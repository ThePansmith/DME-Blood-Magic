package deepmoblearningbm.common;

import mustapelto.deepmoblearning.common.blocks.BlockBase;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DMLBMRegistry {
    public static final NonNullList<Item> registeredItems = NonNullList.create();
    public static final NonNullList<BlockBase> registeredBlocks = NonNullList.create();

}
