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
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.List;
import java.util.function.Function;

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

    // To be used.
    // public static List<String> COLORS = List.of("white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink" );

    public static final Block CLEAR_GLASS = registerGlassBlock("clear_glass");
    public static final Block WHITE_COLORED_CLEAR_GLASS = registerGlassBlock("white_colored_clear_glass");
    public static final Block LIGHT_GRAY_COLORED_CLEAR_GLASS = registerGlassBlock("light_gray_colored_clear_glass");
    public static final Block GRAY_COLORED_CLEAR_GLASS = registerGlassBlock("gray_colored_clear_glass");
    public static final Block BLACK_COLORED_CLEAR_GLASS = registerGlassBlock("black_colored_clear_glass");
    public static final Block BROWN_COLORED_CLEAR_GLASS = registerGlassBlock("brown_colored_clear_glass");
    public static final Block RED_COLORED_CLEAR_GLASS = registerGlassBlock("red_colored_clear_glass");
    public static final Block ORANGE_COLORED_CLEAR_GLASS = registerGlassBlock("orange_colored_clear_glass");
    public static final Block YELLOW_COLORED_CLEAR_GLASS = registerGlassBlock("yellow_colored_clear_glass");
    public static final Block LIME_COLORED_CLEAR_GLASS = registerGlassBlock("lime_colored_clear_glass");
    public static final Block GREEN_COLORED_CLEAR_GLASS = registerGlassBlock("green_colored_clear_glass");
    public static final Block CYAN_COLORED_CLEAR_GLASS = registerGlassBlock("cyan_colored_clear_glass");
    public static final Block LIGHT_BLUE_COLORED_CLEAR_GLASS = registerGlassBlock("light_blue_colored_clear_glass");
    public static final Block BLUE_COLORED_CLEAR_GLASS = registerGlassBlock("blue_colored_clear_glass");
    public static final Block PURPLE_COLORED_CLEAR_GLASS = registerGlassBlock("purple_colored_clear_glass");
    public static final Block MAGENTA_COLORED_CLEAR_GLASS = registerGlassBlock("magenta_colored_clear_glass");
    public static final Block PINK_COLORED_CLEAR_GLASS = registerGlassBlock("pink_colored_clear_glass");
    public static final Block WHITE_STAINED_CLEAR_GLASS = registerGlassBlock("white_stained_clear_glass");
    public static final Block LIGHT_GRAY_STAINED_CLEAR_GLASS = registerGlassBlock("light_gray_stained_clear_glass");
    public static final Block GRAY_STAINED_CLEAR_GLASS = registerGlassBlock("gray_stained_clear_glass");
    public static final Block BLACK_STAINED_CLEAR_GLASS = registerGlassBlock("black_stained_clear_glass");
    public static final Block BROWN_STAINED_CLEAR_GLASS = registerGlassBlock("brown_stained_clear_glass");
    public static final Block RED_STAINED_CLEAR_GLASS = registerGlassBlock("red_stained_clear_glass");
    public static final Block ORANGE_STAINED_CLEAR_GLASS = registerGlassBlock("orange_stained_clear_glass");
    public static final Block YELLOW_STAINED_CLEAR_GLASS = registerGlassBlock("yellow_stained_clear_glass");
    public static final Block LIME_STAINED_CLEAR_GLASS = registerGlassBlock("lime_stained_clear_glass");
    public static final Block GREEN_STAINED_CLEAR_GLASS = registerGlassBlock("green_stained_clear_glass");
    public static final Block CYAN_STAINED_CLEAR_GLASS = registerGlassBlock("cyan_stained_clear_glass");
    public static final Block LIGHT_BLUE_STAINED_CLEAR_GLASS = registerGlassBlock("light_blue_stained_clear_glass");
    public static final Block BLUE_STAINED_CLEAR_GLASS = registerGlassBlock("blue_stained_clear_glass");
    public static final Block PURPLE_STAINED_CLEAR_GLASS = registerGlassBlock("purple_stained_clear_glass");
    public static final Block MAGENTA_STAINED_CLEAR_GLASS = registerGlassBlock("magenta_stained_clear_glass");
    public static final Block PINK_STAINED_CLEAR_GLASS = registerGlassBlock("pink_stained_clear_glass");

    public static List<Block> BETTER_GLASS_BLOCKS = List.of(
            CLEAR_GLASS, WHITE_COLORED_CLEAR_GLASS, LIGHT_GRAY_COLORED_CLEAR_GLASS, GRAY_COLORED_CLEAR_GLASS, BLACK_COLORED_CLEAR_GLASS,
            BROWN_COLORED_CLEAR_GLASS, RED_COLORED_CLEAR_GLASS, ORANGE_COLORED_CLEAR_GLASS, YELLOW_COLORED_CLEAR_GLASS, LIME_COLORED_CLEAR_GLASS,
            GREEN_COLORED_CLEAR_GLASS, CYAN_COLORED_CLEAR_GLASS, LIGHT_BLUE_COLORED_CLEAR_GLASS, BLUE_COLORED_CLEAR_GLASS, PURPLE_COLORED_CLEAR_GLASS,
            MAGENTA_COLORED_CLEAR_GLASS, PINK_COLORED_CLEAR_GLASS, WHITE_STAINED_CLEAR_GLASS, LIGHT_GRAY_STAINED_CLEAR_GLASS, GRAY_STAINED_CLEAR_GLASS, BLACK_STAINED_CLEAR_GLASS,
            BROWN_STAINED_CLEAR_GLASS, RED_STAINED_CLEAR_GLASS, ORANGE_STAINED_CLEAR_GLASS, YELLOW_STAINED_CLEAR_GLASS, LIME_STAINED_CLEAR_GLASS,
            GREEN_STAINED_CLEAR_GLASS, CYAN_STAINED_CLEAR_GLASS, LIGHT_BLUE_STAINED_CLEAR_GLASS, BLUE_STAINED_CLEAR_GLASS, PURPLE_STAINED_CLEAR_GLASS,
            MAGENTA_STAINED_CLEAR_GLASS, PINK_STAINED_CLEAR_GLASS
    );


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name), toRegister);
    }

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