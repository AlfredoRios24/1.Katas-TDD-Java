package com.kata;

public class Tennis {

    static class Game {
        private int player1 = 0;
        private int player2 = 0;

        void wonPoint(String player) {
            if (player.equals("player1")) player1++;
            else player2++;
        }

        String getScore() {
            if (player1 == player2) {
                return switch (player1) {
                    case 0 -> "Love-All";
                    case 1 -> "Fifteen-All";
                    case 2 -> "Thirty-All";
                    case 3 -> "Forty-All";
                    default -> "Deuce";
                };
            } else if (player1 >= 4 || player2 >= 4) {
                int diff = player1 - player2;
                if (diff == 1) return "Advantage player1";
                if (diff == -1) return "Advantage player2";
                return diff >= 2 ? "Win for player1" : "Win for player2";
            } else {
                String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
                return scores[player1] + "-" + scores[player2];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Tennis Kata ===");

        Game game = new Game();
        game.wonPoint("player1");
        game.wonPoint("player2");
        game.wonPoint("player1");
        game.wonPoint("player1");

        System.out.printf("Score actual: %s%n", game.getScore());
    }
}
