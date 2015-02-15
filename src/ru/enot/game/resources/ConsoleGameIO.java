/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.enot.game.graphics.NewGameWindowController;

/**
 *
 * @author IMAC
 */
public class ConsoleGameIO implements GameIO {

    private Scanner scanner;
    

    public ConsoleGameIO() {
        scanner = new Scanner(System.in);
        
    }

    @Override
    public void printlnMessage(String messge) {
       //NewGameWindowController.label.setText(messge);
        System.out.println(messge);
    }

    @Override
    public void printMessage(String messge) {
        System.out.print(messge);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        boolean error;
        int value = 0;
        do {
            error = false;
            try {
                String inputString = scanner.nextLine();
                value = Integer.parseInt(inputString);

            } catch (NumberFormatException ex) {
                error = true;
                System.out.print("Please enter a number: ");
            }
        } while (error);
        return value;
    }

    @Override
    public void cleanMessages() {

        for (int i = 0; i < 30; ++i) {
            System.out.println();
        }
    }

}
