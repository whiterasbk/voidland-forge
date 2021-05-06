package whiter.mod.voidland.block

import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.BlockRenderLayer
import whiter.mod.voidland.BlockBaseWithItem
import whiter.mod.voidland.blocks

class BlockSample : BlockBaseWithItem(Material.ROCK, "block_sieve") {

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