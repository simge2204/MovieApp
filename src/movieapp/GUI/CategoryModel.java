/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.sql.SQLException;
import movieapp.BE.Category;
import movieapp.BLL.BLLManager;

/**
 *
 * @author simge
 */
public class CategoryModel
    {
    private BLLManager bllManager = new BLLManager();
    
    public void addGenre(String name)
        {
        bllManager.addGenre(name);
        }
    public void deleteGenre(int id) throws SQLException
        {
        bllManager.deleteGenre(id);
        }
    public void editGenre(Category genre)
        {
        bllManager.editGenre(genre);
        }
    }
