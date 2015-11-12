package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MD_Full_Piutang {
    private String No_PO;
    private String no_nota_piutang;
    private String nama_barang;
    private int harga_barang;
    private int bnyk_barang;
    private loadAllData lD;
    private database db;

    private List<MD_Full_Piutang> listPiutang=new ArrayList<MD_Full_Piutang>();
    
    public MD_Full_Piutang(String No_PO, String no_nota_piutang, String nama_barang, int harga_barang, int bnyk_barang) {
        this.No_PO = No_PO;
        this.no_nota_piutang = no_nota_piutang;
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
        this.bnyk_barang = bnyk_barang;
    }

    public MD_Full_Piutang() {
        this.No_PO = null;
        this.no_nota_piutang = null;
        this.nama_barang = null;
        this.harga_barang = 0;
        this.bnyk_barang = 0;
    }

    public void isiListDB(){
        try {
            ResultSet rs=db.getRs("select * from full_piutang");
            while(rs.next()){
                addTOList((new MD_Full_Piutang(rs.getString("No_PO"), 
                        rs.getString("no_nota_piutang"), 
                        rs.getString("nama_barang"),
                        rs.getInt("harga_barang"),
                        rs.getInt("banyak_barang"))));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public List<MD_Full_Piutang> getListPiutang() {
        return listPiutang;
    }

    public void setListPiutang(List<MD_Full_Piutang> listPiutang) {
        this.listPiutang = listPiutang;
    }
    
    public void addTOList(MD_Full_Piutang mfp){
        listPiutang.add(mfp);
    }
    
    public String getNo_PO() {
        return No_PO;
    }

    public void setNo_PO(String No_PO) {
        this.No_PO = No_PO;
    }

    public String getNo_nota_piutang() {
        return no_nota_piutang;
    }

    public void setNo_nota_piutang(String no_nota_piutang) {
        this.no_nota_piutang = no_nota_piutang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }

    public int getBnyk_barang() {
        return bnyk_barang;
    }

    public void setBnyk_barang(int bnyk_barang) {
        this.bnyk_barang = bnyk_barang;
    }
    
}
