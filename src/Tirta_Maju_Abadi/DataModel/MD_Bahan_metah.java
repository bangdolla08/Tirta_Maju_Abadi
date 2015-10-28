package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;

public class MD_Bahan_metah {
    private int id_bahan,stok,limit_buffer;
    private String nama_bahan,spesifikasi,unit;
    private loadAllData lad;
    public MD_Bahan_metah() {
        this.id_bahan = 0;
        this.stok = 0;
        this.limit_buffer = 0;
        this.nama_bahan = null;
        this.spesifikasi = null;
        this.unit = null;
    }
    
    @Override
    public String toString(){
        return nama_bahan;
    }
    
    public MD_Bahan_metah(int id_bahan, int stok, int limit_buffer, String nama_bahan,  String unit, String spesifikasi, loadAllData lad) {
        this.id_bahan = id_bahan;
        this.stok = stok;
        this.limit_buffer = limit_buffer;
        this.nama_bahan = nama_bahan;
        this.spesifikasi = spesifikasi;
        this.unit = unit;
        this.lad=lad;
    }
    public MD_Bahan_metah(int stok, int limit_buffer, String nama_bahan, String spesifikasi, String unit) {
        this.stok = stok;
        this.limit_buffer = limit_buffer;
        this.nama_bahan = nama_bahan;
        this.spesifikasi = spesifikasi;
        this.unit = unit;
    }
    
    public int getId_bahan() {
        return id_bahan;
    }

    public void setId_bahan(int id_bahan) {
        this.id_bahan = id_bahan;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getLimit_buffer() {
        return limit_buffer;
    }

    public void setLimit_buffer(int limit_buffer) {
        this.limit_buffer = limit_buffer;
    }

    public String getNama_bahan() {
        return nama_bahan;
    }

    public void setNama_bahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
