
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;

/**
 *
 * @author NEEZAR
 */
public class MD_Pesan_barang {
    private String No_po, No_pemesanan;
    private int Id_supplier;
    private database db;
    private MD_Supplier MS;
    public MD_Pesan_barang(String No_po, String No_pemesanan, int id_supplier,database db){
        this.No_po=No_po;
        this.No_pemesanan=No_pemesanan;
        this.Id_supplier=id_supplier;
        this.db=db;
        //MS=new listMD_Suplier(db).getSuplier(Id_supplier);
    }
    public MD_Pesan_barang(){
        this.No_po=null;
        this.No_pemesanan=null;
        this.Id_supplier=0;
    }

    public String getNo_po() {
        return No_po;
    }

    public String getNo_pemesanan() {
        return No_pemesanan;
    }

    public int getId_supplier() {
        return Id_supplier;
    }

    public void setNo_po(String No_po) {
        this.No_po = No_po;
    }

    public void setNo_pemesanan(String No_pemesanan) {
        this.No_pemesanan = No_pemesanan;
    }

    public void setId_supplier(int Id_supplier) {
        this.Id_supplier = Id_supplier;
    }
    
}
