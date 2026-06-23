package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.BetterGlass;
import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.item.ModItems;
import dev.petbyte.betterglass.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
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

    // These Maps will be removed and replaced by ColorCollections in v1.2.0
    private static final Map<DyeColor, Item> DYES = Map.ofEntries(
            Map.entry(DyeColor.WHITE, Items.DYE.white()),
            Map.entry(DyeColor.LIGHT_GRAY, Items.DYE.lightGray()),
            Map.entry(DyeColor.GRAY, Items.DYE.gray()),
            Map.entry(DyeColor.BLACK, Items.DYE.black()),
            Map.entry(DyeColor.BROWN, Items.DYE.brown()),
            Map.entry(DyeColor.RED, Items.DYE.red()),
            Map.entry(DyeColor.ORANGE, Items.DYE.orange()),
            Map.entry(DyeColor.YELLOW, Items.DYE.yellow()),
            Map.entry(DyeColor.LIME, Items.DYE.lime()),
            Map.entry(DyeColor.GREEN, Items.DYE.green()),
            Map.entry(DyeColor.CYAN, Items.DYE.cyan()),
            Map.entry(DyeColor.LIGHT_BLUE, Items.DYE.lightBlue()),
            Map.entry(DyeColor.BLUE, Items.DYE.blue()),
            Map.entry(DyeColor.PURPLE, Items.DYE.purple()),
            Map.entry(DyeColor.MAGENTA, Items.DYE.magenta()),
            Map.entry(DyeColor.PINK, Items.DYE.pink())
    );

    private static final Map<DyeColor, Block> STAINED_VANILLA_GLASS_BLOCK = Map.ofEntries(
            Map.entry(DyeColor.WHITE, Blocks.STAINED_GLASS.white()),
            Map.entry(DyeColor.LIGHT_GRAY, Blocks.STAINED_GLASS.lightGray()),
            Map.entry(DyeColor.GRAY, Blocks.STAINED_GLASS.gray()),
            Map.entry(DyeColor.BLACK, Blocks.STAINED_GLASS.black()),
            Map.entry(DyeColor.BROWN, Blocks.STAINED_GLASS.brown()),
            Map.entry(DyeColor.RED, Blocks.STAINED_GLASS.red()),
            Map.entry(DyeColor.ORANGE, Blocks.STAINED_GLASS.orange()),
            Map.entry(DyeColor.YELLOW, Blocks.STAINED_GLASS.yellow()),
            Map.entry(DyeColor.LIME, Blocks.STAINED_GLASS.lime()),
            Map.entry(DyeColor.GREEN, Blocks.STAINED_GLASS.green()),
            Map.entry(DyeColor.CYAN, Blocks.STAINED_GLASS.cyan()),
            Map.entry(DyeColor.LIGHT_BLUE, Blocks.STAINED_GLASS.lightBlue()),
            Map.entry(DyeColor.BLUE, Blocks.STAINED_GLASS.blue()),
            Map.entry(DyeColor.PURPLE, Blocks.STAINED_GLASS.purple()),
            Map.entry(DyeColor.MAGENTA, Blocks.STAINED_GLASS.magenta()),
            Map.entry(DyeColor.PINK, Blocks.STAINED_GLASS.pink())
    );

    private static final Map<DyeColor, Block> STAINED_VANILLA_GLASS_PANE = Map.ofEntries(
            Map.entry(DyeColor.WHITE, Blocks.STAINED_GLASS_PANE.white()),
            Map.entry(DyeColor.LIGHT_GRAY, Blocks.STAINED_GLASS_PANE.lightGray()),
            Map.entry(DyeColor.GRAY, Blocks.STAINED_GLASS_PANE.gray()),
            Map.entry(DyeColor.BLACK, Blocks.STAINED_GLASS_PANE.black()),
            Map.entry(DyeColor.BROWN, Blocks.STAINED_GLASS_PANE.brown()),
            Map.entry(DyeColor.RED, Blocks.STAINED_GLASS_PANE.red()),
            Map.entry(DyeColor.ORANGE, Blocks.STAINED_GLASS_PANE.orange()),
            Map.entry(DyeColor.YELLOW, Blocks.STAINED_GLASS_PANE.yellow()),
            Map.entry(DyeColor.LIME, Blocks.STAINED_GLASS_PANE.lime()),
            Map.entry(DyeColor.GREEN, Blocks.STAINED_GLASS_PANE.green()),
            Map.entry(DyeColor.CYAN, Blocks.STAINED_GLASS_PANE.cyan()),
            Map.entry(DyeColor.LIGHT_BLUE, Blocks.STAINED_GLASS_PANE.lightBlue()),
            Map.entry(DyeColor.BLUE, Blocks.STAINED_GLASS_PANE.blue()),
            Map.entry(DyeColor.PURPLE, Blocks.STAINED_GLASS_PANE.purple()),
            Map.entry(DyeColor.MAGENTA, Blocks.STAINED_GLASS_PANE.magenta()),
            Map.entry(DyeColor.PINK, Blocks.STAINED_GLASS_PANE.pink())
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

                patternizeGlass(List.of(Blocks.GLASS, ModBlocks.CLEAR_GLASS, ModBlocks.SCRATCHED_GLASS,
                        Blocks.TINTED_GLASS, ModBlocks.CLEAR_TINTED_GLASS, ModBlocks.SCRATCHED_TINTED_GLASS), RecipeCategory.BUILDING_BLOCKS);
                patternizeGlass(List.of(Blocks.GLASS_PANE, ModBlocks.CLEAR_GLASS_PANE, ModBlocks.SCRATCHED_GLASS_PANE,
                        ModBlocks.TINTED_GLASS_PANE, ModBlocks.CLEAR_TINTED_GLASS_PANE, ModBlocks.SCRATCHED_TINTED_GLASS_PANE), RecipeCategory.DECORATIONS);

                blockToPaneCraftingTable(ModBlocks.BETTER_GLASS_PATTERNED_BLOCKS, ModBlocks.BETTER_GLASS_PATTERNED_PANES);

                cycleThroughBlocksCraftingTablePatterned(List.of(ModBlocks.PATTERNED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_GLASS_BLOCKS), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTablePatterned(List.of(ModBlocks.PATTERNED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_GLASS_PANES), RecipeCategory.DECORATIONS);
                cycleThroughBlocksCraftingTablePatterned(List.of(ModBlocks.PATTERNED_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_BLOCKS), RecipeCategory.BUILDING_BLOCKS);
                cycleThroughBlocksCraftingTablePatterned(List.of(ModBlocks.PATTERNED_TINTED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_PANES), RecipeCategory.DECORATIONS);

                tintGlass(List.of(ModBlocks.PATTERNED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_GLASS_BLOCKS),
                        List.of(ModBlocks.PATTERNED_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS);
                tintGlass(List.of(ModBlocks.PATTERNED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_GLASS_PANES),
                        List.of(ModBlocks.PATTERNED_TINTED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_PANES),
                        RecipeCategory.DECORATIONS);

                untintGlass(List.of(ModBlocks.PATTERNED_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_BLOCKS),
                        List.of(ModBlocks.PATTERNED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_GLASS_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS);
                untintGlass(List.of(ModBlocks.PATTERNED_TINTED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_PANES),
                        List.of(ModBlocks.PATTERNED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_GLASS_PANES),
                        RecipeCategory.DECORATIONS);

                blockSwapStonecutterPatterned(List.of(ModBlocks.PATTERNED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_GLASS_BLOCKS), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterPatterned(List.of(ModBlocks.PATTERNED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_GLASS_PANES), RecipeCategory.DECORATIONS);
                blockSwapStonecutterPatterned(List.of(ModBlocks.PATTERNED_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_BLOCKS, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_BLOCKS), RecipeCategory.BUILDING_BLOCKS);
                blockSwapStonecutterPatterned(List.of(ModBlocks.PATTERNED_TINTED_GLASS_PANES, ModBlocks.PATTERNED_CLEAR_TINTED_GLASS_PANES, ModBlocks.PATTERNED_SCRATCHED_TINTED_GLASS_PANES), RecipeCategory.DECORATIONS);


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

                addPatternRecipes();
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

            private void blockToPaneCraftingTable(List<Block> inputBlocks, List<Block> outputBlocks) {
                for (int i = 0; i < inputBlocks.size(); i++) {
                    String inputID = BuiltInRegistries.BLOCK.getKey(inputBlocks.get(i)).toString().replace("betterglass:", "");
                    String resultID = BuiltInRegistries.BLOCK.getKey(outputBlocks.get(i)).toString().replace("betterglass:", "");
                    shaped(RecipeCategory.DECORATIONS, outputBlocks.get(i), 16)
                            .pattern("GGG").pattern("GGG").define('G', inputBlocks.get(i))
                            .unlockedBy("has_%s".formatted(inputID), has(inputBlocks.get(i))).group(resultID)
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

            private void cycleThroughBlocksCraftingTablePatterned(List<Map<String, Block>> variants, RecipeCategory recipeCategory) {
                for (int i = 0; i < variants.size(); i++) {
                    var inputVariant = variants.get((i - 1 + variants.size()) % variants.size());
                    var outputVariant = variants.get(i);

                    for (String motif : ModBlocks.PATTERN_MOTIFS) {
                        cycleThroughBlocksCraftingTable(inputVariant.get(motif), outputVariant.get(motif), recipeCategory);
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

            private void tintGlass(List<Map<String, Block>> input, List<Map<String, Block>> result, RecipeCategory recipeCategory) {
                for (int i = 0; i < input.size(); i++) {
                    for (String motif : ModBlocks.PATTERN_MOTIFS) {
                        String inputID = BuiltInRegistries.BLOCK.getKey(input.get(i).get(motif)).toString().replace("betterglass:", "");
                        String resultID = BuiltInRegistries.BLOCK.getKey(result.get(i).get(motif)).toString().replace("betterglass:", "");
                        shaped(recipeCategory, result.get(i).get(motif), 2)
                                .pattern(" A ").pattern("AGA").pattern(" A ").define('A', Items.AMETHYST_SHARD)
                                .define('G', input.get(i).get(motif)).unlockedBy("has_%s".formatted(inputID), has(input.get(i).get(motif)))
                                .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD)).group(resultID)
                                .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                    }
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

            private void untintGlass(List<Map<String, Block>> input, List<Map<String, Block>> result, RecipeCategory recipeCategory) {
                for (int i = 0; i < input.size(); i++) {
                    for (String motif : ModBlocks.PATTERN_MOTIFS) {
                        String inputID = BuiltInRegistries.BLOCK.getKey(input.get(i).get(motif)).toString().replace("betterglass:", "");
                        String resultID = BuiltInRegistries.BLOCK.getKey(result.get(i).get(motif)).toString().replace("betterglass:", "");
                        shaped(recipeCategory, result.get(i).get(motif), 2)
                                .pattern(" G ").pattern("GHG").pattern(" G ").define('H', Items.HONEYCOMB)
                                .define('G', input.get(i).get(motif)).unlockedBy("has_%s".formatted(inputID), has(input.get(i).get(motif)))
                                .unlockedBy("has_honeycomb", has(Items.HONEYCOMB)).group(resultID)
                                .save(output, "%s_from_%s_via_crafting_table".formatted(resultID, inputID));
                    }
                }
            }

            private void patternizeGlass(List<Block> inputs, RecipeCategory recipeCategory) {
                for (Block input : inputs) {
                    for (String pattern : ModBlocks.PATTERN_MOTIFS) {
                        Item patternItem = ModItems.PATTERNS.get(pattern);
                        String inputID = BuiltInRegistries.BLOCK.getKey(input).toString().replaceAll("(minecraft|betterglass):", "");
                        Block result = BuiltInRegistries.BLOCK.get(Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID,
                                "%s_patterned_%s".formatted(pattern, inputID))).map(Holder.Reference::value).orElseThrow();
                        String resultID = BuiltInRegistries.BLOCK.getKey(result).toString().replace("betterglass:", "");
                        shaped(recipeCategory, result, 4).pattern(" G ").pattern("GPG").pattern(" G ")
                                .define('G', input).define('P', patternItem)
                                .unlockedBy("has_%s".formatted(patternItem), has(patternItem)).unlockedBy("has_%s".formatted(resultID), has(result))
                                .group(resultID).save(output, "%s_by_pattern_via_crafting_table".formatted(resultID));
                    }
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

            private void blockSwapStonecutterPatterned(List<Map<String, Block>> blocks, RecipeCategory recipeCategory) {
                for (int i = 0; i < blocks.size(); i++) {
                    for (int j = 0; j < blocks.size(); j++) {
                        if (i == j) { continue; }
                        for (String motif : ModBlocks.PATTERN_MOTIFS) {
                            stonecutterResultFromBase(recipeCategory, blocks.get(i).get(motif), blocks.get(j).get(motif));
                        }
                    }
                }
            }

            private void addPatternRecipes() {
                RecipeCategory recipeCategory = RecipeCategory.TOOLS;
                Item EMPTY_PATTERN = ModItems.EMPTY_PATTERN;
                // EMPTY
                shapeless(recipeCategory, EMPTY_PATTERN, 4).unlockedBy("has_paper", has(Items.PAPER))
                        .requires(Items.PAPER).requires(Items.FEATHER).requires(ConventionalItemTags.GLASS_BLOCKS)
                        .unlockedBy("has_any_glass", has(ConventionalItemTags.GLASS_BLOCKS))
                        .save(output);

                // NON-PRIDE
                shaped(recipeCategory, ModItems.PATTERNS.get("checkerboard"), 1)
                        .pattern("PBW").pattern(" WB").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.black()).define('W', Items.DYE.white())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("null"), 1)
                        .pattern("PBM").pattern(" MB").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.black()).define('M', Items.DYE.magenta())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                // PRIDE
                shaped(recipeCategory, ModItems.PATTERNS.get("agender"), 1)
                        .pattern("PBL").pattern(" W ").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.black()).define('L', Items.DYE.lime())
                        .define('W', Items.DYE.white())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("androgyne"), 1)
                        .pattern("PDU").pattern(" C ").define('P', EMPTY_PATTERN)
                        .define('D', Items.DYE.pink()).define('U', Items.DYE.purple())
                        .define('C', Items.DYE.cyan())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("aroace"), 1)
                        .pattern("POY").pattern("WLB").define('P', EMPTY_PATTERN)
                        .define('O', Items.DYE.orange()).define('Y', Items.DYE.yellow())
                        .define('W', Items.DYE.white()).define('L', Items.DYE.lightBlue())
                        .define('B', Items.DYE.blue()).group("aroace_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("aromantic"), 1)
                        .pattern("PGL").pattern("WIB").define('P', EMPTY_PATTERN)
                        .define('G', Items.DYE.green()).define('L', Items.DYE.lime())
                        .define('W', Items.DYE.white()).define('I', Items.DYE.lightGray())
                        .define('B', Items.DYE.black())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("asexual"), 1)
                        .pattern("PBL").pattern(" WU").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.black()).define('L', Items.DYE.lightGray())
                        .define('W', Items.DYE.white()).define('U', Items.DYE.purple())
                        .group("asexual_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("asexual_new"), 1)
                        .pattern("PBL").pattern("WYM").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.black()).define('L', Items.DYE.lightGray())
                        .define('W', Items.DYE.white()).define('Y', Items.DYE.yellow())
                        .define('M', Items.DYE.magenta()).group("asexual_new_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("bigender"), 1)
                        .pattern("PIW").pattern(" LB").define('P', EMPTY_PATTERN)
                        .define('I', Items.DYE.pink()).define('W', Items.DYE.white())
                        .define('L', Items.DYE.lightBlue()).define('B', Items.DYE.blue())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("bisexual"), 1)
                        .pattern("PIM").pattern(" B ").define('P', EMPTY_PATTERN)
                        .define('I', Items.DYE.pink()).define('M', Items.DYE.magenta())
                        .define('B', Items.DYE.blue())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("demiboy"), 1)
                        .pattern("PGL").pattern(" B ").define('P', EMPTY_PATTERN)
                        .define('G', Items.DYE.gray()).define('L', Items.DYE.lightGray())
                        .define('B', Items.DYE.lightBlue()).group("demiboy_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("demigender"), 1)
                        .pattern("PGL").pattern(" Y ").define('P', EMPTY_PATTERN)
                        .define('G', Items.DYE.gray()).define('L', Items.DYE.lightGray())
                        .define('Y', Items.DYE.yellow()).group("demigender_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("demigirl"), 1)
                        .pattern("PGL").pattern(" I ").define('P', EMPTY_PATTERN)
                        .define('G', Items.DYE.gray()).define('L', Items.DYE.lightGray())
                        .define('I', Items.DYE.pink()).group("demigirl_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("demiromantic"), 1)
                        .pattern("PW").pattern("BG").pattern(" L").define('P', EMPTY_PATTERN)
                        .define('W', Items.DYE.white()).define('B', Items.DYE.black())
                        .define('G', Items.DYE.green()).define('L', Items.DYE.lightGray())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("demisexual"), 1)
                        .pattern("PW").pattern("BU").pattern(" L").define('P', EMPTY_PATTERN)
                        .define('W', Items.DYE.white()).define('B', Items.DYE.black())
                        .define('U', Items.DYE.purple()).define('L', Items.DYE.lightGray())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("genderfluid"), 1)
                        .pattern("PIW").pattern("UBE").define('P', EMPTY_PATTERN)
                        .define('I', Items.DYE.pink()).define('W', Items.DYE.white())
                        .define('U', Items.DYE.purple()).define('B', Items.DYE.black())
                        .define('E', Items.DYE.blue())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("genderqueer"), 1)
                        .pattern("PU").pattern(" W").pattern(" G").define('P', EMPTY_PATTERN)
                        .define('U', Items.DYE.purple()).define('W', Items.DYE.white())
                        .define('G', Items.DYE.green())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("intersex"), 1)
                        .pattern("PYU").define('P', EMPTY_PATTERN)
                        .define('Y', Items.DYE.yellow()).define('U', Items.DYE.purple())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("lesbian"), 1)
                        .pattern("POW").pattern(" I ").define('P', EMPTY_PATTERN)
                        .define('O', Items.DYE.orange()).define('W', Items.DYE.white())
                        .define('I', Items.DYE.pink())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("mlm"), 1)
                        .pattern("PGW").pattern(" B ").define('P', EMPTY_PATTERN)
                        .define('G', Items.DYE.green()).define('W', Items.DYE.white())
                        .define('B', Items.DYE.blue())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("neutrois"), 1)
                        .pattern("PW").pattern(" G").pattern(" B").define('P', EMPTY_PATTERN)
                        .define('W', Items.DYE.white()).define('G', Items.DYE.green())
                        .define('B', Items.DYE.black())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("nonbinary"), 1)
                        .pattern("PYW").pattern(" UB").define('P', EMPTY_PATTERN)
                        .define('Y', Items.DYE.yellow()).define('W', Items.DYE.white())
                        .define('U', Items.DYE.purple()).define('B', Items.DYE.black())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("omnisexual"), 1)
                        .pattern("PI").pattern(" B").pattern(" L").define('P', EMPTY_PATTERN)
                        .define('I', Items.DYE.pink()).define('B', Items.DYE.black())
                        .define('L', Items.DYE.blue())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("pansexual"), 1)
                        .pattern("PI").pattern(" Y").pattern(" C").define('P', EMPTY_PATTERN)
                        .define('I', Items.DYE.pink()).define('Y', Items.DYE.yellow())
                        .define('C', Items.DYE.cyan())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("philadelphia_pride"), 1)
                        .pattern("PBR").pattern("EOY").pattern("GLU").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.black()).define('R', Items.DYE.brown())
                        .define('E', Items.DYE.red()).define('O', Items.DYE.orange())
                        .define('Y', Items.DYE.yellow()).define('G', Items.DYE.green())
                        .define('L', Items.DYE.blue()).define('U', Items.DYE.purple())
                        .group("philadelphia_pride_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("philadelphia_pride"), 1)
                        .pattern("PBR").define('P', ModItems.PATTERNS.get("rainbow"))
                        .define('B', Items.DYE.black()).define('R', Items.DYE.brown())
                        .group("philadelphia_pride_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "philadelphia_pride_pattern_from_rainbow_pattern_extended_dyes");

                shaped(recipeCategory, ModItems.PATTERNS.get("polyamory"), 1)
                        .pattern("PBR").pattern(" YL").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.blue()).define('R', Items.DYE.red())
                        .define('Y', Items.DYE.yellow()).define('L', Items.DYE.black())
                        .group("polyamory_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("polyamory_new"), 1)
                        .pattern("PWY").pattern("CIU").define('P', EMPTY_PATTERN)
                        .define('W', Items.DYE.white()).define('Y', Items.DYE.yellow())
                        .define('C', Items.DYE.cyan()).define('I', Items.DYE.pink())
                        .define('U', Items.DYE.purple()).group("polyamory_new_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("polygender"), 1)
                        .pattern("PBL").pattern("IYU").define('P', EMPTY_PATTERN)
                        .define('B', Items.DYE.black()).define('L', Items.DYE.lightGray())
                        .define('I', Items.DYE.pink()).define('Y', Items.DYE.yellow())
                        .define('U', Items.DYE.lightBlue())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("polysexual"), 1)
                        .pattern("PIG").pattern(" B ").define('P', EMPTY_PATTERN)
                        .define('I', Items.DYE.pink()).define('G', Items.DYE.green())
                        .define('B', Items.DYE.blue())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PBR").pattern("WIL").define('P', ModItems.PATTERNS.get("rainbow"))
                        .define('B', Items.DYE.black()).define('R', Items.DYE.brown())
                        .define('W', Items.DYE.white()).define('I', Items.DYE.pink())
                        .define('L', Items.DYE.lightBlue()).group("progress_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_rainbow_pattern_extended_dyes");

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PBR").pattern(" T ").define('P', ModItems.PATTERNS.get("rainbow"))
                        .define('B', Items.DYE.black()).define('R', Items.DYE.brown())
                        .define('T', ModItems.PATTERNS.get("transfem")).group("progress_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_rainbow_pattern_extended_transfem");

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PBR").pattern(" T ").define('P', ModItems.PATTERNS.get("rainbow"))
                        .define('B', Items.DYE.black()).define('R', Items.DYE.brown())
                        .define('T', ModItems.PATTERNS.get("transgender")).group("progress_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_rainbow_pattern_extended_transgender");

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PBR").pattern(" T ").define('P', ModItems.PATTERNS.get("rainbow"))
                        .define('B', Items.DYE.black()).define('R', Items.DYE.brown())
                        .define('T', ModItems.PATTERNS.get("transmasc")).group("progress_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_rainbow_pattern_extended_transmasc");

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PWI").pattern(" L ").define('P', ModItems.PATTERNS.get("philadelphia_pride"))
                        .define('W', Items.DYE.white()).define('I', Items.DYE.pink())
                        .define('L', Items.DYE.lightBlue()).group("progress_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_philadelphia_pride_pattern_extended_dyes");

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PT").define('P', ModItems.PATTERNS.get("philadelphia_pride"))
                        .define('T', ModItems.PATTERNS.get("transfem"))
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_philadelphia_pride_pattern_extended_transfem");

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PT").define('P', ModItems.PATTERNS.get("philadelphia_pride"))
                        .define('T', ModItems.PATTERNS.get("transgender"))
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_philadelphia_pride_pattern_extended_transgender");

                shaped(recipeCategory, ModItems.PATTERNS.get("progress"), 1)
                        .pattern("PT").define('P', ModItems.PATTERNS.get("philadelphia_pride"))
                        .define('T', ModItems.PATTERNS.get("transmasc"))
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output, "progress_pattern_from_philadelphia_pride_pattern_extended_transmasc");

                shaped(recipeCategory, ModItems.PATTERNS.get("rainbow"), 1)
                        .pattern("PRO").pattern("YGB").pattern(" U ").define('P', EMPTY_PATTERN)
                        .define('R', Items.DYE.red()).define('O', Items.DYE.orange())
                        .define('Y', Items.DYE.yellow()).define('G', Items.DYE.green())
                        .define('B', Items.DYE.blue()).define('U', Items.DYE.purple())
                        .group("rainbow_pattern")
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("transfem"), 1)
                        .pattern("PLL").pattern(" II").define('P', EMPTY_PATTERN)
                        .define('L', Items.DYE.lightBlue()).define('I', Items.DYE.pink())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("transgender"), 1)
                        .pattern("PLI").pattern("WIL").define('P', EMPTY_PATTERN)
                        .define('L', Items.DYE.lightBlue()).define('I', Items.DYE.pink())
                        .define('W', Items.DYE.white())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                shaped(recipeCategory, ModItems.PATTERNS.get("transmasc"), 1)
                        .pattern("PII").pattern(" LL").define('P', EMPTY_PATTERN)
                        .define('L', Items.DYE.lightBlue()).define('I', Items.DYE.pink())
                        .unlockedBy("has_empty_pattern", has(EMPTY_PATTERN)).save(output);

                // PRIDE CONVERSIONS
                shapeless(recipeCategory, ModItems.PATTERNS.get("aroace"), 1)
                        .requires(ModItems.PATTERNS.get("aromantic")).requires(ModItems.PATTERNS.get("asexual"))
                        .unlockedBy("has_aromantic_pattern", has(ModItems.PATTERNS.get("aromantic")))
                        .unlockedBy("has_asexual_pattern", has(ModItems.PATTERNS.get("asexual")))
                        .group("aroace_pattern")
                        .save(output, "aroace_pattern_from_aromantic_pattern_and_asexual_pattern");

                shapeless(recipeCategory, ModItems.PATTERNS.get("aroace"), 1)
                        .requires(ModItems.PATTERNS.get("aromantic")).requires(ModItems.PATTERNS.get("asexual_new"))
                        .unlockedBy("has_aromantic_pattern", has(ModItems.PATTERNS.get("aromantic")))
                        .unlockedBy("has_asexual_new_pattern", has(ModItems.PATTERNS.get("asexual_new")))
                        .group("aroace_pattern")
                        .save(output, "aroace_pattern_from_aromantic_pattern_and_asexual_new_pattern");

                shapeless(recipeCategory, ModItems.PATTERNS.get("asexual"), 1)
                        .requires(ModItems.PATTERNS.get("asexual_new"))
                        .unlockedBy("has_asexual_new_pattern", has(ModItems.PATTERNS.get("asexual_new")))
                        .group("asexual_pattern")
                        .save(output, "asexual_pattern_from_asexual_new_pattern");

                shapeless(recipeCategory, ModItems.PATTERNS.get("asexual_new"), 1)
                        .requires(ModItems.PATTERNS.get("asexual"))
                        .unlockedBy("has_asexual_pattern", has(ModItems.PATTERNS.get("asexual")))
                        .group("asexual_new_pattern")
                        .save(output, "asexual_new_pattern_from_asexual_pattern");

                shapeless(recipeCategory, ModItems.PATTERNS.get("demiboy"), 1)
                        .requires(ModItems.PATTERNS.get("demigender"))
                        .requires(Items.DYE.lightBlue())
                        .unlockedBy("has_demigender_pattern", has(ModItems.PATTERNS.get("demigender")))
                        .group("demiboy_pattern")
                        .save(output, "demiboy_pattern_from_demigender_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("demiboy"), 1)
                        .requires(ModItems.PATTERNS.get("demigirl"))
                        .requires(Items.DYE.lightBlue())
                        .unlockedBy("has_demigirl_pattern", has(ModItems.PATTERNS.get("demigirl")))
                        .group("demiboy_pattern")
                        .save(output, "demiboy_pattern_from_demigirl_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("demigender"), 1)
                        .requires(ModItems.PATTERNS.get("demiboy"))
                        .requires(Items.DYE.yellow())
                        .unlockedBy("has_demiboy_pattern", has(ModItems.PATTERNS.get("demiboy")))
                        .group("demigender_pattern")
                        .save(output, "demigender_pattern_from_demiboy_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("demigender"), 1)
                        .requires(ModItems.PATTERNS.get("demigirl"))
                        .requires(Items.DYE.yellow())
                        .unlockedBy("has_demigirl_pattern", has(ModItems.PATTERNS.get("demigirl")))
                        .group("demigender_pattern")
                        .save(output, "demigender_pattern_from_demigirl_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("demigirl"), 1)
                        .requires(ModItems.PATTERNS.get("demiboy"))
                        .requires(Items.DYE.pink())
                        .unlockedBy("has_demiboy_pattern", has(ModItems.PATTERNS.get("demiboy")))
                        .group("demigirl_pattern")
                        .save(output, "demigirl_pattern_from_demiboy_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("demigirl"), 1)
                        .requires(ModItems.PATTERNS.get("demigender"))
                        .requires(Items.DYE.pink())
                        .unlockedBy("has_demigender_pattern", has(ModItems.PATTERNS.get("demigender")))
                        .group("demigirl_pattern")
                        .save(output, "demigirl_pattern_from_demigender_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("polyamory"), 1)
                        .requires(ModItems.PATTERNS.get("polyamory_new"))
                        .unlockedBy("has_polyamory_new_pattern", has(ModItems.PATTERNS.get("polyamory_new")))
                        .group("polyamory_pattern")
                        .save(output, "polyamory_pattern_from_polyamory_new_pattern");

                shapeless(recipeCategory, ModItems.PATTERNS.get("polyamory_new"), 1)
                        .requires(ModItems.PATTERNS.get("polyamory"))
                        .unlockedBy("has_polyamory_pattern", has(ModItems.PATTERNS.get("polyamory")))
                        .group("polyamory_new_pattern")
                        .save(output, "polyamory_new_pattern_from_polyamory_pattern");

                shapeless(recipeCategory, ModItems.PATTERNS.get("transfem"), 1)
                        .requires(ModItems.PATTERNS.get("transmasc"))
                        .unlockedBy("has_transmasc_pattern", has(ModItems.PATTERNS.get("transmasc")))
                        .group("transfem_pattern")
                        .save(output, "transfem_pattern_from_transmasc_pattern");

                shapeless(recipeCategory, ModItems.PATTERNS.get("transgender"), 1)
                        .requires(ModItems.PATTERNS.get("transfem"))
                        .requires(Items.DYE.white())
                        .unlockedBy("has_transfem_pattern", has(ModItems.PATTERNS.get("transfem")))
                        .group("transgender_pattern")
                        .save(output, "transgender_pattern_from_transfem_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("transgender"), 1)
                        .requires(ModItems.PATTERNS.get("transmasc"))
                        .requires(Items.DYE.white())
                        .unlockedBy("has_transmasc_pattern", has(ModItems.PATTERNS.get("transmasc")))
                        .group("transgender_pattern")
                        .save(output, "transgender_pattern_from_transmasc_pattern_and_dye");

                shapeless(recipeCategory, ModItems.PATTERNS.get("transmasc"), 1)
                        .requires(ModItems.PATTERNS.get("transgender"))
                        .unlockedBy("has_transgender_pattern", has(ModItems.PATTERNS.get("transgender")))
                        .group("transmasc_pattern")
                        .save(output, "transmasc_pattern_from_transgender_pattern");
            }
        };
    }


    @Override
    public @NonNull String getName() {
        return "Recipes";
    }
}
