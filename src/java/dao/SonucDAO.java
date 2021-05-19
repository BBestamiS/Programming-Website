/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class SonucDAO {
    DBConnection dBConnection = util.DBConnection.getdBConnection();
    public void create(int sonuc,int sinav_id, int kullanici_id) {
        try {
            Statement st = dBConnection.getConnection().createStatement();
            st.executeUpdate("insert into sonuc (sonuc,sinav_id,kullanici_id) values ('" + sonuc + "','" + sinav_id + "','" + kullanici_id + "')"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int read(int kullanici_id , int pdil_id) {
        int sonuc = 0;
        int sinav_id = 0;
        try {
            Statement st = dBConnection.getConnection().createStatement();
            ResultSet rs1 = st.executeQuery("select * from sinav where pdil_id="+pdil_id);
            rs1.next();
            sinav_id = rs1.getInt("sinav_id");
            ResultSet rs = st.executeQuery("select * from sonuc where sinav_id="+sinav_id+" and kullanici_id="+kullanici_id);
            rs.next();
            sonuc = rs.getInt("sonuc");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sonuc;
    }

}
