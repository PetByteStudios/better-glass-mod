package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        for (Block block : ModBlocks.BETTER_GLASS_ALL) {
            if (isTinted(block)) {
                dropSelf(block);
            } else {
                add(block, createSilkTouchOnlyTable(block));
            }
        }

        dropSelf(ModBlocks.GLASSCUTTER);
    }

    private boolean isTinted(Block block) {
        return ModBlocks.CLEAR_TINTED_GLASS == block
                || ModBlocks.SCRATCHED_TINTED_GLASS == block
                || ModBlocks.CLEAR_TINTED_GLASS_PANE == block
                || ModBlocks.SCRATCHED_TINTED_GLASS_PANE == block
                || ModBlocks.COLORED_TINTED_GLASS.containsValue(block)
                || ModBlocks.COLORED_TINTED_GLASS_PANE.containsValue(block)
                || ModBlocks.STAINED_TINTED_GLASS.containsValue(block)
                || ModBlocks.STAINED_TINTED_GLASS_PANE.containsValue(block)
                || ModBlocks.COLORED_CLEAR_TINTED_GLASS.containsValue(block)
                || ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE.containsValue(block)
                || ModBlocks.STAINED_CLEAR_TINTED_GLASS.containsValue(block)
                || ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE.containsValue(block)
                || ModBlocks.COLORED_SCRATCHED_TINTED_GLASS.containsValue(block)
                || ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE.containsValue(block)
                || ModBlocks.STAINED_SCRATCHED_TINTED_GLASS.containsValue(block)
                || ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE.containsValue(block)
                || ModBlocks.TINTED_GLASS_PANE == block;
    }
}