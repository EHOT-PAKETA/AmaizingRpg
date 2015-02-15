/**
 *
 * @author EHOT-PAKETA
 */
package ru.enot.game.objects.utils;

public class GameException extends Exception {

    public GameException() {
    }

    public GameException(String string) {
        super(string);
    }

    public GameException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GameException(Throwable thrwbl) {
        super(thrwbl);
    }

    public GameException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
