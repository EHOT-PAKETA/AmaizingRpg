/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.objects;

import java.io.Serializable;
import java.util.Random;


/**
 *
 * @author IMAC
 */
public class Hero extends LifeObject implements HitMaker, Hitable, Serializable {

    private String name;
    private String heroType;
    private int experience;
    private int attakPower;
    

    public Hero(int lvl, int strength, int agility) {
        super(lvl, strength, agility);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;

    }

    public int getDamage() {
        int damage = getStrength() * 2 + getLvl();
        return damage;

    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    @Override
    public void makeHit(Hitable enemy) {

        if (criticalChanse() == true) {
            attakPower = getDamage() * 3 + getLvl();
            System.out.println("ENEMY get Critical hit !!!!! " + attakPower + "!!!");
        }else{
            attakPower = getDamage();
        }

        enemy.takeHit(attakPower);

    }

    @Override

    public boolean takeHit(int damage) {

        if (evadeChanse() == true) {
            System.out.println("HERO EVADED!");
        } else {
            life = (getLife() - damage);
        }
        return evadeChanse();

    }

    private boolean evadeChanse() {
        int evadePercent = getAgility();
        Random rand = new Random();
        int rValue = rand.nextInt(100);
        if (rValue < evadePercent) {
            return true;
        } else {
            return false;
        }
    }

    private boolean criticalChanse() {
        int criticalPercent = getAgility() + getLvl();
        Random rand = new Random();
        int rValue = rand.nextInt(100);
        if (rValue < criticalPercent) {
            return true;
        } else {
            return false;
        }

    }
}
