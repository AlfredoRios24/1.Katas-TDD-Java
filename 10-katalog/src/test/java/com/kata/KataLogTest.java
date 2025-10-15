package com.kata;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KataLogTest {

    @Test
    void shouldStoreOnLogMessage(){
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Inicio del sistema");

        assertEquals(1, logger.entries.size());
        assertTrue(logger.entries.get(0).message.contains("Inicio del sistema"));

        }

    @Test
    void shouldKeepOrderOfLogMessages() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Primero");
        logger.log("Segundo");
        logger.log("Tercero");

        List<KataLog.LogEntry> entries = logger.entries;
        assertEquals("Primero", entries.get(0).message);
        assertEquals("Segundo", entries.get(1).message);
        assertEquals("Tercero", entries.get(2).message);
    }

    @Test
    void shouldFilterLogsByKeyword() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Inicio del sistema");
        logger.log("Error al conectar a la base de datos");
        logger.log("Proceso completado con éxito");
        logger.log("Error al guardar los datos");

        List<KataLog.LogEntry> filtered = logger.filter("error");

        assertEquals(2, filtered.size());
        assertTrue(filtered.get(0).message.contains("Error"));
        assertTrue(filtered.get(1).message.contains("Error"));
    }

    @Test
    void shouldReturnEmptyListWhenNoKeywordMatches() {
        KataLog.Logger logger = new KataLog.Logger();

        logger.log("Inicio del sistema");
        logger.log("Proceso completado");

        List<KataLog.LogEntry> filtered = logger.filter("error");

        assertTrue(filtered.isEmpty());
    }


}
