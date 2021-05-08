package whiter.mod.voidland.block.base

import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import whiter.mod.voidland.BlockBaseWithItem

class BlockVoidGrass : BlockBaseWithItem(Material.GRASS, "void_grass") {
    override fun isFullCube(state: IBlockState): Boolean {
        return true
    }

    override fun isOpaqueCube(state: IBlockState): Boolean {
        return true
    }
}