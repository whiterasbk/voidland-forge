package whiter.mod.voidland.event;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import whiter.mod.voidland.vl;

/**
 * @author whiter
 */
@Mod.EventBusSubscriber(modid = vl.modid)

public class JavaHandler {

    @SubscribeEvent
    public static void onPickUp(PlayerEvent.ItemPickupEvent event) {
        KtHandler.onItemPickup(event);
    }
}
