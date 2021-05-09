package whiter.mod.voidland.block


import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import whiter.mod.voidland.annotation.RegisterBlock
import whiter.mod.voidland.guids
import whiter.mod.voidland.vl

/*
* 万象台
* */
@RegisterBlock
class BlockVoidTable : Block(Material.ROCK) {
    init {
        tickRandomly = true
        setHardness(0.5F)
        setLightOpacity(1)
        setLightLevel(0F)
        soundType = SoundType.METAL
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

    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        //用来控制玩家右击方块时做什么，是的这是一个重要方法
        // playerIn.displayGui((IInteractionObject)worldIn.getTileEntity);//打开机器的GUI，如果它真的可交互的话
        playerIn.openGui(vl.mod, guids.void_table.ordinal, worldIn, playerIn.posX.toInt(), playerIn.posY.toInt(), playerIn.posZ.toInt())
        return true
    }
}