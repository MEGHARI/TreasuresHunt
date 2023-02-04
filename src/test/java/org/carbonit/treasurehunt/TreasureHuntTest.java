package org.carbonit.treasurehunt;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class TreasureHuntTest {

     @Test
     void initTest() {
         Assertions.assertTrue(true);
     }

     @Test
     void shouldInitLandAndAdventurerWithoutMouvements() {
         //Given
         final Land land = new Land(3, 4);
         final Adventurer lara = new Adventurer("Lara", 1, 1);

         // When
         land.withAdventurer(lara);

         //Then
         Assertions.assertEquals(lara.position(), new Position(1, 1));
     }

 }
