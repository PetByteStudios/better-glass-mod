package dev.petbyte.betterglass;

// import dev.petbyte.betterglass.datagen.ModBlockLootTableProvider;
import dev.petbyte.betterglass.datagen.ModBlockTagsProvider;
import dev.petbyte.betterglass.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BetterGlassDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		// pack.addProvider(ModBlockLootTableProvider::new);
	}
}
