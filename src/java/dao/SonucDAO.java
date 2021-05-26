/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class SonucDAO  extends  DAOTemplate{
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
            ResultSet rs = st.executeQuery("select * from sonuc where sinav_id="+getSinav_id()+" and kullanici_id="+getKullanici_id());
             rs.next();
            sonucId = rs.getInt("sonuc_id");
            sonuc1 = rs.getInt("sonuc");
            if(sonucId == -1){
                st.executeUpdate("insert into sonuc (sonuc,sinav_id,kullanici_id) values ('" + getSonuc() + "','" + getSinav_id() + "','" + getKullanici_id() + "')"); 
            }else{
                st.executeUpdate("update sonuc set sonuc='"+getSonuc()+"' where sonuc_id="+sonucId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SonucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void readResultSet() {
        setSonuc(0);
        try {
            rs1 = st.executeQuery("select * from sinav where pdil_id="+getPdil_id());
        } catch (SQLException ex) {
            Logger.getLogger(SonucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void okumaIslemi() {
        try {
            rs1.next();
            int sinav_id = rs1.getInt("sinav_id");
            ResultSet rs = st.executeQuery("select * from sonuc where sinav_id="+sinav_id+" and kullanici_id="+getKullanici_id());
            rs.next();
            int sonuc = rs.getInt("sonuc");
            setSonuc(sonuc);
        } catch (SQLException ex) {
            Logger.getLogger(SonucDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
