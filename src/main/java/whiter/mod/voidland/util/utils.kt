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

interface IHasItem {

}


