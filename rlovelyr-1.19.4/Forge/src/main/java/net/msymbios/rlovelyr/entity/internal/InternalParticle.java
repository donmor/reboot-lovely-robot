package net.msymbios.rlovelyr.entity.internal;


import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;

public class InternalParticle {

    // -- Variables --
    private static final double VelocityMultiplier = 0.02D;
    private static final int MaximumNumberParticles = 7;

    private static final Random random = new Random();

    // -- Methods --

    // PARTICLES
    public static void Ash(LivingEntity entity) {
        for (int i = 0; i < MaximumNumberParticles; ++i) {
            double d0 = CalculateVelocity();
            double d1 = CalculateVelocity();
            double d2 = CalculateVelocity();
            entity.level.addParticle(ParticleTypes.ASH, entity.getX(1.0D), entity.getRandomY() + 0.5D, entity.getZ(1.0D), d0, d1, d2);
        }
    } // Ash ()

    public static void Heart(LivingEntity entity) {
        for (int i = 0; i < MaximumNumberParticles; ++i) {
            double d0 = CalculateVelocity();
            double d1 = CalculateVelocity();
            double d2 = CalculateVelocity();
            entity.level.addParticle(ParticleTypes.HEART, entity.getX(1.0D), entity.getRandomY() + 0.5D, entity.getZ(1.0D), d0, d1, d2);
        }
        entity.getLevel().broadcastEntityEvent(entity, (byte) 7);
    } // Heart ()

    public static void LevelUp(LivingEntity entity) {
        for (int i = 0; i < MaximumNumberParticles; ++i) {
            double d0 = CalculateVelocity();
            double d1 = CalculateVelocity();
            double d2 = CalculateVelocity();
            entity.level.addParticle(ParticleTypes.HAPPY_VILLAGER, entity.getX(1.0D), entity.getRandomY() + 0.5D, entity.getZ(1.0D), d0, d1, d2);
        }
        entity.getLevel().broadcastEntityEvent(entity, (byte) 14);
    } // LevelUp ()

    // UTILITY
    private static double CalculateVelocity() {
        return random.nextGaussian() * VelocityMultiplier;
    } // CalculateVelocity ()

    private static double CalculateVelocity(double multiplier) {
        return random.nextGaussian() * multiplier;
    } // CalculateVelocity ()

} // Class InternalParticle