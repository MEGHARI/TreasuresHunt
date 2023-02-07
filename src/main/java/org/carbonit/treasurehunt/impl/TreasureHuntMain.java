package org.carbonit.treasurehunt.impl;

import org.carbonit.treasurehunt.adapters.primary.WriterFileResult;
import org.carbonit.treasurehunt.adapters.secondary.TreasureDataReader;
import org.carbonit.treasurehunt.hexagon.ports.primary.IFleWriterResult;
import org.carbonit.treasurehunt.hexagon.ports.secondary.ITreasuresDataReader;
import org.carbonit.treasurehunt.hexagon.usecase.AdventureUseCase;

public class TreasureHuntMain {

    private static final String pathFileEntry = "C:/Users/ameghari/Documents/TreasureHuntEntry.txt";
    private static final String pathFileResult = "C:/Users/ameghari/Documents/TreasureHuntResult.txt";

    public static void main(String... args) {
        ITreasuresDataReader dataReader = new TreasureDataReader();
        // Lecture du fichier d'entrée
        dataReader.parseFile(System.getProperty("PATH_ENTRY"));

        IFleWriterResult adventurerUSeCase = new AdventureUseCase(dataReader);
        WriterFileResult writerFileResult = new WriterFileResult(adventurerUSeCase);


        // Initialisation de la carte
        adventurerUSeCase.initLandWithMountains();
        adventurerUSeCase.initLandWithTreasure();
        adventurerUSeCase.initLandWithAdventurer();

        // Lancement de l'aventure
        adventurerUSeCase.lunchMovementsAdventurerInLand();

        // Creation du fichier final
        writerFileResult.wirteResultsInFile(System.getProperty("PATH_RESULT"));


    }
}
