package dev.petbyte.betterglass.tag;

import dev.petbyte.betterglass.BetterGlass;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    private static TagKey<Block> createTag(String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name));
    }

    public static final TagKey<Block> CLEAR_GLASS = createTag("clear_glass");
    public static final TagKey<Block> SCRATCHED_GLASS = createTag("scratched_glass");
    public static final TagKey<Block> COLORED_GLASS = createTag("colored_glass");
    public static final TagKey<Block> STAINED_GLASS = createTag("stained_glass");
    public static final TagKey<Block> COLORED_CLEAR_GLASS = createTag("colored_clear_glass");
    public static final TagKey<Block> STAINED_CLEAR_GLASS = createTag("stained_clear_glass");
    public static final TagKey<Block> COLORED_SCRATCHED_GLASS = createTag("colored_scratched_glass");
    public static final TagKey<Block> STAINED_SCRATCHED_GLASS = createTag("stained_scratched_glass");
}
