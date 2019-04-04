package gui;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Gerardo A A
 */
//e  E 3
public class Maleta extends JButton{  
    public static final int CERRADA = 0;
    public static final int ABIERTA = 1;
    
    private int noMaleta;
    private int cantidad;
    private int estado;
    
    public Maleta(int noMaleta,int cantidad) {
        super(noMaleta+"");
        imageMaleta();
        super.setHorizontalTextPosition(SwingConstants.CENTER);
        super.setVerticalTextPosition(SwingConstants.CENTER);
        super.setFont(new Font("Arial",Font.BOLD,40));
        this.noMaleta = noMaleta;
        this.cantidad = cantidad;
        this.estado = CERRADA;
        super.setBorderPainted(false);
        super.setContentAreaFilled(false);
    }

    public int getNoMaleta() {
        return noMaleta;
    }

    public void setNoMaleta(int noMaleta) {
        this.noMaleta = noMaleta;
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        this.setIcon(null);
        this.setText("");
    }
    
    private void imageMaleta(){
        ImageIcon imageIcon = new ImageIcon((getClass().getResource("../image/m.png")));
        ImageIcon imageIcon1 = new ImageIcon(imageIcon.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
        this.setIcon(imageIcon1);
    }
}
