/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kullanici;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bbestamis
 */
public class KullaniciDAO extends DAOTemplate{

    @Override
    public void readResultSet() {
        try {
           rs = st.executeQuery("select * from kullanici");
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void okumaIslemi() {
        try {
            kullanici_list = new ArrayList<>();
            while (rs.next()) {
                Kullanici tmp = new Kullanici(rs.getInt("kullanici_id"), rs.getString("isim"), rs.getString("email"), rs.getString("parola"));
                System.out.println("kullanici adı = "+rs.getString("isim"));
                kullanici_list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createResultSet() {
        try {
            st.executeUpdate("insert into kullanici (isim,email,parola) values ('" + getKullanici().getIsim() + "','" + getKullanici().getEmail() + "','" + getKullanici().getParola() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public void deleteResultSet() {
        try {
            st.executeUpdate("delete from kullanici where kullanici_id=" + getKullanici().getKullanici_id());
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
   

   
}
