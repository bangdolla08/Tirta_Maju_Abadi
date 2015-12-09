/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.Report;

import java.awt.Color;
import java.util.Locale;

/**
 *
 * @author jepank's
 */
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.*;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizer;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;


public class Templatess {
    public static final StyleBuilder rootStyle;
	public static final StyleBuilder boldStyle;
	public static final StyleBuilder italicStyle;
	public static final StyleBuilder boldCenteredStyle;
	public static final StyleBuilder bold10CenteredStyle;
	public static final StyleBuilder bold18CenteredStyle;
	public static final StyleBuilder bold22CenteredStyle;
	public static final StyleBuilder columnStyle;
//        public static final StyleBuilder kolomStyle;
	public static final StyleBuilder columnTitleStyle;
	public static final StyleBuilder groupStyle;
	public static final StyleBuilder subtotalStyle;
        public static final StyleBuilder bold14;
        public static final StyleBuilder bold14Left;
        public static final StyleBuilder bold12Leftt;
        public static final StyleBuilder bold12Rightt;
        public static final StyleBuilder root12Rightt;
        public static final StyleBuilder root10Left;
        public static final StyleBuilder left10;
        public static final StyleBuilder underleft10;

	public static final ReportTemplateBuilder reportTemplate;
	public static final CurrencyType currencyType;
	public static final ComponentBuilder<?, ?> dynamicReportsComponent;
	public static final ComponentBuilder<?, ?> footerComponent;
        private String No_nota;
        
        public Templatess(String No_nota){
            this.No_nota=No_nota;
        }

	static {
		rootStyle           = stl.style().setPadding(2);
		boldStyle           = stl.style(rootStyle).bold();
		italicStyle         = stl.style(rootStyle).italic();
		boldCenteredStyle   = stl.style(boldStyle)
		                         .setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
                bold14Left          = stl.style(boldStyle)
                                          .setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.TOP);
                bold12Leftt          = stl.style(boldStyle).setFontSize(10)
                                          .setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.TOP);
                bold12Rightt         = stl.style(boldStyle).setFontSize(10)
                                          .setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.TOP);
                root12Rightt         = stl.style(boldStyle).setFontSize(10)
                                          .setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.TOP)
                                           .setBorder(stl.pen1Point());
                root10Left         = stl.style(rootStyle).setFontSize(8)
                                          .setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.TOP)
                                           .setBorder(stl.pen1Point());
		bold10CenteredStyle = stl.style(rootStyle)
		                         .setFontSize(10);
                bold14              = stl.style(bold14Left)
                                        .setFontName("Arial").setFontSize(14);
                left10              = stl.style(rootStyle)
                                        .setFontName("Arial").setFontSize(8);
                underleft10          = stl.style(boldStyle)
                                          .setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.TOP);
                

		bold18CenteredStyle = stl.style(boldCenteredStyle)
		                         .setFontSize(18);
		bold22CenteredStyle = stl.style(boldCenteredStyle)
                             .setFontSize(22);
		columnStyle         = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE);
//                kolomStyle    =  stl.style(rootStyle).setHorizontalAlignment(HorizontalAlignment.LEFT);
                
		columnTitleStyle    = stl.style(columnStyle)
		                         .setBorder(stl.pen1Point())
		                         .setHorizontalAlignment(HorizontalAlignment.CENTER)
		                         .setBackgroundColor(Color.WHITE)
		                         .bold();
		groupStyle          = stl.style(boldStyle)
		                         .setHorizontalAlignment(HorizontalAlignment.LEFT);
		subtotalStyle       = stl.style(boldStyle)
		                         .setTopBorder(stl.pen1Point());

		StyleBuilder crosstabGroupStyle      = stl.style(columnTitleStyle);
		StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle)
		                                          .setBackgroundColor(Color.WHITE);
		StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle)
		                                          .setBackgroundColor(Color.WHITE);
		StyleBuilder crosstabCellStyle       = stl.style(columnStyle)
		                                          .setBorder(stl.pen1Point());
//tableOfContentsCustomizer
		TableOfContentsCustomizerBuilder tableOfContentsCustomizer = new TableOfContentsCustomizerBuilder()
			.setHeadingStyle(0, stl.style(rootStyle).bold());

		reportTemplate = template()
		                   .setLocale(Locale.ENGLISH)
		                   .setColumnStyle(columnStyle)
		                   .setColumnTitleStyle(columnTitleStyle)
		                   .setGroupStyle(groupStyle)
		                   .setGroupTitleStyle(groupStyle)
		                   //.highlightDetailEvenRows()
		                    .crosstabHighlightEvenRows()
		                   .setCrosstabGroupStyle(crosstabGroupStyle)
		                   .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
		                   .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
		                   .setCrosstabCellStyle(crosstabCellStyle)
		                   .setTableOfContentsCustomizer(tableOfContentsCustomizer);

		currencyType = new CurrencyType();

		HyperLinkBuilder link = hyperLink("http://www.GGSOFT.com");
		dynamicReportsComponent =
		  cmp.horizontalList(
		  	cmp.image(Templates.class.getResource("../Images/Logos.png")).setFixedDimension(70, 70),
		  	cmp.verticalList(
		  		cmp.text("PT. Triasta Maju Abadi").setStyle(bold14).setHorizontalAlignment(HorizontalAlignment.LEFT)
//                                cmp.text("No. Nota :").setStyle(bold10CenteredStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)
		  		.setHyperLink(link))).setFixedWidth(300);

		footerComponent = cmp.pageXofY()
		                     .setStyle(
		                     	stl.style(boldCenteredStyle)
		                     	   .setTopBorder(stl.pen1Point()));
	}

	/**
	 * Creates custom component which is possible to add to any report band component
	 */
	public static ComponentBuilder<?, ?> createTitleComponent(String label) {
		return cmp.horizontalList()
		        .add(
		        	dynamicReportsComponent,
		        	cmp.text(label).setStyle(rootStyle).setHorizontalAlignment(HorizontalAlignment.JUSTIFIED))
		        .newRow()
		        .newRow()
		        .add(cmp.verticalGap(10));
	}

	public static CurrencyValueFormatter createCurrencyValueFormatter(String label) {
		return new CurrencyValueFormatter(label);
	}

	public static class CurrencyType extends BigDecimalType {
		private static final long serialVersionUID = 1L;

		@Override
		public String getPattern() {
			return "Rp #,###.00";
		}
	}

	private static class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {
		private static final long serialVersionUID = 1L;

		private String label;

		public CurrencyValueFormatter(String label) {
			this.label = label;
		}

		@Override
		public String format(Number value, ReportParameters reportParameters) {
			return label + currencyType.valueToString(value, reportParameters.getLocale());
		}
	}
}
