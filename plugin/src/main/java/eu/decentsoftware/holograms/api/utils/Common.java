package eu.decentsoftware.holograms.api.utils;


import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.regex.Pattern;

@UtilityClass
public class Common {

    private static final Pattern SPACING_CHARS_REGEX;
    public static String PREFIX;

    static {
        SPACING_CHARS_REGEX = Pattern.compile("[_ \\-]+");
        PREFIX = "&8[&3DecentHolograms&8] &7";
    }

    /*
     * 	Colorize
     */

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&',string);
    }

    /*
     * 	Tell
     */

    /**
     * Remove spacing characters from the given string.
     *
     * <p>Spacing characters: ' ', '-', '_'</p>
     *
     * @param string The string.
     * @return The string without spacing characters.
     */
    public static String removeSpacingChars(String string) {
        if (string == null) {
            return null;
        }
        return SPACING_CHARS_REGEX.matcher(string).replaceAll("");
    }

}
