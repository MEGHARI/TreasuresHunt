package org.carbonit.treasurehunt.adapters.secondary;

import org.carbonit.treasurehunt.hexagon.model.*;
import org.carbonit.treasurehunt.hexagon.ports.secondary.ITreasuresDataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TreasureDataReader implements ITreasuresDataReader {

    private final String ADVENTURER_PREFIX = "A";
    private final String REGEX_SEPARATOR = " - ";
    private String LAND_PREFIX = "C";
    private String Mountain_PREFIX = "M";
    private final String TREASURE_PREFIX = "T";
    private List<Position> mountains = new ArrayList<>();
    private List<Adventurer> adventurers = new ArrayList<>();
    private List<Cell> cellsWithTreasures = new ArrayList<>();
    private List<String> adventurersMovementSequences = new ArrayList<>();
    private Land land;

    @Override
    public Land getLand() {
        return this.land;
    }

    @Override
    public List<Position> getMountains() {
        return mountains;
    }

    @Override
    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    @Override
    public List<Cell> getCellsWithTreasure() {
        return cellsWithTreasures;
    }

    @Override
    public List<String> getAdventurersMovementSequences() {
        return adventurersMovementSequences;
    }

    public void parseFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName)).filter(line -> !line.startsWith("#"))) {
            stream.forEach(this::parseLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void parseLine(String line) {
        if (line.startsWith(LAND_PREFIX)) {
            int horizontalCellsNumber = Integer.parseInt(line.split(REGEX_SEPARATOR)[1]);
            int verticalCellsNumber = Integer.parseInt(line.split(REGEX_SEPARATOR)[2]);
            this.land = new Land(horizontalCellsNumber, verticalCellsNumber);
        } else if (line.startsWith(Mountain_PREFIX)) {
            int mountainPositionX = Integer.parseInt(line.split(REGEX_SEPARATOR)[1]);
            int mountainPositionY = Integer.parseInt(line.split(REGEX_SEPARATOR)[2]);
            mountains.add(new Position(mountainPositionX, mountainPositionY));
        } else if (line.startsWith(TREASURE_PREFIX)) {
            int treasurePositionX = Integer.parseInt(line.split(REGEX_SEPARATOR)[1]);
            int treasurePositionY = Integer.parseInt(line.split(REGEX_SEPARATOR)[2]);
            int treasure = Integer.parseInt(line.split(REGEX_SEPARATOR)[3]);
            cellsWithTreasures.add(new Cell(true, new Position(treasurePositionX, treasurePositionY), treasure));
        } else if (line.startsWith(ADVENTURER_PREFIX)) {
            String adventurerName = line.split(REGEX_SEPARATOR)[1];
            int adventurerPositionX = Integer.parseInt(line.split(REGEX_SEPARATOR)[2]);
            int adventurerPositionY = Integer.parseInt(line.split(REGEX_SEPARATOR)[3]);
            Orientation adventurerOrientation = Orientation.valueOf(line.split(REGEX_SEPARATOR)[4]);
            String movementSequences = line.split(REGEX_SEPARATOR)[5];
            adventurers.add(new Adventurer(adventurerName, new Position(adventurerPositionX, adventurerPositionY), adventurerOrientation));
            adventurersMovementSequences.add(movementSequences);

        }
    }
}

