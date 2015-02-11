/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.objects;

import java.util.Random;

/**
 *
 * @author IMAC
 */
public class Enemy extends LifeObject implements Hitable, HitMaker {
private int attakPower;
    public Enemy(int lvl, int strength, int agility) {
        super(lvl, strength, agility);

    }

    public int getDamage() {
        int damage = getStrength() * 2 + getLvl();
        return damage;
    }

  

    @Override
    public void makeHit(Hitable hero) {
        
        if (criticalChanse() == true) {
            attakPower = getDamage() * 3 + getLvl();
            System.out.println("Hero get Critical hit !!!!! " + attakPower + "!!!");
        }else{
            attakPower = getDamage();
        }

        hero.takeHit(attakPower);

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
