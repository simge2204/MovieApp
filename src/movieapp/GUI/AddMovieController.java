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
import javafx.scene.control.Label;
import movieapp.BE.Movie;
import movieapp.BLL.BLLManager;

/**
 * FXML Controller class
 *
 * @author maxim
 */
public class AddMovieController implements Initializable
{
    private Movie selectedMovie;
    private MovieModel movieModel = new MovieModel();
    private BLLManager bllManager = new BLLManager();
    MainWindowController mainWindowController = new MainWindowController();
    private int type = 1;
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
    @FXML
    private Label TxtField;

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
                movieModel.addMovie(Title, Imdb, MyRating, Lastview, path);
                break;
            case 2:
                selectedMovie.setName(Title);
                selectedMovie.setIMDBRating(Imdb);
                selectedMovie.setPersonalRating(MyRating);
                selectedMovie.setLastView(Lastview);
                selectedMovie.setPath(path);
                movieModel.editMovie(selectedMovie);
//                bllManager.editMovie(selectedMovie);
                break;
            default:
                System.out.println("Something went wrong");
                stage.close();
                break;
       }
        
//        mainWindowController.reload();
        stage.close();
    }
    
    public void setMovieModel(MovieModel movieModel)
        {
        this.movieModel = movieModel;  
        
        }
    
    public void setMainWindowController(MainWindowController mainWindowController) 
        {
        this.mainWindowController = mainWindowController;
        }

    public void setEdit() throws SQLException
        {
        type = 2;
        }

    public void setNew()
        {
        type = 1;
        }
    public void setMovie(Movie selectedMovie)
        {
        this.selectedMovie = selectedMovie;
        TitleField.setText(selectedMovie.getName());
        ImdbField.setText(String.valueOf(selectedMovie.getIMDBRating()));
        MyRatingField.setText(String.valueOf(selectedMovie.getPersonalRating()));
        LastviewField.setText(String.valueOf(selectedMovie.getLastView()));
        PathField.setText(selectedMovie.getPath());
        }


    @FXML
    private void close(ActionEvent event)
    {
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickbtnChoose(ActionEvent event)
        {
        }
}
