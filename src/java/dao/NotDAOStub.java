/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Not;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bbestamis
 */
public class NotDAOStub{
    
    private List<Not> notList = null;
    public void create(Not note) {
        try {
            this.getNotList().add(note);
            System.out.println("Not sisteme eklendi");
            System.out.println("Not: "+note.getNote());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Not> read(int kullanici_id , int konu_id, int dil_id) {
        
        List<Not> list = new ArrayList<>();
        try {
            
            for (int i = 0; i < this.getNotList().size(); i++) {
              
                if(this.getNotList().get(i).getKullanici_id() == kullanici_id && this.getNotList().get(i).getKonu_id() == konu_id && this.getNotList().get(i).getDil_id() == dil_id){
                    list.add(this.getNotList().get(i));
                    System.out.println("Kullanıcının, dilin ve konunun "+(i+1)+". notu: "+this.getNotList().get(i).getNote());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public List<Not> read(int kullanici_id) {
        List<Not> list = new ArrayList<>();
        try {
            for (int i = 0; i < this.getNotList().size(); i++) {
                if(this.getNotList().get(i).getKullanici_id() == kullanici_id){
                    list.add(notList.get(i));
                    System.out.println("Kullanıcının "+(i+1)+". notu: "+list.get(i).getNote());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void delete(Not note) {
       int a = 0;
        try {
            for (int i = 0; i < this.getNotList().size(); i++) {
                if (this.getNotList().get(i).getNote_id() == note.getNote_id()) {
                    this.getNotList().remove(i);
                    System.out.println("Not Sistemden Silindi");
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                System.out.println("Silinecek Not Bulunamadı");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Not> getNotList() {
        if (this.notList == null) {
            notList = new ArrayList<>();
            Not not1 = new Not(1,"Bir programda farklı veri tipleriyle işlem yapmamız gerekebilir.",2,1,3);
            Not not2 = new Not(2,"Final nitelemli bir değişken java’da bir sabit (constant) yerine geçer.",2,2,2);
            notList.add(not1);
            notList.add(not2);
        }
        return notList;
    }
}