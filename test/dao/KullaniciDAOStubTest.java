/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kullanici;
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
public class KullaniciDAOStubTest {
    KullaniciDAOStub kullaniciDAOStub;
     Kullanici kullanici1 = null;
    Kullanici kullanici2 = null;
    
    public KullaniciDAOStubTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kullaniciDAOStub = new KullaniciDAOStub();
        kullanici1 = new Kullanici(1, "beyazıt", "deneme@outlook.com", "123");
       kullanici2 = new Kullanici(3, "ahmet", "deneme4@outlook.com", "321");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class KullaniciDAOStub.
     */
    @Test
    public void testLoginDogru() {
        System.out.println("--------------");
        System.out.println("login Doğru");
        Kullanici kullanici = kullanici1;
        Kullanici expResult = kullanici1;
        Kullanici result = kullaniciDAOStub.login(kullanici);
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getParola(), result.getParola());
    }
    @Test
    public void testLoginYanlıs() {
        System.out.println("--------------");
        System.out.println("login Yanlış");
        Kullanici kullanici = kullanici2;
        Kullanici expResult = null;
        Kullanici result = kullaniciDAOStub.login(kullanici);
        assertNull(result);
    }
    
    @Test
    public void testCreateFarklı() {
        System.out.println("--------------");
        System.out.println("Create Farklı");
        Kullanici kullanici = kullanici2;
        kullaniciDAOStub.create(kullanici);
    }
    @Test
    public void testCreateAynı() {
        System.out.println("--------------");
        System.out.println("Create Aynı");
        Kullanici kullanici = kullanici1;
        kullaniciDAOStub.create(kullanici);
    }
    @Test
    public void testDeleteIDVar() {
        System.out.println("--------------");
        System.out.println("Delete ID Var");
        Kullanici kullanici = kullanici1;
        kullaniciDAOStub.delete(kullanici);
    }
    @Test
    public void testDeleteIDYok() {
        System.out.println("--------------");
        System.out.println("Delete ID Yok");
        Kullanici kullanici = kullanici2;
        kullaniciDAOStub.delete(kullanici);
    }
    
}
