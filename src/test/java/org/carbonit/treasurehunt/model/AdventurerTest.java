package org.carbonit.treasurehunt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdventurerTest {

    Adventurer adventurer;


    @Test
    void shouldTestAdventurerWithNorthOrientationAndWithoutMoving(){

        // GIVEN
        Orientation orientation = Orientation.NORTH;
        Position position = new Position(1, 3);

        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "");
        // THEN
        Assertions.assertEquals(position, adventurer.getPosition());

    }

    @Test
    void shouldTestAdventurerWithSouthOrientationAndWithOneMovement() {

        // GIVEN
        Orientation orientation = Orientation.SOUTH;
        Position newPositionAfterMoved = new Position(1, 4);
        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "A");
        adventurer.move();
        // THEN
        Assertions.assertEquals(newPositionAfterMoved, adventurer.getPosition());

    }

    @Test
    void shouldTestAdventurerWithNorthOrientationAndWithOneMovement() {

        // GIVEN
        Orientation orientation = Orientation.NORTH;
        Position newPositionAfterMoved = new Position(1, 2);
        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "A");
        adventurer.move();
        // THEN
        Assertions.assertEquals(newPositionAfterMoved, adventurer.getPosition());

    }

    @Test
    void shouldTestAdventurerWithOuestOrientationAndWithOneMovement() {

        // GIVEN
        Orientation orientation = Orientation.WEST;
        Position newPositionAfterMoved = new Position(0, 3);
        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "A");
        adventurer.move();
        // THEN
        Assertions.assertEquals(newPositionAfterMoved, adventurer.getPosition());

    }

    @Test
    void shouldTestAdventurerWithEastOrientationAndWithOneMovement() {

        // GIVEN
        Orientation orientation = Orientation.EAST;
        Position newPositionAfterMoved = new Position(2, 3);
        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "A");
        adventurer.move();
        // THEN
        Assertions.assertEquals(newPositionAfterMoved, adventurer.getPosition());

    }

    @Test
    void shouldNotMovingWhenModifyOnlyOrientation() {

        // GIVEN
        Orientation orientation = Orientation.SOUTH;
        Position position = new Position(1, 3);
        // WHEN
        adventurer = new Adventurer("Lara", position, orientation, "G");
        adventurer.move();
        // THEN
        Assertions.assertEquals(position, adventurer.getPosition());

    }

    @Test
    void shouldModifyPositionAfterProgressAndChangingOrientationToEAST() {

        // GIVEN
        Orientation orientation = Orientation.SOUTH;
        Position position = new Position(1, 3);
        Position newPosition = new Position(2, 3);
        // WHEN
        adventurer = new Adventurer("Lara", position, orientation, "GA");
        adventurer.move();
        // THEN
        Assertions.assertEquals(newPosition, adventurer.getPosition());

    }

    @Test
    void shouldModifyPositionAfterProgressAndChangingOrientationToWEST() {

        // GIVEN
        Orientation orientation = Orientation.SOUTH;
        Position position = new Position(1, 3);
        Position newPosition = new Position(0, 3);
        // WHEN
        adventurer = new Adventurer("Lara", position, orientation, "DA");
        adventurer.move();
        // THEN
        Assertions.assertEquals(newPosition, adventurer.getPosition());

    }

}
