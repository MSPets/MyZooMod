package mspets.my.zoomod.client.model;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mspets.my.zoomod.common.entity.PandaEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PandaEntityModel <T extends PandaEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Front;
	private final ModelRenderer RightFront;
	private final ModelRenderer LeftFront;
	private final ModelRenderer Back;
	private final ModelRenderer LeftBack;
	private final ModelRenderer RightBack;
	private final ModelRenderer Head;

	public PandaEntityModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 13.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-7.0F, -12.0F, -16.0F, 14.0F, 12.0F, 32.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		

		Front = new ModelRenderer(this);
		Front.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Front);
		

		RightFront = new ModelRenderer(this);
		RightFront.setRotationPoint(0.0F, 0.0F, 0.0F);
		Front.addChild(RightFront);
		RightFront.setTextureOffset(48, 44).addBox(-11.0F, -7.0F, -16.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

		LeftFront = new ModelRenderer(this);
		LeftFront.setRotationPoint(0.0F, 0.0F, 0.0F);
		Front.addChild(LeftFront);
		LeftFront.setTextureOffset(32, 44).addBox(7.0F, -7.0F, -16.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

		Back = new ModelRenderer(this);
		Back.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Back);
		

		LeftBack = new ModelRenderer(this);
		LeftBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		Back.addChild(LeftBack);
		LeftBack.setTextureOffset(16, 44).addBox(7.0F, -7.0F, 12.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

		RightBack = new ModelRenderer(this);
		RightBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		Back.addChild(RightBack);
		RightBack.setTextureOffset(0, 44).addBox(-11.0F, -7.0F, 12.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -16.0F, -21.0F, 8.0F, 8.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	/*
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
	}
	 */
}