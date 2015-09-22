/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

/**
 *
 * @author PUTRA
 */
public class MD_Keterangan {
  private int id_bo, harga;
  private String keterangan;
  
  public MD_Keterangan()
  {
  }
  
  public MD_Keterangan(int id_bo, int harga, String keterangan)
  {
      this.harga=harga;
      this.id_bo=id_bo;
      this.keterangan=keterangan;
  }

    public int getId_bo() {
        return id_bo;
    }

    public void setId_bo(int id_bo) {
        this.id_bo = id_bo;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
