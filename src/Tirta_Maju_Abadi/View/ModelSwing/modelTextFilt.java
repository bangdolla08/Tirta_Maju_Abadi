package Tirta_Maju_Abadi.View.ModelSwing;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class modelTextFilt extends JTextField{
    private JLabel jl;
    public modelTextFilt(){
        this.setText("");
    }
    public void reset(){
        this.setText(jl.getText());
    }
    public modelTextFilt(JLabel jl){
        this.jl=jl;
        reset();
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(getText().equals(jl.getText()))
                    setText("");
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(getText().equals(""))
                    reset();
            }
        });
    }
    public int getInteger(){
        int result=0;
        try {
            result=Integer.parseInt(getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Maaf Inputan Anda Harus Angka ");
        }
        return result;
    }
    
    public String getString(){
        return getText();
    }
    public void setFromInt(int angka){
        setText(""+angka);
    }
    public void setText(Object obj){
        setText(""+obj);
    }
    public boolean Kosongkah(){
        if(getText().equals("")||getText().equals(jl.getText())){
            JOptionPane.showMessageDialog(this, "Maaf Inputan "+jl.getText()+" Tidak Boleh Kosong");
            return false;
        }else
            return true;
    }
}
