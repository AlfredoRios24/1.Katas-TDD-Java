package com.kata;

public class MarsRover {

    enum Direction {N, E, S, W}

    static class Rover {
        int x, y;
        Direction dir;

        Rover(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        void move(String commands) {
            for (char c : commands.toCharArray()) {
                switch (c) {
                    case 'L': turnLeft(); break;
                    case 'R': turnRight(); break;
                    case 'M': moveForward(); break;
                }
            }
        }

        void turnLeft() {
            dir = Direction.values()[(dir.ordinal() + 3) % 4];
        }

        void turnRight() {
            dir = Direction.values()[(dir.ordinal() + 1) % 4];
        }

        void moveForward() {
            switch (dir) {
                case N -> y++;
                case S -> y--;
                case E -> x++;
                case W -> x--;
            }
        }

        @Override
        public String toString() {
            return x + " " + y + " " + dir;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Mars Rover Kata ===");

        Rover rover = new Rover(1, 2, Direction.N);
        String commands = "LMLMLMLMM";
        rover.move(commands);

        System.out.printf("Posición final: %s%n", rover);
    }
}
