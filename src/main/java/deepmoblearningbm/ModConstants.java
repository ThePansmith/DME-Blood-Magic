package deepmoblearningbm;

import net.minecraftforge.fml.common.Loader;

public class ModConstants {
    public static final class ModInfo {
        public static final String MODID = "deepmoblearningbm";
        public static final String NAME = "DeepMobEvolution: Blood Magic";
        public static final String VERSION = "@VERSION@";
        public static final String CONFIG_PATH = "deepmobevolutionbloodmagic";
    }

    public static final boolean MOD_BM_LOADED = Loader.isModLoaded("bloodmagic");
}
