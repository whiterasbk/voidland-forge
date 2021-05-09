package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.util.BlockRenderLayer
import whiter.mod.voidland.BlockBaseWithItem
import whiter.mod.voidland.annotation.RegisterBlock

@RegisterBlock
class BlockSoulSlut : Block(Material.ROCK) {
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