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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Customer {
	private String nama;
	private String Tujuan;
	private Date dNow=new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String tgl=ft.format(dNow);

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTujuan() {
        return Tujuan;
    }

    public void setTujuan(String Tujuan) {
        this.Tujuan = Tujuan;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }


}
