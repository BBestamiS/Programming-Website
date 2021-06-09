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
public class SonucL {
    private int sinavBir;
    private int sinavIki;
    private int sonucBir;
    private int sonucIki;

    public SonucL() {
    }

    public SonucL(int sinavBir, int sinavIki, int sonucBir, int sonucIki) {
        this.sinavBir = sinavBir;
        this.sinavIki = sinavIki;
        this.sonucBir = sonucBir;
        this.sonucIki = sonucIki;
    }

    public int getSinavBir() {
        return sinavBir;
    }

    public void setSinavBir(int sinavBir) {
        this.sinavBir = sinavBir;
    }

    public int getSinavIki() {
        return sinavIki;
    }

    public void setSinavIki(int sinavIki) {
        this.sinavIki = sinavIki;
    }

   

    public int getSonucBir() {
        return sonucBir;
    }

    public void setSonucBir(int sonucBir) {
        this.sonucBir = sonucBir;
    }

    public int getSonucIki() {
        return sonucIki;
    }

    public void setSonucIki(int sonucIki) {
        this.sonucIki = sonucIki;
    }
    
}
