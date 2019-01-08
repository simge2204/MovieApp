/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            stmt = con.prepareStatement("INSERT INTO Song(Name) VALUES(?)");
            stmt.setString(1, name);
            stmt.executeUpdate();
        }
            catch (SQLException ex) 
        {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void deleteMovie(int id) throws SQLServerException, SQLException
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
    }
