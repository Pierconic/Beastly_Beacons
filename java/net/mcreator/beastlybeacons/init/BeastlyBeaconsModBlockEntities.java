
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.beastlybeacons.block.entity.MalevolentBeaconBlockEntity;
import net.mcreator.beastlybeacons.block.entity.DeactivatedBeaconBlockEntity;
import net.mcreator.beastlybeacons.block.entity.BenevolentBeaconBlockEntity;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BeastlyBeaconsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BeastlyBeaconsMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BENEVOLENT_BEACON = register("benevolent_beacon", BeastlyBeaconsModBlocks.BENEVOLENT_BEACON, BenevolentBeaconBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DEACTIVATED_BEACON = register("deactivated_beacon", BeastlyBeaconsModBlocks.DEACTIVATED_BEACON, DeactivatedBeaconBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MALEVOLENT_BEACON = register("malevolent_beacon", BeastlyBeaconsModBlocks.MALEVOLENT_BEACON, MalevolentBeaconBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BENEVOLENT_BEACON.get(), (blockEntity, side) -> ((BenevolentBeaconBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, BENEVOLENT_BEACON.get(), (blockEntity, side) -> ((BenevolentBeaconBlockEntity) blockEntity).getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DEACTIVATED_BEACON.get(), (blockEntity, side) -> ((DeactivatedBeaconBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MALEVOLENT_BEACON.get(), (blockEntity, side) -> ((MalevolentBeaconBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, MALEVOLENT_BEACON.get(), (blockEntity, side) -> ((MalevolentBeaconBlockEntity) blockEntity).getEnergyStorage());
	}
}
