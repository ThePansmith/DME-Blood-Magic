package deepmoblearningbm.common.blocks;

import deepmoblearningbm.common.tiles.TileEntityDigitalAgonizer;
import mustapelto.deepmoblearning.common.blocks.BlockMachine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockDigitalAgonizer extends BlockMachine {

    public BlockDigitalAgonizer() {
        super("digital_agonizer");
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState iBlockState) {return new TileEntityDigitalAgonizer();}
}
