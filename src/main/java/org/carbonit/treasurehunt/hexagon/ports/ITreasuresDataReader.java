package org.carbonit.treasurehunt.hexagon.ports;

import org.carbonit.treasurehunt.hexagon.model.Adventurer;
import org.carbonit.treasurehunt.hexagon.model.Cell;
import org.carbonit.treasurehunt.hexagon.model.Land;
import org.carbonit.treasurehunt.hexagon.model.Position;

import java.util.List;

public interface ITreasuresDataReader {
    Land getLand();

    List<Position> getMountains();

    List<Adventurer> getAdventurers();

    List<Cell> getCellsWithTreasure();

    List<String> getAdventurersMovementSequences();

}
