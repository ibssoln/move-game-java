package com.priceline.chutes;

import com.priceline.chutes.entity.Controller;
import com.priceline.chutes.entity.Player;
import java.util.*;
import java.util.stream.Collectors;
import static com.priceline.chutes.util.Utility.print;

public class Game {

    //NOTE: To achieve maintainability and extensibility for a later extension of the whole application, the specific 'chutes-and-ladders' related functionalities
    //have been moved to the new class named 'Controller.java'.

    public static void main(String[] args) {
        try {

            Controller gameController = new Controller();
            gameController.initiateGame(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
