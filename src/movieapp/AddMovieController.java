/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author maxim
 */
public class AddMovieController implements Initializable
{

    @FXML
    private Button AddMovie;
    @FXML
    private Button Close;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void addMovie(ActionEvent event)
    {
    }

    @FXML
    private void clickbtnChoose(ActionEvent event)
    {
    }

    @FXML
    private void close(ActionEvent event)
    {
        System.exit(0);
    }
    
}
