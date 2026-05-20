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
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
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

        valueLookupBuilder(ModTags.Items.CLEAR_GLASS).add(ModBlocks.CLEAR_GLASS.asItem())
                .addAll(ModBlocks.COLORED_CLEAR_GLASS.values().stream().map(Block::asItem).toList())
                .addAll(ModBlocks.STAINED_CLEAR_GLASS.values().stream().map(Block::asItem).toList());
        valueLookupBuilder(ModTags.Items.SCRATCHED_GLASS).add(ModBlocks.SCRATCHED_GLASS.asItem())
                .addAll(ModBlocks.COLORED_SCRATCHED_GLASS.values().stream().map(Block::asItem).toList())
                .addAll(ModBlocks.STAINED_SCRATCHED_GLASS.values().stream().map(Block::asItem).toList());
        valueLookupBuilder(ModTags.Items.COLORED_GLASS)
                .addAll(ModBlocks.COLORED_CLEAR_GLASS.values().stream().map(Block::asItem).toList())
                .addAll(ModBlocks.COLORED_SCRATCHED_GLASS.values().stream().map(Block::asItem).toList());
        valueLookupBuilder(ModTags.Items.STAINED_GLASS)
                .addAll(ModBlocks.STAINED_CLEAR_GLASS.values().stream().map(Block::asItem).toList())
                .addAll(ModBlocks.STAINED_SCRATCHED_GLASS.values().stream().map(Block::asItem).toList());
        valueLookupBuilder(ModTags.Items.COLORED_CLEAR_GLASS)
                .addAll(ModBlocks.COLORED_CLEAR_GLASS.values().stream().map(Block::asItem).toList());
        valueLookupBuilder(ModTags.Items.STAINED_CLEAR_GLASS)
                .addAll(ModBlocks.STAINED_CLEAR_GLASS.values().stream().map(Block::asItem).toList());
        valueLookupBuilder(ModTags.Items.COLORED_SCRATCHED_GLASS)
                .addAll(ModBlocks.COLORED_SCRATCHED_GLASS.values().stream().map(Block::asItem).toList());
        valueLookupBuilder(ModTags.Items.STAINED_SCRATCHED_GLASS)
                .addAll(ModBlocks.STAINED_SCRATCHED_GLASS.values().stream().map(Block::asItem).toList());
    }
}
