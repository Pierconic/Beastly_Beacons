
package net.mcreator.beastlybeacons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.FriendlyWeakForcefieldEntity;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier1;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FriendlyWeakForcefieldRenderer extends MobRenderer<FriendlyWeakForcefieldEntity, Modelforcefieldtier1<FriendlyWeakForcefieldEntity>> {
	public FriendlyWeakForcefieldRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelforcefieldtier1(context.bakeLayer(Modelforcefieldtier1.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<FriendlyWeakForcefieldEntity, Modelforcefieldtier1<FriendlyWeakForcefieldEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefieldglow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FriendlyWeakForcefieldEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FriendlyWeakForcefieldEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefield.png");
	}
}
