package whiter.mod.voidland.block.base

import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import whiter.mod.voidland.BlockBaseWithItem

class BlockSoulBoard : BlockBaseWithItem(Material.WOOD, "soul_board") {
    init {
        this.setTickRandomly(true);
        //this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.6F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.WOOD);
    }
}