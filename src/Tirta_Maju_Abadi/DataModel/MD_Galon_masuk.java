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
public class MD_Galon_masuk {
    private String Tanggal;
    private int No_urut,Banyak_masuk,Id_pelanggan;
    
    public MD_Galon_masuk(int No_urut, 
            int Banyak_masuk, String Tanggal, int Id_pelanggan){
        this.No_urut=No_urut;
        this.Banyak_masuk=Banyak_masuk;
        this.Tanggal=Tanggal;
        this.Id_pelanggan=Id_pelanggan;
    }
    public MD_Galon_masuk(){
        this.No_urut=0;
        this.Banyak_masuk=0;
        this.Tanggal=null;
        this.Id_pelanggan=0;
    }
    
    public int getNo_urut(){
        return No_urut;
    }
    public int getBanyak_masuk(){
        return Banyak_masuk;
    }
    public String getTanggal(){
        return Tanggal;
    }
    public int getId_pelanggan(){
        return Id_pelanggan;
    }
    
    public void setNo_urut(int No_urut){
        this.No_urut=No_urut;
    }
    public void setBanyak_masuk(int Banyak_masuk){
        this.Banyak_masuk=Banyak_masuk;
    }
    public void setTanggal(String Tanggal){
        this.Tanggal=Tanggal;
    }
    public void setId_pelanggan(int Id_pelanggan){
        this.Id_pelanggan=Id_pelanggan;
    }
}
