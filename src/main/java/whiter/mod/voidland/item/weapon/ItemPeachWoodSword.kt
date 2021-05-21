package whiter.mod.voidland.item.weapon

import com.google.common.collect.Multimap
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.init.Blocks
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import whiter.mod.voidland.annotation.RegisterItem

@RegisterItem
class ItemPeachWoodSword: Item() {

//    lateinit var attackDamage: Double
//    lateinit var material: Item.ToolMaterial
//
//    fun ItemPeachWoodSword(material: Item.ToolMaterial) {
//        this.material = material
//        this.maxStackSize = 1
//        this.maxDamage = material.maxUses
//        this.creativeTab = CreativeTabs.COMBAT
//        this.attackDamage = 3.0f + material.attackDamage.toDouble()
//    }
//
//    override fun getDestroySpeed(stack: ItemStack, state: IBlockState): Float {
//        val block = state.block
//
//        if (block === Blocks.WEB) {
//            return 15.0f
//        } else {
//            val material = state.material
//            return if (material !== Material.PLANTS && material !== Material.VINE && material !== Material.CORAL && material !== Material.LEAVES && material !== Material.GOURD) 1.0f else 1.5f
//        }
//    }
//
//    override fun hitEntity(stack: ItemStack, target: EntityLivingBase, attacker: EntityLivingBase): Boolean {
//        stack.damageItem(1, attacker)
//        return true
//    }
//
//    override fun onBlockDestroyed(stack: ItemStack, worldIn: World, state: IBlockState, pos: BlockPos, entityLiving: EntityLivingBase): Boolean {
//        if (state.getBlockHardness(worldIn, pos).toDouble() != 0.0) {
//            stack.damageItem(2, entityLiving)
//        }
//
//        return true
//    }
//
//    override fun canHarvestBlock(blockIn: IBlockState): Boolean {
//        return blockIn.block === Blocks.WEB
//    }
//
//    @SideOnly(Side.CLIENT)
//    override fun isFull3D(): Boolean {
//        return true
//    }
//
//    override fun getItemEnchantability(): Int {
//        return this.material.enchantability
//    }
//
//    fun getToolMaterialName(): String {
//        return this.material.toString()
//    }
//
//    override fun getIsRepairable(toRepair: ItemStack, repair: ItemStack): Boolean {
//        val mat = this.material.repairItemStack
//        return if (!mat.isEmpty && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) true else super.getIsRepairable(toRepair, repair)
//    }
//
//    override fun getItemAttributeModifiers(equipmentSlot: EntityEquipmentSlot): Multimap<String, AttributeModifier> {
//        val multimap = super.getItemAttributeModifiers(equipmentSlot)
//
//        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
//            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.name, AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage.toDouble(), 0))
//            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.name, AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316, 0))
//        }
//
//        return multimap
//    }
}