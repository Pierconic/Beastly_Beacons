package net.mcreator.beastlybeacons.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.beastlybeacons.entity.EvilSpriteEntity;

public class EvilSpriteModel extends GeoModel<EvilSpriteEntity> {
	@Override
	public ResourceLocation getAnimationResource(EvilSpriteEntity entity) {
		return ResourceLocation.parse("beastly_beacons:animations/sprite.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EvilSpriteEntity entity) {
		return ResourceLocation.parse("beastly_beacons:geo/sprite.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EvilSpriteEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/" + entity.getTexture() + ".png");
	}

}
