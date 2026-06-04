package dev.petbyte.betterglass.datagen;

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

    Path resourcesDir = Path.of("../../src/main/resources");
    Path outputBetterGlassDir = resourcesDir.resolve("../generated/resourcepacks/connecting_textures/assets/betterglass/optifine/ctm/betterglass/");
    Path outputVanillaDir = resourcesDir.resolve("../generated/resourcepacks/connecting_textures/assets/betterglass/optifine/ctm/minecraft/");

    Path finalBlockOutput = null;
    Path finalPaneOutput = null;

    public static Map<String, List<int[]>> sidePixels = Map.of(
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
            for (String blockType : List.of("clear_glass", "scratched_glass", "vanilla_glass", "clear_tinted_glass", "scratched_tinted_glass", "tinted_glass")) {
                for (String colorType : List.of("undyed", "stained", "colored")) {
                    if (colorType.equals("undyed")) {
                        String nameFormat = blockType.equals("vanilla_glass") ? "glass" : blockType;
                        String namespaceFormat = (blockType.equals("vanilla_glass") || blockType.equals("tinted_glass")) ? "minecraft" : "betterglass";

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
                                """.formatted(nameFormat, namespaceFormat);

                        finalBlockOutput = ((blockType.equals("vanilla_glass") || blockType.equals("tinted_glass")) ? outputVanillaDir : outputBetterGlassDir).resolve("%s/%s/block.properties".formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), colorType));
                        finalPaneOutput = ((blockType.equals("vanilla_glass") || blockType.equals("tinted_glass")) ? outputVanillaDir : outputBetterGlassDir).resolve("%s/%s/pane.properties".formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), colorType));
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
                            finalBlockOutput = (colorType.equals("stained") ? outputVanillaDir : outputBetterGlassDir).resolve("glass/%s/%s/block.properties".formatted(colorType, colorName));
                            finalPaneOutput = (colorType.equals("stained") ? outputVanillaDir : outputBetterGlassDir).resolve("glass/%s/%s/pane.properties".formatted(colorType, colorName));
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

    @Override
    public @NonNull String getName() {
        return "ConnectedTextures";
    }
}
