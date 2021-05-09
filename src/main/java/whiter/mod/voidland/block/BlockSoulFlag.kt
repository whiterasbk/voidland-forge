package whiter.mod.voidland.block

import com.sun.org.apache.xpath.internal.operations.Bool
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import whiter.mod.voidland.BlockBaseWithItem
import whiter.mod.voidland.annotation.RegisterBlock

@RegisterBlock
class BlockSoulFlag : Block(Material.ROCK) {
    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    override fun getBlockLayer(): BlockRenderLayer {
        return BlockRenderLayer.TRANSLUCENT
    }
    override fun isPassable(worldIn: IBlockAccess, pos: BlockPos): Boolean {
        return false;
    }
}