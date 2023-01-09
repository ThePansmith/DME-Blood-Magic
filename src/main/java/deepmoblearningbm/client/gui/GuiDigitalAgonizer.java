package deepmoblearningbm.client.gui;

import deepmoblearningbm.ModInfo;
import deepmoblearningbm.common.tiles.TileEntityDigitalAgonizer;
import mustapelto.deepmoblearning.client.gui.GuiMachine;
import mustapelto.deepmoblearning.common.util.Point;
import mustapelto.deepmoblearning.common.util.Rect;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


import static mustapelto.deepmoblearning.DMLConstants.Gui.SimulationChamber.PLAYER_INVENTORY;
@SideOnly(Side.CLIENT)
public class GuiDigitalAgonizer extends GuiMachine {

    /*
     * TODO: Implement functionality
     * Standard energy bar on right
     * GUI displays error in output item field as barrier texture which on hover
     * complains if there is no linked altar and instructs you to link one
     * The left slot is for pristine matter
     * above the progress bar a multiplier text is displayed
     * When a model is input a mb indicator is shown to indicate base blood per operation
     * the multiplier text will update when matter or sacrifice runes are added.
     * if runes are added an indicator will pop up that on hover shows multiplier breakdown
     * number of runes is displayed next to indicator
     * above matter slot fuel progress bar is shown
     * mini and main progress bar moves like one would expect.
     * Note: for some reason in the texturefile the progress bar is 4px longer then needed
     */
    private static final ResourceLocation TEXTURE = new ResourceLocation(ModInfo.MODID, "textures/gui/digital_agonizer_gui.png");
    private static final int WIDTH = 108;
    private static final int HEIGHT = 85;

    private static final class PositionInTextureFile {
        public static final Point ENERGY_BAR = new Point(0, 85);
        private static final Point REDSTONE_BUTTON = new Point(WIDTH - 20, HEIGHT - 20);
    }

    private static final class PositionOnScreen {
        private static final Rect MAIN_GUI = new Rect(8, 0, 216, 141);
        private static final Rect ENERGY_BAR = new Rect(6, 4, 7, 77);

    }

    // STATE VARIABLES
    private final TileEntityDigitalAgonizer tile;
    private ItemStack currentModel; // Data Model currently inside Agonizer

    //TODO: Implement error states
    //private GuiSimulationChamber.DataModelError dataModelError = GuiSimulationChamber.DataModelError.NONE; // Error with model (missing/faulty)?
    // private GuiSimulationChamber.SimulationError simulationError = GuiSimulationChamber.SimulationError.NONE; // Other error (missing polymer/low energy/output full)?
    private boolean redstoneDeactivated = false; // Is Agonizer chamber deactivated by redstone signal?
    private int currentIteration; // Saves data model's current iteration so we don't update display if iteration hasn't changed
    private boolean currentPristineSuccess; // Saves data model's current pristine success state so we don't update display if iteration hasn't changed

    public GuiDigitalAgonizer(TileEntityDigitalAgonizer tileEntity, EntityPlayer player, World world) {
        super(tileEntity, player, world, WIDTH, HEIGHT, PositionInTextureFile.REDSTONE_BUTTON);
        this.tile = tileEntity; //this overide exists just to grab these values
        this.currentModel = tileEntity.getDataModel();
    }


    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        textureManager.bindTexture(TEXTURE);
        GlStateManager.color(1f, 1f, 1f, 1f);

        // Main GUI
        drawTexturedModalRect(
                guiLeft + PositionOnScreen.MAIN_GUI.LEFT,
                guiTop + PositionOnScreen.MAIN_GUI.TOP,
                0,
                0,
                PositionOnScreen.MAIN_GUI.WIDTH,
                PositionOnScreen.MAIN_GUI.HEIGHT
        );
        drawEnergyBar(PositionOnScreen.ENERGY_BAR, PositionInTextureFile.ENERGY_BAR);

        drawPlayerInventory(guiLeft + PLAYER_INVENTORY.X, guiTop + PLAYER_INVENTORY.Y);

    }
}