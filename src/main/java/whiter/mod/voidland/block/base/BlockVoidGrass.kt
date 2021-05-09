package whiter.mod.voidland.block.base

import net.minecraft.block.BlockTallGrass
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.stats.StatList
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import whiter.mod.voidland.BlockBaseWithItem
import whiter.mod.voidland.annotation.RegisterBlock

@RegisterBlock(name = "")
class BlockVoidGrass : BlockBaseWithItem(Material.GRASS, "void_grass") {
    init {
        this.setTickRandomly(true);
        //        val  aabb: AxisAlignedBB = AxisAlignedBB()
        //this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.5F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.PLANT);
    }
}