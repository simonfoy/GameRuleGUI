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
        } else if (event.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Disable Raids")) {

            boolean disableRaidsCurrentState = world.getGameRuleValue(GameRule.DISABLE_RAIDS);
            world.setGameRule(GameRule.DISABLE_RAIDS, !disableRaidsCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.CLOCK
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Daylight Cycle")) {

            boolean doDaylightCycleCurrentState = world.getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, !doDaylightCycleCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.BONE
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Entity Drops")) {

            boolean doEntityDropsCurrentState = world.getGameRuleValue(GameRule.DO_ENTITY_DROPS);
            world.setGameRule(GameRule.DO_ENTITY_DROPS, !doEntityDropsCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.FLINT_AND_STEEL
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Fire Ticks")) {

            boolean doFireTicksCurrentState = world.getGameRuleValue(GameRule.DO_FIRE_TICK);
            world.setGameRule(GameRule.DO_FIRE_TICK, !doFireTicksCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.RED_BED
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Immediate Respawn")) {

            boolean doImmediateRespawnCurrentState = world.getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN);
            world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, !doImmediateRespawnCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.PHANTOM_MEMBRANE
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Insomnia")) {

            boolean doInsomniaCurrentState = world.getGameRuleValue(GameRule.DO_INSOMNIA);
            world.setGameRule(GameRule.DO_INSOMNIA, !doInsomniaCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.CRAFTING_TABLE
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Limited Crafting")) {

            boolean doLimitedCraftingCurrentState = world.getGameRuleValue(GameRule.DO_LIMITED_CRAFTING);
            world.setGameRule(GameRule.DO_LIMITED_CRAFTING, !doLimitedCraftingCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.ROTTEN_FLESH
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Mob Loot")) {

            boolean doMobLootCurrentState = world.getGameRuleValue(GameRule.DO_MOB_LOOT);
            world.setGameRule(GameRule.DO_MOB_LOOT, !doMobLootCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.ZOMBIE_HEAD
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Mob Spawning")) {

            boolean doMobSpawningCurrentState = world.getGameRuleValue(GameRule.DO_MOB_SPAWNING);
            world.setGameRule(GameRule.DO_MOB_SPAWNING, !doMobSpawningCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.PILLAGER_SPAWN_EGG
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Patrol Spawning")) {

            boolean doPatrolSpawningCurrentState = world.getGameRuleValue(GameRule.DO_PATROL_SPAWNING);
            world.setGameRule(GameRule.DO_PATROL_SPAWNING, !doPatrolSpawningCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.GRASS_BLOCK
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Tile Drops")) {

            boolean doTileDropsCurrentState = world.getGameRuleValue(GameRule.DO_TILE_DROPS);
            world.setGameRule(GameRule.DO_TILE_DROPS, !doTileDropsCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.WANDERING_TRADER_SPAWN_EGG
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Trader Spawning")) {

            boolean doTraderSpawningCurrentState = world.getGameRuleValue(GameRule.DO_TRADER_SPAWNING);
            world.setGameRule(GameRule.DO_TRADER_SPAWNING, !doTraderSpawningCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.VINE
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Vines Spread")) {

            boolean doVinesSpreadCurrentState = world.getGameRuleValue(GameRule.DO_VINES_SPREAD);
            world.setGameRule(GameRule.DO_VINES_SPREAD, !doVinesSpreadCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.WARDEN_SPAWN_EGG
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.GREEN + "Do Warden Spawning")) {

            boolean doWardenSpawningCurrentState = world.getGameRuleValue(GameRule.DO_WARDEN_SPAWNING);
            world.setGameRule(GameRule.DO_WARDEN_SPAWNING, !doWardenSpawningCurrentState);

            openGameRulesGUI(player);

            event.setCancelled(true);
        } else if (event.getCurrentItem().getType() == Material.CLOCK
                && event.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.AQUA + "Do Weather Cycle")) {

            boolean doWeatherCycleCurrentState = world.getGameRuleValue(GameRule.DO_WEATHER_CYCLE);
            world.setGameRule(GameRule.DO_WEATHER_CYCLE, !doWeatherCycleCurrentState);

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

        ItemStack disableRaidsItem  = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta disableRaidsItemMeta = disableRaidsItem.getItemMeta();

        boolean disableRaidsCurrentState = world.getGameRuleValue(GameRule.DISABLE_RAIDS);
        disableRaidsItemMeta.setDisplayName(ChatColor.GREEN + "Disable Raids: " + (disableRaidsCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        disableRaidsItem.setItemMeta(disableRaidsItemMeta);

        gui.setItem(5, disableRaidsItem);

        ItemStack doDaylightCycleItem = new ItemStack(Material.CLOCK);
        ItemMeta doDaylightCycleItemMeta = doDaylightCycleItem.getItemMeta();

        boolean doDaylightCycleCurrentState = world.getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE);
        doDaylightCycleItemMeta.setDisplayName(ChatColor.GREEN + "Do Daylight Cycle: " + (doDaylightCycleCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doDaylightCycleItem.setItemMeta(doDaylightCycleItemMeta);

        gui.setItem(6, doDaylightCycleItem);

        ItemStack doEntityDropsItem = new ItemStack(Material.BONE);
        ItemMeta doEntityDropsItemMeta = doEntityDropsItem.getItemMeta();

        boolean doEntityDropsCurrentState = world.getGameRuleValue(GameRule.DO_ENTITY_DROPS);
        doEntityDropsItemMeta.setDisplayName(ChatColor.GREEN + "Do Entity Drops: " + (doEntityDropsCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doEntityDropsItem.setItemMeta(doEntityDropsItemMeta);

        gui.setItem(7, doEntityDropsItem);

        ItemStack doFireTicksItem = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta doFireTicksItemMeta = doFireTicksItem.getItemMeta();

        boolean doFireTicksCurrentState = world.getGameRuleValue(GameRule.DO_FIRE_TICK);
        doFireTicksItemMeta.setDisplayName(ChatColor.GREEN + "Do Fire Ticks: " + (doFireTicksCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doFireTicksItem.setItemMeta(doFireTicksItemMeta);

        gui.setItem(8, doFireTicksItem);

        ItemStack doImmediateRespawnItem = new ItemStack(Material.RED_BED);
        ItemMeta doImmediateRespawnItemMeta = doImmediateRespawnItem.getItemMeta();

        boolean doImmediateRespawnCurrentState = world.getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN);
        doImmediateRespawnItemMeta.setDisplayName(ChatColor.GREEN + "Do Immediate Respawn: " + (doImmediateRespawnCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doImmediateRespawnItem.setItemMeta(doImmediateRespawnItemMeta);

        gui.setItem(9, doImmediateRespawnItem);

        ItemStack doInsomniaItem = new ItemStack(Material.PHANTOM_MEMBRANE);
        ItemMeta doInsomniaItemMeta = doInsomniaItem.getItemMeta();

        boolean doInsomniaCurrentState = world.getGameRuleValue(GameRule.DO_INSOMNIA);
        doInsomniaItemMeta.setDisplayName(ChatColor.GREEN + "Do Insomnia: " + (doInsomniaCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doInsomniaItem.setItemMeta(doInsomniaItemMeta);

        gui.setItem(10, doInsomniaItem);

        ItemStack doLimitedCraftingItem = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta doLimitedCraftingItemMeta = doLimitedCraftingItem.getItemMeta();

        boolean doLimitedCraftingCurrentState = world.getGameRuleValue(GameRule.DO_LIMITED_CRAFTING);
        doLimitedCraftingItemMeta.setDisplayName(ChatColor.GREEN + "Do Limited Crafting: " + (doLimitedCraftingCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doLimitedCraftingItem.setItemMeta(doLimitedCraftingItemMeta);

        gui.setItem(11, doLimitedCraftingItem);

        ItemStack doMobLootItem = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta doMobLootItemMeta = doMobLootItem.getItemMeta();

        boolean doMobLootCurrentState = world.getGameRuleValue(GameRule.DO_MOB_LOOT);
        doMobLootItemMeta.setDisplayName(ChatColor.GREEN + "Do Mob Loot: " + (doMobLootCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doMobLootItem.setItemMeta(doMobLootItemMeta);

        gui.setItem(12, doMobLootItem);

        ItemStack doMobSpawningItem = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta doMobSpawningItemMeta = doMobSpawningItem.getItemMeta();

        boolean doMobSpawningCurrentState = world.getGameRuleValue(GameRule.DO_MOB_SPAWNING);
        doMobSpawningItemMeta.setDisplayName(ChatColor.GREEN + "Do Mob Spawning: " + (doMobSpawningCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doMobSpawningItem.setItemMeta(doMobSpawningItemMeta);

        gui.setItem(12, doMobSpawningItem);

        ItemStack doPatrolSpawningItem = new ItemStack(Material.PILLAGER_SPAWN_EGG);
        ItemMeta doPatrolSpawningItemMeta = doPatrolSpawningItem.getItemMeta();

        boolean doPatrolSpawningCurrentState = world.getGameRuleValue(GameRule.DO_PATROL_SPAWNING);
        doPatrolSpawningItemMeta.setDisplayName(ChatColor.GREEN + "Do Patrol Spawning: " + (doPatrolSpawningCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doPatrolSpawningItem.setItemMeta(doPatrolSpawningItemMeta);

        gui.setItem(12, doPatrolSpawningItem);

        ItemStack doTileDropsItem = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta doTileDropsItemMeta = doTileDropsItem.getItemMeta();

        boolean doTileDropsCurrentState = world.getGameRuleValue(GameRule.DO_TILE_DROPS);
        doTileDropsItemMeta.setDisplayName(ChatColor.GREEN + "Do Tile Drops: " + (doTileDropsCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doTileDropsItem.setItemMeta(doTileDropsItemMeta);

        gui.setItem(13, doTileDropsItem);

        ItemStack doTraderSpawningItem = new ItemStack(Material.WANDERING_TRADER_SPAWN_EGG);
        ItemMeta doTraderSpawningItemMeta = doTraderSpawningItem.getItemMeta();

        boolean doTraderSpawningCurrentState = world.getGameRuleValue(GameRule.DO_TRADER_SPAWNING);
        doTraderSpawningItemMeta.setDisplayName(ChatColor.GREEN + "Do Trader Spawning: " + (doTraderSpawningCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doTraderSpawningItem.setItemMeta(doTraderSpawningItemMeta);

        gui.setItem(14, doTraderSpawningItem);

        ItemStack doVinesSpreadItem = new ItemStack(Material.VINE);
        ItemMeta doVinesSpreadItemMeta = doVinesSpreadItem.getItemMeta();

        boolean doVinesSpreadCurrentState = world.getGameRuleValue(GameRule.DO_VINES_SPREAD);
        doVinesSpreadItemMeta.setDisplayName(ChatColor.GREEN + "Do Vines Spread: " + (doVinesSpreadCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doVinesSpreadItem.setItemMeta(doVinesSpreadItemMeta);

        gui.setItem(15, doVinesSpreadItem);

        ItemStack doWardenSpawningItem = new ItemStack(Material.WARDEN_SPAWN_EGG);
        ItemMeta doWardenSpawningItemMeta = doWardenSpawningItem.getItemMeta();

        boolean doWardenSpawningCurrentState = world.getGameRuleValue(GameRule.DO_WARDEN_SPAWNING);
        doWardenSpawningItemMeta.setDisplayName(ChatColor.GREEN + "Do Warden Spawning: " + (doWardenSpawningCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doWardenSpawningItem.setItemMeta(doWardenSpawningItemMeta);

        gui.setItem(16, doWardenSpawningItem);

        ItemStack doWeatherCycleItem = new ItemStack(Material.CLOCK);
        ItemMeta doWeatherCycleItemMeta = doWeatherCycleItem.getItemMeta();

        boolean doWeatherCycleCurrentState = world.getGameRuleValue(GameRule.DO_WEATHER_CYCLE);
        doWeatherCycleItemMeta.setDisplayName(ChatColor.AQUA + "Do Weather Cycle: " + (doWeatherCycleCurrentState ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));

        doWeatherCycleItem.setItemMeta(doWeatherCycleItemMeta);

        gui.setItem(17, doWeatherCycleItem);

        player.openInventory(gui);
    }
}
