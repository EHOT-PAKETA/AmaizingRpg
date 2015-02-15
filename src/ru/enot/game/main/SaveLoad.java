package ru.enot.game.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import ru.enot.game.objects.Hero;
import ru.enot.game.resources.ConsoleGameIO;
import ru.enot.game.resources.GameIO;

/**
 *
 * @author IMAC
 */
public class SaveLoad {

    static final Path SAVE_FILE_PATH = Paths.get("C:\\AMAIZING RPG\\savedata");

    private GameIO gameIO;
    private int choise;
    private ArrayList<String> savedFilesList;
    private DirectoryStream<Path> savedFiles;

    public SaveLoad() {
        gameIO = new ConsoleGameIO();
    }

    public void saveCharacter(Hero hero, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_PATH + "\\" + fileName + ".save"))) {
            oos.writeObject(hero);
        }
    }

    public Hero loadCharacter(Hero hero) throws IOException, ClassNotFoundException {
        
        gameIO.cleanMessages();
        do {
            savedFiles = Files.newDirectoryStream(SAVE_FILE_PATH, "*.save");
            savedFilesList = new ArrayList<>();
            int i = 0;
            gameIO.printlnMessage("Loading characters....");
            for (Path p : savedFiles) {
                String fileName = p.getFileName().toString();
                fileName = fileName.substring(0, fileName.lastIndexOf(".save"));
                savedFilesList.add(i, fileName);
                gameIO.printlnMessage("[" + (i + 1) + "] - " + savedFilesList.get(i));
                i++;
            }
            if (savedFilesList.isEmpty()) {
                gameIO.printlnMessage("Sorry... No character to load!");
                gameIO.printlnMessage("Try to start new game.");
                System.exit(0);
            }
            gameIO.printMessage("Enter your choise: ");
            choise = gameIO.readInt();
            if (choise < 1 || choise > savedFilesList.size()) {
                gameIO.cleanMessages();
                gameIO.printlnMessage("Error! Available choise from 1 to " + savedFilesList.size() + "!");
                gameIO.printlnMessage("Try again ...");
                gameIO.printlnMessage("----------------------------");
            }
        } while (choise < 1 || choise > savedFilesList.size());
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(SAVE_FILE_PATH + "\\" + savedFilesList.get(choise - 1) + ".save"));
        hero = (Hero) oos.readObject();
        return hero;
    }
}
