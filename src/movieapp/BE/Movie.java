/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.BE;

/**
 *
 * @author simge
 */
public class Movie
    {
    private int id;
    private String title;
    private int IMDBRating;
    private int personalRating;
    private int lastView;
    private String path;
    
    public Movie()
        {
        
        }
    public int getId()
        {
        return id;
        }
    public void setId(int id)
        {
        this.id = id;
        }
    public String getName()
        {
        return title;
        }
    public void setName(String title)
        {
        this.title = title;
        }
    public int getIMDBRating()
        {
        return IMDBRating;
        }
    public void setIMDBRating(int IMDBRating)
        {
        this.IMDBRating = IMDBRating;
        }
    public int getPersonalRating()
        {
        return personalRating;
        }
    public void setPersonalRating(int personalRating)
        {
        this.personalRating = personalRating;
        }
    public int getLastView()
        {
        return lastView;
        }
    public void setLastView(int lastView)
        {
        this.lastView = lastView;
        }
    public String getPath()
        {
        return path;
        }
    public void setPath(String path)
        {
        this.path = path;
        }
    }
