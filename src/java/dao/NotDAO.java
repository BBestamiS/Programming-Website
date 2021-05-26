/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Not;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bbestamis
 */
public class NotDAO extends DAOTemplate{

    @Override
    public void readResultSet() {
        try {
            if(this.getKontrol() == 0){
                rs = st.executeQuery("select * from note where kullanici_id="+getKullanici_id());
            }
            else{
                rs = st.executeQuery("select * from note where kullanici_id="+getKullanici_id()+" and konu_id="+getKonu_id()+" and dil_id="+getDil_id());
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void okumaIslemi() {
        try {
            not_list = new ArrayList<>();
            while (rs.next()) {
                Not tmp = new Not(rs.getInt("note_id"), rs.getString("note"), rs.getInt("kullanici_id"),rs.getInt("konu_id"),rs.getInt("dil_id"));
                not_list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void createResultSet() {
        try { 
            st.executeUpdate("insert into note (note,kullanici_id,konu_id,dil_id) values ('" + getNot().getNote() + "','" + getNot().getKullanici_id() + "','" + getNot().getKonu_id()+ "','" + getNot().getDil_id()+ "')");
        } catch (SQLException ex) {
            Logger.getLogger(NotDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteResultSet() {
        try {
            st.executeUpdate("delete from note where note_id=" + getNot().getNote_id());
        } catch (SQLException ex) {
            Logger.getLogger(NotDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
