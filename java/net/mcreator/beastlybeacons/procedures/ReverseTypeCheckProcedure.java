package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.beastlybeacons.entity.EvilBeaconBeamEntity;

public class ReverseTypeCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(EvilBeaconBeamEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()) {
			return false;
		}
		return true;
	}
}
