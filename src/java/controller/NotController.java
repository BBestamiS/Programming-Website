/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NotDAO;
import entity.Not;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author bbestamis
 */
@Named
@SessionScoped
public class NotController implements Serializable {

    private NotDAO notDAO = NotDAO.getNotDAO();
    private Not not;
    private String mesaj;

    public String create(int kullanici_id, int konu_id, int dil_id) {
        if (this.getNot().getNote().equals("")) {
            mesajGoster();
            return "homePage";
        }
        this.getNot().setKullanici_id(kullanici_id);
        this.getNot().setKonu_id(konu_id);
        this.getNot().setDil_id(dil_id);
        this.notDAO.create(this.getNot());
        this.setNot(null);
        mesajKaldir();
        return "homePage";
    }

    public String mesajGoster() {
        this.setMesaj("Boş Not Alınamaz!");
        return "homePage";
    }

    public void mesajKaldir() {
        this.setMesaj(null);
    }
    
    public List<Not> getReadKullanici(int kullanici_id) {
        return this.notDAO.read(kullanici_id);
    }
    
    public List<Not> getRead(int kullanici_id, int konu_id, int dil_id) {
        return this.notDAO.read(kullanici_id, konu_id, dil_id);
    }

    public void delete(Not not) {
        this.notDAO.delete(not);
        this.setMesaj(null);
    }

    public Not getNot() {
        if (this.not == null) {
            this.not = new Not();
        }
        return not;
    }

    public void setNot(Not not) {
        this.not = not;
    }

    public Not getNotGetir() {
        return this.getNot();
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
