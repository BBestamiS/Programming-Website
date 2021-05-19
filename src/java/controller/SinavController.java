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
public class SinavController implements Serializable {

    private Sinav sinav;
    private SinavDAO sinavDAO = SinavDAO.getSinavDAO();
    private Sonuc sonuc;
    private int control;
    private int sayfaControl;
    private List<Sinav> list;
    private List<String> cevapList;
    private List<Sonuc> sonucList;
    private SecenekAdapter secenekAdapter;
    private DuzSecenek duzSecenek;
    private String bar1;
    private String bar2;
    private String bar3;
    private int barControl;

    public String bitir() {
        this.getSonucList().clear();
        String isaretlenmisCevap;
        String dogruCevap;
        for (int i = 0; i < this.getList().size(); i++) {
            this.getSecenekAdapter().setCevap1(this.getList().get(i).getCevap_bir());
            this.getSecenekAdapter().setCevap2(this.getList().get(i).getCevap_iki());
            this.getSecenekAdapter().setCevap3(this.getList().get(i).getCevap_uc());
            this.getSecenekAdapter().setCevap4(this.getList().get(i).getCevap_dort());
            this.getDuzSecenek().setSecenek(this.getCevapList().get(i + 1));
            this.getDuzSecenek().setDogruSecenek(this.getList().get(i).getCevap_dogru());
            isaretlenmisCevap = this.getSoruAdapter().SecenekCevir(this.getDuzSecenek().getSecenek());
            dogruCevap = this.getSoruAdapter().SecenekCevir(this.getDuzSecenek().getDogruSecenek());
            if (this.getCevapList().get(i + 1).equals(this.getList().get(i).getCevap_dogru())) {
                Sonuc tmp = new Sonuc(this.getList().get(i).getSoru(), dogruCevap, isaretlenmisCevap, "Doğru");
                this.getSonucList().add(tmp);
            } else {
                Sonuc tmp = new Sonuc(this.getList().get(i).getSoru(), dogruCevap, isaretlenmisCevap, "Yanlış");
                this.getSonucList().add(tmp);
            }
        }
        temizle();

        return "result";
    }

    public String flutterbar() {
        this.setBarControl(1);
        this.setBar1("background-color: #198754; width: " + 30 + "%");
        this.setBar2("background-color: #0dcaf0; width: " + 60 + "%");
        this.setBar3("background-color: #ffc107; width: " + 90 + "%");
        return "profile";
    }

    public String swiftbar() {
        this.setBarControl(1);
        this.setBar1("background-color: #ffc107; width: " + 90 + "%");
        this.setBar2("background-color: #198754; width: " + 30 + "%");
        this.setBar3("background-color: #0dcaf0; width: " + 60 + "%");
        return "profile";
    }

    public String javabar() {
        this.setBarControl(1);
        this.setBar1("background-color: #0dcaf0; width: " + 60 + "%");
        this.setBar2("background-color: #ffc107; width: " + 90 + "%");
        this.setBar3("background-color: #198754; width: " + 30 + "%");
        return "profile";
    }

    public String getBarBir() {
        if (this.getBarControl() == 0) {
            return "background-color: #198754; width: " + 30 + "%";
        }
        return this.getBar1();
    }

    public String getBarIki() {
        if (this.getBarControl() == 0) {
            return "background-color: #0dcaf0; width: " + 60 + "%";
        }
        return this.getBar2();
    }

    public String getBarUc() {
        if (this.getBarControl() == 0) {
            return "background-color: #ffc107; width: " + 90 + "%";
        }
        return this.getBar3();
    }

