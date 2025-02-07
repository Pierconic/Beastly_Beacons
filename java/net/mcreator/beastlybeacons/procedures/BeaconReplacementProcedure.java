package net.mcreator.beastlybeacons.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModGameRules;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BeaconReplacementProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate.getBlock() == Blocks.BEACON) {
			world.setBlock(BlockPos.containing(x, y, z), BeastlyBeaconsModBlocks.DEACTIVATED_BEACON.get().defaultBlockState(), 3);
			if (!world.getLevelData().getGameRules().getBoolean(BeastlyBeaconsModGameRules.REQUIRE_BEACON_EXP)) {
				if (world instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
					if (_entityStorage != null)
						_entityStorage.receiveEnergy(1, false);
				}
			}
		}
	}
}
