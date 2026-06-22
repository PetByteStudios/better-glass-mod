package dev.petbyte.betterglass.item;

import dev.petbyte.betterglass.BetterGlass;
import dev.petbyte.betterglass.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ModItems {
    public static final List<Item> ALL_ITEMS = new ArrayList<>();
    public static Map<String, Item> PATTERNS = new LinkedHashMap<>();

    public static final Item EMPTY_PATTERN = registerItem("empty_pattern", Item::new);

    static {
        for (String patternMotif : ModBlocks.PATTERN_MOTIFS) {
            PATTERNS.put(patternMotif, registerItem("%s_pattern".formatted(patternMotif), Item::new));
        }

        ALL_ITEMS.add(EMPTY_PATTERN);
        ALL_ITEMS.addAll(PATTERNS.values());
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name)))));
    }

    public static void registerModItems() {
        BetterGlass.LOGGER.info("Registering Mod Items for %s".formatted(BetterGlass.MOD_ID));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            for (String patternMotif : ModBlocks.PATTERN_MOTIFS) {
                output.accept(PATTERNS.get(patternMotif));
            }
        });
    }
}
