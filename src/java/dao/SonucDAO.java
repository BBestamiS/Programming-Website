/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class SonucDAO extends DAOTemplate {

    ResultSet rs1;

    @Override
    public void deleteResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createResultSet() {
        try {
            int sonucId = -1;
            int sonuc1 = 0;
            ResultSet rs = st.executeQuery("select * from sonuc where sinav_id=" + getSinav_id() + " and kullanici_id=" + getKullanici_id());
            if (rs.next() == false) {
                st.executeUpdate("insert into sonuc (sonuc,sinav_id,kullanici_id) values ('" + getSonuc() + "','" + getSinav_id() + "','" + getKullanici_id() + "')");
            } else {
                sonucId = rs.getInt("sonuc_id");
                sonuc1 = rs.getInt("sonuc");
                st.executeUpdate("update sonuc set sonuc='" + getSonuc() + "' where sonuc_id=" + sonucId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SonucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void readResultSet() {
        try {
            rs1 = st.executeQuery("select * from sinav where pdil_id=" + getPdil_id());
        } catch (SQLException ex) {
            Logger.getLogger(SonucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void okumaIslemi() {
        try {
            this.getSonucl().setSonucBir(0);
            this.getSonucl().setSonucIki(0);
            this.getSonucl().setSinavBir(0);
            this.getSonucl().setSinavIki(0);
            int m = 0;
            while (rs1.next()) {
               System.out.println("sınav id = "+ rs1.getInt("sinav_id"));
                if (m == 0) {
                    this.getSonucl().setSinavBir(rs1.getInt("sinav_id"));
                    System.out.println("birinci sınav id = "+ rs1.getInt("sinav_id"));
                    m++;
                }else {
                    System.out.println("ikinci sınav id = "+ rs1.getInt("sinav_id"));
                    this.getSonucl().setSinavIki(rs1.getInt("sinav_id"));
                }
            }
            ResultSet rs = st.executeQuery("select * from sonuc where sinav_id=" + this.getSonucl().getSinavBir() + " and kullanici_id=" + getKullanici_id());
            if(rs.next() == true){
                this.getSonucl().setSonucBir(rs.getInt("sonuc"));
            }
            
            ResultSet rs2 = st.executeQuery("select * from sonuc where sinav_id=" + this.getSonucl().getSinavIki() + " and kullanici_id=" + getKullanici_id());
            if(rs2.next() == true){
                this.getSonucl().setSonucIki(rs2.getInt("sonuc"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SonucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
