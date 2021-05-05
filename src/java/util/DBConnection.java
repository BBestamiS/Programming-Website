/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bbestamis
 */
public class DBConnection {
    private static DBConnection dBConnection = null;
    private DBConnection() {
    }

    public static DBConnection getdBConnection() {
        if(dBConnection == null){
           synchronized (DBConnection.class){
               if(dBConnection == null){
                   dBConnection = new DBConnection();
               }
           }
        }
        return dBConnection;
    }
    
    private Connection connection;
    
    public Connection connect(){
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proje", "postgres", "123");
            System.out.println("bağlanti başarılı");
        } catch (Exception e) {
            System.out.println("bağlanti başarısız");
            System.out.println(e.getMessage());
        }
        return this.connection;
    }

    public Connection getConnection() {
        if(this.connection == null ){
            return connect();
        }
        return connection;
    }
    
    
}
