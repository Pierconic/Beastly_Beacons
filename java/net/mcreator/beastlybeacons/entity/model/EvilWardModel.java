package net.mcreator.beastlybeacons.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.beastlybeacons.entity.EvilWardEntity;

public class EvilWardModel extends GeoModel<EvilWardEntity> {
	@Override
	public ResourceLocation getAnimationResource(EvilWardEntity entity) {
		return ResourceLocation.parse("beastly_beacons:animations/ward.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EvilWardEntity entity) {
		return ResourceLocation.parse("beastly_beacons:geo/ward.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EvilWardEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/" + entity.getTexture() + ".png");
	}

}
