package mspets.my.zoomod.client.model.entity;

import mspets.my.zoomod.MyZooMod;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrocodileEntityModel extends AnimatedGeoModel{
	@Override
	public ResourceLocation getModelLocation(Object object) {
		return new ResourceLocation(MyZooMod.MODID, "geo/crocodile.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(Object object) {
		return new ResourceLocation(MyZooMod.MODID, "textures/entities/crocodile.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(Object animatable) {
		return new ResourceLocation(MyZooMod.MODID, "animations/crocodile.animation.json");
	}
}