
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.beastlybeacons.item.WarningSigilItem;
import net.mcreator.beastlybeacons.item.FriendlyWardBeamItem;
import net.mcreator.beastlybeacons.item.EvilWardBeamItem;
import net.mcreator.beastlybeacons.item.DeactivatedSigilItem;
import net.mcreator.beastlybeacons.item.ActiveSigilItem;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

public class BeastlyBeaconsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BeastlyBeaconsMod.MODID);
	public static final DeferredItem<Item> BENEVOLENT_BEACON = block(BeastlyBeaconsModBlocks.BENEVOLENT_BEACON);
	public static final DeferredItem<Item> ACTIVATED_COPPER = block(BeastlyBeaconsModBlocks.ACTIVATED_COPPER);
	public static final DeferredItem<Item> ACTIVATED_IRON = block(BeastlyBeaconsModBlocks.ACTIVATED_IRON);
	public static final DeferredItem<Item> ACTIVATED_GOLD = block(BeastlyBeaconsModBlocks.ACTIVATED_GOLD);
	public static final DeferredItem<Item> ACTIVATED_EMERALD = block(BeastlyBeaconsModBlocks.ACTIVATED_EMERALD);
	public static final DeferredItem<Item> ACTIVATED_DIAMOND = block(BeastlyBeaconsModBlocks.ACTIVATED_DIAMOND);
	public static final DeferredItem<Item> ACTIVATED_LAPIS = block(BeastlyBeaconsModBlocks.ACTIVATED_LAPIS);
	public static final DeferredItem<Item> ACTIVATED_NETHERITE = block(BeastlyBeaconsModBlocks.ACTIVATED_NETHERITE);
	public static final DeferredItem<Item> DEACTIVATED_BEACON = block(BeastlyBeaconsModBlocks.DEACTIVATED_BEACON);
	public static final DeferredItem<Item> DEACTIVATED_SIGIL = REGISTRY.register("deactivated_sigil", DeactivatedSigilItem::new);
	public static final DeferredItem<Item> ACTIVE_SIGIL = REGISTRY.register("active_sigil", ActiveSigilItem::new);
	public static final DeferredItem<Item> WARNING_SIGIL = REGISTRY.register("warning_sigil", WarningSigilItem::new);
	public static final DeferredItem<Item> MALEVOLENT_BEACON = block(BeastlyBeaconsModBlocks.MALEVOLENT_BEACON);
	public static final DeferredItem<Item> SINISTER_COPPER = block(BeastlyBeaconsModBlocks.SINISTER_COPPER);
	public static final DeferredItem<Item> SINISTER_IRON = block(BeastlyBeaconsModBlocks.SINISTER_IRON);
	public static final DeferredItem<Item> SINISTER_GOLD = block(BeastlyBeaconsModBlocks.SINISTER_GOLD);
	public static final DeferredItem<Item> SINISTER_EMERALD = block(BeastlyBeaconsModBlocks.SINISTER_EMERALD);
	public static final DeferredItem<Item> SINISTER_DIAMOND = block(BeastlyBeaconsModBlocks.SINISTER_DIAMOND);
	public static final DeferredItem<Item> SINISTER_LAPIS = block(BeastlyBeaconsModBlocks.SINISTER_LAPIS);
	public static final DeferredItem<Item> SINISTER_NETHERITE = block(BeastlyBeaconsModBlocks.SINISTER_NETHERITE);
	public static final DeferredItem<Item> FRIENDLY_WARD_BEAM = REGISTRY.register("friendly_ward_beam", FriendlyWardBeamItem::new);
	public static final DeferredItem<Item> EVIL_WARD_BEAM = REGISTRY.register("evil_ward_beam", EvilWardBeamItem::new);
	public static final DeferredItem<Item> BEACON_AURA = block(BeastlyBeaconsModBlocks.BEACON_AURA);
	public static final DeferredItem<Item> FRIENDLY_WARD_SPAWN_EGG = REGISTRY.register("friendly_ward_spawn_egg", () -> new DeferredSpawnEggItem(BeastlyBeaconsModEntities.FRIENDLY_WARD, -1, -1, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
