package dev.petbyte.betterglass.tab;

import dev.petbyte.betterglass.BetterGlass;
import dev.petbyte.betterglass.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab BETTER_GLASS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "better_glass"), FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.CLEAR_GLASS))
                    .title(Component.translatable("creativemodetab.betterglass.betterglass"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.CLEAR_GLASS);
                        output.accept(ModBlocks.WHITE_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.LIGHT_GRAY_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.GRAY_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.BLACK_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.BROWN_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.RED_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.ORANGE_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.YELLOW_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.LIME_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.GREEN_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.CYAN_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.LIGHT_BLUE_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.BLUE_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.PURPLE_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.MAGENTA_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.PINK_COLORED_CLEAR_GLASS);
                        output.accept(ModBlocks.WHITE_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.LIGHT_GRAY_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.GRAY_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.BLACK_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.BROWN_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.RED_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.ORANGE_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.YELLOW_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.LIME_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.GREEN_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.CYAN_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.LIGHT_BLUE_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.BLUE_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.PURPLE_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.MAGENTA_STAINED_CLEAR_GLASS);
                        output.accept(ModBlocks.PINK_STAINED_CLEAR_GLASS);
                    }).build());

    public static void registerModCreativeModeTabs() {
        BetterGlass.LOGGER.info("Registering Creative Mode Tabs for %s".formatted(BetterGlass.MOD_ID));
    }
}
