package dev.petbyte.betterglass.datagen;

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

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        for (Block block : ModBlocks.BETTER_GLASS_BLOCKS) {
            valueLookupBuilder(BlockTags.IMPERMEABLE).add(block);
            valueLookupBuilder(ConventionalBlockTags.GLASS_BLOCKS).add(block);
            valueLookupBuilder(ConventionalBlockTags.GLASS_BLOCKS_CHEAP).add(block);
        }

        for (DyeColor color : DyeColor.values()) {
            TagKey<Block> colorDyedTag = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "dyed/" + color.getName()));

            Block[] dyedBlocks = {
                    ModBlocks.COLORED_CLEAR_GLASS.get(color),
                    ModBlocks.COLORED_SCRATCHED_GLASS.get(color),
                    ModBlocks.STAINED_CLEAR_GLASS.get(color),
                    ModBlocks.STAINED_SCRATCHED_GLASS.get(color)
            };

            valueLookupBuilder(colorDyedTag).add(dyedBlocks);
            valueLookupBuilder(ConventionalBlockTags.DYED).add(dyedBlocks);
        }

        valueLookupBuilder(ConventionalBlockTags.GLASS_BLOCKS_COLORLESS)
                .add(ModBlocks.CLEAR_GLASS)
                .add(ModBlocks.SCRATCHED_GLASS);


        valueLookupBuilder(ModTags.CLEAR_GLASS_BLOCK.block())
                .add(ModBlocks.CLEAR_GLASS)
                .addAll(ModBlocks.COLORED_CLEAR_GLASS.values())
                .addAll(ModBlocks.STAINED_CLEAR_GLASS.values());

        valueLookupBuilder(ModTags.CLEAR_GLASS_PANE.block())
                .add(ModBlocks.CLEAR_GLASS_PANE);

        valueLookupBuilder(ModTags.SCRATCHED_GLASS_BLOCK.block())
                .add(ModBlocks.SCRATCHED_GLASS)
                .addAll(ModBlocks.COLORED_SCRATCHED_GLASS.values())
                .addAll(ModBlocks.STAINED_SCRATCHED_GLASS.values());

        valueLookupBuilder(ModTags.COLORED_GLASS_BLOCK.block())
                .addAll(ModBlocks.COLORED_CLEAR_GLASS.values())
                .addAll(ModBlocks.COLORED_SCRATCHED_GLASS.values())
                .addAll(ModBlocks.COLORED_VANILLA_GLASS.values());

        valueLookupBuilder(ModTags.STAINED_GLASS_BLOCK.block())
                .addAll(ModBlocks.STAINED_CLEAR_GLASS.values())
                .addAll(ModBlocks.STAINED_SCRATCHED_GLASS.values());

        valueLookupBuilder(ModTags.COLORED_CLEAR_GLASS_BLOCK.block())
                .addAll(ModBlocks.COLORED_CLEAR_GLASS.values());

        valueLookupBuilder(ModTags.COLORED_SCRATCHED_GLASS_BLOCK.block())
                .addAll(ModBlocks.COLORED_SCRATCHED_GLASS.values());

        valueLookupBuilder(ModTags.STAINED_CLEAR_GLASS_BLOCK.block())
                .addAll(ModBlocks.STAINED_CLEAR_GLASS.values());

        valueLookupBuilder(ModTags.STAINED_SCRATCHED_GLASS_BLOCK.block())
                .addAll(ModBlocks.STAINED_SCRATCHED_GLASS.values());

        valueLookupBuilder(ModTags.STAINED_VANILLA_GLASS_BLOCK.block()).add(Blocks.WHITE_STAINED_GLASS)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS).add(Blocks.GRAY_STAINED_GLASS).add(Blocks.BLACK_STAINED_GLASS)
                .add(Blocks.BROWN_STAINED_GLASS).add(Blocks.RED_STAINED_GLASS).add(Blocks.YELLOW_STAINED_GLASS)
                .add(Blocks.ORANGE_STAINED_GLASS).add(Blocks.LIME_STAINED_GLASS).add(Blocks.GREEN_STAINED_GLASS)
                .add(Blocks.CYAN_STAINED_GLASS).add(Blocks.LIGHT_BLUE_STAINED_GLASS).add(Blocks.BLUE_STAINED_GLASS)
                .add(Blocks.PURPLE_STAINED_GLASS).add(Blocks.MAGENTA_STAINED_GLASS).add(Blocks.PINK_STAINED_GLASS);

        valueLookupBuilder(ModTags.STAINED_VANILLA_GLASS_PANE.block()).add(Blocks.WHITE_STAINED_GLASS_PANE)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE).add(Blocks.GRAY_STAINED_GLASS_PANE).add(Blocks.BLACK_STAINED_GLASS_PANE)
                .add(Blocks.BROWN_STAINED_GLASS_PANE).add(Blocks.RED_STAINED_GLASS_PANE).add(Blocks.YELLOW_STAINED_GLASS_PANE)
                .add(Blocks.ORANGE_STAINED_GLASS_PANE).add(Blocks.LIME_STAINED_GLASS_PANE).add(Blocks.GREEN_STAINED_GLASS_PANE)
                .add(Blocks.CYAN_STAINED_GLASS_PANE).add(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE).add(Blocks.BLUE_STAINED_GLASS_PANE)
                .add(Blocks.PURPLE_STAINED_GLASS_PANE).add(Blocks.MAGENTA_STAINED_GLASS_PANE).add(Blocks.PINK_STAINED_GLASS_PANE);

        valueLookupBuilder(ModTags.COLORED_VANILLA_GLASS_BLOCK.block())
                .addAll(ModBlocks.COLORED_VANILLA_GLASS.values());


        valueLookupBuilder(ModTags.STAINED_VANILLA_GLASS_ALL.block())
                .addTag(ModTags.STAINED_VANILLA_GLASS_BLOCK.block())
                .addTag(ModTags.STAINED_VANILLA_GLASS_PANE.block());


        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.GLASSCUTTER);
    }
}
