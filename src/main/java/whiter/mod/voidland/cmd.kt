package whiter.mod.voidland

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.TextComponentString

object debug {
    var x = 256
    var y = 256
}

class VlCommand : CommandBase() {
    override fun execute(server: MinecraftServer, sender: ICommandSender, args: Array<String>) {

        if (args.size < 2) {
            sender.sendMessage(TextComponentString("no update ${debug.x}, ${debug.y}"))
            return
        }

        debug.x = args[0].toInt()
        debug.y = args[1].toInt()

        sender.sendMessage(TextComponentString("update ${debug.x}, ${debug.y}"));
    }

    override fun getUsage(sender: ICommandSender): String {
        return "/vlddebug x y"
    }

    override fun getName(): String {
        return "vlddebug"
    }

}