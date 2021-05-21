package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.EnumParticleTypes
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.ITextComponent
import net.minecraft.world.World
import net.minecraftforge.common.ForgeHooks
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.server.permission.context.BlockPosContext
import whiter.mod.voidland.Voidland
import whiter.mod.voidland.annotation.RegisterBlock
import whiter.mod.voidland.blocks
import whiter.mod.voidland.guids
import whiter.mod.voidland.vl
import java.util.*

/*
* 灵魂槽
* */
@RegisterBlock
class BlockSoulSlut : Block(Material.ROCK) {
    init {
        this.setTickRandomly(true);
        this.setHardness(0.5F);
        this.setLightOpacity(1);
        this.setLightLevel(0F)
        this.setSoundType(SoundType.METAL);
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

    fun getSlutBonus(world: World, pos: BlockPos): Float {
        return (if (blocks.map["voidland:soul_slut"]?.equals(this)!!) 1 else 0).toFloat()
    }

    @SideOnly(Side.CLIENT)
    override fun randomDisplayTick(stateIn: IBlockState, worldIn: World, pos: BlockPos, rand: Random) {
        super.randomDisplayTick(stateIn, worldIn, pos, rand)

        for (i in -2..2) {
            var j = -2
            while (j <= 2) {
                if (i > -2 && i < 2 && j == -1) {
                    j = 2
                }

                if (rand.nextInt(8) == 0) {
                    for (k in 0..1) {
                        val blockpos = pos.add(0, 1, 0)
                        if (getSlutBonus(worldIn, blockpos) > 0.0f) {
                            if (!worldIn.isAirBlock(pos.add(i / 2, 0, j / 2))) {
                                break
                                this.setLightLevel(0F)
                            }
                            pos.add(i,k,j)
                            this.setLightLevel(0.5F)
                            worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.x.toDouble() + 0.5, pos.y.toDouble() + 2.0, pos.z.toDouble() + 0.5, (i.toFloat() + rand.nextFloat()).toDouble() - 0.5, (k.toFloat() - rand.nextFloat() - 1.0f).toDouble(), (j.toFloat() + rand.nextFloat()).toDouble() - 0.5, *IntArray(0))
                        }
                    }
                }
                ++j
            }
        }

    }
    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        val blockpos = pos.add(0, 1, 0)
        worldIn.spawnParticle(EnumParticleTypes.FLAME,pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(),0.0,0.0,0.0)
        return true
    }
}