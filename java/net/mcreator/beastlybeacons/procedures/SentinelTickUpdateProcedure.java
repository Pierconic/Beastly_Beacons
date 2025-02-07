package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;

import java.util.List;
import java.util.Comparator;

public class SentinelTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double x_distance = 0;
		double y_distance = 0;
		double z_distance = 0;
		double magnitude = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))
				|| (!(!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()) || !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()))
						&& Math.random() < 0.001) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 15);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 12, 0.2, 0.2, 0.2, 0.2);
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			x_distance = entity.getX() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX();
			y_distance = entity.getY() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY();
			z_distance = entity.getZ() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ();
			magnitude = Math.sqrt(Math.pow(x_distance, 2) + Math.pow(y_distance, 2) + Math.pow(z_distance, 2));
			entity.setDeltaMovement(new Vec3(((x_distance / magnitude) * (-0.3)), ((y_distance / magnitude) * (-0.3)), ((z_distance / magnitude) * (-0.3))));
		}
		found = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (found == false && entityiterator instanceof Monster) {
					if (Math.random() < 0.3) {
						found = true;
						entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0.5), 0.25, (entity.getLookAngle().z * 0.5)));
						if (!entity.level().isClientSide())
							entity.discard();
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 12, 0.2, 0.2, 0.2, 0.2);
						if (entityiterator instanceof Creeper) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 20);
						} else {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 6);
						}
					}
				}
			}
		}
	}
}
