package dev.petbyte.betterglass;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class BetterGlassClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Disable for non-beta releases.
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            client.player.sendSystemMessage(Component.literal("Better Glass").withStyle(style -> style.withBold(true)).append(Component.literal(" v" + BetterGlass.MOD_VERSION).withStyle(style -> style.withBold(false).withItalic(true).withColor(ChatFormatting.RED))));
            client.player.sendOverlayMessage(Component.literal("Better Glass").withStyle(style -> style.withBold(true)).append(Component.literal(" v" + BetterGlass.MOD_VERSION).withStyle(style -> style.withBold(false).withItalic(true).withColor(ChatFormatting.RED))));
        });
    }
}
