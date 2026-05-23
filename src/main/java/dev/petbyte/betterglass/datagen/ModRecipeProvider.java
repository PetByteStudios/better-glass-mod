package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

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

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                /*
                    it was worth an attempt, but the bottle gets consumed :/
                    leaving here as future idea for Glasscutter Update.
                Ingredient WATER_BOTTLE = DefaultCustomIngredients.components(

                        Ingredient.of(Items.POTION),
                        builder -> builder.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER))
                );
                */

                // panes = MISC; blocks = BUILDING_BLOCKS


                // ******************************************* //
                //                                             //
                //   CRAFTING TABLE: DYING & UN-DYING GLASS    //
                //                                             //
                // ******************************************* //


                // STAINED CLEAR -> COLORED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_CLEAR_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModBlocks.STAINED_CLEAR_GLASS.get(color))
                            .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_stained_clear_glass", has(ModTags.Items.STAINED_CLEAR_GLASS))
                            .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group("%s_colored_clear_glass".formatted(color.getName()))
                            .save(output, "%s_colored_clear_glass_from_%s_stained_clear_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // COLORED CLEAR -> UNDYED CLEAR
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLEAR_GLASS, 8).pattern("GGG")
                        .pattern("GWG").pattern("GGG").define('G', ModTags.Items.COLORED_CLEAR_GLASS)
                        .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_colored_clear_glass", has(ModTags.Items.COLORED_CLEAR_GLASS))
                        .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group("clear_glass")
                        .save(output, "clear_glass_from_colored_clear_glass_via_crafting_table");

                // CLEAR -> COLORED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_CLEAR_GLASS.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', ModBlocks.CLEAR_GLASS)
                            .define('W', DYES.get(color)).unlockedBy("has_clear_glass", has(ModBlocks.CLEAR_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_colored_clear_glass".formatted(color.getName()))
                            .save(output, "%s_colored_clear_glass_from_clear_glass_via_crafting_table".formatted(color.getName()));
                }
                // COLORED CLEAR -> STAINED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_CLEAR_GLASS.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', ModBlocks.COLORED_CLEAR_GLASS.get(color))
                            .define('W', DYES.get(color))
                            .unlockedBy("has_%s_colored_clear_glass".formatted(color.getName()), has(ModBlocks.COLORED_CLEAR_GLASS.get(color)))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_clear_glass".formatted(color.getName()))
                            .save(output, "%s_stained_clear_glass_from_%s_colored_clear_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // CLEAR -> STAINED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_CLEAR_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModBlocks.CLEAR_GLASS)
                            .define('W', DYES.get(color)).unlockedBy("has_clear_glass", has(ModBlocks.CLEAR_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_clear_glass".formatted(color.getName()))
                            .save(output, "%s_stained_clear_glass_from_clear_glass_via_crafting_table".formatted(color.getName()));
                }
                // RE-DYE ANY COLORED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_CLEAR_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModTags.Items.COLORED_CLEAR_GLASS)
                            .define('W', DYES.get(color))
                            .unlockedBy("has_colored_clear_glass", has(ModTags.Items.COLORED_CLEAR_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_colored_clear_glass".formatted(color.getName()))
                            .save(output, "%s_colored_clear_glass_from_other_colored_clear_glass_via_crafting_table".formatted(color.getName()));
                }
                // RE-DYE ANY STAINED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_CLEAR_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModTags.Items.STAINED_CLEAR_GLASS)
                            .define('W', DYES.get(color))
                            .unlockedBy("has_stained_clear_glass", has(ModTags.Items.STAINED_CLEAR_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_clear_glass".formatted(color.getName()))
                            .save(output, "%s_stained_clear_glass_from_other_stained_clear_glass_via_crafting_table".formatted(color.getName()));
                }


                // STAINED SCRATCHED -> COLORED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_SCRATCHED_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModBlocks.STAINED_SCRATCHED_GLASS.get(color))
                            .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_stained_scratched_glass", has(ModTags.Items.STAINED_SCRATCHED_GLASS))
                            .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group("%s_colored_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_colored_scratched_glass_from_%s_stained_scratched_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // COLORED SCRATCHED -> UNDYED SCRATCHED
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCRATCHED_GLASS, 8).pattern("GGG")
                        .pattern("GWG").pattern("GGG").define('G', ModTags.Items.COLORED_SCRATCHED_GLASS)
                        .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_colored_scratched_glass", has(ModTags.Items.COLORED_SCRATCHED_GLASS))
                        .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group("scratched_glass")
                        .save(output, "scratched_glass_from_colored_scratched_glass_via_crafting_table");

                // SCRATCHED -> COLORED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_SCRATCHED_GLASS.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', ModBlocks.SCRATCHED_GLASS)
                            .define('W', DYES.get(color)).unlockedBy("has_scratched_glass", has(ModBlocks.SCRATCHED_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_colored_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_colored_scratched_glass_from_scratched_glass_via_crafting_table".formatted(color.getName()));
                }
                // COLORED SCRATCHED -> STAINED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_SCRATCHED_GLASS.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', ModBlocks.COLORED_SCRATCHED_GLASS.get(color))
                            .define('W', DYES.get(color))
                            .unlockedBy("has_%s_colored_scratched_glass".formatted(color.getName()), has(ModBlocks.COLORED_SCRATCHED_GLASS.get(color)))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_stained_scratched_glass_from_%s_colored_scratched_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // SCRATCHED -> STAINED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_SCRATCHED_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModBlocks.SCRATCHED_GLASS)
                            .define('W', DYES.get(color)).unlockedBy("has_scratched_glass", has(ModBlocks.SCRATCHED_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_stained_scratched_glass_from_scratched_glass_via_crafting_table".formatted(color.getName()));
                }
                // RE-DYE ANY COLORED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_SCRATCHED_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModTags.Items.COLORED_SCRATCHED_GLASS)
                            .define('W', DYES.get(color))
                            .unlockedBy("has_colored_scratched_glass", has(ModTags.Items.COLORED_SCRATCHED_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_colored_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_colored_scratched_glass_from_other_colored_scratched_glass_via_crafting_table".formatted(color.getName()));
                }
                // RE-DYE ANY STAINED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_SCRATCHED_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModTags.Items.STAINED_SCRATCHED_GLASS)
                            .define('W', DYES.get(color))
                            .unlockedBy("has_stained_scratched_glass", has(ModTags.Items.STAINED_SCRATCHED_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_stained_scratched_glass_from_other_stained_scratched_glass_via_crafting_table".formatted(color.getName()));
                }


                // ******************************************* //
                //                                             //
                // C. TABLE: RE-DYING & UN-DYING VANILLA GLASS //
                //                                             //
                // ******************************************* //


                // STAINED VANILLA -> COLORED VANILLA
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_VANILLA_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', STAINED_VANILLA_GLASS_BLOCK.get(color))
                            .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_stained_glass", has(ModTags.Items.STAINED_VANILLA_GLASS_BLOCK))
                            .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group("%s_colored_vanilla_glass".formatted(color.getName()))
                            .save(output, "%s_colored_vanilla_glass_from_%s_stained_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // VANILLA -> COLORED VANILLA
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_VANILLA_GLASS.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', Blocks.GLASS)
                            .define('W', DYES.get(color)).unlockedBy("has_glass", has(Blocks.GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_colored_vanilla_glass".formatted(color.getName()))
                            .save(output, "%s_colored_vanilla_glass_from_glass_via_crafting_table".formatted(color.getName()));
                }
                // COLORED VANILLA -> STAINED VANILLA
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, STAINED_VANILLA_GLASS_BLOCK.get(color), 4)
                            .pattern(" G ").pattern("GWG").pattern(" G ").define('G', ModBlocks.COLORED_VANILLA_GLASS.get(color))
                            .define('W', DYES.get(color))
                            .unlockedBy("has_%s_colored_vanilla_glass".formatted(color.getName()), has(ModBlocks.COLORED_VANILLA_GLASS.get(color)))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_glass".formatted(color.getName()))
                            .save(output, "%s_stained_glass_from_%s_colored_vanilla_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }

                // COLORED BLOCK -> UNDYED BLOCK
                shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS, 8).pattern("GGG")
                        .pattern("GWG").pattern("GGG").define('G', ModTags.Items.COLORED_VANILLA_GLASS)
                        .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_colored_vanilla_glass", has(ModTags.Items.COLORED_VANILLA_GLASS))
                        .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group("glass")
                        .save(output, "glass_from_colored_vanilla_glass_via_crafting_table");
                // STAINED PANE -> UNDYED PANE
                shaped(RecipeCategory.DECORATIONS, Blocks.GLASS_PANE, 8).pattern("GGG")
                        .pattern("GWG").pattern("GGG").define('G', ModTags.Items.STAINED_VANILLA_GLASS_PANE)
                        .define('W', ConventionalItemTags.WATER_BUCKETS).unlockedBy("has_stained_glass_pane", has(ModTags.Items.STAINED_VANILLA_GLASS_PANE))
                        .unlockedBy("has_water_bucket", has(ConventionalItemTags.WATER_BUCKETS)).group("glass_pane")
                        .save(output, "glass_pane_from_stained_glass_pane_via_crafting_table");

                // RE-DYE ANY STAINED BLOCK
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, STAINED_VANILLA_GLASS_BLOCK.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModTags.Items.STAINED_VANILLA_GLASS_BLOCK)
                            .define('W', DYES.get(color))
                            .unlockedBy("has_stained_vanilla_glass", has(ModTags.Items.STAINED_VANILLA_GLASS_BLOCK))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_glass".formatted(color.getName()))
                            .save(output, "%s_stained_glass_from_other_stained_glass_via_crafting_table".formatted(color.getName()));
                }
                // RE-DYE ANY STAINED PANE
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.DECORATIONS, STAINED_VANILLA_GLASS_PANE.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModTags.Items.STAINED_VANILLA_GLASS_PANE)
                            .define('W', DYES.get(color))
                            .unlockedBy("has_stained_vanilla_glass_pane", has(ModTags.Items.STAINED_VANILLA_GLASS_PANE))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_stained_glass_pane".formatted(color.getName()))
                            .save(output, "%s_stained_glass_pane_from_other_stained_glass_pane_via_crafting_table".formatted(color.getName()));
                }
                // RE-DYE ANY COLORED VANILLA
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_VANILLA_GLASS.get(color), 8)
                            .pattern("GGG").pattern("GWG").pattern("GGG").define('G', ModTags.Items.COLORED_VANILLA_GLASS)
                            .define('W', DYES.get(color))
                            .unlockedBy("has_colored_vanilla_glass", has(ModTags.Items.COLORED_VANILLA_GLASS))
                            .unlockedBy("has_%s_dye".formatted(color.getName()), has(DYES.get(color))).group("%s_colored_vanilla_glass".formatted(color.getName()))
                            .save(output, "%s_colored_vanilla_glass_from_other_colored_vanilla_glass_via_crafting_table".formatted(color.getName()));
                }


                // ******************************************* //
                //                                             //
                // CRAFTING TABLE: CYCLING BETWEEN GLASS TYPES //
                //                                             //
                // ******************************************* //


                // VANILLA -> CLEAR
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLEAR_GLASS, 4)
                        .pattern("GG").pattern("GG").define('G', Blocks.GLASS)
                        .unlockedBy("has_glass", has(Blocks.GLASS)).group("clear_glass")
                        .save(output, "clear_glass_from_glass_via_crafting_table");
                // CLEAR -> SCRATCHED
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCRATCHED_GLASS, 4)
                        .pattern("GG").pattern("GG").define('G', ModBlocks.CLEAR_GLASS)
                        .unlockedBy("has_clear_glass", has(ModBlocks.CLEAR_GLASS)).group("scratched_glass")
                        .save(output, "scratched_glass_from_clear_glass_via_crafting_table");
                // SCRATCHED -> VANILLA
                shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS, 4)
                        .pattern("GG").pattern("GG").define('G', ModBlocks.SCRATCHED_GLASS)
                        .unlockedBy("has_scratched_glass", has(ModBlocks.SCRATCHED_GLASS)).group("glass")
                        .save(output, "glass_from_scratched_glass_via_crafting_table");

                // COLORED VANILLA -> COLORED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_CLEAR_GLASS.get(color), 4)
                            .pattern("GG").pattern("GG").define('G', ModBlocks.COLORED_VANILLA_GLASS.get(color))
                            .unlockedBy("has_%s_colored_vanilla_glass".formatted(color.getName()), has(ModBlocks.COLORED_VANILLA_GLASS.get(color)))
                            .group("%s_colored_clear_glass".formatted(color.getName()))
                            .save(output, "%s_colored_clear_glass_from_%s_colored_vanilla_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // COLORED CLEAR -> COLORED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_SCRATCHED_GLASS.get(color), 4)
                            .pattern("GG").pattern("GG").define('G', ModBlocks.COLORED_CLEAR_GLASS.get(color))
                            .unlockedBy("has_%s_colored_clear_glass".formatted(color.getName()), has(ModBlocks.COLORED_CLEAR_GLASS.get(color)))
                            .group("%s_colored_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_colored_scratched_glass_from_%s_colored_clear_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // COLORED SCRATCHED -> COLORED VANILLA
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_VANILLA_GLASS.get(color), 4)
                            .pattern("GG").pattern("GG").define('G', ModBlocks.COLORED_SCRATCHED_GLASS.get(color))
                            .unlockedBy("has_%s_colored_scratched_glass".formatted(color.getName()), has(ModBlocks.COLORED_SCRATCHED_GLASS.get(color)))
                            .group("%s_colored_vanilla_glass".formatted(color.getName()))
                            .save(output, "%s_colored_vanilla_glass_from_%s_colored_scratched_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }

                // STAINED VANILLA -> STAINED CLEAR
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_CLEAR_GLASS.get(color), 4)
                            .pattern("GG").pattern("GG").define('G', STAINED_VANILLA_GLASS_BLOCK.get(color))
                            .unlockedBy("has_%s_stained_vanilla_glass".formatted(color.getName()), has(STAINED_VANILLA_GLASS_BLOCK.get(color)))
                            .group("%s_stained_clear_glass".formatted(color.getName()))
                            .save(output, "%s_stained_clear_glass_from_%s_stained_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // STAINED CLEAR -> STAINED SCRATCHED
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_SCRATCHED_GLASS.get(color), 4)
                            .pattern("GG").pattern("GG").define('G', ModBlocks.STAINED_CLEAR_GLASS.get(color))
                            .unlockedBy("has_%s_stained_clear_glass".formatted(color.getName()), has(ModBlocks.STAINED_CLEAR_GLASS.get(color)))
                            .group("%s_stained_scratched_glass".formatted(color.getName()))
                            .save(output, "%s_stained_scratched_glass_from_%s_stained_clear_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }
                // STAINED SCRATCHED -> STAINED VANILLA
                for (DyeColor color : DyeColor.values()) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, STAINED_VANILLA_GLASS_BLOCK.get(color), 4)
                            .pattern("GG").pattern("GG").define('G', ModBlocks.STAINED_SCRATCHED_GLASS.get(color))
                            .unlockedBy("has_%s_stained_scratched_glass".formatted(color.getName()), has(ModBlocks.STAINED_SCRATCHED_GLASS.get(color)))
                            .group("%s_stained_glass".formatted(color.getName()))
                            .save(output, "%s_stained_glass_from_%s_stained_scratched_glass_via_crafting_table".formatted(color.getName(), color.getName()));
                }


                // ******************************************* //
                //                                             //
                //          STONECUTTER: GLASS TYPES           //
                //                                             //
                // ******************************************* //


                // UNDYED GLASS FROM OTHER UNDYED GLASS
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLEAR_GLASS, ModBlocks.SCRATCHED_GLASS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLEAR_GLASS, Blocks.GLASS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCRATCHED_GLASS, ModBlocks.CLEAR_GLASS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCRATCHED_GLASS, Blocks.GLASS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS, ModBlocks.CLEAR_GLASS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS, ModBlocks.SCRATCHED_GLASS);

                // STAINED GLASS FROM OTHER STAINED GLASS
                for (DyeColor color : DyeColor.values()) {
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_CLEAR_GLASS.get(color), ModBlocks.STAINED_SCRATCHED_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_CLEAR_GLASS.get(color), STAINED_VANILLA_GLASS_BLOCK.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_SCRATCHED_GLASS.get(color), ModBlocks.STAINED_CLEAR_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_SCRATCHED_GLASS.get(color), STAINED_VANILLA_GLASS_BLOCK.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, STAINED_VANILLA_GLASS_BLOCK.get(color), ModBlocks.STAINED_CLEAR_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, STAINED_VANILLA_GLASS_BLOCK.get(color), ModBlocks.STAINED_SCRATCHED_GLASS.get(color));
                }

                // COLORED GLASS FROM OTHER COLORED GLASS
                for (DyeColor color : DyeColor.values()) {
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_CLEAR_GLASS.get(color), ModBlocks.COLORED_SCRATCHED_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_CLEAR_GLASS.get(color), ModBlocks.COLORED_VANILLA_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_SCRATCHED_GLASS.get(color), ModBlocks.COLORED_CLEAR_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_SCRATCHED_GLASS.get(color), ModBlocks.COLORED_VANILLA_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_VANILLA_GLASS.get(color), ModBlocks.COLORED_CLEAR_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_VANILLA_GLASS.get(color), ModBlocks.COLORED_SCRATCHED_GLASS.get(color));
                }

                // COLORED <-> STAINED
                for (DyeColor color : DyeColor.values()) {
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_CLEAR_GLASS.get(color), ModBlocks.STAINED_CLEAR_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_SCRATCHED_GLASS.get(color), ModBlocks.STAINED_SCRATCHED_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COLORED_VANILLA_GLASS.get(color), STAINED_VANILLA_GLASS_BLOCK.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_CLEAR_GLASS.get(color), ModBlocks.COLORED_CLEAR_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINED_SCRATCHED_GLASS.get(color), ModBlocks.COLORED_SCRATCHED_GLASS.get(color));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, STAINED_VANILLA_GLASS_BLOCK.get(color), ModBlocks.COLORED_VANILLA_GLASS.get(color));
                }
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "Recipes";
    }
}
