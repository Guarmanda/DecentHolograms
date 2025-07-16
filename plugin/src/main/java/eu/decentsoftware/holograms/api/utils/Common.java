package eu.decentsoftware.holograms.api.utils;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class Common {

    public static final String NAME_REGEX = "[a-zA-Z0-9_-]+";

    private static final Pattern SPACING_CHARS_REGEX;

    static {
        SPACING_CHARS_REGEX = Pattern.compile("[_ \\-]+");
    }

    /*
     * 	Colorize
     */

    public static String colorize(String string) {
        return string;
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

    /**
     * Check whether the given version is higher than the current version.
     *
     * @param currentVersion The current version.
     * @param newVersion     The new version.
     * @return Boolean.
     */
    public static boolean isVersionHigher(String currentVersion, String newVersion) {
        if (isVersionInvalid(currentVersion) || isVersionInvalid(newVersion)) {
            return false;
        }

        String[] currentVersionParts = currentVersion.split("\\.");
        String[] newVersionParts = newVersion.split("\\.");

        for (int i = 0; i < 3; i++) {
            int currentVersionPart = Integer.parseInt(currentVersionParts[i]);
            int newVersionPart = Integer.parseInt(newVersionParts[i]);

            if (newVersionPart > currentVersionPart) {
                return true;
            } else if (newVersionPart < currentVersionPart) {
                return false;
            }
        }

        return false;
    }

    private static boolean isVersionInvalid(String version2) {
        return version2 == null || !version2.matches("\\d+\\.\\d+\\.\\d+(\\.\\d+)?");
    }

}
