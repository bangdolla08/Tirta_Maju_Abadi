package Tirta_Maju_Abadi.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bd08
 */
public class md_hutang_pelanggan {
    private MD_Pelanggan mdp;
    private MD_Penjualan_po mpp;
    private List<MD_Penjualan_po> listNota=new ArrayList<MD_Penjualan_po>();    
    
    private int tanggungan;
    private int bnyknota;
    
    public md_hutang_pelanggan(MD_Pelanggan mdp, MD_Penjualan_po mpp) {
        this.mdp = mdp;
        this.mpp = mpp;
        this.tanggungan = tanggungan;
        this.bnyknota = bnyknota;
    }
    
    public MD_Pelanggan getMdp() {
        return mdp;
    }

    public void setMdp(MD_Pelanggan mdp) {
        this.mdp = mdp;
    }

    public MD_Penjualan_po getMpp() {
        return mpp;
    }

    public void setMpp(MD_Penjualan_po mpp) {
        this.mpp = mpp;
    }

    public int getTanggungan() {
        return tanggungan;
    }

    public void setTanggungan(int tanggungan) {
        this.tanggungan = tanggungan;
    }

    public int getBnyknota() {
        return bnyknota;
    }

    public void setBnyknota(int bnyknota) {
        this.bnyknota = bnyknota;
    }
}
