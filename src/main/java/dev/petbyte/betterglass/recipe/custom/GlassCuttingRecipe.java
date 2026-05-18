package dev.petbyte.betterglass.recipe.custom;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.recipe.ModRecipes;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.item.crafting.display.StonecutterRecipeDisplay;

import java.util.List;

public class GlassCuttingRecipe extends SingleItemRecipe {
    public GlassCuttingRecipe(CommonInfo commonInfo, Ingredient ingredient, ItemStackTemplate result) {
        super(commonInfo, ingredient, result);
    }

    @Override
    public RecipeType<GlassCuttingRecipe> getType() {
        return ModRecipes.GLASSCUTTING;
    }

    @Override
    public RecipeSerializer<GlassCuttingRecipe> getSerializer() {
        return ModRecipes.GLASSCUTTING_SERIALIZER;
    }

    @Override
    public String group() { return ""; }

    @Override
    public List<RecipeDisplay> display() {
        return List.of(new StonecutterRecipeDisplay(
                this.input().display(),
                this.resultDisplay(),
                new SlotDisplay.ItemSlotDisplay(ModBlocks.GLASSCUTTER.asItem())
        ));
    }

    public SlotDisplay resultDisplay() {
        return new SlotDisplay.ItemStackSlotDisplay(this.result());
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.STONECUTTER;
    }
}