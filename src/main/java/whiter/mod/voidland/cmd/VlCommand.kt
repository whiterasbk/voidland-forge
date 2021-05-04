package whiter.mod.voidland.cmd

import net.minecraft.command.ICommandSender
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.TextComponentString
import whiter.mod.voidland.VlCommandBase
import whiter.mod.voidland.debug

class VlCommand: VlCommandBase("vlddebug") {
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


}
