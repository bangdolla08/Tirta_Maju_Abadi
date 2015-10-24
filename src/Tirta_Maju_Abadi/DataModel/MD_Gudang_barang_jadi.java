/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEEZAR
 */
public class MD_Gudang_barang_jadi {
    private String Koordinator, Operator;
    private int Id_produk, Banyak, Grup;
    
    private List<list2Values> list=new ArrayList<>();
    public void list(ModelChuser mc){
        mc.setModel(list);
    }
    
    private void setGrup(){
        list.add(new list2Values("1",1));
        list.add(new list2Values("2",2));
        list.add(new list2Values("3",3));
        list.add(new list2Values("4",4));
        list.add(new list2Values("5",5));
        list.add(new list2Values("6",6));
    }
    
    public MD_Gudang_barang_jadi(int Id_produk,
            int Banyak,
            String Koordinator,
            String Operator,
            int Grup){
        this.Banyak=Banyak;
        this.Grup=Grup;
        this.Koordinator=Koordinator;
        this.Operator=Operator;
        this.Id_produk=Id_produk;
        setGrup();
    }
    
    public  MD_Gudang_barang_jadi(){
        this.Banyak=0;
        this.Id_produk=0;
        this.Koordinator=null;
        this.Operator=null;
        this.Grup=0;
        setGrup();
    }

    public String getKoordinator() {
        return Koordinator;
    }

    public int getGrup() {
        return Grup;
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

    public void setGrup(int Grup) {
        this.Grup = Grup;
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
