package org.carbonit.treasurehunt.adapter;

import org.carbonit.treasurehunt.hexagon.model.*;
import org.carbonit.treasurehunt.hexagon.ports.ITreasuresDataReader;

import java.util.List;

public class ThirdTreasureDataReaderStub implements ITreasuresDataReader {


    @Override
    public Land getLand() {
        return new Land(3,3);
    }

    @Override
    public List<Position> getMountains() {
        return List.of(new Position(1,2));
    }

    @Override
    public List<Adventurer> getAdventurers() {
        return List.of(new Adventurer("Lara",new Position(0,0), Orientation.SOUTH));
    }

    @Override
    public List<Cell> getCellsWithTreasure() {
        return List.of(new Cell(true,new Position(0,3),2), new Cell(true,new Position(1,3),3));
    }

    @Override
    public List<String> getAdventurersMovementSequences() {
        return List.of("AAGADA");
    }
}
