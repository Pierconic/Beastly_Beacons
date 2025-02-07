
package net.mcreator.beastlybeacons.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.model.EvilWardModel;
import net.mcreator.beastlybeacons.entity.layer.EvilWardLayer;
import net.mcreator.beastlybeacons.entity.EvilWardEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EvilWardRenderer extends GeoEntityRenderer<EvilWardEntity> {
	public EvilWardRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new EvilWardModel());
		this.shadowRadius = 0.6f;
		this.addRenderLayer(new EvilWardLayer(this));
	}

	@Override
	public RenderType getRenderType(EvilWardEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, EvilWardEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(EvilWardEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
