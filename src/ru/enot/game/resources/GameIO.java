/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.resources;

/**
 *
 * @author IMAC
 */
public interface GameIO {

    public void printlnMessage(String messge);
    
    public void printMessage(String messge);
    
    public String readString ();
    
    public int readInt();
    
    public void cleanMessages();
}
