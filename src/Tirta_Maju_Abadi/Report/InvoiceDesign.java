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

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.util.Date;

import Tirta_Maju_Abadi.Report.Templates;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
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
public class InvoiceDesign {
        Date dNow=new Date();
	private InvoiceData data;
	private AggregationSubtotalBuilder<BigDecimal> totalSum;
        private SimpleDateFormat ft = new SimpleDateFormat("dd MMMMM yyyy");

	public JasperReportBuilder build() throws DRException {
                data=new InvoiceData();
		JasperReportBuilder report = report();

		//init styles
		StyleBuilder columnStyle = stl.style(Templates.columnStyle);
                
                StyleBuilder columnnStyle = stl.style(Templates.groupStyle).
                        setRightBorder(stl.pen1Point())
                        .setLeftBorder(stl.pen1Point());
                
		//init columns
		TextColumnBuilder<String> rowNumberColumn = col.column("No.","no",type.stringType())
			.setWidth(60).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String> descriptionColumn = col.column("N A M A  B A R A N G", "nama_barang", type.stringType())
			.setWidth(300).setHorizontalAlignment(HorizontalAlignment.LEFT);
		TextColumnBuilder<String> quantityColumn = col.column("QUANTITY", "quantity", type.stringType())
			.setHorizontalAlignment(HorizontalAlignment.CENTER).setWidth(150);
                

		//configure report
		report
			.setTemplate(Templates.reportTemplate)
                        .setColumnStyle(columnnStyle)
			//columns
			.columns(
				rowNumberColumn, descriptionColumn, quantityColumn)
			//band components
			.title(
				Templates.createTitleComponent("Surabaya, " + ft.format(dNow)+"\n"
                                        + "Kepada YTH: \n"
                                        + data.getInvoice().getNo()+"\n"
                                        + "Alamat"+"\n"
                                        + "Telp. "+data.getInvoice().getNo()),
                                cmp.text("Alamat Kirim : "+data.getInvoice().getNo()),
				cmp.horizontalList().setStyle(stl.style(1)).setGap(1).add(
				cmp.verticalGap(10)))
                        
			.pageFooter(
				Templates.footerComponent)
                        .summary(cmp.line())
                        
                        .summary(
				cmp.horizontalList(
					cmp.text("Penerima,                Pengirim,    ").setStyle(Templates.bold12Rightt)),
				cmp.verticalGap(40),
                                cmp.horizontalList(
					cmp.text("   (......................)       (......................)").setStyle(Templates.bold12Rightt)),
				cmp.verticalGap(1)
                        )
			.setDataSource(data.createDataSource());
		return report;
	}

	public InvoiceDesign() {
//		InvoiceDesign design = new InvoiceDesign();
		try {
			JasperReportBuilder report = build();
			report.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}
}