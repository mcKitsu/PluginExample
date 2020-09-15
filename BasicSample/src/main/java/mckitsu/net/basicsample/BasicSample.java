package mckitsu.net.basicsample;

import org.bukkit.plugin.java.JavaPlugin;

public final class BasicSample extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Basic sample onEnable");
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("Basic sample onDisable");
        // Plugin shutdown logic
    }
}
