package org.carbonit.treasurehunt.hexagon.usecase;

import org.carbonit.treasurehunt.adapters.secondary.*;
import org.carbonit.treasurehunt.hexagon.model.Position;
import org.carbonit.treasurehunt.hexagon.ports.secondary.ITreasuresDataReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdventureUseCaseTest {


    @Test
    void shouldMoveAdventurerLaraToCellOfPosition1_3AfterMoving() {
        //Given
        ITreasuresDataReader treasuresDataReader = new FirstTreasureDataReaderStub();
        Position positionFinal = new Position(1, 3);
        AdventureUseCase adventureUseCase = new AdventureUseCase(treasuresDataReader);
        // When
        adventureUseCase.initLandWithAdventurer();
        adventureUseCase.lunchMovementsAdventurerInLand();
        //Then
        Assertions.assertFalse(adventureUseCase.getLand().getCells()[1][3].isFree());
        Assertions.assertTrue(adventureUseCase.getLand().getCells()[0][0].isFree());
        Assertions.assertEquals(adventureUseCase.getAdventurers().get(0).getPosition(), positionFinal);
    }

    @Test
    void shouldMoveAdventurerLaraToCellOfPosition1_2AfterMoving() {
        //Given
        ITreasuresDataReader treasuresDataReader = new SecondTreasureDataReaderStub();
        Position positionFinal = new Position(1, 2);
        AdventureUseCase adventureUseCase = new AdventureUseCase(treasuresDataReader);
        // When
        adventureUseCase.initLandWithAdventurer();
        adventureUseCase.lunchMovementsAdventurerInLand();
        //Then
        Assertions.assertFalse(adventureUseCase.getLand().getCells()[1][2].isFree());
        Assertions.assertTrue(adventureUseCase.getLand().getCells()[0][0].isFree());
        Assertions.assertEquals(adventureUseCase.getAdventurers().get(0).getPosition(), positionFinal);

    }

    @Test
    void shouldMoveAdventurerLaraToCellOfPosition0_2WithMountainAt1_2() {
        //Given
        ITreasuresDataReader treasuresDataReader = new ThirdTreasureDataReaderStub();
        Position positionFinal = new Position(0, 2);
        AdventureUseCase adventureUseCase = new AdventureUseCase(treasuresDataReader);
        // When
        adventureUseCase.initLandWithMountains();
        adventureUseCase.initLandWithAdventurer();
        adventureUseCase.lunchMovementsAdventurerInLand();
        //Then
        Assertions.assertFalse(adventureUseCase.getLand().getCells()[1][2].isFree());
        Assertions.assertTrue(adventureUseCase.getLand().getCells()[0][0].isFree());
        Assertions.assertFalse(adventureUseCase.getLand().getCells()[0][2].isFree());
        Assertions.assertEquals(adventureUseCase.getAdventurers().get(0).getPosition(), positionFinal);

    }

    @Test
    void shouldMoveAdventurerLaraToCellOfPosition0_2WithMountainAt1_2AndConsumeOneTreasureAt0_1() {
        //Given
        ITreasuresDataReader treasuresDataReader = new ForthTreasureDataReaderStub();
        AdventureUseCase adventureUseCase = new AdventureUseCase(treasuresDataReader);
        // When
        adventureUseCase.initLandWithMountains();
        adventureUseCase.initLandWithAdventurer();
        adventureUseCase.initLandWithTreasure();
        adventureUseCase.lunchMovementsAdventurerInLand();
        //Then
        Assertions.assertEquals(adventureUseCase.getAdventurers().get(0).getTreasure(),1);
        Assertions.assertEquals(adventureUseCase.getLand().getCells()[0][1].getTreasure(),1);

    }

    @Test
    void shouldIndianaConsumeThreeTreasuresWhenMovingToCellOfPosition0_3WithFirstMountainAt1_0AndSecondMountainAt2_1() {
        //Given
        ITreasuresDataReader treasuresDataReader = new TreasureDataReaderStub();
        AdventureUseCase adventureUseCase = new AdventureUseCase(treasuresDataReader);
        // When
        adventureUseCase.initLandWithMountains();
        adventureUseCase.initLandWithAdventurer();
        adventureUseCase.initLandWithTreasure();
        adventureUseCase.lunchMovementsAdventurerInLand();
        //Then
        Assertions.assertEquals(adventureUseCase.getAdventurers().get(0).getPosition(), new Position(0, 3));
        Assertions.assertEquals(adventureUseCase.getAdventurers().get(0).getTreasure(), 3);
        Assertions.assertEquals(adventureUseCase.getLand().getCells()[0][3].getTreasure(), 0);
        Assertions.assertEquals(adventureUseCase.getLand().getCells()[1][3].getTreasure(), 2);

    }

}
