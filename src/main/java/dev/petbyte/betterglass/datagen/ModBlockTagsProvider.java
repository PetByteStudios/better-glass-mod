package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.BetterGlassUtils;
import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

import static dev.petbyte.betterglass.BetterGlassUtils.*;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        var tagClearGlassBlock = builder(ModTags.CLEAR_GLASS_BLOCK.block());
        var tagClearGlassPane = builder(ModTags.CLEAR_GLASS_PANE.block());
        var tagScratchedGlassBlock = builder(ModTags.SCRATCHED_GLASS_BLOCK.block());
        var tagScratchedGlassPane = builder(ModTags.SCRATCHED_GLASS_PANE.block());
        var tagColoredGlassBlock = builder(ModTags.COLORED_GLASS_BLOCK.block());
        var tagColoredGlassPane = builder(ModTags.COLORED_GLASS_PANE.block());
        var tagStainedGlassBlock = builder(ModTags.STAINED_GLASS_BLOCK.block());
        var tagStainedGlassPane = builder(ModTags.STAINED_GLASS_PANE.block());

        var tagClearTintedGlassBlock = builder(ModTags.CLEAR_TINTED_GLASS_BLOCK.block());
        var tagClearTintedGlassPane = builder(ModTags.CLEAR_TINTED_GLASS_PANE.block());
        var tagScratchedTintedGlassBlock = builder(ModTags.SCRATCHED_TINTED_GLASS_BLOCK.block());
        var tagScratchedTintedGlassPane = builder(ModTags.SCRATCHED_TINTED_GLASS_PANE.block());
        var tagColoredTintedGlassBlock = builder(ModTags.COLORED_TINTED_GLASS_BLOCK.block());
        var tagColoredTintedGlassPane = builder(ModTags.COLORED_TINTED_GLASS_PANE.block());
        var tagStainedTintedGlassBlock = builder(ModTags.STAINED_TINTED_GLASS_BLOCK.block());
        var tagStainedTintedGlassPane = builder(ModTags.STAINED_TINTED_GLASS_PANE.block());
        var tagAnyColoredTintedGlassBlock = builder(ModTags.ANY_COLORED_TINTED_GLASS_BLOCK.block());
        var tagAnyColoredTintedGlassPane = builder(ModTags.ANY_COLORED_TINTED_GLASS_PANE.block());

        for (Block block : ModBlocks.BETTER_GLASS_BLOCKS) {
            builder(BlockTags.IMPERMEABLE).add(blockKey(block));
            builder(ConventionalBlockTags.GLASS_BLOCKS).add(blockKey(block));
            if (ModBlocks.BETTER_GLASS_CHISELED_ALL.contains(block)) { continue; }
            if (blockKey(block).toString().contains("tinted")) {
                builder(ConventionalBlockTags.GLASS_BLOCKS_TINTED).add(blockKey(block));
            } else {
                builder(ConventionalBlockTags.GLASS_BLOCKS_CHEAP).add(blockKey(block));
            }
        }

        for (DyeColor color : DyeColor.values()) {
            TagKey<Block> colorDyedTag = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "dyed/" + color.getName()));

            Block[] dyedBlocks = {
                    ModBlocks.COLORED_CLEAR_GLASS.get(color),
                    ModBlocks.COLORED_SCRATCHED_GLASS.get(color),
                    ModBlocks.STAINED_CLEAR_GLASS.get(color),
                    ModBlocks.STAINED_SCRATCHED_GLASS.get(color)
            };

            addAll(builder(colorDyedTag), dyedBlocks);
            addAll(builder(ConventionalBlockTags.DYED), dyedBlocks);
        }

        builder(ConventionalBlockTags.GLASS_BLOCKS_COLORLESS)
                .add(blockKey(ModBlocks.CLEAR_GLASS))
                .add(blockKey(ModBlocks.SCRATCHED_GLASS));

        builder(ConventionalBlockTags.GLASS_PANES_COLORLESS)
                .add(blockKey(ModBlocks.CLEAR_GLASS_PANE))
                .add(blockKey(ModBlocks.SCRATCHED_GLASS_PANE));

        addAll(tagClearGlassBlock, ModBlocks.COLORED_CLEAR_GLASS.values().toArray(new Block[0]));
        addAll(tagClearGlassBlock, ModBlocks.STAINED_CLEAR_GLASS.values().toArray(new Block[0]));
        tagClearGlassBlock.add(blockKey(ModBlocks.CLEAR_GLASS));

        addAll(tagClearGlassPane, ModBlocks.COLORED_CLEAR_GLASS.values().toArray(new Block[0]));
        addAll(tagClearGlassPane, ModBlocks.STAINED_CLEAR_GLASS.values().toArray(new Block[0]));
        tagClearGlassPane.add(blockKey(ModBlocks.CLEAR_GLASS));

        addAll(tagScratchedGlassBlock, ModBlocks.COLORED_SCRATCHED_GLASS.values().toArray(new Block[0]));
        addAll(tagScratchedGlassBlock, ModBlocks.STAINED_SCRATCHED_GLASS.values().toArray(new Block[0]));
        tagScratchedGlassBlock.add(blockKey(ModBlocks.SCRATCHED_GLASS));

        addAll(tagScratchedGlassPane, ModBlocks.COLORED_SCRATCHED_GLASS.values().toArray(new Block[0]));
        addAll(tagScratchedGlassPane, ModBlocks.STAINED_SCRATCHED_GLASS.values().toArray(new Block[0]));
        tagScratchedGlassPane.add(blockKey(ModBlocks.SCRATCHED_GLASS));

        addAll(tagColoredGlassBlock, ModBlocks.COLORED_CLEAR_GLASS.values().toArray(new Block[0]));
        addAll(tagColoredGlassBlock, ModBlocks.COLORED_SCRATCHED_GLASS.values().toArray(new Block[0]));
        addAll(tagColoredGlassBlock, ModBlocks.COLORED_VANILLA_GLASS.values().toArray(new Block[0]));

        addAll(tagColoredGlassPane, ModBlocks.COLORED_CLEAR_GLASS_PANE.values().toArray(new Block[0]));
        addAll(tagColoredGlassPane, ModBlocks.COLORED_SCRATCHED_GLASS_PANE.values().toArray(new Block[0]));
        addAll(tagColoredGlassPane, ModBlocks.COLORED_VANILLA_GLASS_PANE.values().toArray(new Block[0]));

        addAll(tagStainedGlassBlock, ModBlocks.STAINED_CLEAR_GLASS.values().toArray(new Block[0]));
        addAll(tagStainedGlassBlock, ModBlocks.STAINED_SCRATCHED_GLASS.values().toArray(new Block[0]));

        addAll(tagStainedGlassPane, ModBlocks.STAINED_CLEAR_GLASS_PANE.values().toArray(new Block[0]));
        addAll(tagStainedGlassPane, ModBlocks.STAINED_SCRATCHED_GLASS_PANE.values().toArray(new Block[0]));

        addAll(builder(ModTags.COLORED_CLEAR_GLASS_BLOCK.block()), ModBlocks.COLORED_CLEAR_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.COLORED_CLEAR_GLASS_PANE.block()), ModBlocks.COLORED_CLEAR_GLASS_PANE.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_CLEAR_GLASS_BLOCK.block()), ModBlocks.STAINED_CLEAR_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_CLEAR_GLASS_PANE.block()), ModBlocks.STAINED_CLEAR_GLASS_PANE.values().toArray(new Block[0]));

        addAll(builder(ModTags.COLORED_SCRATCHED_GLASS_BLOCK.block()), ModBlocks.COLORED_SCRATCHED_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.COLORED_SCRATCHED_GLASS_PANE.block()), ModBlocks.COLORED_SCRATCHED_GLASS_PANE.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_SCRATCHED_GLASS_BLOCK.block()), ModBlocks.STAINED_SCRATCHED_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_SCRATCHED_GLASS_PANE.block()), ModBlocks.STAINED_SCRATCHED_GLASS_PANE.values().toArray(new Block[0]));

        builder(ModTags.STAINED_VANILLA_GLASS_BLOCK.block()).addAll(Blocks.STAINED_GLASS.map(BetterGlassUtils::blockKey));
        builder(ModTags.STAINED_VANILLA_GLASS_PANE.block()).addAll(Blocks.STAINED_GLASS_PANE.map(BetterGlassUtils::blockKey));

        addAll(builder(ModTags.COLORED_VANILLA_GLASS_BLOCK.block()), ModBlocks.COLORED_VANILLA_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.COLORED_VANILLA_GLASS_PANE.block()), ModBlocks.COLORED_VANILLA_GLASS_PANE.values().toArray(new Block[0]));

        addAll(builder(ModTags.COLORED_TINTED_GLASS_BLOCK.block()), ModBlocks.COLORED_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.COLORED_TINTED_GLASS_PANE.block()), ModBlocks.COLORED_TINTED_GLASS_PANE.values().toArray(new Block[0]));



        addAll(tagClearTintedGlassBlock, ModBlocks.COLORED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(tagClearTintedGlassBlock, ModBlocks.STAINED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        tagClearTintedGlassBlock.add(blockKey(ModBlocks.CLEAR_TINTED_GLASS));

        addAll(tagClearTintedGlassPane, ModBlocks.COLORED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(tagClearTintedGlassPane, ModBlocks.STAINED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        tagClearTintedGlassPane.add(blockKey(ModBlocks.CLEAR_TINTED_GLASS));

        addAll(tagScratchedTintedGlassBlock, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(tagScratchedTintedGlassBlock, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));
        tagScratchedTintedGlassBlock.add(blockKey(ModBlocks.SCRATCHED_TINTED_GLASS));

        addAll(tagScratchedTintedGlassPane, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(tagScratchedTintedGlassPane, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));
        tagScratchedTintedGlassPane.add(blockKey(ModBlocks.SCRATCHED_TINTED_GLASS));

        addAll(tagAnyColoredTintedGlassBlock, ModBlocks.COLORED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(tagAnyColoredTintedGlassBlock, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(tagAnyColoredTintedGlassBlock, ModBlocks.COLORED_TINTED_GLASS.values().toArray(new Block[0]));

        addAll(tagColoredTintedGlassBlock, ModBlocks.COLORED_TINTED_GLASS.values().toArray(new Block[0]));

        addAll(tagAnyColoredTintedGlassPane, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE.values().toArray(new Block[0]));
        addAll(tagAnyColoredTintedGlassPane, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE.values().toArray(new Block[0]));
        addAll(tagAnyColoredTintedGlassPane, ModBlocks.COLORED_TINTED_GLASS_PANE.values().toArray(new Block[0]));

        addAll(tagColoredTintedGlassPane, ModBlocks.COLORED_TINTED_GLASS_PANE.values().toArray(new Block[0]));

        addAll(tagStainedTintedGlassBlock, ModBlocks.STAINED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(tagStainedTintedGlassBlock, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));

        addAll(tagStainedTintedGlassPane, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE.values().toArray(new Block[0]));
        addAll(tagStainedTintedGlassPane, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE.values().toArray(new Block[0]));

        addAll(builder(ModTags.COLORED_CLEAR_TINTED_GLASS_BLOCK.block()), ModBlocks.COLORED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.COLORED_CLEAR_TINTED_GLASS_PANE.block()), ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_CLEAR_TINTED_GLASS_BLOCK.block()), ModBlocks.STAINED_CLEAR_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_CLEAR_TINTED_GLASS_PANE.block()), ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE.values().toArray(new Block[0]));

        addAll(builder(ModTags.COLORED_SCRATCHED_TINTED_GLASS_BLOCK.block()), ModBlocks.COLORED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.COLORED_SCRATCHED_TINTED_GLASS_PANE.block()), ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_SCRATCHED_TINTED_GLASS_BLOCK.block()), ModBlocks.STAINED_SCRATCHED_TINTED_GLASS.values().toArray(new Block[0]));
        addAll(builder(ModTags.STAINED_SCRATCHED_TINTED_GLASS_PANE.block()), ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE.values().toArray(new Block[0]));

        builder(ModTags.CLEAR_GLASS_ALL.block())
                .addTag(ModTags.CLEAR_GLASS_BLOCK.block())
                .addTag(ModTags.CLEAR_GLASS_PANE.block());

        builder(ModTags.SCRATCHED_GLASS_ALL.block())
                .addTag(ModTags.SCRATCHED_GLASS_BLOCK.block())
                .addTag(ModTags.SCRATCHED_GLASS_PANE.block());

        builder(ModTags.COLORED_GLASS_ALL.block())
                .addTag(ModTags.COLORED_GLASS_BLOCK.block())
                .addTag(ModTags.COLORED_GLASS_PANE.block());

        builder(ModTags.STAINED_GLASS_ALL.block())
                .addTag(ModTags.STAINED_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_GLASS_PANE.block());

        builder(ModTags.COLORED_CLEAR_GLASS_ALL.block())
                .addTag(ModTags.COLORED_CLEAR_GLASS_BLOCK.block())
                .addTag(ModTags.COLORED_CLEAR_GLASS_PANE.block());

        builder(ModTags.STAINED_CLEAR_GLASS_ALL.block())
                .addTag(ModTags.STAINED_CLEAR_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_CLEAR_GLASS_PANE.block());

        builder(ModTags.COLORED_SCRATCHED_GLASS_ALL.block())
                .addTag(ModTags.COLORED_SCRATCHED_GLASS_BLOCK.block())
                .addTag(ModTags.COLORED_SCRATCHED_GLASS_PANE.block());

        builder(ModTags.STAINED_SCRATCHED_GLASS_ALL.block())
                .addTag(ModTags.STAINED_SCRATCHED_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_SCRATCHED_GLASS_PANE.block());

        builder(ModTags.STAINED_VANILLA_GLASS_ALL.block())
                .addTag(ModTags.STAINED_VANILLA_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_VANILLA_GLASS_PANE.block());

        builder(ModTags.COLORED_VANILLA_GLASS_ALL.block())
                .addTag(ModTags.COLORED_VANILLA_GLASS_BLOCK.block())
                .addTag(ModTags.COLORED_VANILLA_GLASS_PANE.block());

        builder(ModTags.COLORED_TINTED_GLASS_ALL.block())
                .addTag(ModTags.COLORED_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.COLORED_TINTED_GLASS_PANE.block());

        builder(ModTags.CLEAR_TINTED_GLASS_ALL.block())
                .addTag(ModTags.CLEAR_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.CLEAR_TINTED_GLASS_PANE.block());

        builder(ModTags.SCRATCHED_TINTED_GLASS_ALL.block())
                .addTag(ModTags.SCRATCHED_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.SCRATCHED_TINTED_GLASS_PANE.block());

        builder(ModTags.ANY_COLORED_TINTED_GLASS_ALL.block())
                .addTag(ModTags.ANY_COLORED_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.ANY_COLORED_TINTED_GLASS_PANE.block());

        builder(ModTags.STAINED_TINTED_GLASS_ALL.block())
                .addTag(ModTags.STAINED_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_TINTED_GLASS_PANE.block());

        builder(ModTags.COLORED_CLEAR_TINTED_GLASS_ALL.block())
                .addTag(ModTags.COLORED_CLEAR_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.COLORED_CLEAR_TINTED_GLASS_PANE.block());

        builder(ModTags.STAINED_CLEAR_TINTED_GLASS_ALL.block())
                .addTag(ModTags.STAINED_CLEAR_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_CLEAR_TINTED_GLASS_PANE.block());

        builder(ModTags.COLORED_SCRATCHED_TINTED_GLASS_ALL.block())
                .addTag(ModTags.COLORED_SCRATCHED_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.COLORED_SCRATCHED_TINTED_GLASS_PANE.block());

        builder(ModTags.STAINED_SCRATCHED_TINTED_GLASS_ALL.block())
                .addTag(ModTags.STAINED_SCRATCHED_TINTED_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_SCRATCHED_TINTED_GLASS_PANE.block());


        builder(BlockTags.MINEABLE_WITH_PICKAXE).add(blockKey(ModBlocks.GLASSCUTTER));
    }
}
