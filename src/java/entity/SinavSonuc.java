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
public class SinavSonuc {
    private int sonuc_id;
    private int sonuc;
    private int sinav_id;
    private int kullanici_id;

    public SinavSonuc(int sonuc_id, int sonuc, int sinav_id, int kullanici_id) {
        this.sonuc_id = sonuc_id;
        this.sonuc = sonuc;
        this.sinav_id = sinav_id;
        this.kullanici_id = kullanici_id;
    }

    public SinavSonuc() {
    }

    public int getSonuc_id() {
        return sonuc_id;
    }

    public void setSonuc_id(int sonuc_id) {
        this.sonuc_id = sonuc_id;
    }

    public int getSonuc() {
        return sonuc;
    }

    public void setSonuc(int sonuc) {
        this.sonuc = sonuc;
    }

    public int getSinav_id() {
        return sinav_id;
    }

    public void setSinav_id(int sinav_id) {
        this.sinav_id = sinav_id;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }
    
}
