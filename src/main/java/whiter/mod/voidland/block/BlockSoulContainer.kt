package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyInteger
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import whiter.mod.voidland.annotation.RegisterBlock
/*
* 魂魄容器
* */
@RegisterBlock
class BlockSoulContainer : Block(Material.ROCK) {
    val LEVEL = PropertyInteger.create("level", 0, 3)
    protected val AABB_LEGS = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0)
    protected val AABB_WALL_NORTH = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.125)
    protected val AABB_WALL_SOUTH = AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 1.0, 1.0)
    protected val AABB_WALL_EAST = AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 1.0, 1.0)
    protected val AABB_WALL_WEST = AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 1.0, 1.0)
   init {
       this.tickRandomly = true
       this.setHardness(0.5F)
       this.setLightOpacity(1)
       this.setLightLevel(0F)
       this.soundType = SoundType.METAL
    }

    override fun addCollisionBoxToList(state: IBlockState, worldIn: World, pos: BlockPos, entityBox: AxisAlignedBB, collidingBoxes: List<AxisAlignedBB>, entityIn: Entity?, isActualState: Boolean) {
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_LEGS)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_WEST)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_NORTH)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_EAST)
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_SOUTH)
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

