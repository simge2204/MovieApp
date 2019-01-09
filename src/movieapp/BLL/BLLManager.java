/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.BLL;

import java.sql.SQLException;
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
    
    public void addMovie(String title, float imdb, float rating, String lastview, String path)
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
    public void addGenre(String name)
        {
        dao.addGenre(name);
        }
    public void deleteGenre(int id) throws SQLException
        {
        dao.deleteGenre(id);
        }
    public void editGenre(Category genre)
        {
        dao.editGenre(genre);
        }
}
