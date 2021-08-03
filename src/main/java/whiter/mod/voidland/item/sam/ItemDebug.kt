package whiter.mod.voidland.item.sam

import net.minecraft.block.BlockContainer
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.Item
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World
import net.minecraftforge.server.command.TextComponentHelper
import whiter.mod.voidland.annotation.RegisterItem
import whiter.mod.voidland.guids
import whiter.mod.voidland.vl

@RegisterItem(name = "debug_item")
class ItemDebug: Item() {

//    lateinit var player: EntityPlayer
//    lateinit var world: World
//    lateinit var pos: World
//    lateinit var side: World
    override fun onItemUseFirst(player: EntityPlayer, world: World, pos: BlockPos, side: EnumFacing, hitX: Float, hitY: Float, hitZ: Float, hand: EnumHand): EnumActionResult {

    val tc = TextComponentString("pos: $pos")
    player.sendMessage(tc)

    // test void table gui
    player.openGui(vl.mod, guids.demo.ordinal, world, player.posX.toInt(), player.posY.toInt(), player.posZ.toInt())
    println("####"+(BlockContainer is Block))
    return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand)
    }
}

