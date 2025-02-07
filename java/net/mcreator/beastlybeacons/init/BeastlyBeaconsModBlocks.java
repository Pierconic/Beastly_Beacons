
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.beastlybeacons.block.SinisterNetheriteBlock;
import net.mcreator.beastlybeacons.block.SinisterLapisBlock;
import net.mcreator.beastlybeacons.block.SinisterIronBlock;
import net.mcreator.beastlybeacons.block.SinisterGoldBlock;
import net.mcreator.beastlybeacons.block.SinisterEmeraldBlock;
import net.mcreator.beastlybeacons.block.SinisterDiamondBlock;
import net.mcreator.beastlybeacons.block.SinisterCopperBlock;
import net.mcreator.beastlybeacons.block.MalevolentBeaconBlock;
import net.mcreator.beastlybeacons.block.DeactivatedBeaconBlock;
import net.mcreator.beastlybeacons.block.BenevolentBeaconBlock;
import net.mcreator.beastlybeacons.block.BeaconAuraBlock;
import net.mcreator.beastlybeacons.block.ActivatedNetheriteBlock;
import net.mcreator.beastlybeacons.block.ActivatedLapisBlock;
import net.mcreator.beastlybeacons.block.ActivatedIronBlock;
import net.mcreator.beastlybeacons.block.ActivatedGoldBlock;
import net.mcreator.beastlybeacons.block.ActivatedEmeraldBlock;
import net.mcreator.beastlybeacons.block.ActivatedDiamondBlock;
import net.mcreator.beastlybeacons.block.ActivatedCopperBlock;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

public class BeastlyBeaconsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(BeastlyBeaconsMod.MODID);
	public static final DeferredBlock<Block> BENEVOLENT_BEACON = REGISTRY.register("benevolent_beacon", BenevolentBeaconBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_COPPER = REGISTRY.register("activated_copper", ActivatedCopperBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_IRON = REGISTRY.register("activated_iron", ActivatedIronBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_GOLD = REGISTRY.register("activated_gold", ActivatedGoldBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_EMERALD = REGISTRY.register("activated_emerald", ActivatedEmeraldBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_DIAMOND = REGISTRY.register("activated_diamond", ActivatedDiamondBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_LAPIS = REGISTRY.register("activated_lapis", ActivatedLapisBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_NETHERITE = REGISTRY.register("activated_netherite", ActivatedNetheriteBlock::new);
	public static final DeferredBlock<Block> DEACTIVATED_BEACON = REGISTRY.register("deactivated_beacon", DeactivatedBeaconBlock::new);
	public static final DeferredBlock<Block> MALEVOLENT_BEACON = REGISTRY.register("malevolent_beacon", MalevolentBeaconBlock::new);
	public static final DeferredBlock<Block> SINISTER_COPPER = REGISTRY.register("sinister_copper", SinisterCopperBlock::new);
	public static final DeferredBlock<Block> SINISTER_IRON = REGISTRY.register("sinister_iron", SinisterIronBlock::new);
	public static final DeferredBlock<Block> SINISTER_GOLD = REGISTRY.register("sinister_gold", SinisterGoldBlock::new);
	public static final DeferredBlock<Block> SINISTER_EMERALD = REGISTRY.register("sinister_emerald", SinisterEmeraldBlock::new);
	public static final DeferredBlock<Block> SINISTER_DIAMOND = REGISTRY.register("sinister_diamond", SinisterDiamondBlock::new);
	public static final DeferredBlock<Block> SINISTER_LAPIS = REGISTRY.register("sinister_lapis", SinisterLapisBlock::new);
	public static final DeferredBlock<Block> SINISTER_NETHERITE = REGISTRY.register("sinister_netherite", SinisterNetheriteBlock::new);
	public static final DeferredBlock<Block> BEACON_AURA = REGISTRY.register("beacon_aura", BeaconAuraBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
