package com.priceline.chutes.framework;

public interface Controller {

    //NOTE: For extensibility, created interfaces to be implemented by the concrete classes.
    // This interface can be implemented by the variation of the game controllers.
    void initiateGame(String[] gameParams);

}
