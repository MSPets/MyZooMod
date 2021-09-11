package mspets.my.zoomod.client.render.entity;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.client.model.entity.CrocodileEntityModel;
import mspets.my.zoomod.common.entity.CrocodileEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrocodileRender extends GeoEntityRenderer<CrocodileEntity> {

    public CrocodileRender(EntityRendererManager renderManager)
    {
        super(renderManager, new CrocodileEntityModel());
        this.shadowSize = 0.5f;
    }

    @Override
    public ResourceLocation getEntityTexture(CrocodileEntity entity) {
        return new ResourceLocation(MyZooMod.MODID, "textures/entities/crocodile.png");
    }
}
