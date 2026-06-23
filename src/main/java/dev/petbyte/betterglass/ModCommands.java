package dev.petbyte.betterglass;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import java.net.URI;

public class ModCommands {
    public static void registerModCommands() {
        BetterGlass.LOGGER.info("Registering Mod Commands for %s".formatted(BetterGlass.MOD_ID));

        CommandRegistrationCallback.EVENT.register((dispatcher, _, _) ->
                dispatcher.register(Commands.literal("bgwiki").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("    ")
                                                            .append(Component.literal("Welcome to Better Glass (v%s)!".formatted(BetterGlass.MOD_VERSION)).withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.literal("\n\n")).append(Component.literal("This command is a small wiki on Better Glass. Run any of the below commands to read more!"))
                                                            .append(Component.literal("\n")).append(Component.literal("    "))
                                                            .append(Component.literal("/bgwiki recipes").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                            .append(Component.literal(" — Recipes").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\n")).append(Component.literal("    "))
                                                            .append(Component.literal("/bgwiki types").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki types"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                            .append(Component.literal(" — Glass Types").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\n")).append(Component.literal("    "))
                                                            .append(Component.literal("/bgwiki roadmap").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki roadmap"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                            .append(Component.literal(" — Roadmap").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\n")).append(Component.literal("    "))
                                                            .append(Component.literal("/bgwiki info").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki info"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                            .append(Component.literal(" — Extra Information").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\n")).append(Component.literal("    "))
                                                            .append(Component.literal("/bgwiki faq").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki faq"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                            .append(Component.literal(" — FAQ").withStyle(ChatFormatting.ITALIC)),
                                            false);
                                    return 1;
                                })
                                .then(Commands.literal("recipes").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Better Glass: Recipes").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nThis command shows you recipes for Better Glass, it is meant as a small tool. However, I do recommend a Recipe Viewer, such as \"JEI\", for more details."))
                                                                            .append(Component.literal("\nClick any of the recipes below."))
                                                                            .append(Component.literal("\n"))
                                                                            .append(Component.literal("Re-Dye").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes redye"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(" "))
                                                                            .append(Component.literal("Un-Dye").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes undye"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(" "))
                                                                            .append(Component.literal("Dye (One Step)").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes dyeonce"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(" "))
                                                                            .append(Component.literal("Dye (Two Steps)").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes dyetwice"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal("\n"))
                                                                            .append(Component.literal("Panes").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes panes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(" "))
                                                                            .append(Component.literal("Cycle Types").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes cycle"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(" "))
                                                                            .append(Component.literal("Tint").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes tint"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(" "))
                                                                            .append(Component.literal("Un-tint").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes untint"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(" "))
                                                                            .append(Component.literal("Stonecutter").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes stonecutter"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append("\n\n    ").append(Component.literal("For info on patterns, check ")
                                                                            .append(Component.literal("Patterns").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes patterns"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)))
                                                                            .append("."),
                                                            false);
                                                    return 1;
                                                })
                                                .then(Commands.literal("redye").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Re-Dye Recipe (Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can re-dye Glass using the following recipe:"))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Glass"))
                                                                            .append(Component.literal("\nGDG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  (same type, any color (must all be Stained or Colored, no mixing))"))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  D = A Dye"))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("undye").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Un-Dye Recipe (Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can un-dye Glass using the following recipe:"))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Colored/Stained Glass"))
                                                                            .append(Component.literal("\nGWG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  (Same Glass Type. Stained -> Colored needs the same color, Colored -> Undyed can mix colors.)"))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  W = Water Bucket"))
                                                                            .append(Component.literal("\nThis recipe does one step, from Stained to Colored, and Colored to Undyed."))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("dyeonce").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Dye (One Step) Recipe (Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can dye Glass once using the following recipe:"))
                                                                            .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Colored/Stained Glass"))
                                                                            .append(Component.literal("\nGDG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  (same type and color; or undyed)"))
                                                                            .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  D = A Dye"))
                                                                            .append(Component.literal("\nThis recipe does one step, from Undyed to Colored, or Colored to Stained."))
                                                                            .append(Component.literal("\nTo go straight from Undyed to Stained, check "))
                                                                            .append(Component.literal("Dye (Two Steps)").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(".\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("dyetwice").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Dye (Two Steps) Recipe (Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can stain Glass using the following recipe:"))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Undyed Glass (same type)"))
                                                                            .append(Component.literal("\nGDG").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  D = A Dye"))
                                                                            .append(Component.literal("\nThis recipe does two steps, from Undyed to Stained."))
                                                                            .append(Component.literal("\nTo go from Undyed to Colored, or Colored to Stained, check "))
                                                                            .append(Component.literal("Dye (One Step)").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                                            .append(Component.literal(".\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("panes").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Panes Recipe (Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can craft Glass Panes using the following recipe:"))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Glass (must be the same type)"))
                                                                            .append(Component.literal("\nGGG").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nThis recipe results in an output of 16."))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("cycle").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Cycle through Types Recipe (Inventory/Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can cycle through types using the following recipe:"))
                                                                            .append(Component.literal("\nGG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Glass (must be the same type)"))
                                                                            .append(Component.literal("\nGG").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nThis recipe cycles through Clear -> Scratched -> Vanilla -> ..."))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("tint").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Tinting Glass Recipe (Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can craft Tinted Glass using the following recipe:"))
                                                                            .append(Component.literal("\n A ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  A = Amethyst Shard"))
                                                                            .append(Component.literal("\nAGA").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\n A ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Glass (must be the same type & color)"))
                                                                            .append(Component.literal("\nThis recipe results in an output of 2."))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("untint").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Un-tinting Glass Recipe (Crafting Table)").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can un-tint Tinted Glass using the following recipe:"))
                                                                            .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Glass (must be the same type & color)"))
                                                                            .append(Component.literal("\nGHG").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  H = Honeycomb"))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("stonecutter").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Stonecutter/Glasscutter recipes").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nBy inputting any Glass Block or Pane, you can easily change the Glass Type."))
                                                                            .append(Component.literal("\nBy inputting any Colored or Stained Glass Block or Pane, you can switch between Coloration type at no extra cost."))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                }))
                                                .then(Commands.literal("patterns").executes(context -> {
                                                    context.getSource().sendSuccess(() ->
                                                                    Component.literal("")
                                                                            .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                            .append(Component.literal("Pattern recipes").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\nYou can put a pattern on a Glass using the following recipe:"))
                                                                            .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G = Any Glass (must be the same type; not stained/colored)"))
                                                                            .append(Component.literal("\nGPG").withStyle(ChatFormatting.BOLD))
                                                                            .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P = Any Pattern"))
                                                                            .append(Component.literal("\nFor recipes of patterns, run /bgwiki recipes patterns [pattern name]."))
                                                                            .append(Component.literal("\n  "))
                                                                            .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                            false);
                                                    return 1;
                                                })
                                                            .then(Commands.literal("checkerboard").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Checkerboard").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Checkerboard Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEBW").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n WB").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/W = Black/White Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("null").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Null").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Null Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEBP").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n PB").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/P = Black/Pink Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("agender").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Agender").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Agender Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEBL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n W ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/L/W = Black/Lime/White Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("androgyne").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Androgyne").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Androgyne Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEPU").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n C ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/U/C = Pink/Purple/Cyan Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("aroace").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Aroace").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Aroace Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEOY").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nWLB").withStyle(ChatFormatting.BOLD)).append(Component.literal("  O/Y/W/L/B = Orange/Yellow/White/Light Blue/Blue Dye"))
                                                                                        .append(Component.literal("\nThe Aroace Pattern can also be crafted by combining an Aromantic Pattern with an Asexual or Asexual New Pattern."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("aromantic").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Aromantic").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Aromantic Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEGL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nWIB").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G/L/W/I/B = Green/Lime/White/Light Gray/Black Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("asexual").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Asexual").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Asexual Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEBL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n WP").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/L/W/P = Black/Light Gray/White/Purple Dye"))
                                                                                        .append(Component.literal("\nThe Asexual Pattern can also be crafted by putting an Asexual New Pattern into the crafting grid."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("asexual_new").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Asexual New").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Asexual New Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEBL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nWYP").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/L/W/Y/P = Black/Light Gray/White/Yellow/Pink Dye"))
                                                                                        .append(Component.literal("\nThe Asexual New Pattern can also be crafted by putting an Asexual Pattern into the crafting grid."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("bigender").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Bigender").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Bigender Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEPW").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n LB").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/W/L/B = Pink/White/Light Blue/Blue Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("bisexual").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Bisexual").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Bisexual Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEPU").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n B ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/U/B = Pink/Purple/Blue Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demiboy").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Demiboy").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Demiboy Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEGL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n B ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G/L/B = Gray/Light Gray/Light Blue Dye"))
                                                                                        .append(Component.literal("\nThe Demiboy Pattern can also be crafted by putting a Demigender or Demigirl Pattern into the crafting grid alongside Light Blue Dye."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demigender").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Demigender").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Demigender Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEGL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n Y ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G/L/Y = Gray/Light Gray/Yellow Dye"))
                                                                                        .append(Component.literal("\nThe Demigender Pattern can also be crafted by putting a Demiboy or Demigirl Pattern into the crafting grid alongside Yellow Dye."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demigirl").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Demigirl").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Demigirl Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEGL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n P ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G/L/P = Gray/Light Gray/Pink Dye"))
                                                                                        .append(Component.literal("\nThe Demigirl Pattern can also be crafted by putting a Demiboy or Demigender Pattern into the crafting grid alongside Pink Dye."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demiromantic").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Demiromantic").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Demiromantic Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEW ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nBG ").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\n L ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  W/B/G/L = White/Black/Green/Light Gray Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("demisexual").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Demisexual").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Demisexual Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEW ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nBP ").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\n L ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  W/B/P/L = White/Black/Purple/Light Gray Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("genderfluid").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Genderfluid").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Genderfluid Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEPW").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nUBL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/W/U/B/L = Pink/White/Purple/Black/Blue Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("genderqueer").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Genderqueer").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Genderqueer Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEP ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n W ").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/W/G = Purple/White/Green Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("intersex").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Intersex").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Intersex Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEYP").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n   ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  Y/P = Yellow/Purple Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("lesbian").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Lesbian").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Lesbian Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEOW").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n P ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  O/W/P = Orange/White/Pink Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("mlm").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Mlm").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Mlm Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEGW").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n B ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G/W/B = Green/White/Blue Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("neutrois").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Neutrois").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Neutrois Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEW ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n G ").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\n B ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  W/G/B = White/Green/Black Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("nonbinary").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Nonbinary").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Nonbinary Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEYW").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n PB").withStyle(ChatFormatting.BOLD)).append(Component.literal("  Y/W/P/B = Yellow/White/Purple/Black Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("omnisexual").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Omnisexual").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Omnisexual Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEP ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n B ").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\n U ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/B/U = Pink/Black/Blue Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("pansexual").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Pansexual").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Pansexual Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEP ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n Y ").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\n C ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/Y/C = Pink/Yellow/Cyan Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("philadelphia_pride").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Philadelphia Pride").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Philadelphia Pride Pattern using the following recipes:"))
                                                                                        .append(Component.literal("\nEBR").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nDOY").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/R/D/O = Black/Brown/Red/Orange Dye"))
                                                                                        .append(Component.literal("\nGLU").withStyle(ChatFormatting.BOLD)).append(Component.literal("  Y/G/L/U = Yellow/Green/Blue/Purple Dye"))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.literal("\nPBR").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P = Rainbow Pattern"))
                                                                                        .append(Component.literal("\n   ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/R = Black/Brown Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polyamory").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Polyamory").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Polyamory Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEBR").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n YL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/R/Y/L = Blue/Red/Yellow/Black Dye"))
                                                                                        .append(Component.literal("\nThe Polyamory Pattern can also be crafted by putting an Polyamory New Pattern into the crafting grid."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polyamory_new").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Polyamory New").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Polyamory New Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEWY").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nCPU").withStyle(ChatFormatting.BOLD)).append(Component.literal("  W/Y/C/P/U = White/Yellow/Cyan/Pink/Purple Dye"))
                                                                                        .append(Component.literal("\nThe Polyamory New Pattern can also be crafted by putting an Polyamory Pattern into the crafting grid."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polygender").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Polygender").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Polygender Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEBL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nPYI").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/L/P/Y/I = Black/Light Gray/Pink/Yellow/Light Blue Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("polysexual").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Polysexual").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Polysexual Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEPG").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n B ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P/G/B = Pink/Green/Blue Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("progress").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Progress").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Progress Pattern using the following recipes:"))
                                                                                        .append(Component.literal("\nPBR").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P = Rainbow Pattern"))
                                                                                        .append(Component.literal("\nWIL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/R/W/P/I = Black/Brown/White/Pink/Light Blue Dye"))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.literal("\nPBR").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P = Rainbow Pattern; T = Transfem/-gender/-masc Pattern"))
                                                                                        .append(Component.literal("\n T ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  B/R = Black/Brown Dye"))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.literal("\nPWI").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P = Philadelphia Pattern"))
                                                                                        .append(Component.literal("\n L ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  W/I/L = White/Pink/Light Blue Dye"))
                                                                                        .append(Component.literal("\n"))
                                                                                        .append(Component.literal("\nPT ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  P = Philadelphia Pattern"))
                                                                                        .append(Component.literal("\n   ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  T = Transfem/-gender/-masc Pattern"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("rainbow").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Rainbow").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Rainbow Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nERO").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nYGB").withStyle(ChatFormatting.BOLD)).append(Component.literal("  R/O/Y = Red/Orange/Yellow Dye"))
                                                                                        .append(Component.literal("\n U ").withStyle(ChatFormatting.BOLD)).append(Component.literal("  G/B/P = Green/Blue/Purple Dye"))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("transfem").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Transfem").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Transfem Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nELL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n PP").withStyle(ChatFormatting.BOLD)).append(Component.literal("  L/P = Light Blue/Pink Dye"))
                                                                                        .append(Component.literal("\nThe Transfem Pattern can also be crafted by putting a Transmasc Pattern into the crafting grid."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("transgender").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Transgender").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Transgender Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nELP").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\nWPL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  L/P/W = Light Blue/Pink/White Dye"))
                                                                                        .append(Component.literal("\nThe Transfem Pattern can also be crafted by putting a Transfem or Transmasc Pattern into the crafting grid alongside a White Dye."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                            .then(Commands.literal("transmasc").executes(context -> {
                                                                context.getSource().sendSuccess(() ->
                                                                                Component.literal("")
                                                                                        .append(Component.literal("=== ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                                                        .append(Component.literal("Pattern Recipes: Transmasc").withStyle(ChatFormatting.BOLD))
                                                                                        .append(Component.literal("\nYou can craft a Transmasc Pattern using the following recipe:"))
                                                                                        .append(Component.literal("\nEPP").withStyle(ChatFormatting.BOLD)).append(Component.literal("  E = Empty Pattern"))
                                                                                        .append(Component.literal("\n LL").withStyle(ChatFormatting.BOLD)).append(Component.literal("  L/P = Light Blue/Pink Dye"))
                                                                                        .append(Component.literal("\nThe Transmasc Pattern can also be crafted by putting a Transfem Pattern into the crafting grid."))
                                                                                        .append(Component.literal("\n  "))
                                                                                        .append(Component.literal("Back to root").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)),
                                                                        false);
                                                                return 1;
                                                            }))
                                                )
                                )
                                .then(Commands.literal("types").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("")
                                                            .append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.literal("Better Glass: Glass Types").withStyle(ChatFormatting.BOLD))
                                                            .append("\n")
                                                            .append("Better Glass features various Glass Types, here's an explainer!")
                                                            .append(Component.literal("\nColoration: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                                            .append(Component.literal("There are two types of Coloration for Glass. Those are Stained (the entire block has a stain on it); and Colored (only opaque pixels are colored).").withStyle(ChatFormatting.ITALIC))
                                                            .append("\n    ").append("Additionally, there is \"Patterned\" Glass, which is Stained Glass but with a special motif instead of a color.")
                                                            .append(Component.literal("\nBehaviour: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                                            .append(Component.literal("There are Blocks, Panes, Tinted Blocks, and Tinted Panes. Tinted Glass does not let light through and darkens the area.").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\nVariants: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                                            .append(Component.literal("Glass is available in Vanilla (using a vanilla-like texture), Scratched (using a texture resembling pre-1.14 Glass), and Clear (outline only).").withStyle(ChatFormatting.ITALIC))
                                                            .append("\n\n").append("These are available in all possible combinations.")
                                                            .append("\n").append(Component.literal("There is also a Chiseled Glass variant to celebrate 500 downloads, as of v1.1.0, is Creative-only.").withStyle(ChatFormatting.ITALIC)),
                                            false);
                                    return 1;
                                }))
                                .then(Commands.literal("roadmap").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("").append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.literal("Better Glass: Roadmap").withStyle(ChatFormatting.BOLD))
                                                            .append("\n")
                                                            .append("Better Glass has a Roadmap for the future. This roadmap has no particular timeframe and is non-binding. These changes may never occur, occur in a different order, or only release in the 22nd century.")
                                                            .append(Component.literal("\nv1.2.0: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                                            .append(Component.literal("Tech rewrite, Advancements, QoL (Culling fix & Resource Pack changes)"))
                                                            .append(Component.literal("\nv1.3.0: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                                            .append(Component.literal("Glasscutter, Patterning & Chiseling Station, new Glass, connecting & non-connecting blockstates"))
                                                            .append(Component.literal("\nv1.4.0: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                                            .append(Component.literal("Pane Upgrades (Better culling, more blockstates), new Glass")),
                                            false);
                                    return 1;
                                }))
                                .then(Commands.literal("info").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("")
                                                            .append(Component.literal("å ").withStyle(ChatFormatting.BOLD, ChatFormatting.OBFUSCATED, ChatFormatting.DARK_PURPLE))
                                                            .append(Component.literal("Extra Info for Better Glass...").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_PURPLE))
                                                            .append(Component.literal(" å").withStyle(ChatFormatting.BOLD, ChatFormatting.OBFUSCATED, ChatFormatting.DARK_PURPLE))
                                                            .append(Component.literal("\nVersion: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA))
                                                            .append(Component.literal(BetterGlass.MOD_VERSION).withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\nGit Hash: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA))
                                                            .append(Component.literal(BetterGlass.COMMIT_HASH).withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\nWebsite: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA))
                                                            .append(Component.literal("petbyte.dev").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\nAuthor: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA))
                                                            .append(Component.literal("joelfrom08").withStyle(ChatFormatting.ITALIC))
                                                            .append(Component.literal("\n© 2026 PetByte 🧡").withStyle(ChatFormatting.GOLD)),
                                            false);
                                    return 1;
                                }))
                                .then(Commands.literal("faq").executes(context -> {
                                    context.getSource().sendSuccess(() ->
                                                    Component.literal("").append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                                            .append(Component.literal("Better Glass: FAQ").withStyle(ChatFormatting.BOLD))
                                                            .append(Component.literal("\nAm I forced to use your textures for Vanilla Glass? ").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN))
                                                            .append("Currently, yes, but a toggle to switch back to Vanilla textures will be added in v1.2.0.")
                                                            .append(Component.literal("\nMy Connected Textures don't work, why? ").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN))
                                                            .append("Did you make sure to install the \"Continuity\" mod and enable the provided \"Better Glass: Connecting Textures\" resource pack? If yes, and it doesn't work, report the issue on the ")
                                                            .append(Component.literal("GitHub repo").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.OpenUrl(URI.create("https://github.com/PetByteStudios/better-glass-mod")))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_BLUE))
                                                            .append(Component.literal("\nHow am I supposed to deal with hundreds of different blocks and thousands of recipes!? ").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN))
                                                            .append("I recognize there are a lot of blocks and recipes, it is definitely quite overwhelming. But I have good news for you. Currently planned for v1.3.0 are two workstations to make crafting easier. Additionally, you can use the \"JEI\" mod for a comprehensive overview or run ")
                                                            .append(Component.literal("/bgwiki recipes").setStyle(Style.EMPTY.withClickEvent(new ClickEvent.RunCommand("/bgwiki recipes"))).withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                                            .append(" for a simplified list of recipes.")
                                                            .append(Component.literal("\nHow many Glass blocks are there? ").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN))
                                                            .append("As of v1.1.0, if you sum up all Glass Types, Patterns, Colors, and Stains for normal and tinted blocks and panes, you'll receive ")
                                                            .append(Component.literal("769").withStyle(ChatFormatting.BOLD, ChatFormatting.LIGHT_PURPLE))
                                                            .append(".").append(" If you count in Chiseled blocks (which are Creative-only), you'll reach ")
                                                            .append(Component.literal("1,138").withStyle(ChatFormatting.BOLD, ChatFormatting.LIGHT_PURPLE)).append("!"),
                                            false);
                                    return 1;
                                }))
                ));
    }
}