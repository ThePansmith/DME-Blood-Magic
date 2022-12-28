package deepmoblearningbm;

import deepmoblearningbm.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = ModConstants.MODID, version = ModConstants.VERSION, dependencies =
        "required-after:deepmoblearning;required-after:bloodmagic;after:jei;after:twilightforest")
public class DeepMobLearningBM {
    @Mod.Instance(ModConstants.MODID)
    public static DeepMobLearningBM instance;

    @SidedProxy(
            clientSide="deepmoblearningbm.client.ClientProxy",
            serverSide="deepmoblearningbm.common.CommonProxy"
    )
    public static CommonProxy proxy;

}