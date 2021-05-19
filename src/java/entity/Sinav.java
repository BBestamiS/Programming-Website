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
public class Sinav {
    private int sinav_id;
    private String sinav_adi;
    private int pdil_id;

    public Sinav() {
    }

    public Sinav(int sinav_id, String sinav_adi, int pdil_id) {
        this.sinav_id = sinav_id;
        this.sinav_adi = sinav_adi;
        this.pdil_id = pdil_id;
    }

    public int getSinav_id() {
        return sinav_id;
    }

    public void setSinav_id(int sinav_id) {
        this.sinav_id = sinav_id;
    }

    public String getSinav_adi() {
        return sinav_adi;
    }

    public void setSinav_adi(String sinav_adi) {
        this.sinav_adi = sinav_adi;
    }

    public int getPdil_id() {
        return pdil_id;
    }

    public void setPdil_id(int pdil_id) {
        this.pdil_id = pdil_id;
    }
    
    
}
