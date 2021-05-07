package whiter.mod.voidland

import net.minecraft.command.CommandBase
import net.minecraftforge.fml.common.event.FMLServerStartingEvent

object debug {
    var x = 128
    var y = 192
}

object cmds {
    val map = mutableMapOf<String, CommandBase>()

    fun initCommands(event: FMLServerStartingEvent) {

        println("这里是map")
        println(map)
        for (each in map) {
            println("正在初始化命令...")
            println(each)
            //if
            // (each as VlCommandBase) .register(event)

            println(each is VlCommandBase)

            if (each.value is VlCommandBase) {
                (each.value as VlCommandBase).register(event)
            }
        }
    }
}

abstract class VlCommandBase(cmdname: String) : CommandBase() {

    var command: String = cmdname

    init {
        cmds.map[cmdname] = this
//        println("正在添加命令...${cmds.map}")
    }

    override fun getName(): String {
        return command
    }

    fun register(event: FMLServerStartingEvent) {
//        println(this)
//        println("这回输中文")
        event.registerServerCommand(this)
    }
}
