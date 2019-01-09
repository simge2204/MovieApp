/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.BLL;

import movieapp.DAL.MovieDAO;
import movieapp.BE.Movie;

/**
 *
 * @author simge
 */
public class BLLManager
{
    MovieDAO DAO = new MovieDAO();
    
    public void addMovie(String title, float imdb, float rating, String lastview, String path)
        {
        DAO.addMovie(title, imdb, rating, lastview, path);
        }
    
    public void editMovie(Movie movie)
    {
     DAO.editMovie(movie);
    }
}
