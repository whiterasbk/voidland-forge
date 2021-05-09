package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.util.BlockRenderLayer
import whiter.mod.voidland.annotation.RegisterBlock

/*
* 定向魂魄收集器
* */
@RegisterBlock
class BlockSoulCounter : Block(Material.ROCK) {
    init {
        this.tickRandomly = true
        this.setHardness(0.5F)
        this.setLightOpacity(1)
        this.setLightLevel(0F)
        this.soundType = SoundType.METAL
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