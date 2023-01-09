package deepmoblearningbm.common.tiles;

import deepmoblearningbm.DMAConfig;
import deepmoblearningbm.client.gui.GuiDigitalAgonizer;
import deepmoblearningbm.common.inventory.ContainerDigitalAgonizer;
import mustapelto.deepmoblearning.client.gui.GuiContainerBase;
import mustapelto.deepmoblearning.common.inventory.ContainerTileEntity;
import mustapelto.deepmoblearning.common.inventory.ItemHandlerDataModel;
import mustapelto.deepmoblearning.common.tiles.CraftingState;
import mustapelto.deepmoblearning.common.tiles.TileEntityMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityDigitalAgonizer extends TileEntityMachine {

    private static final int CRAFTING_SPEED_TICKS = 60;
    private static final int RF_INPUTMAX = Integer.MAX_VALUE;


    private final ItemHandlerDataModel inputDataModel = new ItemHandlerDataModel() {
        @Override
        protected void onContentsChanged(int slot) {
            onDataModelChanged();
        }
    };


    public TileEntityDigitalAgonizer() {
        super(DMAConfig.MachineSettings.AGONIZER_RF_CAPACITY, RF_INPUTMAX);
    }

    private void onDataModelChanged() {
    }

    @Override
    protected int getCraftingDuration() {
        return CRAFTING_SPEED_TICKS;
    }

    @Override
    protected void finishCrafting() {
    }

    @Override
    public int getCraftingEnergyCost() {
        return DMAConfig.MachineSettings.DIGITAL_AGONIZER_RF_COST;
    }

    @Override
    protected CraftingState updateCraftingState() {
        return CraftingState.IDLE;
    }

    @Override
    public ContainerTileEntity getContainer(InventoryPlayer inventoryPlayer) {
        return new ContainerDigitalAgonizer(this, inventoryPlayer);
    }
    @SideOnly(Side.CLIENT)
    public GuiContainerBase getGui(EntityPlayer player, World world) {
        return new GuiDigitalAgonizer(this, player, world);
    }
    //TODO: Implement getDataModel
    public ItemStack getDataModel() {
        return inputDataModel.getStackInSlot(0);
    }
}
