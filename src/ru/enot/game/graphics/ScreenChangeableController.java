/**
 *
 * @author EHOT-PAKETA
 */
package ru.enot.game.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import ru.enot.game.objects.utils.GameException;

public abstract class ScreenChangeableController {

    public abstract Control getSomeSceneControlElement();

    public void changeScene(String sctreenName) throws GameException {
        Stage stage = (Stage) getSomeSceneControlElement().getScene().getWindow();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(sctreenName));
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException ex) {
            throw new GameException(ex);
        }
    }
}
