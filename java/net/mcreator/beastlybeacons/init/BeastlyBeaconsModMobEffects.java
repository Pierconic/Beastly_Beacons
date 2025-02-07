
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.beastlybeacons.potion.PurityMobEffect;
import net.mcreator.beastlybeacons.potion.MalevolenceMobEffect;
import net.mcreator.beastlybeacons.potion.BenevolenceMobEffect;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

public class BeastlyBeaconsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, BeastlyBeaconsMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> BENEVOLENCE = REGISTRY.register("benevolence", () -> new BenevolenceMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MALEVOLENCE = REGISTRY.register("malevolence", () -> new MalevolenceMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PURITY = REGISTRY.register("purity", () -> new PurityMobEffect());
}
