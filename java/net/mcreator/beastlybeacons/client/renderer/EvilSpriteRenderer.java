
package net.mcreator.beastlybeacons.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.model.EvilSpriteModel;
import net.mcreator.beastlybeacons.entity.layer.EvilSpriteLayer;
import net.mcreator.beastlybeacons.entity.EvilSpriteEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EvilSpriteRenderer extends GeoEntityRenderer<EvilSpriteEntity> {
	public EvilSpriteRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new EvilSpriteModel());
		this.shadowRadius = 0.3f;
		this.addRenderLayer(new EvilSpriteLayer(this));
	}

	@Override
	public RenderType getRenderType(EvilSpriteEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, EvilSpriteEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(EvilSpriteEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
