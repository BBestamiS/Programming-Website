/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Konu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public class KonuDAO extends DBConnection{
    public List<Konu> read(int dil_id) {
        List<Konu> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from konu where dil_id="+dil_id);
            while (rs.next()) {
                Konu tmp = new Konu(rs.getInt("konu_id"), rs.getString("konu"), rs.getString("video_link"), rs.getInt("dil_id"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
