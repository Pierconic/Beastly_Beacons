package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;

public class EvilEffect1CheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (BeaconTypeCheckProcedure.execute(world, x, y, z) == true && Effect1CheckProcedure.execute(world, x, y, z) == true) {
			return true;
		}
		return false;
	}
}
