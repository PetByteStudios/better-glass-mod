package dev.petbyte.betterglass.datagen;

import com.google.gson.Gson;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import org.jspecify.annotations.NonNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

                GenerateStainedGlassPaneTops(colorName, palette);

                GenerateColoredModdedGlass(colorName, palette);
                GenerateColoredVanillaGlass(colorName, palette);
                if (colorName.equals("undyed")) { continue; } // No need to generate a Stained variant of Undyed
                GenerateStainedModdedGlass(colorName, palette);
                GenerateStainedVanillaGlass(colorName, palette);
            }
            return CompletableFuture.allOf();
        } catch (IOException e) {
            throw new RuntimeException("Texture datagen failed at run(): ", e);
        }
    }

    private void GenerateColoredModdedGlass(String colorName, LinkedHashMap<Integer, Integer> palette) {
        try {
            for (String blockType : List.of("clear_glass", "scratched_glass")) {
                BufferedImage template = ImageIO.read(
                        templatesDir.resolve("blocks/%s.png".formatted(blockType)).toFile()
                );
                BufferedImage result = applyPalette(template, palette);
                Path outputDir = resourcesDir.resolve("../generated/assets/betterglass/textures/block");
                saveTexture(result, outputDir.resolve((colorName.equals("undyed") ? "%s.png".formatted(blockType) : "%s_colored_%s.png".formatted(colorName, blockType))));
            }
        } catch (IOException e) {
            throw new RuntimeException("Texture datagen failed at GenerateColoredModdedGlass(): ", e);
        }
    }

    private void GenerateStainedModdedGlass(String colorName, LinkedHashMap<Integer, Integer> palette) {
        try {
            for (String blockType : List.of("clear_glass", "scratched_glass")) {
                BufferedImage template = ImageIO.read(
                        templatesDir.resolve("blocks/%s.png".formatted(blockType)).toFile()
                );

                String lastPaletteColor = Integer.toHexString(palette.sequencedValues().getLast());
                BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = result.createGraphics();
                g2d.setColor(new Color(Integer.parseUnsignedInt("40%s".formatted(lastPaletteColor.substring(2)),16), true)); // color is the last palette color at 40₁₆ alpha
                g2d.fillRect(0, 0, result.getWidth(), result.getHeight());
                BufferedImage stainedForeground = applyPalette(template, palette);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // set drawmode to 50% alpha (?)
                g2d.drawImage(stainedForeground, 0, 0, null); // add foreground
                g2d.dispose();
                Path outputDir = resourcesDir.resolve("../generated/assets/betterglass/textures/block");
                saveTexture(result, outputDir.resolve(("%s_stained_%s.png".formatted(colorName, blockType))));
            }
        } catch (IOException e) {
            throw new RuntimeException("Texture datagen failed at GenerateColoredModdedGlass(): ", e);
        }
    }

    private void GenerateColoredVanillaGlass(String colorName, LinkedHashMap<Integer, Integer> palette) {
        try {
            BufferedImage template = ImageIO.read(
                    templatesDir.resolve("blocks/vanilla_glass.png").toFile()
            );
            BufferedImage result = applyPalette(template, palette);
            Path outputDir = resourcesDir.resolve("../generated/assets/betterglass/textures/block");
            if (colorName.equals("undyed")) {
                outputDir = outputDir.resolve("../../../minecraft/textures/block");
                saveTexture(result, outputDir.resolve("glass.png"));
            } else {
                saveTexture(result, outputDir.resolve(("%s_colored_vanilla_glass.png".formatted(colorName))));
            }
        } catch (IOException e) {
            throw new RuntimeException("Texture datagen failed at GenerateColoredVanillaGlass(): ", e);
        }
    }

    private void GenerateStainedVanillaGlass(String colorName, LinkedHashMap<Integer, Integer> palette) {
        try {
            BufferedImage template = ImageIO.read(
                    templatesDir.resolve("blocks/vanilla_glass.png").toFile()
            );

            String lastPaletteColor = Integer.toHexString(palette.sequencedValues().getLast());
            BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = result.createGraphics();
            g2d.setColor(new Color(Integer.parseUnsignedInt("40%s".formatted(lastPaletteColor.substring(2)),16), true)); // color is the last palette color at 40₁₆ alpha
            g2d.fillRect(0, 0, result.getWidth(), result.getHeight());
            BufferedImage stainedForeground = applyPalette(template, palette);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // set drawmode to 50% alpha (?)
            g2d.drawImage(stainedForeground, 0, 0, null); // add foreground
            g2d.dispose();
            Path outputDir = resourcesDir.resolve("../generated/assets/minecraft/textures/block");
            saveTexture(result, outputDir.resolve("%s_stained_glass.png".formatted(colorName)));
        } catch (IOException e) {
            throw new RuntimeException("Texture datagen failed at GenerateStainedVanillaGlass(): ", e);
        }
    }

    private void GenerateStainedGlassPaneTops(String colorName, LinkedHashMap<Integer, Integer> palette) {
        try {
            BufferedImage template = ImageIO.read(
                    templatesDir.resolve("blocks/glass_pane_top.png").toFile()
            );

            Path outputDir = resourcesDir.resolve("../generated/assets/minecraft/textures/block");
            if (colorName.equals("undyed")) {
                BufferedImage result = applyPalette(template, palette);
                saveTexture(result, outputDir.resolve("glass_pane_top.png"));
            } else {
                String lastPaletteColor = Integer.toHexString(palette.sequencedValues().getLast());
                BufferedImage result = new BufferedImage(template.getWidth(), template.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = result.createGraphics();
                g2d.setColor(new Color(Integer.parseUnsignedInt("40%s".formatted(lastPaletteColor.substring(2)),16), true)); // color is the last palette color at 40₁₆ alpha
                g2d.fillRect(0, 0, result.getWidth(), result.getHeight());
                BufferedImage stainedForeground = applyPalette(template, palette);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // set drawmode to 50% alpha (?)
                g2d.drawImage(stainedForeground, 0, 0, null); // add foreground
                g2d.dispose();
                saveTexture(result, outputDir.resolve(("%s_stained_glass_pane_top.png".formatted(colorName))));
            }
        } catch (IOException e) {
            throw new RuntimeException("Texture datagen failed at GenerateStainedGlassPaneTops(): ", e);
        }
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
