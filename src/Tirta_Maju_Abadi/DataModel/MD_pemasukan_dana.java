package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;

public class MD_pemasukan_dana {
    private int no_masukkan;
    private int type_pemasukkan;
    private int bnyak_dana;
    private int id_no_rekening;
    private int no_nota;
    private int id_pelanggan;

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public MD_pemasukan_dana(int no_masukkan, int type_pemasukkan, int bnyak_dana, int id_no_rekening, int no_nota, int id_pelanggan) {
        this.no_masukkan = no_masukkan;
        this.type_pemasukkan = type_pemasukkan;
        this.bnyak_dana = bnyak_dana;
        this.id_no_rekening = id_no_rekening;
        this.no_nota = no_nota;
        this.id_pelanggan = id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
        
    }
    
    private List<list2Values> lstType_pembayaran=new ArrayList<list2Values>();
    
    private void isiTypePembayaran(){
        lstType_pembayaran.add(new list2Values("Cash", 1));
        lstType_pembayaran.add(new list2Values("Transfer", 2));
        lstType_pembayaran.add(new list2Values("Giro", 3));
        
    }
    
    public int getNo_masukkan() {
        return no_masukkan;
    }

    public void setNo_masukkan(int no_masukkan) {
        this.no_masukkan = no_masukkan;
    }

    public int getType_pemasukkan() {
        return type_pemasukkan;
    }

    public void setType_pemasukkan(int type_pemasukkan) {
        this.type_pemasukkan = type_pemasukkan;
    }

    public int getBnyak_dana() {
        return bnyak_dana;
    }

    public void setBnyak_dana(int bnyak_dana) {
        this.bnyak_dana = bnyak_dana;
    }

    public int getId_no_rekening() {
        return id_no_rekening;
    }

    public void setId_no_rekening(int id_no_rekening) {
        this.id_no_rekening = id_no_rekening;
    }

    public int getNo_nota() {
        return no_nota;
    }

    public void setNo_nota(int no_nota) {
        this.no_nota = no_nota;
    }
}
