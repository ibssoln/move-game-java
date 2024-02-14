package com.priceline.chutes.util;

public class Utility {

    //NOTE: Created a util package and Utility class to store a static non-state functions to be used as helper methods.

    //NOTE: the 'private' modifier
    private Utility() { //NOTE: explicitly set this no-arg constructor to be 'private', to prevent an external user from instantiating an object of this class.
        super();
    }

    public static void print(Object o){
        System.out.println(o);
    }

}
