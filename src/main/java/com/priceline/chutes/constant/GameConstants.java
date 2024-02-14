package com.priceline.chutes.constant;

import com.priceline.chutes.conventionalgame.BoardSquare;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public final class GameConstants {
    //NOTE: created this constant class underneath the constant package, and made it 'final' class so that it cannot be modified or inherited.

    //NOTE: the 'private' modifier
    private GameConstants() { //NOTE: explicitly set this no-arg constructor to be 'private', to prevent an external user from instantiating an object of this class.
        super();
    }

    //NOTE: Moved 'specialSquares' in the Board class to the constant class (and set it to be 'public static final'),
    // since this data is fixed and final for the given business rules. Also, refactored the property name to use only
    // the capital letters as it's a constant variable.
    public static final Map<Integer, BoardSquare> SPECIAL_SQUARES = Map.ofEntries(
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

    //NOTE: Moved 'squares' in the Board class to the constant class (and set it to be 'public static final'),
    //  since this data is fixed and final for the given business rules.
    //  Also, refactored the property name to use only the capital letters as it's a constant variable.
    public static final List<BoardSquare> SQUARES = java.util.stream.IntStream.rangeClosed(1, 100)
            .mapToObj(i -> Optional
            .ofNullable(SPECIAL_SQUARES.get(i))
            .orElseGet(BoardSquare::new))
            .collect(Collectors.toList());

    //NOTE: changed the Random private class resource as static, and moved to constant class, since it can be a singleton and be used by many other instances of
    // different games.
    public static final Random RANDOM = new Random();

}
