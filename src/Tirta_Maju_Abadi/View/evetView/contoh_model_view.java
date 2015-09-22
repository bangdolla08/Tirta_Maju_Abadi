
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Mobil;
import Tirta_Maju_Abadi.DataModel.listMD_Mobil;
import Tirta_Maju_Abadi.toll.database;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class contoh_model_view {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Mobil listmD_Mobil;
    private database db;
    public contoh_model_view(TableModel dtm,listMD_Mobil listmD_Mobil,database db) {
        this.dtm=(DefaultTableModel) dtm;
        this.listmD_Mobil=listmD_Mobil;
        this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Mobil md:listmD_Mobil.getAll()) {
            Vector vct=new Vector();
            //urutkan dengan yang di design;
            vct.add(md.getDriver());
            dtm.addRow(vct);
        }
    }
    public void insertMetode(MD_Mobil md){
        if(db.setDB("insert into mobil set"
                + "nopol='"+md.getNopol()+"' dst"))
            JOptionPane.showMessageDialog(null, "data Berhasil di inputkan","Berhasil",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "data gagal di inputkan","gagal",JOptionPane.ERROR_MESSAGE);
    }    
    public void editMetode(MD_Mobil md,String nopolLama){
        if(db.setDB("update into mobil set"
                + "nopol='"+md.getNopol()+"' dst where nopol='"+nopolLama+"'"))
            JOptionPane.showMessageDialog(null, "data Berhasil di inputkan","Berhasil",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "data gagal di inputkan","gagal",JOptionPane.ERROR_MESSAGE);
    }
}
