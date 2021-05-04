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
import net.minecraft.world.DimensionType
import net.minecraftforge.common.DimensionManager
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import whiter.mod.voidland.block.BlockSample
import whiter.mod.voidland.block.BlockSample2
import whiter.mod.voidland.cmd.VlCommand
import whiter.mod.voidland.cmd.VlCommand2
import whiter.mod.voidland.item.ItemSample


object vlregister {


    // block => item => model
    lateinit var logger:Logger

    fun onPreInit(event: FMLPreInitializationEvent) {
        logger = event.modLog


        // register commands
//        VlCommand()
//        VlCommand2()


        // register blocks & items
        // 模板:val block_name = BlockBaseWithItem(block_material,block_name)
        ItemSample()
        BlockSample()

        val soul_stabilizer = ItemBase("soul_stabilizer")

        val block_sieve = BlockBaseWithItem(Material.WOOD, "block_sieve")
//        val soul_stabilizer = combination("soul_stabilizer")

        val slut_block = BlockBaseWithItem(Material.WOOD, "slut_block")
        val soul_counter_base = BlockBaseWithItem(Material.WOOD, "soul_counter_base")
        val soul_counter_center = BlockBaseWithItem(Material.WOOD, "soul_counter_center")
        val soul_counter_nocore = BlockBaseWithItem(Material.WOOD, "soul_counter_nocore")
        val soul_counter = BlockBaseWithItem(Material.WOOD, "soul_counter")

        // init gui
        NetworkRegistry.INSTANCE.registerGuiHandler(vl.mod, GUIHandler())


        // register Dimension
        vl.dimType = DimensionType.register("vl_dimension", "_vl_dim", vl.dimID, VlWorldProvider::class.java, false)
        DimensionManager.registerDimension(vl.dimID, vl.dimType)

    }



    fun onRegisterBlocks(event: RegistryEvent.Register<Block>) {
        logger.info("onRegisterBlocks")
//        println("voidland:onRegisterBlocks")


        event.registry.register(BlockSample2("slut_block"))


        blocks.register(event)
    }

    fun onRegisterItems(event: RegistryEvent.Register<Item>) {
        logger.info("onRegisterItems")
//        println("voidland:onRegisterItems")
        items.register(event)
    }

    fun onRegisterModels(event: ModelRegistryEvent) {
        logger.info("onRegisterModels")
//        println("voidland:onRegisterModels")
        blocks.initModels(event)
        items.initModels(event)
        // fluids.initModels()
    }

    fun onRegisterItemsLowest(event: RegistryEvent.Register<Item>) {

    }

    fun onRecipeRegistry(event: RegistryEvent.Register<IRecipe>) {



        // Synthesis table
    }
    fun onRegisterEnchantments(event: RegistryEvent.Register<Enchantment>) {


        // Enchantments
    }



    fun onInit(event: FMLInitializationEvent) {

    }

    fun onPostInit(event: FMLPostInitializationEvent) {

//        // check blocks & items
//        println(items.data)
//        println(blocks.data)
    }

    fun onServerStarting(event: FMLServerStartingEvent) {

        print("开始了没")
//        event.registerServerCommand(VlCommand())
//        event.registerServerCommand(VlCommand2())



        // todo 不修了

        // register commands
//        VlCommand().register(event)
//        VlCommand2().register(event)
//        cmds.initCommands(event)
    }

}