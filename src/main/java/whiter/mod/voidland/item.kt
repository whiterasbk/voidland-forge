package whiter.mod.voidland

import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
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

class ItemBase(@Nonnull name: String) : Item(), IHasModel {
    init {
        unlocalizedName = vl.modid + "." + name
        setRegistryName(name)
        setCreativeTab(blocks.creativeTab)
        items.data.add(this)
    }
}


