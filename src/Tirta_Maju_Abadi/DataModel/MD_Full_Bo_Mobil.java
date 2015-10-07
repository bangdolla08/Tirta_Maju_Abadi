/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author putra
 */
public class MD_Full_Bo_Mobil {
    private int no_bo, pembayaran, estimasi, banyak;
    private loadAllData lD;
    
    public void MD_Full_Bo_Mobil(int no_bo, int pembayaran, int estimasi, int banyak)
    {
        this.no_bo=no_bo;
        this.pembayaran=pembayaran;
        this.estimasi=estimasi;
        this.banyak=banyak;
        
    }

    public int getNo_bo() {
        return no_bo;
    }

    public void setNo_bo(int no_bo) {
        this.no_bo = no_bo;
    }

    public int getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(int pembayaran) {
        this.pembayaran = pembayaran;
    }

    public int getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(int estimasi) {
        this.estimasi = estimasi;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }
    
    
}
