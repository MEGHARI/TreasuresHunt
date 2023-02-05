package org.carbonit.treasurehunt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdventurerTest {

    Adventurer adventurer;

    @Test
    void shouldInitAdventurerWithSouthOrientation() {

        // GIVEN
        Orientation orientation = Orientation.SOUTH;

         // WHEN
        adventurer = new Adventurer("Lara",new Position(1,3),orientation,"");
        // THEN
        Assertions.assertEquals("S",adventurer.getOrientation().getOrientation());
    }

    @Test
    void shouldInitAdventurerWithNorthOrientation() {

        // GIVEN
        Orientation orientation = Orientation.NORTH;

        // WHEN
        adventurer = new Adventurer("Lara",new Position(1,3),orientation,"");
        // THEN
        Assertions.assertEquals("N",adventurer.getOrientation().getOrientation());
    }
    @Test
    void shouldInitAdventurerWithOUESTOrientation() {

        // GIVEN
        Orientation orientation = Orientation.OUEST;

        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation,"");
        // THEN
        Assertions.assertEquals("O", adventurer.getOrientation().getOrientation());
    }

    @Test
    void shouldInitAdventurerWithEastOrientation() {

        // GIVEN
        Orientation orientation = Orientation.EAST;

        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation,"");
        // THEN
        Assertions.assertEquals("E", adventurer.getOrientation().getOrientation());
    }
    @Test
    void shouldTestAdventurerWithSouthOrientationAndWithoutMoving(){

        // GIVEN
        Orientation orientation = Orientation.SOUTH;
        Position position = new Position(1, 3);

        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation,"");
        // THEN
        Assertions.assertEquals("S", adventurer.getOrientation().getOrientation());
        Assertions.assertEquals(position, adventurer.getPosition());

    }

    @Test
    void shouldTestAdventurerWithNorthOrientationAndWithoutMoving(){

        // GIVEN
        Orientation orientation = Orientation.NORTH;
        Position position = new Position(1, 3);

        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "");
        // THEN
        Assertions.assertEquals("N", adventurer.getOrientation().getOrientation());
        Assertions.assertEquals(position, adventurer.getPosition());

    }

    @Test
    void shouldTestAdventurerWithSouthOrientationAndWithOneMovement() {

        // GIVEN
        Orientation orientation = Orientation.SOUTH;
        Position position = new Position(1, 3);
        Position newPositionAfterMoved = new Position(1, 4);
        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "A");
        adventurer.move();
        // THEN
        Assertions.assertEquals("S", adventurer.getOrientation().getOrientation());
        Assertions.assertEquals(newPositionAfterMoved, adventurer.getPosition());

    }

    @Test
    void shouldTestAdventurerWithNorthOrientationAndWithOneMovement() {

        // GIVEN
        Orientation orientation = Orientation.NORTH;
        Position position = new Position(1, 3);
        Position newPositionAfterMoved = new Position(1, 2);
        // WHEN
        adventurer = new Adventurer("Lara", new Position(1, 3), orientation, "A");
        adventurer.move();
        // THEN
        Assertions.assertEquals("N", adventurer.getOrientation().getOrientation());
        Assertions.assertEquals(newPositionAfterMoved, adventurer.getPosition());

    }


}
