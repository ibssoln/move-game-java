package com.priceline.chutes.conventionalgame;

public class Player {

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    //NOTE: To achieve a better 'encapsulation' of properties in the classes, explicitly set the class 'properties'
    // to be 'private', and added missing accessors (getters and setters) for those properties
    // so that the properties can be accessed by other object via the accessor methods.
    private String name;
    private int position = 0;

    //NOTE: In each class, created a base constructor and set the modifier to be 'public'
    // so that an external class can instantiate this target class.
    private Player(){ // NOTE: By setting this base constructor as 'private', we can block the case where a player is instantiated without a name.
        super();
    }

    public Player(String name){
        this.name = name;
    }

    //NOTE: getters and setters of class properties can be useful for the extensibility and scalability of the application.
    // Often, 'unit tests' can benefit from the 'getters and setters' provided for the properties, to test different use-cases extensively.
    // Also, as the application grows, there arises more use-cases where we need to access the properties via accessor methods.

    public String getName() {
        return name;
    }

    //NOTE: We either not have this 'setName' method or set the modifier of this 'setName' method as 'private',
    //to clearly express the business rule that we do not want a Player's name to be changed by an external access/influence.
    private void setName(String name) { // NOTE: By setting this setter as 'private', we made it clear to block the case where a player name is changed by an external influence.
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
