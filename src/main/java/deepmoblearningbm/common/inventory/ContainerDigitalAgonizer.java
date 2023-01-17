package deepmoblearningbm.common.inventory;

import deepmoblearningbm.common.tiles.TileEntityDigitalAgonizer;
import mustapelto.deepmoblearning.common.inventory.ContainerTileEntity;
import mustapelto.deepmoblearning.common.inventory.SlotDataModel;
import mustapelto.deepmoblearning.common.inventory.SlotPristineMatter;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.items.IItemHandler;

import static deepmoblearningbm.client.gui.GuiDigitalAgonizer.RelativePositionInGui.*;

public class ContainerDigitalAgonizer extends ContainerTileEntity {

    public ContainerDigitalAgonizer(TileEntityDigitalAgonizer tileEntity, InventoryPlayer inventoryPlayer) {
        super(tileEntity, inventoryPlayer, PLAYER_INVENTORY.LEFT, PLAYER_INVENTORY.TOP);
    }

    @Override
    protected void addTileEntityInventory(IItemHandler inventory) {
        addSlotToContainer(new SlotDataModel(inventory, 0, DATA_MODEL_SLOT.LEFT,DATA_MODEL_SLOT.TOP));
        addSlotToContainer(new SlotPristineMatter(inventory, 1, PRISTINE_SLOT.X,PRISTINE_SLOT.Y));
    }
}