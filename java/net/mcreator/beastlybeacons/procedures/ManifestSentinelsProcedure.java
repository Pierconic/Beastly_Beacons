package net.mcreator.beastlybeacons.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModGameRules;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModEntities;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;
import net.mcreator.beastlybeacons.entity.FriendlySpriteEntity;
import net.mcreator.beastlybeacons.entity.EvilSpriteEntity;

import java.util.List;
import java.util.Comparator;

public class ManifestSentinelsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double SentinelCount = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double radius = 0;
		if (Effect10CheckProcedure.execute(world, x, y, z) == true && Effect15CheckProcedure.execute(world, x, y, z) == true) {
			radius = 152;
		} else if (Effect15CheckProcedure.execute(world, x, y, z) == true) {
			radius = 128;
		} else if (Effect10CheckProcedure.execute(world, x, y, z) == true) {
			radius = 96;
		} else {
			radius = 72;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.BENEVOLENT_BEACON.get()) {
			SentinelCount = 0;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(160 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof EvilSpriteEntity && !(entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					} else if (entityiterator instanceof FriendlySpriteEntity) {
						SentinelCount = SentinelCount + 1;
					}
				}
			}
			if (SentinelCount <= 25) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Monster
								&& !(!world.getEntitiesOfClass(FriendlySpriteEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 12, 12, 12), e -> true).isEmpty()) && Math.random() < 0.6) {
							for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
								sy = Mth.nextInt(RandomSource.create(), 2, 4);
								if (Math.random() < 0.5) {
									sx = Mth.nextInt(RandomSource.create(), 3, 6);
								} else {
									sx = Mth.nextInt(RandomSource.create(), -6, -3);
								}
								if (Math.random() < 0.5) {
									sz = Mth.nextInt(RandomSource.create(), 3, 6);
								} else {
									sz = Mth.nextInt(RandomSource.create(), -6, -3);
								}
								if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
									if (world instanceof ILevelExtension _ext) {
										IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
										if (_entityStorage != null)
											_entityStorage.extractEnergy(1, false);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX() + sx, entityiterator.getY() + sy, entityiterator.getZ() + sz),
												BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX() + sx), (entityiterator.getY() + sy), (entityiterator.getZ() + sz), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")),
												SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = BeastlyBeaconsModEntities.FRIENDLY_SPRITE.get().spawn(_level, BlockPos.containing(entityiterator.getX() + sx + 0.5, entityiterator.getY() + sy + 0.5, entityiterator.getZ() + sz + 0.5),
											MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
									}
								}
							}
						}
					}
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.MALEVOLENT_BEACON.get()) {
			SentinelCount = 0;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(160 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof FriendlySpriteEntity && !(entityiterator instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					} else if (entityiterator instanceof EvilSpriteEntity) {
						SentinelCount = SentinelCount + 1;
					}
				}
			}
			if (SentinelCount <= 40) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity _livEnt39 && _livEnt39.hasEffect(BeastlyBeaconsModMobEffects.MALEVOLENCE) && Math.random() < 0.8) {
							for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 2); index1++) {
								sy = Mth.nextInt(RandomSource.create(), 2, 4);
								if (Math.random() < 0.5) {
									sx = Mth.nextInt(RandomSource.create(), 5, 8);
								} else {
									sx = Mth.nextInt(RandomSource.create(), -8, -5);
								}
								if (Math.random() < 0.5) {
									sz = Mth.nextInt(RandomSource.create(), 5, 8);
								} else {
									sz = Mth.nextInt(RandomSource.create(), -8, -5);
								}
								if (!world.getBlockState(BlockPos.containing(entityiterator.getX() + sx, entityiterator.getY() + sy, entityiterator.getZ() + sz)).canOcclude()) {
									if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
										if (world instanceof ILevelExtension _ext) {
											IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
											if (_entityStorage != null)
												_entityStorage.extractEnergy(1, false);
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entityiterator.getX() + sx, entityiterator.getY() + sy, entityiterator.getZ() + sz),
													BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound((entityiterator.getX() + sx), (entityiterator.getY() + sy), (entityiterator.getZ() + sz), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")),
													SoundSource.HOSTILE, 1, 1, false);
										}
									}
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = BeastlyBeaconsModEntities.EVIL_SPRITE.get().spawn(_level, BlockPos.containing(entityiterator.getX() + sx + 0.5, entityiterator.getY() + sy + 0.5, entityiterator.getZ() + sz + 0.5),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
