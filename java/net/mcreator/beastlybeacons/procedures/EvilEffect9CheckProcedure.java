package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;

public class EvilEffect9CheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (BeaconTypeCheckProcedure.execute(world, x, y, z) == true && Effect9CheckProcedure.execute(world, x, y, z) == true) {
			return true;
		}
		return false;
	}
}
