/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bbestamis
 */
public class KullaniciDAOStub extends KullaniciDAO {

    private List<Kullanici> kullaniciList = null;

    @Override
    public Kullanici login(Kullanici kullanici) {
        Kullanici tmp = null;
        List<Kullanici> list = new ArrayList<>();
        try {
            list = getKullaniciList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmail().equals(kullanici.getEmail()) && list.get(i).getParola().equals(kullanici.getParola())) {
                    tmp = list.get(i);
                    System.out.println("Kullanıcı e-Posta ve Şifresi doğru");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (tmp == null) {
            System.out.println("e-Posta veya Şifre Hatalı");
        }
        return tmp;
    }

    @Override
    public void create(Kullanici kullanici) {
        int a = 0;
        try {
            for (int i = 0; i < this.getKullaniciList().size(); i++) {
                if (this.getKullaniciList().get(i).getEmail() == kullanici.getEmail() && this.getKullaniciList().get(i).getParola() == kullanici.getParola()) {
                    kullaniciList.add(kullanici);
                    System.out.println("Aynı e-Posta ve Parolaya sahip kullanıcılar var");
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                System.out.println("Sisteme eklendi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Kullanici kullanici) {
        int a = 0;
        try {
            for (int i = 0; i < this.getKullaniciList().size(); i++) {
                if (this.getKullaniciList().get(i).getKullanici_id() == kullanici.getKullanici_id()) {
                    kullaniciList.remove(i);
                    System.out.println("Kullanıcı Sistemden silindi");
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                System.out.println("Silinecek Kullanıcı Bulunamadı");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Kullanici> getKullaniciList() {
        if (this.kullaniciList == null) {
            kullaniciList = new ArrayList<>();
            Kullanici kul1 = new Kullanici(1, "beyazıt", "deneme@outlook.com", "123");
            Kullanici kul2 = new Kullanici(2, "ali", "deneme1@outlook.com", "asd");
            kullaniciList.add(kul1);
            kullaniciList.add(kul2);
        }
        return kullaniciList;
    }

}
