package mspets.my.zoomod.common.registry;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.common.entity.CrocodileEntity;
import mspets.my.zoomod.common.entity.MonkeyEntity;
import mspets.my.zoomod.common.entity.PandaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistries {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, MyZooMod.MODID);

    public static final RegistryObject<EntityType<PandaEntity>> PANDA_ENTITY = ENTITY_TYPE.register("panda", () ->
            EntityType.Builder.create(PandaEntity::new, EntityClassification.CREATURE)
                    .size(0.9f,1.3f)
                    .build(new ResourceLocation(MyZooMod.MODID, "panda_entity").toString()));

    public static final RegistryObject<EntityType<CrocodileEntity>> CROCODILE_ENTITY = ENTITY_TYPE.register("crocodile", () ->
            EntityType.Builder.create(CrocodileEntity::new, EntityClassification.CREATURE)
                    .size(3f,1f)
                    .build(new ResourceLocation(MyZooMod.MODID, "crocodile_entity").toString()));

    public static final RegistryObject<EntityType<MonkeyEntity>> MONKEY_ENTITY = ENTITY_TYPE.register("monkey", () ->
            EntityType.Builder.create(MonkeyEntity::new, EntityClassification.CREATURE)
                    .size(3f,1f)
                    .build(new ResourceLocation(MyZooMod.MODID, "monkey_entity").toString()));

}
