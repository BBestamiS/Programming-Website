/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.SecenekAdapterStub;
import controller.SinavControllerStub;
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
public class SinavControllerStubTest {
    SecenekAdapterStub secenekAdapterStub;
    SinavControllerStub sinavControllerStub;
    String cevap1;
    String cevap2;
    String cevap3;
    
    public SinavControllerStubTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        secenekAdapterStub = new SecenekAdapterStub();
        sinavControllerStub = new SinavControllerStub();
        cevap1 = "Main fonksiyonunun bulunduğu dosyadır";
        cevap2 = "2";
        cevap3 = "Widgettir";
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class KullaniciDAOStub.
     */
    @Test
    public void testSoruKontrol() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Soru Kontrol");
        String expResult = "1-Yanlış 2-Doğru 3-Yanlış ";
        sinavControllerStub.cevapDoldur(cevap1, cevap2, cevap3);
        String result = sinavControllerStub.bitir();
        assertEquals(expResult, result);
    }
    @Test
    public void testAdaptorKontrol() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Adaptor Kontrol");
        String expResult = "Main fonksiyonunun bulunduğu dosyadır";
        
        String result = secenekAdapterStub.SecenekCevir("1");
        assertEquals(expResult, result);
    }
    @Test
    public void testBosCevapKontrol() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Boş Cevap Kontrol");
        String expResult = "Boş";
        String result = secenekAdapterStub.SecenekCevir("");
        assertEquals(expResult, result);
    }
    @Test
    public void testCevaplariTemizle(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Cevapları Temizle");
        sinavControllerStub.cevapDoldur(cevap1, cevap2, cevap3);
        String expResult = "Temizlendi";
        String result = sinavControllerStub.temizle();
        assertEquals(expResult, result);
    }
}
