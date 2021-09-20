package mspets.my.zoomod.common.tile_entity;

<<<<<<< HEAD
import mspets.my.zoomod.common.registry.TileRegistries;
import net.minecraft.block.BlockState;
=======
import mspets.my.zoomod.common.registry.BlockRegistries;
import mspets.my.zoomod.common.registry.TileRegisties;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class FeedingTroughTile extends TileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    // for hopper
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public FeedingTroughTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public FeedingTroughTile(){
<<<<<<< HEAD
        this(TileRegistries.FEEDING_TROUGH_TILE.get());
=======
        this(TileRegisties.FEEDING_TROUGH_TILE.get());
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler(){
<<<<<<< HEAD
        // How many item slots
        return new ItemStackHandler(6){
=======
        return new ItemStackHandler(2){
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
<<<<<<< HEAD
            public boolean isItemValid(int slot, ItemStack stack) {
                if(stack.getItem() == Items.WHEAT){
                    return stack.getItem() == Items.WHEAT;
                }
                else {
                    return false;
=======
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot){
                    case 0: return stack.getItem() == Items.GLASS_PANE;
                    default:
                        return false;
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
                }
                //return super.isItemValid(slot, stack);
            }

            @Override
            public int getSlotLimit(int slot) {
<<<<<<< HEAD
                return 64;
=======
                return 1;
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

}
