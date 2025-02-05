package net.msymbios.rlovelyr.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.msymbios.rlovelyr.entity.enums.EntityTexture;
import net.msymbios.rlovelyr.entity.internal.InternalEntity;
import net.msymbios.rlovelyr.entity.internal.Utility;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SpawnItem extends ForgeSpawnEggItem {

    // -- Constructor --
    public SpawnItem(Supplier<? extends EntityType<? extends Mob>> type, Properties props) {
        super(type, 0xFFFFFF, 0xFFFFFF, props);
    } // Constructor SpawnItem ()

    // -- Build-In Methods --
    @Override
    public void appendHoverText(ItemStack stack, @org.jetbrains.annotations.Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);
        if(!stack.hasTag()) {
            CompoundTag compound = new CompoundTag();
            compound.putInt("color", 16);
            compound.putInt("level", 0);
            stack.setTag(compound);
        }

        if(stack.hasTag()) {
            if(!stack.getTag().getString("custom_name").isEmpty())  tooltip.add(Component.translatable("msg.item.name").append(": " + stack.getTag().getString("custom_name")));
            tooltip.add(Component.translatable("msg.item.color").append(": ").append(Component.translatable(Utility.getTranslatable(EntityTexture.byId(stack.getTag().getInt("color"))))));
            if(stack.getTag().getInt("level") > 0) tooltip.add(Component.translatable("msg.item.level").append(": " + stack.getTag().getInt("level")));
        }
    } // appendHoverText ()

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, user, ClipContext.Fluid.SOURCE_ONLY);
        if (blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(stack);
        } else if (!(level instanceof ServerLevel)) {
            return InteractionResultHolder.success(stack);
        } else {
            BlockPos blockpos = blockhitresult.getBlockPos();
            if (!(level.getBlockState(blockpos).getBlock() instanceof LiquidBlock)) {
                return InteractionResultHolder.pass(stack);
            } else if (level.mayInteract(user, blockpos) && user.mayUseItemAt(blockpos, blockhitresult.getDirection(), stack)) {
                EntityType<?> entitytype = this.getType(stack.getTag());
                InternalEntity  entity = (InternalEntity) entitytype.spawn((ServerLevel)level, stack, user, blockpos, MobSpawnType.SPAWN_EGG, false, false);
                if (entity == null) {
                    return InteractionResultHolder.pass(stack);
                } else {
                    if (!user.getAbilities().instabuild) {
                        stack.shrink(1);
                    }

                    user.awardStat(Stats.ITEM_USED.get(this));
                    level.gameEvent(user, GameEvent.ENTITY_PLACE, entity.position());
                    entity.handleTame(user);
                    initialize(stack.getTag(), entity);
                    return InteractionResultHolder.consume(stack);
                }
            } else {
                return InteractionResultHolder.fail(stack);
            }
        }
    } // use ()

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack stack = context.getItemInHand();
            BlockPos blockpos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(Blocks.SPAWNER)) {
                BlockEntity blockentity = level.getBlockEntity(blockpos);
                if (blockentity instanceof SpawnerBlockEntity) {
                    SpawnerBlockEntity spawnerblockentity = (SpawnerBlockEntity)blockentity;
                    EntityType<?> entitytype1 = this.getType(stack.getTag());
                    spawnerblockentity.setEntityId(entitytype1, level.getRandom());
                    blockentity.setChanged();
                    level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                    level.gameEvent(context.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
                    stack.shrink(1);
                    return InteractionResult.CONSUME;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }

            EntityType<?> entitytype = this.getType(stack.getTag());
            InternalEntity entity = (InternalEntity) entitytype.spawn((ServerLevel)level, stack, context.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP);
            if (entity != null) {
                stack.shrink(1);
                level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
                Player player = context.getPlayer();
                entity.handleTame(player);
                initialize(stack.getTag(), entity);
            }

            return InteractionResult.CONSUME;
        }
    } // useOn ()

    // -- Methods --
    private void initialize (CompoundTag dataNBT, InternalEntity entity) {
        if(!dataNBT.getString("custom_name").isEmpty()) entity.setCustomName(Component.nullToEmpty(dataNBT.getString("custom_name")));
        if(dataNBT.getInt("color") != 16) entity.setTexture(dataNBT.getInt("color"));

        if(dataNBT.getInt("max_level") > 0) entity.setMaxLevel(dataNBT.getInt("max_level"));
        if(dataNBT.getInt("level") > 0) entity.setCurrentLevel(dataNBT.getInt("level"));
        if(dataNBT.getInt("exp") > 0) entity.setExp(dataNBT.getInt("exp"));

        if(dataNBT.getInt("fire_protection") > 0) entity.setFireProtection(dataNBT.getInt("fire_protection"));
        if(dataNBT.getInt("fall_protection") > 0) entity.setFallProtection(dataNBT.getInt("fall_protection"));
        if(dataNBT.getInt("blast_protection") > 0) entity.setBlastProtection(dataNBT.getInt("blast_protection"));
        if(dataNBT.getInt("projectile_protection") > 0) entity.setProjectileProtection(dataNBT.getInt("projectile_protection"));
    } // initialize ()

} // Class SpawnItem