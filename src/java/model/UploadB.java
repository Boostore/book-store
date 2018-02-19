/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class UploadB {
    private String bnam, bwri, cont;
    private int bpri;
    
    public String getBnam() {
        return bnam;
    }
    public void setBnam(String bnam) {
        this.bnam = bnam;       
    }
    public String getBwri() {
        return bwri;
    }
    public void setBwri(String bwri) {
        this.bwri = bwri;
    }
    public int getBpri() {
        return bpri;
    }
    public void setBpri(int bpri) {
        this.bpri = bpri;
    }
    public String getCont() {
        return cont;
    }
    public void setCont(String cont) {
        this.cont = cont;
    }

    @Override
    public String toString() {
        return "UploadB{" + " bname=" + bnam + ", bwrit=" + bwri + ", bpris=" + bpri + ", contact=" + cont + "}";
    }
    
}
