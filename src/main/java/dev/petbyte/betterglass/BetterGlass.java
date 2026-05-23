package dev.petbyte.betterglass;

import dev.petbyte.betterglass.block.ModBlocks;
import dev.petbyte.betterglass.glasscutter.ModMenus;
import dev.petbyte.betterglass.item.ModItems;
import dev.petbyte.betterglass.tab.ModCreativeModeTabs;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
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
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModMenus.RegisterGlasscutterMenu();

		ResourceManagerHelper.registerBuiltinResourcePack(
				Identifier.fromNamespaceAndPath("betterglass", "forced_resources"),
				FabricLoader.getInstance().getModContainer("betterglass").orElseThrow(),
				Component.literal("Better Glass Resources"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
	}
}