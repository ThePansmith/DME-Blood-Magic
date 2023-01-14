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


@SideOnly(Side.CLIENT)
public class GuiDigitalAgonizer extends GuiMachine {

    //TODO: Test Power bar works correctly.

    //TODO: Implement functionality
    /*
     *
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
    private static final ResourceLocation AGONIZER_GUI_TEXTURE = new ResourceLocation(ModInfo.MODID, "textures/gui/digital_agonizer_gui.png");

    protected static final class PositionInTextureFile {
        public static final Point ENERGY_BAR = new Point(0, 85);

        private static final Point DATA_MODEL_SLOT = new Point(21, 3);


    }
    private static final int TOTAL_HEIGHT = RelativePositionInGui.MAIN_GUI.HEIGHT + RelativePositionInGui.PLAYER_INVENTORY.HEIGHT + 4;
    private static final int TOTAL_WIDTH = Math.max(RelativePositionInGui.MAIN_GUI.WIDTH, RelativePositionInGui.PLAYER_INVENTORY.WIDTH);

    public static final class RelativePositionInGui {
        private static final Rect MAIN_GUI = new Rect(0, 0, 108, 85);
        public static final Rect PLAYER_INVENTORY = new Rect((RelativePositionInGui.MAIN_GUI.WIDTH - 177)/2, RelativePositionInGui.MAIN_GUI.HEIGHT + 4,177,91);
        private static final Rect ENERGY_BAR = new Rect(6, 4, 7, 77);
        public static final Rect DATA_MODEL_SLOT = new Rect(22, 4,16,16);
        public static final Point PRISTINE_SLOT = new Point(21, 24);
        public static final Rect PlayerInventory = new Rect(22, 4,16,16);
        private static final Point REDSTONE_BUTTON = new Point(-22,  0); // Redstone Button is 16x16

    }

    // STATE VARIABLES
    private final TileEntityDigitalAgonizer tile;
    private ItemStack currentModel; // Data Model currently inside Agonizer

    // TODO: Implement error states
    //private GuiSimulationChamber.DataModelError dataModelError = GuiSimulationChamber.DataModelError.NONE; // Error with model (missing/faulty)?
    // private GuiSimulationChamber.SimulationError simulationError = GuiSimulationChamber.SimulationError.NONE; // Other error (missing polymer/low energy/output full)?
    private boolean redstoneDeactivated = false; // Is Agonizer chamber deactivated by redstone signal?
    private int currentIteration; // Saves data model's current iteration so we don't update display if iteration hasn't changed
    private boolean currentPristineSuccess; // Saves data model's current pristine success state so we don't update display if iteration hasn't changed

    public GuiDigitalAgonizer(TileEntityDigitalAgonizer tileEntity, EntityPlayer player, World world) {
        super(tileEntity, player, world, TOTAL_WIDTH, TOTAL_HEIGHT, RelativePositionInGui.REDSTONE_BUTTON);
        this.tile = tileEntity; //this overide exists just to grab these values
        this.currentModel = tileEntity.getDataModel();
    }


    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        textureManager.bindTexture(AGONIZER_GUI_TEXTURE);
        GlStateManager.color(1f, 1f, 1f, 1f);

        // Main GUI
        drawTexturedModalRect(
                guiLeft + RelativePositionInGui.MAIN_GUI.LEFT,
                guiTop + RelativePositionInGui.MAIN_GUI.TOP,
                RelativePositionInGui.MAIN_GUI.LEFT,
                RelativePositionInGui.MAIN_GUI.TOP,
                RelativePositionInGui.MAIN_GUI.WIDTH,
                RelativePositionInGui.MAIN_GUI.HEIGHT
        );

        drawEnergyBar(RelativePositionInGui.ENERGY_BAR, PositionInTextureFile.ENERGY_BAR);

        drawPlayerInventory(guiLeft + RelativePositionInGui.PLAYER_INVENTORY.LEFT, guiTop + RelativePositionInGui.PLAYER_INVENTORY.TOP);

    }
}