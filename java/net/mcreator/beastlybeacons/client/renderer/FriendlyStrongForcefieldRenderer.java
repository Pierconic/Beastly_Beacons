
package net.mcreator.beastlybeacons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.FriendlyStrongForcefieldEntity;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier3;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FriendlyStrongForcefieldRenderer extends MobRenderer<FriendlyStrongForcefieldEntity, Modelforcefieldtier3<FriendlyStrongForcefieldEntity>> {
	public FriendlyStrongForcefieldRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelforcefieldtier3(context.bakeLayer(Modelforcefieldtier3.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<FriendlyStrongForcefieldEntity, Modelforcefieldtier3<FriendlyStrongForcefieldEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefieldglow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FriendlyStrongForcefieldEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FriendlyStrongForcefieldEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefield.png");
	}
}
