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
        adventurer = new Adventurer("Lara",new Position(1,3),orientation);
        // THEN
        Assertions.assertEquals("S",adventurer.getOrientation().getOrientation());
    }



}
