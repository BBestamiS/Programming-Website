/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Sinav;
import entity.Soru;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class SoruDAO{
    private static SoruDAO sinavDAO = null;
    private SoruDAO() {
    }

    public static SoruDAO getSinavDAO() {
        if(sinavDAO == null){
           synchronized (SoruDAO.class){
               if(sinavDAO == null){
                   sinavDAO = new SoruDAO();
               }
           }
        }
        return sinavDAO;
    }
    
    DBConnection dBConnection = util.DBConnection.getdBConnection();
    public List<Soru> read(int sinav_id) {
        
        List<Soru> list = new ArrayList<>();
        try {
            Statement st = dBConnection.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from soru where sinav_id="+sinav_id);

            while (rs.next()) {
                Soru tmp = new Soru(rs.getInt("soru_id"),rs.getString("soru"),rs.getString("cevap_bir"),rs.getString("cevap_iki"),rs.getString("cevap_uc"),rs.getString("cevap_dort"),rs.getString("cevap_dogru"),rs.getInt("sinav_id"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public List<Sinav> sinavGetir(int pdilId) {
        
        List<Sinav> list = new ArrayList<>();
        try {
            Statement st = dBConnection.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from sinav where pdil_id="+pdilId);

            while (rs.next()) {
                Sinav tmp = new Sinav(rs.getInt("sinav_id"),rs.getString("sinav_adi"),rs.getInt("pdil_id"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}