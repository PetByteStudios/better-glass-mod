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

        copy(ModTags.Blocks.CLEAR_GLASS, ModTags.Items.CLEAR_GLASS);
        copy(ModTags.Blocks.SCRATCHED_GLASS, ModTags.Items.SCRATCHED_GLASS);
        copy(ModTags.Blocks.COLORED_GLASS, ModTags.Items.COLORED_GLASS);
        copy(ModTags.Blocks.STAINED_GLASS, ModTags.Items.STAINED_GLASS);
        copy(ModTags.Blocks.COLORED_CLEAR_GLASS, ModTags.Items.COLORED_CLEAR_GLASS);
        copy(ModTags.Blocks.STAINED_CLEAR_GLASS, ModTags.Items.STAINED_CLEAR_GLASS);
        copy(ModTags.Blocks.COLORED_SCRATCHED_GLASS, ModTags.Items.COLORED_SCRATCHED_GLASS);
        copy(ModTags.Blocks.STAINED_SCRATCHED_GLASS, ModTags.Items.STAINED_SCRATCHED_GLASS);
        copy(ModTags.Blocks.STAINED_VANILLA_GLASS_BLOCK, ModTags.Items.STAINED_VANILLA_GLASS_BLOCK);
        copy(ModTags.Blocks.STAINED_VANILLA_GLASS_PANE, ModTags.Items.STAINED_VANILLA_GLASS_PANE);
        copy(ModTags.Blocks.COLORED_VANILLA_GLASS, ModTags.Items.COLORED_VANILLA_GLASS);
        copy(ModTags.Blocks.CLEAR_GLASS_PANE, ModTags.Items.CLEAR_GLASS_PANE);
    }
}
