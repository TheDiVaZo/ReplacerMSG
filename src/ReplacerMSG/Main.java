package ReplacerMSG;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main extends JavaPlugin implements Listener {

    private static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();

        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);

        getServer().getPluginCommand("replacermsg").setExecutor(new command(this));
        instance = this;

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        //Bukkit.getConsoleSender().sendMessage(event.getMessage() + "АХАХАХАХАХАХ");
        List<String> msg = Arrays.asList(event.getMessage().split(" "));
        for(String s: getConfig().getConfigurationSection("words").getKeys(false)) {
            String original = getConfig().getString("words."+s+".original");
            String replacer_text = getConfig().getString("words."+s+".replacer_text");
            if(msg.indexOf(original) != -1) {
                msg.set(msg.indexOf(original), replacer_text);
            }
        }
        event.setMessage(String.join(" ", msg));
    }

    public static Main getInstance() {
        return instance;
    }
}
