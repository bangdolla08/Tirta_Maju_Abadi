package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;

public class MD_Full_po_bahan_dasar {
    private String no_po,rencana_kirim,unit;
    private int id_barang,permintaan;
    private MD_Bahan_metah md_bahan_mentah;
    private loadAllData lD;
    private MD_Produk mdp;

    public MD_Full_po_bahan_dasar() {
    }
    
    public MD_Full_po_bahan_dasar(String no_po, MD_Produk mdp, int permintaan, String unit, String rencana_kirim) {
        this.no_po = no_po;
        this.rencana_kirim = rencana_kirim;
        this.permintaan = permintaan;
        this.id_barang=mdp.getId_produk();
        this.unit=unit;
        this.mdp=mdp;
    }
    
    public MD_Full_po_bahan_dasar(String no_po, int id_barang, int permintaan, String unit, String rencana_kirim) {
        this.no_po = no_po;
        this.rencana_kirim = rencana_kirim;
        this.id_barang = id_barang;
        this.permintaan = permintaan;
        this.unit=unit;
    }

    public MD_Produk getMdp() {
        return mdp;
    }

    public void setMdp(MD_Produk mdp) {
        this.mdp = mdp;
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

    public int getpermintaan() {
        return permintaan;
    }

    public void setPermintaan(int permintaan) {
        this.permintaan = permintaan;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
