package net.mcreator.beastlybeacons.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.beastlybeacons.entity.FriendlyWardEntity;

public class FriendlyWardModel extends GeoModel<FriendlyWardEntity> {
	@Override
	public ResourceLocation getAnimationResource(FriendlyWardEntity entity) {
		return ResourceLocation.parse("beastly_beacons:animations/ward.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FriendlyWardEntity entity) {
		return ResourceLocation.parse("beastly_beacons:geo/ward.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FriendlyWardEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/" + entity.getTexture() + ".png");
	}

}
