package nl.jessegeerts.breachpvp.breachwildteleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import randomtp.whoktor.other.RandomTPAPI;

public class LaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cYou are not a player.");
            return true;
        }
        Player p = (Player) sender;

        if (Bukkit.getPluginManager().isPluginEnabled("RandomTP")) {


            RandomTPAPI rtp = RandomTPAPI.getInstance();
            if (p.getLocation().getWorld().getName().equalsIgnoreCase("world")||p.getLocation().getWorld().getName().equalsIgnoreCase("arctic")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn " + p.getName());
                Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        rtp.randomTeleportPlayer(p, p.getLocation().getWorld(), 4500);
                    }
                },20);
                return true;
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lERROR: &cYou have to be in world (spawn) or arctic world."));
            }
        } else {
            Bukkit.getLogger().warning("RandomTP from Whoktor is not installed (https://www.spigotmc.org/resources/randomtp-%E1%B4%8F%CA%80%C9%AA%C9%A2%C9%AA%C9%B4%E1%B4%80%CA%9F-sign-gui-menu-now-recoded-best-random-teleport-plugin.5084/)");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lERROR >> &cSomething went wrong, take contact with the staff about the commmand /wild ."));
            Bukkit.getPluginManager().disablePlugin(Main.getPlugin());

        }

        return true;
    }
}