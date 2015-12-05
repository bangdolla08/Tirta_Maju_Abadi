/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2014 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package Tirta_Maju_Abadi.Report;

import Tirta_Maju_Abadi.DataModel.MD_Bahan_metah;
import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.listMD_Bahan_mentah;
import Tirta_Maju_Abadi.View.Penjualan_depo;
import Tirta_Maju_Abadi.View.evetView.view_penjualan_depo;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.awt.image.RescaleOp;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.transform.Result;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class InvoiceDatas {
	private Invoices invoices=new Invoices();
        private MD_Penjualan_po mpo;
        private ResultSet rs;
        private ResultSet rss;
        private String No_nota;
        private MD_Produk mprod;
        private int Id_pelanggan;
        private int jumlah=0;
    
        public InvoiceDatas(){
        }
        
	public InvoiceDatas(String no_nota) {
            this.No_nota=no_nota;
            invoices = createInvoice();   
        }

	private Invoices createInvoice() {
                List<Items> items = new ArrayList<Items>();
                int no=1;
                try{
                    rss=new database().getRs("select * from penjualan_po where No_nota='"+No_nota+"'");
                    while(rss.next()){
                        Id_pelanggan=rss.getInt("Id_pelanggan");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                try{
                    rs=new database().getRs("select * from full_penjualan where No_nota='"+No_nota+"'");
                    while(rs.next()){
                        this.mprod=new loadAllData().getListMD_Produk().getMDByID(rs.getInt("Id_produk"));
                        int harga=new loadAllData().getListMD_Harga_pelanggan().getByIDAndProduk(Id_pelanggan, mprod.getId_produk()).getHarga();
                        items.add(createItem(String.valueOf(no), String.valueOf(mprod.getNama_produk()),
                                rs.getString("Banyak"),String.valueOf(harga), 
                                String.valueOf(rs.getInt("Banyak")*harga)));
                        no++;
                        jumlah+=rs.getInt("Banyak")*harga;
                    }
                }catch(Exception e){
                    //System.out.println(e);
                    JOptionPane.showMessageDialog(null, e);
                }
                    for(int i=1;i<=10-no;i++){
                        items.add(createItem("", "", "","",""));
                    }
                    invoices.setItems(items);
            return invoices;
	}
        
        public int totJumlah(){
            return jumlah;
        }

	public Items createItem(String no, String nama_barang, String quantity, String price, String jumlah) {
		Items item = new Items();
                item.setNo(no);
		item.setNama_barang(nama_barang);
		item.setQuantity(quantity);
                item.setHarga(price);
                item.setJumlah(jumlah);
		return item;
	}

	public Invoices getInvoice() {
		return invoices;
	}

	public JRDataSource createDataSource() {
            return new JRBeanCollectionDataSource(invoices.getItems());
	}
}
