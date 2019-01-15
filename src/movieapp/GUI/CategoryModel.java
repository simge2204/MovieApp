/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

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
public class CategoryModel
    {
    private BLLManager bllManager = new BLLManager();
    private ObservableList<Category> genres = FXCollections.observableArrayList();
    private ObservableList<Category> genresOnMovie = FXCollections.observableArrayList();
    public ObservableList<Category> getGenres()
        {
        return genres;
        }
    public ObservableList<Category> getGenresOnMovie()
        {
        return genresOnMovie;
        }
    public void loadGenres() throws SQLException
    {
        List<Category> loadedGenres = bllManager.getAllGenre();

        genres.clear();
        genres.addAll(loadedGenres);
    }
    public void newGenre(String name)
        {
        bllManager.newGenre(name);
        }
    public void deleteGenre(int id) throws SQLException
        {
        bllManager.deleteGenre(id);
        }
    public void editGenre(Category genre)
        {
        bllManager.editGenre(genre);
        }
    public void getGenresOnMovie(Movie selectedMovie)
        {
        List<Category> loadedGenres = bllManager.getGenresOnMovie(selectedMovie);

        genresOnMovie.clear();
        genresOnMovie.addAll(loadedGenres);
        }
    public void addGenreToMovie(Category selectedGenre, Movie selectedMovie)
        {
        bllManager.addGenreToMovie(selectedGenre, selectedMovie);
        }
    public void removeGenreFromMovie(Category selectedGenre, Movie selectedMovie)
        {
        bllManager.removeGenreFromMovie(selectedGenre, selectedMovie);
        }
    }
