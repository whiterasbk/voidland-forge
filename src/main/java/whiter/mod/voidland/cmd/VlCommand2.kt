package whiter.mod.voidland.cmd

import net.minecraft.command.ICommandSender
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.TextComponentString
import whiter.mod.voidland.VlCommandBase

class VlCommand2 : VlCommandBase("testcmd") {


    override fun execute(server: MinecraftServer, sender: ICommandSender, args: Array<String>) {
        val a = args[0]
        val b = args[1]
        sender.sendMessage(TextComponentString("testmsg ${a}, ${b}"))
    }

    override fun getUsage(sender: ICommandSender): String {
        return "/testcmd a b"
    }

}