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
import net.minecraft.world.level.block.Block;

public class ModCreativeModeTabs {
    public static final CreativeModeTab BETTER_GLASS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "better_glass"), FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.CLEAR_GLASS))
                    .title(Component.translatable("creativemodetab.betterglass.betterglass"))
                    .displayItems((parameters, output) -> {
                        for (Block block : ModBlocks.BETTER_GLASS_BLOCKS) {
                            output.accept(block);
                        }
                    }).build());

    public static void registerModCreativeModeTabs() {
        BetterGlass.LOGGER.info("Registering Creative Mode Tabs for %s".formatted(BetterGlass.MOD_ID));
    }
}
