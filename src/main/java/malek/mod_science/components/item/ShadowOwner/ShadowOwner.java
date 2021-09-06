package malek.mod_science.components.item.ShadowOwner;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.item.ItemComponent;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import malek.mod_science.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

import static malek.mod_science.ModScience.ModScienceId;
import static malek.mod_science.ModScience.getServer;

public class ShadowOwner extends ItemComponent implements ItemComponentInitializer, OwnerComponent {
    public static final ComponentKey<ShadowOwner> SHADOW_OWNER = ComponentRegistryV3.INSTANCE.getOrCreate(ModScienceId("shadow_owner"), ShadowOwner.class);



    public ShadowOwner(ItemStack stack) {
        super(stack);
    }

    @Override
    public void registerItemComponentFactories(ItemComponentFactoryRegistry registry) {
        registry.register(ModItems.LIVID_SHADOW, SHADOW_OWNER, ShadowOwner::new);
    }


    @Override
    public ServerPlayerEntity getOwner() {
        if(!(this.hasTag("owner"))) this.setOwner(null);
        return getServer().getPlayerManager().getPlayer(this.getUuid("owner"));
    }

    @Override
    public void setOwner(ServerPlayerEntity entity) {
        this.putUuid("owner", entity.getUuid());
    }


}
