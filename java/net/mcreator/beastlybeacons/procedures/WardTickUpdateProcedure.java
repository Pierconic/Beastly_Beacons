package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;
import net.mcreator.beastlybeacons.entity.FriendlyWardEntity;
import net.mcreator.beastlybeacons.entity.EvilWardEntity;

import java.util.Comparator;

public class WardTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double y_distance = 0;
		double magnitude = 0;
		double z_distance = 0;
		double x_distance = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 12, 0.2, 0.2, 0.2, 0.2);
		}
		if (entity instanceof FriendlyWardEntity) {
			if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).isEmpty() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity)) {
				if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			} else if (Math.random() < 0.001) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if (entity instanceof EvilWardEntity) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).isEmpty() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity)) {
				if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(BeastlyBeaconsModMobEffects.MALEVOLENCE)) {
					if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			} else if (Math.random() < 0.001) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			x_distance = entity.getX() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX();
			y_distance = entity.getY() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY();
			z_distance = entity.getZ() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ();
			magnitude = Math.sqrt(Math.pow(x_distance, 2) + Math.pow(y_distance, 2) + Math.pow(z_distance, 2));
			if (magnitude < 10) {
				entity.setDeltaMovement(new Vec3(((x_distance / magnitude) * 0.25), ((y_distance / magnitude) * 0.25), ((z_distance / magnitude) * 0.25)));
			}
		}
	}
}
