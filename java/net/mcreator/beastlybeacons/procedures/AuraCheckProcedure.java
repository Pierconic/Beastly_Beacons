package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

public class AuraCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == BeastlyBeaconsModBlocks.MALEVOLENT_BEACON.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == BeastlyBeaconsModBlocks.BENEVOLENT_BEACON.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == BeastlyBeaconsModBlocks.BEACON_AURA.get())) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp7 && (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp7)) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.WATER.defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
