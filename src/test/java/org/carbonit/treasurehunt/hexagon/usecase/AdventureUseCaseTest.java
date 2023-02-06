package org.carbonit.treasurehunt.hexagon.usecase;

import org.carbonit.treasurehunt.hexagon.model.Adventurer;
import org.carbonit.treasurehunt.hexagon.model.Land;
import org.carbonit.treasurehunt.hexagon.model.Orientation;
import org.carbonit.treasurehunt.hexagon.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AdventureUseCaseTest {


    @Test
    void shouldMoveAdventurerLaraToCellOfPosition1_3AfterMoving() {
        //Given
        String lara = "Lara";
        int positionX = 0;
        int positionY = 0;
        final Land land = new Land(3, 4);
        Adventurer laraAdventure = new Adventurer(lara, new Position(positionX, positionY), Orientation.SOUTH);

        Position positionFinal = new Position(1, 3);
        AdventureUseCase adventureUseCase = new AdventureUseCase(land);
        // When
        land.addAdventurer(laraAdventure);
        adventureUseCase.lunchMovementsAdventurerInLand(laraAdventure,"AAGADA");
        //Then
        Assertions.assertFalse(land.getCells()[1][3].isFree());
        Assertions.assertTrue(land.getCells()[0][0].isFree());
        Assertions.assertEquals(laraAdventure.getPosition(), positionFinal);
    }

    @Test
    void shouldMoveAdventurerLaraToCellOfPosition1_2AfterMoving() {
        //Given
        String lara = "Lara";
        int positionX = 0;
        int positionY = 0;
        final Land land = new Land(3, 3);
        Adventurer laraAdventure = new Adventurer(lara, new Position(positionX, positionY), Orientation.SOUTH);

        Position positionFinal = new Position(1, 2);
        AdventureUseCase adventureUseCase = new AdventureUseCase(land);
        // When
        land.addAdventurer(laraAdventure);
        adventureUseCase.lunchMovementsAdventurerInLand(laraAdventure, "AAGADA");
        //Then
        Assertions.assertFalse(land.getCells()[1][2].isFree());
        Assertions.assertTrue(land.getCells()[0][0].isFree());
        Assertions.assertEquals(laraAdventure.getPosition(), positionFinal);

    }

    @Test
    void shouldMoveAdventurerLaraToCellOfPosition0_2WithMountainAt1_2() {
        //Given
        String lara = "Lara";
        int positionX = 0;
        int positionY = 0;
        final Land land = new Land(3, 3);
        Adventurer laraAdventure = new Adventurer(lara, new Position(positionX, positionY), Orientation.SOUTH);
        Position mountain = new Position(1, 2);
        Position positionFinal = new Position(0, 2);
        AdventureUseCase adventureUseCase = new AdventureUseCase(land);
        // When
        land.addMountain(mountain);
        land.addAdventurer(laraAdventure);
        adventureUseCase.lunchMovementsAdventurerInLand(laraAdventure, "AAGADA");
        //Then
        Assertions.assertFalse(land.getCells()[1][2].isFree());
        Assertions.assertTrue(land.getCells()[0][0].isFree());
        Assertions.assertFalse(land.getCells()[0][2].isFree());
        Assertions.assertEquals(laraAdventure.getPosition(), positionFinal);

    }

    @Test
    void shouldMoveAdventurerLaraToCellOfPosition0_2WithMountainAt1_2AndConsumeOneTreasureAt0_1() {
        //Given
        String lara = "Lara";
        int positionX = 0;
        int positionY = 0;
        final Land land = new Land(3, 3);
        Adventurer laraAdventure = new Adventurer(lara, new Position(positionX, positionY), Orientation.SOUTH);
        Position mountain = new Position(1, 2);
        AdventureUseCase adventureUseCase = new AdventureUseCase(land);
        // When
        land.addMountain(mountain);
        land.addAdventurer(laraAdventure);
        land.getCells()[0][1].setTreasure(2);
        adventureUseCase.lunchMovementsAdventurerInLand(laraAdventure, "AAGADA");
        //Then
        Assertions.assertEquals(laraAdventure.getTreasure(),1);
        Assertions.assertEquals(land.getCells()[0][1].getTreasure(),1);

    }

    @Test
    void shouldIndianaConsumeThreeTreasuresWhenMovingToCellOfPosition0_3WithFirstMountainAt1_0AndSecondMountainAt2_1() {
        //Given
        String lara = "Indiana";
        int positionX = 1;
        int positionY = 1;
        final Land land = new Land(3, 4);
        Adventurer laraAdventure = new Adventurer(lara, new Position(positionX, positionY), Orientation.SOUTH);
        Position firstMountain = new Position(1, 0);
        Position secondMountain = new Position(2, 1);
        AdventureUseCase adventureUseCase = new AdventureUseCase(land);
        // When
        land.addMountain(firstMountain);
        land.addMountain(secondMountain);
        land.addAdventurer(laraAdventure);
        land.getCells()[0][3].setTreasure(2);
        land.getCells()[1][3].setTreasure(3);
        adventureUseCase.lunchMovementsAdventurerInLand(laraAdventure, "AADADAGGA");
        //Then
        Assertions.assertEquals(laraAdventure.getPosition(), new Position(0, 3));
        Assertions.assertEquals(laraAdventure.getTreasure(), 3);
        Assertions.assertEquals(land.getCells()[0][3].getTreasure(), 0);
        Assertions.assertEquals(land.getCells()[1][3].getTreasure(), 2);

    }

    @Test
    void shouldInitAllLandWithAllMountains() {
        // GIVEN
        Position firstMountain = new Position(1, 0);
        Position secondMountain = new Position(2, 1);
        List<Position> mountains = List.of(firstMountain, secondMountain);
        Land land = new Land(3, 4);
        // WHEN
        AdventureUseCase adventureUseCase = new AdventureUseCase(land);
        adventureUseCase.initLandWithMountains(mountains);
        // THEN
        Assertions.assertFalse(land.getCells()[1][0].isFree());
        Assertions.assertFalse(land.getCells()[2][1].isFree());
    }

    @Test
    void shouldInitAllLandWithAllUsers() {
        // GIVEN
        Adventurer laraAdventure = new Adventurer("Lara", new Position(1, 3), Orientation.SOUTH);
        Adventurer bobAdventure = new Adventurer("Bob", new Position(0, 3), Orientation.SOUTH);
        List<Adventurer> adventurers = List.of(laraAdventure,bobAdventure);
        Land land = new Land(3, 4);
        // WHEN
        AdventureUseCase adventureUseCase = new AdventureUseCase(land);
        adventureUseCase.initLandWithAdventurer(adventurers);
        // THEN
        Assertions.assertFalse(land.getCells()[1][3].isFree());
        Assertions.assertFalse(land.getCells()[0][3].isFree());
    }


}
