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
public class Pdil {
    private int dil_id;
    private String dil;

    public Pdil() {
    }

    public Pdil(int dil_id, String dil) {
        this.dil_id = dil_id;
        this.dil = dil;
    }

    public int getDil_id() {
        return dil_id;
    }

    public void setDil_id(int dil_id) {
        this.dil_id = dil_id;
    }

    public String getDil() {
        return dil;
    }

    public void setDil(String dil) {
        this.dil = dil;
    }
    
    
    
}
