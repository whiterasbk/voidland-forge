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
import kotlinx.coroutines.awaitAll
import net.minecraftforge.fml.common.network.NetworkRegistry
import whiter.mod.voidland.gui.ContainerDemo
import whiter.mod.voidland.gui.GuiContainerDemo
import whiter.mod.voidland.gui.GuiSample
import whiter.mod.voidland.gui.GuiVoidTable


enum class guids {
    soul_conunter,
    sample,
    void_table,
    demo
}


class GUIHandler : IGuiHandler {

    override fun getServerGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        return when (ID) {
            // guids.demo.ordinal -> ContainerDemo()
            else -> null
        }
    }

    override fun getClientGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        return when (ID) {
            guids.sample.ordinal -> GuiSample()
            guids.void_table.ordinal -> GuiVoidTable()
            // guids.demo.ordinal -> GuiContainerDemo(ContainerDemo())
            else -> null
        }
    }

}

open class SampleGUI : GuiScreen()