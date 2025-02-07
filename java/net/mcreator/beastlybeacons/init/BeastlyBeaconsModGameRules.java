
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BeastlyBeaconsModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> REQUIRE_BEACON_EXP;
	public static GameRules.Key<GameRules.BooleanValue> ALLOW_BEACON_LOCKING;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		REQUIRE_BEACON_EXP = GameRules.register("requireBeaconEXP", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		ALLOW_BEACON_LOCKING = GameRules.register("allowBeaconLocking", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	}
}
