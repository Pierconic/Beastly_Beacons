package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ReverseBottomLayerCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		boolean proximity = false;
		sx = -3;
		found = true;
		for (int index0 = 0; index0 < 7; index0++) {
			sz = -3;
			for (int index1 = 0; index1 < 7; index1++) {
				if (!(world.getBlockState(BlockPos.containing(x + sx, y - 3, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:beacon_base_materials")))) {
					found = false;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			return false;
		}
		return true;
	}
}
