package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

public class AuraPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double oy = 0;
		oy = y;
		if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			world.setBlock(BlockPos.containing(x, y, z), BeastlyBeaconsModBlocks.BEACON_AURA.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x, oy, z),
					(BeastlyBeaconsModBlocks.BEACON_AURA.get().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _withbp4
							? BeastlyBeaconsModBlocks.BEACON_AURA.get().defaultBlockState().setValue(_withbp4, true)
							: BeastlyBeaconsModBlocks.BEACON_AURA.get().defaultBlockState()),
					3);
		}
		if (y < 319) {
			BeastlyBeaconsMod.queueServerWork(1, () -> {
				AuraPlacementProcedure.execute(world, x, y + 1, z);
			});
		}
	}
}
