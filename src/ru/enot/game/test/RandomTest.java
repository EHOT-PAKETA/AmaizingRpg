/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author IMAC
 */
public class RandomTest {



    public static void main(String[] agrs) {
        
        
        Scanner in = new Scanner(System.in);
        System.out.print("Введите рандом %: ");
        int randPercent = in.nextInt();

        Random rand = new Random();

        int cicleCount = 100;
        int allTrueAmount = 0;

        for (int i = 0; i < cicleCount; i++) {
            int trueAmount = 0;
            for (int j = 0; j < 100; j++) {

                int rValue = rand.nextInt(100);
                if (rValue < randPercent) {

                    trueAmount++;

                }
            }

            allTrueAmount += trueAmount;
        }
        int chancePercent = allTrueAmount / cicleCount;
        System.out.println("Итоговый рандом: " + chancePercent);
    }

}
