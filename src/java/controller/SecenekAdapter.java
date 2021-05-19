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
public class SecenekAdapter {

    public SecenekAdapter() {
    }
    private String cevap1;
    private String cevap2;
    private String cevap3;
    private String cevap4;
    private SinavController sinavController;
    public String SecenekCevir(String cevap){
        System.out.println(cevap);
        String cevap1;
            if(cevap.equals("1")){
                cevap1 = getCevap1();
                System.out.println("cevap = " + getCevap1());
            }else if(cevap.equals("2")){
                cevap1 = getCevap2();
                System.out.println("cevap = " + getCevap2());
            }else if(cevap.equals("3")){
                cevap1 = getCevap3();
                System.out.println("cevap = " + getCevap3());
            }else if(cevap.equals("4")){
                cevap1 = getCevap4();
                System.out.println("cevap = " + getCevap4());
            }else{
                cevap1 = "Boş";
           }
            return cevap1;
    }

    public SinavController getSinavController() {
        if(this.sinavController == null){
            this.sinavController = new SinavController();
        }
    
        return sinavController;
    }

    public void setSinavController(SinavController sinavController) {
        this.sinavController = sinavController;
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