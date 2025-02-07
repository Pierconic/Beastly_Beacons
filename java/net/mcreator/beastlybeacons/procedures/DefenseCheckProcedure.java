package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DefenseCheckProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sz = 0;
		double defense = 0;
		defense = 0;
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sz = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sz, y - 1, z + sx))).getBlock() == Blocks.CRYING_OBSIDIAN) {
					defense = defense + 1;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		sx = -2;
		for (int index2 = 0; index2 < 5; index2++) {
			sz = -2;
			for (int index3 = 0; index3 < 5; index3++) {
				if ((world.getBlockState(BlockPos.containing(x + sz, y - 2, z + sx))).getBlock() == Blocks.CRYING_OBSIDIAN) {
					defense = defense + 1;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		sx = -3;
		for (int index4 = 0; index4 < 7; index4++) {
			sz = -3;
			for (int index5 = 0; index5 < 7; index5++) {
				if ((world.getBlockState(BlockPos.containing(x + sz, y - 3, z + sx))).getBlock() == Blocks.CRYING_OBSIDIAN) {
					defense = defense + 1;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		return defense;
	}
}
