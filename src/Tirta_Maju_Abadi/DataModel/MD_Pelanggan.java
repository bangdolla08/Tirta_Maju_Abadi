/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEEZAR
 */
public class MD_Pelanggan {
    private int Id_pelanggan;
    private String Nama,Alamat,Tipe_pembayaran;
    private List<MD_Harga_pelanggan> listHargag=new ArrayList<MD_Harga_pelanggan>();
    private database db;
    public MD_Pelanggan(int Id_pelanggan, String Nama,
            String Alamat, String Tipe_pembayaran,database db){
        this.Id_pelanggan=Id_pelanggan;
        this.Nama=Nama;
        this.Alamat=Alamat;
        this.Tipe_pembayaran=Tipe_pembayaran;
        this.db=db;
        listHargag.clear();
        setHarga();
    }
    public List<MD_Harga_pelanggan> getlistHarga(){
        return listHargag;
    }
    public MD_Pelanggan(int Id_pelanggan, String Nama,
            String Alamat, String Tipe_pembayaran){
        this.Id_pelanggan=Id_pelanggan;
        this.Nama=Nama;
        this.Alamat=Alamat;
        this.Tipe_pembayaran=Tipe_pembayaran;
        listHargag.clear();
    }
    
    private void setHarga(){
        try {
            ResultSet rs=db.getRs("select * from harga_pelanggan where Id_pelanggan='"+Id_pelanggan+"'");
            while (rs.next()) {      
                addListHarga(new MD_Harga_pelanggan(Id_pelanggan, rs.getInt("Id_produk"), rs.getInt("Harga")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addListHarga(MD_Harga_pelanggan mhp){
        listHargag.add(mhp);
    }
    
    public MD_Pelanggan(){
        this.Id_pelanggan=0;
        this.Nama=null;
        this.Alamat=null;
        this.Tipe_pembayaran=null;
    }
    
   public int getId_Pelanggan(){
        return Id_pelanggan;
    }
   public String getNama(){
       return Nama;
   }
    
   public String getAlamat(){
       return Alamat;               
   }
   
   public String getTipe_pembayaran(){
       return Tipe_pembayaran;
   }
   
   public void setId_pelanggan(int Id_pelanggan){
       this.Id_pelanggan=Id_pelanggan;
   }
   
   public void setNama(String Nama){
       this.Nama=Nama;
   }
   
   public void setAlamat(String Alamat){
       this.Alamat=Alamat;
   }
   
   public void setTipe_pembayaran(String Tipe_pembayaran){
       this.Tipe_pembayaran=Tipe_pembayaran;
   }
}
