package dev.petbyte.betterglass.recipe;

import dev.petbyte.betterglass.BetterGlass;
import dev.petbyte.betterglass.recipe.custom.GlassCuttingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;

public class ModRecipes {
    public static final RecipeType<GlassCuttingRecipe> GLASSCUTTING =
            new RecipeType<>() {
                @Override public String toString() { return "glasscutting"; }
            };

    public static final RecipeSerializer<GlassCuttingRecipe> GLASSCUTTING_SERIALIZER =
            new RecipeSerializer<>(
                    StonecutterRecipe.simpleMapCodec(GlassCuttingRecipe::new),
                    StonecutterRecipe.simpleStreamCodec(GlassCuttingRecipe::new)
            );

    public static void registerRecipeTypes() {
        BetterGlass.LOGGER.info("Registering RecipeTypes for %s".formatted(BetterGlass.MOD_ID));

        Registry.register(BuiltInRegistries.RECIPE_TYPE,
                Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "glasscutting"), GLASSCUTTING);
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER,
                Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "glasscutting"), GLASSCUTTING_SERIALIZER);
    }
}