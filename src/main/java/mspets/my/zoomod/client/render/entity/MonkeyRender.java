package mspets.my.zoomod.client.render.entity;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.client.model.entity.MonkeyEntityModel;
import mspets.my.zoomod.common.entity.MonkeyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MonkeyRender extends GeoEntityRenderer<MonkeyEntity> {

    public MonkeyRender(EntityRendererManager renderManager)
    {
        super(renderManager, new MonkeyEntityModel());
        this.shadowSize = 0.5f;
    }

    @Override
    public ResourceLocation getEntityTexture(MonkeyEntity entity) {
        return new ResourceLocation(MyZooMod.MODID, "textures/entities/monkey.png");
    }
}
