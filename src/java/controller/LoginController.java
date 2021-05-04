/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    private KullaniciDAO kullaniciDAO;
    private String control;
    private int loginPage;

    public String login(){
        setKullanici(getKullaniciDAO().login(getKullanici()));
        System.out.println("kullanici adi = "+this.getKullanici().getIsim());
        if(this.getKullanici() == null){
            mesajYazdir();
           return "login";
        }else{
            mesajKaldir();
            return  "mainScreen";
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
        this.getKullaniciDAO().create(kullanici);
        mesajKaldir();
        gitLoginPage();
    }

    public List<Kullanici> getRead() {
        return this.getKullaniciDAO().read();
    }

    public void delete(Kullanici kullanici) {
        this.getKullaniciDAO().delete(kullanici);
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

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
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

   
}
