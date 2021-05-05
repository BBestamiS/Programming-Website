/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pdil;
import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class PdilDAO{
    private static PdilDAO dilDAO = new PdilDAO();
    private PdilDAO() {
    }

    public static PdilDAO getDilDAO() {
        if(dilDAO == null){
           synchronized (PdilDAO.class){
               if(dilDAO == null){
                   dilDAO = new PdilDAO();
               }
           }
        }
        return dilDAO;
    }
    
    
    DBConnection dBConnection = util.DBConnection.getdBConnection();
    public Pdil read(int dil_id) {
        
        Pdil dil = null;
        try {
            Statement st = dBConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from pdil where dil_id="+dil_id);
                dil = new Pdil(rs.getInt("dil_id"), rs.getString("dil"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dil;
    }
}
