package Tirta_Maju_Abadi.DataModel;

public class MD_Full_Piutang {
    private String No_PO;
    private String no_nota_piutang;
    private String nama_barang;
    private int harga_barang;
    private int bnyk_barang;

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
