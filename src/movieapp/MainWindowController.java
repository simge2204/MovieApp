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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 *
 * @author kedde
 */
public class MainWindowController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button søge;
    @FXML
    private TextField søgefelt;
    @FXML
    private TableColumn<?, ?> genre;
    @FXML
    private TableColumn<?, ?> title;
    @FXML
    private TableColumn<?, ?> myRating;
    @FXML
    private TableColumn<?, ?> imdbRating;
    @FXML
    private TableColumn<?, ?> lastview;
    @FXML
    private Button AddMovie;
    @FXML
    private Button RemoveMovie;
    @FXML
    private Button EditMovie;
    @FXML
    private Button Reset;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchForMovie(ActionEvent event)
    {
    }

    @FXML
    private void addMovie(ActionEvent event)
    {
    }

    @FXML
    private void removeMovie(ActionEvent event)
    {
    }

    @FXML
    private void editMovie(ActionEvent event)
    {
    }

    @FXML
    private void reset(ActionEvent event)
    {
    }
    
}
