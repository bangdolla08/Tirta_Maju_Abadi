package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MD_Mobil_Keluar {
    private String id_PO_keluar;
    private String nopol, tujuan;
    private MD_Mobil mdmobil;
    private Date tgl;
    private List<MD_Full_penjualan> listfull=new ArrayList<MD_Full_penjualan>();
    public MD_Mobil_Keluar(){
        
    }
    
    public MD_Mobil_Keluar(String id_PO_keluar,Date tgl,String nopol, String tujuan,database db,loadAllData lad)
    {
        this.id_PO_keluar=id_PO_keluar;
        this.nopol=nopol;
        this.mdmobil=lad.getListMD_Mobil().getMDByID(nopol);
        this.tgl=tgl;
        this.tujuan=tujuan;
    }

    public MD_Mobil getMdmobil() {
        return mdmobil;
    }

    public void setMdmobil(MD_Mobil mdmobil) {
        this.mdmobil = mdmobil;
    }

    public String getId_bo() {
        return id_PO_keluar;
    }

    public void setId_bo(String id_PO_keluar) {
        this.id_PO_keluar = id_PO_keluar;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getId_PO_keluar() {
        return id_PO_keluar;
    }

    public void setId_PO_keluar(String id_PO_keluar) {
        this.id_PO_keluar = id_PO_keluar;
    }

    public List<MD_Full_penjualan> getListfull() {
        return listfull;
    }

    public void setListfull(List<MD_Full_penjualan> listfull) {
        this.listfull = listfull;
    }
    
}
