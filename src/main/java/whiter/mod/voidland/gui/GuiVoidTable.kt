package whiter.mod.voidland.gui

import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.ResourceLocation
import whiter.mod.voidland.debug
import whiter.mod.voidland.vl

class GuiVoidTable: GuiScreen() {

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.drawDefaultBackground()

        var gwidth = 96
        var gheight = 128

        gwidth = debug.x
        gheight = debug.y


        val background = ResourceLocation(vl.modid, "textures/gui/void_table_gui.png");
        GlStateManager.color(1f, 1f, 1f, 1f)
        mc.renderEngine.bindTexture(background)
        drawTexturedModalRect(width / 2 - gwidth, height / 2 - gheight, 0, 0, 192, 192)
//        drawTexturedModalRect(width / 2 - gwidth / 2, height - gheight, 0, 0, gwidth, gheight)
    }

    override fun doesGuiPauseGame(): Boolean {
        return false
    }
}