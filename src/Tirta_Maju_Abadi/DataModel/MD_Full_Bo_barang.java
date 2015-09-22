package Tirta_Maju_Abadi.DataModel;

public class MD_Full_Bo_barang {
    private int no_bo;
    private String nama_barang;
    private int estimasi_harga;
    public MD_Full_Bo_barang(int no_bo, String nama_barang, int estimasi_harga) {
        this.no_bo = no_bo;
        this.nama_barang = nama_barang;
        this.estimasi_harga = estimasi_harga;
    }

    public int getNo_bo() {
        return no_bo;
    }

    public void setNo_bo(int no_bo) {
        this.no_bo = no_bo;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getEstimasi_harga() {
        return estimasi_harga;
    }

    public void setEstimasi_harga(int estimasi_harga) {
        this.estimasi_harga = estimasi_harga;
    }
    
    
}
