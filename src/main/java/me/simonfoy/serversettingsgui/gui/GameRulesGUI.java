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
        World world = player.getWorld();

        if (event.getCurrentItem().getType() == Material.BELL
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Announce Advancements")) {

            boolean announceAdvancementsCurrentState = world.getGameRuleValue(GameRule.ANNOUNCE_ADVANCEMENTS);
            world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, !announceAdvancementsCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.TNT
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Block Explosion Drop Decay")) {

            boolean blockExplosionDropDecayCurrentState = world.getGameRuleValue(GameRule.BLOCK_EXPLOSION_DROP_DECAY);
            world.setGameRule(GameRule.BLOCK_EXPLOSION_DROP_DECAY, !blockExplosionDropDecayCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.COMMAND_BLOCK
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Command Block Output")) {

            boolean commandBlockOutputCurrentState = world.getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT);
            world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, !commandBlockOutputCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.REDSTONE_BLOCK
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Command Modification Block Limit")) {
            player.sendMessage(ChatColor.RED + "This feature hasn't been implemented yet!");
            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.ELYTRA
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Disable Elytra Movement Check")) {

            boolean disableElytraMovementCheckCurrentState = world.getGameRuleValue(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK);
            world.setGameRule(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, !disableElytraMovementCheckCurrentState);

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

        ItemStack commandBlockOutputItem = new ItemStack(Material.COMMAND_BLOCK);
        ItemMeta commandBlockOutputItemMeta = commandBlockOutputItem.getItemMeta();

        boolean commandBlockOutputCurrentState = world.getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT);
        commandBlockOutputItemMeta.setDisplayName(ChatColor.GREEN + "Command Block Output: " + (commandBlockOutputCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        commandBlockOutputItem.setItemMeta(commandBlockOutputItemMeta);

        gui.setItem(2, commandBlockOutputItem);

        ItemStack commandModificationBlockLimitItem = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta commandModificationBlockLimitItemMeta = commandModificationBlockLimitItem.getItemMeta();

        int commandModificationBlockLimitCurrentState = world.getGameRuleValue(GameRule.COMMAND_MODIFICATION_BLOCK_LIMIT);
        commandModificationBlockLimitItemMeta.setDisplayName(ChatColor.GREEN + "Command Modification Block Limit: " + ChatColor.YELLOW + commandModificationBlockLimitCurrentState);

        commandModificationBlockLimitItem.setItemMeta(commandModificationBlockLimitItemMeta);

        gui.setItem(3, commandModificationBlockLimitItem);

        ItemStack disableElytraMovementCheckItem = new ItemStack(Material.ELYTRA);
        ItemMeta disableElytraMovementCheckItemMeta = disableElytraMovementCheckItem.getItemMeta();

        boolean disableElytraMovementCheckCurrentState = world.getGameRuleValue(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK);
        disableElytraMovementCheckItemMeta.setDisplayName(ChatColor.GREEN + "Disable Elytra Movement Check: " + (disableElytraMovementCheckCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        disableElytraMovementCheckItem.setItemMeta(disableElytraMovementCheckItemMeta);

        gui.setItem(4, disableElytraMovementCheckItem);

        player.openInventory(gui);

        player.openInventory(gui);
    }
}
