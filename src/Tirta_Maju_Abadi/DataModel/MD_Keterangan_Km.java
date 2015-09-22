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
public class MD_Keterangan_Km {
    private int id_bo, km, posisi;
    
    public MD_Keterangan_Km()
    {
    }
    
    public MD_Keterangan_Km(int id_bo, int km, int posisi)
    {
        this.id_bo=id_bo;
        this.km=km;
        this.posisi=posisi;
    }

    public int getId_bo() {
        return id_bo;
    }

    public void setId_bo(int id_bo) {
        this.id_bo = id_bo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }
}
