/**
 *
 * @author EHOT-PAKETA
 */
package ru.enot.game.graphics;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMainClass extends Application {

    Stage stage;
    Parent root;
    Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        scene = new Scene(root);
        this.stage = stage;
        stage.setScene(scene);
        stage.show();

    }
public static void main(String[] args) {
        launch(args);
    }

}
