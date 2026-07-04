package dev.petbyte.betterglass;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.*;

import java.net.URI;

public class ModCommands {
    private static Component dyeIngredientList(String... colorKeys) {
        MutableComponent colors = Component.literal("");
        for (int i = 0; i < colorKeys.length; i++) {
            colors.append(Component.translatable(colorKeys[i]));
            if (i < colorKeys.length - 1) {
                colors.append(Component.literal("/"));
            }
        }
        colors.append(Component.literal(" "))
                .append(Component.translatable("betterglass.dye"));
        return colors;
    }

    public static void registerModCommands() {
        BetterGlass.LOGGER.info("Registering Mod Commands for %s".formatted(BetterGlass.MOD_ID));

        CommandRegistrationCallback.EVENT.register((dispatcher, _, _) ->
                dispatcher.register(Commands.literal("bgwiki").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("    ")
                                                            .append(Component.translatable("commands.betterglass.bgwiki.root.welcome", BetterGlass.MOD_VERSION).withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.literal("\n\n")).append(Component.translatable("commands.betterglass.bgwiki.root.introduction"))
                                                            .append(Component.translatable("commands.betterglass.generic.newline_four_spaced", Component.translatable("commands.betterglass.generic.em_dash_separated", Component.literal("/bgwiki recipes").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.translatable("commands.betterglass.generic.hover.click_to_view.recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED), Component.translatable("commands.betterglass.bgwiki.recipes").withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline_four_spaced", Component.translatable("commands.betterglass.generic.em_dash_separated", Component.literal("/bgwiki types").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki types")).withHoverEvent(new HoverEvent.ShowText(Component.translatable("commands.betterglass.generic.hover.click_to_view.types")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED), Component.translatable("commands.betterglass.bgwiki.types").withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline_four_spaced", Component.translatable("commands.betterglass.generic.em_dash_separated", Component.literal("/bgwiki roadmap").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki roadmap")).withHoverEvent(new HoverEvent.ShowText(Component.translatable("commands.betterglass.generic.hover.click_to_view.roadmap")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED), Component.translatable("commands.betterglass.bgwiki.roadmap").withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline_four_spaced", Component.translatable("commands.betterglass.generic.em_dash_separated", Component.literal("/bgwiki info").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki info")).withHoverEvent(new HoverEvent.ShowText(Component.translatable("commands.betterglass.generic.hover.click_to_view.info")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED), Component.translatable("commands.betterglass.bgwiki.info").withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline_four_spaced", Component.translatable("commands.betterglass.generic.em_dash_separated", Component.literal("/bgwiki faq").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki faq")).withHoverEvent(new HoverEvent.ShowText(Component.translatable("commands.betterglass.generic.hover.click_to_view.faq")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED), Component.translatable("commands.betterglass.bgwiki.faq").withStyle(ChatFormatting.ITALIC)))),
                                            false);
                                    return 1;
                                })
                                .then(Commands.literal("recipes").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("betterglass.modname"), Component.translatable("commands.betterglass.bgwiki.recipes")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.introduction")))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.click_below")))
                                                                            .append(Component.literal("\n"))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.redye").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes redye")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes redye")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.undye").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes undye")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes undye")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.dye_once").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes dyeonce")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes dyeonce")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.dye_twice").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes dyetwice")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes dyetwice")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("\n"))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.panes").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes panes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes panes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.cycle_types").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes cycle")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes cycle")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.tint").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes tint")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes tint")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.untint").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes untint")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes untint")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.stonecutter").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes stonecutter")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes stonecutter")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append("\n\n    ").append(Component.translatable("commands.betterglass.bgwiki.recipes.check_info_on_patterns")
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)))
                                                                            .append(". ")
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.strip_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes strip_patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes strip_patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                })
                                                .then(Commands.literal("redye").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.redye"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.redye"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GDG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.same_type_any_color_same_coloration")))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("D"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_dye"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.results_output", 8)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("undye").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.undye"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.undye"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.colored_or_stained"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GWG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.same_type_any_color_stained_mixed_color_colored")))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("W"),
                                                                                            Component.translatable("item.minecraft.water_bucket"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.undye.info.output", 4)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("dyeonce").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.dye_once"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.dye_once"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" G ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.colored_or_stained"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GDG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.same_type_same_color_or_undyed")))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" G ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("D"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_dye"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.dye_once.info.output", 4)))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.dye_once.info.dye_twice",
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.dye_twice").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes dyetwice")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes dyetwice")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("dyetwice").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.dye_twice"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.dye_twice"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.undyed.same_type"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GDG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.info.same_type_any_color_same_coloration")))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                                            Component.literal("D"), Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_dye"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.dye_twice.info.output", 8)))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.dye_twice.info.dye_once",
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.dye_once").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes dyeonce")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes dyeonce")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("panes").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.panes"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.panes"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.identical"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("GGG").withStyle(ChatFormatting.BOLD)))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.results_output", 16)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("cycle").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.cycle_types"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.cycle_types"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.identical"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("GG").withStyle(ChatFormatting.BOLD)))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.cycle_types.info.output", 4)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("tint").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.tint"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.tint"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" A ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("A"),
                                                                                            Component.translatable("item.minecraft.amethyst_shard"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("AGA").withStyle(ChatFormatting.BOLD)))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" A ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.results_output", 2)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("untint").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.untint"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.untint"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" G ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.identical"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("GHG").withStyle(ChatFormatting.BOLD)))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" G ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("H"),
                                                                                            Component.translatable("item.minecraft.honeycomb"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.results_output", 4)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("stonecutter").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.station_recipes", Component.translatable("commands.betterglass.bgwiki.recipes.stonecutter")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.stonecutter.info.one")))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.stonecutter.info.two")))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("patterns").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.pattern"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.patterns"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" G ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.undyed.same_type"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("GPG").withStyle(ChatFormatting.BOLD)))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" G ").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("P"),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_pattern"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.results_output", 4)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.strip_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes strip_patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes strip_patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline_surrounded", Component.translatable("commands.betterglass.bgwiki.recipes.check_pattern_recipes")))
                                                                            .append(Component.translatable("betterglass.pattern.empty").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns empty")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns empty")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.checkerboard").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns checkerboard")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns checkerboard")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.null").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns null")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns null")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.agender").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns agender")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns agender")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.androgyne").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns androgyne")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns androgyne")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.aroace").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns aroace")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns aroace")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.aromantic").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns aromantic")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns aromantic")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.asexual").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns asexual")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns asexual")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.asexual_new").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns asexual_new")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns asexual_new")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.bigender").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns bigender")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns bigender")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.bisexual").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns bisexual")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns bisexual")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.demiboy").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns demiboy")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns demiboy")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.demigender").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns demigender")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns demigender")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.demigirl").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns demigirl")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns demigirl")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.demiromantic").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns demiromantic")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns demiromantic")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.demisexual").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns demisexual")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns demisexual")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.genderfluid").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns genderfluid")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns genderfluid")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.genderqueer").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns genderqueer")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns genderqueer")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.intersex").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns intersex")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns intersex")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.lesbian").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns lesbian")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns lesbian")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.mlm").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns mlm")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns mlm")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.neutrois").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns neutrois")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns neutrois")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.nonbinary").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns nonbinary")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns nonbinary")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.omnisexual").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns omnisexual")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns omnisexual")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.pansexual").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns pansexual")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns pansexual")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.philadelphia_pride").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns philadelphia_pride")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns philadelphia_pride")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.polyamory").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns polyamory")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns polyamory")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.polyamory_new").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns polyamory_new")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns polyamory_new")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.polygender").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns polygender")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns polygender")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.polysexual").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns polysexual")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns polysexual")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.progress").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns progress")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns progress")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.rainbow").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns rainbow")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns rainbow")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.transfem").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns transfem")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns transfem")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.transgender").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns transgender")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns transgender")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("  "))
                                                                            .append(Component.translatable("betterglass.pattern.transmasc").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns transmasc")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns transmasc")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                })
                                                            .then(Commands.literal("empty").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.empty")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.empty.crafted_from")))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.results_output", 4)))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("checkerboard").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/W"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.white")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.checkerboard")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.checkerboard_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBW").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" WB").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("null").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/P"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.pink")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.null")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.null_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBP").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" PB").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("agender").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/L/W"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.lime", "betterglass.color.white")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.agender")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.agender_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" W ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("androgyne").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/U/C"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.purple", "betterglass.color.cyan")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.androgyne")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.androgyne_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EPU").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" C ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("aroace").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("O/Y/W/L/B"),
                                                                        dyeIngredientList("betterglass.color.orange", "betterglass.color.yellow", "betterglass.color.white", "betterglass.color.light_blue", "betterglass.color.blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.aroace")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.aroace_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EOY").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("WLB").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.aroace.also_crafted_from")))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("aromantic").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("G/L/W/I/B"),
                                                                        dyeIngredientList("betterglass.color.green", "betterglass.color.lime", "betterglass.color.white", "betterglass.color.light_gray", "betterglass.color.black")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.aromantic")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.aromantic_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EGL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("WIB").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("asexual").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/L/W/P"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.light_gray", "betterglass.color.white", "betterglass.color.purple")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.asexual")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.asexual_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" WP").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.an",
                                                                                                Component.translatable("item.betterglass.asexual_pattern"), Component.translatable("item.betterglass.asexual_new_pattern"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("asexual_new").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/L/W/Y/P"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.light_gray", "betterglass.color.white", "betterglass.color.yellow", "betterglass.color.pink")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.asexual_new")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.asexual_new_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("WYP").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.an",
                                                                                                Component.translatable("item.betterglass.asexual_new_pattern"), Component.translatable("item.betterglass.asexual_pattern"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("bigender").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/W/L/B"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.white", "betterglass.color.light_blue", "betterglass.color.blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.bigender")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.bigender_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EPW").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" LB").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("bisexual").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/U/B"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.purple", "betterglass.color.blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.bisexual")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.bisexual_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EPU").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" B ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demiboy").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("G/L/B"),
                                                                        dyeIngredientList("betterglass.color.green", "betterglass.color.light_gray", "betterglass.color.light_blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.demiboy")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.demiboy_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EGL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" B ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.or.a",
                                                                                                Component.translatable("item.betterglass.demiboy_pattern"), Component.translatable("item.betterglass.demigender_pattern"),
                                                                                                Component.translatable("item.betterglass.demigirl_pattern"), Component.translatable("item.minecraft.light_blue_dye"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demigender").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("G/L/Y"),
                                                                        dyeIngredientList("betterglass.color.green", "betterglass.color.light_gray", "betterglass.color.yellow")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.demigender")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.demigender_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EGL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" Y ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.or.a",
                                                                                                Component.translatable("item.betterglass.demigender_pattern"), Component.translatable("item.betterglass.demiboy_pattern"),
                                                                                                Component.translatable("item.betterglass.demigirl_pattern"), Component.translatable("item.minecraft.yellow_dye"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demigirl").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("G/L/P"),
                                                                        dyeIngredientList("betterglass.color.green", "betterglass.color.light_gray", "betterglass.color.pink")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.demigirl")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.demigirl_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EGL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" P ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.or.a",
                                                                                                Component.translatable("item.betterglass.demigirl_pattern"), Component.translatable("item.betterglass.demiboy_pattern"),
                                                                                                Component.translatable("item.betterglass.demigender_pattern"), Component.translatable("item.minecraft.pink_dye"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demiromantic").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("W/B/G/L"),
                                                                        dyeIngredientList("betterglass.color.white", "betterglass.color.black", "betterglass.color.green", "betterglass.color.light_gray")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.demiromantic")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.demiromantic_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EW ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("BG ").withStyle(ChatFormatting.BOLD)))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" L ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demisexual").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("W/B/P/L"),
                                                                        dyeIngredientList("betterglass.color.white", "betterglass.color.black", "betterglass.color.purple", "betterglass.color.light_gray")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.demisexual")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.demisexual_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EW ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("BP ").withStyle(ChatFormatting.BOLD)))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" L ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("genderfluid").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/W/U/B/L"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.white", "betterglass.color.purple", "betterglass.color.black", "betterglass.color.blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.genderfluid")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.genderfluid_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EPW").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("UBL").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("genderqueer").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/W/G"),
                                                                        dyeIngredientList("betterglass.color.purple", "betterglass.color.white", "betterglass.color.green")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.genderqueer")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.genderqueer_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EP ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal(" W ").withStyle(ChatFormatting.BOLD)))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" G ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("intersex").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("Y/P"),
                                                                        dyeIngredientList("betterglass.color.yellow", "betterglass.color.purple")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.intersex")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.intersex_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EYP").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("   ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("lesbian").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("O/W/P"),
                                                                        dyeIngredientList("betterglass.color.orange", "betterglass.color.white", "betterglass.color.pink")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.lesbian")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.lesbian_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EOW").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" P ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("mlm").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("G/W/B"),
                                                                        dyeIngredientList("betterglass.color.green", "betterglass.color.white", "betterglass.color.blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.mlm")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.mlm_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EGW").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" B ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("neutrois").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("W/G/B"),
                                                                        dyeIngredientList("betterglass.color.white", "betterglass.color.green", "betterglass.color.black")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.neutrois")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.neutrois_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EW ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal(" G ").withStyle(ChatFormatting.BOLD)))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" B ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("nonbinary").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("Y/W/P/B"),
                                                                        dyeIngredientList("betterglass.color.yellow", "betterglass.color.white", "betterglass.color.purple", "betterglass.color.black")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.nonbinary")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.nonbinary_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EYW").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" PB").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("omnisexual").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/B/U"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.black", "betterglass.color.blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.omnisexual")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.an", Component.translatable("item.betterglass.omnisexual_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EP ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal(" B ").withStyle(ChatFormatting.BOLD)))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" U ").withStyle(ChatFormatting.BOLD), ingredientLegend))

                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("pansexual").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/Y/C"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.yellow", "betterglass.color.cyan")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.pansexual")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.pansexual_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EP ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal(" Y ").withStyle(ChatFormatting.BOLD)))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" C ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("philadelphia_pride").executes(context -> {
                                                                Component ingredientLegendOne = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/R/D/O"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.brown", "betterglass.color.red", "betterglass.color.orange")
                                                                );
                                                                Component ingredientLegendTwo = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("Y/G/L/U"),
                                                                        dyeIngredientList("betterglass.color.yellow", "betterglass.color.green", "betterglass.color.blue", "betterglass.color.purple")
                                                                );
                                                                Component ingredientLegendThree = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/R"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.brown")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.philadelphia_pride")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.plural.a", Component.translatable("item.betterglass.philadelphia_pride_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBR").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("DOY").withStyle(ChatFormatting.BOLD), ingredientLegendOne))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GLU").withStyle(ChatFormatting.BOLD), ingredientLegendTwo))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("PBR").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("P"),
                                                                                                        Component.translatable("item.betterglass.rainbow_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("   ").withStyle(ChatFormatting.BOLD), ingredientLegendThree))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polyamory").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/R/Y/L"),
                                                                        dyeIngredientList("betterglass.color.blue", "betterglass.color.red", "betterglass.color.yellow", "betterglass.color.black")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.polyamory")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.polyamory_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBR").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" YL").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.a",
                                                                                                Component.translatable("item.betterglass.polyamory_pattern"), Component.translatable("item.betterglass.polyamory_new_pattern"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polyamory_new").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("W/Y/C/P/U"),
                                                                        dyeIngredientList("betterglass.color.white", "betterglass.color.yellow", "betterglass.color.cyan", "betterglass.color.pink", "betterglass.color.purple")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.polyamory_new")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.polyamory_new_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EWY").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("CPU").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.a",
                                                                                                Component.translatable("item.betterglass.polyamory_new_pattern"), Component.translatable("item.betterglass.polyamory_pattern"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polygender").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/L/P/Y/I"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.light_gray", "betterglass.color.pink", "betterglass.color.yellow", "betterglass.color.light_blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.polygender")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.polygender_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EBL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("PYI").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polysexual").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/G/B"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.green", "betterglass.color.blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.polysexual")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.polysexual_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EPG").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" B ").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("progress").executes(context -> {
                                                                Component ingredientLegendOne = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/R/W/P/I"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.brown", "betterglass.color.white", "betterglass.color.pink", "betterglass.color.light_blue")
                                                                );
                                                                Component ingredientLegendTwo = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("B/R"),
                                                                        dyeIngredientList("betterglass.color.black", "betterglass.color.brown")
                                                                );
                                                                Component ingredientLegendThree = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("W/I/L"),
                                                                        dyeIngredientList("betterglass.color.white", "betterglass.color.pink", "betterglass.color.light_blue")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.progress")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.plural.a", Component.translatable("item.betterglass.progress_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("PBR").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("P"),
                                                                                                        Component.translatable("item.betterglass.rainbow_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("WIL").withStyle(ChatFormatting.BOLD), ingredientLegendOne))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("PBR").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.two_patterns",
                                                                                                        Component.literal("P"), Component.translatable("item.betterglass.rainbow_pattern"),
                                                                                                        Component.literal("T"), Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.transfem_transgender_transmasc_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" T ").withStyle(ChatFormatting.BOLD), ingredientLegendTwo))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("PWI").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("P"),
                                                                                                        Component.translatable("item.betterglass.philadelphia_pride_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" L ").withStyle(ChatFormatting.BOLD), ingredientLegendThree))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("PT ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("P"),
                                                                                                        Component.translatable("item.betterglass.philadelphia_pride_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("   ").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("T"),
                                                                                                        Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.transfem_transgender_transmasc_pattern"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("rainbow").executes(context -> {
                                                                Component ingredientLegendOne = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("R/O/Y"),
                                                                        dyeIngredientList("betterglass.color.red", "betterglass.color.orange", "betterglass.color.yellow")
                                                                );
                                                                Component ingredientLegendTwo = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("G/B/P"),
                                                                        dyeIngredientList("betterglass.color.green", "betterglass.color.blue", "betterglass.color.purple")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.rainbow")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.rainbow_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("ERO").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("YGB").withStyle(ChatFormatting.BOLD), ingredientLegendOne))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" U ").withStyle(ChatFormatting.BOLD), ingredientLegendTwo))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("transfem").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("L/P"),
                                                                        dyeIngredientList("betterglass.color.light_blue", "betterglass.color.pink")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.transfem")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.transfem_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("ELL").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" PP").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.a",
                                                                                                Component.translatable("item.betterglass.transfem_pattern"), Component.translatable("item.betterglass.transmasc_pattern"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("transgender").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("L/P/W"),
                                                                        dyeIngredientList("betterglass.color.light_blue", "betterglass.color.pink", "betterglass.color.white")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.transgender")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.transgender_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("ELP").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("WPL").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.and_conversion.or.a",
                                                                                                Component.translatable("item.betterglass.transgender_pattern"), Component.translatable("item.betterglass.transfem_pattern"),
                                                                                                Component.translatable("item.betterglass.transmasc_pattern"), Component.translatable("item.minecraft.white_dye"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("transmasc").executes(context -> {
                                                                Component ingredientLegend = Component.translatable(
                                                                        "commands.betterglass.bgwiki.recipes.recipe.ingredient_legend",
                                                                        Component.literal("P/L"),
                                                                        dyeIngredientList("betterglass.color.pink", "betterglass.color.pink")
                                                                );
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("commands.betterglass.bgwiki.recipes.pattern_group"), Component.translatable("betterglass.pattern.transmasc")).withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.item.a", Component.translatable("item.betterglass.transmasc_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("EPP").withStyle(ChatFormatting.BOLD),
                                                                                                Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("E"),
                                                                                                        Component.translatable("item.betterglass.empty_pattern"))))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal(" LL").withStyle(ChatFormatting.BOLD), ingredientLegend))
                                                                                        .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.patterns.info.simple_conversion.a",
                                                                                                Component.translatable("item.betterglass.transmasc_pattern"), Component.translatable("item.betterglass.transfem_pattern"))))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED))
                                                                                        .append(Component.literal("  "))
                                                                                        .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes patterns")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                )
                                                .then(Commands.literal("strip_patterns").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.specific_recipe", Component.translatable("commands.betterglass.bgwiki.recipes.strip_patterns"), Component.translatable("block.minecraft.crafting_table")).withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.generic", Component.translatable("commands.betterglass.bgwiki.recipes.recipe_action.strip_patterns"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("G"),
                                                                                            Component.translatable("commands.betterglass.bgwiki.recipes.ingredient.any_glass.patterned.same_type"))))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe.no_legend", Component.literal("GFG").withStyle(ChatFormatting.BOLD)))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.recipe", Component.literal("GGG").withStyle(ChatFormatting.BOLD),
                                                                                    Component.translatable("commands.betterglass.bgwiki.recipes.recipe.ingredient_legend", Component.literal("F"),
                                                                                            Component.translatable("item.minecraft.flint"))))
                                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.recipes.results_output", 8)))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.translatable("commands.betterglass.bgwiki.recipes.back_to_root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.literal("/bgwiki recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)),
                                                            false);
                                                    return 1;
                                                }))
                                )
                                .then(Commands.literal("types").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("")
                                                            .append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("betterglass.modname"), Component.translatable("commands.betterglass.bgwiki.types")).withStyle(ChatFormatting.BOLD))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.types.introduction")))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.types.coloration").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE), Component.translatable("commands.betterglass.bgwiki.types.coloration.explainer").withStyle(ChatFormatting.ITALIC))))
                                                            .append("\n    ").append(Component.translatable("commands.betterglass.bgwiki.types.coloration.explainer.extra").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.types.behaviour").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE), Component.translatable("commands.betterglass.bgwiki.types.behaviour.explainer").withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.types.variants").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE), Component.translatable("commands.betterglass.bgwiki.types.variants.explainer").withStyle(ChatFormatting.ITALIC))))
                                                            .append("\n\n").append(Component.translatable("commands.betterglass.bgwiki.types.available").withStyle(ChatFormatting.BOLD))
                                                            .append("\n").append(Component.translatable("commands.betterglass.bgwiki.types.chiseled.creative_only_500").withStyle(ChatFormatting.ITALIC)),
                                            false);
                                    return 1;
                                }))
                                .then(Commands.literal("roadmap").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("").append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("betterglass.modname"), Component.translatable("commands.betterglass.bgwiki.roadmap")).withStyle(ChatFormatting.BOLD))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.bgwiki.roadmap.introduction")))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.roadmap.120.name").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE), Component.translatable("commands.betterglass.bgwiki.roadmap.120.description"))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.roadmap.130.name").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE), Component.translatable("commands.betterglass.bgwiki.roadmap.130.description"))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.roadmap.140.name").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE), Component.translatable("commands.betterglass.bgwiki.roadmap.140.description")))),
                                            false);
                                    return 1;
                                }))
                                .then(Commands.literal("info").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("")
                                                            .append(Component.literal("å ").withStyle(ChatFormatting.BOLD, ChatFormatting.OBFUSCATED, ChatFormatting.DARK_PURPLE))
                                                            .append(Component.translatable("commands.betterglass.bgwiki.info.introduction").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_PURPLE))
                                                            .append(Component.literal(" å").withStyle(ChatFormatting.BOLD, ChatFormatting.OBFUSCATED, ChatFormatting.DARK_PURPLE))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.info.version").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA), Component.literal(BetterGlass.MOD_VERSION).withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.info.git_hash").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA), Component.literal(BetterGlass.COMMIT_HASH).withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.info.website").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA), Component.literal("petbyte.dev").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.OpenUrl(URI.create("https://petbyte.dev"))).withHoverEvent(new HoverEvent.ShowText(Component.translatable("commands.betterglass.generic.hover.click_to_view.petbyte_website")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.ITALIC, ChatFormatting.GOLD))))
                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content", Component.translatable("commands.betterglass.bgwiki.info.author").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA), Component.literal("joelfrom08").withStyle(ChatFormatting.ITALIC))))
                                                            .append(Component.literal("\n© 2026 PetByte 🧡").withStyle(ChatFormatting.GOLD)),
                                            false);
                                    return 1;
                                }))
                                .then(Commands.literal("faq").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("").append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.translatable("commands.betterglass.generic.specific_section", Component.translatable("betterglass.modname"), Component.translatable("commands.betterglass.bgwiki.faq")).withStyle(ChatFormatting.BOLD))

                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content",
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.forced_to_use_custom_textures_vanilla_glass").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN),
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.forced_to_use_custom_textures_vanilla_glass.answer"))))

                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content",
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.connected_textures_do_not_work").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN),
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.connected_textures_do_not_work.answer",
                                                                            Component.translatable("resourcePack.betterglass.connecting_textures.name"),
                                                                            Component.translatable("commands.betterglass.generic.github_repo").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.OpenUrl(URI.create("https://github.com/PetByteStudios/better-glass-mod"))).withHoverEvent(new HoverEvent.ShowText(Component.literal("https://github.com/PetByteStudios/better-glass-mod")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_BLUE)))))

                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content",
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.how_to_deal_with_recipes").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN),
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.how_to_deal_with_recipes.answer",
                                                                            Component.literal("/bgwiki recipes").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes")).withHoverEvent(new HoverEvent.ShowText(Component.translatable("commands.betterglass.generic.hover.click_to_view.recipes")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.RED)))))

                                                            .append(Component.translatable("commands.betterglass.generic.newline", Component.translatable("commands.betterglass.generic.label_content",
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.how_many_glass_blocks").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN),
                                                                    Component.translatable("commands.betterglass.bgwiki.faq.how_many_glass_blocks.answer",
                                                                            Component.literal("769").withStyle(ChatFormatting.BOLD, ChatFormatting.LIGHT_PURPLE), Component.literal("1,138").withStyle(ChatFormatting.BOLD, ChatFormatting.LIGHT_PURPLE))))),
                                            false);
                                    return 1;
                                }))
                ));
    }
}