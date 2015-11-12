package Tirta_Maju_Abadi.toll;

import Tirta_Maju_Abadi.DataModel.*;

public class loadAllData {
    private database db=new database();
    private MD_Pegawai mp;
    private listMD_Produk listMD_Produk1=new listMD_Produk(db, this);
    private listMD_Harga_pelanggan listMD_Harga_pelanggan1=new listMD_Harga_pelanggan(db,this);
    private listMD_Full_Piutang Lfpiut=new listMD_Full_Piutang(db,this);
    private listMD_Bahan_mentah listMD_Bahan_mentah1=new listMD_Bahan_mentah(db, this);
    private listMD_Ban listMD_Ban1=new listMD_Ban(db);
    private listMD_Datang_bahan_dasar listMD_Datang_bahan_dasar1=new listMD_Datang_bahan_dasar(db);
    private listMD_Full_penjualan listMD_Full_penjualan1=new listMD_Full_penjualan(db, this);
    private listMD_Galon_cacat listMD_Galon_cacat1=new listMD_Galon_cacat(db,this);
    private listMD_Galon_keluar listMD_Galon_keluar1=new listMD_Galon_keluar(db);
    private listMD_Galon_masuk listMD_Galon_masuk1=new listMD_Galon_masuk(db, this);
    private listMD_Gudang_barang_jadi listMD_Gudang_barang_jadi1=new listMD_Gudang_barang_jadi(db);
    private listMD_Keluar_gudang_bahan_jadi listMD_Keluar_gudang_bahan_jadi1=new listMD_Keluar_gudang_bahan_jadi(db);
    private listMD_Keluar_gudang_bahan_mentah listMD_Keluar_gudang_bahan_mentah1=new listMD_Keluar_gudang_bahan_mentah(db);
    private listMD_Keterangan listMD_Keterangan1=new listMD_Keterangan(db);
    private listMD_Keterangan_Km listMD_Keterangan_Km1=new listMD_Keterangan_Km(db);
    private listMD_Mobil listMD_Mobil1=new listMD_Mobil(db);
    private listMD_Mobil_Keluar listMD_Mobil_Keluar1=new listMD_Mobil_Keluar(db,this);
    private listMD_Nota_pesan listMD_Nota_pesan1=new listMD_Nota_pesan(db);
    private listMD_Pegawai listMD_Pegawai1=new listMD_Pegawai(db);
    private listMD_Pelanggan listMD_Pelanggan1=new listMD_Pelanggan(db,this);
    private listMD_Penjualan_po listMD_Penjualan_po1=new listMD_Penjualan_po(db, this);
    private listMD_Pesan_barang listMD_Pesan_barang1=new listMD_Pesan_barang(db);
    private listMD_Po_bahan_dasar listMD_Po_bahan_dasar1=new listMD_Po_bahan_dasar(db);
    //private listMD_Produk listMD_Produk1=new listMD_Produk(db, this);
    private listMD_Suplier listMD_Suplier1=new listMD_Suplier(db,this);
    private listMD_full_bahan_dasar_datang listMD_full_bahan_dasar_datang1=new listMD_full_bahan_dasar_datang(db, this);
    private listMD_Bo_barang listMD_bo_barang=new listMD_Bo_barang(db, this);
    private listMD_Bo_Mobil listMD_bo_mobil = new listMD_Bo_Mobil(db, this);
    private listMD_pengambilan_gudang listMD_pengambilan1=new listMD_pengambilan_gudang(db, this);

    public listMD_Full_Piutang getLfpiut() {
        return Lfpiut;
    }

