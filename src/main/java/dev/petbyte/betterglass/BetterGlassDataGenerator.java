package dev.petbyte.betterglass;

import dev.petbyte.betterglass.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;

public class BetterGlassDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		var modBlockTagsProvider = pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider((output, registries) -> new ModItemTagsProvider(output, registries, modBlockTagsProvider));
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider((FabricPackOutput _) -> new ConnectedTexturesProvider());
		pack.addProvider((FabricPackOutput _) -> new ModTextureProvider());
		pack.addProvider(ModLangProvider::new);
	}
}
