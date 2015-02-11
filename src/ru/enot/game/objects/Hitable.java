/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.objects;

/**
 *
 * @author IMAC
 */
public interface Hitable {

    /**
     *
     * @param damage
     * @return попал или промазал
     */
    public boolean takeHit(int damage);

}
