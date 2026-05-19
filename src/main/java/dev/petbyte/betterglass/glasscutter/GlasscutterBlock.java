package dev.petbyte.betterglass.glasscutter;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class GlasscutterBlock extends StonecutterBlock {
    public GlasscutterBlock(Properties settings) {
        super(settings);
    }

    @Override
    public MenuProvider getMenuProvider(@NonNull BlockState state, @NonNull Level world, @NonNull BlockPos pos) {
        return new SimpleMenuProvider(
                (syncId, inv, _) -> new GlasscutterMenu(syncId, inv, ContainerLevelAccess.create(world, pos)),
                Component.translatable("container.betterglass.glasscutter")
        );
    }
}