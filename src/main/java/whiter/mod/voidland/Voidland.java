package whiter.mod.voidland;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import whiter.mod.voidland.proxy.CommonProxy;

/**
 * @author whiter
 * @author g-breeze
 */
@Mod(modid = vl.modid, name = vl.name, version = vl.version, acceptedMinecraftVersions = vl.acceptedMinecraftVersions, dependencies = vl.dependencies)
@Mod.EventBusSubscriber
public class Voidland {
    @SidedProxy(serverSide = "whiter.mod.voidland.proxy.ServerProxy", clientSide = "whiter.mod.voidland.proxy.ClientProxy")
    public static CommonProxy proxy;
    @Mod.Instance(vl.modid)
    public static  Voidland insatnce;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        proxy.preInit(event);
        MinecraftForge.EVENT_BUS.register(proxy);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

        proxy.init(event);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        vlregister.INSTANCE.onServerStarting(event);
    }

}




