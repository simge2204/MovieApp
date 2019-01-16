/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.BE;

import java.sql.Date;

/**
 *
 * @author simge
 */
public class Movie
    {
    private int id;
    private String name;
    private float IMDBRating;
    private float personalRating;
    private Date lastView;
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
        return name;
        }
    public void setName(String name)
        {
        this.name = name;
        }
    public float getIMDBRating()
        {
        return IMDBRating;
        }
    public void setIMDBRating(float IMDBRating)
        {
        this.IMDBRating = IMDBRating;
        }
    public float getPersonalRating()
        {
        return personalRating;
        }
    public void setPersonalRating(float personalRating)
        {
        this.personalRating = personalRating;
        }
    public Date getLastView()
        {
        return lastView;
        }
    public void setLastView(Date lastView)
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
