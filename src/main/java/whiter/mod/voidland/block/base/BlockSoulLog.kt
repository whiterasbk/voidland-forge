package whiter.mod.voidland.block.base

import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import whiter.mod.voidland.BlockBaseWithItem

class BlockSoulLog : BlockBaseWithItem(Material.WOOD, "soul_log") {
    init {
        this.setTickRandomly(true);
        //this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(1.15F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.WOOD);
    }
}