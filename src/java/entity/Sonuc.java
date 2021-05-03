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
public class Sonuc {
    private String soru;
    private String dogru_cevap;
    private String cevap;
    private String sonuc;

    public Sonuc(String soru, String dogru_cevap, String cevap, String sonuc) {
        this.soru = soru;
        this.dogru_cevap = dogru_cevap;
        this.cevap = cevap;
        this.sonuc = sonuc;
    }
    

   

    public Sonuc() {
    }

    
    
    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getDogru_cevap() {
        return dogru_cevap;
    }

    public void setDogru_cevap(String dogru_cevap) {
        this.dogru_cevap = dogru_cevap;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }
    
    
            
}
