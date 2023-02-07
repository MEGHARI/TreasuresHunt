package org.carbonit.treasurehunt.hexagon.usecase;

import org.carbonit.treasurehunt.hexagon.model.Adventurer;
import org.carbonit.treasurehunt.hexagon.model.Land;
import org.carbonit.treasurehunt.hexagon.model.Position;
import org.carbonit.treasurehunt.hexagon.ports.primary.IFleWriterResult;
import org.carbonit.treasurehunt.hexagon.ports.secondary.ITreasuresDataReader;
import java.util.List;

public class AdventureUseCase implements IFleWriterResult {

    private ITreasuresDataReader treasuresDataReader;
    private Land land;
    private List<Adventurer> adventurers;
    private List<Position> mountains;

    public AdventureUseCase(ITreasuresDataReader treasuresDataReader) {
        this.treasuresDataReader = treasuresDataReader;
        this.land = treasuresDataReader.getLand();
        this.adventurers = treasuresDataReader.getAdventurers();
        this.mountains = treasuresDataReader.getMountains();
    }
    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    @Override
    public List<Position> getMountains() {
        return mountains;
    }

    @Override
    public void lunchMovementsAdventurerInLand() {
        for (int i = 0; i < adventurers.size(); i++) {
            land.moveAdventurerInLand(adventurers.get(i), treasuresDataReader.getAdventurersMovementSequences().get(i));
        }
    }

    @Override
    public void initLandWithMountains() {
        mountains.forEach(land::addMountain);
    }

    @Override
    public void initLandWithAdventurer() {
        adventurers.forEach(land::addAdventurer);
    }

    @Override
    public void initLandWithTreasure() {
        treasuresDataReader.getCellsWithTreasure().forEach(cell ->
                land.getCells()[cell.getPosition().getX()][cell.getPosition().getY()] = cell
        );
    }
    @Override
    public Land getLand() {
        return land;
    }
}
