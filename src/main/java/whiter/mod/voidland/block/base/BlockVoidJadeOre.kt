package whiter.mod.voidland.block.base

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.stats.StatList
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import whiter.mod.voidland.annotation.RegisterBlock
import whiter.mod.voidland.items
import java.util.*

/*
* 玉石矿
* */
@RegisterBlock
class BlockVoidJadeOre : Block(Material.ROCK) {
    init {
        this.setTickRandomly(true);
        this.setHardness(1.2F);
        this.setLightOpacity(1);
        this.setLightLevel(0.5F)
        this.setSoundType(SoundType.STONE);
    }

    override fun harvestBlock(worldIn: World, player: EntityPlayer, pos: BlockPos, state: IBlockState, te: TileEntity?, stack: ItemStack) {
        if (!worldIn.isRemote && (stack.item === Items.WOODEN_PICKAXE || stack.item === Items.STONE_PICKAXE || stack.item === Items.IRON_PICKAXE || stack.item === Items.GOLDEN_PICKAXE || stack.item === Items.DIAMOND_PICKAXE)) {
            super.harvestBlock(worldIn, player, pos, state, te, stack)
        } else {
            player.addStat(StatList.getBlockStats(this)!!)
        }
    }
//     todo make with voidjade
    override fun getItemDropped(state: IBlockState, rand: Random, fortune: Int): Item? {
        return items.map["voidland:soul_bottle"]
    }

}