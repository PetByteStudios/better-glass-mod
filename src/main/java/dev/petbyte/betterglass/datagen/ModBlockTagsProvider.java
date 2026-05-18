package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
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

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
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
    }
}
