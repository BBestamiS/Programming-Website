/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Soru;
import entity.Sonuc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bbestamis
 */
public class SinavControllerStub{
    
    private List<Soru> list;
    private List<String> cevapList;
    private String birinciSecenek;
    private String ikinciSecenek;
    private String ucuncuSecenek;
    private String dorduncuSecenek;
    private String dogruCevap;
    private String cevap;
    

   public String bitir() {
       sistemDoldur();
       String sonuc = "";
        String isaretlenmisCevap;
        String dogruCevap;
        for (int i = 0; i < this.getList().size(); i++) {
            isaretlenmisCevap = this.getCevapList().get(i);
            dogruCevap = this.getList().get(i).getCevap_dogru();
            if (this.getList().get(i).getCevap_dogru().equals(this.getCevapList().get(i))) {
                System.out.println(this.getList().get(i).getSoru()+"   "+this.getList().get(i).getCevap_dogru()+"   "+this.getCevapList().get(i)+"   "+ "Dogru");
                sonuc = sonuc+(i+1)+"-Doğru"+" ";
            } else {
                System.out.println(this.getList().get(i).getSoru()+"   "+this.getList().get(i).getCevap_dogru()+"   "+this.getCevapList().get(i)+"   "+ "Yanlış");
                sonuc = sonuc+(i+1)+"-Yanlış"+" ";
            }
        }
        System.out.println(sonuc);
        return sonuc;
   }
   public void cevapDoldur(String birinciCevap,String ikinciCevap, String ucuncuCevap){
       this.getCevapList().add(birinciCevap);
       this.getCevapList().add(ikinciCevap);
       this.getCevapList().add(ucuncuCevap);
   }
    
    public void sistemDoldur(){
        Soru soru1 = new Soru(1,"pubspec.yaml dosyası nedir?","Main fonksiyonunun bulunduğu dosyadır","Projenin konfigürasyon dosyasıdır","Tasarım oluşturmak için kullanılır","Projenin derlenmesini sağlar","Projenin konfigürasyon dosyasıdır",1);
        Soru soru2 = new Soru(2,"Flutter kaç tür widget içerir?","1","2","3","4","2",1);
        Soru soru3 = new Soru(3,"Dart nedir?","Flutter uygulamaları geliştirmek için kullandığınız nesne yönelimli bir programlama dilidir.","Widgettir","Flutter derleyicisidir","Tasarım oluşturmamızı sağlar","Flutter uygulamaları geliştirmek için kullandığınız nesne yönelimli bir programlama dilidir.",1);
        this.getList().add(soru1);
        this.getList().add(soru2);
        this.getList().add(soru3);
    }


    public String temizle() {
        int a = 0;
        for (int i = 0; i <= 2; i++) {
            this.cevapList.set(i, null);
            if(this.cevapList.get(i) == null){
                a = a+1;
                System.out.println(i+".cevap = "+this.cevapList.get(i));
            }
        }
        if(a == 3){
            System.out.println("Temizlendi");
            return  "Temizlendi";
        }
        System.out.println("Temizlenmedi");
        return "Temizlenmedi";
    }

    public String getBirinciSecenek() {
        return birinciSecenek;
    }

    public void setBirinciSecenek(String birinciSecenek) {
        this.birinciSecenek = birinciSecenek;
    }

    public String getIkinciSecenek() {
        return ikinciSecenek;
    }

    public void setIkinciSecenek(String ikinciSecenek) {
        this.ikinciSecenek = ikinciSecenek;
    }

    public String getUcuncuSecenek() {
        return ucuncuSecenek;
    }

    public void setUcuncuSecenek(String ucuncuSecenek) {
        this.ucuncuSecenek = ucuncuSecenek;
    }

    public String getDorduncuSecenek() {
        return dorduncuSecenek;
    }

    public void setDorduncuSecenek(String dorduncuSecenek) {
        this.dorduncuSecenek = dorduncuSecenek;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public String getDogruCevap() {
        return dogruCevap;
    }

    public void setDogruCevap(String dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    public List<Soru> getList() {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<Soru> list) {
        this.list = list;
    }

    public List<String> getCevapList() {
        if (this.cevapList == null) {
            this.cevapList = new ArrayList<>();
        }
        return cevapList;
    }

    public void setCevapList(List<String> cevapList) {
        this.cevapList = cevapList;
    }
}
