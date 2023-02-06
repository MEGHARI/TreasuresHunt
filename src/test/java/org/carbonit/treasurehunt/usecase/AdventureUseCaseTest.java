package org.carbonit.treasurehunt.usecase;

import org.carbonit.treasurehunt.model.Adventurer;
import org.carbonit.treasurehunt.model.Land;
import org.carbonit.treasurehunt.model.Orientation;
import org.carbonit.treasurehunt.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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



}
