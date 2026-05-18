package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }
    
    private static final List<Block> SILK_TOUCH_BLOCKS = List.of(
            ModBlocks.CLEAR_GLASS,
            ModBlocks.WHITE_COLORED_CLEAR_GLASS,
            ModBlocks.LIGHT_GRAY_COLORED_CLEAR_GLASS,
            ModBlocks.GRAY_COLORED_CLEAR_GLASS,
            ModBlocks.BLACK_COLORED_CLEAR_GLASS,
            ModBlocks.BROWN_COLORED_CLEAR_GLASS,
            ModBlocks.RED_COLORED_CLEAR_GLASS,
            ModBlocks.ORANGE_COLORED_CLEAR_GLASS,
            ModBlocks.YELLOW_COLORED_CLEAR_GLASS,
            ModBlocks.LIME_COLORED_CLEAR_GLASS,
            ModBlocks.GREEN_COLORED_CLEAR_GLASS,
            ModBlocks.CYAN_COLORED_CLEAR_GLASS,
            ModBlocks.LIGHT_BLUE_COLORED_CLEAR_GLASS,
            ModBlocks.BLUE_COLORED_CLEAR_GLASS,
            ModBlocks.PURPLE_COLORED_CLEAR_GLASS,
            ModBlocks.MAGENTA_COLORED_CLEAR_GLASS,
            ModBlocks.PINK_COLORED_CLEAR_GLASS
    );

    @Override
    public void generate() {
        for (Block block : SILK_TOUCH_BLOCKS) {
            add(block, createSilkTouchOnlyTable(block));
        }
    }
}