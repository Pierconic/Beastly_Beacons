package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

public class BeaconTypeCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BeastlyBeaconsModBlocks.MALEVOLENT_BEACON.get()) {
			return true;
		}
		return false;
	}
}
