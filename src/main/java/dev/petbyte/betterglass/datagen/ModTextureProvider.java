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

    final Path resourcesDir = Path.of("../../src/main/resources");
    final Path templatesDir = resourcesDir.resolve("assets/betterglass/templates");
    final Path templateJson = templatesDir.resolve("palettes/template.json");

    @Override
    public @NonNull CompletableFuture<?> run(@NonNull CachedOutput cache) {
        try {
            for (String colorName : List.of("white", "light_gray", "gray", "black",
                    "brown", "red", "orange", "yellow", "lime", "green",
                    "cyan", "light_blue", "blue", "purple", "magenta", "pink", "undyed")) {
                Path paletteJson = templatesDir.resolve("palettes/%s.json".formatted(colorName));
                LinkedHashMap<Integer, Integer> palette = loadPalette(templateJson, paletteJson);

                for (String blockType : List.of("clear_glass", "scratched_glass", "vanilla_glass", "clear_tinted_glass", "scratched_tinted_glass", "tinted_glass")) {
                    // BLOCKS
                    BufferedImage template = ImageIO.read(templatesDir.resolve("blocks/%s.png".formatted(blockType)).toFile());
                    BufferedImage result = applyPalette(template, palette);
                    Path outputDir = resourcesDir.resolve("../generated/resourcepacks/base_assets/assets/%s/textures/block".formatted((blockType.equals("vanilla_glass") || blockType.equals("tinted_glass")) && colorName.equals("undyed") ? "minecraft" : "betterglass"));
                    String outputName = (colorName.equals("undyed") ? "%s.png".formatted(blockType.equals("vanilla_glass") ? "glass" : blockType) : "%s_colored_%s.png".formatted(colorName, blockType));
                    if (blockType.contains("tinted_glass")) {
                        Graphics2D g2d = result.createGraphics();
                        g2d.setColor(new Color(0, 0, 0, 127));
                        g2d.fillRect(0, 0, result.getWidth(), result.getHeight());
                        g2d.dispose();
                        saveTexture(result, outputDir.resolve(outputName));
                    } else {
                        saveTexture(result, outputDir.resolve(outputName));
                    }

                    // PANE TOPS
                    BufferedImage paneTopTemplate = ImageIO.read(templatesDir.resolve("blocks/glass_pane_top.png").toFile());
                    BufferedImage paneTopResult = applyPalette(paneTopTemplate, palette);
                    outputName = colorName.equals("undyed") ? "%s_pane_top.png".formatted(blockType.equals("vanilla_glass") ? "glass" : blockType) : "%s_colored_%s_pane_top.png".formatted(colorName, blockType);
                    if (blockType.contains("tinted_glass")) {
                        Graphics2D g2d = paneTopResult.createGraphics();
                        g2d.setColor(new Color(0, 0, 0, 127));
                        g2d.fillRect(0, 0, paneTopResult.getWidth(), paneTopResult.getHeight());
                        g2d.dispose();
                        if (blockType.equals("tinted_glass") && colorName.equals("undyed")) { outputDir = outputDir.resolve("../../../betterglass/textures/block"); }
                        saveTexture(paneTopResult, outputDir.resolve(outputName));
                    } else {
                        saveTexture(paneTopResult, outputDir.resolve(outputName));
                    }

                    if (colorName.equals("undyed")) { continue; }

                    // BLOCKS
                    outputName = "%s_stained_%s.png".formatted(colorName, blockType.equals("vanilla_glass") ? "glass" : blockType);
                    if (blockType.equals("vanilla_glass")) { outputDir = outputDir.resolve("../../../minecraft/textures/block"); }
                    result = applyStain(template, palette);
                    if (blockType.contains("tinted_glass")) {
                        Graphics2D g2d = result.createGraphics();
                        g2d.setColor(new Color(0, 0, 0, 127));
                        g2d.fillRect(0, 0, result.getWidth(), result.getHeight());
                        g2d.dispose();
                        saveTexture(result, outputDir.resolve(outputName));
                    } else {
                        saveTexture(result, outputDir.resolve(outputName));
                    }

                    // PANE TOPS
                    generateStainedGlassPaneTops(colorName, blockType, palette);
                }
            }
            generateConnectingTextures();

            return CompletableFuture.allOf();
        }
        catch (IOException e) { throw new RuntimeException("Texture datagen failed at run(): ", e); }
    }

    private void generateStainedGlassPaneTops(String colorName, String blockName, LinkedHashMap<Integer, Integer> palette) {
        try {
            BufferedImage template = ImageIO.read(templatesDir.resolve("blocks/glass_pane_top.png").toFile());
            Path outputDir = resourcesDir.resolve("../generated/resourcepacks/base_assets/assets/%s/textures/block".formatted(blockName.equals("vanilla_glass") ? "minecraft" : "betterglass"));

            BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = result.createGraphics();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.62890625f));
            g2d.drawImage(applyPalette(template, palette), 0, 0, null);
            g2d.dispose();

            String outputName = "%s_stained_%s_pane_top.png".formatted(colorName, blockName.equals("vanilla_glass") ? "glass" : blockName);
            if (blockName.contains("tinted_glass")) {
                Graphics2D g2d2 = result.createGraphics();
                g2d2.setColor(new Color(0, 0, 0, 127));
                g2d2.fillRect(0, 0, result.getWidth(), result.getHeight());
                g2d2.dispose();
                saveTexture(result, outputDir.resolve(outputName));
            } else {
                saveTexture(result, outputDir.resolve(outputName));
            }
        }
        catch (IOException e) { throw new RuntimeException("Texture datagen failed at GenerateStainedGlassPaneTops(): ", e); }
    }

    private void generateConnectingTextures() {
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

                for (String blockType : List.of("clear_glass", "scratched_glass", "vanilla_glass", "clear_tinted_glass", "scratched_tinted_glass", "tinted_glass")) {
                    BufferedImage template = ImageIO.read(templatesDir.resolve("blocks/%s.png".formatted(blockType)).toFile());

                    Path ctmDir = resourcesDir.resolve("../generated/resourcepacks/connecting_textures/assets/betterglass/optifine/ctm/betterglass/%s".formatted(blockType.equals("vanilla_glass") ? "glass" : blockType));
                    // Colored
                    generateCTMTiles(template, palette, false, connections, ctmDir.resolve(colorName.equals("undyed") ? "undyed" : "colored/%s".formatted(colorName)), (blockType.equals("vanilla_glass") || blockType.equals("tinted_glass")), blockType.contains("tinted_glass"));

                    // Stained (skip undyed)
                    if (!colorName.equals("undyed")) {
                        generateCTMTiles(template, palette, true, connections, ctmDir.resolve("stained/%s".formatted(colorName)), blockType.equals("vanilla_glass"), blockType.contains("tinted_glass"));
                    }
                }
            }
        }
        catch (IOException e) { throw new RuntimeException("Texture datagen failed at GenerateConnectingTextures(): ", e); }
    }

    private void generateCTMTiles(BufferedImage base, LinkedHashMap<Integer, Integer> palette, boolean stained,
                                  @NonNull Map<String, List<String>> connections, Path outputDir, boolean vanilla, boolean tinted) {
        try {
            for (Map.Entry<String, List<String>> entry : connections.entrySet()) {
                int tileIndex = Integer.parseInt(entry.getKey());
                List<String> sides = entry.getValue();

                // Start with a copy of the base template
                BufferedImage tile = stained ? applyStain(base, palette) : applyPalette(base, palette);

                // Remove pixels for each connected side
                for (String side : sides) {
                    List<int[]> pixels = ConnectedTexturesProvider.sidePixels.get(side);
                    if (pixels == null) continue;
                    for (int[] px : pixels) {
                        if (!stained) tile.setRGB(px[0], px[1], 0x00000000);
                        else tile.setRGB(px[0], px[1], Integer.parseUnsignedInt("40%s".formatted(Integer.toHexString(palette.sequencedValues().getLast()).substring(2)),16));
                    }
                }

                if ((stained || outputDir.endsWith("undyed")) && vanilla) {
                    outputDir = Paths.get(outputDir.toString().replace("ctm\\betterglass", "ctm\\minecraft"));
                    outputDir = Paths.get(outputDir.toString().replace("ctm/betterglass", "ctm/minecraft"));
                }

                if (tinted) {
                    Graphics2D g2d2 = tile.createGraphics();
                    g2d2.setColor(new Color(0, 0, 0, 127));
                    g2d2.fillRect(0, 0, tile.getWidth(), tile.getHeight());
                    g2d2.dispose();
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
