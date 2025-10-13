package com.kata;

import java.util.HashSet;
import java.util.Set;

public class MarsRover {

    public enum Direction {N, E, S, W}

    public static class Rover {
        int x, y;
        Direction dir;
        int maxX, maxY;
        boolean obstacleFound = false;
        Set<String> obstacles = new HashSet<>();

        public Rover(int x, int y, Direction dir) {
            this(x, y, dir, 5, 5);
        }

        public Rover(int x, int y, Direction dir, int maxX, int maxY) {
            if (x < 0 || y < 0) throw new IllegalArgumentException("Coordenadas negativas no permitidas");
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.maxX = maxX;
            this.maxY = maxY;
        }

        public void addObstacle(int ox, int oy) {
            if (ox > maxX || oy > maxY || ox < 0 || oy < 0)
                throw new IllegalArgumentException("Obstáculo fuera del mapa");
            obstacles.add(ox + "," + oy);
        }

        public void move(String commands) {
            if (commands == null || commands.isEmpty())
                throw new IllegalArgumentException("Comandos inválidos");

            for (char c : commands.toCharArray()) {
                switch (c) {
                    case 'L' -> turnLeft();
                    case 'R' -> turnRight();
                    case 'M' -> {
                        if (!moveForward()) return;
                    }
                    default -> throw new IllegalArgumentException("Comando inválido: " + c);
                }
                printMap();
            }
        }

        private void turnLeft() {
            dir = Direction.values()[(dir.ordinal() + 3) % 4];
        }

        private void turnRight() {
            dir = Direction.values()[(dir.ordinal() + 1) % 4];
        }

        private boolean moveForward() {
            int nextX = x, nextY = y;

            switch (dir) {
                case N -> nextY++;
                case S -> nextY--;
                case E -> nextX++;
                case W -> nextX--;
            }

            if (nextX < 0 || nextY < 0 || nextX > maxX || nextY > maxY)
                throw new IllegalStateException("Rover fuera del mapa");

            if (obstacles.contains(nextX + "," + nextY)) {
                obstacleFound = true;
                System.out.println("⚠️  Obstáculo detectado en (" + nextX + "," + nextY + ")");
                return false;
            }

            x = nextX;
            y = nextY;
            return true;
        }

        public void printMap() {
            System.out.println("\nMapa actual:");
            for (int row = maxY; row >= 0; row--) {
                for (int col = 0; col <= maxX; col++) {
                    if (x == col && y == row)
                        System.out.print("R ");
                    else if (obstacles.contains(col + "," + row))
                        System.out.print("# ");
                    else
                        System.out.print(". ");
                }
                System.out.println();
            }
            System.out.println("Posición: " + this);
        }

        @Override
        public String toString() {
            return obstacleFound
                    ? x + " " + y + " " + dir + " (OBSTÁCULO DETECTADO)"
                    : x + " " + y + " " + dir;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Mars Rover Kata ===");

        Rover rover = new Rover(1, 2, Direction.N, 5, 5);
        rover.addObstacle(3, 3);
        rover.addObstacle(2, 4);

        rover.printMap();

        String commands = "LMLMLMLMMRMM";
        System.out.println("Comandos: " + commands);
        rover.move(commands);

        System.out.println("\nPosición final: " + rover);
    }
}
