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
public class SecenekAdapterStub {

    public SecenekAdapterStub() {
    }
    private String cevap1;
    private String cevap2;
    private String cevap3;
    private String cevap4;
    public String SecenekCevir(String cevap){
        cevapDoldur();
        String donusturulmus;
            if(cevap.equals("1")){
                donusturulmus = getCevap1();
            }else if(cevap.equals("2")){
                donusturulmus = getCevap2();
            }else if(cevap.equals("3")){
                donusturulmus = getCevap3();
            }else if(cevap.equals("4")){
                donusturulmus = getCevap4();
            }else{
                donusturulmus = "Boş";
           }
            System.out.println("Tüm Şıklar = 1-"+getCevap1()+" 2-"+getCevap2()+" 3-"+getCevap3()+" 4-"+getCevap4());
            System.out.println("Gelen Cevap = "+cevap);
            System.out.println("Çevrilen Cevap = "+donusturulmus);
            return donusturulmus;
    }
    public void cevapDoldur(){
        this.setCevap1("Main fonksiyonunun bulunduğu dosyadır");
        this.setCevap2("Projenin konfigürasyon dosyasıdır");
        this.setCevap3("Tasarım oluşturmak için kullanılır");
        this.setCevap4("Projenin derlenmesini sağlar");
    }

    public String getCevap1() {
        return cevap1;
    }

    public void setCevap1(String cevap1) {
        this.cevap1 = cevap1;
    }

    public String getCevap2() {
        return cevap2;
    }

    public void setCevap2(String cevap2) {
        this.cevap2 = cevap2;
    }

    public String getCevap3() {
        return cevap3;
    }

    public void setCevap3(String cevap3) {
        this.cevap3 = cevap3;
    }

    public String getCevap4() {
        return cevap4;
    }

    public void setCevap4(String cevap4) {
        this.cevap4 = cevap4;
    }

}