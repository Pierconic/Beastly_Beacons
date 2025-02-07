
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

public class BeastlyBeaconsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, BeastlyBeaconsMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> FRIENDLY_PULSE_TIER1 = REGISTRY.register("friendly.pulse.tier1",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "friendly.pulse.tier1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRIENDLY_PULSE_TIER2 = REGISTRY.register("friendly.pulse.tier2",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "friendly.pulse.tier2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRIENDLY_PULSE_TIER_3 = REGISTRY.register("friendly.pulse.tier.3",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "friendly.pulse.tier.3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EVIL_PULSE_TIER1 = REGISTRY.register("evil.pulse.tier1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "evil.pulse.tier1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EVIL_PULSE_TIER2 = REGISTRY.register("evil.pulse.tier2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "evil.pulse.tier2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EVIL_PULSE_TIER3 = REGISTRY.register("evil.pulse.tier3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "evil.pulse.tier3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRIENDLY_HUM = REGISTRY.register("friendly.hum", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "friendly.hum")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRIENDLY_HUM2 = REGISTRY.register("friendly.hum2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "friendly.hum2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EVIL_HUM = REGISTRY.register("evil.hum", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "evil.hum")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EVIL_HUM2 = REGISTRY.register("evil.hum2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "evil.hum2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BEACON_DEACTIVATE = REGISTRY.register("beacon.deactivate", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "beacon.deactivate")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BEACON_ACTIVATE = REGISTRY.register("beacon.activate", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "beacon.activate")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SENTINEL_SPAWN = REGISTRY.register("sentinel.spawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "sentinel.spawn")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SENTINEL_DEATH = REGISTRY.register("sentinel.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "sentinel.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SENTINEL_AMBIENT = REGISTRY.register("sentinel.ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "sentinel.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WARD_SPAWN = REGISTRY.register("ward.spawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "ward.spawn")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WARD_DEATH = REGISTRY.register("ward.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "ward.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WARD_AMBIENT = REGISTRY.register("ward.ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "ward.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WARD_ATTACK = REGISTRY.register("ward.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "ward.attack")));
	public static final DeferredHolder<SoundEvent, SoundEvent> INTRUDER_ALERT = REGISTRY.register("intruder.alert", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "intruder.alert")));
}
