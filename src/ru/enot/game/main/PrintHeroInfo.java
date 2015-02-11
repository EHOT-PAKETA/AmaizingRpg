package ru.enot.game.main;

import ru.enot.game.objects.Hero;
import ru.enot.game.resources.ConsoleGameIO;
import ru.enot.game.resources.GameIO;

public class PrintHeroInfo {

    private GameIO gameIO;

    public void PrintHeroInfo(Hero hero, String status) {
        gameIO = new ConsoleGameIO();
        gameIO.cleanMessages();
        gameIO.printlnMessage("----------------------------");
        gameIO.printlnMessage("You " + status + " your character!");
        gameIO.printlnMessage("----------------------------");
        gameIO.printlnMessage("Name of your character: " + hero.getName());
        gameIO.printlnMessage("Class of character: " + hero.getHeroType());
        gameIO.printlnMessage("Your character's lvl: " + hero.getLvl());
        gameIO.printlnMessage("----------------------------");
        gameIO.printlnMessage("Your character's stats:");
        gameIO.printlnMessage("----------------------------");
        gameIO.printlnMessage("Strenght: " + hero.getStrength());
        gameIO.printlnMessage("Agility: " + hero.getAgility());
        gameIO.printlnMessage("Damage: " + hero.getDamage());
        gameIO.printlnMessage("----------------------------");

    }

}
