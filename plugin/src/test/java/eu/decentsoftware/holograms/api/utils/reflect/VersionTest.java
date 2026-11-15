package eu.decentsoftware.holograms.api.utils.reflect;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VersionTest {
    @BeforeAll
    static void initializeVersion() throws ClassNotFoundException {
        Server server = mock(Server.class);
        when(server.getBukkitVersion()).thenReturn("26.3.build.253-stable");
        try (MockedStatic<Bukkit> bukkit = mockStatic(Bukkit.class)) {
            bukkit.when(Bukkit::getServer).thenReturn(server);
            Class.forName(Version.class.getName());
        }
    }

    @Test
    void readsCurrentPaperMinecraftVersion() throws ReflectiveOperationException {
        Server server = mock(Server.class);
        when(server.getBukkitVersion()).thenReturn("26.3.build.253-stable");
        try (MockedStatic<Bukkit> bukkit = mockStatic(Bukkit.class)) {
            bukkit.when(Bukkit::getServer).thenReturn(server);
            java.lang.reflect.Method method = Version.class.getDeclaredMethod("getCurrentMinecraftVersion");
            method.setAccessible(true);
            assertEquals("26.3", method.invoke(null));
        }
    }

    @Test
    void resolvesPaperBuildVersion() {
        Version version = Version.fromMinecraftVersion("26.3.build.253-stable", Platform.PAPER);
        assertNotNull(version);
        assertEquals("paper_v26_3", version.name());
        assertSame(version, Version.fromMinecraftVersion("26.3", Platform.PAPER));
    }

    @Test
    void preservesLegacyVersionsAndPlatformRestrictions() {
        assertSame(Version.v1_8_R3, Version.fromMinecraftVersion("1.8.8-R0.1-SNAPSHOT", Platform.SPIGOT));
        assertSame(Version.paper_v1_21_R7, Version.fromMinecraftVersion("1.21.11", Platform.PAPER));
        assertSame(Version.v26_1, Version.fromMinecraftVersion("26.1", Platform.SPIGOT));
        assertNull(Version.fromMinecraftVersion("26.3", Platform.SPIGOT));
        assertNull(Version.fromMinecraftVersion("26.30", Platform.PAPER));
        assertNull(Version.fromMinecraftVersion(null, Platform.PAPER));
    }
}
