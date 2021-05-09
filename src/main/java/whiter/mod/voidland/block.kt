package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemBlock
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.apache.logging.log4j.Logger
import whiter.mod.voidland.util.IHasModel
import whiter.mod.voidland.util.util
import javax.annotation.Nonnull


/**
 * blocks open classes
 */

enum class VlCreativeTabs {
    voidland_defaut;

    fun get(): CreativeTabs {
        if (this == voidland_defaut) {
            return vl.creative_tab
        }

        return vl.creative_tab
    }
}

object blocks {
//    val data = arrayListOf<Block>()
    val map = mutableMapOf<String, Block>()
    val tobeInitModel = mutableMapOf<String, Block>()
    lateinit var logger: Logger


    @SideOnly(Side.CLIENT)
    fun initModels(event: ModelRegistryEvent) {
        for (each in tobeInitModel) {
            util.initModel(each.value, event)
        }
    }

    fun register(event: RegistryEvent.Register<Block>) {
        for (each in map) {
            event.registry.register(each.value)
            logger.info("Voidland onRegisterBlock: ${each.value.registryName}")
        }
    }
}

open class BlockBase(mat: Material, @Nonnull name: String) : Block(mat), IHasModel {
    init {
        unlocalizedName = vl.modid + "." + name
        setRegistryName(name)
        setCreativeTab(vl.creative_tab)

        blocks.map[name] = this
    }
}

open class BlockBaseWithItem(mat: Material, @Nonnull name: String) : BlockBase(mat, name) {
    var item: ItemBlock = ItemBlockBase(this)
}



