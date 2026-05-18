package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
// import dev.petbyte.betterglass.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
// import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.WHITE_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.LIGHT_GRAY_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.GRAY_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.BLACK_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.BROWN_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.RED_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.ORANGE_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.YELLOW_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.LIME_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.GREEN_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.CYAN_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.LIGHT_BLUE_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.BLUE_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.PURPLE_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.MAGENTA_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.PINK_COLORED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.WHITE_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.LIGHT_GRAY_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.GRAY_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.BLACK_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.BROWN_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.RED_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.ORANGE_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.YELLOW_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.LIME_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.GREEN_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.CYAN_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.LIGHT_BLUE_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.BLUE_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.PURPLE_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.MAGENTA_STAINED_CLEAR_GLASS);
        blockModelGenerators.createTrivialCube(ModBlocks.PINK_STAINED_CLEAR_GLASS);
    }


    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        // itemModelGenerators.generateFlatItem(ModItems.TEST_ITEM, ModelTemplates.FLAT_ITEM);
    }
}
