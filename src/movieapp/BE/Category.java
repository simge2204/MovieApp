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
public class Category
    {
    private int id;
    private String genre;
    
    public Category()
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
    public String getGenre()
        {
        return genre;
        }
    public void setGenre(String genre)
        {
        this.genre = genre;
        }
    }
