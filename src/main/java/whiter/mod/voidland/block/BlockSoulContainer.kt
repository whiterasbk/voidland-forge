package whiter.mod.voidland.block

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyInteger
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.init.Items
import net.minecraft.init.PotionTypes
import net.minecraft.init.SoundEvents
import net.minecraft.item.ItemArmor
import net.minecraft.item.ItemBanner
import net.minecraft.item.ItemStack
import net.minecraft.potion.PotionUtils
import net.minecraft.stats.StatList
import net.minecraft.tileentity.TileEntityBanner
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.SoundCategory
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
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

    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        val itemstack = playerIn.getHeldItem(hand)

        if (itemstack.isEmpty) {
            return true
        } else {
            val i = (state.getValue(LEVEL) as Int).toInt()
            val item = itemstack.item

            if (item === Items.WATER_BUCKET) {
                if (i < 3 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        playerIn.setHeldItem(hand, ItemStack(Items.BUCKET))
                    }

                    playerIn.addStat(StatList.CAULDRON_FILLED)
                    this.setWaterLevel(worldIn, pos, state, 3)
                    worldIn.playSound(null as EntityPlayer?, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f)
                }

                return true
            } else if (item === Items.BUCKET) {
                if (i == 3 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        itemstack.shrink(1)

                        if (itemstack.isEmpty) {
                            playerIn.setHeldItem(hand, ItemStack(Items.WATER_BUCKET))
                        } else if (!playerIn.inventory.addItemStackToInventory(ItemStack(Items.WATER_BUCKET))) {
                            playerIn.dropItem(ItemStack(Items.WATER_BUCKET), false)
                        }
                    }

                    playerIn.addStat(StatList.CAULDRON_USED)
                    this.setWaterLevel(worldIn, pos, state, 0)
                    worldIn.playSound(null as EntityPlayer?, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f)
                }

                return true
            } else if (item === Items.GLASS_BOTTLE) {
                if (i > 0 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        val itemstack3 = PotionUtils.addPotionToItemStack(ItemStack(Items.POTIONITEM), PotionTypes.WATER)
                        playerIn.addStat(StatList.CAULDRON_USED)
                        itemstack.shrink(1)

                        if (itemstack.isEmpty) {
                            playerIn.setHeldItem(hand, itemstack3)
                        } else if (!playerIn.inventory.addItemStackToInventory(itemstack3)) {
                            playerIn.dropItem(itemstack3, false)
                        } else if (playerIn is EntityPlayerMP) {
                            playerIn.sendContainerToPlayer(playerIn.inventoryContainer)
                        }
                    }

                    worldIn.playSound(null as EntityPlayer?, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f)
                    this.setWaterLevel(worldIn, pos, state, i - 1)
                }

                return true
            } else if (item === Items.POTIONITEM && PotionUtils.getPotionFromItem(itemstack) === PotionTypes.WATER) {
                if (i < 3 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        val itemstack2 = ItemStack(Items.GLASS_BOTTLE)
                        playerIn.addStat(StatList.CAULDRON_USED)
                        playerIn.setHeldItem(hand, itemstack2)

                        if (playerIn is EntityPlayerMP) {
                            playerIn.sendContainerToPlayer(playerIn.inventoryContainer)
                        }
                    }

                    worldIn.playSound(null as EntityPlayer?, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f)
                    this.setWaterLevel(worldIn, pos, state, i + 1)
                }

                return true
            } else {
                if (i > 0 && item is ItemArmor) {

                    if (item.armorMaterial == ItemArmor.ArmorMaterial.LEATHER && item.hasColor(itemstack) && !worldIn.isRemote) {
                        item.removeColor(itemstack)
                        this.setWaterLevel(worldIn, pos, state, i - 1)
                        playerIn.addStat(StatList.ARMOR_CLEANED)
                        return true
                    }
                }

                if (i > 0 && item is ItemBanner) {
                    if (TileEntityBanner.getPatterns(itemstack) > 0 && !worldIn.isRemote) {
                        val itemstack1 = itemstack.copy()
                        itemstack1.count = 1
                        TileEntityBanner.removeBannerData(itemstack1)
                        playerIn.addStat(StatList.BANNER_CLEANED)

                        if (!playerIn.capabilities.isCreativeMode) {
                            itemstack.shrink(1)
                            this.setWaterLevel(worldIn, pos, state, i - 1)
                        }

                        if (itemstack.isEmpty) {
                            playerIn.setHeldItem(hand, itemstack1)
                        } else if (!playerIn.inventory.addItemStackToInventory(itemstack1)) {
                            playerIn.dropItem(itemstack1, false)
                        } else if (playerIn is EntityPlayerMP) {
                            playerIn.sendContainerToPlayer(playerIn.inventoryContainer)
                        }
                    }

                    return true
                } else {
                    return false
                }
            }
        }
    }

    fun setWaterLevel(worldIn: World, pos: BlockPos, state: IBlockState, level: Int) {
        worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp(level, 0, 3))!!), 2)
        worldIn.updateComparatorOutputLevel(pos, this)
    }

    override fun fillWithRain(worldIn: World, pos: BlockPos) {
        if (worldIn.rand.nextInt(20) == 1) {
            val f = worldIn.getBiome(pos).getTemperature(pos)

            if (worldIn.biomeProvider.getTemperatureAtHeight(f, pos.y) >= 0.15f) {
                val iblockstate = worldIn.getBlockState(pos)

                if ((iblockstate.getValue(LEVEL) as Int).toInt() < 3) {
                    worldIn.setBlockState(pos, iblockstate.cycleProperty(LEVEL), 2)
                }
            }
        }
    }

    override fun getBlockLayer(): BlockRenderLayer {
        return BlockRenderLayer.TRANSLUCENT
    }
}

