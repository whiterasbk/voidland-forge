package whiter.mod.voidland.block.base

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import whiter.mod.voidland.annotation.RegisterBlock

/*
* 滞魂草方块
* */
@RegisterBlock
class BlockVoidGrass : Block(Material.GRASS) {
    init {
//         val  aabb: AxisAlignedBB = AxisAlignedBB()
        this.setTickRandomly(true);
        //        val  aabb: AxisAlignedBB = AxisAlignedBB()
        //this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.5F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.PLANT);
    }
}