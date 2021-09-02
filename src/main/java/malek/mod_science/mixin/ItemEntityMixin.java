package malek.mod_science.mixin;

import malek.mod_science.event.ItemEntityTickEvent;
import malek.mod_science.fluids.ModFluidBlocks;
import malek.mod_science.items.ModItems;
import malek.mod_science.util.general.LoggerInterface;
import malek.mod_science.util.general.MixinUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity implements LoggerInterface {

    @Shadow
    public abstract ItemStack getStack();

    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    int shadowTimer;
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tickMixin(CallbackInfo ci) {
        ActionResult result = ItemEntityTickEvent.EVENT.invoker().doTick(MixinUtil.cast(this));
        switch (result) {
            case CONSUME:
                this.discard();
            case SUCCESS:
                ci.cancel();
        }
        if(this.onGround && (this.getStack().getItem() == ModItems.SHADOW || this.getStack().getItem() == ModItems.LIVID_SHADOW)){
            shadowTimer++;
            if(shadowTimer == 80){
                world.setBlockState(new BlockPos(this.getPos()), ModFluidBlocks.SHADOWFLUID.getDefaultState());
                this.kill();
                shadowTimer = 0;
            }
        }
    }


    @Override
    public Logger getLogger() {
        return LogManager.getLogger();
    }
}
