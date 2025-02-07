
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.beastlybeacons.client.gui.InactiveBeaconGUIScreen;
import net.mcreator.beastlybeacons.client.gui.ActiveBeaconGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BeastlyBeaconsModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(BeastlyBeaconsModMenus.INACTIVE_BEACON_GUI.get(), InactiveBeaconGUIScreen::new);
		event.register(BeastlyBeaconsModMenus.ACTIVE_BEACON_GUI.get(), ActiveBeaconGUIScreen::new);
	}
}
