/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.search;
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
    @FXML
    private Button IMDBsøg;
    @FXML
    private TextField IMDBsøgefelt;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        JOptionPane.showMessageDialog(frame, "Remember to delete Movies you haven't watch in a long time, especially those with a low score to save space on your PC.");
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
        movieModel.loadMovies(søgefelt.getText());
        filmfelt.setItems(movieModel.getMovies());
        
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
    private void playMovie() throws IOException, SQLException
        {
        //Runtime.getRuntime().exec("C:/Program Files/Windows Media Player/wmplayer.exe");
        Desktop desk = Desktop.getDesktop();
        Movie selectedMovie = filmfelt.getSelectionModel().getSelectedItem();
        File movieFile = new File(selectedMovie.getPath());
        Date currentDate = new Date(System.currentTimeMillis());
        selectedMovie.setLastView(currentDate);
        movieModel.editDate(selectedMovie);
        if(movieFile.exists()) {
            if(desk.isSupported(Desktop.Action.OPEN));
             try {Desktop.getDesktop().open(movieFile);
             } catch (IOException e)
             { e.printStackTrace(); }
        }
        reload();
        }


    @FXML
    private void reset(ActionEvent event) throws SQLException
    {
        reload();
        søgefelt.setText("");
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
    private void genreSøge(ActionEvent event) throws SQLException
    {
        int selectedCategories = genrefelt.getSelectionModel().getSelectedItems().size();
        switch (selectedCategories) {
            case 1:
                Category selectedCategory = genrefelt.getSelectionModel().getSelectedItem();
                filmfelt.setItems(movieModel.getMovies());
                movieModel.loadMoviesFromGenre(selectedCategory);
                break;
            case 2:
                Category selectedCategory1 = genrefelt.getSelectionModel().getSelectedItems().get(0);
                Category selectedCategory2 = genrefelt.getSelectionModel().getSelectedItems().get(1);
                filmfelt.setItems(movieModel.getMovies());
                movieModel.loadMoviesFromGenre(selectedCategory1, selectedCategory2);
                break;
            case 3:
                Category selectedCategory3 = genrefelt.getSelectionModel().getSelectedItems().get(0);
                Category selectedCategory4 = genrefelt.getSelectionModel().getSelectedItems().get(1);
                Category selectedCategory5 = genrefelt.getSelectionModel().getSelectedItems().get(2);
                filmfelt.setItems(movieModel.getMovies());
                movieModel.loadMoviesFromGenre(selectedCategory3, selectedCategory4, selectedCategory5);
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR MESSAGE!");
                alert.setHeaderText("You have encountered an error!");
                alert.setContentText("Please select between 1 to 3 Categories at a time before searching!");
                alert.showAndWait();
        }
    }
    
    @FXML
    private void setOnMouseClicked(MouseEvent event) {
            genrefelt.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);         
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
        reload();
    }

    @FXML
    private void IMDBsøg(ActionEvent event) throws SQLException
    {
        Float IMDB = Float.parseFloat(IMDBsøgefelt.getText());
        movieModel.IMDBSearch(IMDB);
        
    }
    
}
