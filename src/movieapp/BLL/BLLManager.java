/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.BLL;

import movieapp.DAL.MovieDAO;

/**
 *
 * @author simge
 */
public class BLLManager
    {
    MovieDAO DAO = new MovieDAO();
    
    public void addMovie(String title, String imdb, String rating, String lastview, String path)
        {
        DAO.addMovie(title, imdb, rating, lastview, path);
        }
    }
