
package net.mcreator.beastlybeacons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.WardBackupEntity;
import net.mcreator.beastlybeacons.client.model.Modelward_entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WardBackupRenderer extends MobRenderer<WardBackupEntity, Modelward_entity<WardBackupEntity>> {
	public WardBackupRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelward_entity(context.bakeLayer(Modelward_entity.LAYER_LOCATION)), 0.6f);
		this.addLayer(new RenderLayer<WardBackupEntity, Modelward_entity<WardBackupEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("beastly_beacons:textures/entities/wardfriendly.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, WardBackupEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(WardBackupEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/wardfriendly.png");
	}
}
