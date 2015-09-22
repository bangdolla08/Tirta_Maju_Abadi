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
public class MD_Keluar_gudang_bahan_mentah {
    private int Id_supplier,Banyak;
    private int No_urut;
    
    public MD_Keluar_gudang_bahan_mentah(int Id_supplier,
            int Banyak,
            int No_urut){
        this.Banyak=Banyak;
        this.No_urut=No_urut;
        this.Id_supplier=Id_supplier;
    }
    public MD_Keluar_gudang_bahan_mentah(){
        this.Id_supplier=0;
        this.Banyak=0;
        this.No_urut=0;
    }

    public int getId_supplier() {
        return Id_supplier;
    }

    public int getBanyak() {
        return Banyak;
    }

    public int getNo_urut() {
        return No_urut;
    }

    public void setId_supplier(int Id_supplier) {
        this.Id_supplier = Id_supplier;
    }

    public void setBanyak(int Banyak) {
        this.Banyak = Banyak;
    }

    public void setNo_urut(int No_urut) {
        this.No_urut = No_urut;
    }
    
}
