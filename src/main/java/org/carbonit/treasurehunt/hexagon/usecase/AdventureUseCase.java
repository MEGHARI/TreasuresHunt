package org.carbonit.treasurehunt.hexagon.usecase;

import org.carbonit.treasurehunt.hexagon.model.Adventurer;
import org.carbonit.treasurehunt.hexagon.model.Land;
import org.carbonit.treasurehunt.hexagon.ports.ITreasuresDataReader;
import java.util.List;

public class AdventureUseCase {

    private ITreasuresDataReader treasuresDataReader;
    private Land land;

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    private List<Adventurer> adventurers;


    public AdventureUseCase(ITreasuresDataReader treasuresDataReader) {
        this.treasuresDataReader = treasuresDataReader;
        this.land = treasuresDataReader.getLand();
        adventurers = treasuresDataReader.getAdventurers();
    }

    public void lunchMovementsAdventurerInLand() {
        for (int i = 0; i < adventurers.size(); i++) {
            land.moveAdventurerInLand(adventurers.get(i), treasuresDataReader.getAdventurersMovementSequences().get(i));
        }
    }

    public void initLandWithMountains() {
        treasuresDataReader.getMountains().forEach(land::addMountain);
    }

    public void initLandWithAdventurer() {
        adventurers.forEach(land::addAdventurer);
    }

    public void initLandWithTreasure() {
        treasuresDataReader.getCellsWithTreasure().forEach(cell ->
                land.getCells()[cell.getPosition().getX()][cell.getPosition().getY()] = cell
        );
    }
    public Land getLand() {
        return land;
    }
}
