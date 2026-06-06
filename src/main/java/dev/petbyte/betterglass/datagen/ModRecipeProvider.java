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
                ReDyeCraftingTable("colored_clear_glass_block", ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("colored_clear_glass_pane", ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("stained_clear_glass_block", ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("stained_clear_glass_pane", ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("colored_scratched_glass_block", ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("colored_scratched_glass_pane", ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("stained_scratched_glass_block", ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("stained_scratched_glass_pane", ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("colored_vanilla_glass_block", ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("colored_vanilla_glass_pane", ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("stained_vanilla_glass_block", STAINED_VANILLA_GLASS_BLOCK, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("stained_vanilla_glass_pane", STAINED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);

                ReDyeCraftingTable("colored_clear_tinted_glass_block", ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("colored_clear_tinted_glass_pane", ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("stained_clear_tinted_glass_block", ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("stained_clear_tinted_glass_pane", ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("colored_scratched_tinted_glass_block", ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("colored_scratched_tinted_glass_pane", ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("stained_scratched_tinted_glass_block", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("stained_scratched_tinted_glass_pane", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("colored_tinted_glass_block", ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("colored_tinted_glass_pane", ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ReDyeCraftingTable("stained_tinted_glass_block", ModBlocks.STAINED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ReDyeCraftingTable("stained_tinted_glass_pane", ModBlocks.STAINED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                StainedToColoredCraftingTable("stained_clear_glass_block", ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                StainedToColoredCraftingTable("stained_clear_glass_pane", ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                StainedToColoredCraftingTable("stained_scratched_glass_block", ModBlocks.STAINED_SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                StainedToColoredCraftingTable("stained_scratched_glass_pane", ModBlocks.STAINED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                StainedToColoredCraftingTable("stained_vanilla_glass_block", STAINED_VANILLA_GLASS_BLOCK, ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                StainedToColoredCraftingTable("stained_vanilla_glass_pane", STAINED_VANILLA_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);

                StainedToColoredCraftingTable("stained_clear_tinted_glass_block", ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                StainedToColoredCraftingTable("stained_clear_tinted_glass_pane", ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                StainedToColoredCraftingTable("stained_scratched_tinted_glass_block", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                StainedToColoredCraftingTable("stained_scratched_tinted_glass_pane", ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                StainedToColoredCraftingTable("stained_tinted_glass_block", ModBlocks.STAINED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                StainedToColoredCraftingTable("stained_tinted_glass_pane", ModBlocks.STAINED_TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                ColoredToUndyedCraftingTable("colored_clear_glass_block", ModBlocks.CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColoredToUndyedCraftingTable("colored_clear_glass_pane", ModBlocks.CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColoredToUndyedCraftingTable("colored_scratched_glass_block", ModBlocks.SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColoredToUndyedCraftingTable("colored_scratched_glass_pane", ModBlocks.SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColoredToUndyedCraftingTable("colored_vanilla_glass_block", Blocks.GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColoredToUndyedCraftingTable("colored_vanilla_glass_pane", Blocks.GLASS_PANE, RecipeCategory.DECORATIONS);

                ColoredToUndyedCraftingTable("colored_clear_tinted_glass_block", ModBlocks.CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColoredToUndyedCraftingTable("colored_clear_tinted_glass_pane", ModBlocks.CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColoredToUndyedCraftingTable("colored_scratched_tinted_glass_block", ModBlocks.SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColoredToUndyedCraftingTable("colored_scratched_tinted_glass_pane", ModBlocks.SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColoredToUndyedCraftingTable("colored_tinted_glass_block", Blocks.TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColoredToUndyedCraftingTable("colored_tinted_glass_pane", ModBlocks.TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                ColorOrStainOneStepCraftingTable(ModBlocks.CLEAR_GLASS, ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(Blocks.GLASS, ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(Blocks.GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_VANILLA_GLASS, STAINED_VANILLA_GLASS_BLOCK, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_VANILLA_GLASS_PANE, STAINED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);

                ColorOrStainOneStepCraftingTable(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(Blocks.TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_TINTED_GLASS, ModBlocks.STAINED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainOneStepCraftingTable(ModBlocks.COLORED_TINTED_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                ColorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_GLASS, ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);

                ColorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainTwoStepsCraftingTable(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                ColorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                ColorOrStainTwoStepsCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                BlockToPaneCraftingTable(ModBlocks.CLEAR_GLASS, ModBlocks.CLEAR_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_CLEAR_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_CLEAR_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.SCRATCHED_GLASS, ModBlocks.SCRATCHED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.STAINED_SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.COLORED_VANILLA_GLASS, ModBlocks.COLORED_VANILLA_GLASS_PANE);

                BlockToPaneCraftingTable(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.CLEAR_TINTED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE);
                BlockToPaneCraftingTable(ModBlocks.COLORED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS_PANE);
                BlockToPaneCraftingTable(Blocks.TINTED_GLASS, ModBlocks.TINTED_GLASS_PANE);

                CycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_GLASS, ModBlocks.SCRATCHED_GLASS, Blocks.GLASS), RecipeCategory.BUILDING_BLOCKS);
                CycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.SCRATCHED_GLASS_PANE, Blocks.GLASS_PANE), RecipeCategory.DECORATIONS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_VANILLA_GLASS), RecipeCategory.BUILDING_BLOCKS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, STAINED_VANILLA_GLASS_BLOCK), RecipeCategory.BUILDING_BLOCKS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);

                CycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS, Blocks.TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                CycleThroughBlocksCraftingTableUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                CycleThroughBlocksCraftingTableDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);

                TintGlass(Blocks.GLASS_PANE, ModBlocks.TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(ModBlocks.CLEAR_GLASS, ModBlocks.CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(ModBlocks.SCRATCHED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(ModBlocks.SCRATCHED_GLASS_PANE, ModBlocks.SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(ModBlocks.COLORED_VANILLA_GLASS, ModBlocks.COLORED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(ModBlocks.COLORED_VANILLA_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(STAINED_VANILLA_GLASS_BLOCK, ModBlocks.STAINED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(STAINED_VANILLA_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);
                TintGlass(ModBlocks.STAINED_SCRATCHED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                TintGlass(ModBlocks.STAINED_SCRATCHED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, RecipeCategory.DECORATIONS);

                UntintGlass(ModBlocks.TINTED_GLASS_PANE, Blocks.GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.SCRATCHED_TINTED_GLASS, ModBlocks.SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.COLORED_TINTED_GLASS, ModBlocks.COLORED_VANILLA_GLASS, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.COLORED_TINTED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.STAINED_TINTED_GLASS, STAINED_VANILLA_GLASS_BLOCK, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.STAINED_TINTED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_CLEAR_GLASS, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);
                UntintGlass(ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, RecipeCategory.BUILDING_BLOCKS);
                UntintGlass(ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, RecipeCategory.DECORATIONS);

                ColoredStainedSwapStonecutter(
                        List.of(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_VANILLA_GLASS, ModBlocks.COLORED_TINTED_GLASS, ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS),
                        List.of(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, STAINED_VANILLA_GLASS_BLOCK, ModBlocks.STAINED_TINTED_GLASS, ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS),
                        RecipeCategory.BUILDING_BLOCKS
                );
                ColoredStainedSwapStonecutter(
                        List.of(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE, ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE),
                        List.of(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE, ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE),
                        RecipeCategory.DECORATIONS
                );

                BlockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_GLASS, ModBlocks.SCRATCHED_GLASS, Blocks.GLASS), RecipeCategory.BUILDING_BLOCKS);
                BlockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_GLASS_PANE, ModBlocks.SCRATCHED_GLASS_PANE, Blocks.GLASS_PANE), RecipeCategory.DECORATIONS);
                BlockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS, Blocks.TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                BlockSwapStonecutterUndyed(List.of(ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.SCRATCHED_TINTED_GLASS_PANE, ModBlocks.TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS, ModBlocks.COLORED_SCRATCHED_GLASS, ModBlocks.COLORED_VANILLA_GLASS), RecipeCategory.BUILDING_BLOCKS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_GLASS_PANE, ModBlocks.COLORED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS, ModBlocks.STAINED_SCRATCHED_GLASS, STAINED_VANILLA_GLASS_BLOCK), RecipeCategory.BUILDING_BLOCKS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_GLASS_PANE, STAINED_VANILLA_GLASS_PANE), RecipeCategory.DECORATIONS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS, ModBlocks.COLORED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.COLORED_CLEAR_TINTED_GLASS_PANE, ModBlocks.COLORED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.COLORED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS, ModBlocks.STAINED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                BlockSwapStonecutterDyed(List.of(ModBlocks.STAINED_CLEAR_TINTED_GLASS_PANE, ModBlocks.STAINED_SCRATCHED_TINTED_GLASS_PANE, ModBlocks.STAINED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);
            }


            private void ReDyeCraftingTable(String tag, Map<DyeColor, Block> family, RecipeCategory recipeCategory) {
                String format = tag.replace("_block", "").replace("stained_vanilla", "stained");
                for (DyeColor color : DyeColor.values()) {
                    shaped(recipeCategory, family.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', itemTags.get(tag))
                            .define('W', DYES.get(color)).unlockedBy("has_%s".formatted(format), has(itemTags.get(tag)))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_%s".formatted(color.getName(), format))
                            .save(output, "%s_%s_from_other_%s_via_crafting_table".formatted(color.getName(), format, format));
                }
            }

            private void StainedToColoredCraftingTable(String inputTag, Map<DyeColor, Block> inputFamily, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
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

            private void ColoredToUndyedCraftingTable(String inputTag, Block result, RecipeCategory recipeCategory) {
                String format = inputTag.replace("_block", "").replace("stained_vanilla", "stained");
                String resultID = BuiltInRegistries.BLOCK.getKey(result).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(recipeCategory, result, 8).pattern("GGG").pattern("GWG").pattern("GGG")
                        .define('G', itemTags.get(inputTag)).define('W', ConventionalItemTags.WATER_BUCKETS)
                        .unlockedBy("has_%s".formatted(format), has(itemTags.get(inputTag)))
                        .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, format));
            }

            private void ColorOrStainOneStepCraftingTable(Map<DyeColor, Block> inputFamily, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
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

            private void ColorOrStainOneStepCraftingTable(Block inputBlock, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
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

            private void ColorOrStainTwoStepsCraftingTable(Block inputBlock, Map<DyeColor, Block> outputFamily, RecipeCategory recipeCategory) {
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

            private void BlockToPaneCraftingTable(Block inputBlock, Block outputBlock) {
                String inputID = BuiltInRegistries.BLOCK.getKey(inputBlock).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(outputBlock).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(RecipeCategory.DECORATIONS, outputBlock, 16)
                        .pattern("GGG").pattern("GGG").define('G', inputBlock)
                        .unlockedBy("has_%s".formatted(inputID), has(inputBlock)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void BlockToPaneCraftingTable(Map<DyeColor, Block> inputFamily, Map<DyeColor, Block> outputFamily) {
                for (DyeColor color : DyeColor.values()) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(inputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(outputFamily.get(color)).toString().replaceAll("(minecraft|betterglass):", "");
                    shaped(RecipeCategory.DECORATIONS, outputFamily.get(color), 16)
                            .pattern("GGG").pattern("GGG").define('G', inputFamily.get(color))
                            .unlockedBy("has_%s".formatted(inputID), has(inputFamily.get(color))).group(resultID)
                            .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                }
            }

            private void CycleThroughBlocksCraftingTable(Block inputVariant, Block outputVariant, RecipeCategory recipeCategory) {
                String inputID = BuiltInRegistries.BLOCK.getKey(inputVariant).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(outputVariant).toString().replaceAll("(minecraft|betterglass):", "");

                shaped(recipeCategory, outputVariant, 4)
                        .pattern("GG").pattern("GG").define('G', inputVariant)
                        .unlockedBy("has_%s".formatted(inputID), has(inputVariant)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void CycleThroughBlocksCraftingTableUndyed(List<Block> variants, RecipeCategory recipeCategory) {
                for (int i = 0; i < variants.size(); i++) {
                    var inputVariant = variants.get((i - 1 + variants.size()) % variants.size());
                    var outputVariant = variants.get(i);

                    CycleThroughBlocksCraftingTable(inputVariant, outputVariant, recipeCategory);
                }
            }

            private void CycleThroughBlocksCraftingTableDyed(List<Map<DyeColor, Block>> variants, RecipeCategory recipeCategory) {
                for (int i = 0; i < variants.size(); i++) {
                    var inputVariant = variants.get((i - 1 + variants.size()) % variants.size());
                    var outputVariant = variants.get(i);

                    for (DyeColor color : DyeColor.values()) {
                        CycleThroughBlocksCraftingTable(inputVariant.get(color), outputVariant.get(color), recipeCategory);
                    }
                }
            }

            private void TintGlass(Block input, Block result, RecipeCategory recipeCategory) {
                String inputID = BuiltInRegistries.BLOCK.getKey(input).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(result).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(recipeCategory, result, 2)
                        .pattern(" A ").pattern("AGA").pattern(" A ").define('A', Items.AMETHYST_SHARD)
                        .define('G', input).unlockedBy("has_%s".formatted(inputID), has(input))
                        .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void TintGlass(Map<DyeColor, Block> input, Map<DyeColor, Block> result, RecipeCategory recipeCategory) {
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

            private void UntintGlass(Block input, Block result, RecipeCategory recipeCategory) {
                String inputID = BuiltInRegistries.BLOCK.getKey(input).toString().replaceAll("(minecraft|betterglass):", "");
                String resultID = BuiltInRegistries.BLOCK.getKey(result).toString().replaceAll("(minecraft|betterglass):", "");
                shaped(recipeCategory, result, 4)
                        .pattern(" G ").pattern("GHG").pattern(" G ").define('H', Items.HONEYCOMB)
                        .define('G', input).unlockedBy("has_%s".formatted(inputID), has(input))
                        .unlockedBy("has_honeycomb", has(Items.HONEYCOMB)).group(resultID)
                        .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
            }

            private void UntintGlass(Map<DyeColor, Block> input, Map<DyeColor, Block> result, RecipeCategory recipeCategory) {
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

            private void ColoredStainedSwapStonecutter(List<Map<DyeColor,Block>> colored, List<Map<DyeColor,Block>> stained, RecipeCategory recipeCategory) {
                for (int i = 0; i < colored.size(); i++) {
                    for (DyeColor color : DyeColor.values()) {
                        stonecutterResultFromBase(recipeCategory, colored.get(i).get(color), stained.get(i).get(color));
                        stonecutterResultFromBase(recipeCategory, stained.get(i).get(color), colored.get(i).get(color));
                    }
                }
            }

            private void BlockSwapStonecutterUndyed(List<Block> blocks, RecipeCategory recipeCategory) {
                for (int i = 0; i < blocks.size(); i++) {
                    for (int j = 0; j < blocks.size(); j++) {
                        if (i == j) { continue; }
                        stonecutterResultFromBase(recipeCategory, blocks.get(i), blocks.get(j));
                    }
                }
            }

            private void BlockSwapStonecutterDyed(List<Map<DyeColor,Block>> blocks, RecipeCategory recipeCategory) {
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
