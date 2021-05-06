package whiter.mod.voidland.item

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumHand
import net.minecraft.world.World
import whiter.mod.voidland.ItemBase
import whiter.mod.voidland.guids
import whiter.mod.voidland.vl


class ItemSample : ItemBase("sample_item") {
    override fun onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {

        println(233)

        // teleport


        playerIn.openGui(vl.mod, guids.sample.ordinal, worldIn, playerIn.posX.toInt(), playerIn.posY.toInt(), playerIn.posZ.toInt())


        if (!worldIn.isRemote && playerIn is EntityPlayerMP) {

//            val ws = FMLCommonHandler.instance().minecraftServerInstance.getWorld(vl.dimID)
//            val plist = FMLCommonHandler.instance().minecraftServerInstance.playerList
//            plist.transferPlayerToDimension(playerIn, vl.dimID, Teleporter(ws))
        }


        return super.onItemRightClick(worldIn, playerIn, handIn)
    }
}




