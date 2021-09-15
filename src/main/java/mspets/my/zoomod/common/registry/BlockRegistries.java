package mspets.my.zoomod.common.registry;

import mspets.my.zoomod.MyZooMod;
import mspets.my.zoomod.common.blocks.FeedingTrough;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistries {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MyZooMod.MODID);

    public static final RegistryObject<Block> FEEDING_TROUGH = BLOCKS.register("feeding_trough", () ->
            new FeedingTrough(
                    Block.Properties
                            .create(Material.IRON)
                            .hardnessAndResistance(5.0f, 6.0f)
                            .sound(SoundType.STONE)
                            .harvestLevel(1)
                            .harvestTool(ToolType.AXE)
            )
    );
}
