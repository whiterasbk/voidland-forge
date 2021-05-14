package whiter.mod.voidland.util

import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistryEntry

object util {
    fun name2_Case(str: String): String {
        val a = StringBuffer()
        for(i in str) {
            if (i in 'A'..'Z') {
                a.append("_").append(i.toString().toLowerCase())
            } else {
                a.append(i)
            }
        }

        val r = a.toString()
        return if (r.startsWith("_")) {
            r.replaceFirst("_", "")
        } else {
            r
        }
    }

    fun clipBIstr(str: String, prefix: String): String {
        return if (str.startsWith(prefix)) {
            name2_Case(str.substring(prefix.length))
        } else {
            name2_Case(str)
        }
    }

    fun initModel(bori: IForgeRegistryEntry.Impl<*>, event: ModelRegistryEvent) {
        if (bori is Item)
            ModelLoader.setCustomModelResourceLocation(bori, 0,
                    ModelResourceLocation((bori).registryName!!, "inventory"))
        else if (bori is Block)
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(bori), 0,
                    ModelResourceLocation((bori).registryName!!, "inventory"))
        else
            throw IllegalArgumentException("Unable to register model")
    }
}

interface IHasModel {

    @SideOnly(Side.CLIENT)
    fun initModel(e: ModelRegistryEvent) {
        if (this is Item)
            ModelLoader.setCustomModelResourceLocation(this as Item, 0,
                    ModelResourceLocation((this as IForgeRegistryEntry<*>).registryName!!, "inventory"))
        else if (this is Block)
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this as Block), 0,
                    ModelResourceLocation((this as IForgeRegistryEntry<*>).registryName!!, "inventory"))
        else
            throw IllegalArgumentException("Unable to register model")
    }

}



