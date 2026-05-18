package dev.petbyte.betterglass.glasscutter;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GlasscutterBlock extends StonecutterBlock {
    public static final MapCodec<GlasscutterBlock> CODEC = simpleCodec(GlasscutterBlock::new);
    private static final Component TITLE = Component.translatable("container.betterglass.glasscutter");

    public GlasscutterBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider(
                (containerId, inventory, player) -> new GlasscutterMenu(containerId, inventory, ContainerLevelAccess.create(level, pos)),
                TITLE
        );
    }

    @Override
    public MapCodec<GlasscutterBlock> codec() {
        return CODEC;
    }
}