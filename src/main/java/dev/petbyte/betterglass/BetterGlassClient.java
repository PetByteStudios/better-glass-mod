package dev.petbyte.betterglass;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class BetterGlassClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Disable for non-beta releases.
        ClientPlayConnectionEvents.JOIN.register((_, _, client) -> {
            assert client.player != null;
            client.player.sendSystemMessage(Component.literal("Better Glass").withStyle(style -> style.withBold(true)).append(Component.literal(" v" + BetterGlass.MOD_VERSION).withStyle(style -> style.withBold(false).withItalic(true).withColor(ChatFormatting.RED))));
            client.player.sendOverlayMessage(Component.literal("Better Glass").withStyle(style -> style.withBold(true)).append(Component.literal(" v" + BetterGlass.MOD_VERSION).withStyle(style -> style.withBold(false).withItalic(true).withColor(ChatFormatting.RED))));
        });

        ResourceLoader.registerBuiltinPack(
                Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "connecting_textures"),
                FabricLoader.getInstance().getModContainer(BetterGlass.MOD_ID).orElseThrow(),
                Component.translatable("resourcePack.betterglass.connecting_textures.name"),
                PackActivationType.DEFAULT_ENABLED
        );

        ResourceLoader.registerBuiltinPack(
                Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "base_assets"),
                FabricLoader.getInstance().getModContainer(BetterGlass.MOD_ID).orElseThrow(),
                Component.translatable("resourcePack.betterglass.base_assets.name"),
                PackActivationType.ALWAYS_ENABLED
        );
    }
}
