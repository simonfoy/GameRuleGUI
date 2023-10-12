package me.simonfoy.gamerulegui;

import me.simonfoy.gamerulegui.command.GameRuleGUICommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameRuleGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("gamerulegui").setExecutor(new GameRuleGUICommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
