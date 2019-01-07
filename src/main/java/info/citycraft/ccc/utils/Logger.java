package info.citycraft.ccc.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {
    /**
     * Logs a debug message (if debug mode is enabled)
     *
     * @param str String to log
     */
    public static void debug(String str) {
            log("&3[&aDEBUG&3]&d " + str);
    }

    /**
     * Logs an informative message
     *
     * @param str String to log
     */
    public static void info(String str) {
            log("&e" + str);
    }

    /**
     * Logs a warning message
     *
     * @param str String to log
     */
    public static void warn(String str) {
            log("&6" + str);
    }

    /**
     * Logs an error message
     *
     * @param str String to log
     */
    public static void error(String str) {
            log("&c" + str);
    }

    private static void log(String str) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[&3CityCraftCommander&e]&r " + str + "&r"));
    }
}