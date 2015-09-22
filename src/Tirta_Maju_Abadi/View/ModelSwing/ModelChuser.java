package Tirta_Maju_Abadi.View.ModelSwing;

import Tirta_Maju_Abadi.DataModel.list2Values;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ModelChuser extends javax.swing.JComboBox{
    public ModelChuser(){
        removeAllItems();
        addItem(DPilih);
    }
    public ModelChuser(JLabel jl){
        this.jl=jl;
        removeAllItems();
        addItem(DPilih);
    }
    
    private JLabel jl;
    
    private static final String DPilih="--Pilih--";
    public boolean Kosongkah(){
        if(getSelectedItem().equals(DPilih)){
            JOptionPane.showMessageDialog(this, "Maaf Anda Belom Memilih "+jl.getText());
            return false;
        }else{
            return true;
        }
    }
    public void reset(){
        setSelectedItem(DPilih);
    }
    public String getSelectedItemS(){
        return getSelectedItem().toString();
    }
    
     public void setModel(List<list2Values> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
