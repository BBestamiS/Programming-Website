/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Not;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class NotDAO{
    private static NotDAO notDAO = null;
    private NotDAO() {
    }

    public static NotDAO getNotDAO() {
        if(notDAO == null){
           synchronized (NotDAO.class){
               if(notDAO == null){
                   notDAO = new NotDAO();
               }
           }
        }
        return notDAO;
    }
    
    DBConnection dBConnection = util.DBConnection.getdBConnection();
    public void create(Not note) {
        try {
            Statement st = dBConnection.getConnection().createStatement();
            st.executeUpdate("insert into note (note,kullanici_id,konu_id,dil_id) values ('" + note.getNote() + "','" + note.getKullanici_id() + "','" + note.getKonu_id()+ "','" + note.getDil_id()+ "')"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Not> read(int kullanici_id , int konu_id, int dil_id) {
        
        List<Not> list = new ArrayList<>();
        try {
            Statement st = dBConnection.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from note where kullanici_id="+kullanici_id+" and konu_id="+konu_id+" and dil_id="+dil_id);

            while (rs.next()) {
                Not tmp = new Not(rs.getInt("note_id"), rs.getString("note"), rs.getInt("kullanici_id"),rs.getInt("konu_id"),rs.getInt("dil_id"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public List<Not> read(int kullanici_id) {
        
        List<Not> list = new ArrayList<>();
        try {
            Statement st = dBConnection.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from note where kullanici_id="+kullanici_id);

            while (rs.next()) {
                Not tmp = new Not(rs.getInt("note_id"), rs.getString("note"), rs.getInt("kullanici_id"),rs.getInt("konu_id"),rs.getInt("dil_id"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void delete(Not note) {
        try {
            Statement st = dBConnection.getConnection().createStatement();
            st.executeUpdate("delete from note where note_id=" + note.getNote_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
