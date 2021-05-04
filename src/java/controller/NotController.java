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
public class NotController implements Serializable{
    private NotDAO notDAO;
    private Not not;
    
    public String create(int kullanici_id, int konu_id, int dil_id) {
        this.getNot().setKullanici_id(kullanici_id);
        this.getNot().setKonu_id(konu_id);
        this.getNot().setDil_id(dil_id);
        this.getNotDAO().create(this.getNot());
        return "mainScreen";
    }

    public List<Not> getRead(int kullanici_id,int konu_id, int dil_id) {
        return this.getNotDAO().read(kullanici_id,konu_id,dil_id);
    }

    public void delete(Not not) {
        this.getNotDAO().delete(not);
    }

    public NotDAO getNotDAO() {
        if(this.notDAO == null){
            this.notDAO = new NotDAO();
        }
        return notDAO;
    }

    public void setNotDAO(NotDAO notDAO) {
        this.notDAO = notDAO;
    }

    public Not getNot() {
        if(this.not == null){
            this.not = new Not();
        }
        return not;
    }

    public void setNot(Not not) {
        this.not = not;
    }
    
    public Not getNotGetir(){
        return this.getNot();
    }
    
}
