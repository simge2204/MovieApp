/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.BLL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import movieapp.BE.Category;
import movieapp.DAL.MovieDAO;
import movieapp.BE.Movie;
import movieapp.DAL.GenreDAO;

/**
 *
 * @author simge
 */
public class BLLManager
{
    MovieDAO DAO = new MovieDAO();
    GenreDAO dao = new GenreDAO();
    
    public void addMovie(String title, float imdb, float rating, Date lastview, String path) throws SQLException
        {
        DAO.addMovie(title, imdb, rating, lastview, path);
        }
    public void deleteMovie(int id) throws SQLException
        {
        DAO.deleteMovie(id);
        }
    public void editMovie(Movie movie)
        {
        DAO.editMovie(movie);
        }
    public List<Movie> getAllMovies(String Search) throws SQLServerException, SQLException
        {
        return DAO.getAllMovies(Search);
        }
    public List<Movie> getAllMovies() throws SQLServerException, SQLException
        {
        return DAO.getAllMovies();
        }
    public void newGenre(String name)
        {
        dao.newGenre(name);
        }
    public void deleteGenre(int id) throws SQLException
        {
        dao.deleteGenre(id);
        }
    public void editGenre(Category genre)
        {
        dao.editGenre(genre);
        }
    public List<Category> getAllGenre()
        {
        return dao.getAllGenre();
        }
    public List<Category> getGenresOnMovie(Movie selectedMovie)
    {
        return dao.getGenresOnMovie(selectedMovie);
    }
    public void addGenreToMovie(Category selectedGenre, Movie selectedMovie)
    {
        dao.addGenreToMovie(selectedGenre, selectedMovie);
    }
    public void removeGenreFromMovie(Category selectedGenre, Movie selectedMovie)
    {
        dao.RemoveGenreFromMovie(selectedGenre, selectedMovie);
    }
    public List<Movie> getMoviesFromCategory(Category selectedGenre)
    {
        return DAO.getMoviesFromCategory(selectedGenre);
    }
    public List<Movie> getMoviesFromCategory(Category selectedGenre1, Category selectedGenre2)
    {
        return DAO.getMoviesFromCategory(selectedGenre1, selectedGenre2);
    }
    public List<Movie> getMoviesFromCategory(Category selectedGenre3, Category selectedGenre4, Category selectedGenre5) throws SQLException
    {
        return DAO.getMoviesFromCategory(selectedGenre3, selectedGenre4, selectedGenre5);
    }
    public List<Movie> IMDBSearch(float IMDB) throws SQLException
    {
        return DAO.IMDBSearch(IMDB);
    }
    public void editDate(Movie movie)
    {
        DAO.editDate(movie);
    }
}
