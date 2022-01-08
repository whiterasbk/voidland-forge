@file:JvmMultifileClass
@file:JvmName("KtHandler")
package whiter.mod.voidland.event

import net.minecraft.util.text.TextComponentString
import net.minecraftforge.fml.common.gameevent.PlayerEvent

fun onItemPickup(event: PlayerEvent.ItemPickupEvent) {
    event.player.sendMessage(TextComponentString(">kt>$event>>e"))
}