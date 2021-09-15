package mspets.my.zoomod.common.registry;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.common.container.FeedingTroughContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerRegistries {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MyZooMod.MODID);

    public static final RegistryObject<ContainerType<FeedingTroughContainer>> FEEDING_TROUGH_CONTAINER =
            CONTAINERS.register("feeding_trough_container",() ->
                    IForgeContainerType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntityWorld();
                        return new FeedingTroughContainer(windowId, world, pos, inv, inv.player);
                    })));
}
