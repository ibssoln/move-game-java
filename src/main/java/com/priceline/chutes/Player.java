package com.priceline.chutes;

public class Player {

    String name;
    int position = 0;

    Player(String name){
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
