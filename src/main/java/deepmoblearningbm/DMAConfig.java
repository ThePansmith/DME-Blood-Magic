package deepmoblearningbm;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ModInfo.MODID, name = ModInfo.CONFIG_PATH + "/deepmobevolutionbm")
@Mod.EventBusSubscriber
public class DMAConfig {
    @Config.Name("Machine Settings")
    public static DMAConfig.MachineSettings MACHINE_SETTINGS = new DMAConfig.MachineSettings();

    public static class MachineSettings {
        @Config.Name("Digital Agonizer RF Cost")
        @Config.Comment("Energy cost of Digital Agonizer in RF/t")
        @Config.RangeInt(min = 0, max = 10000)
        public static int DIGITAL_AGONIZER_RF_COST = 256;
        @Config.Name("Digital Agonizer RF Capacity")
        @Config.Comment("Energy capacity of Digital Agonizer in RF")
        @Config.RangeInt(min = 0)
        public static int AGONIZER_RF_CAPACITY = 800_000;
    }
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ModInfo.MODID)) {
            ConfigManager.sync(ModInfo.MODID, Config.Type.INSTANCE);
        }
    }

}
