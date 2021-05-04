package whiter.mod.voidland

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item.getItemFromBlock
import net.minecraft.item.ItemStack
import net.minecraft.world.DimensionType
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly


object vl {
    const val modid = "voidland"
    const val name = "无主之地"
    const val version = "1.0"
    const val acceptedMinecraftVersions = "[1.12, 1.13)"
    const val dependencies = "required-after:forgelin"
    lateinit var dimType: DimensionType
    val mod = Voidland.insatnce
    var dimID = 141
}

class CreativeTab internal constructor() : CreativeTabs("voidland") {

    @SideOnly(Side.CLIENT)
    override fun getTabIconItem(): ItemStack {
        return ItemStack(getItemFromBlock(blocks.map["sampel_block"]), 1)
    }

}
