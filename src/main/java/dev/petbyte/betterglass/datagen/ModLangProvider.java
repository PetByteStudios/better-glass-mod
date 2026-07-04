package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.item.ModItems;
import dev.petbyte.betterglass.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        Map<String, String> patternNames = Map.ofEntries(
                Map.entry("empty", "Empty"),
                Map.entry("checkerboard", "Checkerboard"),
                Map.entry("null", "Null"),
                Map.entry("agender", "Agender"),
                Map.entry("androgyne", "Androgyne"),
                Map.entry("aroace", "AroAce"),
                Map.entry("aromantic", "Aromantic"),
                Map.entry("asexual", "Asexual"),
                Map.entry("asexual_new", "Asexual (New)"),
                Map.entry("bigender", "Bigender"),
                Map.entry("bisexual", "Bisexual"),
                Map.entry("demiboy", "Demiboy"),
                Map.entry("demigender", "Demigender"),
                Map.entry("demigirl", "Demigirl"),
                Map.entry("demiromantic", "Demiromantic"),
                Map.entry("demisexual", "Demisexual"),
                Map.entry("genderfluid", "Genderfluid"),
                Map.entry("genderqueer", "Genderqueer"),
                Map.entry("intersex", "Intersex"),
                Map.entry("lesbian", "Lesbian"),
                Map.entry("mlm", "MLM"),
                Map.entry("neutrois", "Neutrois"),
                Map.entry("nonbinary", "Non-Binary"),
                Map.entry("omnisexual", "Omnisexual"),
                Map.entry("pansexual", "Pansexual"),
                Map.entry("philadelphia_pride", "Philadelphia Pride"),
                Map.entry("polyamory", "Polyamory"),
                Map.entry("polyamory_new", "Polyamory (New)"),
                Map.entry("polygender", "Polygender"),
                Map.entry("polysexual", "Polysexual"),
                Map.entry("progress", "Progress"),
                Map.entry("rainbow", "Rainbow"),
                Map.entry("transfem", "Transfem"),
                Map.entry("transgender", "Transgender"),
                Map.entry("transmasc", "Transmasc")
        );

        for (Block block : ModBlocks.BETTER_GLASS_ALL) {
            if (ModBlocks.BETTER_GLASS_PATTERNED_ALL.contains(block)) {
                continue;
            }
            String blockID = BuiltInRegistries.BLOCK.getKey(block).toString().replaceAll("(minecraft|betterglass):|vanilla_", "");
            String translation = capitalizeWords(blockID);
            translationBuilder.add(block.getDescriptionId(), translation);
        }

        for (Item item : ModItems.ALL_ITEMS) {
            if (ModItems.PATTERNS.containsValue(item)) { continue; }
            String itemID = BuiltInRegistries.ITEM.getKey(item).toString().replace("betterglass:", "");
            String translation = capitalizeWords(itemID);
            translationBuilder.add(item.getDescriptionId(), translation);
        }

        for (var pattern : ModItems.PATTERNS.entrySet()) {
            String patternName = patternNames.getOrDefault(pattern.getKey(), capitalizeWords(pattern.getKey()));
            String translation = "%s Pattern".formatted(patternName);
            translationBuilder.add(pattern.getValue().getDescriptionId(), translation);
        }

        for (Block block : ModBlocks.BETTER_GLASS_PATTERNED_ALL) {
            String blockID = BuiltInRegistries.BLOCK.getKey(block).toString().replace("betterglass:", "");
            String[] parts = blockID.split("_patterned_", 2);
            String patternId = parts[0];
            String rest = capitalizeWords(parts[1]);
            String patternName = patternNames.getOrDefault(patternId, capitalizeWords(patternId));
            String translation = "Patterned %s (%s)".formatted(rest, patternName);
            translationBuilder.add(block.getDescriptionId(), translation);
        }

        for (ModTags.TagPair tagPair : ModTags.ALL_TAG_PAIRS) {
            String blockTagID = tagPair.block().getTranslationKey();
            String itemTagID = tagPair.item().getTranslationKey();
            String translation = capitalizeWords(blockTagID.replaceAll("(tag.(block|item).betterglass.)", ""))
                    .replace("All", "(All)");

            translationBuilder.add(blockTagID, translation);
            translationBuilder.add(itemTagID, translation);
        }

        for (TagKey<Item> itemTagKey : ModTags.ALL_ITEM_TAGS) {
            String itemTagID = itemTagKey.getTranslationKey();
            String translation = capitalizeWords(itemTagID.replaceAll("(tag.(block|item).betterglass.)", ""))
                    .replace("All", "(All)");

            translationBuilder.add(itemTagID, translation);
        }

        translationBuilder.add("betterglass.modname", "Better Glass");

        translationBuilder.add("block.betterglass.glasscutter", "Glasscutter (Temp. W.I.P.)");
        translationBuilder.add("container.betterglass.glasscutter", "Glasscutter");
        translationBuilder.add("container.betterglass.glasscutter.easter_egg.spacing","   ");
        translationBuilder.add("container.betterglass.glasscutter.easter_egg.text", "(aka. fancy stonecutter. soz)");
        translationBuilder.add("creativemodetab.betterglass.betterglass", "Better Glass");
        translationBuilder.add("creativemodetab.betterglass.betterglass_patterned", "Better Glass (Patterned)");
        translationBuilder.add("creativemodetab.betterglass.betterglass_chiseled", "Better Glass (Chiseled)");
        translationBuilder.add("resourcePack.betterglass.connecting_textures.name", "Better Glass: Connecting Textures");
        translationBuilder.add("resourcePack.betterglass.connecting_textures.description", "Req. Continuity. Glass Pane Culling Fix compatible");
        translationBuilder.add("resourcePack.betterglass.base_assets.name", "Better Glass: Base Assets");
        translationBuilder.add("resourcePack.betterglass.base_assets.description", "The base textures for Better Glass");

        patternNames.forEach((id, name) ->
                translationBuilder.add("betterglass.pattern." + id, name)
        );

        translationBuilder.add("betterglass.dye", "Dye");
        translationBuilder.add("betterglass.color.white", "White");
        translationBuilder.add("betterglass.color.light_gray", "Light Gray");
        translationBuilder.add("betterglass.color.gray", "Gray");
        translationBuilder.add("betterglass.color.black", "Black");
        translationBuilder.add("betterglass.color.brown", "Brown");
        translationBuilder.add("betterglass.color.red", "Red");
        translationBuilder.add("betterglass.color.orange", "Orange");
        translationBuilder.add("betterglass.color.yellow", "Yellow");
        translationBuilder.add("betterglass.color.lime", "Lime");
        translationBuilder.add("betterglass.color.green", "Green");
        translationBuilder.add("betterglass.color.cyan", "Cyan");
        translationBuilder.add("betterglass.color.light_blue", "Light Blue");
        translationBuilder.add("betterglass.color.blue", "Blue");
        translationBuilder.add("betterglass.color.purple", "Purple");
        translationBuilder.add("betterglass.color.magenta", "Magenta");
        translationBuilder.add("betterglass.color.pink", "Pink");

        // Commands
        translationBuilder.add("commands.betterglass.bgwiki.root.welcome", "Welcome to Better Glass (v%s)!");
        translationBuilder.add("commands.betterglass.bgwiki.root.introduction", "This command is a small wiki on Better Glass. Run any of the below commands to read more!");
        translationBuilder.add("commands.betterglass.generic.em_dash_separated", "%s — %s");
        translationBuilder.add("commands.betterglass.generic.github_repo", "GitHub repo");
        translationBuilder.add("commands.betterglass.generic.label_content", "%s %s");
        translationBuilder.add("commands.betterglass.generic.newline", "\n%s");
        translationBuilder.add("commands.betterglass.generic.newline_four_spaced", "\n    %s");
        translationBuilder.add("commands.betterglass.generic.newline_surrounded", "\n%s\n");
        translationBuilder.add("commands.betterglass.generic.prefix", "%s — ");
        translationBuilder.add("commands.betterglass.generic.specific_section", "%s: %s");
        translationBuilder.add("commands.betterglass.generic.suffix", " — %s");
        translationBuilder.add("commands.betterglass.generic.two_spaces", "  %s");
        translationBuilder.add("commands.betterglass.generic.hover.click_to_view.faq", "Click to view FAQ");
        translationBuilder.add("commands.betterglass.generic.hover.click_to_view.info", "Click to view extra info");
        translationBuilder.add("commands.betterglass.generic.hover.click_to_view.petbyte_website", "Click to view the PetByte website");
        translationBuilder.add("commands.betterglass.generic.hover.click_to_view.recipes", "Click to view recipes");
        translationBuilder.add("commands.betterglass.generic.hover.click_to_view.roadmap", "Click to view the roadmap");
        translationBuilder.add("commands.betterglass.generic.hover.click_to_view.types", "Click to view types");

        translationBuilder.add("commands.betterglass.bgwiki.recipes", "Recipes");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.back_to_patterns", "Back to Patterns");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.back_to_root", "Back to root");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.check_info_on_patterns", "For info on Patterns, check ");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.check_pattern_recipes", "For recipes of Patterns, check below:");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.click_below", "Click any of the recipes below.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.cycle_types", "Cycle Types");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.cycle_types.info.output", "This recipe cycles through Clear -> Scratched -> Vanilla -> ..., and results in an output of %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.dye_once", "Dye (One Step)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.dye_once.info.dye_twice", "To go straight from Undyed to Stained, check %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.dye_once.info.output", "This recipe does one step, from Undyed to Colored, or Colored to Stained, and results in an output of %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.dye_twice", "Dye (Two Steps)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.dye_twice.info.dye_once", "To go from Undyed to Colored, or Colored to Stained, check %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.dye_twice.info.output", "This recipe does two steps, from Undyed straight to Stained and results in an output of %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_dye", "Any Dye");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass", "Any Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.colored_or_stained", "Any Colored/Stained Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.identical", "Any Glass (must all be identical)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.identical", "(must all be identical)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.same_type_any_color_same_coloration", "(Same Type, any Color. Must all be Stained or Colored; no mixing)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.same_type_any_color_stained_mixed_color_colored", "(Same Type. Same Stained or any Colored; no mixing)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.same_type_same_color_or_undyed", "(Same Type and Color, or Undyed)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.patterned.same_type", "Any Patterned Glass (Same Base Type)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.undyed", "Any Undyed Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_glass.undyed.same_type", "Any Undyed Glass (Same Type)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.any_pattern", "Any Pattern");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.transfem_transgender_transmasc_pattern", "Transfem/-gender/-masc Pattern");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.ingredient.two_patterns", "%s = %s; %s = %s");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.introduction", "This command shows you recipes for Better Glass, it is meant as a small tool. However, I do recommend a recipe viewer, such as \"JEI\", for more details.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.panes", "Panes");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.pattern", "Pattern");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.pattern_group", "Pattern Recipes");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns", "Patterns");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.aroace.also_crafted_from", "The Aroace Pattern can also be crafted by combining an Aromantic Pattern with an Asexual or Asexual New Pattern.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.empty.crafted_from", "You can craft an Empty Pattern using Paper, a Feather, and a Glass Block, no specific shape.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.a", "The %s can also be crafted by putting a %s into the crafting grid alongside %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.an", "The %s can also be crafted by putting an %s into the crafting grid alongside %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.or.a", "The %s can also be crafted by putting a %s or %s into the crafting grid alongside %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.or.an", "The %s can also be crafted by putting an %s or %s into the crafting grid alongside %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.a", "The %s can also be crafted by putting a %s into the crafting grid.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.an", "The %s can also be crafted by putting an %s into the crafting grid.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.or.a", "The %s can also be crafted by putting a %s or %s into the crafting grid.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.or.an", "The %s can also be crafted by putting an %s or %s into the crafting grid.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe", "\n%s  %s");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", "%s = %s");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe.no_legend", "\n%s");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.cycle_types", "cycle through types");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.dye_once", "dye Glass once");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.dye_twice", "stain Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.generic", "You can %s using the following recipe:");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.generic.plural", "You can %s using the following recipes:");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.item.a", "You can craft a %s using the following recipe:");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.item.an", "You can craft an %s using the following recipe:");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.item.plural.a", "You can craft a %s using the following recipes:");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.item.plural.an", "You can craft an %s using the following recipes:");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.panes", "craft Glass Panes");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.patterns", "put a Pattern on a Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.redye", "re-dye Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.strip_patterns", "remove Patterns from Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.tint", "craft Tinted Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.undye", "undye Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_action.untint", "untint Tinted Glass");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.recipe_group", "%s Recipes (%s)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.redye", "Re-Dye");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.results_output", "This recipe results in an output of %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.specific_recipe", "%s Recipe (%s)");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.station_recipes", "%s Recipes");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.stonecutter", "Stonecutter/Glasscutter");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.stonecutter.info.one", "By inputting any Glass Block or Pane, you can easily change the Glass Type.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.stonecutter.info.two", "By inputting any Colored or Stained Glass Block or Pane, you can switch between Coloration type at no extra cost.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.strip_patterns", "Strip Patterns");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.tint", "Tint");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.undye", "Undye");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.undye.info.output", "This recipe does one step, from Stained to Colored, and Colored to Undyed, and results in an output of %s.");
        translationBuilder.add("commands.betterglass.bgwiki.recipes.untint", "Untint");

        translationBuilder.add("commands.betterglass.bgwiki.types", "Glass Types");
        translationBuilder.add("commands.betterglass.bgwiki.types.introduction", "Better Glass features various Glass Types, here's an explainer!");
        translationBuilder.add("commands.betterglass.bgwiki.types.coloration", "Coloration:");
        translationBuilder.add("commands.betterglass.bgwiki.types.coloration.explainer", "There are two types of Coloration for Glass. Those are Stained (the entire block has a stain on it); and Colored (only opaque pixels are colored).");
        translationBuilder.add("commands.betterglass.bgwiki.types.coloration.explainer.extra", "Additionally, there is \"Patterned\" Glass, which is Stained Glass but with a special motif instead of a color.");
        translationBuilder.add("commands.betterglass.bgwiki.types.behaviour", "Behaviour:");
        translationBuilder.add("commands.betterglass.bgwiki.types.behaviour.explainer", "There are Blocks, Panes, Tinted Blocks, and Tinted Panes. Tinted Glass does not let light through and darkens the area.");
        translationBuilder.add("commands.betterglass.bgwiki.types.variants", "Variants:");
        translationBuilder.add("commands.betterglass.bgwiki.types.variants.explainer", "Glass is available in Vanilla (using a vanilla-like texture), Scratched (using a texture resembling pre-1.14 Glass), and Clear (outline only).");
        translationBuilder.add("commands.betterglass.bgwiki.types.available", "These are available in all possible combinations.");
        translationBuilder.add("commands.betterglass.bgwiki.types.chiseled.creative_only_500", "There is also a Chiseled Glass variant to celebrate 500 downloads, which, as of v1.1.0, is Creative-only.");

        translationBuilder.add("commands.betterglass.bgwiki.roadmap", "Roadmap");
        translationBuilder.add("commands.betterglass.bgwiki.roadmap.introduction", "Better Glass has a roadmap for the future. This roadmap has no particular timeframe and is non-binding. These changes may never occur, occur in a different order, or only release in the 22nd century.");
        translationBuilder.add("commands.betterglass.bgwiki.roadmap.120.name", "v1.2.0:");
        translationBuilder.add("commands.betterglass.bgwiki.roadmap.120.description", "Tech rewrite, Advancements, QoL (Culling fix & Resource Pack changes)");
        translationBuilder.add("commands.betterglass.bgwiki.roadmap.130.name", "v1.3.0:");
        translationBuilder.add("commands.betterglass.bgwiki.roadmap.130.description", "Glasscutter, Patterning & Chiseling Station, new Glass, connecting & non-connecting block states");
        translationBuilder.add("commands.betterglass.bgwiki.roadmap.140.name", "v1.4.0:");
        translationBuilder.add("commands.betterglass.bgwiki.roadmap.140.description", "Pane Upgrades (better culling, more block states), new Glass");

        translationBuilder.add("commands.betterglass.bgwiki.info", "Extra Information");
        translationBuilder.add("commands.betterglass.bgwiki.info.introduction", "Extra Info for Better Glass...");
        translationBuilder.add("commands.betterglass.bgwiki.info.version", "Version:");
        translationBuilder.add("commands.betterglass.bgwiki.info.git_hash", "Git Hash:");
        translationBuilder.add("commands.betterglass.bgwiki.info.website", "Website:");
        translationBuilder.add("commands.betterglass.bgwiki.info.author", "Author:");

        translationBuilder.add("commands.betterglass.bgwiki.faq", "FAQ");
        translationBuilder.add("commands.betterglass.bgwiki.faq.forced_to_use_custom_textures_vanilla_glass", "Am I forced to use your textures for Vanilla Glass?");
        translationBuilder.add("commands.betterglass.bgwiki.faq.forced_to_use_custom_textures_vanilla_glass.answer", "Currently, yes, but a toggle to switch back to Vanilla textures will be added in v1.2.0.");
        translationBuilder.add("commands.betterglass.bgwiki.faq.connected_textures_do_not_work", "My Connected Textures don't work; why?");
        translationBuilder.add("commands.betterglass.bgwiki.faq.connected_textures_do_not_work.answer", "Did you make sure to install the \"Continuity\" mod and enable the provided \"%s\" resource pack? If yes, and it doesn't work, report the issue on the %s.");
        translationBuilder.add("commands.betterglass.bgwiki.faq.how_to_deal_with_recipes", "How am I supposed to deal with hundreds of different blocks and thousands of recipes!?");
        translationBuilder.add("commands.betterglass.bgwiki.faq.how_to_deal_with_recipes.answer", "I recognize there are a lot of blocks and recipes; it is definitely quite overwhelming. But I have good news for you. Currently planned for v1.3.0 are two workstations to make crafting easier. Additionally, you can use the \"JEI\" mod for a comprehensive overview or run %s for a simplified list of recipes.");
        translationBuilder.add("commands.betterglass.bgwiki.faq.how_many_glass_blocks", "How many Glass Blocks are there?");
        translationBuilder.add("commands.betterglass.bgwiki.faq.how_many_glass_blocks.answer", "As of v1.1.0, if you sum up all Glass Types, Patterns, Colors, and Stains for normal and tinted blocks and panes, you'll receive %s. If you count in Chiseled blocks (which are Creative-only), you'll reach %s!");
    }

    private static String capitalizeWords(String id) {
        return Arrays.stream(id.split("_"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
