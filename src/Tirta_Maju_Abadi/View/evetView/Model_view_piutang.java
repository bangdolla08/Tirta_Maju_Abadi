/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_Piutang;
import Tirta_Maju_Abadi.DataModel.MD_Piutang;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jepank's
 */

public class Model_view_piutang {
   private database db;
   private loadAllData lad;
   private loadAllData lads;
   private MD_Piutang mpi;
   private MD_Full_Piutang mdfp;
   
   public Model_view_piutang(MD_Piutang mpi, database db, loadAllData lad){
       this.mpi=mpi;
       this.db=db;
       this.lad=lad;
   }
   
   public void Update(){
       int a=0;
       if(mpi.isStatuspembayaran())
           a=1;
       this.mdfp=lad.getLfpiut().getMDByNo_nota(mpi.getNo_Nota_Piutang());
       if(String.valueOf(mdfp.getNo_nota_piutang()).equals(mpi.getNo_Nota_Piutang())){
            if(db.setDB("update piutang set setatusPembayaran='"+a+"',"
                + "NO_pembayaran='"+mpi.getNoPembayaran()+"' where no_nota_piutang='"+mdfp.getNo_nota_piutang()+"'")) 
                JOptionPane.showMessageDialog(null, "Transaksi Sukses Diperbarui","Informasi",JOptionPane.INFORMATION_MESSAGE);
                else
                JOptionPane.showMessageDialog(null, "Gagal Ubah Transaksi","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else
           JOptionPane.showMessageDialog(null, "No Nota Tidak Di Temukan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
