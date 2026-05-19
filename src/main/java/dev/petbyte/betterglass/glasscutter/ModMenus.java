package dev.petbyte.betterglass.glasscutter;

import dev.petbyte.betterglass.BetterGlass;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.inventory.StonecutterScreen;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final MenuType<GlasscutterMenu> GLASSCUTTER_MENU =
            Registry.register(
                    BuiltInRegistries.MENU,
                    Identifier.fromNamespaceAndPath(BetterGlass.MOD_ID, "glasscutter"),
                    new MenuType<>(GlasscutterMenu::new, FeatureFlags.VANILLA_SET)
            );

    public static void RegisterGlasscutterMenu() {
        MenuScreens.register(GLASSCUTTER_MENU, StonecutterScreen::new);
    }
}
