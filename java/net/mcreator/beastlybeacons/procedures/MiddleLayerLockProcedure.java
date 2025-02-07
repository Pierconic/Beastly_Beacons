package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

public class MiddleLayerLockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		boolean proximity = false;
		sx = -2;
		for (int index0 = 0; index0 < 5; index0++) {
			sz = -2;
			for (int index1 = 0; index1 < 5; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_COPPER.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 2, z + sz), BeastlyBeaconsModBlocks.SINISTER_COPPER.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_IRON.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 2, z + sz), BeastlyBeaconsModBlocks.SINISTER_IRON.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_GOLD.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 2, z + sz), BeastlyBeaconsModBlocks.SINISTER_GOLD.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_EMERALD.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 2, z + sz), BeastlyBeaconsModBlocks.SINISTER_EMERALD.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_DIAMOND.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 2, z + sz), BeastlyBeaconsModBlocks.SINISTER_DIAMOND.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_LAPIS.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 2, z + sz), BeastlyBeaconsModBlocks.SINISTER_LAPIS.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_NETHERITE.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 2, z + sz), BeastlyBeaconsModBlocks.SINISTER_NETHERITE.get().defaultBlockState(), 3);
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
	}
}
