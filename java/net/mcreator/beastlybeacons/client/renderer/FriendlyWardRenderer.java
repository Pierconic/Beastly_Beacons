
package net.mcreator.beastlybeacons.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.model.FriendlyWardModel;
import net.mcreator.beastlybeacons.entity.layer.FriendlyWardLayer;
import net.mcreator.beastlybeacons.entity.FriendlyWardEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FriendlyWardRenderer extends GeoEntityRenderer<FriendlyWardEntity> {
	public FriendlyWardRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FriendlyWardModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new FriendlyWardLayer(this));
	}

	@Override
	public RenderType getRenderType(FriendlyWardEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, FriendlyWardEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(FriendlyWardEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
