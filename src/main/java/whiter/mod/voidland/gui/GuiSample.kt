package whiter.mod.voidland.gui

import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.ResourceLocation
import whiter.mod.voidland.debug
import whiter.mod.voidland.vl
import java.io.IOException

class GuiSample : GuiScreen() {

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.drawDefaultBackground()

        var gwidth = 256
        var gheight = 256

        gwidth = debug.x
        gheight = debug.y


        val background = ResourceLocation(vl.modid, "textures/gui/testpic1.png");
        GlStateManager.color(1f, 1f, 1f, 1f)
        mc.renderEngine.bindTexture(background)
        drawTexturedModalRect(width / 2 - gwidth / 2, height - gheight, 0, 0, gwidth, gheight)

    }

    @Throws(IOException::class)
    override fun mouseClicked(mouseX: Int, mouseY: Int, mouseButton: Int) {
        super.mouseClicked(mouseX, mouseY, mouseButton)

    }

    override fun doesGuiPauseGame(): Boolean {
        return false
    }
}