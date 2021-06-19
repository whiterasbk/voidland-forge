package whiter.mod.voidland.gui

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.inventory.Container
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraft.util.ResourceLocation
import whiter.mod.voidland.vl
import sun.java2d.pipe.hw.AccelSurface.TEXTURE
import net.minecraft.client.renderer.GlStateManager




@SideOnly(Side.CLIENT)
class GuiContainerDemo(container: Container): GuiContainer(container) {

    private val TEXTURE_PATH = vl.modid + ":" + "textures/gui/gui_demo.png"
    private val TEXTURE = ResourceLocation(TEXTURE_PATH)

    init {
        this.xSize = 176
        this.ySize = 256
    }

    override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {

        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f)

        this.mc.textureManager.bindTexture(TEXTURE)
        val offsetX = (this.width - this.xSize) / 2
        val offsetY = (this.height - this.ySize) / 2

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize)

    }

    override fun drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int) {
        // TODO
    }
}