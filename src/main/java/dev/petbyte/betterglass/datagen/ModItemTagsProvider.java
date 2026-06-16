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

import static dev.petbyte.betterglass.BetterGlassUtils.*;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, ModBlockTagsProvider modBlockTagsProvider) {
        super(output, registryLookupFuture, modBlockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        var conventionalTagGlassBlocksColorless = builder(ConventionalItemTags.GLASS_BLOCKS_COLORLESS);

        for (Block block : ModBlocks.BETTER_GLASS_BLOCKS) {
            builder(ConventionalItemTags.GLASS_BLOCKS).add(itemKey(block.asItem()));
            if (blockKey(block).toString().contains("tinted")) {
                builder(ConventionalItemTags.GLASS_BLOCKS_TINTED).add(itemKey(block.asItem()));
            } else {
                builder(ConventionalItemTags.GLASS_BLOCKS_CHEAP).add(itemKey(block.asItem()));
            }
        }
        for (DyeColor color : DyeColor.values()) {
            TagKey<Item> colorDyedTag = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "dyed/" + color.getName()));

            Item[] dyedBlocks = {
                    ModBlocks.COLORED_CLEAR_GLASS.get(color).asItem(),
                    ModBlocks.COLORED_SCRATCHED_GLASS.get(color).asItem(),
                    ModBlocks.STAINED_CLEAR_GLASS.get(color).asItem(),
                    ModBlocks.STAINED_SCRATCHED_GLASS.get(color).asItem()
            };

            addAll(builder(colorDyedTag), dyedBlocks);
            addAll(builder(ConventionalItemTags.DYED), dyedBlocks);
        }
        conventionalTagGlassBlocksColorless.add(itemKey(ModBlocks.CLEAR_GLASS.asItem()));
        conventionalTagGlassBlocksColorless.add(itemKey(ModBlocks.SCRATCHED_GLASS.asItem()));

        copy(ModTags.CLEAR_GLASS_ALL.block(), ModTags.CLEAR_GLASS_ALL.item());
        copy(ModTags.CLEAR_GLASS_BLOCK.block(), ModTags.CLEAR_GLASS_BLOCK.item());
        copy(ModTags.CLEAR_GLASS_PANE.block(), ModTags.CLEAR_GLASS_PANE.item());
        copy(ModTags.SCRATCHED_GLASS_ALL.block(), ModTags.SCRATCHED_GLASS_ALL.item());
        copy(ModTags.SCRATCHED_GLASS_BLOCK.block(), ModTags.SCRATCHED_GLASS_BLOCK.item());
        copy(ModTags.SCRATCHED_GLASS_PANE.block(), ModTags.SCRATCHED_GLASS_PANE.item());
        copy(ModTags.COLORED_GLASS_ALL.block(), ModTags.COLORED_GLASS_ALL.item());
        copy(ModTags.COLORED_GLASS_BLOCK.block(), ModTags.COLORED_GLASS_BLOCK.item());
        copy(ModTags.COLORED_GLASS_PANE.block(), ModTags.COLORED_GLASS_PANE.item());
        copy(ModTags.STAINED_GLASS_ALL.block(), ModTags.STAINED_GLASS_ALL.item());
        copy(ModTags.STAINED_GLASS_BLOCK.block(), ModTags.STAINED_GLASS_BLOCK.item());
        copy(ModTags.STAINED_GLASS_PANE.block(), ModTags.STAINED_GLASS_PANE.item());
        copy(ModTags.COLORED_CLEAR_GLASS_ALL.block(), ModTags.COLORED_CLEAR_GLASS_ALL.item());
        copy(ModTags.COLORED_CLEAR_GLASS_BLOCK.block(), ModTags.COLORED_CLEAR_GLASS_BLOCK.item());
        copy(ModTags.COLORED_CLEAR_GLASS_PANE.block(), ModTags.COLORED_CLEAR_GLASS_PANE.item());
        copy(ModTags.STAINED_CLEAR_GLASS_ALL.block(), ModTags.STAINED_CLEAR_GLASS_ALL.item());
        copy(ModTags.STAINED_CLEAR_GLASS_BLOCK.block(), ModTags.STAINED_CLEAR_GLASS_BLOCK.item());
        copy(ModTags.STAINED_CLEAR_GLASS_PANE.block(), ModTags.STAINED_CLEAR_GLASS_PANE.item());
        copy(ModTags.COLORED_SCRATCHED_GLASS_ALL.block(), ModTags.COLORED_SCRATCHED_GLASS_ALL.item());
        copy(ModTags.COLORED_SCRATCHED_GLASS_BLOCK.block(), ModTags.COLORED_SCRATCHED_GLASS_BLOCK.item());
        copy(ModTags.COLORED_SCRATCHED_GLASS_PANE.block(), ModTags.COLORED_SCRATCHED_GLASS_PANE.item());
        copy(ModTags.STAINED_SCRATCHED_GLASS_ALL.block(), ModTags.STAINED_SCRATCHED_GLASS_ALL.item());
        copy(ModTags.STAINED_SCRATCHED_GLASS_BLOCK.block(), ModTags.STAINED_SCRATCHED_GLASS_BLOCK.item());
        copy(ModTags.STAINED_SCRATCHED_GLASS_PANE.block(), ModTags.STAINED_SCRATCHED_GLASS_PANE.item());
        copy(ModTags.STAINED_VANILLA_GLASS_ALL.block(), ModTags.STAINED_VANILLA_GLASS_ALL.item());
        copy(ModTags.STAINED_VANILLA_GLASS_BLOCK.block(), ModTags.STAINED_VANILLA_GLASS_BLOCK.item());
        copy(ModTags.STAINED_VANILLA_GLASS_PANE.block(), ModTags.STAINED_VANILLA_GLASS_PANE.item());
        copy(ModTags.COLORED_VANILLA_GLASS_ALL.block(), ModTags.COLORED_VANILLA_GLASS_ALL.item());
        copy(ModTags.COLORED_VANILLA_GLASS_BLOCK.block(), ModTags.COLORED_VANILLA_GLASS_BLOCK.item());
        copy(ModTags.COLORED_VANILLA_GLASS_PANE.block(), ModTags.COLORED_VANILLA_GLASS_PANE.item());
        copy(ModTags.COLORED_TINTED_GLASS_BLOCK.block(), ModTags.COLORED_TINTED_GLASS_BLOCK.item());
        copy(ModTags.COLORED_TINTED_GLASS_PANE.block(), ModTags.COLORED_TINTED_GLASS_PANE.item());
        copy(ModTags.COLORED_TINTED_GLASS_ALL.block(), ModTags.COLORED_TINTED_GLASS_ALL.item());
        copy(ModTags.CLEAR_TINTED_GLASS_BLOCK.block(), ModTags.CLEAR_TINTED_GLASS_BLOCK.item());
        copy(ModTags.CLEAR_TINTED_GLASS_PANE.block(), ModTags.CLEAR_TINTED_GLASS_PANE.item());
        copy(ModTags.CLEAR_TINTED_GLASS_ALL.block(), ModTags.CLEAR_TINTED_GLASS_ALL.item());
        copy(ModTags.SCRATCHED_TINTED_GLASS_BLOCK.block(), ModTags.SCRATCHED_TINTED_GLASS_BLOCK.item());
        copy(ModTags.SCRATCHED_TINTED_GLASS_PANE.block(), ModTags.SCRATCHED_TINTED_GLASS_PANE.item());
        copy(ModTags.SCRATCHED_TINTED_GLASS_ALL.block(), ModTags.SCRATCHED_TINTED_GLASS_ALL.item());
        copy(ModTags.ANY_COLORED_TINTED_GLASS_BLOCK.block(), ModTags.ANY_COLORED_TINTED_GLASS_BLOCK.item());
        copy(ModTags.ANY_COLORED_TINTED_GLASS_PANE.block(), ModTags.ANY_COLORED_TINTED_GLASS_PANE.item());
        copy(ModTags.ANY_COLORED_TINTED_GLASS_ALL.block(), ModTags.ANY_COLORED_TINTED_GLASS_ALL.item());
        copy(ModTags.STAINED_TINTED_GLASS_BLOCK.block(), ModTags.STAINED_TINTED_GLASS_BLOCK.item());
        copy(ModTags.STAINED_TINTED_GLASS_PANE.block(), ModTags.STAINED_TINTED_GLASS_PANE.item());
        copy(ModTags.STAINED_TINTED_GLASS_ALL.block(), ModTags.STAINED_TINTED_GLASS_ALL.item());
        copy(ModTags.COLORED_CLEAR_TINTED_GLASS_BLOCK.block(), ModTags.COLORED_CLEAR_TINTED_GLASS_BLOCK.item());
        copy(ModTags.COLORED_CLEAR_TINTED_GLASS_PANE.block(), ModTags.COLORED_CLEAR_TINTED_GLASS_PANE.item());
        copy(ModTags.COLORED_CLEAR_TINTED_GLASS_ALL.block(), ModTags.COLORED_CLEAR_TINTED_GLASS_ALL.item());
        copy(ModTags.STAINED_CLEAR_TINTED_GLASS_BLOCK.block(), ModTags.STAINED_CLEAR_TINTED_GLASS_BLOCK.item());
        copy(ModTags.STAINED_CLEAR_TINTED_GLASS_PANE.block(), ModTags.STAINED_CLEAR_TINTED_GLASS_PANE.item());
        copy(ModTags.STAINED_CLEAR_TINTED_GLASS_ALL.block(), ModTags.STAINED_CLEAR_TINTED_GLASS_ALL.item());
        copy(ModTags.COLORED_SCRATCHED_TINTED_GLASS_BLOCK.block(), ModTags.COLORED_SCRATCHED_TINTED_GLASS_BLOCK.item());
        copy(ModTags.COLORED_SCRATCHED_TINTED_GLASS_PANE.block(), ModTags.COLORED_SCRATCHED_TINTED_GLASS_PANE.item());
        copy(ModTags.COLORED_SCRATCHED_TINTED_GLASS_ALL.block(), ModTags.COLORED_SCRATCHED_TINTED_GLASS_ALL.item());
        copy(ModTags.STAINED_SCRATCHED_TINTED_GLASS_BLOCK.block(), ModTags.STAINED_SCRATCHED_TINTED_GLASS_BLOCK.item());
        copy(ModTags.STAINED_SCRATCHED_TINTED_GLASS_PANE.block(), ModTags.STAINED_SCRATCHED_TINTED_GLASS_PANE.item());
        copy(ModTags.STAINED_SCRATCHED_TINTED_GLASS_ALL.block(), ModTags.STAINED_SCRATCHED_TINTED_GLASS_ALL.item());
    }
}
