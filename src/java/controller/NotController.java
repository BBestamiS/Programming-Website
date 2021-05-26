/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOTemplate;
import dao.NotDAO;
import entity.Not;
import java.io.Serializable;
import java.sql.SQLException;
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

    private Not not;
    private String mesaj;
    private DAOTemplate notDAO;

    public String create(int kullanici_id, int konu_id, int dil_id) {
        if (this.getNot().getNote().equals("")) {
            mesajGoster();
            return "homePage";
        }
        this.getNot().setKullanici_id(kullanici_id);
        this.getNot().setKonu_id(konu_id);
        this.getNot().setDil_id(dil_id);
        this.notDAO.setNot(this.getNot());
        this.notDAO.create();
        this.setNot(null);
        mesajKaldir();
        return "homePage";
    }
    public String ProgramlamaDili(int id){
        if(id == 2){
            return "Flutter";
        }else if(id == 3){
            return "Java";
        }else{
            return "Swift";
        }
    }
    
    public String mesajGoster() {
        this.setMesaj("Boş Not Alınamaz!");
        return "homePage";
    }

    public void mesajKaldir() {
        this.setMesaj(null);
    }
    
    
    public List<Not> getReadKullanici(int kullanici_id){
        
        this.getNotDAO().setKullanici_id(kullanici_id);
        this.getNotDAO().setKontrol(0);
        this.getNotDAO().read();
        return this.getNotDAO().getNot_list();
    }
    
    
    public List<Not> getRead(int kullanici_id, int konu_id, int dil_id) {
        this.getNotDAO().setKullanici_id(kullanici_id);
        this.getNotDAO().setKonu_id(konu_id);
        this.getNotDAO().setDil_id(dil_id);
        this.getNotDAO().setKontrol(1);
        this.getNotDAO().read();
        return this.getNotDAO().getNot_list();
    }

    public void delete(Not not) {
        this.getNotDAO().setNot(not);
        this.getNotDAO().delete();
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

    public DAOTemplate getNotDAO() {
        if(notDAO == null){
            this.notDAO = new NotDAO();
        }
        return notDAO;
    }

    public void setNotDAO(DAOTemplate notDAO) {
        this.notDAO = notDAO;
    }

   

}
