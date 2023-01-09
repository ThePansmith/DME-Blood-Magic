package deepmoblearningbm;

import deepmoblearningbm.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.MODID, version = ModInfo.VERSION, dependencies =
        "required-after:deepmoblearning;required-after:bloodmagic;after:jei;after:twilightforest")
public class DeepMobAgony {
    @Mod.Instance(ModInfo.MODID)
    public static DeepMobAgony instance;

    public static Logger logger;

    @SidedProxy(
            clientSide = "deepmoblearningbm.client.ClientProxy",
            serverSide = "deepmoblearningbm.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }
}