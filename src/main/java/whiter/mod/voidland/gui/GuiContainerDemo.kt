package whiter.mod.voidland.gui

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.inventory.Container
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
class GuiContainerDemo(container: Container): GuiContainer(container) {
    override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {

    }

    override fun drawGuiContainerForegroundLayer(mouseX: Int, mouseY: Int) {
        // TODO
    }
}