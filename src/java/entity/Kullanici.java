/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author bbestamis
 */
public class Kullanici {
    private int kullanici_id;
    private String isim;
    private String email;
    private String parola;

    public Kullanici() {
    }

    public Kullanici(int kullanici_id, String isim, String email, String parola) {
        this.kullanici_id = kullanici_id;
        this.isim = isim;
        this.email = email;
        this.parola = parola;
    }
    

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

}