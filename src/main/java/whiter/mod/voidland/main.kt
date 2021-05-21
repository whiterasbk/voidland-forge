package whiter.mod.voidland

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.monster.EntitySkeleton
import net.minecraft.item.Item
import net.minecraft.item.Item.getItemFromBlock
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraft.util.FrameTimer
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.DimensionType
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.common.DimensionManager
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.registry.EntityEntry
import net.minecraftforge.fml.common.registry.EntityEntryBuilder
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry
import net.minecraftforge.registries.IForgeRegistryEntry
import org.apache.logging.log4j.Logger
import whiter.mod.voidland.block.base.BlockVoidDirt
import whiter.mod.voidland.block.base.BlockVoidJadeOre
import whiter.mod.voidland.cmd.VlCommand
import whiter.mod.voidland.cmd.VlCommand2
import whiter.mod.voidland.entity.EntitySample
import whiter.mod.voidland.item.ItemCharmPaper
import whiter.mod.voidland.item.ItemSoulStabilizer
import whiter.mod.voidland.item.ItemVoidCharm
import whiter.mod.voidland.util.AutoRegisters
import whiter.mod.voidland.util.util
import kotlin.reflect.KClass




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
        // Synthesis table
        // register smelt


    }

    fun onRegisterItemsLowest(event: RegistryEvent.Register<Item>) {
        logger.info("onRegisterItemsLowest")
    }

    fun onRecipeRegistry(event: RegistryEvent.Register<IRecipe>) {
        logger.info("onRecipeRegistry")

    }

    fun onRegisterEnchantments(event: RegistryEvent.Register<Enchantment>) {
        logger.info("onRegisterEnchantments")
        // Enchantments
    }

    fun onInit(event: FMLInitializationEvent) {
        logger.info("onInit")
    }

    fun onPostInit(event: FMLPostInitializationEvent) {
        logger.info("onPostInit")

        // register smelt

    }

    fun onServerStarting(event: FMLServerStartingEvent) {
        logger.info("onServerStarting")
        cmds.initCommands(event)
    }

    fun getVanillaFurnaceFuelValue(event: FurnaceFuelBurnTimeEvent) {

        for (i in smelt.burnMap) {
            if (event.itemStack.item.equals((items.map[i.key]))) {
                println(event.itemStack)
                event.burnTime = i.value
            } else if (event.itemStack.item.equals((blocks.map[i.key]))) {
                println(event.itemStack)
                event.burnTime = i.value
            }
        }
    }

    fun onRegisterEntity(event: RegistryEvent.Register<EntityEntry>) {
        logger.info("onRegisterEntity")
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


object smelt {

    val sprefix = "voidland:"

    val burnMap = mutableMapOf<String, Int>()

    fun register(rinput: KClass<out IForgeRegistryEntry.Impl<*>>, routput: KClass<out IForgeRegistryEntry.Impl<*>>, exp: Float, prefix: String = sprefix) {
        val input = rinput.java
        val output = routput.java

        if (Item::class.java.isAssignableFrom(input)) {
            if (Block::class.java.isAssignableFrom(output)) {
                val item = items.map[prefix + util.clipBIstr(input.simpleName, "Item")]
                val block = blocks.map[prefix + util.clipBIstr(output.simpleName, "Block")]
                GameRegistry.addSmelting(item, ItemStack(block), exp)
                vlregister.logger.info("smelt IB: $item to $block")
            } else if (Item::class.java.isAssignableFrom(output)) {
                val item1 = items.map[prefix + util.clipBIstr(input.simpleName, "Item")]
                val item2 = items.map[prefix + util.clipBIstr(output.simpleName, "Item")]
                GameRegistry.addSmelting(item1, ItemStack(item2), exp)
                vlregister.logger.info("smelt II: $item1 to $item2")
            }
        } else if (Block::class.java.isAssignableFrom(input)) {
            if (Block::class.java.isAssignableFrom(output)) {
                val block1 = blocks.map[prefix + util.clipBIstr(input.simpleName, "Block")]
                val block2 = blocks.map[prefix + util.clipBIstr(output.simpleName, "Block")]
                GameRegistry.addSmelting(block1, ItemStack(block2), exp)
                vlregister.logger.info("smelt BB: $block1 to $block2")
            } else if (Item::class.java.isAssignableFrom(output)) {
                val item = items.map[prefix + util.clipBIstr(output.simpleName, "Item")]
                val block = blocks.map[prefix + util.clipBIstr(input.simpleName, "Block")]
                GameRegistry.addSmelting(block, ItemStack(item), exp)
                vlregister.logger.info("smelt BI: $block to $item")
            }
        }
    }

    fun addBurnMap(name: String, time: Int = 0) {
        burnMap[name] = time
    }
}