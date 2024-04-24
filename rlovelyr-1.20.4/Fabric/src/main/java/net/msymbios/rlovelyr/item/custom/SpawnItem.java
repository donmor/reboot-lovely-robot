package net.msymbios.rlovelyr.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.Spawner;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.msymbios.rlovelyr.config.LovelyRobotID;
import net.msymbios.rlovelyr.entity.enums.EntityTexture;
import net.msymbios.rlovelyr.entity.internal.InternalEntity;
import net.msymbios.rlovelyr.util.Utility;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

import static net.msymbios.rlovelyr.util.Utility.*;

public class SpawnItem extends SpawnEggItem {

    // -- Constructor --
    public SpawnItem(EntityType<? extends MobEntity> type, Settings settings) {
        super(type, 0xFFFFFF, 0xFFFFFF, settings);
    } // Constructor SpawnItem ()

    // -- Inherited Methods --

    /**
     * Appends tooltip information to the given ItemStack in the specified world, using the provided list of Text elements and TooltipContext.
     **/
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            NbtCompound nbt = stack.getOrCreateNbt();
            addNameTooltip(tooltip, nbt);
            addColorTooltip(tooltip, nbt);
            addLevelTooltip(tooltip, nbt);
         } else {
            NbtCompound compound = stack.getOrCreateNbt();
            compound.putInt(LovelyRobotID.STAT_COLOR, EntityTexture.RANDOM.getId());
            compound.putInt(LovelyRobotID.STAT_LEVEL, 0);
            stack.setNbt(compound);
        }
    } // appendTooltip ()

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return TypedActionResult.pass(itemStack);
        } else if (!(world instanceof ServerWorld)) {
            return TypedActionResult.success(itemStack);
        } else {
            BlockHitResult blockHitResult2 = blockHitResult;
            BlockPos blockPos = blockHitResult2.getBlockPos();
            if (!(world.getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
                return TypedActionResult.pass(itemStack);
            } else if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos, blockHitResult2.getSide(), itemStack)) {
                EntityType<?> entityType = this.getEntityType(itemStack.getNbt());
                InternalEntity entity = (InternalEntity)entityType.spawnFromItemStack((ServerWorld)world, itemStack, user, blockPos, SpawnReason.SPAWN_EGG, false, false);
                if (entity == null) {
                    return TypedActionResult.pass(itemStack);
                } else {
                    if (!user.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                    }

                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    world.emitGameEvent(user, GameEvent.ENTITY_PLACE, entity.getPos());
                    entity.handleTame(user);
                    initialize(itemStack.getNbt(), entity);
                    return TypedActionResult.consume(itemStack);
                }
            } else {
                return TypedActionResult.fail(itemStack);
            }
        }
    } // use ()

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!(world instanceof ServerWorld)) {
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemStack = context.getStack();
            BlockPos blockPos = context.getBlockPos();
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);
            BlockEntity var8 = world.getBlockEntity(blockPos);
            EntityType entityType;
            if (var8 instanceof Spawner) {
                Spawner spawner = (Spawner)var8;
                entityType = this.getEntityType(itemStack.getNbt());
                spawner.setEntityType(entityType, world.getRandom());
                world.updateListeners(blockPos, blockState, blockState, 3);
                world.emitGameEvent(context.getPlayer(), GameEvent.BLOCK_CHANGE, blockPos);
                itemStack.decrement(1);
                return ActionResult.CONSUME;
            } else {
                BlockPos blockPos2;
                if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                    blockPos2 = blockPos;
                } else {
                    blockPos2 = blockPos.offset(direction);
                }

                entityType = this.getEntityType(itemStack.getNbt());
                InternalEntity entity = (InternalEntity) entityType.spawnFromItemStack((ServerWorld)world, itemStack, context.getPlayer(), blockPos2, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP);
                if (entity != null) {
                    itemStack.decrement(1);
                    world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);

                    PlayerEntity player = context.getPlayer();
                    entity.handleTame(player);
                    initialize(itemStack.getNbt(), entity);
                }

                return ActionResult.CONSUME;
            }
        }
    } // useOnBlock ()

    // -- Custom Methods --

    private void initialize (NbtCompound dataNBT, InternalEntity entity) {
        if(!dataNBT.getString(LovelyRobotID.STAT_CUSTOM_NAME).isEmpty()) entity.setCustomName(Text.literal(dataNBT.getString(LovelyRobotID.STAT_CUSTOM_NAME)));
        if(dataNBT.getInt(LovelyRobotID.STAT_COLOR) != EntityTexture.RANDOM.getId()) entity.setTexture(dataNBT.getInt(LovelyRobotID.STAT_COLOR));

        if(dataNBT.getInt(LovelyRobotID.STAT_MAX_LEVEL) > 0) entity.setMaxLevel(dataNBT.getInt(LovelyRobotID.STAT_MAX_LEVEL));
        if(dataNBT.getInt(LovelyRobotID.STAT_LEVEL) > 0) entity.setCurrentLevel(dataNBT.getInt(LovelyRobotID.STAT_LEVEL));
        if(dataNBT.getInt(LovelyRobotID.STAT_EXP) > 0) entity.setExp(dataNBT.getInt(LovelyRobotID.STAT_EXP));

        if(dataNBT.getInt(LovelyRobotID.STAT_FIRE_PROTECTION) > 0) entity.setFireProtection(dataNBT.getInt(LovelyRobotID.STAT_FIRE_PROTECTION));
        if(dataNBT.getInt(LovelyRobotID.STAT_FALL_PROTECTION) > 0) entity.setFallProtection(dataNBT.getInt(LovelyRobotID.STAT_FALL_PROTECTION));
        if(dataNBT.getInt(LovelyRobotID.STAT_BLAST_PROTECTION) > 0) entity.setBlastProtection(dataNBT.getInt(LovelyRobotID.STAT_BLAST_PROTECTION));
        if(dataNBT.getInt(LovelyRobotID.STAT_PROJECTILE_PROTECTION) > 0) entity.setProjectileProtection(dataNBT.getInt(LovelyRobotID.STAT_PROJECTILE_PROTECTION));
    } // initialize ()

} // Class SpawnItem