package me.admin.crashwarn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * CrashWarn started
 */
public class Core extends JavaPlugin {

    public void onEnable(){

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[CrashWarner] " + ChatColor.GREEN + "by " + ChatColor.GOLD + "DevMinty" + ChatColor.GREEN + " has started!");

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Handler(), 100L, 1L);

    }



}
