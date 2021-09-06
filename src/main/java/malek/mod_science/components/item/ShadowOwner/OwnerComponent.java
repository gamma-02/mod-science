package malek.mod_science.components.item.ShadowOwner;

import dev.onyxstudios.cca.api.v3.component.Component;
import net.minecraft.server.network.ServerPlayerEntity;

public interface OwnerComponent extends Component{
    ServerPlayerEntity getOwner();
    void setOwner(ServerPlayerEntity entity);
}
