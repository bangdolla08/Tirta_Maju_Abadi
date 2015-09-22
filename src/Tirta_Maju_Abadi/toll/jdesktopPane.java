/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.toll;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.UIManager;
import javax.swing.plaf.DesktopPaneUI;

/**
 *
 * @author NEEZAR
 */
public class jdesktopPane extends JDesktopPane{
    private Image backImage=null;
    
    public jdesktopPane(){
    
        try{
            backImage=new javax.swing.ImageIcon(this.getClass().getResource("TMA.png")).getImage();
        }catch(Exception e){
            
        }
       
    }
    
    public void paintComponent(Graphics g){
        
        if(backImage == null){
            super.paintComponent(g);
        }
        else{
            g.drawImage(backImage,
                    (this.getSize().width - backImage.getWidth(null)),
                    (this.getSize().height - backImage.getHeight(null)),this);
        }
    }
}
