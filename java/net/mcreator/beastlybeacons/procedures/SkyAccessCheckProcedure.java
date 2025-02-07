package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SkyAccessCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sy = 0;
		boolean blocked = false;
		blocked = false;
		sy = y + 1;
		while (blocked == false) {
			if (sy >= 319) {
				return true;
			} else if ((world.getBlockState(BlockPos.containing(x, sy, z))).is(BlockTags.create(ResourceLocation.parse("forge:beacon_permeable")))) {
				sy = sy + 1;
			} else {
				blocked = true;
			}
		}
		return false;
	}
}
