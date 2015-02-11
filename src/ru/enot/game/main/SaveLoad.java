package ru.enot.game.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import ru.enot.game.objects.Hero;

/**
 *
 * @author IMAC
 */
public class SaveLoad {

    public SaveLoad() {

    }

    public void saveCharacter(Hero hero, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/AMAIZING RPG/savedata/hero1"));
        oos.writeObject(hero);
        oos.flush();
        oos.close();
    }

    public Hero loadCharacter(Hero hero) throws IOException, ClassNotFoundException {
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("c:/AMAIZING RPG/savedata/hero1"));
        hero = (Hero) oos.readObject();
        return hero;
    }
}
