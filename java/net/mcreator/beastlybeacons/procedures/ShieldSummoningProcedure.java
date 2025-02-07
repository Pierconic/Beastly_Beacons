package net.mcreator.beastlybeacons.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModGameRules;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModEntities;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;
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

public class ShieldSummoningProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double level = 0;
		boolean found = false;
		if (new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				if (level instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
					if (_entityStorage != null)
						return _entityStorage.getEnergyStored();
				}
				return 0;
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) > 0 || !world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
			level = DefenseCheckProcedure.execute(world, x, y, z);
			if (DefenseCheckProcedure.execute(world, x, y, z) > 0) {
				found = false;
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.BENEVOLENT_BEACON.get()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:evil_shields")))) {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
							} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:friendly_shields")))) {
								if (entityiterator instanceof FriendlyUltimateForcefieldEntity && level >= 32) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								} else if (entityiterator instanceof FriendlyStrongForcefieldEntity && level >= 24) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								} else if (entityiterator instanceof FriendlyMediumForcefieldEntity && level >= 16) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								} else if (entityiterator instanceof FriendlyWeakForcefieldEntity && level >= 10) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								}
							}
						}
					}
					if (found == false) {
						if (level >= 32) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.FRIENDLY_ULTIMATE_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else if (level >= 24) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.FRIENDLY_STRONG_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else if (level >= 16) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.FRIENDLY_MEDIUM_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else if (level >= 10) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.FRIENDLY_WEAK_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.MALEVOLENT_BEACON.get()) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:friendly_shields")))) {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
							} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:evil_shields")))) {
								if (entityiterator instanceof EvilUltimateForcefieldEntity && level >= 32) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								} else if (entityiterator instanceof EvilStrongForcefieldEntity && level >= 24) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								} else if (entityiterator instanceof EvilMediumForcefieldEntity && level >= 16) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								} else if (entityiterator instanceof EvilWeakForcefieldEntity && level >= 10) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 20, 0, false, false));
									found = true;
								}
							}
						}
					}
					if (found == false) {
						if (level >= 32) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.EVIL_ULTIMATE_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else if (level >= 24) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.EVIL_STRONG_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else if (level >= 16) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.EVIL_MEDIUM_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else if (level >= 10) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = BeastlyBeaconsModEntities.EVIL_WEAK_FORCEFIELD.get().spawn(_level, BlockPos.containing(x + 0.5, y + 2, z + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
				}
			}
		}
	}
}
