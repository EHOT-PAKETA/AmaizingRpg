package ru.enot.game.main;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import jdk.internal.org.objectweb.asm.Opcodes;
import static ru.enot.game.main.SaveLoad.SAVE_FILE_PATH;

import ru.enot.game.objects.Hero;
import ru.enot.game.resources.ConsoleGameIO;
import ru.enot.game.resources.GameIO;
import ru.enot.game.objects.utils.HeroFactory;
import ru.enot.game.objects.utils.HeroType;
import static ru.enot.game.objects.utils.HeroType.*;

/**
 *
 * @author IMAC
 */
public class GameCycleManager implements Serializable {

    private Hero myHero;
    private GameIO gameIO;
    private SaveLoad saveLoad;
    private HeroFactory create;
    private PrintInfo info;
    private String name;
    private int choise;
    

    public GameCycleManager() {
        gameIO = new ConsoleGameIO();
        saveLoad = new SaveLoad();
        create = new HeroFactory();
        info = new PrintInfo();

    }

    public Hero getMyHero() {
        return myHero;
    }

    public void startGame() throws IOException, ClassNotFoundException {
        choise = 0;
        gameIO.cleanMessages();
        do {
            info.printStartGameInfo();
            choise = gameIO.readInt();
            if (choise < 1 || choise > 3) {
                gameIO.cleanMessages();
                gameIO.printlnMessage("Error! Available values: 1, 2 or 3.");
                gameIO.printlnMessage("Try again or exit (3). ");
                gameIO.printlnMessage("----------------------------");
            }
        } while (choise < 1 || choise > 3);

        int intHeroType = 0;
       
        HeroType heroType;
      
        switch (choise) {
            case 1:
                gameIO.cleanMessages();
                int loadOrCreate = 0;
                do {
                    gameIO.printMessage("Please enter name of your character: ");
                    name = gameIO.readString();
                    Set<String> existCharacters = new HashSet<>();
                    DirectoryStream<Path> savedFiles = Files.newDirectoryStream(SAVE_FILE_PATH, "*.save");
                    for (Path p : savedFiles) {
                        String fileName = p.getFileName().toString();
                        fileName = fileName.substring(0, fileName.lastIndexOf(".save"));
                        existCharacters.add(fileName);
                    }
                    if (existCharacters.contains(name)) {
                        gameIO.cleanMessages();
                        do {
                            gameIO.printlnMessage("Your character already exist...");
                            gameIO.printlnMessage("Do you wat load your character or try again?");
                            gameIO.printlnMessage("[1] - Try to load your character.");
                            gameIO.printlnMessage("[2] - Try to create new character.");
                            gameIO.printMessage("Your choise: ");
                            loadOrCreate = gameIO.readInt();

                            if (loadOrCreate < 1 || loadOrCreate > 2) {
                                gameIO.cleanMessages();
                                gameIO.printlnMessage("Error! Available choise is  1 or 2..");
                                gameIO.printlnMessage("Try again ...");
                                gameIO.printlnMessage("----------------------------");

                            }

                        } while (loadOrCreate < 1 || loadOrCreate > 2);
                    }

                } while (loadOrCreate == 2);
                gameIO.cleanMessages();

                if (loadOrCreate == 1) {
                    myHero = saveLoad.loadCharacter(myHero);
                info.printHeroInfo(myHero, "loaded");
                break;
                    
                }
                

                do {

                    gameIO.printlnMessage("Please choose type of your character.");
                    gameIO.printlnMessage("1 - Warrior.");
                    gameIO.printlnMessage("2 - Rogue.");
                    gameIO.printMessage("Your choise: ");
                    intHeroType = gameIO.readInt();
                    if (intHeroType < 1 || intHeroType > 2) {
                        gameIO.cleanMessages();
                        gameIO.printlnMessage("Error! Available choise is  1 or 2..");
                        gameIO.printlnMessage("Try again ...");
                        gameIO.printlnMessage("----------------------------");

                    }
                } while (intHeroType < 1 || intHeroType > 2);

                if (intHeroType == 1) {
                    heroType = WARRIOR;
                } else {
                    heroType = ROGUE;
                }

                this.myHero = create.createNewHero(heroType, name);
                info.printHeroInfo(myHero, "created");
                saveLoad.saveCharacter(myHero, name);
                break;

            case 2:

                myHero = saveLoad.loadCharacter(myHero);
                info.printHeroInfo(myHero, "loaded");
                break;
            case 3:
                System.exit(0);
                break;

        }

    }

}
