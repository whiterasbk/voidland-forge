package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import whiter.mod.voidland.annotation.RegisterBlock

/*
* 定向魂魄收集器-无核心
* */
@RegisterBlock
class BlockSoulCounterNocore : Block(Material.ROCK) {

    protected val AABB_BOTTOM_HALF = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.5, 1.0)
    protected val AABB_TOP_HALF = AxisAlignedBB(0.0, 1.5, 0.0, 1.0, 1.0, 1.0)

    init {
        this.setTickRandomly(true);
        this.setHardness(0.5F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.METAL);
    }

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return AABB_BOTTOM_HALF
    }

    fun isDouble(): Boolean {
        return false
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