/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KonuDAO;
import dao.KullaniciDAO;
import dao.PdilDAO;
import entity.Konu;
import entity.Kullanici;
import entity.Pdil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author bbestamis
 */
@Named
@SessionScoped
public class AnaEkranController implements Serializable{
    private Konu konu;
    private KonuDAO konuDAO = KonuDAO.getKonuDAO();
    private Pdil dil;
    private PdilDAO dilDAO = PdilDAO.getDilDAO();
    private Kullanici kullanici;
    private KullaniciDAO kullaniciDAO = KullaniciDAO.getKullaniciDAO();
    
    
    
    public List<Konu> getkonuGetir(){
        return this.konuDAO.read(this.getDil().getDil_id());
    }
    
    public String dilDegistir(int dil_id){
        this.getDil().setDil_id(dil_id);
        this.setKonu(this.konuDAO.read(this.getDil().getDil_id()).get(0));
        return "mainScreen";
    }
    public String konuDegistir(Konu konu){
        this.setKonu(konu);
        return "mainScreen";
    }
    
   
    public Konu getKonu() {
        if(this.konu == null){
            this.konu = new Konu();
        }
        return konu;
    }

    public void setKonu(Konu konu) {
        this.konu = konu;
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

   
    public Kullanici getKullanici() {
        if(this.kullanici == null){
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    
    
}
