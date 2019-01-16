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
    public void addMovie(String title, float imdb, float rating, String lastview, String path) throws SQLServerException, SQLException
        {
            try (Connection con = cM.getConnection()){
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO Movie(Title, IMDB, Rating, LastView, Path) VALUES(?,?,?,?,?)");
            stmt.setString(1, title);
            stmt.setFloat(2, imdb);
            stmt.setFloat(3, rating);
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
        stmt = con.prepareStatement("DELETE FROM Relations WHERE MovieId = ?; DELETE FROM Movie WHERE id = ?");
        stmt.setInt(1, id);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        }
        
        catch (SQLException ex) 
        {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
public void editMovie(Movie movie) 
    {
        try (Connection con = cM.getConnection()) 
    {
            PreparedStatement stmt = con.prepareStatement("UPDATE Movie SET Title=?, IMDB=?, Rating=?, LastView=?, Path=? WHERE Id=?");
            stmt.setInt(6, movie.getId());
            stmt.setString(1, movie.getName());
            stmt.setFloat(2, movie.getIMDBRating());
            stmt.setFloat(3, movie.getPersonalRating());
//            stmt.setString(4, movie.getLastView());
            stmt.setString(5, movie.getPath());
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<Movie> getAllMovies(String search) 
    {
        
        List<Movie> movies = new ArrayList();
      
        try (Connection con = cM.getConnection())
        {
            PreparedStatement stmt;
            stmt = con.prepareStatement("SELECT * FROM Movie WHERE Title like ?");
            stmt.setString(1, "%"+search+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Movie currentMovie = new Movie();
                currentMovie.setId(rs.getInt("Id"));
                currentMovie.setName(rs.getString("Title"));
                currentMovie.setIMDBRating(rs.getFloat("IMDB"));
                currentMovie.setPersonalRating(rs.getFloat("Rating"));
                currentMovie.setLastView(rs.getString("LastView"));
                currentMovie.setPath(rs.getString("Path"));
                movies.add(currentMovie);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return movies;
    }
    public List<Movie> getAllMovies() 
    {
        return getAllMovies("");
    
    }
    public List<Movie> searchMovies(String search)
    {
        return null;
    }
    
    public List<Movie> getMoviesFromCategory(Category selectedGenre) {
       List<Movie> movies = new ArrayList();
       try (Connection con = cM.getConnection()){
           PreparedStatement stmt;
           stmt = con.prepareStatement("SELECT * FROM Movie WHERE ID IN(SELECT MovieId FROM Relations WHERE GenreId = ? )");
           stmt.setInt(1, selectedGenre.getId());
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()) {
               Movie currentMovie = new Movie();
               currentMovie.setId(rs.getInt("Id"));
               currentMovie.setName(rs.getString("Title"));
               currentMovie.setPersonalRating(rs.getFloat("Rating"));
               currentMovie.setIMDBRating(rs.getFloat("IMDB"));
               currentMovie.setPath(rs.getString("Path"));
               currentMovie.setLastView(rs.getString("LastView")); 
               movies.add(currentMovie);
           }
           
       } catch (SQLServerException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   return movies;
   }
   
   public List<Movie> getMoviesFromCategory(Category selectedGenre1, Category selectedGenre2)  {
       List<Movie> movies = new ArrayList();
       try (Connection con = cM.getConnection()) {
           
           PreparedStatement stmt;
           stmt = con.prepareStatement("SELECT * FROM Movie WHERE ID IN (SELECT MovieId FROM Relations WHERE GenreId = ? or GenreId = ? )");
           stmt.setInt(1, selectedGenre1.getId());
           stmt.setInt(2, selectedGenre2.getId());
           
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()) {
               Movie currentMovie = new Movie();
               currentMovie.setId(rs.getInt("Id"));
               currentMovie.setName(rs.getString("Title"));
               currentMovie.setPersonalRating(rs.getFloat("Rating"));
               currentMovie.setIMDBRating(rs.getFloat("IMDB"));
               currentMovie.setPath(rs.getString("Path"));
               currentMovie.setLastView(rs.getString("LastView")); 
               movies.add(currentMovie);
           }
           
       } catch (SQLServerException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   return movies;
   }
   
   public List<Movie> getMoviesFromCategory(Category selectedGenre3, Category selectedGenre4, Category selectedGenre5) throws SQLException, SQLException, SQLException {
       List<Movie> movies = new ArrayList();
       try (Connection con = cM.getConnection()) {
           
           PreparedStatement stmt;
           stmt = con.prepareStatement("Select * From Movie where ID in (SELECT MovieId FROM Relations WHERE GenreId = ? OR GenreId = ? OR GenreId = ? )");
           stmt.setInt(1, selectedGenre3.getId());
           stmt.setInt(2, selectedGenre4.getId());
           stmt.setInt(3, selectedGenre5.getId());
           
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()) {
               Movie currentMovie = new Movie();
               currentMovie.setId(rs.getInt("Id"));
               currentMovie.setName(rs.getString("Title"));
               currentMovie.setPersonalRating(rs.getFloat("Rating"));
               currentMovie.setIMDBRating(rs.getFloat("IMDB"));
               currentMovie.setPath(rs.getString("Path"));
               currentMovie.setLastView(rs.getString("LastView")); 
               movies.add(currentMovie);
           }
           
       } catch (SQLServerException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   return movies;
   }
}

