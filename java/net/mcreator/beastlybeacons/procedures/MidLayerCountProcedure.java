package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

public class MidLayerCountProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double count = 0;
		count = 0;
		sx = -2;
		for (int index0 = 0; index0 < 5; index0++) {
			sz = -2;
			for (int index1 = 0; index1 < 5; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_COPPER.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_COPPER.get()) {
					count = count + 1;
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_IRON.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_IRON.get()) {
					count = count + 2;
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_GOLD.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_GOLD.get()) {
					count = count + 3;
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_EMERALD.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_EMERALD.get()) {
					count = count + 3;
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_DIAMOND.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_DIAMOND.get()) {
					count = count + 9;
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_LAPIS.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_LAPIS.get()) {
					count = count + 5;
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_NETHERITE.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_NETHERITE.get()) {
					count = count + 12;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		return count;
	}
}
