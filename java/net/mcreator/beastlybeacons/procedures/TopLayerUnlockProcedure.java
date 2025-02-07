package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

public class TopLayerUnlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		boolean proximity = false;
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sz = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_COPPER.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 1, z + sz), BeastlyBeaconsModBlocks.ACTIVATED_COPPER.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_IRON.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 1, z + sz), BeastlyBeaconsModBlocks.ACTIVATED_IRON.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_GOLD.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 1, z + sz), BeastlyBeaconsModBlocks.ACTIVATED_GOLD.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_EMERALD.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 1, z + sz), BeastlyBeaconsModBlocks.ACTIVATED_EMERALD.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_DIAMOND.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 1, z + sz), BeastlyBeaconsModBlocks.ACTIVATED_DIAMOND.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_LAPIS.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 1, z + sz), BeastlyBeaconsModBlocks.ACTIVATED_LAPIS.get().defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 1, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_NETHERITE.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 1, z + sz), BeastlyBeaconsModBlocks.ACTIVATED_NETHERITE.get().defaultBlockState(), 3);
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
	}
}
