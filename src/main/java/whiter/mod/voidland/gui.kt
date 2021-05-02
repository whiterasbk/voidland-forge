package whiter.mod.voidland

import net.minecraft.client.gui.GuiScreen
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler
import java.io.IOException
import net.minecraftforge.fml.client.config.GuiUtils.drawTexturedModalRect
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.ResourceLocation
import sun.audio.AudioPlayer.player
import net.minecraft.util.math.BlockPos
import com.sun.xml.internal.bind.v2.model.core.ID
import net.minecraftforge.fml.common.network.NetworkRegistry


enum class guids {
    soul_conunter,
    sample
}


class GUIHandler : IGuiHandler {

    init {
        NetworkRegistry.INSTANCE.registerGuiHandler(vl.mod, GUIHandler())
    }

    override fun getServerGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        return SampleGUI()
    }

    override fun getClientGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        return if (ID == guids.sample.ordinal) {
            SampleGUI()
        } else {
            SampleGUI()
        }
    }

}

class SampleGUI : GuiScreen() {
    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.drawDefaultBackground()

        val gwidth = 256
        val gheight = 201

        val background = ResourceLocation(vl.modid, "textures/gui/sample.png");
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
