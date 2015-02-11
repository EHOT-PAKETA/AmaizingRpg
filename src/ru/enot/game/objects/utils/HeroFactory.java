/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.objects.utils;

import ru.enot.game.objects.Hero;

/**
 *
 * @author IMAC
 */
public class HeroFactory {

    private final int DEFAULT_LVL = 1;
    private final int DEFAULT_MAIN_PARAM = 15;
    private final int DEFAULT_NOT_MAIN_PARAM = 10;

    public Hero createNewHero(HeroType type, String name) {

        Hero newHero = null;
        String heroType = "";
        switch (type) {
            case ROGUE:

                newHero = new Hero(DEFAULT_LVL, DEFAULT_NOT_MAIN_PARAM, DEFAULT_MAIN_PARAM);
                heroType = "Rogue";
                break;

            case WARRIOR:

                newHero = new Hero(DEFAULT_LVL, DEFAULT_MAIN_PARAM, DEFAULT_NOT_MAIN_PARAM);
                heroType = "Warrior";
                break;

        }
        newHero.setHeroType(heroType);
        newHero.setName(name);
        return newHero;
    }

}
