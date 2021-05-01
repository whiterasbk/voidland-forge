package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.Item
import net.minecraft.item.crafting.IRecipe
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.Logger

object vlregister {


    // block => item => model
    lateinit var logger:Logger

    fun onPreInit(event: FMLPreInitializationEvent) {
        logger = event.modLog

        val sample_item = ItemBase("sample_item")
        val sampel_block = BlockBaseWithItem(Material.WOOD, "sample_block")
        val block_sieve = BlockBaseWithItem(Material.WOOD, "block_sieve")
    }



    fun onRegisterBlocks(event: RegistryEvent.Register<Block>) {

        logger.log(Level.DEBUG, "onRegisterBlocks")
        println("voidland:onRegisterBlocks")
        blocks.register(event)
    }

    fun onRegisterItems(event: RegistryEvent.Register<Item>) {
        logger.log(Level.DEBUG, "onRegisterItems")
        println("voidland:onRegisterItems")
        items.register(event)
    }

    fun onRegisterModels(event: ModelRegistryEvent) {
        logger.log(Level.DEBUG, "onRegisterModels")
        println("voidland:onRegisterModels")
        blocks.initModels(event)
        items.initModels(event)
        // fluids.initModels()
    }

    fun onRegisterItemsLowest(event: RegistryEvent.Register<Item>) {

    }
    fun onRecipeRegistry(event: RegistryEvent.Register<IRecipe>) {}
    fun onRegisterEnchantments(event: RegistryEvent.Register<Enchantment>) {}



    fun onInit(event: FMLInitializationEvent) {

    }
    fun onPostInit(event: FMLPostInitializationEvent) {}

}