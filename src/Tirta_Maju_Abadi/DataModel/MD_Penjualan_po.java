
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MD_Penjualan_po {
    private int Id_pelanggan;
    private String No_nota, No_po;
    private ResultSet rs;
    private database db;
    public MD_Penjualan_po(int Id_pelanggan, String No_nota, String No_po,database db){
        this.Id_pelanggan=Id_pelanggan;
        this.No_nota=No_nota;
        this.No_po=No_po;
        this.db=db;
        listMD_Full_penjualan();
    }
    public MD_Penjualan_po(int Id_pelanggan, String No_nota, String No_po){
        this.Id_pelanggan=Id_pelanggan;
        this.No_nota=No_nota;
        this.No_po=No_po;
        listFull.clear();
    }
    
    public void add_full_penjualan(MD_Full_penjualan tmp){
        listFull.add(tmp);
    }
    
    private List<MD_Full_penjualan> listFull=new ArrayList<MD_Full_penjualan>();
    
    public void listMD_Full_penjualan(){
        listFull.clear();
        try {
            rs=db.getRs("select * from full_penjualan where No_nota='"+No_nota+"'");
            while(rs.next()){
                listFull.add(new MD_Full_penjualan(rs.getInt("Id_produk"), 
                        rs.getInt("Banyak"), 
                        rs.getString("No_nota")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    } 

    public List<MD_Full_penjualan> getListFull() {
        return listFull;
    }

    public void setListFull(List<MD_Full_penjualan> listFull) {
        this.listFull = listFull;
    }
    
    public MD_Penjualan_po(){
        this.Id_pelanggan=0;
        this.No_nota=null;
        this.No_po=null;
    }
    
    public int getId_pelanggan(){
        return Id_pelanggan;
    }
    public String getNo_nota(){
     return No_nota;
    }
    public String getNo_po(){
        return No_po;
    }
    
    public void setId_pelanggan(int Id_pelanggan){
        this.Id_pelanggan=Id_pelanggan;
    }
    public void setNo_nota(String No_nota){
        this.No_nota=No_nota;
    }
    public void setNo_po(String No_po){
        this.No_po=No_po;
    }
}
