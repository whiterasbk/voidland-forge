package whiter.mod.voidland.block.sam

import net.minecraft.block.Block
import net.minecraft.block.BlockBush
import net.minecraft.block.BlockTallGrass
import net.minecraft.block.IGrowable
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.common.IShearable
import whiter.mod.voidland.annotation.RegisterBlock
import java.util.*

@RegisterBlock
class BlockSampleGrass : BlockBush(), IGrowable, IShearable {
    override fun canUseBonemeal(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState): Boolean {
        return true
    }

    override fun grow(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState) {

    }

    override fun canGrow(worldIn: World, pos: BlockPos, state: IBlockState, isClient: Boolean): Boolean {
        return true
    }

    /**
     * Performs the shear function on this object.
     * This is called for both client, and server.
     * The object should perform all actions related to being sheared,
     * except for dropping of the items, and removal of the block.
     * As those are handled by ItemShears itself.
     *
     * Returns a list of items that resulted from the shearing process.
     *
     * For entities, they should trust there internal location information
     * over the values passed into this function.
     *
     * @param item The ItemStack that is being used, may be empty.
     * @param world The current world.
     * @param pos If this is a block, the block's position in world.
     * @param fortune The fortune level of the shears being used.
     * @return A List containing all items from this shearing. May be empty.
     */
    override fun onSheared(item: ItemStack, world: IBlockAccess?, pos: BlockPos?, fortune: Int): MutableList<ItemStack> {
        return NonNullList.withSize(1, ItemStack(Blocks.TALLGRASS, 1, (world?.getBlockState(pos)?.getValue<BlockTallGrass.EnumType>(TYPE) as BlockTallGrass.EnumType).meta))

    }

    /**
     * Checks if the object is currently shearable
     * Example: Sheep return false when they have no wool
     *
     * @param item The ItemStack that is being used, may be empty.
     * @param world The current world.
     * @param pos Block's position in world.
     * @return If this is shearable, and onSheared should be called.
     */
    override fun isShearable(item: ItemStack, world: IBlockAccess?, pos: BlockPos?): Boolean {
        return true
    }

    val TYPE: PropertyEnum<BlockTallGrass.EnumType> = PropertyEnum.create("type", BlockTallGrass.EnumType::class.java)
    private val TALL_GRASS_AABB = AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421)

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return TALL_GRASS_AABB
    }

}