package deepmoblearningbm;

import deepmoblearningbm.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModConstants.ModInfo.MODID, version = ModConstants.ModInfo.VERSION, dependencies =
        "required-after:deepmoblearning;required-after:bloodmagic;after:jei;after:twilightforest")
public class DeepMobLearningBM {
    @Mod.Instance(ModConstants.ModInfo.MODID)
    public static DeepMobLearningBM instance;

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