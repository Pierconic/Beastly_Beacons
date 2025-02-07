package net.mcreator.beastlybeacons.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModGameRules;

public class EnergyNode5DisplayProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				if (level instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
					if (_entityStorage != null)
						return _entityStorage.getEnergyStored();
				}
				return 0;
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 2500 || !world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
			return true;
		}
		return false;
	}
}
