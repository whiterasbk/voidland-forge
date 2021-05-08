package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import whiter.mod.voidland.util.IHasModel
import javax.annotation.Nonnull


/**
 * blocks open classes
 */
object blocks {
//    val data = arrayListOf<Block>()
    val map = mutableMapOf<String, Block>()
    val creativeTab = CreativeTab()

    @SideOnly(Side.CLIENT)
    fun initModels(event: ModelRegistryEvent) {
        for (each in map) {
            if (each.value is IHasModel) {
                (each.value as IHasModel).initModel(event)
            }
        }
    }

    fun register(event: RegistryEvent.Register<Block>) {
        for (each in map) {
            event.registry.register(each.value)
        }
    }
}

open class BlockBase(mat: Material, @Nonnull name: String) : Block(mat), IHasModel {
    init {
        unlocalizedName = vl.modid + "." + name
        setRegistryName(name)
        setCreativeTab(blocks.creativeTab)

        // todo reduce map and data
        blocks.map[name] = this
//        blocks.data.add(this)

    }
}

open class BlockBaseWithItem(mat: Material, @Nonnull name: String) : BlockBase(mat, name) {
    var item: ItemBlock = ItemBlockBase(this)
}



