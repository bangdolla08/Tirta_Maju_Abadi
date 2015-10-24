/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;

/**
 *
 * @author NEEZAR
 */
public class MD_Supplier {
    private int Id_supplier;
    private boolean Ppn;
    private String Nama,
            Alamat,
            No_telepon1,
            No_telepon2,
            Email,
            No_rekening1,
            No_rekening2;
    
    public MD_Supplier(int Id_supplier,
            boolean Ppn,
            String Nama,
            String Alamat,
            String No_telepon1,
            String No_telepon2,
            String Email,
            String No_rekening1,
            String No_rekening2){
        this.Id_supplier=Id_supplier;
        this.Nama=Nama;
        this.Alamat=Alamat;
        this.No_telepon1=No_telepon1;
        this.No_telepon2=No_telepon2;
        this.Email=Email;
        this.Ppn=Ppn;
        this.No_rekening1=No_rekening1;
        this.No_telepon2=No_rekening2;
    }
    public MD_Supplier(){
        this.Id_supplier=0;
        this.Nama=null;
        this.Alamat=null;
        this.No_telepon1=null;
        this.No_telepon2=null;
        this.Email=null;
        this.Ppn=false;
        this.No_rekening1=null;
        this.No_rekening2=null;
    }

    public void setId_supplier(int Id_supplier) {
        this.Id_supplier = Id_supplier;
    }

    public void setPpn(boolean Ppn) {
        this.Ppn = Ppn;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public void setNo_telepon1(String No_telepon1) {
        this.No_telepon1 = No_telepon1;
    }

    public void setNo_telepon2(String No_telepon2) {
        this.No_telepon2 = No_telepon2;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNo_rekening1(String No_rekening1) {
        this.No_rekening1 = No_rekening1;
    }

    public void setNo_rekening2(String No_rekening2) {
        this.No_rekening2 = No_rekening2;
    }

    public int getId_supplier() {
        return Id_supplier;
    }

    public boolean isPpn() {
        return Ppn;
    }

    @Override
    public String toString() {
        return getNama(); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getNama() {
        return Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getNo_telepon1() {
        return No_telepon1;
    }

    public String getNo_telepon2() {
        return No_telepon2;
    }

    public String getEmail() {
        return Email;
    }

    public String getNo_rekening1() {
        return No_rekening1;
    }

    public String getNo_rekening2() {
        return No_rekening2;
    }
}
