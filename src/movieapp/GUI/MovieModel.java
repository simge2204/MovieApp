/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import movieapp.BE.Category;
import movieapp.BE.Movie;
import movieapp.BLL.BLLManager;

/**
 *
 * @author simge
 */
public class MovieModel
    {
    private BLLManager bllManager = new BLLManager();
    private ObservableList<Movie> movies = FXCollections.observableArrayList();
    
    public ObservableList<Movie> getMovies()
        {
        return movies;
        }
    public void loadMovies() throws SQLException
    {
        List<Movie> loadedMovies = bllManager.getAllMovies();
        
        movies.clear();
        movies.addAll(loadedMovies);
    }
    public void loadMovies(String search) throws SQLException
    {
        List<Movie> loadedMovies = bllManager.getAllMovies(search);
        
        movies.clear();
        movies.addAll(loadedMovies);
    }
    public void addMovie(String title, float imdb, float rating, Date lastview, String path) throws SQLException
        {
        bllManager.addMovie(title, imdb, rating, lastview, path);
        }
    public void deleteMovie(int id) throws SQLException
        {
        bllManager.deleteMovie(id);
        }
    public void editMovie(Movie movie)
        {
        bllManager.editMovie(movie);
        }
    public void loadMoviesFromGenre(Category selectedGenre)
    {
        List<Movie> loadedMovies = bllManager.getMoviesFromCategory(selectedGenre);
        
        movies.clear();
        movies.addAll(loadedMovies);
    }
    public void loadMoviesFromGenre(Category selectedGenre1, Category selectedGenre2)
    {
        List<Movie> loadedMovies = bllManager.getMoviesFromCategory(selectedGenre1, selectedGenre2);
        
        movies.clear();
        movies.addAll(loadedMovies);
    }
    public void loadMoviesFromGenre(Category selectedGenre3, Category selectedGenre4, Category selectedGenre5) throws SQLException
    {
        List<Movie> loadedMovies = bllManager.getMoviesFromCategory(selectedGenre3, selectedGenre4, selectedGenre5);
        
        movies.clear();
        movies.addAll(loadedMovies);
    }
    public void IMDBSearch(float IMDB) throws SQLException
    {
        List<Movie> loadedMovies = bllManager.IMDBSearch(IMDB);
        
        movies.clear();
        movies.addAll(loadedMovies);
    }
    public void editDate(Movie movie)
    {
        bllManager.editDate(movie);
    }
    }
