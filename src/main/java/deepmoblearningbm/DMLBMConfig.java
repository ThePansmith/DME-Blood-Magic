package deepmoblearningbm;

import mustapelto.deepmoblearning.DMLConstants;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ModConstants.MODID, name = DMLConstants.ModInfo.CONFIG_PATH + "/deepmobevolutionbm")
@Mod.EventBusSubscriber
public class DMLBMConfig {
    @Config.Name("Machine Settings")
    public static DMLBMConfig.MachineSettings MACHINE_SETTINGS = new DMLBMConfig.MachineSettings();

    public static class MachineSettings {
        @Config.Name("Digital Agonizer RF Cost")
        @Config.Comment("Energy cost of Digital Agonizer in RF/t")
        @Config.RangeInt(min = 0, max = 10000)
        public int DIGITAL_AGONIZER_RF_COST = 256;
    }
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ModConstants.MODID)) {
            ConfigManager.sync(ModConstants.MODID, Config.Type.INSTANCE);
        }
    }

}
