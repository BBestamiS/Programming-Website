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
public class Konu {
    private int konu_id;
    private String konu;
    private String video_link;
    private int dil_id;

    public Konu() {
    }

    public Konu(int konu_id, String konu, String video_link, int dil_id) {
        this.konu_id = konu_id;
        this.konu = konu;
        this.video_link = video_link;
        this.dil_id = dil_id;
    }

    public int getKonu_id() {
        return konu_id;
    }

    public void setKonu_id(int konu_id) {
        this.konu_id = konu_id;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public int getDil_id() {
        return dil_id;
    }

    public void setDil_id(int dil_id) {
        this.dil_id = dil_id;
    }
    
    
}
