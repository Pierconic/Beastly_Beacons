package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

public class BottomLayerDeactivationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		boolean proximity = false;
		sx = -3;
		for (int index0 = 0; index0 < 7; index0++) {
			sz = -3;
			for (int index1 = 0; index1 < 7; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_COPPER.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_COPPER.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 3, z + sz), Blocks.COPPER_BLOCK.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_IRON.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_IRON.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 3, z + sz), Blocks.IRON_BLOCK.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_GOLD.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_GOLD.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 3, z + sz), Blocks.GOLD_BLOCK.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_EMERALD.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_EMERALD.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 3, z + sz), Blocks.EMERALD_BLOCK.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_DIAMOND.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_DIAMOND.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 3, z + sz), Blocks.DIAMOND_BLOCK.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_LAPIS.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_LAPIS.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 3, z + sz), Blocks.LAPIS_BLOCK.defaultBlockState(), 3);
				} else if ((world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.ACTIVATED_NETHERITE.get()
						|| (world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).getBlock() == BeastlyBeaconsModBlocks.SINISTER_NETHERITE.get()) {
					world.setBlock(BlockPos.containing(x + sx, y - 3, z + sz), Blocks.NETHERITE_BLOCK.defaultBlockState(), 3);
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
	}
}
