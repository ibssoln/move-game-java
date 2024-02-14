package com.priceline.chutes.conventionalgame;

public class BoardSquare {

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    //NOTE: To achieve a better 'encapsulation' of properties in the classes, explicitly set the class 'properties'
    // to be 'private', and added missing accessors (getters and setters) for those properties
    // so that the properties can be accessed by other object via the accessor methods.

    private boolean isChute;
    private boolean isLadder;
    private int numberSquaresToSkip;

    //NOTE: In each class, created a base constructor and set the modifier to be 'public'
    // so that an external class can instantiate this target class.
    public BoardSquare(){
        this(false, false, 0);
    }
    public BoardSquare(boolean isChute, boolean isLadder, int numberSquaresToSkip){
        this.isChute = isChute;
        this.isLadder = isLadder;
        this.numberSquaresToSkip = numberSquaresToSkip;
    }

    //NOTE: the following getters and setters can be also useful for the extensibility and scalability of the application.
    // Often, unit tests can benefit from the 'getters and setters' provided for the properties, to test different use-cases extensively.
    // Also, as the application grows, there arises more use-cases where we need to access the properties via accessor methods.

    public boolean isChute() {
        return isChute;
    }

    public void setChute(boolean chute) {
        isChute = chute;
    }

    public boolean isLadder() {
        return isLadder;
    }

    public void setLadder(boolean ladder) {
        isLadder = ladder;
    }

    public int getNumberSquaresToSkip() {
        if (isLadder) {
            return numberSquaresToSkip;
        } else if (isChute) {
            return numberSquaresToSkip * -1;
        } else {
            return 0;
        }
    }

    public void setNumberSquaresToSkip(int numberSquaresToSkip) {
        this.numberSquaresToSkip = numberSquaresToSkip;
    }

}
