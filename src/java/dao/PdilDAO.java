/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pdil;
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
public class PdilDAO extends DAOTemplate {

    @Override
    public void readResultSet() {
        try {
            ResultSet rs = st.executeQuery("select * from pdil where dil_id=" + getDil_id());
        } catch (SQLException ex) {
            Logger.getLogger(PdilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void okumaIslemi() {
        try {
           Pdil dil = new Pdil(rs.getInt("dil_id"), rs.getString("dil"));
           setDil(dil);
        } catch (SQLException ex) {
            Logger.getLogger(PdilDAO.class.getName()).log(Level.SEVERE, null, ex);
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
