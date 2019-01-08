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
import movieapp.BE.Movie;

/**
 *
 * @author simge
 */
public class MovieDAO
{
    ConnectionManager cM = new ConnectionManager();
    
    /**
     *
     * @param title
     * @param imdb
     * @param rating
     * @param lastview
     * @param path
     * @throws com.microsoft.sqlserver.jdbc.SQLServerException
     */
    public void addMovie(String title, String imdb, String rating, String lastview, String path)
        {
            try (Connection con = cM.getConnection()){
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO Song(Title, IMDB, Rating, LastView, Path) VALUES(?,?,?,?,?)");
            stmt.setString(1, title);
            stmt.setString(2, imdb);
            stmt.setString(3, rating);
            stmt.setString(4, lastview);
            stmt.setString(5, path);
            stmt.executeUpdate();
        }
            catch (SQLException ex) 
        {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void deleteMovie(int id) throws SQLServerException, SQLException
    {
        try (Connection con = cM.getConnection())
        {
        PreparedStatement stmt;
        stmt = con.prepareStatement("DELETE FROM Movie WHERE id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        }
        
        catch (SQLException ex) 
        {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
//    public void editMovie(Movie movie) 
//    {
//        try (Connection con = cM.getConnection()) 
//    {
//            PreparedStatement stmt = con.prepareStatement("UPDATE Song SET name=?, artist=?, genre=?, length=?, path=? WHERE id=?");
//            stmt.setInt(6, movie.getId());
//            stmt.setString(1, movie.getTitle());
//            stmt.setString(2, movie.getArtist());
//            stmt.setString(3, movie.getGenre());
//            stmt.setString(4, movie.getTime());
//            stmt.setString(5, movie.getPath());
//            stmt.executeUpdate();
//        }
//        catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}

