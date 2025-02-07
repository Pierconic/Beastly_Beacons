
package net.mcreator.beastlybeacons.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.model.FriendlySpriteModel;
import net.mcreator.beastlybeacons.entity.layer.FriendlySpriteLayer;
import net.mcreator.beastlybeacons.entity.FriendlySpriteEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FriendlySpriteRenderer extends GeoEntityRenderer<FriendlySpriteEntity> {
	public FriendlySpriteRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FriendlySpriteModel());
		this.shadowRadius = 0.3f;
		this.addRenderLayer(new FriendlySpriteLayer(this));
	}

	@Override
	public RenderType getRenderType(FriendlySpriteEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, FriendlySpriteEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(FriendlySpriteEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
