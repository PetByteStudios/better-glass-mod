package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final Map<DyeColor, Item> DYES = Map.ofEntries(
            Map.entry(DyeColor.WHITE, Items.WHITE_DYE),
            Map.entry(DyeColor.LIGHT_GRAY, Items.LIGHT_GRAY_DYE),
            Map.entry(DyeColor.GRAY, Items.GRAY_DYE),
            Map.entry(DyeColor.BLACK, Items.BLACK_DYE),
            Map.entry(DyeColor.BROWN, Items.BROWN_DYE),
            Map.entry(DyeColor.RED, Items.RED_DYE),
            Map.entry(DyeColor.ORANGE, Items.ORANGE_DYE),
            Map.entry(DyeColor.YELLOW, Items.YELLOW_DYE),
            Map.entry(DyeColor.LIME, Items.LIME_DYE),
            Map.entry(DyeColor.GREEN, Items.GREEN_DYE),
            Map.entry(DyeColor.CYAN, Items.CYAN_DYE),
            Map.entry(DyeColor.LIGHT_BLUE, Items.LIGHT_BLUE_DYE),
            Map.entry(DyeColor.BLUE, Items.BLUE_DYE),
            Map.entry(DyeColor.PURPLE, Items.PURPLE_DYE),
            Map.entry(DyeColor.MAGENTA, Items.MAGENTA_DYE),
            Map.entry(DyeColor.PINK, Items.PINK_DYE)
    );

    private static final Map<DyeColor, Block> STAINED_VANILLA_GLASS_BLOCK = Map.ofEntries(
            Map.entry(DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS),
            Map.entry(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS),
            Map.entry(DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS),
            Map.entry(DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS),
            Map.entry(DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS),
            Map.entry(DyeColor.RED, Blocks.RED_STAINED_GLASS),
            Map.entry(DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS),
            Map.entry(DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS),
            Map.entry(DyeColor.LIME, Blocks.LIME_STAINED_GLASS),
            Map.entry(DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS),
            Map.entry(DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS),
            Map.entry(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS),
            Map.entry(DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS),
            Map.entry(DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS),
            Map.entry(DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS),
            Map.entry(DyeColor.PINK, Blocks.PINK_STAINED_GLASS)
    );

    private static final Map<DyeColor, Block> STAINED_VANILLA_GLASS_PANE = Map.ofEntries(
            Map.entry(DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS_PANE),
            Map.entry(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE),
            Map.entry(DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS_PANE),
            Map.entry(DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS_PANE),
            Map.entry(DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS_PANE),
            Map.entry(DyeColor.RED, Blocks.RED_STAINED_GLASS_PANE),
            Map.entry(DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS_PANE),
            Map.entry(DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS_PANE),
            Map.entry(DyeColor.LIME, Blocks.LIME_STAINED_GLASS_PANE),
            Map.entry(DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS_PANE),
            Map.entry(DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS_PANE),
            Map.entry(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE),
            Map.entry(DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS_PANE),
            Map.entry(DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS_PANE),
            Map.entry(DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS_PANE),
            Map.entry(DyeColor.PINK, Blocks.PINK_STAINED_GLASS_PANE)
    );

    private static final Map<String, TagKey<Item>> itemTags = Map.<String, TagKey<Item>>ofEntries(
            Map.entry("clear_glass_all", ModTags.CLEAR_GLASS_ALL.item()),
            Map.entry("clear_glass_block", ModTags.CLEAR_GLASS_BLOCK.item()),
            Map.entry("clear_glass_pane", ModTags.CLEAR_GLASS_PANE.item()),
            Map.entry("scratched_glass_all", ModTags.SCRATCHED_GLASS_ALL.item()),
            Map.entry("scratched_glass_block", ModTags.SCRATCHED_GLASS_BLOCK.item()),
            Map.entry("scratched_glass_pane", ModTags.SCRATCHED_GLASS_PANE.item()),
            Map.entry("colored_glass_all", ModTags.COLORED_GLASS_ALL.item()),
            Map.entry("colored_glass_block", ModTags.COLORED_GLASS_BLOCK.item()),
            Map.entry("colored_glass_pane", ModTags.COLORED_GLASS_PANE.item()),
            Map.entry("stained_glass_all", ModTags.STAINED_GLASS_ALL.item()),
            Map.entry("stained_glass_block", ModTags.STAINED_GLASS_BLOCK.item()),
            Map.entry("stained_glass_pane", ModTags.STAINED_GLASS_PANE.item()),
            Map.entry("colored_clear_glass_all", ModTags.COLORED_CLEAR_GLASS_ALL.item()),
            Map.entry("colored_clear_glass_block", ModTags.COLORED_CLEAR_GLASS_BLOCK.item()),
            Map.entry("colored_clear_glass_pane", ModTags.COLORED_CLEAR_GLASS_PANE.item()),
            Map.entry("stained_clear_glass_all", ModTags.STAINED_CLEAR_GLASS_ALL.item()),
            Map.entry("stained_clear_glass_block", ModTags.STAINED_CLEAR_GLASS_BLOCK.item()),
            Map.entry("stained_clear_glass_pane", ModTags.STAINED_CLEAR_GLASS_PANE.item()),
            Map.entry("colored_scratched_glass_all", ModTags.COLORED_SCRATCHED_GLASS_ALL.item()),
            Map.entry("colored_scratched_glass_block", ModTags.COLORED_SCRATCHED_GLASS_BLOCK.item()),
            Map.entry("colored_scratched_glass_pane", ModTags.COLORED_SCRATCHED_GLASS_PANE.item()),
            Map.entry("stained_scratched_glass_all", ModTags.STAINED_SCRATCHED_GLASS_ALL.item()),
            Map.entry("stained_scratched_glass_block", ModTags.STAINED_SCRATCHED_GLASS_BLOCK.item()),
            Map.entry("stained_scratched_glass_pane", ModTags.STAINED_SCRATCHED_GLASS_PANE.item()),
            Map.entry("stained_vanilla_glass_all", ModTags.STAINED_VANILLA_GLASS_ALL.item()),
            Map.entry("stained_vanilla_glass_block", ModTags.STAINED_VANILLA_GLASS_BLOCK.item()),
            Map.entry("stained_vanilla_glass_pane", ModTags.STAINED_VANILLA_GLASS_PANE.item()),
            Map.entry("colored_vanilla_glass_all", ModTags.COLORED_VANILLA_GLASS_ALL.item()),
            Map.entry("colored_vanilla_glass_block", ModTags.COLORED_VANILLA_GLASS_BLOCK.item()),
            Map.entry("colored_vanilla_glass_pane", ModTags.COLORED_VANILLA_GLASS_PANE.item()),
            Map.entry("colored_tinted_glass_block", ModTags.COLORED_TINTED_GLASS_BLOCK.item()),
            Map.entry("colored_tinted_glass_pane", ModTags.COLORED_TINTED_GLASS_PANE.item()),
            Map.entry("colored_tinted_glass_all", ModTags.COLORED_TINTED_GLASS_ALL.item()),
            Map.entry("clear_tinted_glass_block", ModTags.CLEAR_TINTED_GLASS_BLOCK.item()),
            Map.entry("clear_tinted_glass_pane", ModTags.CLEAR_TINTED_GLASS_PANE.item()),
            Map.entry("clear_tinted_glass_all", ModTags.CLEAR_TINTED_GLASS_ALL.item()),
            Map.entry("scratched_tinted_glass_block", ModTags.SCRATCHED_TINTED_GLASS_BLOCK.item()),
            Map.entry("scratched_tinted_glass_pane", ModTags.SCRATCHED_TINTED_GLASS_PANE.item()),
            Map.entry("scratched_tinted_glass_all", ModTags.SCRATCHED_TINTED_GLASS_ALL.item()),
            Map.entry("any_colored_tinted_glass_block", ModTags.ANY_COLORED_TINTED_GLASS_BLOCK.item()),
            Map.entry("any_colored_tinted_glass_pane", ModTags.ANY_COLORED_TINTED_GLASS_PANE.item()),
            Map.entry("any_colored_tinted_glass_all", ModTags.ANY_COLORED_TINTED_GLASS_ALL.item()),
            Map.entry("stained_tinted_glass_block", ModTags.STAINED_TINTED_GLASS_BLOCK.item()),
            Map.entry("stained_tinted_glass_pane", ModTags.STAINED_TINTED_GLASS_PANE.item()),
            Map.entry("stained_tinted_glass_all", ModTags.STAINED_TINTED_GLASS_ALL.item()),
            Map.entry("colored_clear_tinted_glass_block", ModTags.COLORED_CLEAR_TINTED_GLASS_BLOCK.item()),
            Map.entry("colored_clear_tinted_glass_pane", ModTags.COLORED_CLEAR_TINTED_GLASS_PANE.item()),
            Map.entry("colored_clear_tinted_glass_all", ModTags.COLORED_CLEAR_TINTED_GLASS_ALL.item()),
            Map.entry("stained_clear_tinted_glass_block", ModTags.STAINED_CLEAR_TINTED_GLASS_BLOCK.item()),
            Map.entry("stained_clear_tinted_glass_pane", ModTags.STAINED_CLEAR_TINTED_GLASS_PANE.item()),
            Map.entry("stained_clear_tinted_glass_all", ModTags.STAINED_CLEAR_TINTED_GLASS_ALL.item()),
            Map.entry("colored_scratched_tinted_glass_block", ModTags.COLORED_SCRATCHED_TINTED_GLASS_BLOCK.item()),
            Map.entry("colored_scratched_tinted_glass_pane", ModTags.COLORED_SCRATCHED_TINTED_GLASS_PANE.item()),
            Map.entry("colored_scratched_tinted_glass_all", ModTags.COLORED_SCRATCHED_TINTED_GLASS_ALL.item()),
            Map.entry("stained_scratched_tinted_glass_block", ModTags.STAINED_SCRATCHED_TINTED_GLASS_BLOCK.item()),
            Map.entry("stained_scratched_tinted_glass_pane", ModTags.STAINED_SCRATCHED_TINTED_GLASS_PANE.item()),
            Map.entry("stained_scratched_tinted_glass_all", ModTags.STAINED_SCRATCHED_TINTED_GLASS_ALL.item())
    );

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                reDyeCraftingTable("colored_clear_glass_block", ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("colored_clear_glass_pane", ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("stained_clear_glass_block", ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("stained_clear_glass_pane", ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("colored_scratched_glass_block", ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("colored_scratched_glass_pane", ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("stained_scratched_glass_block", ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("stained_scratched_glass_pane", ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("colored_vanilla_glass_block", ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("colored_vanilla_glass_pane", ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("stained_vanilla_glass_block", STAINED_VANILLA_GLASS_BLOCK, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("stained_vanilla_glass_pane", STAINED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);

                reDyeCraftingTable("colored_clear_tinted_glass_block", ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("colored_clear_tinted_glass_pane", ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("stained_clear_tinted_glass_block", ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("stained_clear_tinted_glass_pane", ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("colored_scratched_tinted_glass_block", ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("colored_scratched_tinted_glass_pane", ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("stained_scratched_tinted_glass_block", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("stained_scratched_tinted_glass_pane", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("colored_tinted_glass_block", ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("colored_tinted_glass_pane", ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                reDyeCraftingTable("stained_tinted_glass_block", ModBlocks.STAINED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                reDyeCraftingTable("stained_tinted_glass_pane", ModBlocks.STAINED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                stainedToColoredCraftingTable("stained_clear_glass_block", ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                stainedToColoredCraftingTable("stained_clear_glass_pane", ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                stainedToColoredCraftingTable("stained_scratched_glass_block", ModBlocks.STAINED_SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                stainedToColoredCraftingTable("stained_scratched_glass_pane", ModBlocks.STAINED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                stainedToColoredCraftingTable("stained_vanilla_glass_block", STAINED_VANILLA_GLASS_BLOCK, ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                stainedToColoredCraftingTable("stained_vanilla_glass_pane", STAINED_VANILLA_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);

                stainedToColoredCraftingTable("stained_clear_tinted_glass_block", ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                stainedToColoredCraftingTable("stained_clear_tinted_glass_pane", ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                stainedToColoredCraftingTable("stained_scratched_tinted_glass_block", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                stainedToColoredCraftingTable("stained_scratched_tinted_glass_pane", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                stainedToColoredCraftingTable("stained_tinted_glass_block", ModBlocks.STAINED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                stainedToColoredCraftingTable("stained_tinted_glass_pane", ModBlocks.STAINED_TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                coloredToUndyedCraftingTable("colored_clear_glass_block", ModBlocks.CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                coloredToUndyedCraftingTable("colored_clear_glass_pane", ModBlocks.CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                coloredToUndyedCraftingTable("colored_scratched_glass_block", ModBlocks.SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                coloredToUndyedCraftingTable("colored_scratched_glass_pane", ModBlocks.SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                coloredToUndyedCraftingTable("colored_vanilla_glass_block", Blocks.GLASS, RecipeCategory.BUILDING_BLOCKS);
                coloredToUndyedCraftingTable("colored_vanilla_glass_pane", Blocks.GLASS_PANE, RecipeCategory.DECORATIONS);

                coloredToUndyedCraftingTable("colored_clear_tinted_glass_block", ModBlocks.CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                coloredToUndyedCraftingTable("colored_clear_tinted_glass_pane", ModBlocks.CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                coloredToUndyedCraftingTable("colored_scratched_tinted_glass_block", ModBlocks.SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                coloredToUndyedCraftingTable("colored_scratched_tinted_glass_pane", ModBlocks.SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                coloredToUndyedCraftingTable("colored_tinted_glass_block", Blocks.TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                coloredToUndyedCraftingTable("colored_tinted_glass_pane", ModBlocks.TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                colorOrStainOneStepCraftingTable(ModBlocks.CLEAR_GLASS, ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(Blocks.GLASS, ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(Blocks.GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_VANILLA_GLASS, STAINED_VANILLA_GLASS_BLOCK, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_VANILLA_GLASS_PANE, STAINED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);

                colorOrStainOneStepCraftingTable(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(Blocks.TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_TINTED_GLASS, ModBlocks.STAINED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainOneStepCraftingTable(ModBlocks.COLORED_TINTED_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                colorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_GLASS, ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);

                colorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                colorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                colorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                blockToPaneCraftingTable(ModBlocks.CLEAR_GLASS, ModBlocks.CLEAR_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_CLEAR_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_CLEAR_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.SCRATCHED_GLASS, ModBlocks.SCRATCHED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.STAINED_SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.COLORED_VANILLA_GLASS, ModBlocks.COLORED_VANILLA_GLASS_PANE);

                blockToPaneCraftingTable(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.CLEAR_TINTED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE);
                blockToPaneCraftingTable(ModBlocks.COLORED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS_PANE);
                blockToPaneCraftingTable(Blocks.TINTED_GLASS, ModBlocks.TINTED_GLASS_PANE);

                cycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_GLASS, ModBlocks.SCRATCHED_GLASS, Blocks.GLASS), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.SCRATCHED_GLASS_PANE, Blocks.GLASS_PANE), RecipeCategory.DECORATIONS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_VANILLA_GLASS), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, STAINED_VANILLA_GLASS_BLOCK), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);

                cycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS, Blocks.TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);

                tintGlass(Blocks.GLASS_PANE, ModBlocks.TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(ModBlocks.CLEAR_GLASS, ModBlocks.CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(ModBlocks.SCRATCHED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(ModBlocks.SCRATCHED_GLASS_PANE, ModBlocks.SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(ModBlocks.COLORED_VANILLA_GLASS, ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(ModBlocks.COLORED_VANILLA_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(STAINED_VANILLA_GLASS_BLOCK, ModBlocks.STAINED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(STAINED_VANILLA_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                tintGlass(ModBlocks.STAINED_SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                tintGlass(ModBlocks.STAINED_SCRATCHED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                untintGlass(Blocks.TINTED_GLASS, Blocks.GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.TINTED_GLASS_PANE, Blocks.GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.COLORED_TINTED_GLASS, ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.COLORED_TINTED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.STAINED_TINTED_GLASS, STAINED_VANILLA_GLASS_BLOCK, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.STAINED_TINTED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                untintGlass(ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                untintGlass(ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);

                coloredStainedSwapStonecutter(
                        List.of(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_VANILLA_GLASS, ModBlocks.COLORED_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS),
                        List.of(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, STAINED_VANILLA_GLASS_BLOCK, ModBlocks.STAINED_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS),
                        RecipeCategory.BUILDING_BLOCKS
                );
                coloredStainedSwapStonecutter(
                        List.of(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE),
                        List.of(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE),
                        RecipeCategory.DECORATIONS
                );

                blockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_GLASS, ModBlocks.SCRATCHED_GLASS, Blocks.GLASS), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.SCRATCHED_GLASS_PANE, Blocks.GLASS_PANE), RecipeCategory.DECORATIONS);
                blockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS, Blocks.TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                blockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_VANILLA_GLASS), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);
                blockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, STAINED_VANILLA_GLASS_BLOCK), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);
                blockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                blockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
            }


            private void reDyeCraftingTable(String tag, Map<DyeColor, Block> family, RecipeCategory recipeCategory) {
                String format = tag.replace("_block", "").replace("stained_vanilla", "stained");
                for (DyeColor color : DyeColor.values()) {
                    shaped(recipeCategory, family.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', itemTags.get(tag))
                            .define('W', DYES.get(color)).unlockedBy("has_%s".formatted(format), has(itemTags.get(tag)))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_%s".formatted(color.getName(), format))
                            .save(output, "%s_%s_from_other_%s_via_crafting_table".formatted(color.getName(), format, format));
                }
            }

            private void stainedToColoredCraftingTable(String inputTag, Map<DyeColor, Block> inputFamily, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
                String format = inputTag.replace("_block", "").replace("stained_vanilla", "stained");
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(inputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(outputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(recipeCategory, outputFamily.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', inputFamily.get(color))
                            .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_%s".formatted(format), has(itemTags.get(inputTag)))
                            .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void coloredToUndyedCraftingTable(String inputTag, Block result, RecipeCategory recipeCategory) {
                String format = inputTag.replace("_block", "").replace("stained_vanilla", "stained");
                String resultID = BuiltInRegistries.BLOCK.getKey(result).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(recipeCategory, result, 8).pattern("GGG").pattern("GWG").pattern("GGG")
                        .define('G', itemTags.get(inputTag)).define('W', ConventionalItemTags.WATER_BUCKETS)
                        .unlockedBy("has_%s".formatted(format), has(itemTags.get(inputTag)))
                        .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, format));
            }

            private void colorOrStainOneStepCraftingTable(Map<DyeColor, Block> inputFamily, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(inputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(outputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(recipeCategory, outputFamily.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', inputFamily.get(color))
                            .define('W', DYES.get(color)).unlockedBy("has_%s".formatted(inputID), has(inputFamily.get(color)))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void colorOrStainOneStepCraftingTable(Block inputBlock, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(inputBlock).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(outputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(recipeCategory, outputFamily.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', inputBlock)
                            .define('W', DYES.get(color)).unlockedBy("has_%s".formatted(inputID), has(inputBlock))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void colorOrStainTwoStepsCraftingTable(Block inputBlock, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(inputBlock).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(outputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(recipeCategory, outputFamily.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', inputBlock)
                            .define('W', DYES.get(color)).unlockedBy("has_%s".formatted(inputID), has(inputBlock))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void blockToPaneCraftingTable(Block inputBlock, Block outputBlock) {
                String inputID = BuiltInRegistries.BLOCK.getKey(inputBlock).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(outputBlock).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(RecipeCategory.DECORATIONS, outputBlock, 16)
                        .pattern("GGG").pattern("GGG").define('G', inputBlock)
                        .unlockedBy("has_%s".formatted(inputID), has(inputBlock)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void blockToPaneCraftingTable(Map<DyeColor, Block> inputFamily, Map<DyeColor, Block> outputFamily) {
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(inputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(outputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(RecipeCategory.DECORATIONS, outputFamily.get(color), 16)
                            .pattern("GGG").pattern("GGG").define('G', inputFamily.get(color))
                            .unlockedBy("has_%s".formatted(inputID), has(inputFamily.get(color))).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void cycleThroughBlocksCraftingTable(Block inputVariant, Block outputVariant, RecipeCategory recipeCategory) {
                String inputID = BuiltInRegistries.BLOCK.getKey(inputVariant).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(outputVariant).toString().replaceAll("(minecraft|betterglass):", "");

                shaped(recipeCategory, outputVariant, 4)
                        .pattern("GG").pattern("GG").define('G', inputVariant)
                        .unlockedBy("has_%s".formatted(inputID), has(inputVariant)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void cycleThroughBlocksCraftingTableUndyed(List<Block> variants, RecipeCategory recipeCategory) {
                for (int i = 0; i < variants.size(); i++) {
                    var inputVariant = variants.get((i - 1 + variants.size()) % variants.size());
                    var outputVariant = variants.get(i);

                    cycleThroughBlocksCraftingTable(inputVariant, outputVariant, recipeCategory);
                }
            }

            private void cycleThroughBlocksCraftingTableDyed(List<Map<DyeColor, Block>> variants, RecipeCategory recipeCategory) {
                for (int i = 0; i < variants.size(); i++) {
                    var inputVariant = variants.get((i - 1 + variants.size()) % variants.size());
                    var outputVariant = variants.get(i);

                    for (DyeColor color : DyeColor.values()) {
                        cycleThroughBlocksCraftingTable(inputVariant.get(color), outputVariant.get(color), recipeCategory);
                    }
                }
            }

            private void tintGlass(Block input, Block result, RecipeCategory recipeCategory) {
                String inputID = BuiltInRegistries.BLOCK.getKey(input).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(result).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(recipeCategory, result, 2)
                        .pattern(" A ").pattern("AGA").pattern(" A ").define('A', Items.AMETHYST_SHARD)
                        .define('G', input).unlockedBy("has_%s".formatted(inputID), has(input))
                        .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void tintGlass(Map<DyeColor, Block> input, Map<DyeColor, Block> result, RecipeCategory recipeCategory) {
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(input.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(result.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(recipeCategory, result.get(color), 2)
                            .pattern(" A ").pattern("AGA").pattern(" A ").define('A', Items.AMETHYST_SHARD)
                            .define('G', input.get(color)).unlockedBy("has_%s".formatted(inputID), has(input.get(color)))
                            .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD)).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void untintGlass(Block input, Block result, RecipeCategory recipeCategory) {
                String inputID = BuiltInRegistries.BLOCK.getKey(input).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(result).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(recipeCategory, result, 4)
                        .pattern(" G ").pattern("GHG").pattern(" G ").define('H', Items.HONEYCOMB)
                        .define('G', input).unlockedBy("has_%s".formatted(inputID), has(input))
                        .unlockedBy("has_honeycomb", has(Items.HONEYCOMB)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void untintGlass(Map<DyeColor, Block> input, Map<DyeColor, Block> result, RecipeCategory recipeCategory) {
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(input.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(result.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(recipeCategory, result.get(color), 4)
                            .pattern(" G ").pattern("GHG").pattern(" G ").define('H', Items.HONEYCOMB)
                            .define('G', input.get(color)).unlockedBy("has_%s".formatted(inputID), has(input.get(color)))
                            .unlockedBy("has_honeycomb", has(Items.HONEYCOMB)).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void coloredStainedSwapStonecutter(List<Map<DyeColor,Block>> colored, List<Map<DyeColor,Block>> stained, RecipeCategory recipeCategory) {
                for (int i = 0; i < colored.size(); i++) {
                    for (DyeColor color : DyeColor.values()) {
                        stonecutterResultFromBase(recipeCategory, colored.get(i).get(color), stained.get(i).get(color));
                        stonecutterResultFromBase(recipeCategory, stained.get(i).get(color), colored.get(i).get(color));
                    }
                }
            }

            private void blockSwapStonecutterUndyed(List<Block> blocks, RecipeCategory recipeCategory) {
                for (int i = 0; i < blocks.size(); i++) {
                    for (int j = 0; j < blocks.size(); j++) {
                        if (i == j) { continue; }
                        stonecutterResultFromBase(recipeCategory, blocks.get(i), blocks.get(j));
                    }
                }
            }

            private void blockSwapStonecutterDyed(List<Map<DyeColor,Block>> blocks, RecipeCategory recipeCategory) {
                for (int i = 0; i < blocks.size(); i++) {
                    for (DyeColor color : DyeColor.values()) {
                        for (int j = 0; j < blocks.size(); j++) {
                            if (i == j) { continue; }
                            stonecutterResultFromBase(recipeCategory, blocks.get(i).get(color), blocks.get(j).get(color));
                        }
                    }
                }
            }
        };
    }


    @Override
    public @NonNull String getName() {
        return "Recipes";
    }
}
