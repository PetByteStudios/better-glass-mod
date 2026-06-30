package dev.petbyte.betterglass.tab;

import dev.petbyte.betterglass.BetterGlass;
import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModCreativeModeTabs {
    @SuppressWarnings("unused")
    public static final CreativeModeTab BETTER_GLASS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "better_glass"), FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.CLEAR_GLASS))
                    .title(Component.translatable("creativemodetab.betterglass.betterglass"))
                    .displayItems((_, output) -> {
                        output.accept(ModBlocks.TINTED_GLASS_PANE);
                        for (Block block : ModBlocks.BETTER_GLASS_NORMAL_ALL) {
                            output.accept(block);
                        }
                        output.accept(ModBlocks.GLASSCUTTER);
                    }).build());

    @SuppressWarnings("unused")
    public static final CreativeModeTab BETTER_GLASS_PATTERNED_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "better_glass_patterned"), FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.PATTERNED_GLASS_BLOCKS.get("null")))
                    .title(Component.translatable("creativemodetab.betterglass.betterglass_patterned"))
                    .displayItems((_, output) -> {
                        output.accept(ModItems.EMPTY_PATTERN);
                        for (String motif : ModBlocks.PATTERN_MOTIFS) {
                            output.accept(ModItems.PATTERNS.get(motif));
                        }
                        for (Block block : ModBlocks.BETTER_GLASS_PATTERNED_ALL) {
                            output.accept(block);
                        }
                    }).build());

    @SuppressWarnings("unused")
    public static final CreativeModeTab BETTER_GLASS_CHISELED_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "better_glass_chiseled"), FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ALL_CHISELED_GLASS.getFirst()))
                    .title(Component.translatable("creativemodetab.betterglass.betterglass_chiseled"))
                    .displayItems((_, output) -> {
                        for (Block block : ModBlocks.BETTER_GLASS_CHISELED_ALL) {
                            output.accept(block);
                        }
                    }).build());

    public static void registerModCreativeModeTabs() {
        BetterGlass.LOGGER.info("Registering Creative Mode Tabs for %s".formatted(BetterGlass.MOD_ID));
    }
}
