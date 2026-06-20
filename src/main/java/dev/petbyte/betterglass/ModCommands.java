package dev.petbyte.betterglass;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

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
                                    .append(Component.literal("/bgwiki recipes").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                    .append(Component.literal(" — Recipes").withStyle(ChatFormatting.ITALIC))
                                    .append(Component.literal("\n")).append(Component.literal("    "))
                                    .append(Component.literal("/bgwiki types").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                    .append(Component.literal(" — Recipes").withStyle(ChatFormatting.ITALIC))
                                    .append(Component.literal("\n")).append(Component.literal("    "))
                                    .append(Component.literal("/bgwiki roadmap").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                    .append(Component.literal(" — Roadmap").withStyle(ChatFormatting.ITALIC))
                                    .append(Component.literal("\n")).append(Component.literal("    "))
                                    .append(Component.literal("/bgwiki info").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                    .append(Component.literal(" — Extra Information").withStyle(ChatFormatting.ITALIC))
                                    .append(Component.literal("\n")).append(Component.literal("    "))
                                    .append(Component.literal("/bgwiki faq").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                    .append(Component.literal(" — FAQ").withStyle(ChatFormatting.ITALIC)),
                            false);
                    return 1;
                })
                .then(Commands.literal("recipes").executes(context -> {
                    context.getSource().sendSuccess(() -> Component.literal("""
                    This command shows you recipes for Better Glass, it is meant as a small tool. However, I do recommend a Recipe Viewer, such as "JEI", for more details.
                    §l§4tset
                    TBD.
                    """), false);
                    return 1;
                }))
                .then(Commands.literal("types").executes(context -> {
                    context.getSource().sendSuccess(() ->
                                Component.literal("")
                                        .append(Component.literal("==  ").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD))
                                        .append("Better Glass features various Glass Types, here's an explainer!")
                                        .append(Component.literal("\nColoration: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                        .append(Component.literal("There are two types of Coloration for Glass. Those are Stained (the entire block has a stain on it); and Colored (only opaque pixels are colored).").withStyle(ChatFormatting.ITALIC))
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
                                            .append("Better Glass FAQ")
                                            .append(Component.literal("\nAm I forced to use your textures for Vanilla Glass? ").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN))
                                            .append("Currently, yes, but a toggle to switch back to Vanilla textures will be added in v1.2.0.")
                                            .append(Component.literal("\nMy Connected Textures don't work, why? ").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN))
                                            .append("Did you make sure to install the \"Continuity\" mod and enable the provided \"Better Glass: Connecting Textures\" resource pack? If yes, and it doesn't work, report the issue on the ")
                                            .append(Component.literal("GitHub repo").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_BLUE))
                                            .append(Component.literal("\nHow am I supposed to deal with hundreds of different blocks and thousands of recipes!? ").withStyle(ChatFormatting.ITALIC, ChatFormatting.GREEN))
                                            .append("I recognize there are a lot of blocks and recipes, it is definitely quite overwhelming. But I have good news for you. Currently planned for v1.3.0 are two workstations to make crafting easier. Additionally, you can use the \"JEI\" mod for a comprehensive overview or run ")
                                            .append(Component.literal("/bgwiki recipes").withStyle(ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED))
                                            .append(" for a simplified list of recipes."),
                            false);
                    return 1;
                }))
        ));
    }
}
