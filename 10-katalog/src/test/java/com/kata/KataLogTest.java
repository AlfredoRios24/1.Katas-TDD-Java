package com.kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KataLogTest {

    @Test
    void shouldAddLogEntries() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Inicio del sistema", KataLog.Level.INFO);
        logger.log("Advertencia de memoria", KataLog.Level.WARN);
        logger.log("Error crítico", KataLog.Level.ERROR);

        assertEquals(3, logger.entries.size());
        assertEquals("Inicio del sistema", logger.entries.get(0).message);
        assertEquals("Advertencia de memoria", logger.entries.get(1).message);
        assertEquals("Error crítico", logger.entries.get(2).message);
    }

    @Test
    void shouldFilterLogsByText() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Inicio del sistema", KataLog.Level.INFO);
        logger.log("Fallo en el módulo 3", KataLog.Level.ERROR);
        logger.log("Sistema estable", KataLog.Level.INFO);

        List<KataLog.LogEntry> filtered = logger.filterByText("sistema");

        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().allMatch(e -> e.message.toLowerCase().contains("sistema")));
    }

    @Test
    void shouldReturnEmptyWhenNoMatchInTextFilter() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Inicio del sistema", KataLog.Level.INFO);
        logger.log("Todo correcto", KataLog.Level.INFO);

        List<KataLog.LogEntry> filtered = logger.filterByText("error");

        assertTrue(filtered.isEmpty());
    }

    @Test
    void shouldFilterLogsByLevel() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Todo bien", KataLog.Level.INFO);
        logger.log("Cuidado", KataLog.Level.WARN);
        logger.log("Fallo grave", KataLog.Level.ERROR);
        logger.log("Aviso adicional", KataLog.Level.WARN);

        List<KataLog.LogEntry> warnings = logger.filterByLevel(KataLog.Level.WARN);

        assertEquals(2, warnings.size());
        assertTrue(warnings.stream().allMatch(e -> e.level == KataLog.Level.WARN));
    }

    @Test
    void shouldReturnEmptyWhenNoLogsOfGivenLevel() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Todo correcto", KataLog.Level.INFO);
        logger.log("Otro mensaje", KataLog.Level.INFO);

        List<KataLog.LogEntry> errors = logger.filterByLevel(KataLog.Level.ERROR);

        assertTrue(errors.isEmpty());
    }

    @Test
    void shouldAddLogsWithDifferentLevels() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Mensaje informativo", KataLog.Level.INFO);
        logger.log("Advertencia", KataLog.Level.WARN);
        logger.log("Error crítico", KataLog.Level.ERROR);

        assertEquals(3, logger.entries.size());
        assertEquals(KataLog.Level.INFO, logger.entries.get(0).level);
        assertEquals(KataLog.Level.WARN, logger.entries.get(1).level);
        assertEquals(KataLog.Level.ERROR, logger.entries.get(2).level);
    }
}
