package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ConnectedTexturesProvider implements DataProvider {
    public ConnectedTexturesProvider() { }

    final Path resourcesDir = Path.of("../../src/main/resources");
    final Path outputBetterGlassDir = resourcesDir.resolve("../generated/resourcepacks/connecting_textures/assets/betterglass/optifine/ctm/betterglass/");
    final Path outputVanillaDir = resourcesDir.resolve("../generated/resourcepacks/connecting_textures/assets/betterglass/optifine/ctm/minecraft/");

    Path finalBlockOutput = null;
    Path finalPaneOutput = null;

    public static final Map<String, List<int[]>> sidePixels = Map.of(
            "top", List.of(new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0}, new int[]{4, 0},
                    new int[]{5, 0}, new int[]{6, 0}, new int[]{7, 0}, new int[]{8, 0}, new int[]{9, 0},
                    new int[]{10, 0}, new int[]{11, 0}, new int[]{12, 0}, new int[]{13, 0}, new int[]{14, 0}),
            "bottom", List.of(new int[]{1, 15}, new int[]{2, 15}, new int[]{3, 15}, new int[]{4, 15},
                    new int[]{5, 15}, new int[]{6, 15}, new int[]{7, 15}, new int[]{8, 15}, new int[]{9, 15},
                    new int[]{10, 15}, new int[]{11, 15}, new int[]{12, 15}, new int[]{13, 15}, new int[]{14, 15}),
            "left", List.of(new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
                    new int[]{0, 5}, new int[]{0, 6}, new int[]{0, 7}, new int[]{0, 8}, new int[]{0, 9},
                    new int[]{0, 10}, new int[]{0, 11}, new int[]{0, 12}, new int[]{0, 13}, new int[]{0, 14}),
            "right", List.of(new int[]{15, 1}, new int[]{15, 2}, new int[]{15, 3}, new int[]{15, 4},
                    new int[]{15, 5}, new int[]{15, 6}, new int[]{15, 7}, new int[]{15, 8}, new int[]{15, 9},
                    new int[]{15, 10}, new int[]{15, 11}, new int[]{15, 12}, new int[]{15, 13}, new int[]{15, 14}),
            "top_left", List.of(new int[]{0, 0}),
            "top_right", List.of(new int[]{15, 0}),
            "bottom_left", List.of(new int[]{0, 15}),
            "bottom_right", List.of(new int[]{15, 15})
            );


    @Override
    public @NonNull CompletableFuture<?> run(@NonNull CachedOutput cache) {
        try {
            for (String blockType : ModTextureProvider.blockTypes) {
                if (!blockType.contains("chiseled")) {
                    GeneratePropertiesForPatterns(blockType);
                }
                for (String colorType : List.of("undyed", "stained", "colored")) {
                    if (colorType.equals("undyed")) {
                        String nameFormat = blockType.equals("vanilla_glass") ? "glass" : blockType;
                        String namespaceFormat = (blockType.equals("vanilla_glass") || (blockType.equals("tinted_glass"))) ? "minecraft" : "betterglass";

                        String blockProperties = """
                                method=ctm
                                matchTiles=%2$s:%1$s
                                matchBlocks=%2$s:%1$s
                                tiles=0-46
                                connect=block
                                """.formatted(nameFormat, namespaceFormat);
                        String paneProperties = """
                                method=ctm
                                matchTiles=%2$s:%1$s
                                matchBlocks=%2$s:%1$s_pane
                                tiles=0-46
                                connect=block
                                """.formatted(nameFormat, namespaceFormat)
                                .replace("matchBlocks=minecraft:tinted_glass_pane", "matchBlocks=betterglass:tinted_glass_pane"); // i swear i can code

                        Path output = blockType.equals("vanilla_glass") || blockType.equals("tinted_glass") ? outputVanillaDir : outputBetterGlassDir;
                        finalBlockOutput = output.resolve("%s/%s/block.properties".formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), colorType));
                        finalPaneOutput = output.resolve("%s/%s/pane.properties".formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), colorType));
                        Files.createDirectories(finalBlockOutput.getParent());
                        Files.createDirectories(finalPaneOutput.getParent());
                        Files.writeString(finalBlockOutput, blockProperties);
                        Files.writeString(finalPaneOutput, paneProperties);
                        continue;
                    }
                    for (String colorName : List.of("white", "light_gray", "gray", "black",
                            "brown", "red", "orange", "yellow", "lime", "green",
                            "cyan", "light_blue", "blue", "purple", "magenta", "pink")) {
                        String handledBlock = "%s_%s_%s".formatted(colorName, colorType, (blockType.equals("vanilla_glass") && colorType.equals("stained") ? "glass" : blockType));
                        String namespaceFormat = blockType.equals("vanilla_glass") && colorType.equals("stained") ? "minecraft" : "betterglass";

                        String blockProperties = """
                                method=ctm
                                matchTiles=%2$s:%1$s
                                matchBlocks=%2$s:%1$s
                                tiles=0-46
                                connect=block
                                """.formatted(handledBlock, namespaceFormat);
                        String paneProperties = """
                                method=ctm
                                matchTiles=%2$s:%1$s
                                matchBlocks=%2$s:%1$s_pane
                                tiles=0-46
                                connect=block
                                """.formatted(handledBlock, namespaceFormat);

                        if (blockType.equals("vanilla_glass")) {
                            Path output = colorType.equals("stained") ? outputVanillaDir : outputBetterGlassDir;
                            finalBlockOutput = output.resolve("glass/%s/%s/block.properties".formatted(colorType, colorName));
                            finalPaneOutput = output.resolve("glass/%s/%s/pane.properties".formatted(colorType, colorName));
                        } else {
                            finalBlockOutput = outputBetterGlassDir.resolve("%s/%s/%s/block.properties".formatted(blockType, colorType, colorName));
                            finalPaneOutput = outputBetterGlassDir.resolve("%s/%s/%s/pane.properties".formatted(blockType, colorType, colorName));
                        }
                        Files.createDirectories(finalBlockOutput.getParent());
                        Files.createDirectories(finalPaneOutput.getParent());
                        Files.writeString(finalBlockOutput, blockProperties);
                        Files.writeString(finalPaneOutput, paneProperties);
                    }
                }
            }
            return CompletableFuture.allOf();
        } catch (IOException e) {
            throw new RuntimeException("Connected Textures Properties Datagen failed at run(): ", e);
        }
    }

    private void GeneratePropertiesForPatterns(String blockType) {
        for (String motif : ModBlocks.PATTERN_MOTIFS) {
            String nameFormat = blockType.equals("vanilla_glass") ? "glass" : blockType;

            String blockProperties = """
                                method=ctm
                                matchTiles=betterglass:%1$s_patterned_%2$s
                                matchBlocks=betterglass:%1$s_patterned_%2$s
                                tiles=0-46
                                connect=block
                                """.formatted(motif, nameFormat);
            String paneProperties = """
                                method=ctm
                                matchTiles=betterglass:%1$s_patterned_%2$s
                                matchBlocks=betterglass:%1$s_patterned_%2$s_pane
                                tiles=0-46
                                connect=block
                                """.formatted(motif, nameFormat);

            try {
                Path output = outputBetterGlassDir;
                finalBlockOutput = output.resolve("%s/patterned/%s/block.properties".formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), motif));
                finalPaneOutput = output.resolve("%s/patterned/%s/pane.properties".formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), motif));
                Files.createDirectories(finalBlockOutput.getParent());
                Files.createDirectories(finalPaneOutput.getParent());
                Files.writeString(finalBlockOutput, blockProperties);
                Files.writeString(finalPaneOutput, paneProperties);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public @NonNull String getName() {
        return "Connected Textures";
    }
}
