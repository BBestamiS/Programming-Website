/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Sinav;
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
public class SinavDAO{
    private static SinavDAO sinavDAO = null;
    private SinavDAO() {
    }

    public static SinavDAO getSinavDAO() {
        if(sinavDAO == null){
           synchronized (SinavDAO.class){
               if(sinavDAO == null){
                   sinavDAO = new SinavDAO();
               }
           }
        }
        return sinavDAO;
    }
    
    DBConnection dBConnection = util.DBConnection.getdBConnection();
    public List<Sinav> read() {
        
        List<Sinav> list = new ArrayList<>();
        try {
            Statement st = dBConnection.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from soru");

            while (rs.next()) {
                Sinav tmp = new Sinav(rs.getInt("soru_id"),rs.getString("soru"),rs.getString("cevap_bir"),rs.getString("cevap_iki"),rs.getString("cevap_uc"),rs.getString("cevap_dort"),rs.getString("cevap_dogru"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
