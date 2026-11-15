package eu.decentsoftware.holograms.api.holograms;

import eu.decentsoftware.holograms.api.DecentHolograms;
import eu.decentsoftware.holograms.api.DecentHologramsAPI;
import eu.decentsoftware.holograms.api.utils.PAPI;
import eu.decentsoftware.holograms.nms.api.renderer.NmsTextHologramRenderer;
import org.bukkit.Location;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HologramLineTest {
    @Test
    void reparsesContentAndPlaceholdersWithoutReplacingTextRenderer() {
        DecentHolograms holograms = mock(DecentHolograms.class, RETURNS_DEEP_STUBS);
        NmsTextHologramRenderer renderer = mock(NmsTextHologramRenderer.class);
        when(holograms.getNmsAdapter().getHologramComponentFactory().createTextRenderer()).thenReturn(renderer);
        try (MockedStatic<DecentHologramsAPI> api = mockStatic(DecentHologramsAPI.class);
             MockedStatic<PAPI> papi = mockStatic(PAPI.class)) {
            api.when(DecentHologramsAPI::get).thenReturn(holograms);
            papi.when(() -> PAPI.containsPlaceholders("Refill %timer%")).thenReturn(true);
            HologramLine line = new HologramLine(null, new Location(null, 0, 64, 0), "Refill 60");
            // Updating a hidden/disabled line must still refresh what its next display will render.
            line.setEnabled(false);

            line.setContent("Refill %timer%");
            assertEquals("Refill %timer%", line.getText());
            assertTrue(line.isContainsPlaceholders());
            assertSame(renderer, line.getRenderer());

            line.setContent("Refill 59");
            assertEquals("Refill 59", line.getText());
            assertFalse(line.isContainsPlaceholders());

            line.setContent(null);
            assertEquals("", line.getText());
            verify(holograms.getNmsAdapter().getHologramComponentFactory(), times(1)).createTextRenderer();
        }
    }
}
