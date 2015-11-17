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
import Tirta_Maju_Abadi.DataModel.listMD_Bahan_mentah;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class InvoiceData {
	private Invoice invoice;
        Date dNow=new Date();
//        SimpleDateFormat ft = new SimpleDateFormat("dd MMMMM yyyy");
//        String tgl=ft.format(dNow);
        private listMD_Bahan_mentah listMD_bahan_mentah;
        private MD_Bahan_metah mb=new MD_Bahan_metah();
        private loadAllData lad;
        private List<Item> items = new ArrayList<Item>();
	public InvoiceData() {
		invoice = createInvoice();
	}
        
        private void loop(){
            int no=3;
//            for(MD_Bahan_metah md:lad.getListMD_Bahan_mentah().getAll()){
//                    items.add(createItem(String.valueOf(no), String.valueOf(md.getNama_bahan()), "9"));
//                    no++;
//                    JOptionPane.showMessageDialog(null, "1");
//            }
            items.add(createItem("1", "Barang", "9"));
            items.add(createItem("2", "Galon", "10"));
            items.add(createItem("3", "BHA", "12"));
            
            for(int i=1;i<=11-no;i++){
                    items.add(createItem("", "", ""));
                }
        }

	private Invoice createInvoice() {
		Invoice invoice = new Invoice();
                int no=0;
                loop();
//		List<Item> items = new ArrayList<Item>();
//                for(MD_Bahan_metah md:listMD_bahan_mentah.getAll()){
//                    items.add(createItem(String.valueOf(no), String.valueOf(md.getNama_bahan()), "9"));
//                    no++;
//                    JOptionPane.showMessageDialog(null, "1");
//                }
                
//		items.add(createItem("1", "Mineral", "5"));
//		items.add(createItem("2", "Galon", "9"));
                
//                for(int i=1;i<=11-no;i++){
//                    items.add(createItem("", "", ""));
//                }
                
//		items.add(createItem("Phone", 1, new BigDecimal(200)));
                
		invoice.setItems(items);
		return invoice;
	}
        

	private Item createItem(String no, String nama_barang, String quantity) {
		Item item = new Item();
                item.setNo(no);
		item.setNama_barang(nama_barang);
		item.setQuantity(quantity);
		return item;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public JRDataSource createDataSource() {
		return new JRBeanCollectionDataSource(invoice.getItems());
	}
}
