package deepmoblearningbm.common.Inventory;

import mustapelto.deepmoblearning.common.inventory.ContainerTileEntity;
import mustapelto.deepmoblearning.common.inventory.SlotDataModel;
import mustapelto.deepmoblearning.common.tiles.TileEntityContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.items.IItemHandler;

import static mustapelto.deepmoblearning.DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT;
import static mustapelto.deepmoblearning.DMLConstants.Gui.SimulationChamber.PLAYER_INVENTORY;

public class ContainerDigitalAgonizer extends ContainerTileEntity {

    public ContainerDigitalAgonizer(TileEntityContainer tileEntity, InventoryPlayer inventoryPlayer) {
        super(tileEntity, inventoryPlayer, PLAYER_INVENTORY.X, PLAYER_INVENTORY.Y);
    }

    @Override
    protected void addTileEntityInventory(IItemHandler inventory) {
        addSlotToContainer(new SlotDataModel(inventory, 0, DATA_MODEL_SLOT.LEFT + 1,DATA_MODEL_SLOT.TOP + 1));

    }
}
