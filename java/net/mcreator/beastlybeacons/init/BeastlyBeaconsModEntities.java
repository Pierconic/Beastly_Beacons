
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.beastlybeacons.entity.WardBackupEntity;
import net.mcreator.beastlybeacons.entity.FriendlyWeakForcefieldEntity;
import net.mcreator.beastlybeacons.entity.FriendlyWardEntity;
import net.mcreator.beastlybeacons.entity.FriendlyWardBeamProjectileEntity;
import net.mcreator.beastlybeacons.entity.FriendlyUltimateForcefieldEntity;
import net.mcreator.beastlybeacons.entity.FriendlyStrongForcefieldEntity;
import net.mcreator.beastlybeacons.entity.FriendlySpriteEntity;
import net.mcreator.beastlybeacons.entity.FriendlyMediumForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilWeakForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilWardEntity;
import net.mcreator.beastlybeacons.entity.EvilWardBeamProjectileEntity;
import net.mcreator.beastlybeacons.entity.EvilUltimateForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilStrongForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilSpriteEntity;
import net.mcreator.beastlybeacons.entity.EvilMediumForcefieldEntity;
import net.mcreator.beastlybeacons.entity.EvilBeaconBeamEntity;
import net.mcreator.beastlybeacons.entity.BeaconBeamTestEntity;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BeastlyBeaconsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, BeastlyBeaconsMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<BeaconBeamTestEntity>> BEACON_BEAM_TEST = register("beacon_beam_test",
			EntityType.Builder.<BeaconBeamTestEntity>of(BeaconBeamTestEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).fireImmune().sized(0.6f, 1000f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilBeaconBeamEntity>> EVIL_BEACON_BEAM = register("evil_beacon_beam",
			EntityType.Builder.<EvilBeaconBeamEntity>of(EvilBeaconBeamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).fireImmune().sized(0.6f, 1000f));
	public static final DeferredHolder<EntityType<?>, EntityType<FriendlyUltimateForcefieldEntity>> FRIENDLY_ULTIMATE_FORCEFIELD = register("friendly_ultimate_forcefield",
			EntityType.Builder.<FriendlyUltimateForcefieldEntity>of(FriendlyUltimateForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<FriendlyStrongForcefieldEntity>> FRIENDLY_STRONG_FORCEFIELD = register("friendly_strong_forcefield",
			EntityType.Builder.<FriendlyStrongForcefieldEntity>of(FriendlyStrongForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<FriendlyMediumForcefieldEntity>> FRIENDLY_MEDIUM_FORCEFIELD = register("friendly_medium_forcefield",
			EntityType.Builder.<FriendlyMediumForcefieldEntity>of(FriendlyMediumForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<FriendlyWeakForcefieldEntity>> FRIENDLY_WEAK_FORCEFIELD = register("friendly_weak_forcefield",
			EntityType.Builder.<FriendlyWeakForcefieldEntity>of(FriendlyWeakForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilUltimateForcefieldEntity>> EVIL_ULTIMATE_FORCEFIELD = register("evil_ultimate_forcefield",
			EntityType.Builder.<EvilUltimateForcefieldEntity>of(EvilUltimateForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilStrongForcefieldEntity>> EVIL_STRONG_FORCEFIELD = register("evil_strong_forcefield",
			EntityType.Builder.<EvilStrongForcefieldEntity>of(EvilStrongForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilMediumForcefieldEntity>> EVIL_MEDIUM_FORCEFIELD = register("evil_medium_forcefield",
			EntityType.Builder.<EvilMediumForcefieldEntity>of(EvilMediumForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilWeakForcefieldEntity>> EVIL_WEAK_FORCEFIELD = register("evil_weak_forcefield",
			EntityType.Builder.<EvilWeakForcefieldEntity>of(EvilWeakForcefieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(8f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<FriendlyWardBeamProjectileEntity>> FRIENDLY_WARD_BEAM_PROJECTILE = register("friendly_ward_beam_projectile",
			EntityType.Builder.<FriendlyWardBeamProjectileEntity>of(FriendlyWardBeamProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilWardBeamProjectileEntity>> EVIL_WARD_BEAM_PROJECTILE = register("evil_ward_beam_projectile",
			EntityType.Builder.<EvilWardBeamProjectileEntity>of(EvilWardBeamProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FriendlySpriteEntity>> FRIENDLY_SPRITE = register("friendly_sprite",
			EntityType.Builder.<FriendlySpriteEntity>of(FriendlySpriteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilSpriteEntity>> EVIL_SPRITE = register("evil_sprite",
			EntityType.Builder.<EvilSpriteEntity>of(EvilSpriteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.45f, 0.45f));
	public static final DeferredHolder<EntityType<?>, EntityType<EvilWardEntity>> EVIL_WARD = register("evil_ward",
			EntityType.Builder.<EvilWardEntity>of(EvilWardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3).fireImmune().sized(1.2f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<WardBackupEntity>> WARD_BACKUP = register("ward_backup",
			EntityType.Builder.<WardBackupEntity>of(WardBackupEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3).fireImmune().sized(1.3f, 1.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<FriendlyWardEntity>> FRIENDLY_WARD = register("friendly_ward",
			EntityType.Builder.<FriendlyWardEntity>of(FriendlyWardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3).fireImmune().sized(1.2f, 0.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		BeaconBeamTestEntity.init(event);
		EvilBeaconBeamEntity.init(event);
		FriendlyUltimateForcefieldEntity.init(event);
		FriendlyStrongForcefieldEntity.init(event);
		FriendlyMediumForcefieldEntity.init(event);
		FriendlyWeakForcefieldEntity.init(event);
		EvilUltimateForcefieldEntity.init(event);
		EvilStrongForcefieldEntity.init(event);
		EvilMediumForcefieldEntity.init(event);
		EvilWeakForcefieldEntity.init(event);
		FriendlySpriteEntity.init(event);
		EvilSpriteEntity.init(event);
		EvilWardEntity.init(event);
		WardBackupEntity.init(event);
		FriendlyWardEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BEACON_BEAM_TEST.get(), BeaconBeamTestEntity.createAttributes().build());
		event.put(EVIL_BEACON_BEAM.get(), EvilBeaconBeamEntity.createAttributes().build());
		event.put(FRIENDLY_ULTIMATE_FORCEFIELD.get(), FriendlyUltimateForcefieldEntity.createAttributes().build());
		event.put(FRIENDLY_STRONG_FORCEFIELD.get(), FriendlyStrongForcefieldEntity.createAttributes().build());
		event.put(FRIENDLY_MEDIUM_FORCEFIELD.get(), FriendlyMediumForcefieldEntity.createAttributes().build());
		event.put(FRIENDLY_WEAK_FORCEFIELD.get(), FriendlyWeakForcefieldEntity.createAttributes().build());
		event.put(EVIL_ULTIMATE_FORCEFIELD.get(), EvilUltimateForcefieldEntity.createAttributes().build());
		event.put(EVIL_STRONG_FORCEFIELD.get(), EvilStrongForcefieldEntity.createAttributes().build());
		event.put(EVIL_MEDIUM_FORCEFIELD.get(), EvilMediumForcefieldEntity.createAttributes().build());
		event.put(EVIL_WEAK_FORCEFIELD.get(), EvilWeakForcefieldEntity.createAttributes().build());
		event.put(FRIENDLY_SPRITE.get(), FriendlySpriteEntity.createAttributes().build());
		event.put(EVIL_SPRITE.get(), EvilSpriteEntity.createAttributes().build());
		event.put(EVIL_WARD.get(), EvilWardEntity.createAttributes().build());
		event.put(WARD_BACKUP.get(), WardBackupEntity.createAttributes().build());
		event.put(FRIENDLY_WARD.get(), FriendlyWardEntity.createAttributes().build());
	}
}
