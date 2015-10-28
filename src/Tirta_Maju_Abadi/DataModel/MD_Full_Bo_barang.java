package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;

public class MD_Full_Bo_barang {
    private int no_bo;
    private String nama_barang;
    private int estimasi_harga;
    private loadAllData lD;
    private MD_Produk mp;
    
    private List <MD_Full_Bo_barang> listfullDb=new ArrayList<MD_Full_Bo_barang>();

    public List<MD_Full_Bo_barang> getListfullDb() {
        return listfullDb;
    }

    public void setListfullDb(List<MD_Full_Bo_barang> listfullDb) {
        this.listfullDb = listfullDb;
    }
    
    public MD_Full_Bo_barang(int no_bo, String nama_barang, int estimasi_harga) {
        this.no_bo = no_bo;
        this.nama_barang = nama_barang;
        this.estimasi_harga = estimasi_harga;
    }
    
    public MD_Full_Bo_barang(int no_bo, MD_Produk mp, int estimasi){
        this.nama_barang=mp.getNama_produk();
        this.no_bo=no_bo;
        this.estimasi_harga=estimasi;
    }
    
    public void addToList(MD_Full_Bo_barang mf){
        listfullDb.add(mf);
    }

    public MD_Produk getMp() {
        return mp;
    }

    public void setMp(MD_Produk mp) {
        this.mp = mp;
    }
    
        
    public int getNo_bo() {
        return no_bo;
    }

    public void setNo_bo(int no_bo) {
        this.no_bo = no_bo;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getEstimasi_harga() {
        return estimasi_harga;
    }

    public void setEstimasi_harga(int estimasi_harga) {
        this.estimasi_harga = estimasi_harga;
    }
    
    
}
