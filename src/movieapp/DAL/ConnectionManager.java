/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
/**
 *
 * @author simge
 */
public class ConnectionManager
{
    private SQLServerDataSource ds = new SQLServerDataSource();
    
    public ConnectionManager()
    {
        ds.setDatabaseName("MovieApp17");
        ds.setUser("CS2018A_17");
        ds.setPassword("CS2018A_17");
        ds.setServerName("EASV-DB2");
        ds.setPortNumber(1433);
    }
    
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }

}