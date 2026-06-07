package dev.petbyte.betterglass;

import dev.petbyte.betterglass.glasscutter.ModMenus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class BetterGlassClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
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

        ModMenus.RegisterGlasscutterMenu();
    }
}
