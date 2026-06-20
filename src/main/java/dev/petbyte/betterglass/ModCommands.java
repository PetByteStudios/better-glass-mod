package dev.petbyte.betterglass;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class ModCommands {
    public static void registerModCommands() {
        BetterGlass.LOGGER.info("Registering Mod Commands for %s".formatted(BetterGlass.MOD_ID));

        CommandRegistrationCallback.EVENT.register((dispatcher, _, _) -> {
            dispatcher.register(Commands.literal("bgwiki")
                    .executes(context -> {
                        context.getSource().sendSuccess(() -> Component.literal("    Welcome to Better Glass (%s)!\n".formatted(BetterGlass.MOD_VERSION))
                                .withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD)
                                .append(Component.literal("This command is a small wiki on Better Glass. Run any of the below commands to read more!\n"))
                                .append(Component.literal("    ")).append(Component.literal("/bgwiki recipes").withStyle(ChatFormatting.BOLD, ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)).append(Component.literal(" — Recipes\n").withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("    ")).append(Component.literal("/bgwiki types").withStyle(ChatFormatting.BOLD, ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)).append(Component.literal(" — Glass Types\n").withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("    ")).append(Component.literal("/bgwiki roadmap").withStyle(ChatFormatting.BOLD, ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)).append(Component.literal(" — Roadmap\n").withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("    ")).append(Component.literal("/bgwiki info").withStyle(ChatFormatting.BOLD, ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)).append(Component.literal(" — Extra Information\n").withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("    ")).append(Component.literal("/bgwiki faq").withStyle(ChatFormatting.BOLD, ChatFormatting.UNDERLINE, ChatFormatting.DARK_RED)).append(Component.literal(" — FAQ").withStyle(ChatFormatting.ITALIC)),
                        false);
                        return 1;
                    })
                    .then(Commands.literal("recipes").executes(context -> {
                        context.getSource().sendSuccess(() -> Component.literal("""
                        This command shows you recipes for Better Glass, it is meant as a small tool. However, I do recommend a Recipe Viewer, such as JEI, for more details.
                        
                        TBD.
                        """), false);
                        return 1;
                    }))
                    .then(Commands.literal("types").executes(context -> {
                        context.getSource().sendSuccess(() -> Component.literal("****").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD).append(Component.literal("Better Glass features various Glass Types, here's an explainer!\n").withStyle(ChatFormatting.RESET))
                                .append("\n\n")
                                .append("    ").append(Component.literal("Coloration: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                .append(Component.literal("There are two types of Coloration for Glass. Those are Stained (the entire block has a stain on it); and Colored (only opaque pixels are colored).\n").withStyle(ChatFormatting.ITALIC))
                                .append("    ").append(Component.literal("Behaviour: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                .append(Component.literal("There are Blocks, Panes, Tinted Blocks, and Tinted Panes. Tinted Glass does not let light through and darkens the area.\n").withStyle(ChatFormatting.ITALIC))
                                .append("    ").append(Component.literal("Variants: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                .append(Component.literal("Glass is available in Vanilla (using a vanilla-like texture), Scratched (using a texture resembling pre-1.14 Glass), and Clear (outline only).").withStyle(ChatFormatting.ITALIC))
                                .append("\n\n")
                                .append(Component.literal("These are available in all possible combinations.\n\n").withStyle(ChatFormatting.RESET))
                                .append(Component.literal("There is also a Chiseled Glass variant to celebrate 500 downloads, which, as of v1.1.0, is Creative-only.").withStyle(ChatFormatting.ITALIC)),
                        false);
                        return 1;
                    }))
                    .then(Commands.literal("roadmap").executes(context -> {
                        context.getSource().sendSuccess(() -> Component.literal("****").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD)
                                .append(Component.literal("Better Glass has a Roadmap for the future. This roadmap has no particular timeframe and is non-binding. These changes may never occur, occur in a different order, or only release in the 22nd century.").withStyle(ChatFormatting.RESET))
                                .append("\n\n")
                                .append(Component.literal("v1.2.0: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                .append(Component.literal("Tech rewrite, Advancements, QoL (Culling fix & Resource Pack changes)").withStyle(ChatFormatting.RESET))
                                .append(Component.literal("\nv1.3.0: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                .append(Component.literal("Glasscutter, Patterning & Chiseling Station, new Glass, connecting & non-connecting blockstates").withStyle(ChatFormatting.RESET))
                                .append(Component.literal("\nv1.4.0: ").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                                .append(Component.literal("Pane Upgrades (Better culling, more blockstates), new Glass").withStyle(ChatFormatting.RESET)),
                        false);
                        return 1;
                    }))
                    .then(Commands.literal("info").executes(context -> {
                        context.getSource().sendSuccess(() -> Component.literal("å").withStyle(ChatFormatting.BOLD, ChatFormatting.OBFUSCATED, ChatFormatting.DARK_PURPLE)
                                .append(Component.literal("Extra Info for Better Glass..").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_PURPLE))
                                .append(Component.literal("å\n").withStyle(ChatFormatting.BOLD, ChatFormatting.OBFUSCATED, ChatFormatting.DARK_PURPLE))
                                .append(Component.literal("Version: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA)).append(Component.literal(BetterGlass.MOD_VERSION).withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("\nGit Hash: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA)).append(Component.literal(BetterGlass.COMMIT_HASH).withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("\nWebsite: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA)).append(Component.literal("petbyte.dev").withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("\nAuthor: ").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_AQUA)).append(Component.literal("joelfrom08").withStyle(ChatFormatting.ITALIC))
                                .append(Component.literal("\n© 2026 PetByte 🧡").withStyle(ChatFormatting.BOLD, ChatFormatting.GOLD)),
                        false);
                        return 1;
                    }))
            );
        });
    }
}
