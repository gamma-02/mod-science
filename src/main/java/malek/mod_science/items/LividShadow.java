package malek.mod_science.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class LividShadow extends Shadow{


    private static ServerPlayerEntity owner;
    public LividShadow(Fluid fluid, Settings settings, ServerPlayerEntity entity) {
        super(fluid, settings);
        owner = entity;
    }
    public static ServerPlayerEntity getOwner(LividShadow shadow){
        return shadow.owner;
    }
    public static void setOwner(ServerPlayerEntity owner1){
        owner = owner1;
    }

    public void onDrop(ItemStack stack, World world, PlayerEntity player) {
        this.owner = player.getServer().getPlayerManager().getPlayer(player.getUuid());
    }

}
