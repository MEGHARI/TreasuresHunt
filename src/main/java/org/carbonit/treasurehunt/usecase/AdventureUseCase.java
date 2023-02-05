package org.carbonit.treasurehunt.usecase;

import org.carbonit.treasurehunt.model.Adventurer;
import org.carbonit.treasurehunt.model.Land;
import org.carbonit.treasurehunt.model.Position;

public class AdventureUseCase {


    public AdventureUseCase(Land land) {
        this.land = land;
    }

    private Land land;

    public void lunchMovementsAdventurerInLand(Adventurer adventure, Land land) {
        Position oldPositionOfAdventurer = new Position(adventure.getPosition().getX(),adventure.getPosition().getY());
        land.addAdventurer(adventure);
        adventure.move();
        if(!adventure.getPosition().equals(oldPositionOfAdventurer)){
            land.getCells()[adventure.getPosition().getX()][adventure.getPosition().getY()].setFree(false);
            land.getCells()[oldPositionOfAdventurer.getX()][oldPositionOfAdventurer.getY()].setFree(false);
        }
    }
}
