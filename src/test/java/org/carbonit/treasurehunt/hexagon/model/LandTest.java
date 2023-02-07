package org.carbonit.treasurehunt.hexagon.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class LandTest {

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
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY), Orientation.S);

         // When
         land.addAdventurer(lara);

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
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY), Orientation.S);

         // When
         land.addAdventurer(lara);

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
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY), Orientation.S);

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
         final Adventurer lara = new Adventurer(name, new Position(positionX, positionY), Orientation.S);

         // When
         boolean isInside = land.isValidateLocation(lara);

         //Then
         Assertions.assertFalse(isInside);
     }

     @Test
     void shouldInitLandAndCheckIfAdventurerInitialPositionIsAvailable() {
         //Given
         String name = "Lara";
         int positionX = 2;
         int positionY = 2;
         final Land land = new Land(3, 4);
         Adventurer lara = new Adventurer(name, new Position(positionX, positionY), Orientation.S);

         // When
         boolean isConsistent = land.isValidateLocation(lara);
         //Then
         Assertions.assertTrue(isConsistent);
     }

     @Test
     void shouldInitLandAndTryInsertingTwoAdventurerInSamePosition() {

         //Given
         String lara = "Lara";
         String bob = "Bob";
         int positionX = 2;
         int positionY = 2;
         final Land land = new Land(3, 4);
         Adventurer laraAdventure = new Adventurer(lara, new Position(positionX, positionY), Orientation.S);
         Adventurer bobAdventure = new Adventurer(bob, new Position(positionX, positionY), Orientation.S);

         // When
         land.addAdventurer(laraAdventure);
         boolean isConsistent = land.isValidateLocation(bobAdventure);

         //Then
         Assertions.assertFalse(isConsistent);
     }

     @Test
     void shouldInitLandWithMountainAt1_2() {
         //Given
         int positionX = 1;
         int positionY = 2;
         Position mountain = new Position(positionX,positionY);
         final int horizontalCellsNumber = 3;
         final int verticalCellsNumber = 4;
         final Land land = new Land(horizontalCellsNumber, verticalCellsNumber);

         // When
         land.addMountain(mountain);

         //Then
         Assertions.assertFalse(land.getCells()[mountain.getX()][mountain.getY()].isFree());
     }

     @Test
     void shouldInitLandWithMountainAt1_2AndAdventurerAt2_2() {
         //Given
         int mountainPositionX = 1;
         int mountainPositionY = 2;
         int adventurerPositionX = 2;
         int adventurerPositionY = 2;
         Position mountain = new Position(mountainPositionX,mountainPositionY);
         Adventurer lara = new Adventurer("Lara",new Position(adventurerPositionX,adventurerPositionY),Orientation.S);
         final int horizontalCellsNumber = 3;
         final int verticalCellsNumber = 4;
         final Land land = new Land(horizontalCellsNumber, verticalCellsNumber);

         // When
         land.addMountain(mountain);
         land.addAdventurer(lara);
         //Then
         Assertions.assertFalse(land.getCells()[mountain.getX()][mountain.getY()].isFree());
         Assertions.assertFalse(land.getCells()[lara.getPosition().getX()][lara.getPosition().getY()].isFree());
     }




 }
