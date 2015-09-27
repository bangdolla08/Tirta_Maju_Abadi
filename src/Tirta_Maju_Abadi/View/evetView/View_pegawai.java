package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Pegawai;
import Tirta_Maju_Abadi.DataModel.listMD_Pegawai;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author bangdolla
 */
public class View_pegawai {
    private DefaultListModel dlm;
    private database db;
    private loadAllData lad;
    private listMD_Pegawai lmp;
    public View_pegawai(ListModel dlm, database db, loadAllData lad) {
        this.dlm = (DefaultListModel) dlm;
        this.db = db;
        this.lad = lad;
        lmp=lad.getListMD_Pegawai();
        isiLisT();
    }
    
    private void isiLisT(){
        dlm.removeAllElements();
        for(MD_Pegawai mp:lmp.getList()){
            dlm.addElement(dlm);
        }
    }
    
    public DefaultListModel getDefaultTableModel(){
        return dlm;
    }
    
    public void InsertTable(MD_Pegawai tmp){
        if(db.setDB("insert into pegawai set nama='"+tmp.getNama()+"',"
                + "alamat='"+tmp.getAlamat()+"',"
                + "no_telpon='"+tmp.getNo_telpon()+"',"
                + "tanggal_lahir='"+tmp.getTanggal_lahir()+"',"
                + "tanggal_masuk='"+tmp.getTanggal_masuk()+"',"
                + "email='"+tmp.getEmail()+"',"
                + "jabatan='"+tmp.getJabatan()+"',"
                + "username='"+tmp.getEmail()+"',"
                + "password='"+tmp.getNo_telpon()+"'")){
            JOptionPane.showMessageDialog(null, "Data Berhasil Di simpan");
        }else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }
    
}
