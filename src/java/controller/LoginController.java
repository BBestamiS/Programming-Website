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
    private KullaniciDAO kullaniciDAO = KullaniciDAO.getKullaniciDAO();
    private String control;
    private int loginPage;

    public String login(){
        setKullanici(kullaniciDAO.login(getKullanici()));
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
        this.kullaniciDAO.create(kullanici);
        mesajKaldir();
        gitLoginPage();
    }

    public List<Kullanici> getRead() {
        return this.kullaniciDAO.read();
    }

    public String delete(Kullanici kullanici) {
        this.kullaniciDAO.delete(kullanici);
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

   
}
