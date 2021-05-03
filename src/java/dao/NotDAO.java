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
public class NotDAO extends DBConnection{
    public void create(Not note) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into note (note) values ('" + note.getNote()+ "')"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Not> read() {
        List<Not> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from note");

            while (rs.next()) {
                Not tmp = new Not(rs.getInt("note_id"), rs.getString("note"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void delete(Not note) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from note where note_id=" + note.getNote_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
