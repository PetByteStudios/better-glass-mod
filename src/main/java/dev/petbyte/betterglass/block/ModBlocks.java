package dev.petbyte.betterglass.block;

import dev.petbyte.betterglass.BetterGlass;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
// import java.util.function.Function;

public class ModBlocks {
    private static BlockBehaviour.Properties glassProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .instrument(NoteBlockInstrument.HAT)
                .noOcclusion()
                .isValidSpawn(Blocks::never)
                .isRedstoneConductor(Blocks::never)
                .isSuffocating(Blocks::never)
                .isViewBlocking(Blocks::never);
    }

    public static final List<DyeColor> DYE_ORDER = List.of(
            DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK,
            DyeColor.BROWN, DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW,
            DyeColor.LIME, DyeColor.GREEN, DyeColor.CYAN, DyeColor.LIGHT_BLUE,
            DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK
    );

    public static final Block CLEAR_GLASS = registerGlassBlock("clear_glass");
    public static final Block SCRATCHED_GLASS = registerGlassBlock("scratched_glass");

    public static List<Block> BETTER_GLASS_BLOCKS = new ArrayList<>(List.of(
            CLEAR_GLASS, SCRATCHED_GLASS
    ));

    public static final Map<DyeColor, Block> COLORED_CLEAR_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_CLEAR_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_SCRATCHED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_SCRATCHED_GLASS = new LinkedHashMap<>();

    static {
        for (DyeColor color : DYE_ORDER) {
            COLORED_CLEAR_GLASS.put(color, registerGlassBlock(color.getName() + "_colored_clear_glass"));
            STAINED_CLEAR_GLASS.put(color, registerGlassBlock(color.getName() + "_stained_clear_glass"));
            COLORED_SCRATCHED_GLASS.put(color, registerGlassBlock(color.getName() + "_colored_scratched_glass"));
            STAINED_SCRATCHED_GLASS.put(color, registerGlassBlock(color.getName() + "_stained_scratched_glass"));
        }

        BETTER_GLASS_BLOCKS.addAll(COLORED_CLEAR_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(STAINED_CLEAR_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(COLORED_SCRATCHED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(STAINED_SCRATCHED_GLASS.values());
    }

    public static final Block GLASSCUTTER = registerGlasscutter();

    public static Block registerGlasscutter() {
        Block toRegister = new StonecutterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONECUTTER)
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "glasscutter"))));
        registerBlockItem("glasscutter", toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "glasscutter"), toRegister);
    }

    /*
    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name), toRegister);
    }
    */

    private static Block registerGlassBlock(String name) {
        Block toRegister = new TransparentBlock(glassProperties().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name),
                new BlockItem(block, new Item.Properties()
                        .useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        BetterGlass.LOGGER.info("Registering Mod Blocks for %s".formatted(BetterGlass.MOD_ID));

        for (Block block : BETTER_GLASS_BLOCKS) {
            CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> output.accept(block));
            CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> output.accept(block));
        }
    }
}