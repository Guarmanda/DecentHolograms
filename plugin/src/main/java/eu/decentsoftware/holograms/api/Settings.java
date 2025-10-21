package eu.decentsoftware.holograms.api;

import lombok.experimental.UtilityClass;

@SuppressWarnings({"java:S1444", "java:S3008"})
@UtilityClass
public class Settings {

    public static boolean DEFAULT_DOWN_ORIGIN = false;

    public static double DEFAULT_HEIGHT_TEXT = 0.3;

    public static int DEFAULT_DISPLAY_RANGE = 48;

    public static int DEFAULT_UPDATE_RANGE = 48;

    public static int DEFAULT_UPDATE_INTERVAL = 20;

    /**
     * If true, the visibility of holograms will be updated when a player gets teleported or respawned.
     *
     * <p>By default, this is disabled because it causes visual glitches where even if a player gets teleported
     * by a fraction of a block, the holograms still disappear and reappear for them.</p>
     *
     * <p>Some clients (or client versions?) need this though, so if someone is experiencing issues with holograms
     * not showing up after a player gets teleported or respawned, they can enable this setting.</p>
     *
     * @since 2.8.9
     */

    public static boolean UPDATE_VISIBILITY_ON_TELEPORT = false;

    /**
     * Reload all Settings
     */
    public static void reload() {



    }

}
