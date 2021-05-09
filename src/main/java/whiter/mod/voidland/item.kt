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
import org.apache.logging.log4j.Logger
import scala.tools.nsc.doc.model.Object
import whiter.mod.voidland.util.IHasModel
import whiter.mod.voidland.util.util
import javax.annotation.Nonnull


object items {
    val tobeInitModel = mutableMapOf<String, Item>()
    val map = mutableMapOf<String, Item>()
    lateinit var logger: Logger

    @SideOnly(Side.CLIENT)
    fun initModels(event: ModelRegistryEvent) {

        for (each in tobeInitModel) {

            util.initModel(each.value, event)
//            if (each.value is IHasModel) {
//                (each.value as IHasModel).initModel(event)
//            }
        }
    }

    fun register(event: RegistryEvent.Register<Item>) {
        for (each in map) {
            event.registry.register(each.value)
            logger.info("Voidland onRegisterItem: ${each.value.registryName}")
        }
    }
}









open class ItemBase(@Nonnull name: String) : Item(), IHasModel {
    init {
        unlocalizedName = vl.modid + "." + name
        setRegistryName(name)
        setCreativeTab(vl.creative_tab)

        // todo reduce data and map
//        items.data.add(this)
        items.map[name] = this
    }
}

class ItemBlockBase(@Nonnull block: Block) : ItemBlock(block), IHasModel {
    init {
        registryName = block.registryName
//        items.data.add(this)
        items.map[registryName.toString()] = this
    }
}



