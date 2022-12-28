package deepmoblearningbm.common.tiles;

import deepmoblearningbm.DMLBMConfig;
import mustapelto.deepmoblearning.common.inventory.ContainerTileEntity;
import mustapelto.deepmoblearning.common.inventory.ItemHandlerDataModel;
import mustapelto.deepmoblearning.common.tiles.CraftingState;
import mustapelto.deepmoblearning.common.tiles.TileEntityMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class TileEntityDigitalAgonizer extends TileEntityMachine {
    private final ItemHandlerDataModel inputDataModel = new ItemHandlerDataModel() {
        @Override
        protected void onContentsChanged(int slot) {
            onDataModelChanged();
        }
    };

    private void onDataModelChanged() {
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
        return DMLBMConfig.MACHINE_SETTINGS.DIGITAL_AGONIZER_RF_COST;
    }

    @Override
    protected CraftingState updateCraftingState() {
        return null;
    }

    @Override
    public ContainerTileEntity getContainer(InventoryPlayer inventoryPlayer) {
        return null;
    }
}
