package whiter.mod.voidland.proxy;


import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import whiter.mod.voidland.Voidland;
import whiter.mod.voidland.vlregister;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

    }

    @Override
    public void registerModels(ModelRegistryEvent event) {
        vlregister.INSTANCE.onRegisterModels(event);
    }



    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }



    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }

    @Override
    public boolean runningOnServer() {
        return false;
    }
}
