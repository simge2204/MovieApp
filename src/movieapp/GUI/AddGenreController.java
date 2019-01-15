/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import movieapp.BE.Category;
import movieapp.BE.Movie;

/**
 * FXML Controller class
 *
 * @author maxim
 */
public class AddGenreController implements Initializable
{
    movieapp.GUI.CategoryModel categoryModel;
    movieapp.GUI.MainWindowController mainWindowController;
    private Movie selectedMovie;
    private Category selectedGenre;
    int type;
    @FXML
    private Button Close;
    @FXML
    private Button Tilføj;
    @FXML
    private TableView<Category> genreFelt;
    @FXML
    private TableColumn<Category, String> genreName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        genreName.setCellValueFactory(new PropertyValueFactory("genre"));
    }    

    @FXML
    private void close(ActionEvent event)
    {
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void tilføj(ActionEvent event) throws SQLException
    {
        Stage stage = (Stage) Tilføj.getScene().getWindow();
        selectedGenre = genreFelt.getSelectionModel().getSelectedItem();
        switch(type) {
            case 1:
                categoryModel.addGenreToMovie(selectedGenre, selectedMovie);
                stage.close();
                break;
            case 2:
                categoryModel.removeGenreFromMovie(selectedGenre, selectedMovie);
                stage.close();
                break;
            default:
                System.out.println("Something went wrong");
                stage.close();
                break;
        }
    }
    
    public void setCategoryModel(CategoryModel categoryModel)
    {
        this.categoryModel = categoryModel;
    }
    
    public void setMainWindowController(MainWindowController mainWindowControler)
    {
        this.mainWindowController = mainWindowControler;
    }
    
    public void setMovie(Movie selectedMovie)
    {
        this.selectedMovie = selectedMovie;
    }
    
    public void setGenre(Category selectedGenre)
    {
        this.selectedGenre = selectedGenre;
    }
    
    public void setAdd()
    {
        type = 1;
        Tilføj.setText("Tilføj");
    }
    
    public void setRemove()
    {
        type = 2;
        Tilføj.setText("Remove");
    }
    
    public void getGenres(Movie SelectedMovie)
    {
        if(type == 1) {
            categoryModel.getGenres();
            genreFelt.setItems(categoryModel.getGenres());
        }
        else if(type == 2) {
            categoryModel.getGenresOnMovie(selectedMovie);
            genreFelt.setItems(categoryModel.getGenresOnMovie());
        }
    }
}
