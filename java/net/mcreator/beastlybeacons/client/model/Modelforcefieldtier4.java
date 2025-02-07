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
public class Modelforcefieldtier4<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("beastly_beacons", "modelforcefieldtier_4"), "main");
	public final ModelPart Shields;
	public final ModelPart UpperSmalls;
	public final ModelPart Smalls;
	public final ModelPart LowerSmalls;

	public Modelforcefieldtier4(ModelPart root) {
		this.Shields = root.getChild("Shields");
		this.UpperSmalls = root.getChild("UpperSmalls");
		this.Smalls = root.getChild("Smalls");
		this.LowerSmalls = root.getChild("LowerSmalls");
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
		PartDefinition UpperSmalls = partdefinition.addOrReplaceChild("UpperSmalls", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition cube_r8 = UpperSmalls.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r9 = UpperSmalls.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.3927F));
		PartDefinition cube_r10 = UpperSmalls.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7489F, 0.0F, 3.1416F));
		PartDefinition cube_r11 = UpperSmalls.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7489F, 0.7854F, 3.1416F));
		PartDefinition cube_r12 = UpperSmalls.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.3927F));
		PartDefinition cube_r13 = UpperSmalls.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.7854F, 0.0F));
		PartDefinition cube_r14 = UpperSmalls.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, -0.7854F, 0.0F));
		PartDefinition cube_r15 = UpperSmalls.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7489F, -0.7854F, -3.1416F));
		PartDefinition Smalls = partdefinition.addOrReplaceChild("Smalls", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition cube_r16 = Smalls.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.3927F, 3.1416F));
		PartDefinition cube_r17 = Smalls.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 1.1781F, 3.1416F));
		PartDefinition cube_r18 = Smalls.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
		PartDefinition cube_r19 = Smalls.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -1.1781F, 3.1416F));
		PartDefinition cube_r20 = Smalls.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
		PartDefinition cube_r21 = Smalls.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r22 = Smalls.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.3927F, 3.1416F));
		PartDefinition cube_r23 = Smalls.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition LowerSmalls = partdefinition.addOrReplaceChild("LowerSmalls", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition cube_r24 = LowerSmalls.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r25 = LowerSmalls.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.3927F));
		PartDefinition cube_r26 = LowerSmalls.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7489F, 0.0F, 3.1416F));
		PartDefinition cube_r27 = LowerSmalls.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7489F, 0.7854F, 3.1416F));
		PartDefinition cube_r28 = LowerSmalls.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.3927F));
		PartDefinition cube_r29 = LowerSmalls.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.7854F, 0.0F));
		PartDefinition cube_r30 = LowerSmalls.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, -0.7854F, 0.0F));
		PartDefinition cube_r31 = LowerSmalls.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 28).addBox(-4.75F, -13.75F, -70.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7489F, -0.7854F, -3.1416F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Shields.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		UpperSmalls.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Smalls.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LowerSmalls.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.UpperSmalls.yRot = ageInTicks / 20.f;
		this.Smalls.yRot = ageInTicks / 20.f;
		this.LowerSmalls.yRot = ageInTicks / 20.f;
		this.Shields.yRot = ageInTicks / 20.f;
	}
}
