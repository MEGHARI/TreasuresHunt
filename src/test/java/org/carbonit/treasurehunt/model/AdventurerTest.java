package org.carbonit.treasurehunt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdventurerTest {

    Adventurer adventurer;

    @Test
    void shouldInitAdventurerWithOrientation() {

        // GIVEN
        String orientation = "S";

         // WHEN
        adventurer = new Adventurer("Lara",new Position(1,3),orientation);
        // THEN
        Assertions.assertEquals(orientation,adventurer.getOrientation());
    }



}
