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
public class MD_Gudang_barang_jadi {
    private String Koordinator, Shift, Operator;
    private int Id_produk, Banyak;
    
    public MD_Gudang_barang_jadi(int Id_produk,
            int Banyak,
            String Koordinator,
            String Operator,
            String Shift){
        this.Banyak=Banyak;
        this.Shift=Shift;
        this.Koordinator=Koordinator;
        this.Operator=Operator;
        this.Id_produk=Id_produk;
    }
    
    public  MD_Gudang_barang_jadi(){
        this.Banyak=0;
        this.Id_produk=0;
        this.Koordinator=null;
        this.Operator=null;
        this.Shift=null;
    }

    public String getKoordinator() {
        return Koordinator;
    }

    public String getShift() {
        return Shift;
    }

    public String getOperator() {
        return Operator;
    }

    public int getId_produk() {
        return Id_produk;
    }

    public int getBanyak() {
        return Banyak;
    }

    public void setKoordinator(String Koordinator) {
        this.Koordinator = Koordinator;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    public void setOperator(String Operator) {
        this.Operator = Operator;
    }

    public void setId_produk(int Id_produk) {
        this.Id_produk = Id_produk;
    }

    public void setBanyak(int Banyak) {
        this.Banyak = Banyak;
    }
    
    
}
