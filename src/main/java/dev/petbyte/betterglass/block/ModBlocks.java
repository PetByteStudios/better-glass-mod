package dev.petbyte.betterglass.block;

import dev.petbyte.betterglass.BetterGlass;
import dev.petbyte.betterglass.glasscutter.GlasscutterBlock;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    private static BlockBehaviour.Properties glassPaneProperties() {
        return BlockBehaviour.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .instrument(NoteBlockInstrument.HAT)
                .noOcclusion();
    }

    public static final List<DyeColor> DYE_ORDER = List.of(
            DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK,
            DyeColor.BROWN, DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW,
            DyeColor.LIME, DyeColor.GREEN, DyeColor.CYAN, DyeColor.LIGHT_BLUE,
            DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK
    );

    private static final Map<DyeColor, MapColor> DYE_COLOR_TO_MAP_COLOR = Map.ofEntries(
            Map.entry(DyeColor.WHITE, MapColor.SNOW),
            Map.entry(DyeColor.LIGHT_GRAY, MapColor.COLOR_LIGHT_GRAY),
            Map.entry(DyeColor.GRAY, MapColor.COLOR_GRAY),
            Map.entry(DyeColor.BLACK, MapColor.COLOR_BLACK),
            Map.entry(DyeColor.BROWN, MapColor.COLOR_BROWN),
            Map.entry(DyeColor.RED, MapColor.COLOR_RED),
            Map.entry(DyeColor.ORANGE, MapColor.COLOR_ORANGE),
            Map.entry(DyeColor.YELLOW, MapColor.COLOR_YELLOW),
            Map.entry(DyeColor.LIME, MapColor.COLOR_LIGHT_GREEN),
            Map.entry(DyeColor.GREEN, MapColor.COLOR_GREEN),
            Map.entry(DyeColor.CYAN, MapColor.COLOR_CYAN),
            Map.entry(DyeColor.LIGHT_BLUE, MapColor.COLOR_LIGHT_BLUE),
            Map.entry(DyeColor.BLUE, MapColor.COLOR_BLUE),
            Map.entry(DyeColor.PURPLE, MapColor.COLOR_PURPLE),
            Map.entry(DyeColor.MAGENTA, MapColor.COLOR_MAGENTA),
            Map.entry(DyeColor.PINK, MapColor.COLOR_PINK)
    );

    public static final Block TINTED_GLASS_PANE = registerTintedGlassPane("tinted_glass_pane", MapColor.COLOR_GRAY);

    public static final Block CLEAR_GLASS = registerGlassBlock("clear_glass", MapColor.NONE);
    public static final Block SCRATCHED_GLASS = registerGlassBlock("scratched_glass", MapColor.NONE);
    public static final Block CLEAR_TINTED_GLASS = registerTintedGlassBlock("clear_tinted_glass", MapColor.COLOR_GRAY);
    public static final Block SCRATCHED_TINTED_GLASS = registerTintedGlassBlock("scratched_tinted_glass", MapColor.COLOR_GRAY);

    public static final Block CLEAR_GLASS_PANE = registerIronBarsBlock("clear_glass_pane", MapColor.NONE);
    public static final Block SCRATCHED_GLASS_PANE = registerIronBarsBlock("scratched_glass_pane", MapColor.NONE);
    public static final Block CLEAR_TINTED_GLASS_PANE = registerTintedGlassPane("clear_tinted_glass_pane", MapColor.COLOR_GRAY);
    public static final Block SCRATCHED_TINTED_GLASS_PANE = registerTintedGlassPane("scratched_tinted_glass_pane", MapColor.COLOR_GRAY);

    public static final List<Block> BETTER_GLASS_BLOCKS = new ArrayList<>(List.of(
            CLEAR_GLASS, SCRATCHED_GLASS, CLEAR_TINTED_GLASS, SCRATCHED_TINTED_GLASS
    ));

    public static final List<Block> BETTER_GLASS_PANES = new ArrayList<>(List.of(
            CLEAR_GLASS_PANE, SCRATCHED_GLASS_PANE, CLEAR_TINTED_GLASS_PANE, SCRATCHED_TINTED_GLASS_PANE
    ));

    public static final List<Block> BETTER_GLASS_ALL = new ArrayList<>();

    public static final Map<DyeColor, Block> COLORED_CLEAR_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_CLEAR_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_CLEAR_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_CLEAR_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_SCRATCHED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_SCRATCHED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_SCRATCHED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_SCRATCHED_GLASS_PANE = new LinkedHashMap<>();

    public static final Map<DyeColor, Block> COLORED_VANILLA_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_VANILLA_GLASS_PANE = new LinkedHashMap<>();


    public static final Map<DyeColor, Block> COLORED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_CLEAR_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_CLEAR_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_CLEAR_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_CLEAR_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_SCRATCHED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> COLORED_SCRATCHED_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_SCRATCHED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> STAINED_SCRATCHED_TINTED_GLASS_PANE = new LinkedHashMap<>();

    public static final List<String> CHISEL_MOTIFS = new ArrayList<>(List.of(
            "500_downloads"
    ));

    public static final List<Block> ALL_CHISELED_GLASS = new ArrayList<>();
    public static final List<Block> ALL_CHISELED_GLASS_PANE = new ArrayList<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_GLASS_PANE = new LinkedHashMap<>();
    public static final List<Block> ALL_CHISELED_CLEAR_GLASS = new ArrayList<>();
    public static final List<Block> ALL_CHISELED_CLEAR_GLASS_PANE = new ArrayList<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_CLEAR_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_CLEAR_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_CLEAR_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_CLEAR_GLASS_PANE = new LinkedHashMap<>();
    public static final List<Block> ALL_CHISELED_SCRATCHED_GLASS = new ArrayList<>();
    public static final List<Block> ALL_CHISELED_SCRATCHED_GLASS_PANE = new ArrayList<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_SCRATCHED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_SCRATCHED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_SCRATCHED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_SCRATCHED_GLASS_PANE = new LinkedHashMap<>();



    public static final List<Block> ALL_CHISELED_TINTED_GLASS = new ArrayList<>();
    public static final List<Block> ALL_CHISELED_TINTED_GLASS_PANE = new ArrayList<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final List<Block> ALL_CHISELED_CLEAR_TINTED_GLASS = new ArrayList<>();
    public static final List<Block> ALL_CHISELED_CLEAR_TINTED_GLASS_PANE = new ArrayList<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_CLEAR_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_CLEAR_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_CLEAR_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_CLEAR_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final List<Block> ALL_CHISELED_SCRATCHED_TINTED_GLASS = new ArrayList<>();
    public static final List<Block> ALL_CHISELED_SCRATCHED_TINTED_GLASS_PANE = new ArrayList<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_SCRATCHED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_COLORED_CHISELED_SCRATCHED_TINTED_GLASS_PANE = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_SCRATCHED_TINTED_GLASS = new LinkedHashMap<>();
    public static final Map<DyeColor, Block> ALL_STAINED_CHISELED_SCRATCHED_TINTED_GLASS_PANE = new LinkedHashMap<>();

    static {
        for (String motif : CHISEL_MOTIFS) {
            ALL_CHISELED_GLASS.add(registerGlassBlock("%s_chiseled_glass".formatted(motif), MapColor.NONE));
            ALL_CHISELED_GLASS_PANE.add(registerIronBarsBlock("%s_chiseled_glass_pane".formatted(motif), MapColor.NONE));
            for (DyeColor color : DYE_ORDER) {
                ALL_COLORED_CHISELED_GLASS.put(color, registerGlassBlock("%s_colored_%s_chiseled_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_COLORED_CHISELED_GLASS_PANE.put(color, registerIronBarsBlock("%s_colored_%s_chiseled_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_GLASS.put(color, registerGlassBlock("%s_stained_%s_chiseled_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_GLASS_PANE.put(color, registerIronBarsBlock("%s_stained_%s_chiseled_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
            }

            ALL_CHISELED_CLEAR_GLASS.add(registerGlassBlock("%s_chiseled_clear_glass".formatted(motif), MapColor.NONE));
            ALL_CHISELED_CLEAR_GLASS_PANE.add(registerIronBarsBlock("%s_chiseled_clear_glass_pane".formatted(motif), MapColor.NONE));
            for (DyeColor color : DYE_ORDER) {
                ALL_COLORED_CHISELED_CLEAR_GLASS.put(color, registerGlassBlock("%s_colored_%s_chiseled_clear_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_COLORED_CHISELED_CLEAR_GLASS_PANE.put(color, registerIronBarsBlock("%s_colored_%s_chiseled_clear_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_CLEAR_GLASS.put(color, registerGlassBlock("%s_stained_%s_chiseled_clear_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_CLEAR_GLASS_PANE.put(color, registerIronBarsBlock("%s_stained_%s_chiseled_clear_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
            }

            ALL_CHISELED_SCRATCHED_GLASS.add(registerGlassBlock("%s_chiseled_scratched_glass".formatted(motif), MapColor.NONE));
            ALL_CHISELED_SCRATCHED_GLASS_PANE.add(registerIronBarsBlock("%s_chiseled_scratched_glass_pane".formatted(motif), MapColor.NONE));
            for (DyeColor color : DYE_ORDER) {
                ALL_COLORED_CHISELED_SCRATCHED_GLASS.put(color, registerGlassBlock("%s_colored_%s_chiseled_scratched_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_COLORED_CHISELED_SCRATCHED_GLASS_PANE.put(color, registerIronBarsBlock("%s_colored_%s_chiseled_scratched_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_SCRATCHED_GLASS.put(color, registerGlassBlock("%s_stained_%s_chiseled_scratched_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_SCRATCHED_GLASS_PANE.put(color, registerIronBarsBlock("%s_stained_%s_chiseled_scratched_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
            }



            ALL_CHISELED_TINTED_GLASS.add(registerGlassBlock("%s_chiseled_tinted_glass".formatted(motif), MapColor.NONE));
            ALL_CHISELED_TINTED_GLASS_PANE.add(registerIronBarsBlock("%s_chiseled_tinted_glass_pane".formatted(motif), MapColor.NONE));
            for (DyeColor color : DYE_ORDER) {
                ALL_COLORED_CHISELED_TINTED_GLASS.put(color, registerGlassBlock("%s_colored_%s_chiseled_tinted_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_COLORED_CHISELED_TINTED_GLASS_PANE.put(color, registerIronBarsBlock("%s_colored_%s_chiseled_tinted_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_TINTED_GLASS.put(color, registerGlassBlock("%s_stained_%s_chiseled_tinted_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_TINTED_GLASS_PANE.put(color, registerIronBarsBlock("%s_stained_%s_chiseled_tinted_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
            }

            ALL_CHISELED_CLEAR_TINTED_GLASS.add(registerGlassBlock("%s_chiseled_clear_tinted_glass".formatted(motif), MapColor.NONE));
            ALL_CHISELED_CLEAR_TINTED_GLASS_PANE.add(registerIronBarsBlock("%s_chiseled_clear_tinted_glass_pane".formatted(motif), MapColor.NONE));
            for (DyeColor color : DYE_ORDER) {
                ALL_COLORED_CHISELED_CLEAR_TINTED_GLASS.put(color, registerGlassBlock("%s_colored_%s_chiseled_clear_tinted_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_COLORED_CHISELED_CLEAR_TINTED_GLASS_PANE.put(color, registerIronBarsBlock("%s_colored_%s_chiseled_clear_tinted_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_CLEAR_TINTED_GLASS.put(color, registerGlassBlock("%s_stained_%s_chiseled_clear_tinted_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_CLEAR_TINTED_GLASS_PANE.put(color, registerIronBarsBlock("%s_stained_%s_chiseled_clear_tinted_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
            }

            ALL_CHISELED_SCRATCHED_TINTED_GLASS.add(registerGlassBlock("%s_chiseled_scratched_tinted_glass".formatted(motif), MapColor.NONE));
            ALL_CHISELED_SCRATCHED_TINTED_GLASS_PANE.add(registerIronBarsBlock("%s_chiseled_scratched_tinted_glass_pane".formatted(motif), MapColor.NONE));
            for (DyeColor color : DYE_ORDER) {
                ALL_COLORED_CHISELED_SCRATCHED_TINTED_GLASS.put(color, registerGlassBlock("%s_colored_%s_chiseled_scratched_tinted_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_COLORED_CHISELED_SCRATCHED_TINTED_GLASS_PANE.put(color, registerIronBarsBlock("%s_colored_%s_chiseled_scratched_tinted_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_SCRATCHED_TINTED_GLASS.put(color, registerGlassBlock("%s_stained_%s_chiseled_scratched_tinted_glass".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
                ALL_STAINED_CHISELED_SCRATCHED_TINTED_GLASS_PANE.put(color, registerIronBarsBlock("%s_stained_%s_chiseled_scratched_tinted_glass_pane".formatted(color.getName(), motif), DYE_COLOR_TO_MAP_COLOR.get(color)));
            }
        }

        for (DyeColor color : DYE_ORDER) {
            COLORED_CLEAR_GLASS.put(color, registerGlassBlock(color.getName() + "_colored_clear_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_CLEAR_GLASS_PANE.put(color, registerIronBarsBlock(color.getName() + "_colored_clear_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_CLEAR_GLASS.put(color, registerGlassBlock(color.getName() + "_stained_clear_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_CLEAR_GLASS_PANE.put(color, registerIronBarsBlock(color.getName() + "_stained_clear_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_SCRATCHED_GLASS.put(color, registerGlassBlock(color.getName() + "_colored_scratched_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_SCRATCHED_GLASS_PANE.put(color, registerIronBarsBlock(color.getName() + "_colored_scratched_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_SCRATCHED_GLASS.put(color, registerGlassBlock(color.getName() + "_stained_scratched_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_SCRATCHED_GLASS_PANE.put(color, registerIronBarsBlock(color.getName() + "_stained_scratched_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));

            COLORED_VANILLA_GLASS.put(color, registerGlassBlock(color.getName() + "_colored_vanilla_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_VANILLA_GLASS_PANE.put(color, registerIronBarsBlock(color.getName() + "_colored_vanilla_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));


            COLORED_TINTED_GLASS.put(color, registerTintedGlassBlock(color.getName() + "_colored_tinted_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_TINTED_GLASS_PANE.put(color, registerTintedGlassPane(color.getName() + "_colored_tinted_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_TINTED_GLASS.put(color, registerTintedGlassBlock(color.getName() + "_stained_tinted_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_TINTED_GLASS_PANE.put(color, registerTintedGlassPane(color.getName() + "_stained_tinted_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_CLEAR_TINTED_GLASS.put(color, registerTintedGlassBlock(color.getName() + "_colored_clear_tinted_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_CLEAR_TINTED_GLASS_PANE.put(color, registerTintedGlassPane(color.getName() + "_colored_clear_tinted_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_CLEAR_TINTED_GLASS.put(color, registerTintedGlassBlock(color.getName() + "_stained_clear_tinted_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_CLEAR_TINTED_GLASS_PANE.put(color, registerTintedGlassPane(color.getName() + "_stained_clear_tinted_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_SCRATCHED_TINTED_GLASS.put(color, registerTintedGlassBlock(color.getName() + "_colored_scratched_tinted_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            COLORED_SCRATCHED_TINTED_GLASS_PANE.put(color, registerTintedGlassPane(color.getName() + "_colored_scratched_tinted_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_SCRATCHED_TINTED_GLASS.put(color, registerTintedGlassBlock(color.getName() + "_stained_scratched_tinted_glass", DYE_COLOR_TO_MAP_COLOR.get(color)));
            STAINED_SCRATCHED_TINTED_GLASS_PANE.put(color, registerTintedGlassPane(color.getName() + "_stained_scratched_tinted_glass_pane", DYE_COLOR_TO_MAP_COLOR.get(color)));
        }

        BETTER_GLASS_BLOCKS.addAll(COLORED_CLEAR_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(STAINED_CLEAR_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(COLORED_SCRATCHED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(STAINED_SCRATCHED_GLASS.values());

        BETTER_GLASS_BLOCKS.addAll(COLORED_VANILLA_GLASS.values());

        BETTER_GLASS_BLOCKS.addAll(COLORED_CLEAR_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(STAINED_CLEAR_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(COLORED_SCRATCHED_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(STAINED_SCRATCHED_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(COLORED_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(STAINED_TINTED_GLASS.values());


        BETTER_GLASS_PANES.addAll(COLORED_CLEAR_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(STAINED_CLEAR_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(COLORED_SCRATCHED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(STAINED_SCRATCHED_GLASS_PANE.values());

        BETTER_GLASS_PANES.addAll(COLORED_VANILLA_GLASS_PANE.values());

        BETTER_GLASS_PANES.addAll(COLORED_CLEAR_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(STAINED_CLEAR_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(COLORED_SCRATCHED_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(STAINED_SCRATCHED_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(COLORED_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(STAINED_TINTED_GLASS_PANE.values());


        BETTER_GLASS_BLOCKS.addAll(ALL_CHISELED_GLASS);
        BETTER_GLASS_BLOCKS.addAll(ALL_COLORED_CHISELED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_STAINED_CHISELED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_CHISELED_CLEAR_GLASS);
        BETTER_GLASS_BLOCKS.addAll(ALL_COLORED_CHISELED_CLEAR_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_STAINED_CHISELED_CLEAR_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_CHISELED_SCRATCHED_GLASS);
        BETTER_GLASS_BLOCKS.addAll(ALL_COLORED_CHISELED_SCRATCHED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_STAINED_CHISELED_SCRATCHED_GLASS.values());

        BETTER_GLASS_PANES.addAll(ALL_CHISELED_GLASS_PANE);
        BETTER_GLASS_PANES.addAll(ALL_COLORED_CHISELED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_STAINED_CHISELED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_CHISELED_CLEAR_GLASS_PANE);
        BETTER_GLASS_PANES.addAll(ALL_COLORED_CHISELED_CLEAR_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_STAINED_CHISELED_CLEAR_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_CHISELED_SCRATCHED_GLASS_PANE);
        BETTER_GLASS_PANES.addAll(ALL_COLORED_CHISELED_SCRATCHED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_STAINED_CHISELED_SCRATCHED_GLASS_PANE.values());


        BETTER_GLASS_BLOCKS.addAll(ALL_CHISELED_TINTED_GLASS);
        BETTER_GLASS_BLOCKS.addAll(ALL_COLORED_CHISELED_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_STAINED_CHISELED_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_CHISELED_CLEAR_TINTED_GLASS);
        BETTER_GLASS_BLOCKS.addAll(ALL_COLORED_CHISELED_CLEAR_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_STAINED_CHISELED_CLEAR_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_CHISELED_SCRATCHED_TINTED_GLASS);
        BETTER_GLASS_BLOCKS.addAll(ALL_COLORED_CHISELED_SCRATCHED_TINTED_GLASS.values());
        BETTER_GLASS_BLOCKS.addAll(ALL_STAINED_CHISELED_SCRATCHED_TINTED_GLASS.values());

        BETTER_GLASS_PANES.addAll(ALL_CHISELED_TINTED_GLASS_PANE);
        BETTER_GLASS_PANES.addAll(ALL_COLORED_CHISELED_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_STAINED_CHISELED_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_CHISELED_CLEAR_TINTED_GLASS_PANE);
        BETTER_GLASS_PANES.addAll(ALL_COLORED_CHISELED_CLEAR_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_STAINED_CHISELED_CLEAR_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_CHISELED_SCRATCHED_TINTED_GLASS_PANE);
        BETTER_GLASS_PANES.addAll(ALL_COLORED_CHISELED_SCRATCHED_TINTED_GLASS_PANE.values());
        BETTER_GLASS_PANES.addAll(ALL_STAINED_CHISELED_SCRATCHED_TINTED_GLASS_PANE.values());


        BETTER_GLASS_PANES.add(TINTED_GLASS_PANE); // dumb hack but idc

        BETTER_GLASS_ALL.addAll(BETTER_GLASS_BLOCKS);
        BETTER_GLASS_ALL.addAll(BETTER_GLASS_PANES);
    }

    public static final Block GLASSCUTTER = registerGlasscutter();

    public static Block registerGlasscutter() {
        Block toRegister = new GlasscutterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONECUTTER)
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "glasscutter"))));
        registerBlockItem("glasscutter", toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "glasscutter"), toRegister);
    }

    private static Block registerGlassBlock(String name, MapColor mapColor) {
        Block toRegister = new TransparentBlock(glassProperties().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))).mapColor(mapColor));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name), toRegister);
    }

    private static Block registerIronBarsBlock(String name, MapColor mapColor) {
        Block toRegister = new IronBarsBlock(glassPaneProperties().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))).mapColor(mapColor));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name), toRegister);
    }

    private static Block registerTintedGlassBlock(String name, MapColor mapColor) {
        Block toRegister = new TintedGlassBlock(glassProperties().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))).mapColor(mapColor));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name), toRegister);
    }

    private static Block registerTintedGlassPane(String name, MapColor mapColor) {
        Block toRegister = new TintedGlassPaneBlock(glassPaneProperties().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, name))).mapColor(mapColor));
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

        for (Block block : BETTER_GLASS_ALL) {
            CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> output.accept(block));
        }

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(output -> output.insertAfter(Items.STONECUTTER, GLASSCUTTER));
    }
}