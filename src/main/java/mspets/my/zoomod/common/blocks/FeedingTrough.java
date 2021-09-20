package mspets.my.zoomod.common.blocks;

import mspets.my.zoomod.common.container.FeedingTroughContainer;
<<<<<<< HEAD
import mspets.my.zoomod.common.registry.TileRegistries;
=======
import mspets.my.zoomod.common.registry.TileRegisties;
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
import mspets.my.zoomod.common.tile_entity.FeedingTroughTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class FeedingTrough extends Block {

    public FeedingTrough(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
<<<<<<< HEAD
        return TileRegistries.FEEDING_TROUGH_TILE.get().create();
=======
        return TileRegisties.FEEDING_TROUGH_TILE.get().create();
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        // Is server
        if(!worldIn.isRemote()){
            TileEntity tileEntity = worldIn.getTileEntity(pos);

            //if (player.isCrouching())
            if(tileEntity instanceof FeedingTroughTile){
                INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);

                NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileEntity.getPos());
            }
            else{
                throw new IllegalStateException("Feeding trough container provider is missing!");
            }

        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.myzoomod.feeding_trough");
            }
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new FeedingTroughContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }
}
