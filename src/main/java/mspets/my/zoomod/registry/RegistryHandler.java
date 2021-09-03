package mspets.my.zoomod.registry;

import mspets.my.zoomod.ModItemTier;
import mspets.my.zoomod.MyZooMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MyZooMod.MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyZooMod.MODID);

    // Blocks
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
}
