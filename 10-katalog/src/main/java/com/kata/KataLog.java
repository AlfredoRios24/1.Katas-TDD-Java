package com.kata;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class KataLog {

    static class LogEntry {
        LocalDateTime timestamp;
        String message;

        LogEntry(String message) {
            this.timestamp = LocalDateTime.now();
            this.message = message;
        }

        @Override
        public String toString() {
            return timestamp + " - " + message;
        }
    }

    static class Logger {
        List<LogEntry> entries = new ArrayList<>();

        void log(String message) {
            entries.add(new LogEntry(message));
        }

        void print() {
            entries.forEach(System.out::println);
        }


        List<LogEntry> filter(String keyword) {
            List<LogEntry> filtered = new ArrayList<>();
            for (LogEntry entry : entries) {
                if (entry.message.toLowerCase().contains(keyword.toLowerCase())) {
                    filtered.add(entry);
                }
            }
            return filtered;
        }
    }



    public static void main(String[] args) {
        System.out.println("=== Kata Log ===");

        Logger logger = new Logger();
        logger.log("Inicio de la aplicación");
        logger.log("Procesando datos");
        logger.log("Finalizando");

        System.out.println("\nRegistros:");
        logger.print();
    }
}
