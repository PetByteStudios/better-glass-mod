package dev.petbyte.betterglass.datagen;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import org.jspecify.annotations.NonNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModTextureProvider implements DataProvider {
    public ModTextureProvider() { }

    Path resourcesDir = Path.of("../../src/main/resources");
    Path templatesDir = resourcesDir.resolve("assets/betterglass/templates");
    Path templateJson = templatesDir.resolve("palettes/template.json");

    @Override
    public @NonNull CompletableFuture<?> run(@NonNull CachedOutput cache) {
        try {
            for (String colorName : List.of("white", "light_gray", "gray", "black",
                    "brown", "red", "orange", "yellow", "lime", "green",
                    "cyan", "light_blue", "blue", "purple", "magenta", "pink", "undyed")) {
                Path paletteJson = templatesDir.resolve("palettes/%s.json".formatted(colorName));
                LinkedHashMap<Integer, Integer> palette = loadPalette(templateJson, paletteJson);

                for (String blockType : List.of("clear_glass", "scratched_glass", "vanilla_glass")) {
                    BufferedImage template = ImageIO.read(templatesDir.resolve("blocks/%s.png".formatted(blockType)).toFile());
                    BufferedImage result = applyPalette(template, palette);
                    Path outputDir = resourcesDir.resolve("../generated/assets/%s/textures/block".formatted(blockType.equals("vanilla_glass") && colorName.equals("undyed") ? "minecraft" : "betterglass"));
                    saveTexture(result, outputDir.resolve((colorName.equals("undyed") ? "%s.png".formatted(blockType.equals("vanilla_glass") ? "glass" : blockType) : "%s_colored_%s.png".formatted(colorName, blockType))));

                    if (colorName.equals("undyed")) { continue; }

                    result = applyStain(template, palette);
                    if (blockType.equals("vanilla_glass")) { outputDir = outputDir.resolve("../../../minecraft/textures/block"); }
                    saveTexture(result, outputDir.resolve("%s_stained_%s.png".formatted(colorName, blockType.equals("vanilla_glass") ? "glass" : blockType)));
                }

                GenerateStainedGlassPaneTops(colorName, palette);
            }
            GenerateConnectingTextures();
            return CompletableFuture.allOf();
        }
        catch (IOException e) { throw new RuntimeException("Texture datagen failed at run(): ", e); }
    }

    private void GenerateStainedGlassPaneTops(String colorName, LinkedHashMap<Integer, Integer> palette) {
        try {
            BufferedImage template = ImageIO.read(templatesDir.resolve("blocks/glass_pane_top.png").toFile());

            Path outputDir = resourcesDir.resolve("../generated/assets/minecraft/textures/block");
            if (colorName.equals("undyed")) {
                BufferedImage result = applyPalette(template, palette);
                saveTexture(result, outputDir.resolve("glass_pane_top.png"));
            } else {
                BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = result.createGraphics();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2d.drawImage(applyPalette(template, palette), 0, 0, null);
                saveTexture(result, outputDir.resolve(("%s_stained_glass_pane_top.png".formatted(colorName))));
            }
        }
        catch (IOException e) { throw new RuntimeException("Texture datagen failed at GenerateStainedGlassPaneTops(): ", e); }
    }

    private void GenerateConnectingTextures() {
        try {
            // Load connections JSON once
            Type mapType = new TypeToken<Map<String, List<String>>>() {
            }.getType();
            Map<String, List<String>> connections = new Gson().fromJson(
                    Files.readString(templatesDir.resolve("connections.json")), mapType
            );

             for (String colorName : List.of("white", "light_gray", "gray", "black",
                    "brown", "red", "orange", "yellow", "lime", "green",
                    "cyan", "light_blue", "blue", "purple", "magenta", "pink", "undyed")) {
                Path paletteJson = templatesDir.resolve("palettes/%s.json".formatted(colorName));
                LinkedHashMap<Integer, Integer> palette = loadPalette(templateJson, paletteJson);

                for (String blockType : List.of("clear_glass", "scratched_glass", "vanilla_glass")) {
                    BufferedImage template = ImageIO.read(templatesDir.resolve("blocks/%s.png".formatted(blockType)).toFile());

                    Path ctmDir = resourcesDir.resolve("../generated/assets/betterglass/optifine/ctm/betterglass/%s".formatted(blockType.equals("vanilla_glass") ? "glass" : blockType));
                    // Colored
                    generateCTMTiles(template, palette, false, ConnectedTexturesProvider.sidePixels, connections, ctmDir.resolve(colorName.equals("undyed") ? "undyed" : "colored/%s".formatted(colorName)), blockType.equals("vanilla_glass"));

                    // Stained (skip undyed)
                    if (!colorName.equals("undyed")) {
                        generateCTMTiles(template, palette, true, ConnectedTexturesProvider.sidePixels, connections, ctmDir.resolve("stained/%s".formatted(colorName)), blockType.equals("vanilla_glass"));
                    }
                }
            }
        }
        catch (IOException e) { throw new RuntimeException("Texture datagen failed at GenerateConnectingTextures(): ", e); }
    }

    private void generateCTMTiles(BufferedImage base, LinkedHashMap<Integer, Integer> palette, boolean stained,
                                  Map<String, List<int[]>> sidePixels, Map<String, List<String>> connections, Path outputDir, boolean vanilla) {
        try {
            for (Map.Entry<String, List<String>> entry : connections.entrySet()) {
                int tileIndex = Integer.parseInt(entry.getKey());
                List<String> sides = entry.getValue();

                // Start with a copy of the base template
                BufferedImage tile = stained ? applyStain(base, palette) : applyPalette(base, palette);

                // Remove pixels for each connected side
                for (String side : sides) {
                    List<int[]> pixels = sidePixels.get(side);
                    if (pixels == null) continue;
                    for (int[] px : pixels) {
                        tile.setRGB(px[0], px[1], 0x00000000); // fully transparent
                    }
                }

                if ((stained || outputDir.endsWith("undyed")) && vanilla) {
                    outputDir = Paths.get(outputDir.toString().replace("ctm\\betterglass", "ctm\\minecraft"));
                    outputDir = Paths.get(outputDir.toString().replace("ctm/betterglass", "ctm/minecraft"));
                }
                saveTexture(tile, outputDir.resolve("%d.png".formatted(tileIndex)));
            }
        }
        catch (IOException e) { throw new RuntimeException("Texture datagen failed at generateCTMTiles(): ", e); }
    }

    private BufferedImage applyPalette(BufferedImage template, Map<Integer, Integer> paletteMap) {
        BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < template.getWidth(); x++) {
            for (int y = 0; y < template.getHeight(); y++) {
                int pixel = template.getRGB(x, y);
                result.setRGB(x, y, paletteMap.getOrDefault(pixel, pixel));
            }
        }
        return result;
    }

    private BufferedImage applyStain(BufferedImage template, LinkedHashMap<Integer, Integer> paletteMap) {
        String lastPaletteColor = Integer.toHexString(paletteMap.sequencedValues().getLast());
        BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = result.createGraphics();
        g2d.setColor(new Color(Integer.parseUnsignedInt("40%s".formatted(lastPaletteColor.substring(2)),16), true)); // color is the last palette color at 40₁₆ alpha
        g2d.fillRect(0, 0, result.getWidth(), result.getHeight());
        BufferedImage stainedForeground = applyPalette(template, paletteMap);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // set drawmode to 50% alpha (?)
        g2d.drawImage(stainedForeground, 0, 0, null); // add foreground
        g2d.dispose();
        return result;
    }

    private LinkedHashMap<Integer, Integer> loadPalette(Path templateJson, Path paletteJson) throws IOException {
        Gson gson = new Gson();

        String[] templateColors = gson.fromJson(Files.readString(templateJson), String[].class);
        String[] paletteColors = gson.fromJson(Files.readString(paletteJson), String[].class);

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < templateColors.length; i++) {
            int from = (int) Long.parseLong("FF" + templateColors[i], 16); // ARGB, fully opaque
            int to = (int) Long.parseLong("FF" + paletteColors[i], 16);
            map.put(from, to);
        }
        return map;
    }

    private void saveTexture(BufferedImage image, Path outputPath) throws IOException {
        Files.createDirectories(outputPath.getParent());
        ImageIO.write(image, "png", outputPath.toFile());
    }

    @Override
    public @NonNull String getName() {
        return "Textures";
    }
}
