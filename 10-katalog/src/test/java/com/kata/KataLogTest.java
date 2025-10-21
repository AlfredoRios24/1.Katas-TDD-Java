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

    @Test
    void shouldFilterLogsByTextAndLevel() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Inicio del sistema", KataLog.Level.INFO);
        logger.log("Error en el sistema", KataLog.Level.ERROR);
        logger.log("Sistema estable", KataLog.Level.INFO);

        List<KataLog.LogEntry> filtered = logger.filterByText("sistema")
                .stream()
                .filter(e -> e.level == KataLog.Level.ERROR)
                .toList();

        assertEquals(1, filtered.size());
        assertEquals("Error en el sistema", filtered.get(0).message);
    }

    @Test
    void shouldIgnoreCaseWhenFilteringByText() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Error Crítico en el Sistema", KataLog.Level.ERROR);
        logger.log("todo bien", KataLog.Level.INFO);

        List<KataLog.LogEntry> filtered = logger.filterByText("sistema");

        assertEquals(1, filtered.size());
        assertEquals("Error Crítico en el Sistema", filtered.get(0).message);
    }

    @Test
    void shouldHandleNullOrEmptyMessagesGracefully() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log(null, KataLog.Level.INFO);
        logger.log("", KataLog.Level.ERROR);

        assertEquals(2, logger.entries.size());
        assertNull(logger.entries.get(0).message);
        assertEquals("", logger.entries.get(1).message);
    }

    @Test
    void shouldPreserveInsertionOrder() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Primero", KataLog.Level.INFO);
        logger.log("Segundo", KataLog.Level.WARN);
        logger.log("Tercero", KataLog.Level.ERROR);

        assertEquals("Primero", logger.entries.get(0).message);
        assertEquals("Segundo", logger.entries.get(1).message);
        assertEquals("Tercero", logger.entries.get(2).message);
    }

    @Test
    void shouldReturnEmptyListWhenNoLogsPresent() {
        KataLog.Logger logger = new KataLog.Logger();

        List<KataLog.LogEntry> filteredByText = logger.filterByText("algo");
        List<KataLog.LogEntry> filteredByLevel = logger.filterByLevel(KataLog.Level.ERROR);

        assertTrue(filteredByText.isEmpty());
        assertTrue(filteredByLevel.isEmpty());
    }


}
