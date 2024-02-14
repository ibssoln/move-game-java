package com.priceline.chutes;

import java.util.Random;

public class Game {

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
                    break;
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
