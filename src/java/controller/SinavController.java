/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SinavDAO;
import entity.Sinav;
import entity.Sonuc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author bbestamis
 */
@Named
@SessionScoped
public class SinavController implements Serializable{
    private Sinav sinav;
    private SinavDAO sinavDAO;
    private Sonuc sonuc;
    private int control;
    private int sayfaControl;
    private List<Sinav> list;
    private List<String> cevapList;
    private List<Sonuc> sonucList;
    
    public String bitir(){
        this.getSonucList().clear();
        String cevap;
        String dogruCevap;
        for (int i = 0; i < this.getList().size(); i++) {
            if(this.getCevapList().get(i + 1).equals("1")){
                cevap = this.getList().get(i).getCevap_bir();
            }else if(this.getCevapList().get(i + 1).equals("2")){
                cevap = this.getList().get(i).getCevap_iki();
            }else if(this.getCevapList().get(i + 1).equals("3")){
                cevap = this.getList().get(i).getCevap_uc();
            }else if(this.getCevapList().get(i + 1).equals("4")){
                cevap = this.getList().get(i).getCevap_dort();
            }else{
                cevap = "Boş";
            }
            if(this.getList().get(i).getCevap_dogru().equals("1")){
                dogruCevap = this.getList().get(i).getCevap_bir();
            }else if(this.getList().get(i).getCevap_dogru().equals("2")){
                dogruCevap = this.getList().get(i).getCevap_iki();
            }else if(this.getList().get(i).getCevap_dogru().equals("3")){
                dogruCevap = this.getList().get(i).getCevap_uc();
            }else if(this.getList().get(i).getCevap_dogru().equals("4")){
                dogruCevap = this.getList().get(i).getCevap_dort();
            }else{
                dogruCevap = "Boş";
            }
     
            if(this.getCevapList().get(i + 1).equals(this.getList().get(i).getCevap_dogru()) ){
                
                
                Sonuc tmp = new Sonuc(this.getList().get(i).getSoru(),dogruCevap,cevap,"Doğru");
                this.getSonucList().add(tmp);
            }else{
                
                Sonuc tmp = new Sonuc(this.getList().get(i).getSoru(),dogruCevap,cevap,"Yanlış");
                this.getSonucList().add(tmp);
            }
        }
        temizle();
        
        return "result";
    }
 
    public Sinav getSoru(){
        this.setList(this.getSinavDAO().read());
        this.getSinav().setSoru(this.getList().get(getControl()).getSoru());
        this.getSinav().setCevap_bir(this.getList().get(getControl()).getCevap_bir());
        this.getSinav().setCevap_iki(this.getList().get(getControl()).getCevap_iki());
        this.getSinav().setCevap_uc(this.getList().get(getControl()).getCevap_uc());
        this.getSinav().setCevap_dort(this.getList().get(getControl()).getCevap_dort());
        this.getSinav().setCevap_dogru(this.getList().get(getControl()).getCevap_dogru());
        
        return this.sinav;
    }
    
    public void temizle(){
        this.sayfaControl = 0;
        for (int i = 0; i <= 5; i++) {
                this.cevapList.set(i, null);
            }
        this.control = 0;
    }
    
    
    
    public String cevapEkle(String cevap){
        getCevapList().set(control + 1, cevap);
        return "quiz";
    }
    
    public String secim(){
       return this.getCevapList().get(control + 1);
    }
    
    public Sinav getSinav() {
        if(this.sinav == null){
            this.sinav = new Sinav();
        }
        return sinav;
    }

    public void setSinav(Sinav sinav) {
        this.sinav = sinav;
    }

    public SinavDAO getSinavDAO() {
        if(this.sinavDAO == null){
            this.sinavDAO = new SinavDAO();
        }
        return sinavDAO;
    }

    public void setSinavDAO(SinavDAO sinavDAO) {
        this.sinavDAO = sinavDAO;
    }

    

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public List<Sinav> getList() {
        if(this.list == null){
            this.list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<Sinav> list) {
        this.list = list;
    }
   public String setControlArttir(){
       if(getControl() == 4){
           return"quiz";
       }
       setControl(getControl() + 1);
       System.out.println(this.getControl());
       return"quiz";
   }
   public String setControlAzalt(){
       if(getControl() == 0){
           return"quiz";
       }
       setControl(getControl() - 1);
       return"quiz";
   }

    

    public List<String> getCevapList() {
        if(this.cevapList == null){
            this.cevapList = new ArrayList<>();
            for (int i = 0; i <= 5; i++) {
                this.cevapList.add(null);
            }
        }
        
        return cevapList;
    }

    public void setCevapList(List<String> cevapList) {
        this.cevapList = cevapList;
    }

    public Sonuc getSonuc() {
        if(this.sonuc == null){
            this.sonuc = new Sonuc();
        }
        return sonuc;
    }

    public void setSonuc(Sonuc sonuc) {
        this.sonuc = sonuc;
    }

    public List<Sonuc> getSonucList() {
        if(this.sonucList == null){
            this.sonucList = new ArrayList<>();
        }
        return sonucList;
    }

    public void setSonucList(List<Sonuc> sonucList) {
        this.sonucList = sonucList;
    }
    
    public String sayfaGecis(String sayfa){
        this.sayfaControl = 0;
        System.out.println(this.getSayfaControl());
        return sayfa;
    }
    
    public String sinavaBasla(){
        this.setSayfaControl(1);
        return "quiz";
    }
    public int getSayfaControl() {
        return sayfaControl;
    }

    public void setSayfaControl(int sayfaControl) {
        this.sayfaControl = sayfaControl;
    }
    
}
