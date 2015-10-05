package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;

public class MD_Full_po_bahan_dasar {
    private String no_po,rencana_kirim;
    private int id_barang,banyak;
    private MD_Bahan_metah md_bahan_mentah;
    private loadAllData lD;

    public MD_Full_po_bahan_dasar() {
    }
    
    public MD_Full_po_bahan_dasar(String no_po, int id_barang, int banyak, String rencana_kirim) {
        this.no_po = no_po;
        this.rencana_kirim = rencana_kirim;
        this.id_barang = id_barang;
        this.banyak = banyak;
    }
    
    public MD_Produk getModel_produk(){
        return lD.getListMD_Produk().getMDByID(id_barang);
    }

    public String getNo_po() {
        return no_po;
    }

    public void setNo_po(String no_po) {
        this.no_po = no_po;
    }

    public String getRencana_kirim() {
        return rencana_kirim;
    }

    public void setRencana_kirim(String rencana_kirim) {
        this.rencana_kirim = rencana_kirim;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }
}
