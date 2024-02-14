package com.priceline.chutes.entity;

public class Player {

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    String name;
    int position = 0;

    //NOTE: In each class, created a base constructor and set the modifier to be 'public'
    // so that an external class can instantiate this target class.
    private Player(){
        // NOTE: By setting this base constructor as 'private',
        // we can block the case where a player is instantiated without a name.
    }

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
