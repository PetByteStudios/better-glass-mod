package dev.petbyte.betterglass.block;

import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class TintedGlassPaneBlock extends IronBarsBlock {
    public TintedGlassPaneBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean propagatesSkylightDown(@NonNull BlockState state) {
        return false;
    }

    @Override
    protected int getLightDampening(@NonNull BlockState state) {
        return 15;
    }
}