package com.kata;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KataLog {

    enum Level {INFO, WARN, ERROR}

    static class LogEntry {
        LocalDateTime timestamp;
        String message;
        Level level;

        LogEntry(String message, Level level) {
            this.timestamp = LocalDateTime.now();
            this.message = message;
            this.level = level;
        }

        @Override
        public String toString() {
            return String.format("%s [%s] %s", timestamp, level, message);
        }
    }

    static class Logger {
        List<LogEntry> entries = new ArrayList<>();

        void log(String message, Level level) {
            entries.add(new LogEntry(message, level));
        }

        List<LogEntry> filterByText(String text) {
            String lower = text.toLowerCase();
            return entries.stream()
                    .filter(e -> e.message.toLowerCase().contains(lower))
                    .collect(Collectors.toList());
        }

        List<LogEntry> filterByLevel(Level level) {
            return entries.stream()
                    .filter(e -> e.level == level)
                    .collect(Collectors.toList());
        }

        void print() {
            entries.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Kata Log ===");

        Logger logger = new Logger();
        logger.log("Inicio de la aplicación", Level.INFO);
        logger.log("Advertencia de configuración", Level.WARN);
        logger.log("Error fatal del sistema", Level.ERROR);

        System.out.println("\n=== Todos los logs ===");
        logger.print();

        System.out.println("\n=== Solo WARN ===");
        logger.filterByLevel(Level.WARN).forEach(System.out::println);
    }
}
