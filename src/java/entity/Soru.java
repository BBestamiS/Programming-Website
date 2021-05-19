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
public class Soru {
    private int soru_id;
    private String soru;
    private String cevap_bir;
    private String cevap_iki;
    private String cevap_uc;
    private String cevap_dort;
    private String cevap_dogru;
    private int sinav_id;

    public Soru() {
    }

    public Soru(int soru_id, String soru, String cevap_bir, String cevap_iki, String cevap_uc, String cevap_dort, String cevap_dogru, int sinav_id) {
        this.soru_id = soru_id;
        this.soru = soru;
        this.cevap_bir = cevap_bir;
        this.cevap_iki = cevap_iki;
        this.cevap_uc = cevap_uc;
        this.cevap_dort = cevap_dort;
        this.cevap_dogru = cevap_dogru;
        this.sinav_id = sinav_id;
    }

    
    
    

    public int getSoru_id() {
        return soru_id;
    }

    public void setSoru_id(int soru_id) {
        this.soru_id = soru_id;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getCevap_bir() {
        return cevap_bir;
    }

    public void setCevap_bir(String cevap_bir) {
        this.cevap_bir = cevap_bir;
    }

    public String getCevap_iki() {
        return cevap_iki;
    }

    public void setCevap_iki(String cevap_iki) {
        this.cevap_iki = cevap_iki;
    }

    public String getCevap_uc() {
        return cevap_uc;
    }

    public void setCevap_uc(String cevap_uc) {
        this.cevap_uc = cevap_uc;
    }

    public String getCevap_dort() {
        return cevap_dort;
    }

    public void setCevap_dort(String cevap_dort) {
        this.cevap_dort = cevap_dort;
    }

    public String getCevap_dogru() {
        return cevap_dogru;
    }

    public void setCevap_dogru(String cevap_dogru) {
        this.cevap_dogru = cevap_dogru;
    }

    public int getSinav_id() {
        return sinav_id;
    }

    public void setSinav_id(int sinav_id) {
        this.sinav_id = sinav_id;
    }
    
    
    
}
