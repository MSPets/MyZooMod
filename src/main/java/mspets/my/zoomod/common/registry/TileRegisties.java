package mspets.my.zoomod.common.registry;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.common.tile_entity.FeedingTroughTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileRegisties {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MyZooMod.MODID);

    public static final RegistryObject<TileEntityType<FeedingTroughTile>> FEEDING_TROUGH_TILE =
            TILE_ENTITIES.register("feeding_trough_tile", () ->
                    TileEntityType.Builder.create(FeedingTroughTile::new, BlockRegistries.FEEDING_TROUGH.get()).build(null));
}
