/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

/**
 *
 * @author NEEZAR
 */
public class MD_Galon_cacat {
    private String No_surat_jalan;
    private int banyak;
    private boolean Treatment,Pecah;
    
    public MD_Galon_cacat(String No_surat_jalan, boolean Treatment, boolean Pecah, int banyak){
        this.No_surat_jalan=No_surat_jalan;
        this.Treatment=Treatment;
        this.Pecah=Pecah;
        this.banyak=banyak;
    }
    public MD_Galon_cacat(){
        this.No_surat_jalan=null;
        this.Treatment=false;
        this.Pecah=false;
        this.banyak=0;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public String getNo_urut() {
        return No_surat_jalan;
    }

    public boolean getTreatment() {
        return Treatment;
    }

    public boolean getPecah() {
        return Pecah;
    }

    public void setNo_urut(String No_surat_jalan) {
        this.No_surat_jalan = No_surat_jalan;
    }

    public void setTreatment(boolean Treatment) {
        this.Treatment = Treatment;
    }

    public void setPecah(boolean Pecah) {
        this.Pecah = Pecah;
    }
    
}
