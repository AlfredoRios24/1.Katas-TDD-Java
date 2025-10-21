package com.kata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {

    @Test
    void shouldStartAtLoveAll(){
        Tennis.Game game = new Tennis.Game();
        assertEquals("Love-All", game.getScore());
    }

    @Test
    void shouldHandleBasicScores(){
        Tennis.Game game = new Tennis.Game();

        game.wonPoint("player1");
        assertEquals("Fifteen-Love", game.getScore());

        game.wonPoint("player2");
        assertEquals("Fifteen-All", game.getScore());

        game.wonPoint("player1");
        assertEquals("Thirty-Fifteen", game.getScore());
    }

    @Test
    void shouldReachDeuce(){
        Tennis.Game game = new Tennis.Game();

        for (int i = 0; i < 3; i++){
            game.wonPoint("player1");
            game.wonPoint("player2");
        }
        assertEquals("Deuce", game.getScore());
    }

    @Test
    void shouldHandleAdvantage(){
        Tennis.Game game = new Tennis.Game();

        for (int i = 0; i < 3; i++){
            game.wonPoint("player1");
            game.wonPoint("player2");
        }
        game.wonPoint("player1");
        assertEquals("Advantage player1", game.getScore());

        game.wonPoint("player2");
        assertEquals("Deuce", game.getScore());

        game.wonPoint("player2");
        assertEquals("Advantage player2", game.getScore());
    }

    @Test
    void shouldDetectWinForPlayer2(){
        Tennis.Game game = new Tennis.Game();

        for (int i = 0; i < 4; i++ ){
            game.wonPoint("player2");
        }
        assertEquals("Win for player2", game.getScore());
    }

    @Test
    void shouldReturnFortyThirty(){
        Tennis.Game game = new Tennis.Game();

        game.wonPoint("player1");
        game.wonPoint("player1");
        game.wonPoint("player1");

        game.wonPoint("player2");
        game.wonPoint("player2");

        assertEquals("Forty-Thirty", game.getScore());
    }

    @Test
    void shouldReturnThirtyLove(){
        Tennis.Game game = new Tennis.Game();

        game.wonPoint("player1");
        game.wonPoint("player1");

        assertEquals("Thirty-Love", game.getScore());
    }


}
