package net.mckitsu.yamlloader;

import net.mckitsu.kitsulib.io.FileManager;
import net.mckitsu.kitsulib.io.ResourceManager;
import net.mckitsu.kitsulib.io.YamlManager;
import net.mckitsu.kitsulib.ui.Logger;
import net.mckitsu.yamlloader.yaml.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public final class YamlLoader extends JavaPlugin {
    FileManager fileManagerConfig;

    @Override
    public void onEnable() {
        getLogger().info("Init YamlLoader");
        fileManagerConfig = new FileManager("plugins\\YamlLoader", "config.yml");
        if(!fileManagerConfig.exists()){    //if not fount the resource file in plugin dir.
            getLogger().info("Copy resource to plugin folder");
            fileManagerConfig.createFile();
            InputStream cfg = YamlLoader.class.getClassLoader().getResourceAsStream("config.yml");

            getLogger().info("Begin copy");
            boolean result = fileManagerConfig.copy.asInputStream(cfg);
            if(result)
                getLogger().info("Copy successful!");
            else
                getLogger().info("Copy fail");
        }

        YamlManager<Config> configLoader =
                new YamlManager<Config>(Config.class, YamlLoader.class.getClassLoader());

        try {
            Config config = configLoader.load.asFileManager(fileManagerConfig); //create a class loader for 'Config' class
            getLogger().info(config.toString());    //show the class data
            getLogger().info(configLoader.dump.asString(config));   //convert class to yaml format and show in terminal.
        } catch (IOException e) {
            //e.printStackTrace();
            getLogger().warning("config format not match!");
            //most to recopy file in to folder and reload yaml.
        }


        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
