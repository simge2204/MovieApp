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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import java.sql.SQLException;
import movieapp.BE.Movie;
import movieapp.BLL.BLLManager;

/**
 * FXML Controller class
 *
 * @author maxim
 */
public class AddMovieController implements Initializable
{
    private Movie selectedMovie
    private BLLManager bllManager = new BLLManager();
    @FXML
    private Button AddMovieBtn;
    @FXML
    private Button Close;
    @FXML
    private TextField TitleField;
    @FXML
    private TextField LastviewField;
    @FXML
    private TextField PathField;
    @FXML
    private TextField MyRatingField;
    @FXML
    private TextField ImdbField;

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
        String Title=TitleField.getText();
        Float Imdb=Float.parseFloat(ImdbField.getText());
        Float MyRating=Float.parseFloat(MyRatingField.getText());
        String Lastview=LastviewField.getText();
        String path=PathField.getText();
        Stage stage = (Stage) AddMovieBtn.getScene().getWindow();
        switch (type) 
        {
            case 1:
                Movie.addMovie(Title, Imdb, MyRating, Lastview, path);
                break;
            case 2:
                selectedMovie.setName(Title);
                selectedMovie.setIMDBRating(Imdb);
                selectedMovie.setPersonalRating(MyRating);
//                selectedMovie.set(Lastview);
//                selectedMovie.set(path);
                bllManager.editMovie(selectedMovie);
                break;
            default:
                System.out.println("Something went wrong");
                stage.close();
                break;
       }
        
//        mainWindowController.reload();
        stage.close();
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
