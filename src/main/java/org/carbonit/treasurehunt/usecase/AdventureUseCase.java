package org.carbonit.treasurehunt.usecase;

import org.carbonit.treasurehunt.model.Adventurer;
import org.carbonit.treasurehunt.model.Land;

public class AdventureUseCase {


    public AdventureUseCase(Land land) {
        this.land = land;
    }

    private Land land;

    public void lunchMovementsAdventurerInLand(Adventurer adventurer, String movingSequences) {
        movingWithSequences(adventurer, movingSequences);
    }

    private void movingWithSequences(Adventurer adventurer, String movingSequences) {
        land.moveAdventurerInLand(adventurer, movingSequences);
    }

}
