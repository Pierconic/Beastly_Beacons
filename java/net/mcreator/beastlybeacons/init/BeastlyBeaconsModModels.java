
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.beastlybeacons.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.beastlybeacons.client.model.Modelward_entity;
import net.mcreator.beastlybeacons.client.model.Modelsentinel_entity;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier4;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier3;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier2;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier1;
import net.mcreator.beastlybeacons.client.model.Modelbeam_model;
import net.mcreator.beastlybeacons.client.model.Modelbeacon_aura;
import net.mcreator.beastlybeacons.client.model.ModelRemapped_Beam;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BeastlyBeaconsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelbeam_model.LAYER_LOCATION, Modelbeam_model::createBodyLayer);
		event.registerLayerDefinition(Modelforcefieldtier4.LAYER_LOCATION, Modelforcefieldtier4::createBodyLayer);
		event.registerLayerDefinition(Modelbeacon_aura.LAYER_LOCATION, Modelbeacon_aura::createBodyLayer);
		event.registerLayerDefinition(Modelforcefieldtier2.LAYER_LOCATION, Modelforcefieldtier2::createBodyLayer);
		event.registerLayerDefinition(Modelward_entity.LAYER_LOCATION, Modelward_entity::createBodyLayer);
		event.registerLayerDefinition(Modelsentinel_entity.LAYER_LOCATION, Modelsentinel_entity::createBodyLayer);
		event.registerLayerDefinition(ModelRemapped_Beam.LAYER_LOCATION, ModelRemapped_Beam::createBodyLayer);
		event.registerLayerDefinition(Modelforcefieldtier3.LAYER_LOCATION, Modelforcefieldtier3::createBodyLayer);
		event.registerLayerDefinition(Modelforcefieldtier1.LAYER_LOCATION, Modelforcefieldtier1::createBodyLayer);
	}
}
