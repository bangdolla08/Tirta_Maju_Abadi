package Tirta_Maju_Abadi.toll;

import java.sql.*;

public class database {
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    public database(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String alamat="localhost";
            String Port="3306";
            String Nama_db="db_tirta_maju_abadi";
            String Username="root";
            String Pasword="";
            cn=DriverManager.getConnection("jdbc:mysql://"+
            alamat+":"+Port+"/"+Nama_db,Username,Pasword);
            st=cn.createStatement();
        }catch(Exception e){
            System.out.println("Pesan Error : " + e);
        }
    }
    public ResultSet getRs(String a){
        try{
            //rs.close();
            rs=st.executeQuery(a);
        }catch(Exception e){
            System.err.println("Pesan Error : " + e);
        }
        return rs;
    }
    
    public boolean setDB(String a){
        try {
            st.executeUpdate(a);
            return true;
        } catch (Exception e) {
            System.err.println("Pesan Error : " + e);
            return false;
        }
    }
}
