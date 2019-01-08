/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.BLL;

import movieapp.DAL.DAO;

/**
 *
 * @author simge
 */
public class BLLManager
    {
    DAO DAO = new DAO();
    
    public void addMovie(String name)
        {
        DAO.addMovie(name);
        }
    }
