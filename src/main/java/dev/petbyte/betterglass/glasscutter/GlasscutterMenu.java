package dev.petbyte.betterglass.glasscutter;

import dev.petbyte.betterglass.block.ModBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.StonecutterMenu;
import org.jspecify.annotations.NonNull;

public class GlasscutterMenu extends StonecutterMenu {
    private ContainerLevelAccess access;

    public GlasscutterMenu(int syncId, Inventory inv) {
        super(syncId, inv);
    }

    public GlasscutterMenu(int syncId, Inventory inv, ContainerLevelAccess access) {
        super(syncId, inv, access);
        this.access = access;
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return stillValid(this.access, player, ModBlocks.GLASSCUTTER);
    }
}