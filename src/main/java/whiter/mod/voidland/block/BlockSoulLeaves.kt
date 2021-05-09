package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.stats.StatList
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import whiter.mod.voidland.annotation.RegisterBlock

/*聚魂叶
*
* */
@RegisterBlock
class BlockSoulLeaves : Block(Material.LEAVES) {
    init {
        this.setTickRandomly(true);
        //this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setLightLevel(0.5F)
        this.setSoundType(SoundType.PLANT);
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
    override fun harvestBlock(worldIn: World, player: EntityPlayer, pos: BlockPos, state: IBlockState, te: TileEntity?, stack: ItemStack) {
        if (!worldIn.isRemote && stack.item === Items.SHEARS) {
            super.harvestBlock(worldIn, player, pos, state, te, stack)
        } else {
            player.addStat(StatList.getBlockStats(this)!!)
        }
    }
}