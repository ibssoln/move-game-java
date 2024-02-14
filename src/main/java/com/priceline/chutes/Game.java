package com.priceline.chutes;

import com.priceline.chutes.entity.Board;
import com.priceline.chutes.entity.BoardSquare;
import com.priceline.chutes.entity.Player;

import java.util.Random;

public class Game {

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    private Random random = new Random();
    Player dijkstra = new Player("dijkstra");
    Player turing = new Player("turing");
    Player hopper = new Player("hopper");
    Player torvalds = new Player("torvalds");

    public Player playGame(){
        Player[] players = new Player[]{dijkstra, turing, hopper, torvalds};
        Board board = new Board();

        while(true){
            for (Player currentPlayer : players) {
                int spinResult = spin();
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > 100){
                    //NOTE: the 'break' statement below was a bug. I have changed it to 'continue' to fix the logical error.
                    continue;
                }
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();
                if (nextPosition < 100) {
                    currentPlayer.setPosition(nextPosition);
                } else if (nextPosition == 100) {
                    return currentPlayer;//The winner!
                }
            }
        }
    }

    private int spin(){
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        try {
            Player winner = new Game().playGame();
            System.out.println("The winner is: " + winner.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
