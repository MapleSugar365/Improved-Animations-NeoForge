package einstein.improved_animations.core.neoforge;

import einstein.improved_animations.ImprovedAnimations;
import einstein.improved_animations.util.data.TimelineGroupDataLoader;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(ImprovedAnimations.MOD_ID)
public class ImprovedAnimationsNeoForge {

    public ImprovedAnimationsNeoForge(IEventBus modEventBus) {
        // modEventBus.register(this);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::onRegisterClientReloadListeners);
    }

    @OnlyIn(Dist.CLIENT)
    void clientSetup(FMLClientSetupEvent event) {
        ImprovedAnimations.onClientInit();
    }

    @OnlyIn(Dist.CLIENT)
    void onRegisterClientReloadListeners(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new TimelineGroupDataLoader());
    }
}
