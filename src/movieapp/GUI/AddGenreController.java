/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author maxim
 */
public class AddGenreController implements Initializable
{

    @FXML
    private Button Close;
    @FXML
    private Button Tilføj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void close(ActionEvent event)
    {
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void tilføj(ActionEvent event)
    {
    }
    
}
