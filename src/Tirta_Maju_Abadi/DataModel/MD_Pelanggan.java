/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEEZAR
 */
public class MD_Pelanggan {
    private int Id_pelanggan,Tipe_pembayaran;
    private String Nama,Alamat,No_telepon;
    private List<MD_Harga_pelanggan> listHargag=new ArrayList<MD_Harga_pelanggan>();
    private database db;
    private loadAllData lAD;
    
    private List<list2Values> list=new ArrayList<>();
    public void list(ModelChuser mc){
        mc.setModel(list);
    }
    private void setTypePembayaran(){
        list.add(new list2Values("COD", 1));
        list.add(new list2Values("Before Purching", 2));
    }
    public list2Values cariType(int a){
        list2Values l2v=null;
        for(list2Values l2vtmp :list){
            if(l2vtmp.sama(a)){
                l2v=l2vtmp;
                break;
            }                
        }
        return l2v;
    }
    @Override
    public String toString() {
        return getId_Pelanggan()+" | "+getNama(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MD_Pelanggan(int Id_pelanggan, String Nama,
            String Alamat, int Tipe_pembayaran,String No_telepon,database db,loadAllData lAD){
        this.Id_pelanggan=Id_pelanggan;
        setTypePembayaran();
        this.Nama=Nama;
        this.Alamat=Alamat;
        this.No_telepon=No_telepon;
        this.Tipe_pembayaran=Tipe_pembayaran;
        this.db=db;
        listHargag.clear();
        this.lAD=lAD;
        setHarga();
    }
    public List<MD_Harga_pelanggan> getlistHarga(){
        return listHargag;
    }
    public MD_Pelanggan(int Id_pelanggan, String Nama,
            String Alamat, int Tipe_pembayaran){
        setTypePembayaran();
        this.Id_pelanggan=Id_pelanggan;
        this.Nama=Nama;
        this.Alamat=Alamat;
        this.Tipe_pembayaran=Tipe_pembayaran;
        listHargag.clear();
    }
    
    private void setHarga(){
        try {
            
            //ResultSet rs=db.getRs("select * from harga_pelanggan where Id_pelanggan='"+Id_pelanggan+"'");
            ///while (rs.next()) {      
            for(MD_Harga_pelanggan mhp:lAD.getListMD_Harga_pelanggan().getAll()){
//                System.out.println(mhp.getId_pelanggan()+"|"+mhp.getHarga());
                if(mhp.getId_pelanggan()==Id_pelanggan){
                    addListHarga(mhp);
//                    System.out.println(mhp.getId_pelanggan()+"|"+mhp.getHarga());
                }
                //System.out.println(rs.getInt("Id_produk")+"|"+rs.getInt("Harga"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addListHarga(MD_Harga_pelanggan mhp){
        listHargag.add(mhp);
    }
    
    public MD_Pelanggan(){
        setTypePembayaran();
        this.Id_pelanggan=0;
        this.Nama=null;
        this.Alamat=null;
        this.No_telepon=No_telepon;
        this.Tipe_pembayaran=0;
    }

    public String getNo_telepon() {
        return No_telepon;
    }

    public void setNo_telepon(String No_telepon) {
        this.No_telepon = No_telepon;
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
   
   public int getTipe_pembayaran(){
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
   
   public void setTipe_pembayaran(int Tipe_pembayaran){
       this.Tipe_pembayaran=Tipe_pembayaran;
   }
}
