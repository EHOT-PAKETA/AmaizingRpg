/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.game.graphics;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javax.swing.JOptionPane;
import ru.enot.game.main.GameCycleManager;

/**
 * FXML Controller class
 *
 * @author IMAC
 */
public class NewGameWindowController implements Initializable {
    GameCycleManager gameManager = new GameCycleManager();

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public Label label;
    public Pane pane;
  public TextFlow tf;
 
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
       label.setText("123");
    
        
        
     
     
    }    
//    public static void getText(){
//        label.setText(text);
//    }
    
}
