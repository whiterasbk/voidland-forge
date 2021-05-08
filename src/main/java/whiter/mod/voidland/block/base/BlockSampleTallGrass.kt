package whiter.mod.voidland.block.base

import net.minecraft.block.*
import java.util.Random
import net.minecraft.block.material.Material
import net.minecraft.block.properties.IProperty
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.stats.StatList
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.IStringSerializable
import net.minecraft.util.NonNullList
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import whiter.mod.voidland.blocks


class BlockSampleTallGrass : BlockTallGrass() {
    init {
        unlocalizedName = "sample_block"
        blocks.map["sample_block"] = this
//        this.setRegistryName("sample_block")

    }
}

/*
class BlockSampleTallGrass protected constructor(): BlockBush(Material.VINE), IGrowable, net.minecraftforge.common.IShearable {

    init {
        this.defaultState = this.blockState.baseState.withProperty(TYPE, EnumType.DEAD_BUSH)

        blocks.map["sample_tall_grass"] = this
    }

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return TALL_GRASS_AABB
    }

    override fun canBlockStay(worldIn: World, pos: BlockPos, state: IBlockState): Boolean {
        return super.canBlockStay(worldIn, pos, state)
    }

    override fun isReplaceable(worldIn: IBlockAccess, pos: BlockPos): Boolean {
        return true
    }

    override fun getItemDropped(state: IBlockState, rand: Random, fortune: Int): Item? {
        return null
    }

    override fun quantityDroppedWithBonus(fortune: Int, random: Random): Int {
        return 1 + random.nextInt(fortune * 2 + 1)
    }

    override fun harvestBlock(worldIn: World, player: EntityPlayer, pos: BlockPos, state: IBlockState, te: TileEntity?, stack: ItemStack) {
        if (!worldIn.isRemote && stack.item === Items.SHEARS) {
            player.addStat(StatList.getBlockStats(this)!!)
            Block.spawnAsEntity(worldIn, pos, ItemStack(Blocks.TALLGRASS, 1, (state.getValue(TYPE) as EnumType).meta))
        } else {
            super.harvestBlock(worldIn, player, pos, state, te, stack)
        }
    }

    override fun getItem(worldIn: World, pos: BlockPos, state: IBlockState): ItemStack {
        return ItemStack(this, 1, state.block.getMetaFromState(state))
    }

    override fun getSubBlocks(itemIn: CreativeTabs, items: NonNullList<ItemStack>) {
        for (i in 1..2) {
            items.add(ItemStack(this, 1, i))
        }
    }

    override fun canGrow(worldIn: World, pos: BlockPos, state: IBlockState, isClient: Boolean): Boolean {
        return state.getValue(TYPE) != EnumType.DEAD_BUSH
    }

    override fun canUseBonemeal(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState): Boolean {
        return true
    }

    override fun grow(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState) {
        var enumPlantType: BlockDoublePlant.EnumPlantType = BlockDoublePlant.EnumPlantType.GRASS

        if (state.getValue(TYPE) == EnumType.FERN) {
            enumPlantType = BlockDoublePlant.EnumPlantType.FERN
        }

        if (Blocks.DOUBLE_PLANT.canPlaceBlockAt(worldIn, pos)) {
            Blocks.DOUBLE_PLANT.placeAt(worldIn, pos, enumPlantType, 2)
        }
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return this.defaultState.withProperty(TYPE, EnumType.byMetadata(meta))
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return (state.getValue(TYPE) as EnumType).meta
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, *arrayOf<IProperty<*>>(TYPE))
    }

    override fun getOffsetType(): EnumOffsetType {
        return EnumOffsetType.XYZ
    }

    enum class EnumType private constructor(val meta: Int, name: String) : IStringSerializable {
        DEAD_BUSH(0, "dead_bush"),
        GRASS(1, "tall_grass"),
        FERN(2, "fern");

        override fun toString(): String {
            return this.name
        }

        override fun getName(): String {
            return this.name
        }

        companion object {

            private val META_LOOKUP = arrayOfNulls<EnumType>(values().size)

            fun byMetadata(meta: Int): EnumType? {
                var meta = meta
                if (meta < 0 || meta >= META_LOOKUP.size) {
                    meta = 0
                }

                return META_LOOKUP[meta]
            }

            init {
                for (enumType in values()) {
                    META_LOOKUP[enumType.meta] = enumType
                }
            }
        }
    }

    override fun isShearable(item: ItemStack, world: IBlockAccess, pos: BlockPos): Boolean {
        return true
    }

    override fun onSheared(item: ItemStack, world: IBlockAccess, pos: BlockPos, fortune: Int): NonNullList<ItemStack> {
        return NonNullList.withSize(1, ItemStack(Blocks.TALLGRASS, 1, (world.getBlockState(pos).getValue(TYPE) as EnumType).meta))
    }

    override fun getDrops(drops: NonNullList<ItemStack>, world: IBlockAccess, pos: BlockPos, state: IBlockState, fortune: Int) {
        if (Block.RANDOM.nextInt(8) != 0) return
        val seed = net.minecraftforge.common.ForgeHooks.getGrassSeed(Block.RANDOM, fortune)
        if (!seed.isEmpty)
            drops.add(seed)
    }

    companion object {
        val TYPE: PropertyEnum<EnumType> = PropertyEnum.create("type", EnumType::class.java)
        protected val TALL_GRASS_AABB = AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421)
    }
}

*/