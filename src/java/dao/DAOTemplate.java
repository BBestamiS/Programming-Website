/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Konu;
import entity.Kullanici;
import entity.Not;
import entity.Pdil;
import entity.Sinav;
import entity.Soru;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author bbestamis
 */
public abstract class DAOTemplate {
    
    private Kullanici kullanici;
    private Pdil dil;
    private int kullanici_id;
    private int konu_id;
    private int dil_id;
    private int pdil_id;
    private int kontrol;
    private Not not;
    private int sonuc;
    private int sinav_id;
    public List<Kullanici> kullanici_list;
    public List<Not> not_list;
    public List<Konu> konu_list;
    public List<Soru> soru_list;
    public Statement st;
    public ResultSet rs;
    
    DBConnection dBConnection = util.DBConnection.getdBConnection();
    public final void delete(){
        try {
            statement();
            deleteResultSet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public final void create(){
        try {
            statement();
            createResultSet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public final void read(){
        try {
            statement();
            readResultSet();
            okumaIslemi();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public abstract void deleteResultSet();
    public abstract void createResultSet();
    public abstract void readResultSet();
    public abstract void okumaIslemi();
    public void statement(){
        try {
            if(this.st == null){
                st = dBConnection.getConnection().createStatement();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public List<Kullanici> getKullanici_list() {
        return kullanici_list;
    }

    public void setKullanici_list(List<Kullanici> kullanici_list) {
        this.kullanici_list = kullanici_list;
    }

    public List<Not> getNot_list() {
        return not_list;
    }

    public void setNot_list(List<Not> not_list) {
        this.not_list = not_list;
    }
    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getKonu_id() {
        return konu_id;
    }

    public void setKonu_id(int konu_id) {
        this.konu_id = konu_id;
    }

    public int getDil_id() {
        return dil_id;
    }

    public void setDil_id(int dil_id) {
        System.out.println("dil id = "+dil_id);
        this.dil_id = dil_id;
    }

    public int getKontrol() {
        return kontrol;
    }

    public void setKontrol(int kontrol) {
        System.out.println("kontrol değeri = "+kontrol);
        this.kontrol = kontrol;
    }

    public Not getNot() {
        return not;
    }

    public void setNot(Not not) {
        this.not = not;
    }

    public List<Konu> getKonu_list() {
        return konu_list;
    }

    public void setKonu_list(List<Konu> konu_list) {
        this.konu_list = konu_list;
    }
    
    public Kullanici login(Kullanici kullanici){
        Kullanici tmp = null;
        try {
            read();
            for (int i = 0; i < kullanici_list.size(); i++) {
                if(kullanici_list.get(i).getEmail().equals(kullanici.getEmail()) && kullanici_list.get(i).getParola().equals(kullanici.getParola())){
              
                    tmp = kullanici_list.get(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }
    public List<Sinav> sinavGetir(int pdilId) {
        
        List<Sinav> list = new ArrayList<>();
        try {
            Statement st = dBConnection.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from sinav where pdil_id="+pdilId);

            while (rs.next()) {
                Sinav tmp = new Sinav(rs.getInt("sinav_id"),rs.getString("sinav_adi"),rs.getInt("pdil_id"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public Pdil getDil() {
        if(this.dil == null){
            this.dil = new Pdil();
        }
        return dil;
    }

    public void setDil(Pdil dil) {
        this.dil = dil;
    }

    public int getSonuc() {
        return sonuc;
    }

    public void setSonuc(int sonuc) {
        this.sonuc = sonuc;
    }

    public int getSinav_id() {
        return sinav_id;
    }

    public void setSinav_id(int sinav_id) {
        this.sinav_id = sinav_id;
    }

    public int getPdil_id() {
        return pdil_id;
    }

    public void setPdil_id(int pdil_id) {
        this.pdil_id = pdil_id;
    }

    public List<Soru> getSoru_list() {
        return soru_list;
    }

    public void setSoru_list(List<Soru> soru_list) {
        this.soru_list = soru_list;
    }

  
    
    
}
