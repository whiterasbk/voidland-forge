package whiter.mod.voidland.block.base

import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material
import net.minecraft.block.properties.IProperty
import net.minecraft.block.properties.PropertyBool
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.util.IStringSerializable
import net.minecraft.util.NonNullList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import whiter.mod.voidland.BlockBaseWithItem

class BlockVoidDirt: BlockBaseWithItem(Material.GROUND, "void_dirt") {

//    val VARIANT: PropertyEnum<DirtType> = PropertyEnum.create("variant", BlockVoidDirt.DirtType::class.java)
//    val SNOWY = PropertyBool.create("snowy")
//
//    init {
//        this.defaultState = this.blockState.baseState.withProperty<DirtType, DirtType>(VARIANT, DirtType.DIRT).withProperty(SNOWY, java.lang.Boolean.valueOf(false))
//    }
//
//    override fun getMapColor(state: IBlockState, worldIn: IBlockAccess, pos: BlockPos): MapColor {
//        return (state.getValue<DirtType>(VARIANT) as DirtType).color
//    }
//
//    override fun getActualState(state: IBlockState, worldIn: IBlockAccess, pos: BlockPos): IBlockState {
//        var state = state
//        if (state.getValue<DirtType>(VARIANT) == DirtType.PODZOL) {
//            val block = worldIn.getBlockState(pos.up()).block
//            state = state.withProperty(SNOWY, java.lang.Boolean.valueOf(block === Blocks.SNOW || block === Blocks.SNOW_LAYER))
//        }
//
//        return state
//    }
//
//    override fun getSubBlocks(itemIn: CreativeTabs, items: NonNullList<ItemStack>) {
//        items.add(ItemStack(this, 1, DirtType.DIRT.metadata))
//        items.add(ItemStack(this, 1, DirtType.COARSE_DIRT.metadata))
//        items.add(ItemStack(this, 1, DirtType.PODZOL.metadata))
//    }
//
//    override fun getItem(worldIn: World, pos: BlockPos, state: IBlockState): ItemStack {
//        return ItemStack(this, 1, (state.getValue<DirtType>(VARIANT) as DirtType).metadata)
//    }
//
//    override fun getStateFromMeta(meta: Int): IBlockState {
//        return this.defaultState.withProperty<DirtType, DirtType>(VARIANT, DirtType.byMetadata(meta))
//    }
//
//    override fun getMetaFromState(state: IBlockState): Int {
//        return (state.getValue<DirtType>(VARIANT) as DirtType).metadata
//    }
//
//    override fun createBlockState(): BlockStateContainer {
//        return BlockStateContainer(this, *arrayOf<IProperty<*>>(VARIANT, SNOWY))
//    }
//
//    override fun damageDropped(state: IBlockState): Int {
//        var bdp = state.getValue<DirtType>(VARIANT) as DirtType
//
//        if (bdp == DirtType.PODZOL) {
//            bdp = DirtType.DIRT
//        }
//
//        return bdp.metadata
//    }
//
//    enum class DirtType(val metadata: Int, nameIn: String, private val unlocalizedName: String, val color: MapColor) : IStringSerializable {
//        DIRT(0, "dirt", "default", MapColor.DIRT),
//        COARSE_DIRT(1, "coarse_dirt", "coarse", MapColor.DIRT),
//        PODZOL(2, "podzol","default", MapColor.OBSIDIAN);
//
//        private val METADATA_LOOKUP = arrayOfNulls<DirtType>(values().size)
//        private val iname: String = nameIn
//
//        override fun getName(): String {
//            return iname
//        }
//
//        init {
//            for (dt in values()) {
//                METADATA_LOOKUP[dt.metadata] = dt
//            }
//        }
//
//        companion object {
//
//            private val METADATA_LOOKUP = arrayOfNulls<DirtType>(values().size)
//
//            fun byMetadata(metadata: Int): DirtType? {
//                var metadata = metadata
//                if (metadata < 0 || metadata >= METADATA_LOOKUP.size) {
//                    metadata = 0
//                }
//
//                return METADATA_LOOKUP[metadata]
//            }
//
//            init {
//                for (bdp in values()) {
//                    METADATA_LOOKUP[bdp.metadata] = bdp
//                }
//            }
//        }
//
//    }
}