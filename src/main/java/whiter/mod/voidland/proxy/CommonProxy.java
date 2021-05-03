package whiter.mod.voidland.proxy;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import whiter.mod.voidland.vlregister;

@Mod.EventBusSubscriber
public abstract class CommonProxy {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        vlregister.INSTANCE.onRegisterBlocks(event);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        vlregister.INSTANCE.onRegisterItems(event);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerItemsLowest(RegistryEvent.Register<Item> event) {
        vlregister.INSTANCE.onRegisterItemsLowest(event);
    }

    @SubscribeEvent
    public static void onRecipeRegistry(RegistryEvent.Register<IRecipe> event) {
        vlregister.INSTANCE.onRecipeRegistry(event);
    }

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        vlregister.INSTANCE.onRegisterEnchantments(event);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {

    }


    public void preInit(FMLPreInitializationEvent event) {
        vlregister.INSTANCE.onPreInit(event);
    }

    public void init(FMLInitializationEvent event) {
        vlregister.INSTANCE.onInit(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        vlregister.INSTANCE.onPostInit(event);
    }

    public boolean runningOnServer() {
        return false;
    }
}
