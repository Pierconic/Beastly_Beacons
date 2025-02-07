
package net.mcreator.beastlybeacons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.FriendlyMediumForcefieldEntity;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier2;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FriendlyMediumForcefieldRenderer extends MobRenderer<FriendlyMediumForcefieldEntity, Modelforcefieldtier2<FriendlyMediumForcefieldEntity>> {
	public FriendlyMediumForcefieldRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelforcefieldtier2(context.bakeLayer(Modelforcefieldtier2.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<FriendlyMediumForcefieldEntity, Modelforcefieldtier2<FriendlyMediumForcefieldEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefieldglow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FriendlyMediumForcefieldEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FriendlyMediumForcefieldEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/friendlyforcefield.png");
	}
}
