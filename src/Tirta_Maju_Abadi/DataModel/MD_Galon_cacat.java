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
    private int No_urut;
    private String Treatment,Pecah;
    
    public MD_Galon_cacat(int No_urut, String Treatment, String Pecah){
        this.No_urut=No_urut;
        this.Treatment=Treatment;
        this.Pecah=Pecah;
    }
    public MD_Galon_cacat(){
        this.No_urut=0;
        this.Treatment=null;
        this.Pecah=null;
    }

    public int getNo_urut() {
        return No_urut;
    }

    public String getTreatment() {
        return Treatment;
    }

    public String getPecah() {
        return Pecah;
    }

    public void setNo_urut(int No_urut) {
        this.No_urut = No_urut;
    }

    public void setTreatment(String Treatment) {
        this.Treatment = Treatment;
    }

    public void setPecah(String Pecah) {
        this.Pecah = Pecah;
    }
    
}
