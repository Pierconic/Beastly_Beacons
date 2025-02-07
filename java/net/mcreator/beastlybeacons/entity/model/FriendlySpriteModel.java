package net.mcreator.beastlybeacons.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.beastlybeacons.entity.FriendlySpriteEntity;

public class FriendlySpriteModel extends GeoModel<FriendlySpriteEntity> {
	@Override
	public ResourceLocation getAnimationResource(FriendlySpriteEntity entity) {
		return ResourceLocation.parse("beastly_beacons:animations/sprite.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FriendlySpriteEntity entity) {
		return ResourceLocation.parse("beastly_beacons:geo/sprite.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FriendlySpriteEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/" + entity.getTexture() + ".png");
	}

}
