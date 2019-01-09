/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import movieapp.BE.Category;

/**
 *
 * @author maxim
 */
public class GenreDAO
{
    ConnectionManager cM = new ConnectionManager();
    
    
    public void addGenre(String name)
        {
            try (Connection con = cM.getConnection()){
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO Genre(Name) VALUES(?)");
            stmt.setString(1, name);
            stmt.executeUpdate();
        }
            catch (SQLException ex) 
        {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void deleteGenre(int id) throws SQLServerException, SQLException
    {
        try (Connection con = cM.getConnection())
        {
        PreparedStatement stmt;
        stmt = con.prepareStatement("DELETE FROM Genre WHERE id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        }
        
        catch (SQLException ex) 
        {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void editGenre(Category genre) 
    {
        try (Connection con = cM.getConnection()) 
    {
            PreparedStatement stmt = con.prepareStatement("UPDATE Genre SET Name = ? WHERE Id = ?");
            stmt.setInt(2, genre.getId());
            stmt.setString(1, genre.getGenre());
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Category> getAllGenre() {
        
        List<Category> categorys = new ArrayList();
      
        try (Connection con = cM.getConnection()){
            PreparedStatement stmt;
            stmt = con.prepareStatement("SELECT * FROM Genre");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Category currentCategory = new Category();
                currentCategory.setId(rs.getInt("id"));
                currentCategory.setGenre(rs.getString("name"));
                categorys.add(currentCategory);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return categorys;
    }
    }
