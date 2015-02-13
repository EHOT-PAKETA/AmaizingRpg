/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.test;

import java.io.IOException;
import java.util.Scanner;
import ru.enot.game.main.GameCycleManager;
import ru.enot.game.objects.Enemy;
import ru.enot.game.objects.Hero;
import ru.enot.game.objects.utils.HeroFactory;
import ru.enot.game.objects.utils.HeroType;
import static ru.enot.game.objects.utils.HeroType.*;

/**
 *
 * @author IMAC
 */
public class GameTest {

    public static void main(String[] agrs) throws IOException, ClassNotFoundException {

        GameCycleManager gameManager = new GameCycleManager();
       gameManager.startGame();

//       test();
    }

    private static void test() {
        HeroFactory create = new HeroFactory();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Hero name: ");
        String heroName = in.nextLine();
        System.out.print("Enter Hero type (1 - WARRIOR / 2 - ROGUE): ");
        int heroType = in.nextInt();
        HeroType choosedType = null;
        if (heroType == 1) {
            choosedType = WARRIOR;
        } else if (heroType == 2) {
            choosedType = ROGUE;
        }

        for (int i = 0; i < 10; i++) {

            Hero hero = create.createNewHero(choosedType, heroName);
            Enemy enemy = new Enemy(1, 20, 11);
            hero.setAgility(hero.getAgility() + i);
            hero.setStrength(hero.getStrength() + i);
            enemy.setAgility(hero.getAgility() + i);
            enemy.setStrength(hero.getStrength() + i);
            System.out.println("Name of Hero: " + hero.getName());
            System.out.println("Class of Hero: " + choosedType);
            System.out.println("Strenght: " + hero.getStrength());
            System.out.println("Agility: " + hero.getAgility());
            System.out.println("Hero lvl: " + hero.getLvl());
            System.out.println("Hero damage: " + hero.getDamage());
            System.out.println();
            System.out.println("Hero life: " + hero.getLife());
            System.out.println("Enemy life: " + enemy.getLife());
            for (int j = 0; j < 10; j++) {
                if (enemy.isDead() == false && hero.isDead() == false) {
                    System.out.println();
                    System.out.println("Hero strikes .. ");
                    hero.makeHit(enemy);
                    System.out.println();
                    System.out.println("Hero life: " + hero.getLife());
                    System.out.println("Enemy life: " + enemy.getLife());

                }

                if (hero.isDead() == false && enemy.isDead() == false) {
                    System.out.println();
                    System.out.println("Enemy strikes.. ");
                    enemy.makeHit(hero);
                    System.out.println();
                    System.out.println("Hero life: " + hero.getLife());
                    System.out.println("Enemy life: " + enemy.getLife());

                } else if (hero.isDead() == false && enemy.isDead() == true) {
                    hero.setExperience(100 * i);
                    System.out.println("Enemy is dead!");
                    System.out.println("You get 100 experience!");
                    break;
                } else if (hero.isDead() == true && enemy.isDead() == false) {
                    System.out.println("HERO IS DEAD! YOU LOSE!");
                    break;

                }
            }
            if (hero.isDead() == true) {
                break;
            }
            System.out.print("Try Again? (1 - yes / 2 - no):");
            int again = in.nextInt();
            if (again == 1) {

            } else {
                break;
            }

        }
    }
}
