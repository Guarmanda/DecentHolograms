package eu.decentsoftware.holograms.plugin;

import eu.decentsoftware.holograms.api.DecentHolograms;
import eu.decentsoftware.holograms.api.DecentHologramsAPI;
import eu.decentsoftware.holograms.api.utils.reflect.Version;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class DecentHologramsPlugin  {

    public DecentHolograms onEnable(JavaPlugin plugin) {
        if (Version.CURRENT == null) {
            Bukkit.getLogger().severe("Unsupported server version detected: " + Bukkit.getServer().getVersion());
            return null;
        }
        DecentHologramsAPI.onLoad(plugin);
        DecentHologramsAPI.onEnable();
        return DecentHologramsAPI.get();
    }

    public void onDisable() {
        if (Version.CURRENT == null) {
            return;
        }
        DecentHologramsAPI.onDisable();
    }

}
