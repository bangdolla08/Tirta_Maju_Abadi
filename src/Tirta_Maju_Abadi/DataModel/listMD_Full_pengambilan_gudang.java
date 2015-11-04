/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jepank's
 */
public class listMD_Full_pengambilan_gudang {
    private database db;
    private ResultSet rs;
    private List<MD_Full_pengambilan_gudang> listfullDB=new ArrayList<MD_Full_pengambilan_gudang>();
   
    
    public listMD_Full_pengambilan_gudang(database db){
        this.db=db;
        try {
            listfullDB.clear();
            
            while(rs.next()){
                listfullDB.add(
                        new MD_Full_pengambilan_gudang(rs.getInt("Id_barang"),
                                rs.getInt("Id_supplier"),
                                rs.getInt("banyak"))
                        );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public listMD_Full_pengambilan_gudang(ResultSet rs, database db){
        this.db=db;
        try {
            listfullDB.clear();
            
            while(rs.next()){
                listfullDB.add(
                        new MD_Full_pengambilan_gudang(rs.getInt("Id_barang"),
                                rs.getInt("Id_supplier"),
                                rs.getInt("banyak"))
                        );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<MD_Full_pengambilan_gudang> getList(){
        return listfullDB;
    }
}
