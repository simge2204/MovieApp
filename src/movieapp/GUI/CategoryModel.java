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
import movieapp.BLL.BLLManager;

/**
 *
 * @author simge
 */
public class CategoryModel
    {
    private BLLManager bllManager = new BLLManager();
    private ObservableList<Category> genres = FXCollections.observableArrayList();
    
    public ObservableList<Category> getGenres()
        {
        return genres;
        }
    public void loadGenres() throws SQLException
    {
        List<Category> loadedGenres = bllManager.getAllGenre();

        genres.clear();
        genres.addAll(loadedGenres);
    }
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
