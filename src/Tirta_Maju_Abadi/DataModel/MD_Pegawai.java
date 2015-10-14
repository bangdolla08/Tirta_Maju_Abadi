package Tirta_Maju_Abadi.DataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;

public class MD_Pegawai {
    private int no_pegawai,jabatan;
    private Date tanggal_lahir,tanggal_masuk;
    private String nama,alamat,no_telpon,username,password,email,jabatanString;

    public MD_Pegawai(){
        cariJabatan();
    }
    private void cariJabatan(){
        listTypePegawai.add(new list2Values("Super Admin", 0));
        listTypePegawai.add(new list2Values("Owner", 1));
        listTypePegawai.add(new list2Values("Driver", 10));
        listTypePegawai.add(new list2Values("Helper", 11));
    }
    public String cariDarijabatan(int no){
        list2Values tmp=null;
        for (list2Values listTypePegawai1 : listTypePegawai) {
            if(listTypePegawai1.sama(no)){
                tmp=listTypePegawai1;
                break;
            }
        }
        return tmp.getStringNya();
    }
    public int cariDarijabatan(String no){
        list2Values tmp=null;
        for (list2Values listTypePegawai1 : listTypePegawai) {
            if(listTypePegawai1.sama(no)){
                tmp=listTypePegawai1;
                break;
            }
        }
        return tmp.getIsinya();
    }
    
    public MD_Pegawai(int jabatan, Date tanggal_lahir, Date tanggal_masuk, String nama, String alamat, String no_telpon, String username, String password, String email) {
        this.jabatan = jabatan;
        this.tanggal_lahir = tanggal_lahir;
        this.tanggal_masuk = tanggal_masuk;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telpon = no_telpon;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    
    private List<list2Values> listTypePegawai=new ArrayList<list2Values>();
    
    public DefaultListModel<list2Values> setJlist(){
        return (DefaultListModel<list2Values>) listTypePegawai;
    } 
    
    public MD_Pegawai(int no_pegawai, int jabatan, Date tanggal_lahir, Date tanggal_masuk, String nama, String alamat, String no_telpon, String username, String password, String email) {
        this.no_pegawai = no_pegawai;
        this.jabatan = jabatan;
        this.tanggal_lahir = tanggal_lahir;
        this.tanggal_masuk = tanggal_masuk;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telpon = no_telpon;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return getNama(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNo_pegawai() {
        return no_pegawai;
    }

    public void setNo_pegawai(int no_pegawai) {
        this.no_pegawai = no_pegawai;
    }

    public int getJabatan() {
        return jabatan;
    }

    public void setJabatan(int jabatan) {
        this.jabatan = jabatan;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public Date getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(Date tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telpon() {
        return no_telpon;
    }

    public String getJabatanString() {
        return jabatanString;
    }

    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
