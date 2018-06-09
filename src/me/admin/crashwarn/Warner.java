package me.admin.crashwarn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * CrashWarn started
 */
public class Warner {

    ArrayList<String> sent = new ArrayList<String>();


    Core core;

    private Warner(Core core) {
        this.core = core;
    }

    public void checkTps() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!(sent.contains("True"))) {
                if (Handler.getTps() < 15) {

                    if (p.isOp() || p.hasPermission("crashwarn.admin")) {
                        p.sendMessage(ChatColor.DARK_AQUA + "[CRASHWARN]" + ChatColor.DARK_RED + "SEVERE:" + ChatColor.RED + " Crash Warn! Current server TPS is " + ChatColor.GOLD + Handler.getTps() + ChatColor.RED + "!");
                        sent.add("True");


                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable() {

                            @Override
                            public void run() {
                                sent.remove("True");
                            }
                        }, 1200);
                    }

                }


            }


            if (Handler.getTps() > 15) {
                if (sent.contains("True")) {
                    sent.remove("True");
                    if (p.isOp()) {
                        p.sendMessage(ChatColor.DARK_AQUA + "[CRASHWARN]" + ChatColor.GRAY + ":" + ChatColor.GREEN + " Server TPS now under control again!");
                    }
                }

            }
        }
    }
}


