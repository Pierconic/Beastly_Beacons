package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModEntities;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;
import net.mcreator.beastlybeacons.entity.EvilBeaconBeamEntity;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

import java.util.Comparator;

public class BeaconUnlockedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String SigilName = "";
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.MALEVOLENT_BEACON.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:beacon.deactivate")), SoundSource.NEUTRAL, 1, (float) 1.5);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:beacon.deactivate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/fill ~ ~1 ~ ~ ~319 ~ air replace beastly_beacons:evil_aura");
			BeastlyBeaconsMod.queueServerWork(3, () -> {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = BeastlyBeaconsModBlocks.BENEVOLENT_BEACON.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata(world.registryAccess());
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.loadWithComponents(_bnbt, world.registryAccess());
							} catch (Exception ignored) {
							}
						}
					}
				}
			});
			TopLayerUnlockProcedure.execute(world, x, y, z);
			MiddleLayerUnlockProcedure.execute(world, x, y, z);
			BottomLayerUnlockProcedure.execute(world, x, y, z);
			if (!world.getEntitiesOfClass(EvilBeaconBeamEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()) {
				if (!((Entity) world.getEntitiesOfClass(EvilBeaconBeamEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
					((Entity) world.getEntitiesOfClass(EvilBeaconBeamEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = BeastlyBeaconsModEntities.BEACON_BEAM_TEST.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
