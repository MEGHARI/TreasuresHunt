package org.carbonit.treasurehunt.adapters.primary;

import org.carbonit.treasurehunt.hexagon.model.Adventurer;
import org.carbonit.treasurehunt.hexagon.model.Cell;
import org.carbonit.treasurehunt.hexagon.model.Position;
import org.carbonit.treasurehunt.hexagon.ports.primary.IFleWriterResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterFileResult {


    private final String TREASURE_DEFINITION = "# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}";
    private final String ADVENTURER_DEFINITION = "# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}";
    private final String SEPARATOR_FILE = " - ";
    private IFleWriterResult fileResult;

    public WriterFileResult(IFleWriterResult fileResult) {
        this.fileResult = fileResult;
    }

    public void wirteResultsInFile(String fileName) {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));) {
            writer.write("C - " + fileResult.getLand().horizontalCellsNumber + SEPARATOR_FILE + fileResult.getLand().verticalCellsNumber+"\n");
            mountainsWriter(writer);
            treasureWriter(writer);
            adventurerWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void adventurerWriter(BufferedWriter writer) throws IOException {
        if(fileResult.getAdventurers().size() > 0 ){
            writer.write(ADVENTURER_DEFINITION+"\n");
        }
        for (Adventurer adventurer : fileResult.getAdventurers()) {
            writer.write("A - " + adventurer.getName() + SEPARATOR_FILE + adventurer.getPosition().getX() + SEPARATOR_FILE + adventurer.getPosition().getY() + SEPARATOR_FILE + adventurer.getOrientation() + SEPARATOR_FILE + adventurer.getTreasure()+"\n");
        }
    }

    private void treasureWriter(BufferedWriter writer) throws IOException {
        List<Cell> treasures = new ArrayList<>();
        for (int x = 0; x < fileResult.getLand().horizontalCellsNumber; x++) {
            for (int y = 0; y < fileResult.getLand().verticalCellsNumber; y++) {
                if (fileResult.getLand().getCells()[x][y].getTreasure() > 0) {
                    treasures.add(fileResult.getLand().getCells()[x][y]);
                }
            }
        }
        if (treasures.size() > 0) {
            writer.write(TREASURE_DEFINITION+"\n");
            for (Cell treasure : treasures) {
                writer.write("T - " + treasure.getPosition().getX() + SEPARATOR_FILE + treasure.getPosition().getY() + SEPARATOR_FILE + treasure.getTreasure()+"\n");
            }
        }
    }

    private void mountainsWriter(BufferedWriter writer) throws IOException {
        for (Position mountain : fileResult.getMountains()) {
            writer.write("M - " + mountain.getX() + SEPARATOR_FILE + mountain.getY()+"\n");
        }
    }
}
