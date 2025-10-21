package eu.decentsoftware.holograms.api.utils;


import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class Common {

    public static final String PREFIX;

    static {
        PREFIX = "&8[&3DecentHolograms&8] &7";
    }

    /*
     * 	Colorize
     */

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&',string);
    }

}
