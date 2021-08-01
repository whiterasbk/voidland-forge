package whiter.mod.voidland.block.base

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import whiter.mod.voidland.annotation.RegisterBlock

/*
* 滞魂木板
* */
@RegisterBlock
class BlockVoidBoard : Block(Material.WOOD) {
    init {
        this.setTickRandomly(true);
        //this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(1.3F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.WOOD);
    }
}