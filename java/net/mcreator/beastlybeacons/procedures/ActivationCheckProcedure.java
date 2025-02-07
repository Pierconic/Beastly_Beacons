package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModEntities;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

public class ActivationCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		boolean proximity = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -1;
		found = true;
		for (int index0 = 0; index0 < 3; index0++) {
			sz = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				if (!(world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:beacon_base_materials")))) {
					found = false;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		sx = -12;
		proximity = false;
		for (int index2 = 0; index2 < 24; index2++) {
			sy = -12;
			for (int index3 = 0; index3 < 24; index3++) {
				sz = -12;
				for (int index4 = 0; index4 < 24; index4++) {
					if (((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == BeastlyBeaconsModBlocks.BENEVOLENT_BEACON.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == BeastlyBeaconsModBlocks.BENEVOLENT_BEACON.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == BeastlyBeaconsModBlocks.DEACTIVATED_BEACON.get()) && !(x + sx == x && y + sy == y && z + sz == z)) {
						proximity = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true && proximity == false && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.DEACTIVATED_BEACON.get()) {
			TopLayerIgnitionProcedure.execute(world, x, y, z);
			if (MidLayerCheckProcedure.execute(world, x, y, z) == true) {
				MidLayerIgnitionProcedure.execute(world, x, y, z);
			}
			if (BottomLayerCheckProcedure.execute(world, x, y, z) == true) {
				BottomLayerIgnitionProcedure.execute(world, x, y, z);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:beacon.activate")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("beastly_beacons:beacon.activate")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
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
			if (SkyAccessCheckProcedure.execute(world, x, y, z) == true) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = BeastlyBeaconsModEntities.BEACON_BEAM_TEST.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				AuraPlacementProcedure.execute(world, x, y + 1, z);
			}
		}
	}
}
