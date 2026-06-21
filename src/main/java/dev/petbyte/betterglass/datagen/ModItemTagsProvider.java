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

import static dev.petbyte.betterglass.BetterGlassUtils.addAll;
import static dev.petbyte.betterglass.BetterGlassUtils.itemKey;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, ModBlockTagsProvider modBlockTagsProvider) {
        super(output, registryLookupFuture, modBlockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        var conventionalTagGlassBlocksColorless = builder(ConventionalItemTags.GLASS_BLOCKS_COLORLESS);

        for (Block block : ModBlocks.BETTER_GLASS_BLOCKS) {
            builder(ConventionalItemTags.GLASS_BLOCKS).add(itemKey(block.asItem()));
            if (ModBlocks.BETTER_GLASS_CHISELED_ALL.contains(block)) { continue; }
            if (ModBlockLootTableProvider.isTinted(block)) {
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

        for (ModTags.TagPair tag : ModTags.ALL_TAG_PAIRS) {
            copy(tag.block(), tag.item());
        }
    }
}
