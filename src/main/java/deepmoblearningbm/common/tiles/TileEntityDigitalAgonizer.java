package deepmoblearningbm.common.tiles;

import deepmoblearningbm.DMAConfig;
import deepmoblearningbm.client.gui.GuiDigitalAgonizer;
import deepmoblearningbm.common.inventory.ContainerDigitalAgonizer;
import mustapelto.deepmoblearning.client.gui.GuiContainerBase;
import mustapelto.deepmoblearning.common.DMLConfig;
import mustapelto.deepmoblearning.common.inventory.*;
import mustapelto.deepmoblearning.common.tiles.CraftingState;
import mustapelto.deepmoblearning.common.tiles.TileEntityMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

import javax.annotation.Nullable;

public class TileEntityDigitalAgonizer extends TileEntityMachine {
    private final ItemHandlerPristineMatter inputPristineMatter = new ItemHandlerPristineMatter() {
        // TODO: make custom item handler instead of pristine for more expandability
        // TODO: REMOVE OR FIX THIS COMMENTT
        /**
         * The onMetadataChanged function is called whenever the metadata of an item in the inventory changes.
         * This function is used to reset the crafting recipe for this tile entity if it has a valid output item.
         *
         *
         * @return The metadata of the item in the output slot
         *
         * @docauthor Trelent
         **/
        @Override
        protected void onMetadataChanged() {
//            if (this.pristineMatterMetadata != null && !isValidOutputItem()) {
//                outputItem = ItemStack.EMPTY; // Don't reset output item if stack empties or refills with same item
//            }
            resetCrafting();
        }
    };
    private static final int CRAFTING_SPEED_TICKS = 60;
    private static final int RF_INPUTMAX = Integer.MAX_VALUE;
    private final ItemHandlerInputWrapper pristineMatterWrapper = new ItemHandlerInputWrapper(inputPristineMatter);
    private final ItemHandlerOutput outputLiving = new ItemHandlerOutput();
    private final ItemHandlerOutput outputPristine = new ItemHandlerOutput();

    private final ItemHandlerDataModel inputDataModel = new ItemHandlerDataModel() {
        @Override
        protected void onContentsChanged(int slot) {
            onDataModelChanged();
        }
    };
    private final ItemHandlerInputWrapper dataModelWrapper = new ItemHandlerInputWrapper(inputDataModel);

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
    public ItemStack getPristine() {
        return inputPristineMatter.getStackInSlot(1);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == null) {
                return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(
                        new CombinedInvWrapper(inputDataModel, inputPristineMatter, outputLiving, outputPristine)
                );
            } else {
                if (!DMLConfig.MACHINE_SETTINGS.LEGACY_MACHINE_SIDEDNESS) {
                    return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(
                            new CombinedInvWrapper(dataModelWrapper, inputPristineMatter, outputLiving, outputPristine)
                    );
                } else {
                    if (facing == EnumFacing.UP) {
                        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(new CombinedInvWrapper(inputDataModel, inputPristineMatter));
                    } else {
                        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(new CombinedInvWrapper(outputPristine, outputLiving));
                    }
                }
            }
        }

        return super.getCapability(capability, facing);
    }
}
