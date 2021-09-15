package mspets.my.zoomod.common.registry;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.common.ModItemTier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyZooMod.MODID);

    public static final RegistryObject<Item> FEEDING_TROUGH_ITEM = ITEMS.register("feeding_trough", () ->
            new BlockItem(BlockRegistries.FEEDING_TROUGH.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    public static final RegistryObject<SwordItem> NAME_SPEAR = ITEMS.register("name_spear", () ->
            new SwordItem(
                    ModItemTier.CUSTOMNAMEHERE, 5, -2.8f, (new Item.Properties()).group(ItemGroup.COMBAT)
            )
    );
}
