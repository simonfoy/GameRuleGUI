package me.simonfoy.serversettingsgui;

import me.simonfoy.serversettingsgui.command.ServerSettingsCommand;
import me.simonfoy.serversettingsgui.gui.GameRulesGUI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerSettingsGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("serversettings").setExecutor(new ServerSettingsCommand());

        Bukkit.getPluginManager().registerEvents(new GameRulesGUI(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
