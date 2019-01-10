/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
    @FXML
    private Button søge;
    @FXML
    private Label label;
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        title.setCellValueFactory(new PropertyValueFactory("title"));
        imdbRating.setCellValueFactory(new PropertyValueFactory("imdbRating"));
        myRating.setCellValueFactory(new PropertyValueFactory("myRating"));
        lastview.setCellValueFactory(new PropertyValueFactory("lastview"));
        // TODO
    }    

    @FXML
    private void searchForMovie(ActionEvent event)
    {
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
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
//        Parent root4 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        movieapp.GUI.MainWindowController MWController = fxmlLoader.getController();
//        MWController.setMovieModel(movieModel);
//        MWController.setMainWindowController(this);
//        selectedMovie = filmfelt.getSelectionModel().getSelectedItem();
//        MWController.setMovie(selectedMovie);
//        MWController.setPlLabel(selectedPlaylist);
//        stage.setTitle("DeletePlaylist");
//        stage.setScene(new Scene(root4));
//        stage.show();
        movieModel.getMovies().remove(filmfelt.getSelectionModel().getSelectedItem());
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
    
    private void playMovie()
        {
        final JFXPanel VFXPanel = new JFXPanel();

        File video_source = new File("tutorial.mp4");
        Media m = new Media(video_source.toURI().toString());
        MediaPlayer player = new MediaPlayer(m);
        MediaView viewer = new MediaView(player);

        StackPane root = new StackPane();
        Scene scene = new Scene(root);

        // center video position
        javafx.geometry.Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        viewer.setX((screen.getWidth() - filmfelt.getWidth()) / 2);
        viewer.setY((screen.getHeight() - filmfelt.getHeight()) / 2);

        // resize video based on screen size
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);

        // add video to stackpane
        root.getChildren().add(viewer);

        VFXPanel.setScene(scene);
        player.play();
        root = new StackPane();
        root.setAlignment(Pos.CENTER);
//        filmfelt.setLayout(new BorderLayout());
//        filmfelt.add(VFXPanel, BorderLayout.CENTER);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddGenre.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        movieapp.GUI.AddGenreController cpController = fxmlLoader.getController();
        stage.setTitle("AddGenre");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void removeGenre(ActionEvent event)
        {
        }
    
}
