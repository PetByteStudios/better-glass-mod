package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider{
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, ModBlockTagsProvider modBlockTagsProvider) {
        super(output, registryLookupFuture, modBlockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        for (Block block : ModBlocks.BETTER_GLASS_BLOCKS) {
            valueLookupBuilder(ConventionalItemTags.GLASS_BLOCKS).add(block.asItem());
            valueLookupBuilder(ConventionalItemTags.GLASS_BLOCKS_CHEAP).add(block.asItem());
        }
        for (DyeColor color : DyeColor.values()) {
            TagKey<Item> colorDyedTag = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "dyed/" + color.getName()));

            Item[] dyedBlocks = {
                    ModBlocks.COLORED_CLEAR_GLASS.get(color).asItem(),
                    ModBlocks.COLORED_SCRATCHED_GLASS.get(color).asItem(),
                    ModBlocks.STAINED_CLEAR_GLASS.get(color).asItem(),
                    ModBlocks.STAINED_SCRATCHED_GLASS.get(color).asItem()
            };

            valueLookupBuilder(colorDyedTag).add(dyedBlocks);
            valueLookupBuilder(ConventionalItemTags.DYED).add(dyedBlocks);
        }
        valueLookupBuilder(ConventionalItemTags.GLASS_BLOCKS_COLORLESS)
                .add(ModBlocks.CLEAR_GLASS.asItem())
                .add(ModBlocks.SCRATCHED_GLASS.asItem());

        copy(ModTags.CLEAR_GLASS.block(), ModTags.CLEAR_GLASS.item());
        copy(ModTags.SCRATCHED_GLASS.block(), ModTags.SCRATCHED_GLASS.item());
        copy(ModTags.COLORED_GLASS.block(), ModTags.COLORED_GLASS.item());
        copy(ModTags.STAINED_GLASS.block(), ModTags.STAINED_GLASS.item());
        copy(ModTags.COLORED_CLEAR_GLASS.block(), ModTags.COLORED_CLEAR_GLASS.item());
        copy(ModTags.STAINED_CLEAR_GLASS.block(), ModTags.STAINED_CLEAR_GLASS.item());
        copy(ModTags.COLORED_SCRATCHED_GLASS.block(), ModTags.COLORED_SCRATCHED_GLASS.item());
        copy(ModTags.STAINED_SCRATCHED_GLASS.block(), ModTags.STAINED_SCRATCHED_GLASS.item());
        copy(ModTags.STAINED_VANILLA_GLASS_ALL.block(), ModTags.STAINED_VANILLA_GLASS_ALL.item());
        copy(ModTags.STAINED_VANILLA_GLASS_BLOCK.block(), ModTags.STAINED_VANILLA_GLASS_BLOCK.item());
        copy(ModTags.STAINED_VANILLA_GLASS_PANE.block(), ModTags.STAINED_VANILLA_GLASS_PANE.item());
        copy(ModTags.COLORED_VANILLA_GLASS.block(), ModTags.COLORED_VANILLA_GLASS.item());
        copy(ModTags.CLEAR_GLASS_PANE.block(), ModTags.CLEAR_GLASS_PANE.item());
    }
}
