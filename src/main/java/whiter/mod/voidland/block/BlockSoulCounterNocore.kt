package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.util.BlockRenderLayer
import whiter.mod.voidland.annotation.RegisterBlock

/*
* 定向魂魄收集器-无核心
* */
@RegisterBlock
class BlockSoulCounterNocore : Block(Material.ROCK) {
    init {
        this.setTickRandomly(true);
        this.setHardness(0.5F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.METAL);
    }

    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    override fun getBlockLayer(): BlockRenderLayer {
        return BlockRenderLayer.TRANSLUCENT
    }
}