/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kullanici;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class KullaniciDAO{
    private static KullaniciDAO kullaniciDAO = null;
    public KullaniciDAO() {
    }

    public static KullaniciDAO getKullaniciDAO() {
         if(kullaniciDAO == null){
           synchronized (KullaniciDAO.class){
               if(kullaniciDAO == null){
                   kullaniciDAO = new KullaniciDAO();
               }
           }
        }
        return kullaniciDAO;
    }
    
    DBConnection dBConnection = util.DBConnection.getdBConnection();
    public Kullanici login(Kullanici kullanici){
     
        Kullanici tmp = null;
        List<Kullanici> list = new ArrayList<>();
        
        try {
            list = read();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getEmail().equals(kullanici.getEmail()) && list.get(i).getParola().equals(kullanici.getParola())){
              
                    tmp = list.get(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }
  
    public void create(Kullanici kullanici) {
        try {
            Statement st = dBConnection.getConnection().createStatement();
            st.executeUpdate("insert into kullanici (isim,email,parola) values ('" + kullanici.getIsim() + "','" + kullanici.getEmail() + "','" + kullanici.getParola() + "')");
            System.out.println("ekleme başarılı"+kullanici.getIsim()+kullanici.getEmail()+kullanici.getParola());
        } catch (Exception e) {
            System.out.println("ekleme başarısız"+kullanici.getIsim()+kullanici.getEmail()+kullanici.getParola());
            System.out.println(e.getMessage());
        }
    }

    public List<Kullanici> read() {
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = dBConnection.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from kullanici");

            while (rs.next()) {
                Kullanici tmp = new Kullanici(rs.getInt("kullanici_id"), rs.getString("isim"), rs.getString("email"), rs.getString("parola"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void delete(Kullanici kullanici) {
        try {
            Statement st = dBConnection.getConnection().createStatement();
            st.executeUpdate("delete from kullanici where kullanici_id=" + kullanici.getKullanici_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   
}
