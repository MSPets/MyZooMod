package mspets.my.zoomod.common.registry;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.common.entity.CrocodileEntity;
import mspets.my.zoomod.common.entity.PandaEntity;
import mspets.my.zoomod.common.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MyZooMod.MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyZooMod.MODID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, MyZooMod.MODID);

    // Blocks with items
    public static final RegistryObject<Block> FEEDING_TROUGH = BLOCKS.register("feeding_trough", () ->
            new Block(
                    Block.Properties
                            .create(Material.IRON)
                            .hardnessAndResistance(5.0f, 6.0f)
                            .sound(SoundType.STONE)
                            .harvestLevel(1)
                            .harvestTool(ToolType.AXE)
            )
    );
    public static final RegistryObject<Item> FEEDING_TROUGH_ITEM = ITEMS.register("feeding_trough", () ->
            new BlockItem(FEEDING_TROUGH.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    // Items
    public static final RegistryObject<SwordItem> NAME_SPEAR = ITEMS.register("name_spear", () ->
            new SwordItem(
                    ModItemTier.CUSTOMNAMEHERE, 5, -2.8f, (new Item.Properties()).group(ItemGroup.COMBAT)
            )
    );

    // TODO maybe remove
    // Entities + egg
    public static final RegistryObject<EntityType<PandaEntity>> PANDA_ENTITY = ENTITY_TYPE.register("panda", () ->
            EntityType.Builder.create(PandaEntity::new, EntityClassification.CREATURE)
                    .size(0.9f,1.3f)
                    .build(new ResourceLocation(MyZooMod.MODID, "panda_entity").toString()));

    public static final RegistryObject<EntityType<CrocodileEntity>> CROCODILE_ENTITY = ENTITY_TYPE.register("crocodile", () ->
            EntityType.Builder.create(CrocodileEntity::new, EntityClassification.CREATURE)
                    .size(3f,1f)
                    .build(new ResourceLocation(MyZooMod.MODID, "crocodile_entity").toString()));

}
