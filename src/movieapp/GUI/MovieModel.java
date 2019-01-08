/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import movieapp.BLL.BLLManager;

/**
 *
 * @author simge
 */
public class MovieModel
    {
    private BLLManager bllManager = new BLLManager();
    
    public void addMovie(String title, String imdb, String rating, String lastview, String path)
        {
        bllManager.addMovie(title, imdb, rating, lastview, path);
        }
    public void removeMovie()
        {
        
        }
    public void addRating()
        {
        
        }
    public void editRating()
        {
        
        }
    }
