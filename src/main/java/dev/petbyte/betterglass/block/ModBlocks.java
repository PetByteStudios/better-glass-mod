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

import java.util.function.Function;

public class ModBlocks {
    public static final Block CLEAR_GLASS = registerBlock("clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));

    public static final Block WHITE_COLORED_CLEAR_GLASS = registerBlock("white_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block LIGHT_GRAY_COLORED_CLEAR_GLASS = registerBlock("light_gray_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block GRAY_COLORED_CLEAR_GLASS = registerBlock("gray_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block BLACK_COLORED_CLEAR_GLASS = registerBlock("black_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block BROWN_COLORED_CLEAR_GLASS = registerBlock("brown_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block RED_COLORED_CLEAR_GLASS = registerBlock("red_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block ORANGE_COLORED_CLEAR_GLASS = registerBlock("orange_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block YELLOW_COLORED_CLEAR_GLASS = registerBlock("yellow_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block LIME_COLORED_CLEAR_GLASS = registerBlock("lime_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block GREEN_COLORED_CLEAR_GLASS = registerBlock("green_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block CYAN_COLORED_CLEAR_GLASS = registerBlock("cyan_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block LIGHT_BLUE_COLORED_CLEAR_GLASS = registerBlock("light_blue_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block BLUE_COLORED_CLEAR_GLASS = registerBlock("blue_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block PURPLE_COLORED_CLEAR_GLASS = registerBlock("purple_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block MAGENTA_COLORED_CLEAR_GLASS = registerBlock("magenta_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));
    public static final Block PINK_COLORED_CLEAR_GLASS = registerBlock("pink_colored_clear_glass",
            properties -> new TransparentBlock(properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .isRedstoneConductor(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
            ));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))));
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

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {
            output.accept(CLEAR_GLASS);
            output.accept(WHITE_COLORED_CLEAR_GLASS);
            output.accept(LIGHT_GRAY_COLORED_CLEAR_GLASS);
            output.accept(GRAY_COLORED_CLEAR_GLASS);
            output.accept(BLACK_COLORED_CLEAR_GLASS);
            output.accept(BROWN_COLORED_CLEAR_GLASS);
            output.accept(RED_COLORED_CLEAR_GLASS);
            output.accept(ORANGE_COLORED_CLEAR_GLASS);
            output.accept(YELLOW_COLORED_CLEAR_GLASS);
            output.accept(LIME_COLORED_CLEAR_GLASS);
            output.accept(GREEN_COLORED_CLEAR_GLASS);
            output.accept(CYAN_COLORED_CLEAR_GLASS);
            output.accept(LIGHT_BLUE_COLORED_CLEAR_GLASS);
            output.accept(BLUE_COLORED_CLEAR_GLASS);
            output.accept(PURPLE_COLORED_CLEAR_GLASS);
            output.accept(MAGENTA_COLORED_CLEAR_GLASS);
            output.accept(PINK_COLORED_CLEAR_GLASS);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> {
            output.accept(CLEAR_GLASS);
            output.accept(WHITE_COLORED_CLEAR_GLASS);
            output.accept(LIGHT_GRAY_COLORED_CLEAR_GLASS);
            output.accept(GRAY_COLORED_CLEAR_GLASS);
            output.accept(BLACK_COLORED_CLEAR_GLASS);
            output.accept(BROWN_COLORED_CLEAR_GLASS);
            output.accept(RED_COLORED_CLEAR_GLASS);
            output.accept(ORANGE_COLORED_CLEAR_GLASS);
            output.accept(YELLOW_COLORED_CLEAR_GLASS);
            output.accept(LIME_COLORED_CLEAR_GLASS);
            output.accept(GREEN_COLORED_CLEAR_GLASS);
            output.accept(CYAN_COLORED_CLEAR_GLASS);
            output.accept(LIGHT_BLUE_COLORED_CLEAR_GLASS);
            output.accept(BLUE_COLORED_CLEAR_GLASS);
            output.accept(PURPLE_COLORED_CLEAR_GLASS);
            output.accept(MAGENTA_COLORED_CLEAR_GLASS);
            output.accept(PINK_COLORED_CLEAR_GLASS);
        });
    }
}
