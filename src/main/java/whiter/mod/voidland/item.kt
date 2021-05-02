package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumHand
import net.minecraft.world.Teleporter
import net.minecraft.world.World
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import whiter.mod.voidland.util.IHasModel
import javax.annotation.Nonnull


object items {
    val data = arrayListOf<Item>()

    @SideOnly(Side.CLIENT)
    fun initModels(event: ModelRegistryEvent) {
        for (item in data) {
            if (item is IHasModel) {
                (item as IHasModel).initModel(event)
            }
        }
    }

    fun register(event: RegistryEvent.Register<Item>) {
        for (item in data) {
            event.registry.register(item)
        }
    }
}







class ItemSample : ItemBase("sample_item"){
    override fun onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {

        println(233)

        // teleport


        playerIn.openGui(vl.mod, )


        if (!worldIn.isRemote && playerIn is EntityPlayerMP) {

//            val ws = FMLCommonHandler.instance().minecraftServerInstance.getWorld(vl.dimID)
//            val plist = FMLCommonHandler.instance().minecraftServerInstance.playerList
//            plist.transferPlayerToDimension(playerIn, vl.dimID, Teleporter(ws))
        }


        return super.onItemRightClick(worldIn, playerIn, handIn)
    }
}











open class ItemBase(@Nonnull name: String) : Item(), IHasModel {
    init {
        unlocalizedName = vl.modid + "." + name
        setRegistryName(name)
        setCreativeTab(blocks.creativeTab)
        items.data.add(this)
    }
}

class ItemBlockBase(@Nonnull block: Block) : ItemBlock(block), IHasModel {
    init {
        registryName = block.registryName
        items.data.add(this)
    }
}



