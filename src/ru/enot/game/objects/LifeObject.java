/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.objects;

import java.io.Serializable;

/**
 *
 * @author IMAC
 */
class LifeObject implements Hitable, Serializable {

    int life;
    private int lvl;
    private int strength;
    private int agility;

    public LifeObject(int lvl, int strength, int agility) {
        this.lvl = lvl;
        this.strength = strength;
        this.agility = agility;
        this.life = getMaxLife();
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public final int getMaxLife() {
        return strength * 10;
    }

    public final boolean isDead() {

        return life <= 0;

    }

    public int getLvl() {
        return lvl;
    }

    @Override
    public boolean takeHit(int damage) {
        return false;

    }

}
