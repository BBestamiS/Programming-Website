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
    
    public String create() {
        System.out.println(this.getNot().getNote());
        this.getNotDAO().create(this.getNot());
        return "mainScreen";
    }

    public List<Not> getRead() {
        return this.getNotDAO().read();
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
