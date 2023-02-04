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

         final int horizontalCellsNumber = 3;
         final int verticalCellsNumber = 4;
         final Land land = new Land(horizontalCellsNumber, verticalCellsNumber);
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY));

         // When
         land.withAdventurer(lara);

         //Then
         Assertions.assertTrue(lara.isConsistentPosition(horizontalCellsNumber, verticalCellsNumber));
     }

     @Test
     void shouldInitLandAndAdventurerWithNewInitialPosition() {
         //Given
         String name = "Lara";
         int positionX = 0;
         int positionY = 2;

         final int horizontalCellsNumber = 3;
         final int verticalCellsNumber = 4;
         final Land land = new Land(horizontalCellsNumber, verticalCellsNumber);
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY));

         // When
         land.withAdventurer(lara);

         //Then
         Assertions.assertTrue(lara.isConsistentPosition(horizontalCellsNumber, verticalCellsNumber));
     }

     @Test
     void shouldInitLandAndAdventurerWithInternalPosition() {
         //Given
         String name = "Lara";
         int positionX = 0;
         int positionY = 2;

         final Land land = new Land(3, 4);
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY));

         // When
         boolean isInside = land.isValidateLocation(lara);

         //Then
         Assertions.assertTrue(isInside);
     }

     @Test
     void shouldInitLandAndAdventurerWithExternalPosition() {
         //Given
         String name = "Lara";
         int positionX = 8;
         int positionY = 5;

         final Land land = new Land(3, 4);
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY));

         // When
         boolean isInside = land.isValidateLocation(lara);

         //Then
         Assertions.assertFalse(isInside);
     }

 }
