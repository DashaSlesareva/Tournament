package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(101, "Petr Smirnov", 10);
    Player player2 = new Player(102, "Ivan Petrov", 9);
    Player player3 = new Player(103, "Olga Ivanova", 11);
    Player player4 = new Player(104, "Maxim Ivanov", 11);

    @Test
    public void exceptionTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petr Smirnov", "Olga Ivanova");
        });
    }
    @Test
    public void matchPlayer1StrongerTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertEquals(game.round("Petr Smirnov","Ivan Petrov"), 1);
    }
    @Test
    public void matchPlayer2StrongerTest() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        Assertions.assertEquals(game.round("Ivan Petrov", "Olga Ivanova"), -1);
    }
    @Test
    public void matchDrawTest() {
        Game game = new Game();
        game.register(player3);
        game.register(player4);
        Assertions.assertEquals(game.round("Olga Ivanova","Maxim Ivanov" ), 0);
    }

}
