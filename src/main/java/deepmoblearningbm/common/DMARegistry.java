package deepmoblearningbm.common;

import deepmoblearningbm.DeepMobAgony;
import deepmoblearningbm.ModInfo;
import deepmoblearningbm.common.blocks.BlockDigitalAgonizer;
import deepmoblearningbm.common.tiles.TileEntityDigitalAgonizer;
import mustapelto.deepmoblearning.common.blocks.BlockBase;
import mustapelto.deepmoblearning.common.metadata.MetadataManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class DMARegistry {
    public static final NonNullList<Item> registeredItems = NonNullList.create();
    public static final NonNullList<BlockBase> registeredBlocks = NonNullList.create();
    //Items

    //Blocks
    public static final BlockDigitalAgonizer BLOCK_DIGITIAL_AGONIZER = new BlockDigitalAgonizer();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        DeepMobAgony.logger.info("Registering Blocks...");
        registeredBlocks.add(BLOCK_DIGITIAL_AGONIZER);

        IForgeRegistry<Block> registry = event.getRegistry();
        registeredBlocks.forEach(registry::register);

        // Register tile entities
        GameRegistry.registerTileEntity(TileEntityDigitalAgonizer.class, new ResourceLocation(ModInfo.MODID, "digital_agonizer"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        DeepMobAgony.logger.info("Registering Items...");
//
//
        IForgeRegistry<Item> registry = event.getRegistry();
        registeredItems.forEach(registry::register);

        // Register ItemBlocks
        registeredBlocks.forEach(block -> block.getItemBlock().ifPresent(registry::register));
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        DeepMobAgony.logger.info("Registering Entities...");
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
    }


    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        DeepMobAgony.logger.info("Registering Dynamic Recipes...");
        IForgeRegistry<IRecipe> registry = event.getRegistry();
        registry.registerAll(MetadataManager.getCraftingRecipes().toArray(new IRecipe[0]));
    }

}
