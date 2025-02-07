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
import net.mcreator.beastlybeacons.entity.FriendlyWardEntity;
import net.mcreator.beastlybeacons.entity.EvilWardEntity;

import java.util.List;
import java.util.Comparator;

public class ManifestWardsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double signal) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double radius = 0;
		double WardCount = 0;
		double proximity = 0;
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
			WardCount = 0;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(170 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof EvilWardEntity && !(entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					} else if (entityiterator instanceof FriendlyWardEntity) {
						WardCount = WardCount + 1;
					}
				}
			}
			if (WardCount == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = BeastlyBeaconsModEntities.FRIENDLY_WARD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 3, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
					}
				}
			}
			if (WardCount <= 15) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Monster && !(!world.getEntitiesOfClass(FriendlyWardEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 16, 16, 16), e -> true).isEmpty())
								&& Math.random() < 0.4) {
							for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 2); index0++) {
								sy = Mth.nextInt(RandomSource.create(), 2, 4);
								if (Math.random() < 0.5) {
									sx = Mth.nextInt(RandomSource.create(), 7, 12);
								} else {
									sx = Mth.nextInt(RandomSource.create(), -12, -7);
								}
								if (Math.random() < 0.5) {
									sz = Mth.nextInt(RandomSource.create(), 7, 12);
								} else {
									sz = Mth.nextInt(RandomSource.create(), -12, -7);
								}
								if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
									if (world instanceof ILevelExtension _ext) {
										IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
										if (_entityStorage != null)
											_entityStorage.extractEnergy(2, false);
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
									Entity entityToSpawn = BeastlyBeaconsModEntities.FRIENDLY_WARD.get().spawn(_level, BlockPos.containing(entityiterator.getX() + sx + 0.5, entityiterator.getY() + sy + 0.5, entityiterator.getZ() + sz + 0.5),
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
			WardCount = 0;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(170 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof FriendlyWardEntity && !(entityiterator instanceof LivingEntity _livEnt40 && _livEnt40.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					} else if (entityiterator instanceof EvilWardEntity) {
						WardCount = WardCount + 1;
					}
				}
			}
			if (WardCount == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:sentinel.spawn")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = BeastlyBeaconsModEntities.EVIL_WARD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 3, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
					}
				}
			}
			if (WardCount <= 18) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(BeastlyBeaconsModMobEffects.MALEVOLENCE)
								&& !(!world.getEntitiesOfClass(EvilWardEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 15, 15, 15), e -> true).isEmpty())
								&& (Math.random() < 0.2 || signal == 3)) {
							for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 2); index1++) {
								sy = Mth.nextInt(RandomSource.create(), 2, 4);
								if (Math.random() < 0.5) {
									sx = Mth.nextInt(RandomSource.create(), 8, 14);
								} else {
									sx = Mth.nextInt(RandomSource.create(), -14, -8);
								}
								if (Math.random() < 0.5) {
									sz = Mth.nextInt(RandomSource.create(), 8, 14);
								} else {
									sz = Mth.nextInt(RandomSource.create(), -14, -8);
								}
								if (!world.getBlockState(BlockPos.containing(entityiterator.getX() + sx, entityiterator.getY() + sy, entityiterator.getZ() + sz)).canOcclude()) {
									if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
										if (world instanceof ILevelExtension _ext) {
											IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
											if (_entityStorage != null)
												_entityStorage.extractEnergy(2, false);
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
										Entity entityToSpawn = BeastlyBeaconsModEntities.EVIL_WARD.get().spawn(_level, BlockPos.containing(entityiterator.getX() + sx + 0.5, entityiterator.getY() + sy + 0.5, entityiterator.getZ() + sz + 0.5),
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
