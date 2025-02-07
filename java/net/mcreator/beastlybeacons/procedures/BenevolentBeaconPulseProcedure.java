package net.mcreator.beastlybeacons.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModGameRules;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModEntities;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;
import net.mcreator.beastlybeacons.entity.FriendlyWardEntity;
import net.mcreator.beastlybeacons.entity.FriendlySpriteEntity;
import net.mcreator.beastlybeacons.entity.BeaconBeamTestEntity;

import java.util.List;
import java.util.Comparator;

public class BenevolentBeaconPulseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double radius = 0;
		if (!world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					if (level instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
						if (_entityStorage != null)
							return _entityStorage.getEnergyStored();
					}
					return 0;
				}
			}.getEnergyStored(world, BlockPos.containing(x, y, z)) < 1) {
				if (world instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
					if (_entityStorage != null)
						_entityStorage.receiveEnergy(1, false);
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("signal_loop", (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "signal_loop") + 2));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("hum_loop", (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "hum_loop") + 2));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (TopLayerCheckProcedure.execute(world, x, y, z) == true) {
			if (Effect10CheckProcedure.execute(world, x, y, z) == true && Effect15CheckProcedure.execute(world, x, y, z) == true) {
				radius = 168;
			} else if (Effect15CheckProcedure.execute(world, x, y, z) == true) {
				radius = 136;
			} else if (Effect10CheckProcedure.execute(world, x, y, z) == true) {
				radius = 104;
			} else {
				radius = 72;
			}
			ShieldSummoningProcedure.execute(world, x, y, z);
			if (SkyAccessCheckProcedure.execute(world, x, y, z) == true) {
				if (!(!world.getEntitiesOfClass(BeaconBeamTestEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty())) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = BeastlyBeaconsModEntities.BEACON_BEAM_TEST.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					AuraPlacementProcedure.execute(world, x, y + 1, z);
				}
			} else {
				if (!world.getEntitiesOfClass(BeaconBeamTestEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
					if (!((Entity) world.getEntitiesOfClass(BeaconBeamTestEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
						((Entity) world.getEntitiesOfClass(BeaconBeamTestEntity.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
				}
			}
			if (BottomLayerCheckProcedure.execute(world, x, y, z) == true && MidLayerCheckProcedure.execute(world, x, y, z) == true) {
				BottomLayerIgnitionProcedure.execute(world, x, y, z);
				MidLayerIgnitionProcedure.execute(world, x, y, z);
				TopLayerIgnitionProcedure.execute(world, x, y, z);
			} else if (MidLayerCheckProcedure.execute(world, x, y, z) == true) {
				BottomLayerDeactivationProcedure.execute(world, x, y, z);
				MidLayerIgnitionProcedure.execute(world, x, y, z);
				TopLayerIgnitionProcedure.execute(world, x, y, z);
			} else {
				BottomLayerDeactivationProcedure.execute(world, x, y, z);
				MidLayerDeactivationProcedure.execute(world, x, y, z);
				TopLayerIgnitionProcedure.execute(world, x, y, z);
			}
		} else {
			BottomLayerDeactivationProcedure.execute(world, x, y, z);
			MidLayerDeactivationProcedure.execute(world, x, y, z);
			TopLayerDeactivationProcedure.execute(world, x, y, z);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/fill ~ ~1 ~ ~ ~319 ~ air replace beastly_beacons:beacon_aura");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:beacon.deactivate")), SoundSource.NEUTRAL, 6, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:beacon.deactivate")), SoundSource.NEUTRAL, 6, 1, false);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), BeastlyBeaconsModBlocks.DEACTIVATED_BEACON.get().defaultBlockState(), 3);
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "signal_loop") >= 174 && (!world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP) || new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				if (level instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
					if (_entityStorage != null)
						return _entityStorage.getEnergyStored();
				}
				return 0;
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) > 0)) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && !(entityiterator instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
						if (!(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
								}
								return false;
							}
						}.checkGamemode(entityiterator))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 280, 0, true, false));
						}
					} else if (entityiterator instanceof Player) {
						if (!(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
								}
								return false;
							}
						}.checkGamemode(entityiterator))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 260, 0, true, false));
						}
					}
					if (Effect7CheckProcedure.execute(world, x, y, z) == true && entityiterator instanceof FriendlySpriteEntity) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 280, 1, false, false));
					}
					if (Effect12CheckProcedure.execute(world, x, y, z) == true && entityiterator instanceof FriendlyWardEntity && !entityiterator.isInWall()) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(BeastlyBeaconsModMobEffects.BENEVOLENCE, 280, 1, false, false));
					}
					if (entityiterator instanceof Player && entityiterator instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entityiterator))) {
						if (Effect1CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 280, 0, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(1, false);
								}
							}
						}
						if (Effect2CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 280, 0, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(1, false);
								}
							}
						}
						if (Effect3CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 280, 0, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(1, false);
								}
							}
						}
						if (Effect4CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 280, 0, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(1, false);
								}
							}
						}
						if (Effect6CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 280, 1, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(2, false);
								}
							}
						}
						if (Effect9CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 280, 0, true, false));
							if (Effect1CheckProcedure.execute(world, x, y, z) == true) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 280, 2, true, false));
							} else {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 280, 1, true, false));
							}
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(2, false);
								}
							}
						}
						if (Effect11CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 280, 0, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(2, false);
								}
							}
						}
						if (Effect14CheckProcedure.execute(world, x, y, z) == true) {
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(3, false);
								}
							}
							if (Effect4CheckProcedure.execute(world, x, y, z) == true) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 280, 2, true, false));
							} else {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 280, 1, true, false));
							}
						}
					} else if (entityiterator instanceof Monster) {
						if (Effect5CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 280, 0, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(1, false);
								}
							}
						}
						if (Effect8CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 280, 0, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(2, false);
								}
							}
						}
						if (Effect13CheckProcedure.execute(world, x, y, z) == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 280, 1, true, false));
							if (world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
								if (world instanceof ILevelExtension _ext) {
									IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
									if (_entityStorage != null)
										_entityStorage.extractEnergy(3, false);
								}
							}
						}
					}
				}
			}
			if (Effect7CheckProcedure.execute(world, x, y, z) == true) {
				ManifestSentinelsProcedure.execute(world, x, y, z);
			}
			if (Effect12CheckProcedure.execute(world, x, y, z) == true) {
				ManifestWardsProcedure.execute(world, x, y, z, 0);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("signal_loop", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "hum_loop") >= 174) {
			if (BeaconHumCheckProcedure.execute(world, x, y, z) > 10) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:friendly.pulse.tier.3")), SoundSource.NEUTRAL, 3, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:friendly.pulse.tier.3")), SoundSource.NEUTRAL, 3, 1, false);
					}
				}
			} else if (BeaconHumCheckProcedure.execute(world, x, y, z) > 5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:evil.pulse.tier2")), SoundSource.NEUTRAL, 3, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:evil.pulse.tier2")), SoundSource.NEUTRAL, 3, 1, false);
					}
				}
			} else if (BeaconHumCheckProcedure.execute(world, x, y, z) > 2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:friendly.pulse.tier1")), SoundSource.NEUTRAL, 3, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:friendly.pulse.tier1")), SoundSource.NEUTRAL, 3, 1, false);
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:friendly.hum")), SoundSource.NEUTRAL, 3, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:friendly.hum")), SoundSource.NEUTRAL, 3, 1, false);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("hum_loop", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 18, 18, 18), e -> true).isEmpty())) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("hum_loop", 154);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
