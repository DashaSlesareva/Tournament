package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> players = new ArrayList<>();

    public void register (Player player){
        players.add(player);
    }

    public int round (String playerName1, String playerName2){

        int player1Strength = 0;
        int player2Strength = 0;
        for (Player player : players) {
            if (player.getName() == playerName1) {player1Strength = player.getStrength();}
            if (player.getName() == playerName2) {player2Strength = player.getStrength();}
        }
        if (player1Strength==0) {throw new NotRegisteredException("Player: " + playerName1 + " is not registered");}
        if (player2Strength==0) {throw new NotRegisteredException("Player: " + playerName2 + " is not registered");}

        if (player1Strength > player2Strength) {return 1;}
        if (player1Strength < player2Strength) {return -1;}
        return 0;

    }


}