    public Sinav getSoru() {
        this.setList(this.sinavDAO.read());
        this.getSinav().setSoru(this.getList().get(getControl()).getSoru());
        this.getSinav().setCevap_bir(this.getList().get(getControl()).getCevap_bir());
        this.getSinav().setCevap_iki(this.getList().get(getControl()).getCevap_iki());
        this.getSinav().setCevap_uc(this.getList().get(getControl()).getCevap_uc());
        this.getSinav().setCevap_dort(this.getList().get(getControl()).getCevap_dort());
        this.getSinav().setCevap_dogru(this.getList().get(getControl()).getCevap_dogru());

        return this.sinav;
    }

    public void temizle() {
        this.sayfaControl = 0;
        for (int i = 0; i <= 5; i++) {
            this.cevapList.set(i, null);
        }
        this.control = 0;
    }

    public String cevapEkle(String cevap) {
        getCevapList().set(control + 1, cevap);
        return "quiz";
    }

    public String secim() {
        return this.getCevapList().get(control + 1);
    }

    public Sinav getSinav() {
        if (this.sinav == null) {
            this.sinav = new Sinav();
        }
        return sinav;
    }

    public void setSinav(Sinav sinav) {
        this.sinav = sinav;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public List<Sinav> getList() {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<Sinav> list) {
        this.list = list;
    }

    public String setControlArttir() {
        if (getControl() == 4) {
            return "quiz";
        }
        setControl(getControl() + 1);
        System.out.println(this.getControl());
        return "quiz";
    }

    public String setControlAzalt() {
        if (getControl() == 0) {
            return "quiz";
        }
        setControl(getControl() - 1);
        return "quiz";
    }

    public List<String> getCevapList() {
        if (this.cevapList == null) {
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
        if (this.sonuc == null) {
            this.sonuc = new Sonuc();
        }
        return sonuc;
    }

    public void setSonuc(Sonuc sonuc) {
        this.sonuc = sonuc;
    }

    public List<Sonuc> getSonucList() {
        if (this.sonucList == null) {
            this.sonucList = new ArrayList<>();
        }
        return sonucList;
    }

    public void setSonucList(List<Sonuc> sonucList) {
        this.sonucList = sonucList;
    }

    public String sayfaGecis(String sayfa) {
        this.sayfaControl = 0;
        System.out.println(this.getSayfaControl());
        return sayfa;
    }

    public String sinavaBasla() {
        this.setSayfaControl(1);
        return "quiz";
    }

    public int getSayfaControl() {
        return sayfaControl;
    }

    public void setSayfaControl(int sayfaControl) {
        this.sayfaControl = sayfaControl;
    }

    public SinavDAO getSinavDAO() {
        return sinavDAO;
    }

    public void setSinavDAO(SinavDAO sinavDAO) {
        this.sinavDAO = sinavDAO;
    }

    public String getBar1() {
        return bar1;
    }

    public void setBar1(String bar1) {
        this.bar1 = bar1;
    }

    public String getBar2() {
        return bar2;
    }

    public void setBar2(String bar2) {
        this.bar2 = bar2;
    }

    public String getBar3() {
        return bar3;
    }

    public void setBar3(String bar3) {
        this.bar3 = bar3;
    }

    public int getBarControl() {
        return barControl;
    }

    public void setBarControl(int barControl) {
        this.barControl = barControl;
    }

    

    public SecenekAdapter getSoruAdapter() {
        if (this.secenekAdapter == null) {
            this.secenekAdapter = new SecenekAdapter();
        }
        return secenekAdapter;
    }

    public SecenekAdapter getSecenekAdapter() {
        if(this.secenekAdapter == null){
            this.secenekAdapter = new SecenekAdapter();
        }
        return secenekAdapter;
    }

    public void setSecenekAdapter(SecenekAdapter secenekAdapter) {
        this.secenekAdapter = secenekAdapter;
    }

    public DuzSecenek getDuzSecenek() {
        if(this.duzSecenek == null){
            this.duzSecenek = new DuzSecenek();
        }
        return duzSecenek;
    }

    public void setDuzSecenek(DuzSecenek duzSecenek) {
        this.duzSecenek = duzSecenek;
    }
    
}
