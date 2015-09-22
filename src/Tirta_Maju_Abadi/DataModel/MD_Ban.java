
package Tirta_Maju_Abadi.DataModel;

public class MD_Ban {
    private String nopol, posisi, noseri, tgl_pasang;
    
    public MD_Ban()
    {
    }
    
    public MD_Ban(String nopol, String posisi, String noseri, String tgl_pasang)
    {
        this.nopol=nopol;
        this.noseri=noseri;
        this.posisi=posisi;
        this.tgl_pasang=tgl_pasang;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getNoseri() {
        return noseri;
    }

    public void setNoseri(String noseri) {
        this.noseri = noseri;
    }

    public String getTgl_pasang() {
        return tgl_pasang;
    }

    public void setTgl_pasang(String tgl_pasang) {
        this.tgl_pasang = tgl_pasang;
    }
}
