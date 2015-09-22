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
public class MD_Pelanggan {
    private int Id_pelanggan;
    private String Nama,Alamat,Tipe_pembayaran;
    
    public MD_Pelanggan(int Id_pelanggan, String Nama,
            String Alamat, String Tipe_pembayaran){
        this.Id_pelanggan=Id_pelanggan;
        this.Nama=Nama;
        this.Alamat=Alamat;
        this.Tipe_pembayaran=Tipe_pembayaran;
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
