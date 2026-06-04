package dev.petbyte.betterglass.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class TintedGlassPaneBlock extends IronBarsBlock {
    public static final MapCodec<TintedGlassPaneBlock> CODEC = simpleCodec(TintedGlassPaneBlock::new);

    public TintedGlassPaneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull MapCodec<? extends TintedGlassPaneBlock> codec() {
        return CODEC;
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