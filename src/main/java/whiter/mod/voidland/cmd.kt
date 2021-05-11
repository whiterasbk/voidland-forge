package whiter.mod.voidland

import net.minecraft.command.CommandBase
import net.minecraftforge.fml.common.event.FMLServerStartingEvent

object cmds {
    val map = mutableMapOf<String, CommandBase>()
    fun initCommands(event: FMLServerStartingEvent) {
        println(map)
        for (each in map) {
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
    }

    override fun getName(): String {
        return command
    }

    fun register(event: FMLServerStartingEvent) {
        vlregister.logger.info("RegisterCommand: ${this.name}")
        event.registerServerCommand(this)
    }
}
