package dev.petbyte.betterglass.tag;

import dev.petbyte.betterglass.BetterGlass;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    /* private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name));
    }
    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name));
    } */
    public record TagPair(TagKey<Block> block, TagKey<Item> item) {
        public static TagPair create(String name) {
            return new TagPair(
                    TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name)),
                    TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))
            );
        }
    }

    public static final TagPair CLEAR_GLASS = TagPair.create("clear_glass");
    public static final TagPair CLEAR_GLASS_PANE = TagPair.create("clear_glass_pane");
    public static final TagPair SCRATCHED_GLASS = TagPair.create("scratched_glass");
    public static final TagPair COLORED_GLASS = TagPair.create("colored_glass");
    public static final TagPair STAINED_GLASS = TagPair.create("stained_glass");
    public static final TagPair COLORED_CLEAR_GLASS = TagPair.create("colored_clear_glass");
    public static final TagPair STAINED_CLEAR_GLASS = TagPair.create("stained_clear_glass");
    public static final TagPair COLORED_SCRATCHED_GLASS = TagPair.create("colored_scratched_glass");
    public static final TagPair STAINED_SCRATCHED_GLASS = TagPair.create("stained_scratched_glass");

    public static final TagPair STAINED_VANILLA_GLASS_ALL = TagPair.create("stained_vanilla_glass_all");
    public static final TagPair STAINED_VANILLA_GLASS_BLOCK = TagPair.create("stained_vanilla_glass_block");
    public static final TagPair STAINED_VANILLA_GLASS_PANE = TagPair.create("stained_vanilla_glass_pane");

    public static final TagPair COLORED_VANILLA_GLASS = TagPair.create("colored_vanilla_glass");
}
