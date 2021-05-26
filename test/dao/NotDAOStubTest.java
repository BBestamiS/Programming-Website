/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kullanici;
import entity.Not;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bbestamis
 */
public class NotDAOStubTest {
    NotDAOStub notDAOStub;
     Not not1 = null;
     Not not2 = null;
    
    public NotDAOStubTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        notDAOStub = new NotDAOStub();
        not1 = new Not(3,"Burası önemli",1,1,1);
        not2 = new Not(2,"Final nitelemli bir değişken java’da bir sabit (constant) yerine geçer.",2,2,2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class KullaniciDAOStub.
     */
    @Test
    public void testCreate() {
        System.out.println("--------------");
        System.out.println("Not Ekle");
        Not not = not1;
        notDAOStub.create(not);
    }
    
    @Test
    public void testKullaniciNotGetir() {
        System.out.println("--------------");
        System.out.println("Kullanıcının Notlarını Listele");
        notDAOStub.read(2);
    }
    
    @Test
    public void testKonuyaAitNotGetir() {
        System.out.println("--------------");
        System.out.println("Konuya Ait Notları Listele");
        notDAOStub.read(2, 2, 2);
    }
    
    
    @Test
    public void testOlmayanNotuSil() {
        System.out.println("--------------");
        System.out.println("Olmayan Notu Sil");
        notDAOStub.delete(not1);
    }
    @Test
    public void testNotuSil() {
        System.out.println("--------------");
        System.out.println("Notu Sil");
        notDAOStub.delete(not2);
    }
    
}