    public void setLfpiut(listMD_Full_Piutang Lfpiut) {
        this.Lfpiut = Lfpiut;
    }
    public java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
    if(date != null) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    return null;
    }
    public void reset(){
        listMD_Bahan_mentah1=new listMD_Bahan_mentah(db, this);
        listMD_Ban1=new listMD_Ban(db);
        listMD_Datang_bahan_dasar1=new listMD_Datang_bahan_dasar(db);
        listMD_Harga_pelanggan1=new listMD_Harga_pelanggan(db,this);
        listMD_Full_penjualan1=new listMD_Full_penjualan(db, this);
        listMD_Galon_cacat1=new listMD_Galon_cacat(db,this);
        listMD_Galon_keluar1=new listMD_Galon_keluar(db);
        listMD_Galon_masuk1=new listMD_Galon_masuk(db, this);
        listMD_Gudang_barang_jadi1=new listMD_Gudang_barang_jadi(db);
        listMD_Keluar_gudang_bahan_jadi1=new listMD_Keluar_gudang_bahan_jadi(db);
        listMD_Keluar_gudang_bahan_mentah1=new listMD_Keluar_gudang_bahan_mentah(db);
        listMD_Keterangan1=new listMD_Keterangan(db);
        listMD_Keterangan_Km1=new listMD_Keterangan_Km(db);
        listMD_Mobil1=new listMD_Mobil(db);
        listMD_Mobil_Keluar1=new listMD_Mobil_Keluar(db,this);
        listMD_Nota_pesan1=new listMD_Nota_pesan(db);
        listMD_Pegawai1=new listMD_Pegawai(db);
        listMD_Pelanggan1=new listMD_Pelanggan(db,this);
        listMD_Penjualan_po1=new listMD_Penjualan_po(db, this);
        listMD_Pesan_barang1=new listMD_Pesan_barang(db);
        listMD_Po_bahan_dasar1=new listMD_Po_bahan_dasar(db);
        listMD_Produk1=new listMD_Produk(db, this);
        listMD_Suplier1=new listMD_Suplier(db,this);
        listMD_full_bahan_dasar_datang1=new listMD_full_bahan_dasar_datang(db, this);
        listMD_bo_barang=new listMD_Bo_barang(db, this);
        listMD_bo_mobil = new listMD_Bo_Mobil(db, this); 
        listMD_pengambilan1=new listMD_pengambilan_gudang(db, this);
    }

    public listMD_full_bahan_dasar_datang getListMD_full_bahan_dasar_datang1() {
        return listMD_full_bahan_dasar_datang1;
    }

    public void setListMD_full_bahan_dasar_datang1(listMD_full_bahan_dasar_datang listMD_full_bahan_dasar_datang1) {
        this.listMD_full_bahan_dasar_datang1 = listMD_full_bahan_dasar_datang1;
    }
    
    
    public listMD_Bo_Mobil getListMD_bo_mobil() {
        return listMD_bo_mobil;
    }

    public void setListMD_bo_mobil(listMD_Bo_Mobil listMD_bo_mobil) {
        this.listMD_bo_mobil = listMD_bo_mobil;
    }
    
    
    public listMD_Bo_barang getListMD_bo_barang() {
        return listMD_bo_barang;
    }

    public void setListMD_bo_barang(listMD_Bo_barang listMD_bo_barang) {
        this.listMD_bo_barang = listMD_bo_barang;
    }
    

    public listMD_Bahan_mentah getListMD_Bahan_mentah() {
        return listMD_Bahan_mentah1;
    }

    public listMD_pengambilan_gudang getListMD_pengambilan1() {
        return listMD_pengambilan1;
    }

    public void setListMD_pengambilan1(listMD_pengambilan_gudang listMD_pengambilan1) {
        this.listMD_pengambilan1 = listMD_pengambilan1;
    }

    public void setListMD_Bahan_mentah(listMD_Bahan_mentah listMD_Bahan_mentah1) {
        this.listMD_Bahan_mentah1 = listMD_Bahan_mentah1;
    }

    public listMD_Ban getListMD_Ban() {
        return listMD_Ban1;
    }

    public void setListMD_Ban(listMD_Ban listMD_Ban1) {
        this.listMD_Ban1 = listMD_Ban1;
    }

    public listMD_Datang_bahan_dasar getListMD_Datang_bahan_dasar() {
        return listMD_Datang_bahan_dasar1;
    }

    public void setListMD_Datang_bahan_dasar(listMD_Datang_bahan_dasar listMD_Datang_bahan_dasar1) {
        this.listMD_Datang_bahan_dasar1 = listMD_Datang_bahan_dasar1;
    }

    public listMD_Full_penjualan getListMD_Full_penjualan() {
        return listMD_Full_penjualan1;
    }

    public void setListMD_Full_penjualan(listMD_Full_penjualan listMD_Full_penjualan1) {
        this.listMD_Full_penjualan1 = listMD_Full_penjualan1;
    }

    public listMD_Galon_cacat getListMD_Galon_cacat() {
        return listMD_Galon_cacat1;
    }

    public void setListMD_Galon_cacat(listMD_Galon_cacat listMD_Galon_cacat1) {
        this.listMD_Galon_cacat1 = listMD_Galon_cacat1;
    }

    public listMD_Galon_keluar getListMD_Galon_keluar() {
        return listMD_Galon_keluar1;
    }

    public void setListMD_Galon_keluar(listMD_Galon_keluar listMD_Galon_keluar1) {
        this.listMD_Galon_keluar1 = listMD_Galon_keluar1;
    }

    public listMD_Galon_masuk getListMD_Galon_masuk() {
        return listMD_Galon_masuk1;
    }

    public void setListMD_Galon_masuk(listMD_Galon_masuk listMD_Galon_masuk1) {
        this.listMD_Galon_masuk1 = listMD_Galon_masuk1;
    }

    public listMD_Gudang_barang_jadi getListMD_Gudang_barang_jadi() {
        return listMD_Gudang_barang_jadi1;
    }

    public void setListMD_Gudang_barang_jadi(listMD_Gudang_barang_jadi listMD_Gudang_barang_jadi1) {
        this.listMD_Gudang_barang_jadi1 = listMD_Gudang_barang_jadi1;
    }

    public listMD_Harga_pelanggan getListMD_Harga_pelanggan() {
        return listMD_Harga_pelanggan1;
    }

    public void setListMD_Harga_pelanggan(listMD_Harga_pelanggan listMD_Harga_pelanggan1) {
        this.listMD_Harga_pelanggan1 = listMD_Harga_pelanggan1;
    }

    public listMD_Keluar_gudang_bahan_jadi getListMD_Keluar_gudang_bahan_jadi() {
        return listMD_Keluar_gudang_bahan_jadi1;
    }

    public void setListMD_Keluar_gudang_bahan_jadi(listMD_Keluar_gudang_bahan_jadi listMD_Keluar_gudang_bahan_jadi1) {
        this.listMD_Keluar_gudang_bahan_jadi1 = listMD_Keluar_gudang_bahan_jadi1;
    }

    public listMD_Keluar_gudang_bahan_mentah getListMD_Keluar_gudang_bahan_mentah() {
        return listMD_Keluar_gudang_bahan_mentah1;
    }

    public void setListMD_Keluar_gudang_bahan_mentah(listMD_Keluar_gudang_bahan_mentah listMD_Keluar_gudang_bahan_mentah1) {
        this.listMD_Keluar_gudang_bahan_mentah1 = listMD_Keluar_gudang_bahan_mentah1;
    }

    public listMD_Keterangan getListMD_Keterangan() {
        return listMD_Keterangan1;
    }

    public void setListMD_Keterangan(listMD_Keterangan listMD_Keterangan1) {
        this.listMD_Keterangan1 = listMD_Keterangan1;
    }

    public listMD_Keterangan_Km getListMD_Keterangan_Km() {
        return listMD_Keterangan_Km1;
    }

    public void setListMD_Keterangan_Km(listMD_Keterangan_Km listMD_Keterangan_Km1) {
        this.listMD_Keterangan_Km1 = listMD_Keterangan_Km1;
    }

    public listMD_Mobil getListMD_Mobil() {
        return listMD_Mobil1;
    }

    public void setListMD_Mobil(listMD_Mobil listMD_Mobil1) {
        this.listMD_Mobil1 = listMD_Mobil1;
    }

    public listMD_Mobil_Keluar getListMD_Mobil_Keluar() {
        return listMD_Mobil_Keluar1;
    }

    public void setListMD_Mobil_Keluar(listMD_Mobil_Keluar listMD_Mobil_Keluar1) {
        this.listMD_Mobil_Keluar1 = listMD_Mobil_Keluar1;
    }

    public listMD_Nota_pesan getListMD_Nota_pesan() {
        return listMD_Nota_pesan1;
    }

    public void setListMD_Nota_pesan(listMD_Nota_pesan listMD_Nota_pesan1) {
        this.listMD_Nota_pesan1 = listMD_Nota_pesan1;
    }

    public listMD_Pegawai getListMD_Pegawai() {
        return listMD_Pegawai1;
    }

    public void setListMD_Pegawai(listMD_Pegawai listMD_Pegawai1) {
        this.listMD_Pegawai1 = listMD_Pegawai1;
    }

    public listMD_Pelanggan getListMD_Pelanggan() {
        return listMD_Pelanggan1;
    }

    public void setListMD_Pelanggan(listMD_Pelanggan listMD_Pelanggan1) {
        this.listMD_Pelanggan1 = listMD_Pelanggan1;
    }

    public listMD_Penjualan_po getListMD_Penjualan_po() {
        return listMD_Penjualan_po1;
    }

    public void setListMD_Penjualan_po(listMD_Penjualan_po listMD_Penjualan_po1) {
        this.listMD_Penjualan_po1 = listMD_Penjualan_po1;
    }

    public listMD_Pesan_barang getListMD_Pesan_barang() {
        return listMD_Pesan_barang1;
    }

    public void setListMD_Pesan_barang(listMD_Pesan_barang listMD_Pesan_barang1) {
        this.listMD_Pesan_barang1 = listMD_Pesan_barang1;
    }

    public listMD_Po_bahan_dasar getListMD_Po_bahan_dasar() {
        return listMD_Po_bahan_dasar1;
    }

    public void setListMD_Po_bahan_dasar(listMD_Po_bahan_dasar listMD_Po_bahan_dasar1) {
        this.listMD_Po_bahan_dasar1 = listMD_Po_bahan_dasar1;
    }

    public listMD_Produk getListMD_Produk() {
        return listMD_Produk1;
    }

    public void setListMD_Produk(listMD_Produk listMD_Produk1) {
        this.listMD_Produk1 = listMD_Produk1;
    }

    public listMD_Suplier getListMD_Suplier() {
        return listMD_Suplier1;
    }

    public void setListMD_Suplier(listMD_Suplier listMD_Suplier1) {
        this.listMD_Suplier1 = listMD_Suplier1;
    }
}
