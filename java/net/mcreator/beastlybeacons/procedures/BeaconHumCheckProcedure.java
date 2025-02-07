package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;

public class BeaconHumCheckProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		count = 0;
		if (Effect1CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect2CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect3CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect4CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect5CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect6CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect7CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect8CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect9CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect10CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect11CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect12CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect13CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect14CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		if (Effect15CheckProcedure.execute(world, x, y, z) == true) {
			count = count + 1;
		}
		return count;
	}
}
