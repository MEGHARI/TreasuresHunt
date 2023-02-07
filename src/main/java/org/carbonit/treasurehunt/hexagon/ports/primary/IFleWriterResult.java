package org.carbonit.treasurehunt.hexagon.ports.primary;

import org.carbonit.treasurehunt.hexagon.model.Adventurer;
import org.carbonit.treasurehunt.hexagon.model.Land;
import org.carbonit.treasurehunt.hexagon.model.Position;

import java.util.List;

public interface IFleWriterResult {
    Land getLand();

    List<Adventurer> getAdventurers();

    List<Position> getMountains();

    void initLandWithMountains();

    void lunchMovementsAdventurerInLand();

    void initLandWithAdventurer();

    void initLandWithTreasure();
}
