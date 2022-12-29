package deepmoblearningbm.common.tiles;

import deepmoblearningbm.common.Inventory.ContainerDigitalAgonizer;
import mustapelto.deepmoblearning.common.inventory.ContainerTileEntity;
import mustapelto.deepmoblearning.common.inventory.ItemHandlerDataModel;
import mustapelto.deepmoblearning.common.tiles.CraftingState;
import mustapelto.deepmoblearning.common.tiles.TileEntityMachine;
import net.minecraft.entity.player.InventoryPlayer;

import static deepmoblearningbm.DMLBMConfig.MACHINE_SETTINGS;

public class TileEntityDigitalAgonizer extends TileEntityMachine {
    private final ItemHandlerDataModel inputDataModel = new ItemHandlerDataModel() {
        @Override
        protected void onContentsChanged(int slot) {
            onDataModelChanged();
        }
    };

    private void onDataModelChanged() {
    }

    public TileEntityDigitalAgonizer() {
        super(MACHINE_SETTINGS.DIGITAL_AGONIZER_RF_CAPACITY, MACHINE_SETTINGS.DIGITAL_AGONIZER_RF_INPUTMAX);
    }

    public TileEntityDigitalAgonizer(int energyCapacity, int energyMaxReceive) {
        super(energyCapacity, energyMaxReceive);
    }

    @Override
    protected int getCraftingDuration() {
        return 60;
    }

    @Override
    protected void finishCrafting() {

    }

    @Override
    public int getCraftingEnergyCost() {
        return MACHINE_SETTINGS.DIGITAL_AGONIZER_RF_COST;
    }

    @Override
    protected CraftingState updateCraftingState() {
        return CraftingState.IDLE;
    }

    @Override
    public ContainerTileEntity getContainer(InventoryPlayer inventoryPlayer) {
        return new ContainerDigitalAgonizer(this,inventoryPlayer);
    }
}
