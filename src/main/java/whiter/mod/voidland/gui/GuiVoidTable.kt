package whiter.mod.voidland.gui

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.client.renderer.GlStateManager
import whiter.mod.voidland.debug
import whiter.mod.voidland.vl
import net.minecraftforge.items.SlotItemHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.Container
import net.minecraftforge.fml.client.config.GuiUtils.drawTexturedModalRect
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.items.ItemStackHandler
import sun.audio.AudioPlayer.player
import net.minecraft.util.ResourceLocation

@SideOnly(Side.CLIENT)
class GuiVoidTable constructor(inventorySlotsIn: Container): GuiContainer(inventorySlotsIn) {
    // private val items = ItemStackHandler(13)

    init {
        // super()



//        for (i in 0..3) {
//            this.addSlotToContainer(SlotItemHandler(items, i, 38 + i * 32, 20))
//        }
//
//        for (i in 0..2) {
//            for (j in 0..8) {
//                this.addSlotToContainer(Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 51 + i * 18))
//            }
//        }
//
//        for (i in 0..8) {
//            this.addSlotToContainer(Slot(player.inventory, i, 8 + i * 18, 109))
//        }
    }

    override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
        // TODO
    }

    override fun drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int) {
        // TODO
    }
    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.drawDefaultBackground()

        var gwidth = 88
        var gheight = 128

        gwidth = debug.x
        gheight = debug.y


        val background = ResourceLocation(vl.modid, "textures/gui/gui_demo.png");
        GlStateManager.color(1f, 1f, 1f, 1f)
        mc.renderEngine.bindTexture(background)
        drawTexturedModalRect(width / 2 - gwidth, height / 2 - gheight, 0, 0, 256, 256)
    }

    override fun doesGuiPauseGame(): Boolean {
        return false
    }
}