package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
// import dev.petbyte.betterglass.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;
// import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        for (Block block : ModBlocks.BETTER_GLASS_BLOCKS) {
            blockModelGenerators.createTrivialCube(block);
        }
    }


    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        // itemModelGenerators.generateFlatItem(ModItems.TEST_ITEM, ModelTemplates.FLAT_ITEM);
    }
}
