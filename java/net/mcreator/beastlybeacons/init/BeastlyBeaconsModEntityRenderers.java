
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.beastlybeacons.client.renderer.WardBackupRenderer;
import net.mcreator.beastlybeacons.client.renderer.FriendlyWeakForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.FriendlyWardRenderer;
import net.mcreator.beastlybeacons.client.renderer.FriendlyWardBeamProjectileRenderer;
import net.mcreator.beastlybeacons.client.renderer.FriendlyUltimateForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.FriendlyStrongForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.FriendlySpriteRenderer;
import net.mcreator.beastlybeacons.client.renderer.FriendlyMediumForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilWeakForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilWardRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilWardBeamProjectileRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilUltimateForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilStrongForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilSpriteRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilMediumForcefieldRenderer;
import net.mcreator.beastlybeacons.client.renderer.EvilBeaconBeamRenderer;
import net.mcreator.beastlybeacons.client.renderer.BeaconBeamTestRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BeastlyBeaconsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BeastlyBeaconsModEntities.BEACON_BEAM_TEST.get(), BeaconBeamTestRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_BEACON_BEAM.get(), EvilBeaconBeamRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.FRIENDLY_ULTIMATE_FORCEFIELD.get(), FriendlyUltimateForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.FRIENDLY_STRONG_FORCEFIELD.get(), FriendlyStrongForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.FRIENDLY_MEDIUM_FORCEFIELD.get(), FriendlyMediumForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.FRIENDLY_WEAK_FORCEFIELD.get(), FriendlyWeakForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_ULTIMATE_FORCEFIELD.get(), EvilUltimateForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_STRONG_FORCEFIELD.get(), EvilStrongForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_MEDIUM_FORCEFIELD.get(), EvilMediumForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_WEAK_FORCEFIELD.get(), EvilWeakForcefieldRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.FRIENDLY_WARD_BEAM_PROJECTILE.get(), FriendlyWardBeamProjectileRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_WARD_BEAM_PROJECTILE.get(), EvilWardBeamProjectileRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.FRIENDLY_SPRITE.get(), FriendlySpriteRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_SPRITE.get(), EvilSpriteRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.EVIL_WARD.get(), EvilWardRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.WARD_BACKUP.get(), WardBackupRenderer::new);
		event.registerEntityRenderer(BeastlyBeaconsModEntities.FRIENDLY_WARD.get(), FriendlyWardRenderer::new);
	}
}
