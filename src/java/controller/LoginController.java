/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOTemplate;
import dao.KullaniciDAO;
import entity.Kullanici;
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
public class LoginController implements Serializable {

    private Kullanici kullanici;
    private String control;
    private int loginPage;
    private DAOTemplate kullaniciDAO;
    public String login(){
        setKullanici(this.getKullaniciDAO().login(getKullanici()));
        if(this.getGelenKullanici() == null){
            mesajYazdir();
           return "index";
        }else{
            mesajKaldir();
            return  "selection";
        }
    }
    public void mesajYazdir(){
        setControl("Hatalı e-Posta veya Şifre girildi!");
    }
    public void mesajKaldir(){
        setControl(null);
    }
    public void create() {
        System.out.println(this.kullanici.getIsim());
        this.getKullaniciDAO().setKullanici(kullanici);
        this.getKullaniciDAO().create();
        mesajKaldir();
        gitLoginPage();
    }

    public List<Kullanici> getRead() {
        this.getKullaniciDAO().read();
        return this.getKullaniciDAO().getKullanici_list();
    }

    public String delete(Kullanici kullanici) {
        this.getKullaniciDAO().setKullanici(kullanici);
        this.getKullaniciDAO().delete();
        return "index";
    }
    
    public Kullanici getGelenKullanici(){
        return kullanici;
    }
    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }


    public String getControl() {
        
        return control;
    }
    
    public void setControl(String control) {
        this.control = control;
    }
    
    public int getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(int loginPage) {
        this.loginPage = loginPage;
    }
    public void gitRegisterPage(){
        this.setLoginPage(1);
    }
    public void gitLoginPage(){
        this.setLoginPage(0);
    }

    public DAOTemplate getKullaniciDAO() {
        if(this.kullaniciDAO == null){
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

   
}
