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
    val map = mutableMapOf<String, Item>()


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









open class ItemBase(@Nonnull name: String) : Item(), IHasModel {
    init {
        unlocalizedName = vl.modid + "." + name
        setRegistryName(name)
        setCreativeTab(blocks.creativeTab)

        // todo reduce data and map
        items.data.add(this)
        items.map[name] = this
    }
}

class ItemBlockBase(@Nonnull block: Block) : ItemBlock(block), IHasModel {
    init {
        registryName = block.registryName
        items.data.add(this)
    }
}



