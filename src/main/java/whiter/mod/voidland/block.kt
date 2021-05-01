package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.item.ItemBlock
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import whiter.mod.voidland.util.IHasItem
import whiter.mod.voidland.util.IHasModel
import javax.annotation.Nonnull


object blocks {
    val data = arrayListOf<Block>()

    @SideOnly(Side.CLIENT)
    fun initModels(event: ModelRegistryEvent) {
        for (block in data) {
            if (block is IHasModel) {
                (block as IHasModel).initModel(event)
            }
        }
    }

    fun register(event: RegistryEvent.Register<Block>) {
        for (block in data) {
            event.registry.register(block)
        }
    }

//    @SideOnly(Side.CLIENT)
//    fun registerItems(event: RegistryEvent.Register<Item>) {
//        for (block in data) {
//            if (block is IHasItem) {
//                (block as IHasItem).registerItem(event)
//            }
//        }
//    }
}

open class BlockBase(mat: Material, @Nonnull name: String) : Block(mat), IHasModel {
    init {
        unlocalizedName = vl.modid + "." + name
        setRegistryName(name)
        blocks.data.add(this)
    }
}
class BlockBaseWithItem(mat: Material, @Nonnull name: String) : BlockBase(mat, name), IHasItem {
    var item: ItemBlock
    init {
        unlocalizedName = vl.modid + "." + name
        item = ItemBlock(this)
        item.setRegistryName(name)
        items.data.add(item)
        blocks.data.add(this)
    }
}



