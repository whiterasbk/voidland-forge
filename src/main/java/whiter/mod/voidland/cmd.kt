package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommand
import net.minecraft.command.ICommandSender
import net.minecraft.item.Item
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.TextComponentString
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistryEntry
import whiter.mod.voidland.util.IHasModel

object debug {
    var x = 256
    var y = 256
}

object cmds {
    val map = mutableMapOf<String, VlCommandBase>()

    fun initCommands(event: FMLServerStartingEvent) {

        println("这里是map")
        println(map)
        for (each in map) {
            println("正在初始化命令...")
            println(each)
            //if
            // (each as VlCommandBase) .register(event)
            println(each is VlCommandBase)

            if (each is VlCommandBase) {
                each.register(event)
            }
        }
    }
}

abstract class VlCommandBase(cmdname: String) : CommandBase() {

    var command: String = cmdname

    init {
        cmds.map[cmdname] = this
        println("正在添加命令...${cmds.map}")
    }

    override fun getName(): String {
        return command
    }

    fun register(event: FMLServerStartingEvent) {
        println(this)
        println("这回输中文")
        event.registerServerCommand(this)
    }
}
