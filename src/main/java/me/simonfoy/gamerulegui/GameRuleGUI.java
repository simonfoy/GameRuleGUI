package me.simonfoy.gamerulegui;

import me.simonfoy.gamerulegui.command.GameRuleGUICommand;
import me.simonfoy.gamerulegui.gui.GameRulesGUI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameRuleGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("gamerulegui").setExecutor(new GameRuleGUICommand());

        Bukkit.getPluginManager().registerEvents(new GameRulesGUI(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
