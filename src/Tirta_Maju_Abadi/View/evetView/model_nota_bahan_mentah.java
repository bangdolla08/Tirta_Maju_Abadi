package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_Piutang;
import Tirta_Maju_Abadi.DataModel.MD_Piutang;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class model_nota_bahan_mentah {
    private loadAllData lad;
    private database db;
    private MD_Piutang mdp;
    private DefaultTableModel dtm;

    public model_nota_bahan_mentah(loadAllData lad, database db, MD_Piutang mdp, TableModel dtm) {
        this.lad = lad;
        this.db = db;
        this.mdp = mdp;
        this.dtm = (DefaultTableModel) dtm;
    }
    public void reset(){
        dtm.setRowCount(0);
        mdp=new MD_Piutang(lad);
    }
    public boolean insert(){
        boolean INsertAdb=true;
        INsertAdb=INsertAdb&&db.setDB("insert into piutang set No_PO='"+mdp.getNo_po()+"', 	"
                + "no_nota_piutang='"+mdp.getNo_Nota_Piutang()+"',"
                + " tanggal_nota='"+lad.convertUtilDateToSqlDate(mdp.getTanggal_nota())+"', "
                + "tanggal_jatuhTempo='"+lad.convertUtilDateToSqlDate(mdp.getTanggal_jatuh_tempo())+"',"
                + "no_surat_jalan='"+mdp.getNo_surat_jalan()+"', "
                + "setatusPembayaran=0, "
                + "NO_pembayaran='belum'");
        for(MD_Full_Piutang tmp:mdp.getListFull()){
            INsertAdb=INsertAdb&&db.setDB("inset into full_piutang set No_PO='"+mdp.getNo_po()+"', "
                    + "no_nota_piutang='"+tmp.getNo_nota_piutang()+"', "
                    + "nama_barang='"+tmp.getNama_barang()+"', "
                    + "harga_barang='"+tmp.getHarga_barang()+"',"
                    + "banyak_barang='"+tmp.getBnyk_barang()+"'");
        }
        return INsertAdb;
    }
    
    public void setPembayaran(String no_pembayaran){
        db.setDB("update piutang set NO_pembayaran='"+no_pembayaran+"' where No_PO='"+mdp.getNo_po()+"' AND	"
                + "no_nota_piutang='"+mdp.getNo_Nota_Piutang()+"'");
    }
    
    public DefaultTableModel getDtm(){
        return dtm;
    }
    public void SetFullPiutang(MD_Full_Piutang mfp){
        mdp.addTolist(mfp);
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mfp.getNama_barang());
        vct.add(mfp.getHarga_barang());
        vct.add(mfp.getBnyk_barang());
        dtm.addRow(vct);
    }
    
}
