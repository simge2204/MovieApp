/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.sql.SQLException;
import movieapp.BE.Movie;
import movieapp.BLL.BLLManager;

/**
 *
 * @author simge
 */
public class MovieModel
    {
    private BLLManager bllManager = new BLLManager();
    
    public void addMovie(String title, float imdb, float rating, String lastview, String path)
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
    public void addRating()
        {
        
        }
    public void editRating()
        {
        
        }
    }
