package com.priceline.chutes;

import com.priceline.chutes.conventionalgame.ConventionalGameController;
import com.priceline.chutes.framework.Controller;

public class Game {

    //NOTE: To achieve maintainability and extensibility for a later extension of the whole application, the specific 'chutes-and-ladders' related functionalities
    //have been moved to the new class named 'Controller.java'.

    public static void main(String[] args) {
        Controller game;
        try {
            game = new ConventionalGameController();
            game.initiateGame(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
