
package net.mcreator.beastlybeacons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.FriendlyUltimateForcefieldEntity;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier4;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FriendlyUltimateForcefieldRenderer extends MobRenderer<FriendlyUltimateForcefieldEntity, Modelforcefieldtier4<FriendlyUltimateForcefieldEntity>> {
	public FriendlyUltimateForcefieldRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelforcefieldtier4(context.bakeLayer(Modelforcefieldtier4.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<FriendlyUltimateForcefieldEntity, Modelforcefieldtier4<FriendlyUltimateForcefieldEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefieldglow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FriendlyUltimateForcefieldEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FriendlyUltimateForcefieldEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefield.png");
	}
}
