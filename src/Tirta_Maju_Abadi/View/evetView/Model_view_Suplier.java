package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Supplier;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author bd08
 */
public class Model_view_Suplier {
    private loadAllData lad;
    private MD_Supplier MD_s;
    private database db;
    private JList jl;
    private DefaultListModel lm=new DefaultListModel();
    public Model_view_Suplier(loadAllData lad, MD_Supplier MD_s, database db,JList jl) {
        this.lad = lad;
        this.MD_s = MD_s;
        this.db = db;
        this.jl=jl;
    }
    
    public int reset(){
        int nextID_pelanggna=setNextID();
        jl.setModel(lm);
        return nextID_pelanggna;
    }
    private int setNextID(){
        int i=0;
        lm.removeAllElements();
        for(MD_Supplier tmp:lad.getListMD_Suplier().getList()){
            lm.add(i, tmp);
            i=tmp.getId_supplier();
        }
        return i+1;
    }
    public void insertIntoTable(){
        db.setDB("insert into supplier set "
                + "Id_supplier='"+MD_s.getId_supplier()+"', "
                + "Nama='"+MD_s.getNama()+"', "
                + "Alamat='"+MD_s.getAlamat()+"', "
                + "No_telepon1='"+MD_s.getNo_telepon1()+"', "
                + "No_telepon2='"+MD_s.getNo_telepon2()+"', "
                + "Email='"+MD_s.getEmail()+"', "
                + "Ppn='"+MD_s.isPpn()+"', "
                + "No_rekening1='"+MD_s.getNo_rekening1()+"', "
                + "No_rekening2='"+MD_s.getNo_rekening2()+"'");
    }
    
    public void updateIntoTable(){
        db.setDB("update supplier set "
                + "Id_supplier='"+MD_s.getId_supplier()+"', "
                + "Nama='"+MD_s.getNama()+"', "
                + "Alamat='"+MD_s.getAlamat()+"', "
                + "No_telepon1='"+MD_s.getNo_telepon1()+"', "
                + "No_telepon2='"+MD_s.getNo_telepon2()+"', "
                + "Email='"+MD_s.getEmail()+"', "
                + "Ppn='"+MD_s.isPpn()+"', "
                + "No_rekening1='"+MD_s.getNo_rekening1()+"', "
                + "No_rekening2='"+MD_s.getNo_rekening2()+"' "
                + "where Id_supplier='"+MD_s.getId_supplier()+"'");
    }
}
