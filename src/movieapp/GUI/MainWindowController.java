/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import movieapp.BE.Category;
import movieapp.BE.Movie;
import movieapp.BLL.BLLManager;
import movieapp.DAL.MovieDAO;

/**
 * FXML Controller class
 *
 * @author maxim
 */
public class MainWindowController implements Initializable
{
    private Movie selectedMovie;
    private MovieModel movieModel = new MovieModel();
    private BLLManager bllManager = new BLLManager();
    private CategoryModel categoryModel = new CategoryModel();
    private MovieDAO movieDAO = new MovieDAO();
    private Component frame;
    @FXML
    private Button søge;
    @FXML
    private Label label;
    @FXML
    private TableColumn<Category, String> genre;
    @FXML
    private TableColumn<Movie, String> title;
    @FXML
    private TableColumn<Movie, String> myRating;
    @FXML
    private TableColumn<Movie, String> imdbRating;
    @FXML
    private TableColumn<Movie, String> lastview;
    @FXML
    private TextField søgefelt;
    @FXML
    private Button AddMovie;
    @FXML
    private Button RemoveMovie;
    @FXML
    private Button EditMovie;
    @FXML
    private Button Reset;
    @FXML
    private Button Close;
    @FXML
    private Button AddGenre;
    @FXML
    private TableView<Movie> filmfelt;
    @FXML
    private Button RemoveGenre;
    @FXML
    private TableView<Category> genrefelt;
    @FXML
    private Button play;
    @FXML
    private Button genreSøge;
    @FXML
    private Button NyGenre;
    @FXML
    private Label genreController;
    @FXML
    private Button DeleteGenreBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        JOptionPane.showMessageDialog(frame, "Remember to delete Movies you haven't watch in a long time, especially those with a low score to safe space on your PC.");
        title.setCellValueFactory(new PropertyValueFactory("name"));
        imdbRating.setCellValueFactory(new PropertyValueFactory("IMDBRating"));
        myRating.setCellValueFactory(new PropertyValueFactory("personalRating"));
        lastview.setCellValueFactory(new PropertyValueFactory("lastView"));
        genre.setCellValueFactory(new PropertyValueFactory("genre"));
        try {
            reload();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

 @FXML
    private void searchForMovie(ActionEvent event)throws SQLException 
    {
        reload();
    }
    
    public void reload() throws SQLException 
    {
        selectedMovie = filmfelt.getSelectionModel().getSelectedItem();
        filmfelt.setItems(movieModel.getMovies());
        movieModel.loadMovies(søgefelt.getText());
        //if(selectedMovie!=null)
        //{
            genrefelt.setItems(categoryModel.getGenres());
            categoryModel.loadGenres();
        //}
        filmfelt.setItems(movieModel.getMovies());
        movieModel.loadMovies();
        filmfelt.getSelectionModel().select(selectedMovie);
    }
    
    @FXML
    private void addMovie(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMovie.fxml"));
        Parent root2 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        movieapp.GUI.AddMovieController cpController = fxmlLoader.getController();
        cpController.setMovieModel(movieModel);
        cpController.setMainWindowController(this);
        cpController.setNew();
        stage.setTitle("AddMovie");
        stage.setScene(new Scene(root2));
        stage.show();
    }

    @FXML
    private void removeMovie(ActionEvent event) throws IOException, SQLException
    {
        movieDAO.deleteMovie(selectedMovie.getId());
        reload();
    }

    @FXML
    private void editMovie(ActionEvent event) throws IOException, SQLException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMovie.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        movieapp.GUI.AddMovieController cpController = fxmlLoader.getController();
        cpController.setMovieModel(movieModel);
        cpController.setMainWindowController(this);
        cpController.setEdit();
        selectedMovie = filmfelt.getSelectionModel().getSelectedItem();
        cpController.setMovie(selectedMovie);
        stage.setTitle("EditPlaylist");
        stage.setScene(new Scene(root2));
        stage.show();
    }
    
    @FXML
    private void playMovie() throws IOException
        {
        File video_source = new File("");
        Media m = new Media(video_source.toURI().toString());
        MediaPlayer player = new MediaPlayer(m);
        MediaView viewer = new MediaView(player);
        selectedMovie = filmfelt.getSelectionModel().getSelectedItem();
        Runtime.getRuntime().exec("cmd /c start/wmplayer.exe");
        Runtime.getRuntime().exec("cmd /c start/ file.bat");
        Process p = Runtime.getRuntime().exec("cmd /c start/Program Files/Windows Media Player/wmplayer.exe");
//        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        player.play();
        viewer.getMediaPlayer().play();
        }


    @FXML
    private void reset(ActionEvent event)
    {
    }

    @FXML
    private void close(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML
    private void addGenre(ActionEvent event) throws IOException
    {
        Movie selectedMovie = filmfelt.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddGenre.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        movieapp.GUI.AddGenreController agController = fxmlLoader.getController();
        agController.setMainWindowController(this);
        agController.setCategoryModel(categoryModel);
        agController.setMovie(selectedMovie);
        agController.setAdd();
        agController.getGenres(selectedMovie);
        stage.setTitle("Add Genre To Movie");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void removeGenre(ActionEvent event) throws IOException
        {
            Movie selectedMovie = filmfelt.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddGenre.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        movieapp.GUI.AddGenreController agController = fxmlLoader.getController();
        agController.setMainWindowController(this);
        agController.setCategoryModel(categoryModel);
        agController.setMovie(selectedMovie);
        agController.setRemove();
        agController.getGenres(selectedMovie);
        stage.setTitle("Remove Genre From Movie");
        stage.setScene(new Scene(root1));
        stage.show();
        }

    @FXML
    private void genreSøge(ActionEvent event)
    {
    }

    @FXML
    private void NyGenre(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewEditGenre.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        movieapp.GUI.NewEditGenreController negController = fxmlLoader.getController();
        negController.setMainWindowController(this);
        negController.setCategoryModel(categoryModel);
        negController.setNew();
        stage.setTitle("New Genre");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    
    @FXML
    private void editGenre(ActionEvent event) throws IOException
    {
        Category selectedGenre = genrefelt.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewEditGenre.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        movieapp.GUI.NewEditGenreController negController = fxmlLoader.getController();
        negController.setMainWindowController(this);
        negController.setCategoryModel(categoryModel);
        negController.setEdit(selectedGenre);
        negController.setGenre(selectedGenre);
        stage.setTitle("Edit Genre");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void deleteGenre(ActionEvent event) throws SQLException {
        bllManager.deleteGenre(genrefelt.getSelectionModel().getSelectedItem().getId());
    }
    
}
