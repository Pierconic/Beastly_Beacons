package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;
import net.mcreator.beastlybeacons.entity.FriendlyWeakForcefieldEntity;
import net.mcreator.beastlybeacons.entity.FriendlyUltimateForcefieldEntity;
import net.mcreator.beastlybeacons.entity.FriendlyStrongForcefieldEntity;
import net.mcreator.beastlybeacons.entity.FriendlyMediumForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilWeakForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilUltimateForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilStrongForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilMediumForcefieldEntity;

import java.util.List;
import java.util.Comparator;

public class ForcefieldTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double forcemultiplier = 0;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		double radius = 0;
		double damage = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 40, 3, 3, 3, 1);
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Arrow && entityiterator.getY() > entity.getY() + 6) {
						entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), 0.3, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1))));
					}
				}
			}
			if (entity instanceof FriendlyUltimateForcefieldEntity || entity instanceof EvilUltimateForcefieldEntity) {
				forcemultiplier = 3.5;
				radius = 24;
				damage = 15;
			} else if (entity instanceof FriendlyStrongForcefieldEntity || entity instanceof EvilStrongForcefieldEntity) {
				forcemultiplier = 2.5;
				radius = 18;
				damage = 10;
			} else if (entity instanceof FriendlyMediumForcefieldEntity || entity instanceof EvilMediumForcefieldEntity) {
				forcemultiplier = 2;
				radius = 12;
				damage = 5;
			} else if (entity instanceof FriendlyWeakForcefieldEntity || entity instanceof EvilWeakForcefieldEntity) {
				forcemultiplier = 1;
				radius = 8;
				damage = 3;
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:beacon_enemies"))) && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:friendly_shields")))
							|| entityiterator instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(BeastlyBeaconsModMobEffects.MALEVOLENCE)
									&& entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:evil_shields")))) {
						if (entityiterator.getX() > x) {
							lx = 0.5;
						} else if (entityiterator.getX() < x) {
							lx = -0.5;
						}
						if (entityiterator.getZ() > z) {
							lz = 0.5;
						} else if (entityiterator.getZ() < z) {
							lz = -0.5;
						}
						ly = 0.3;
						if (entityiterator instanceof LivingEntity _livEnt27 && _livEnt27.isBlocking() || entityiterator.isShiftKeyDown()) {
							lx = lx * (0.3 / forcemultiplier);
							lz = lz * (0.3 / forcemultiplier);
							ly = ly * (0.3 / forcemultiplier);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:ward.attack")),
										SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:ward.attack")), SoundSource.NEUTRAL, 1, 1,
										false);
							}
						}
						if (!(!world.getEntitiesOfClass(LightningBolt.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty())) {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (float) damage);
						entityiterator.setDeltaMovement(new Vec3((lx * forcemultiplier), (ly * forcemultiplier), (lz * forcemultiplier)));
					}
				}
			}
		}
	}
}
