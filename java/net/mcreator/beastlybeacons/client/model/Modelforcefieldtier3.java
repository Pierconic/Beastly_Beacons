package net.mcreator.beastlybeacons.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelforcefieldtier3<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "modelforcefieldtier_3"), "main");
	public final ModelPart Shields;
	public final ModelPart Smalls;

	public Modelforcefieldtier3(ModelPart root) {
		this.Shields = root.getChild("Shields");
		this.Smalls = root.getChild("Smalls");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Shields = partdefinition.addOrReplaceChild("Shields", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = Shields.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r2 = Shields.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r3 = Shields.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
		PartDefinition cube_r4 = Shields.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
		PartDefinition cube_r5 = Shields.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r6 = Shields.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));
		PartDefinition cube_r7 = Shields.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -26.0F, -70.0F, 16.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition Smalls = partdefinition.addOrReplaceChild("Smalls", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition cube_r8 = Smalls.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.3927F, 3.1416F));
		PartDefinition cube_r9 = Smalls.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 1.1781F, 3.1416F));
		PartDefinition cube_r10 = Smalls.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
		PartDefinition cube_r11 = Smalls.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -1.1781F, 3.1416F));
		PartDefinition cube_r12 = Smalls.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
		PartDefinition cube_r13 = Smalls.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r14 = Smalls.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.3927F, 3.1416F));
		PartDefinition cube_r15 = Smalls.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Shields.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Smalls.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Smalls.yRot = ageInTicks / 20.f;
		this.Shields.yRot = ageInTicks / 20.f;
	}
}
