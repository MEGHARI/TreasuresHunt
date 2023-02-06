package org.carbonit.treasurehunt.hexagon.usecase;

import org.carbonit.treasurehunt.hexagon.model.Adventurer;
import org.carbonit.treasurehunt.hexagon.model.Land;
import org.carbonit.treasurehunt.hexagon.model.Position;
import org.carbonit.treasurehunt.hexagon.ports.ITreasuresDataReader;

import java.util.List;

public class AdventureUseCase {

    public ITreasuresDataReader iTreasuresDataReader;
    public AdventureUseCase(Land land) {
        this.land = land;
    }

    private Land land;

    public void lunchMovementsAdventurerInLand(Adventurer adventurer, String movingSequences) {
        land.moveAdventurerInLand(adventurer, movingSequences);
    }

    public void initLandWithMountains(List<Position> mountains) {
        mountains.forEach(land::addMountain);
    }

    public void initLandWithAdventurer(List<Adventurer> adventurers) {
        adventurers.forEach(land::addAdventurer);
    }
}
