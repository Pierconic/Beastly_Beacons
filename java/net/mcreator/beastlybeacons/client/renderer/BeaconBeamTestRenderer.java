
package net.mcreator.beastlybeacons.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.beastlybeacons.entity.BeaconBeamTestEntity;
import net.mcreator.beastlybeacons.client.model.ModelRemapped_Beam;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BeaconBeamTestRenderer extends MobRenderer<BeaconBeamTestEntity, ModelRemapped_Beam<BeaconBeamTestEntity>> {
	public BeaconBeamTestRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRemapped_Beam(context.bakeLayer(ModelRemapped_Beam.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<BeaconBeamTestEntity, ModelRemapped_Beam<BeaconBeamTestEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("beastly_beacons:textures/entities/remappedbeamtexture.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, BeaconBeamTestEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(BeaconBeamTestEntity entity) {
		return ResourceLocation.parse("beastly_beacons:textures/entities/remappedbeamtexture.png");
	}
}
