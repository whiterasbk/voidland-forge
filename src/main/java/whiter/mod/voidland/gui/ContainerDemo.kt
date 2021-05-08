package whiter.mod.voidland.gui

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.Container

class ContainerDemo(): Container() {
    override fun canInteractWith(playerIn: EntityPlayer): Boolean {
        return true
    }
}