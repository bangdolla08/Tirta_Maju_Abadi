package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MD_Bo_barang {
    
    private database db;
    private int no_bo;
    private Date tanggal;
    private int no_pegawai;
    private int id_pegawai_acc;
    private MD_Pegawai md_pgw;
    private List<MD_Full_Bo_barang> listFull=new ArrayList<MD_Full_Bo_barang>();

    public void addlistFull(MD_Full_Bo_barang tmp){
        listFull.add(tmp);
    }

    public int getId_pegawai_acc() {
        return id_pegawai_acc;
    }

    public void setId_pegawai_acc(int id_pegawai_acc) {
        this.id_pegawai_acc = id_pegawai_acc;
    }
    

    public int getNo_bo() {
        return no_bo;
    }

    public void setNo_bo(int no_bo) {
        this.no_bo = no_bo;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getNo_pegawai() {
        return no_pegawai;
    }

    public void setNo_pegawai(int no_pegawai) {
        this.no_pegawai = no_pegawai;
    }

    public MD_Pegawai getMd_pgw() {
        return md_pgw;
    }

    public void setMd_pgw(MD_Pegawai md_pgw) {
        this.md_pgw = md_pgw;
    }

    public List<MD_Full_Bo_barang> getListFull() {
        return listFull;
    }
    
    public MD_Bo_barang(){
        this.no_bo = no_bo;
        this.tanggal = tanggal;
        this.no_pegawai = no_pegawai;
        this.id_pegawai_acc=id_pegawai_acc;
    }

    public MD_Bo_barang(int no_bo, Date tanggal, int no_pegawai, int id_pegawai_acc) {
        this.no_bo = no_bo;
        this.tanggal = tanggal;
        this.no_pegawai = no_pegawai;
        this.id_pegawai_acc=id_pegawai_acc;
    }
    

    public MD_Bo_barang(database db, int no_bo, Date tanggal, int no_pegawai, int id_pegwai_acc) {
        this.db = db;
        this.no_bo = no_bo;
        this.tanggal = tanggal;
        this.no_pegawai = no_pegawai;
        this.id_pegawai_acc=id_pegwai_acc;
        listAdd();
    }
    
    public void listAdd(){
        listFull.clear();
        try {
            ResultSet rs=db.getRs("select * from full_bo_barang where no_bo='"+no_bo+"'");
            while (rs.next()) {                
                listFull.add(new MD_Full_Bo_barang(no_bo, 
                        rs.getString("nama_barang"), 
                        rs.getInt("estimasi_harga")));
            }
        } catch (Exception e) {
        }
    }
}
