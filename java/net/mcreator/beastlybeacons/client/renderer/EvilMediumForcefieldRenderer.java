
package net.mcreator.beastlybeacons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.EvilMediumForcefieldEntity;
import net.mcreator.beastlybeacons.client.model.Modelforcefieldtier2;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EvilMediumForcefieldRenderer extends MobRenderer<EvilMediumForcefieldEntity, Modelforcefieldtier2<EvilMediumForcefieldEntity>> {
	public EvilMediumForcefieldRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelforcefieldtier2(context.bakeLayer(Modelforcefieldtier2.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<EvilMediumForcefieldEntity, Modelforcefieldtier2<EvilMediumForcefieldEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("beastly_beacons:textures/entities/sinisterforcefieldd1glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EvilMediumForcefieldEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EvilMediumForcefieldEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/sinisterforcefieldd1.png");
	}
}
