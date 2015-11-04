package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



public class MD_Piutang {
    private String No_po;
    private String No_Nota_Piutang;
    private Date tanggal_nota;
    private Date tanggal_jatuh_tempo;
    private String no_surat_jalan;
    private boolean statuspembayaran;
    private String NoPembayaran;
    private loadAllData lad;
    private List<MD_Full_Piutang> listFull=new ArrayList<MD_Full_Piutang>();
    public MD_Piutang(String No_po, String No_Nota_Piutang, Date tanggal_nota, Date tanggal_jatuh_tempo, String no_surat_jalan) {
        this.No_po = No_po;
        this.No_Nota_Piutang = No_Nota_Piutang;
        this.tanggal_nota = tanggal_nota;
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
        this.no_surat_jalan = no_surat_jalan;
    }
    
    public MD_Piutang(String No_po, String No_Nota_Piutang, Date tanggal_nota, Date tanggal_jatuh_tempo, String no_surat_jalan,loadAllData lad) {
        this.No_po = No_po;
        this.No_Nota_Piutang = No_Nota_Piutang;
        this.tanggal_nota = tanggal_nota;
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
        this.no_surat_jalan = no_surat_jalan;
        this.lad=lad;
    }

    public MD_Piutang() {
    }

    public MD_Piutang(String No_po, String No_Nota_Piutang, Date tanggal_nota, Date tanggal_jatuh_tempo, String no_surat_jalan, boolean statuspembayaran, String NoPembayaran, loadAllData lad) {
        this.No_po = No_po;
        this.No_Nota_Piutang = No_Nota_Piutang;
        this.tanggal_nota = tanggal_nota;
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
        this.no_surat_jalan = no_surat_jalan;
        this.statuspembayaran = statuspembayaran;
        this.NoPembayaran = NoPembayaran;
        this.lad = lad;
    }
    private void setList(){
        //for(MD_Full_Piutang mfp:)
    }

    public MD_Piutang(String No_po, String No_Nota_Piutang, Date tanggal_nota, Date tanggal_jatuh_tempo, String no_surat_jalan, boolean statuspembayaran, String NoPembayaran) {
        this.No_po = No_po;
        this.No_Nota_Piutang = No_Nota_Piutang;
        this.tanggal_nota = tanggal_nota;
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
        this.no_surat_jalan = no_surat_jalan;
        this.statuspembayaran = statuspembayaran;
        this.NoPembayaran = NoPembayaran;
    }

    public String getNo_po() {
        return No_po;
    }

    public void setNo_po(String No_po) {
        this.No_po = No_po;
    }

    public String getNo_Nota_Piutang() {
        return No_Nota_Piutang;
    }

    public void setNo_Nota_Piutang(String No_Nota_Piutang) {
        this.No_Nota_Piutang = No_Nota_Piutang;
    }

    public Date getTanggal_nota() {
        return tanggal_nota;
    }

    public void setTanggal_nota(Date tanggal_nota) {
        this.tanggal_nota = tanggal_nota;
    }

    public Date getTanggal_jatuh_tempo() {
        return tanggal_jatuh_tempo;
    }

    public void setTanggal_jatuh_tempo(Date tanggal_jatuh_tempo) {
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
    }

    public String getNo_surat_jalan() {
        return no_surat_jalan;
    }

    public void setNo_surat_jalan(String no_surat_jalan) {
        this.no_surat_jalan = no_surat_jalan;
    }

    public boolean isStatuspembayaran() {
        return statuspembayaran;
    }

    public void setStatuspembayaran(boolean statuspembayaran) {
        this.statuspembayaran = statuspembayaran;
    }

    public String getNoPembayaran() {
        return NoPembayaran;
    }

    public void setNoPembayaran(String NoPembayaran) {
        this.NoPembayaran = NoPembayaran;
    }

    public loadAllData getLad() {
        return lad;
    }

    public void setLad(loadAllData lad) {
        this.lad = lad;
    }
}
