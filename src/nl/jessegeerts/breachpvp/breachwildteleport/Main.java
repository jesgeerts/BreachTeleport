package nl.jessegeerts.breachpvp.breachwildteleport;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Plugin plugin;
    public static Plugin getPlugin(){
        return plugin;
    }

    public void onEnable() {

        getLogger().info("This plugin is made by Jesse Geerts");
            plugin = this;
            getCommand("wild").setExecutor(new LaCommand());
    }
    public void onDisable(){
        plugin=null;
    }

}
