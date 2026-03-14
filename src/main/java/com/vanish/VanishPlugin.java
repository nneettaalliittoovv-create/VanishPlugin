package com.vanish;

import org.bukkit.plugin.java.JavaPlugin;

public class VanishPlugin extends JavaPlugin {
    private VanishManager vanishManager;

    @Override
    public void onEnable() {
        vanishManager = new VanishManager(this);
        getCommand("vanish").setExecutor(new VanishCommand(vanishManager));
        
        getLogger().info("VanishPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("VanishPlugin has been disabled!");
    }

    public VanishManager getVanishManager() {
        return vanishManager;
    }
}
