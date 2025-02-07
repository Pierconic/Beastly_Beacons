
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.beastlybeacons.world.inventory.InactiveBeaconGUIMenu;
import net.mcreator.beastlybeacons.world.inventory.ActiveBeaconGUIMenu;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

public class BeastlyBeaconsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, BeastlyBeaconsMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<InactiveBeaconGUIMenu>> INACTIVE_BEACON_GUI = REGISTRY.register("inactive_beacon_gui", () -> IMenuTypeExtension.create(InactiveBeaconGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ActiveBeaconGUIMenu>> ACTIVE_BEACON_GUI = REGISTRY.register("active_beacon_gui", () -> IMenuTypeExtension.create(ActiveBeaconGUIMenu::new));
}
