package whiter.mod.voidland.block.base

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import whiter.mod.voidland.annotation.RegisterBlock

/*
* 聚魂原木
* */
@RegisterBlock
class BlockSoulLog : Block(Material.WOOD) {
    init {
        this.setTickRandomly(true);
        //this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(1.15F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.WOOD);
    }
}