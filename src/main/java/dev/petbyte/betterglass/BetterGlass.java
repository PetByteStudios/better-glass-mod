package dev.petbyte.betterglass;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.tab.ModCreativeModeTabs;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterGlass implements ModInitializer {
	public static final String MOD_ID = "betterglass";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final String MOD_VERSION = FabricLoader.getInstance()
			.getModContainer(MOD_ID)
			.orElseThrow()
			.getMetadata()
			.getVersion()
			.getFriendlyString();

	@Override
	public void onInitialize() {
		BetterGlass.LOGGER.info("Booting up %s %s".formatted(BetterGlass.MOD_ID, MOD_VERSION));
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModBlocks.registerModBlocks();
	}
}