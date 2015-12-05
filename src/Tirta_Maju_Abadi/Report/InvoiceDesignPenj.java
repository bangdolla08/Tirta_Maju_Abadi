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

import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.util.Date;

import Tirta_Maju_Abadi.Report.Templatess;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class InvoiceDesignPenj {
        Date dNow=new Date();
        private AggregationSubtotalBuilder<String> total;
	private InvoiceDatas data;
        List<Items> items = new ArrayList<Items>();
        private ResultSet rs;
        private MD_Pelanggan mp;
        int Id_pelanggan;
        String nama,alamat;
        private int jumlah;

    public List<Items> getItems() {
        return items;
    }
    

    public void setItems(List<Items> items) {
        this.items = items;
    }
        private SimpleDateFormat ft = new SimpleDateFormat("dd MMMMM yyyy");

	public JasperReportBuilder build(String no_nota) throws DRException {
                data=new InvoiceDatas(no_nota);
                jumlah=new InvoiceDatas(no_nota).totJumlah();
                try{
                    rs=new database().getRs("select * from penjualan_po where No_nota='"+no_nota+"'");
                    while(rs.next()){
                            this.mp=new loadAllData().getListMD_Pelanggan().getMDByID(rs.getInt("Id_pelanggan"));
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
		JasperReportBuilder report = report();

		//init styles
		StyleBuilder columnStyle = stl.style(Templatess.columnStyle);
                StyleBuilder columStyle = stl.style(Templatess.columnStyle)
			.setBorder(stl.pen1Point());
                StyleBuilder columnnStyle = stl.style(Templatess.rootStyle).
                        setRightBorder(stl.pen1Point())
                        .setLeftBorder(stl.pen1Point());
                
		//init columns
		TextColumnBuilder<String> rowNumberColumn = col.column("No.","no",type.stringType())
			.setWidth(40).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String> descriptionColumn = col.column("N A M A  B A R A N G", "nama_barang", type.stringType())
			.setWidth(190).setHorizontalAlignment(HorizontalAlignment.LEFT);
		TextColumnBuilder<String> quantityColumn = col.column("QUANTITY", "quantity", type.stringType())
			.setHorizontalAlignment(HorizontalAlignment.CENTER).setWidth(70);
                TextColumnBuilder<String> priceColumn = col.column("HARGA", "harga", type.stringType())
			.setHorizontalAlignment(HorizontalAlignment.RIGHT).setWidth(100);
                TextColumnBuilder<String> totalColumn = col.column("JUMLAH", "jumlah", type.stringType())
			.setHorizontalAlignment(HorizontalAlignment.RIGHT).setWidth(100);
                //init subtotals
		total = sbt.text(nama, totalColumn)
			.setLabel("Total:")
			.setLabelStyle(Templates.boldStyle);
                

		//configure report
		report
			.setTemplate(Templatess.reportTemplate)
                        .setColumnStyle(columnnStyle)
			//columns
			.columns(
				rowNumberColumn, descriptionColumn, quantityColumn, priceColumn, totalColumn)
			//band components
			.title(
				Templatess.createTitleComponent("Surabaya, " + ft.format(dNow)+"\n"
                                        + "Kepada YTH: \n"
                                        + ""+mp.getNama()+"\n"
                                        + mp.getAlamat()+"\n"
                                        + "Telp. "+mp.getNo_telepon()),
                                cmp.horizontalList(cmp.text("No. Nota : "+no_nota).setStyle(Templatess.rootStyle)),
				cmp.horizontalList().setStyle(stl.style(1)).setGap(1).add(
				cmp.verticalGap(2)))
                        
//			.pageFooter(
//				Templatess.footerComponent)
                        .summary(cmp.line())
                        //subtotals
//			.subtotalsAtSummary(
//				total, sbt.text(nama, totalColumn)))
                        .summary(
                                cmp.horizontalList(
                                cmp.verticalGap(1)),
                                cmp.horizontalList(
                                        cmp.text("NO. Surat Jalan                 : "+no_nota.replaceAll("PD","SJ")+"\n"
                                                + "Pengiriman Pada Tanggal : "+" - ").setStyle(Templatess.rootStyle),
					cmp.text("Total ").setStyle(Templatess.bold12Rightt),
                                        cmp.text(jumlah).setStyle(Templatess.root12Rightt).setFixedDimension(115, 7)),
				cmp.verticalGap(10),
				cmp.horizontalList(
                                        cmp.text("1. Barang yang sudah dibeli tidak dapat dikembalikan\n"
                                                + "2. Untuk setiap pengembalian botol galon yang rusak/pecah "
                                                + "dikenakan denda Rp. 30.000,-/Botol\n"
                                                + "3. Nota Asli(putih) sebagai bukti pembayaran").setStyle(Templatess.root10Left).setFixedWidth(350),
					cmp.text("                Penerima,           Hormat Kami, ").setStyle(Templatess.bold12Rightt)),
                                cmp.verticalGap(15),
                                cmp.horizontalList(
					cmp.text("   (......................)       (......................)").setStyle(Templatess.bold12Rightt)),
				cmp.verticalGap(1)
                        )
			.setDataSource(data.createDataSource());
		return report;
	}

	public InvoiceDesignPenj(String no_nota) {
		//InvoiceDesignPenj design = new InvoiceDesignPenj();
		try {
                        new Templatess(no_nota);
			JasperReportBuilder report = build(no_nota);
			report.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}
}