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
         String name = "Lara";
         int positionX = 1;
         int positionY = 1;

         final Land land = new Land(3, 4);
         final Adventurer lara = new Adventurer(name, positionX, positionY);

         // When
         land.withAdventurer(lara);

         //Then
         Assertions.assertEquals(lara.position(), new Position(positionX, positionY));
     }

     @Test
     void shouldInitLandAndAdventurerWithNewInitialPosition() {
         //Given
         String name = "Lara";
         int positionX = 0;
         int positionY = 2;

         final Land land = new Land(3, 4);
         final Adventurer lara = new Adventurer(name, positionX, positionY);

         // When
         land.withAdventurer(lara);

         //Then
         Assertions.assertEquals(lara.position(), new Position(positionX, positionY));
     }

     @Test
     void shouldInitLandAndAdventurerWithInternalPosition() {
         //Given
         String name = "Lara";
         int positionX = 0;
         int positionY = 2;

         final Land land = new Land(3, 4);
         final Adventurer lara = new Adventurer(name, positionX, positionY);

         // When
         boolean isInside = land.isInside(lara);

         //Then
         Assertions.assertTrue(isInside);
     }

 }
