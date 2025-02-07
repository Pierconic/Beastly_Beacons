package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;
import net.mcreator.beastlybeacons.entity.BeaconBeamTestEntity;

public class BeaconCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BeaconBeamTestEntity) {
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.BENEVOLENT_BEACON.get())) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		} else {
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.MALEVOLENT_BEACON.get())) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
