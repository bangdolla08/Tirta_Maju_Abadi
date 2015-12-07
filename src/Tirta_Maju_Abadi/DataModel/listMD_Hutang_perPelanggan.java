package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;

public class listMD_Hutang_perPelanggan {
    private List<md_hutang_pelanggan> listMD_pelanggan=new ArrayList<md_hutang_pelanggan>();
    private loadAllData lad;

    public listMD_Hutang_perPelanggan(loadAllData lad) {
        this.lad = lad;
    }
    
}
