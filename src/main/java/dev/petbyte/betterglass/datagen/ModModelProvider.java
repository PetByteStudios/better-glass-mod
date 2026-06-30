package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        for (int i = 0; i < ModBlocks.BETTER_GLASS_BLOCKS.size(); i++) {
            blockModelGenerators.createGlassBlocks(
                    ModBlocks.BETTER_GLASS_BLOCKS.get(i),
                    ModBlocks.BETTER_GLASS_PANES.get(i+1) // dumb hack but idc
            );
        }
    }


    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        for (Item item : ModItems.ALL_ITEMS) {
            itemModelGenerators.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
        }
    }
}
