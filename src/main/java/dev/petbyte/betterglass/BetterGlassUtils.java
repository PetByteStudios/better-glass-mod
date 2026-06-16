package dev.petbyte.betterglass;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.List;

public class BetterGlassUtils {
    public static ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name));
    }

    public static ResourceKey<Block> blockKey(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
    }

    public static List<ResourceKey<Block>> blockKeys(Block... blocks) {
        return Arrays.stream(blocks).map(BetterGlassUtils::blockKey).toList();
    }

    public static ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name));
    }

    public static ResourceKey<Item> itemKey(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }

    public static void addAll(TagAppender<Block> builder, Block... blocks) {
        for (Block b : blocks) builder.add(blockKey(b));
    }

    public static void addAll(TagAppender<Item> builder, Item... items) {
        for (Item i : items) builder.add(itemKey(i));
    }
}
