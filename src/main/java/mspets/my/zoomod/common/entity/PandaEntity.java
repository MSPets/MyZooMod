package mspets.my.zoomod.common.entity;

import mspets.my.zoomod.common.registry.EntityRegistries;
<<<<<<< HEAD
=======
import mspets.my.zoomod.common.registry.RegistryHandler;
>>>>>>> 54b034217c3b575d47a284fe9532774cca90e830
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

// https://forums.minecraftforge.net/topic/92625-1163-cant-register-entity-with-deferred-register/
public class PandaEntity extends AnimalEntity{
    public PandaEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        PandaEntity entity = new PandaEntity(EntityRegistries.PANDA_ENTITY.get(), this.world);
        entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos((IPosition) entity)), SpawnReason.BREEDING, (ILivingEntityData)  null, (CompoundNBT) null);
        return entity;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        int priority = 0;
        this.goalSelector.addGoal(priority++, new SwimGoal(this));
        this.goalSelector.addGoal(priority++, new PanicGoal(this, 1.25D));
        //this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        //this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(ItemInitNew.DEF_ITEM.get()), false));
        this.goalSelector.addGoal(priority++, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(priority++, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(priority++, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(priority++, new LookRandomlyGoal(this));
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        /*
        if(this.world.isRemote)
        {

        }
         */
        super.livingTick();
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }

}
