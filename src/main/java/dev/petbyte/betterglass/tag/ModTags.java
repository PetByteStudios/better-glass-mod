package dev.petbyte.betterglass.tag;

import dev.petbyte.betterglass.BetterGlass;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModTags {
    public record TagPair(TagKey<Block> block, TagKey<Item> item) {
        public static TagPair create(String name) {
            TagPair tagPair = new TagPair(
                    TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name)),
                    TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))
            );
            ALL_TAG_PAIRS.add(tagPair);
            return tagPair;
        }
    }

    public static List<TagPair> ALL_TAG_PAIRS = new ArrayList<>();

    public static final TagPair CLEAR_GLASS_BLOCK = TagPair.create("clear_glass_block");
    public static final TagPair CLEAR_GLASS_PANE = TagPair.create("clear_glass_pane");
    public static final TagPair CLEAR_GLASS_ALL = TagPair.create("clear_glass_all");
    public static final TagPair SCRATCHED_GLASS_BLOCK = TagPair.create("scratched_glass_block");
    public static final TagPair SCRATCHED_GLASS_PANE = TagPair.create("scratched_glass_pane");
    public static final TagPair SCRATCHED_GLASS_ALL = TagPair.create("scratched_glass_all");
    public static final TagPair COLORED_GLASS_BLOCK = TagPair.create("colored_glass_block");
    public static final TagPair COLORED_GLASS_PANE = TagPair.create("colored_glass_pane");
    public static final TagPair COLORED_GLASS_ALL = TagPair.create("colored_glass_all");
    public static final TagPair STAINED_GLASS_BLOCK = TagPair.create("stained_glass_block");
    public static final TagPair STAINED_GLASS_PANE = TagPair.create("stained_glass_pane");
    public static final TagPair STAINED_GLASS_ALL = TagPair.create("stained_glass_all");
    public static final TagPair COLORED_CLEAR_GLASS_BLOCK = TagPair.create("colored_clear_glass_block");
    public static final TagPair COLORED_CLEAR_GLASS_PANE = TagPair.create("colored_clear_glass_pane");
    public static final TagPair COLORED_CLEAR_GLASS_ALL = TagPair.create("colored_clear_glass_all");
    public static final TagPair STAINED_CLEAR_GLASS_BLOCK = TagPair.create("stained_clear_glass_block");
    public static final TagPair STAINED_CLEAR_GLASS_PANE = TagPair.create("stained_clear_glass_pane");
    public static final TagPair STAINED_CLEAR_GLASS_ALL = TagPair.create("stained_clear_glass_all");
    public static final TagPair COLORED_SCRATCHED_GLASS_BLOCK = TagPair.create("colored_scratched_glass_block");
    public static final TagPair COLORED_SCRATCHED_GLASS_PANE = TagPair.create("colored_scratched_glass_pane");
    public static final TagPair COLORED_SCRATCHED_GLASS_ALL = TagPair.create("colored_scratched_glass_all");
    public static final TagPair STAINED_SCRATCHED_GLASS_BLOCK = TagPair.create("stained_scratched_glass_block");
    public static final TagPair STAINED_SCRATCHED_GLASS_PANE = TagPair.create("stained_scratched_glass_pane");
    public static final TagPair STAINED_SCRATCHED_GLASS_ALL = TagPair.create("stained_scratched_glass_all");

    public static final TagPair STAINED_VANILLA_GLASS_BLOCK = TagPair.create("stained_vanilla_glass_block");
    public static final TagPair STAINED_VANILLA_GLASS_PANE = TagPair.create("stained_vanilla_glass_pane");
    public static final TagPair STAINED_VANILLA_GLASS_ALL = TagPair.create("stained_vanilla_glass_all");

    public static final TagPair COLORED_VANILLA_GLASS_BLOCK = TagPair.create("colored_vanilla_glass_block");
    public static final TagPair COLORED_VANILLA_GLASS_PANE = TagPair.create("colored_vanilla_glass_pane");
    public static final TagPair COLORED_VANILLA_GLASS_ALL = TagPair.create("colored_vanilla_glass_all");
}
