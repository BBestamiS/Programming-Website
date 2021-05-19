/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author bbestamis
 */
public class DuzSecenek implements Secenek{
    private String secenek;
    private String dogruSecenek;

    @Override
    public String cevapCevir() {
        return this.getSecenek();
    }

    public String getSecenek() {
        return secenek;
    }

    public void setSecenek(String secenek) {
        this.secenek = secenek;
    }

    public String getDogruSecenek() {
        return dogruSecenek;
    }

    public void setDogruSecenek(String dogruSecenek) {
        this.dogruSecenek = dogruSecenek;
    }

    @Override
    public String dogruCevapCevir() {
        return this.getDogruSecenek();
    }
    
}
