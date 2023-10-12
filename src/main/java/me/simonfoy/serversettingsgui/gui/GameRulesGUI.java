package me.simonfoy.serversettingsgui.gui;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameRulesGUI implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;

        if (event.getView().getTitle().equals("Your Server Settings")
                && event.getCurrentItem().getType() == Material.ENCHANTED_BOOK
                && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Game Rules")) {

            Player player = (Player) event.getWhoClicked();
            openGameRulesGUI(player);
            event.setCancelled(true);
        } else if (event.getView().getTitle().equals("Game Rules")) {
            handleGameRuleToggle(event);
        }
    }

    private void handleGameRuleToggle(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem().getType() == Material.BELL
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Announce Advancements")) {

            World world = player.getWorld();
            boolean currentState = world.getGameRuleValue(GameRule.ANNOUNCE_ADVANCEMENTS);
            world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, !currentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.TNT
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Block Explosion Drop Decay")) {

            World world = player.getWorld();
            boolean currentState = world.getGameRuleValue(GameRule.BLOCK_EXPLOSION_DROP_DECAY);
            world.setGameRule(GameRule.BLOCK_EXPLOSION_DROP_DECAY, !currentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        }
    }

    private void openGameRulesGUI(Player player) {

        World world = player.getWorld();

        Inventory gui = Bukkit.createInventory(null, 54, "Game Rules");

        ItemStack announceAdvancementsItem = new ItemStack(Material.BELL);
        ItemMeta announceAdvancementsItemMeta = announceAdvancementsItem.getItemMeta();

        boolean announceAdvancementsCurrentState = world.getGameRuleValue(GameRule.ANNOUNCE_ADVANCEMENTS);
        announceAdvancementsItemMeta.setDisplayName(ChatColor.GREEN + "Announce Advancements: " + (announceAdvancementsCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        announceAdvancementsItem.setItemMeta(announceAdvancementsItemMeta);

        gui.setItem(0, announceAdvancementsItem);

        ItemStack blockExplosionDropDecayItem = new ItemStack(Material.TNT);
        ItemMeta blockExplosionDropDecayItemMeta = blockExplosionDropDecayItem.getItemMeta();

        boolean blockExplosionDropDecayCurrentState = world.getGameRuleValue(GameRule.BLOCK_EXPLOSION_DROP_DECAY);
        blockExplosionDropDecayItemMeta.setDisplayName(ChatColor.GREEN + "Block Explosion Drop Decay: " + (blockExplosionDropDecayCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        blockExplosionDropDecayItem.setItemMeta(blockExplosionDropDecayItemMeta);

        gui.setItem(1, blockExplosionDropDecayItem);

        player.openInventory(gui);
    }
}
