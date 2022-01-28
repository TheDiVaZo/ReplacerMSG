package ReplacerMSG;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class command implements CommandExecutor {
        JavaPlugin plugin;
    public command(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!commandSender.hasPermission("replacermsg.command")) return false;
        if(args.length == 0) {
            String text = "";
            text += String.format("%sList of command:\n", ChatColor.YELLOW);
            text += String.format("%s/replacermsg - %sGet info on commands\n", ChatColor.WHITE, ChatColor.GRAY);
            text += String.format("%s/replacermsg reload - %sreload config", ChatColor.WHITE, ChatColor.GRAY);
            commandSender.sendMessage(text);
            return true;
        }
        switch (args[0]) {
            case "reload": {
                plugin.reloadConfig();
                commandSender.sendMessage("Config reloaded "+ ChatColor.GREEN + "success");
                return true;
            }
        }
        return false;
    }
}
