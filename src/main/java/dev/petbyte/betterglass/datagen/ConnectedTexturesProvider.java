package dev.petbyte.betterglass.datagen;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ConnectedTexturesProvider implements DataProvider {
    public ConnectedTexturesProvider() { }

    Path resourcesDir = Path.of("../../src/main/resources");
    Path connectionsJson = resourcesDir.resolve("assets/betterglass/templates/connections.json");
    Path outputBetterGlassDir = resourcesDir.resolve("../generated/assets/betterglass/optifine/ctm/betterglass/");
    Path outputVanillaDir = resourcesDir.resolve("../generated/assets/betterglass/optifine/ctm/minecraft/");

    Path finalOutput = null;

    @Override
    public @NonNull CompletableFuture<?> run(@NonNull CachedOutput cache) {
        try {
            for (String blockType : List.of("scratched_glass", "clear_glass", "vanilla_glass")) {
                for (String colorType : List.of("undyed", "stained", "colored")) {
                    if (colorType.equals("undyed")) {
                        String blockProperties = """
                                method=ctm
                                matchTiles=%1$s
                                matchBlocks=%1$s
                                tiles=0-46
                                connect=block
                                resourceCondition=%2$s:textures/block/%1$s.png
                                """.formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), (blockType.equals("vanilla_glass") ? "minecraft" : "betterglass"));

                        finalOutput = (blockType.equals("vanilla_glass") ? outputVanillaDir : outputBetterGlassDir).resolve("%s/%s/block.properties".formatted((blockType.equals("vanilla_glass") ? "glass" : blockType), colorType));
                        Files.createDirectories(finalOutput.getParent());
                        Files.writeString(finalOutput, blockProperties);
                        continue;
                    }
                    for (String colorName : List.of("white", "light_gray", "gray", "black",
                            "brown", "red", "orange", "yellow", "lime", "green",
                            "cyan", "light_blue", "blue", "purple", "magenta", "pink")) {
                        String handledBlock = "%s_%s_%s".formatted(colorName, colorType, (blockType.equals("vanilla_glass") ? "glass" : blockType));

                        String blockProperties = """
                                method=ctm
                                matchTiles=%1$s
                                matchBlocks=%1$s
                                tiles=0-46
                                connect=block
                                resourceCondition=%2$s:textures/block/%1$s.png
                                """.formatted(handledBlock, (blockType.equals("vanilla_glass") && colorType.equals("stained") ? "minecraft" : "betterglass"));

                        if (blockType.equals("vanilla_glass")) {
                            finalOutput = (colorType.equals("stained") ? outputVanillaDir : outputBetterGlassDir).resolve("glass/%s/%s/block.properties".formatted(colorType, colorName));
                        } else {
                            finalOutput = outputBetterGlassDir.resolve("%s/%s/%s/block.properties".formatted(blockType, colorType, colorName));
                        }
                        Files.createDirectories(finalOutput.getParent());
                        Files.writeString(finalOutput, blockProperties);
                    }
                }
            }
            return CompletableFuture.allOf();
        } catch (IOException e) {
            throw new RuntimeException("Connected Textures Datagen failed at run(): ", e);
        }
    }

    @Override
    public @NonNull String getName() {
        return "BetterGlass ConnectedTextures";
    }
}
