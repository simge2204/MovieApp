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
    
    public void addMovie(String name)
        {
        bllManager.addMovie(name);
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
