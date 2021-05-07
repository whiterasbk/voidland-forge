package whiter.mod.voidland.block

import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IInteractionObject
import net.minecraft.world.World
import whiter.mod.voidland.BlockBaseWithItem
import whiter.mod.voidland.gui.GuiSample
import whiter.mod.voidland.gui.GuiVoidTable
import whiter.mod.voidland.guids
import whiter.mod.voidland.vl

class BlockVoidTable : BlockBaseWithItem(Material.ROCK, "void_table") {
    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    override fun getBlockLayer(): BlockRenderLayer {
        return BlockRenderLayer.TRANSLUCENT
    }
    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        //用来控制玩家右击方块时做什么，是的这是一个重要方法
        // playerIn.displayGui((IInteractionObject)worldIn.getTileEntity);//打开机器的GUI，如果它真的可交互的话
        playerIn.openGui(vl.mod, guids.void_table.ordinal, worldIn, playerIn.posX.toInt(), playerIn.posY.toInt(), playerIn.posZ.toInt())
        return true
    }
}