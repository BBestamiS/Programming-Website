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
    private KonuDAO konuDAO;
    private Pdil dil;
    private PdilDAO dilDAO;
    private Kullanici kullanici;
    private KullaniciDAO kullaniciDAO;
    
    
    
    public List<Konu> getkonuGetir(){
        return this.getKonuDAO().read(this.getDil().getDil_id());
    }
    
    public String dilDegistir(int dil_id){
        this.getDil().setDil_id(dil_id);
        this.setKonu(this.getKonuDAO().read(this.getDil().getDil_id()).get(0));
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

    public KonuDAO getKonuDAO() {
        if(this.konuDAO == null){
            this.konuDAO = new KonuDAO();
        }
        return konuDAO;
    }

    public void setKonuDAO(KonuDAO konuDAO) {
        this.konuDAO = konuDAO;
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

    public PdilDAO getDilDAO() {
        if(this.dilDAO == null){
            this.dilDAO = new PdilDAO();
        }
        return dilDAO;
    }

    public void setDilDAO(PdilDAO dilDAO) {
        this.dilDAO = dilDAO;
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

    public KullaniciDAO getKullaniciDAO() {
        if(this.kullaniciDAO == null){
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }
    
    
}
