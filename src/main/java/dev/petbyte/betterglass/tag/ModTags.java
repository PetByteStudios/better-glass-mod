package dev.petbyte.betterglass.tag;

import dev.petbyte.betterglass.BetterGlass;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name));
        }

        public static final TagKey<Block> CLEAR_GLASS = createBlockTag("clear_glass");
        public static final TagKey<Block> SCRATCHED_GLASS = createBlockTag("scratched_glass");
        public static final TagKey<Block> COLORED_GLASS = createBlockTag("colored_glass");
        public static final TagKey<Block> STAINED_GLASS = createBlockTag("stained_glass");
        public static final TagKey<Block> COLORED_CLEAR_GLASS = createBlockTag("colored_clear_glass");
        public static final TagKey<Block> STAINED_CLEAR_GLASS = createBlockTag("stained_clear_glass");
        public static final TagKey<Block> COLORED_SCRATCHED_GLASS = createBlockTag("colored_scratched_glass");
        public static final TagKey<Block> STAINED_SCRATCHED_GLASS = createBlockTag("stained_scratched_glass");

        public static final TagKey<Block> STAINED_VANILLA_GLASS_BLOCK = createBlockTag("stained_vanilla_glass_block");
        public static final TagKey<Block> STAINED_VANILLA_GLASS_PANE = createBlockTag("stained_vanilla_glass_pane");
        public static final TagKey<Block> STAINED_VANILLA_GLASS = createBlockTag("stained_vanilla_glass");
    }

    public static class Items {
        private static TagKey<Item> createItemTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name));
        }

        public static final TagKey<Item> CLEAR_GLASS = createItemTag("clear_glass");
        public static final TagKey<Item> SCRATCHED_GLASS = createItemTag("scratched_glass");
        public static final TagKey<Item> COLORED_GLASS = createItemTag("colored_glass");
        public static final TagKey<Item> STAINED_GLASS = createItemTag("stained_glass");
        public static final TagKey<Item> COLORED_CLEAR_GLASS = createItemTag("colored_clear_glass");
        public static final TagKey<Item> STAINED_CLEAR_GLASS = createItemTag("stained_clear_glass");
        public static final TagKey<Item> COLORED_SCRATCHED_GLASS = createItemTag("colored_scratched_glass");
        public static final TagKey<Item> STAINED_SCRATCHED_GLASS = createItemTag("stained_scratched_glass");

        public static final TagKey<Item> STAINED_VANILLA_GLASS_BLOCK = createItemTag("stained_vanilla_glass_block");
        public static final TagKey<Item> STAINED_VANILLA_GLASS_PANE = createItemTag("stained_vanilla_glass_pane");
        public static final TagKey<Item> STAINED_VANILLA_GLASS = createItemTag("stained_vanilla_glass");
    }
}
