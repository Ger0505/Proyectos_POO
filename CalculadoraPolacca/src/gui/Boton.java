/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import listeners.TecladoListener;

/**
 *
 * @author Gerardo A A
 */
public class Boton extends JButton{
    public final static int ENCIMA = 0;
    public static final int AFUERA = 1;
    public static final int CLICKEADO = 2;

    private int Estado;
    public Boton(String text) {
        super(text);

    }

    @Override
    public void paint(Graphics g) {
       Graphics2D gr = (Graphics2D) g;
       switch(Estado){
           case AFUERA:
               gr.setColor(new Color(39,217,247));
            if(super.getText().equals("="))
              gr.setColor(Color.ORANGE); 
               
               break;
           case ENCIMA:
               gr.setColor(new Color(1,242,216));
               break;
           case CLICKEADO:
               gr.setColor(new Color(1,242,144));
               break;
       }
       gr.fillRect(0,0,getWidth(),getHeight());
        super.paint(gr); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    
}
