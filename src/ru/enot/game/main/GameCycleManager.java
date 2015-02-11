/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.main;

import java.io.*;
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
    private PrintHeroInfo info;

    public GameCycleManager() {
        gameIO = new ConsoleGameIO();
        saveLoad = new SaveLoad();
        create = new HeroFactory();
        info = new PrintHeroInfo();

    }

    public Hero getMyHero() {
        return myHero;
    }

    public void startGame() throws IOException, ClassNotFoundException {
        int choise = 0;
        gameIO.cleanMessages();
        do {
            gameIO.printlnMessage("**** AMAZING RPG******");
            gameIO.printlnMessage("1 - Start new game");
            gameIO.printlnMessage("2 - Load game");
            gameIO.printlnMessage("3 - Exit");
            gameIO.printMessage("Enter your choise: ");

            choise = gameIO.readInt();

            if (choise < 1 || choise > 3) {
                gameIO.cleanMessages();
                gameIO.printlnMessage("Error! Available values: 1, 2 or 3.");
                gameIO.printlnMessage("Try again or exit (3). ");
            }
        } while (choise < 1 || choise > 3);

        int intHeroType = 0;
        HeroType heroType;

        switch (choise) {
            case 1:
                gameIO.cleanMessages();
                gameIO.printMessage("Please enter name of your character: ");
                String name = gameIO.readString();
                gameIO.cleanMessages();
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

                    }
                } while (intHeroType < 1 || intHeroType > 2);

                if (intHeroType == 1) {
                    heroType = WARRIOR;
                } else {
                    heroType = ROGUE;
                }

                this.myHero = create.createNewHero(heroType, name);
                info.PrintHeroInfo(myHero, "created");
                saveLoad.saveCharacter(myHero, name);
                break;
            case 2:
                myHero = saveLoad.loadCharacter(myHero);
                info.PrintHeroInfo(myHero, "loaded");
                break;
            case 3:
                System.exit(0);
                break;

        }

    }

}
