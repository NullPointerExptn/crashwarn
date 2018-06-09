package me.admin.crashwarn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * CrashWarn started
 */
public class Warner{

    Core core;

    private Warner(Core core){
        this.core = core;
    }

    public void checkTps(){
        if(Handler.getTps() < 15) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if(p.isOp() || p.hasPermission("crashwarn.admin")){
                    p.sendMessage(ChatColor.DARK_AQUA + "[CRASHWARN]" + ChatColor.DARK_RED + "SEVERE:" + ChatColor.RED + " Crash Warn! Current server TPS is " + ChatColor.GOLD + Handler.getTps() + ChatColor.RED + "!");
                }
            }

        }


    }
}
