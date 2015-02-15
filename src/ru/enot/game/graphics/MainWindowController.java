/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.graphics;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import ru.enot.game.objects.utils.GameException;

/**
 * FXML Controller class
 *
 * @author IMAC
 */
public class MainWindowController extends ScreenChangeableController implements Initializable {

    @FXML
    Label infoLabel;

//    @FXML
//    public void newGameButton() throws IOException, ClassNotFoundException {
//        startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Scene scene = startButton.getScene();
//                Stage stage = (Stage) startButton.getScene().getWindow();
//                Parent root;
//                try {
//                    root = FXMLLoader.load(getClass().getResource("NewGameWindow.fxml"));
//                    scene = new Scene(root);
//                    stage.setScene(scene);
//                    
//                } catch (IOException ex) {
//                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
//                } 
//            }
//        });
//        
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void startGame(MouseEvent event) {
        try {
            changeScene("NewGameWindow.fxml");
        } catch (GameException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void loadGame(MouseEvent event) {

    }

    @FXML
    public void exitGame(MouseEvent event) {

    }

    @Override
    public Control getSomeSceneControlElement() {
        return infoLabel;
    }

}
