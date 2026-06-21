package dev.petbyte.betterglass.datagen;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        for (Block block : ModBlocks.BETTER_GLASS_ALL) {
            if (ModBlocks.BETTER_GLASS_PATTERNED_ALL.contains(block)) {
                continue;
            }
            String blockID = BuiltInRegistries.BLOCK.getKey(block).toString().replaceAll("(minecraft|betterglass):|vanilla_", "");
            String translation = capitalizeWords(blockID);
            translationBuilder.add(block.getDescriptionId(), translation);
        }

        for (Block block : ModBlocks.BETTER_GLASS_PATTERNED_ALL) {
            String blockID = BuiltInRegistries.BLOCK.getKey(block).toString().replace("betterglass:", "");
            String[] parts = blockID.split("_patterned_", 2);
            String patternName = capitalizeWords(parts[0]);
            String rest = capitalizeWords(parts[1]);
            String translation = "Patterned %s (%s)".formatted(rest, patternName);
            translationBuilder.add(block.getDescriptionId(), translation);
        }

        for (ModTags.TagPair tagPair : ModTags.ALL_TAG_PAIRS) {
            String blockTagID = tagPair.block().getTranslationKey();
            String itemTagID = tagPair.item().getTranslationKey();
            String translation = capitalizeWords(blockTagID.replaceAll("(tag.(block|item).betterglass.)", ""))
                    .replace("All", "(All)");

            translationBuilder.add(blockTagID, translation);
            translationBuilder.add(itemTagID, translation);
        }

        translationBuilder.add("block.betterglass.glasscutter", "Glasscutter (Temp. W.I.P.)");
        translationBuilder.add("container.betterglass.glasscutter", "Glasscutter");
        translationBuilder.add("container.betterglass.glasscutter.easter_egg.spacing","   ");
        translationBuilder.add("container.betterglass.glasscutter.easter_egg.text", "(aka. fancy stonecutter. soz)");
        translationBuilder.add("creativemodetab.betterglass.betterglass", "Better Glass");
        translationBuilder.add("creativemodetab.betterglass.betterglass_patterned", "Better Glass (Patterned)");
        translationBuilder.add("creativemodetab.betterglass.betterglass_chiseled", "Better Glass (Chiseled)");
        translationBuilder.add("resourcePack.betterglass.connecting_textures.name", "Better Glass: Connecting Textures");
        translationBuilder.add("resourcePack.betterglass.connecting_textures.description", "Req. Continuity. Glass Pane Culling Fix compatible");
        translationBuilder.add("resourcePack.betterglass.base_assets.name", "Better Glass: Base Assets");
        translationBuilder.add("resourcePack.betterglass.base_assets.description", "The base textures for Better Glass");
    }

    private static String capitalizeWords(String id) {
        return Arrays.stream(id.split("_"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
