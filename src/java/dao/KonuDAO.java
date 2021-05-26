/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Konu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bbestamis
 */
public class KonuDAO extends DAOTemplate{
    

    
     @Override
    public void readResultSet() {
        try {
            if(this.getKontrol() == 0){
                rs = st.executeQuery("select * from konu where dil_id=" + getDil_id());
            }else{
                rs = st.executeQuery("select * from konu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void okumaIslemi() {
        try {
            konu_list = new ArrayList<>();
            while (rs.next()) {
                Konu tmp = new Konu(rs.getInt("konu_id"), rs.getString("konu"), rs.getString("video_link"), rs.getInt("dil_id"));
                konu_list.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
