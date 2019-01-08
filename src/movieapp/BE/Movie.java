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
    private String name;
    private int IMDBRating;
    private int personalRating;
    
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
    public void setPersonalRating(int PersonalRating)
        {
        this.personalRating = PersonalRating;
        }
    }
