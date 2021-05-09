package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.Item
import net.minecraft.item.Item.getItemFromBlock
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraft.util.ResourceLocation
import net.minecraft.world.DimensionType
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.common.DimensionManager
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.registry.EntityEntry
import net.minecraftforge.fml.common.registry.EntityEntryBuilder
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.apache.logging.log4j.Logger
import whiter.mod.voidland.cmd.VlCommand
import whiter.mod.voidland.cmd.VlCommand2
import whiter.mod.voidland.entity.EntitySample
import whiter.mod.voidland.util.AutoRegisters

object vl {
    const val modid = "voidland"
    const val name = "无主之地"
    const val version = "1.0"
    const val acceptedMinecraftVersions = "[1.12, 1.13)"
    const val dependencies = "required-after:forgelin"
    lateinit var dimType: DimensionType
    val mod = Voidland.insatnce
    var dimID = 141
    val modpkgName = "whiter.mod.voidland"
    lateinit var creative_tab: CreativeTab
}

class CreativeTab : CreativeTabs("voidland") {
    @SideOnly(Side.CLIENT)
    override fun getTabIconItem(): ItemStack {
        return ItemStack(getItemFromBlock(blocks.map["voidland:void_table"]), 1)
    }
}

object vlregister {

    // block => item => model
    lateinit var logger: Logger

    fun onPreInit(event: FMLPreInitializationEvent) {

        // set a CreativeTab
        vl.creative_tab = CreativeTab()

        logger = event.modLog
        items.logger = logger
        blocks.logger = logger

        // register blocks & items
        AutoRegisters.registerBlock()
        AutoRegisters.registerItem()

        // register commands
        VlCommand()
        VlCommand2()

        // init gui
        NetworkRegistry.INSTANCE.registerGuiHandler(vl.mod, GUIHandler())

        // register Dimension
        vl.dimType = DimensionType.register("vl_dimension", "_vl_dim", vl.dimID, VlWorldProvider::class.java, false)
        DimensionManager.registerDimension(vl.dimID, vl.dimType)

    }

    fun onRegisterBlocks(event: RegistryEvent.Register<Block>) {
        logger.info("onRegisterBlocks")
        blocks.register(event)
    }

    fun onRegisterItems(event: RegistryEvent.Register<Item>) {
        logger.info("onRegisterItems")
        items.register(event)
    }

    fun onRegisterModels(event: ModelRegistryEvent) {
        logger.info("onRegisterModels")
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

    }

    fun onServerStarting(event: FMLServerStartingEvent) {
        cmds.initCommands(event)
    }

    fun onRegisterEntity(event: RegistryEvent.Register<EntityEntry>) {

        event.registry.register(

                EntityEntryBuilder.create<EntitySample>()
                        .entity(EntitySample::class.java)
                        .id(ResourceLocation(vl.modid, "my_entity"), 233)
                        .name("MyEntity")
                        .tracker(80, 3, false)
                        .build()
        )
    }

}
