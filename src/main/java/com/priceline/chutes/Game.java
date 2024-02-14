package com.priceline.chutes;

import com.priceline.chutes.entity.Board;
import com.priceline.chutes.entity.BoardSquare;
import com.priceline.chutes.entity.Player;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    //NOTE: changed the Random private class resource as static.
    private static Random random = new Random();

//    Player dijkstra = new Player("dijkstra");
//    Player turing = new Player("turing");
//    Player hopper = new Player("hopper");
//    Player torvalds = new Player("torvalds");

    public Player playGame(List<Player> players){
//        Player[] players = new Player[]{dijkstra, turing, hopper, torvalds};
        Board board = new Board();

        while(true){
            for (Player currentPlayer : players) {
                int spinResult = spin();
                int nextPosition = currentPlayer.getPosition() + spinResult;
                if (nextPosition > 100){
                    //NOTE: Fixed a bug. The previous statement, 'break;', was inaccurate based on our business rule.
                    // I have changed it to 'continue;' to fix the logical error.
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

    //NOTE: changed the spin() method as static.
    private static int spin(){
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        try {
            //NOTE: Below is a new section of code for processing the main method's parameters (args),
            // to accept a variable number (2 ~4) of players with their names. Based on the players' information, the players instances are created.
            print("--- Let's set the players!");
            List<Player> players = createBasePlayers(args);

            //NOTE: Below is a new section of code for determining the play order of the players.
            print("--- Let's determine the play order!");
            players = determinePlayOrder(players);
            print("The play order : "+ players.stream().map(player -> player.getName()).collect(Collectors.joining(", ")).toString());

            print("--- Let's play the game!");
            Player winner = new Game().playGame(players);
            System.out.println("The winner is: " + winner.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //NOTE: This createBasePlayers() method was newly added.
    public static List<Player> createBasePlayers(String[] args){
        if(args.length<2){
            print("Could not play. Too little number of players. Please enter the names of 2 ~ 4 players.");
            System.exit(0);
        }else if(args.length>4){
            print("Could not play. Too many number of players. Please enter the names of 2 ~ 4 players.");
            System.exit(0);
        }
        print("The number players: "+args.length);
        return Arrays.stream(args).map(p -> new Player(p)).collect(Collectors.toList());
    }

    //NOTE: This determinePlayOrder() method was newly added.
    //this method uses a recursive run of the self method to find the definite order of play among all players.
    public static List<Player> determinePlayOrder(List<Player> players){
        Map<Integer, List<Player>> spinResults = new HashMap<>();
        //1. each player spins and get their individual number.
        players.stream().forEach(player -> {
            int spinVal = spin();
            print("> player name: "+player.getName()+", spin result: "+spinVal);
            if(Objects.nonNull(spinResults.get(spinVal))){
                spinResults.get(spinVal).add(player);
            }else{
                spinResults.put(spinVal, new ArrayList<>(List.of(player)));
            }
        });
        //2. check the tied players, and determine the orders among them.
        spinResults.entrySet().stream().forEach(entry -> {
            if (entry.getValue().size() > 1) {
                print("> tie found! replay among them.");
                List<Player> newOrdered = determinePlayOrder(entry.getValue()); // NOTE: recursive call
                entry.setValue(newOrdered);
            }
        });
        return spinResults.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<Player>>comparingByKey().reversed())
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    public static void print(Object o){
        System.out.println(o);
    }



}
