package mspets.my.zoomod.client.render.entity;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.client.model.entity.PandaEntityModel;
import mspets.my.zoomod.common.entity.PandaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PandaRender extends MobRenderer<PandaEntity, PandaEntityModel<PandaEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(MyZooMod.MODID,
            "textures/entities/panda_entity.png");

    public PandaRender(EntityRendererManager renderManagerIn) {
        super (renderManagerIn, new PandaEntityModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(PandaEntity entity) {
        return TEXTURE;
    }
}
