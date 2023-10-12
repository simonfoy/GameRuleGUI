package me.simonfoy.gamerulegui.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameRuleGUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            openGameRuleGUI(player);
        }
        return true;
    }

    private void openGameRuleGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Your Server Settings");

        ItemStack gameRulesItem = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta gameRulesItemMeta = gameRulesItem.getItemMeta();
        gameRulesItemMeta.setDisplayName(ChatColor.GREEN + "Game Rules");
        gameRulesItem.setItemMeta(gameRulesItemMeta);

        gui.setItem(13, gameRulesItem);

        player.openInventory(gui);
    }
}
