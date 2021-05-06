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
import whiter.mod.voidland.gui.GuiSample


enum class guids {
    soul_conunter,
    sample
}


class GUIHandler : IGuiHandler {

    override fun getServerGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        return null
    }

    override fun getClientGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        return if (ID == guids.sample.ordinal) {
            GuiSample()
        } else {
            null
        }
    }

}

open class SampleGUI : GuiScreen()