package com.priceline.chutes.entity;

import com.priceline.chutes.entity.BoardSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Board {

    //NOTE: Created an 'entity' package to better organize the classes.
    // The package 'entity' archives all supporting entity classes, while the main class 'Game' remains at the root directory.

    //NOTE: To achieve a better 'encapsulation' of properties in the classes, explicitly set the class 'properties'
    // to be 'private', and added missing accessors (getters and setters) for those properties
    // so that the properties can be accessed by other object via the accessor methods.

    private Map<Integer, BoardSquare> specialSquares = Map.ofEntries(
            entry(1, new BoardSquare(false, true, 37)),
            entry(4, new BoardSquare(false, true, 10)),
            entry(9, new BoardSquare(false, true, 22)),
            entry(16, new BoardSquare(true, false, 10)),
            entry(21, new BoardSquare(false, true, 21)),
            entry(28, new BoardSquare(false, true, 56)),
            entry(36, new BoardSquare(false, true, 8)),
            entry(47, new BoardSquare(true, false, 21)),
            entry(49, new BoardSquare(true, false, 38)),
            entry(51, new BoardSquare(false, true, 16)),
            entry(56, new BoardSquare(true, false, 3)),
            entry(62, new BoardSquare(true, false, 43)),
            entry(64, new BoardSquare(true, false, 4)),
            entry(71, new BoardSquare(false, true, 20)),
            entry(80, new BoardSquare(false, true, 20)),
            entry(87, new BoardSquare(true, false, 63)),
            entry (93, new BoardSquare(true, false, 20)),
            entry(95, new BoardSquare(true, false, 20)),
            entry(98, new BoardSquare(true, false, 20))
    );

    private List<BoardSquare> squares;

    //NOTE: In each class, created a base constructor and set the modifier to be 'public'
    // so that an external class can instantiate this target class.
    public Board() {
        squares = java.util.stream.IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Optional
                        .ofNullable(specialSquares.get(i))
                        .orElseGet(BoardSquare::new))
                .collect(Collectors.toList());
    }

    //NOTE: changed the modifier scope to 'public'.
    public BoardSquare getSquareAtPosition(int i){
        return squares.get(i-1);
    }

    //NOTE: getters and setters of class properties can be useful for the extensibility and scalability of the application.
    // Often, 'unit tests' can benefit from the 'getters and setters' provided for the properties, to test different use-cases extensively.
    // Also, as the application grows, there arises more use-cases where we need to access the properties via accessor methods.

    //NOTE: In order to maintain 'immutability', when we send a list to an external entity,
    // we need to wrap the existing list with a new 'ArrayList' once again and send a 'copy' of it, not to send the original list as a reference.
    public List<BoardSquare> getSquares() {
        return new ArrayList<>(squares); //NOTE: for immutability, we need to return a new copy of the existing list object, not the list itself.
    }

    //NOTE: We will not have/allow a 'setSquares()' method, because we want to lock the squares once it's made.

}
