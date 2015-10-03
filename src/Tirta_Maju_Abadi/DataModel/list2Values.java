package Tirta_Maju_Abadi.DataModel;

public class list2Values {
    private String stringNya;
    private int isinya;
    /**
     *public list<list2Values> namanya(){
     * list<list2values> ajshd=new 
     *  for(md_produk tmp:ld.listMD_produk){
     *      ajshd.add(new list2Values(tmp.namapruduk,tmp.id_produk);
     *  }
     * }
     * 
     */
    public list2Values(String stringNya, int isinya) {
        this.stringNya = stringNya;
        this.isinya = isinya;
    }

    public list2Values(String stringNya) {
        this.stringNya=stringNya;
    }
    
    

    public String getStringNya() {
        return stringNya;
    }

    public void setStringNya(String stringNya) {
        this.stringNya = stringNya;
    }

    public int getIsinya() {
        return isinya;
    }

    public void setIsinya(int isinya) {
        this.isinya = isinya;
    }
    
    public boolean sama(int isinya){
        if(isinya==this.isinya)
            return true;
        else
            return false;
    }
    public boolean sama(String stringNya){
        if(stringNya==this.stringNya)
            return true;
        else
            return false;
    }
}
