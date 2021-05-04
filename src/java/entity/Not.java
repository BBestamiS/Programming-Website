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
public class Not {
    private int note_id;
    private String note;
    private int kullanici_id;
    private int konu_id;
    private int dil_id;

    public Not(int note_id, String note, int kullanici_id, int konu_id, int dil_id) {
        this.note_id = note_id;
        this.note = note;
        this.kullanici_id = kullanici_id;
        this.konu_id = konu_id;
        this.dil_id = dil_id;
    }
    

    

    public Not() {
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getKonu_id() {
        return konu_id;
    }

    public void setKonu_id(int konu_id) {
        this.konu_id = konu_id;
    }

    public int getDil_id() {
        return dil_id;
    }

    public void setDil_id(int dil_id) {
        this.dil_id = dil_id;
    }

   
    
    
}
