package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Gerardo A A
 */
public class pnlMateleta extends JPanel implements ActionListener{
    private JButton boton;
    private Maleta maleta;
    private JButton salir;
    public pnlMateleta(JButton salir) {
        super.setLayout(new BorderLayout());
        this.salir = salir;
        boton = new JButton();
        boton.setForeground(Color.BLACK);
        boton.setFont(new Font("Arial",Font.BOLD,80));
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.CENTER);
        SetimageMaleta("../image/maletinC.png");
        boton.addActionListener(this);
        super.add(boton,BorderLayout.CENTER);
        if(salir!=null)
        super.add(salir,BorderLayout.SOUTH);
    }

    public Maleta getMaleta() {
        return maleta;
    }

    public JButton getBoton() {
        return boton;
    }
    
    public void setMaleta(Maleta maleta) {
        this.maleta = maleta;
        this.boton.setText(maleta.getNoMaleta()+"");
        if(this.maleta == null)
            System.out.println("Maleta vacia");
    }
    
    public void SetimageMaleta(String route){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(route));
        ImageIcon imageIcon1 = new ImageIcon(imageIcon.getImage().getScaledInstance(520,500,Image.SCALE_DEFAULT));
        boton.setIcon(imageIcon1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(boton)){
                boton.setText("$  "+maleta.getCantidad());
                boton.setFont(new Font("Arial",Font.BOLD,50));
                boton.setForeground(Color.WHITE);
                SetimageMaleta("../image/maletinA.png");
                if(salir!=null)
                salir.setEnabled(true);
        }
    }
}
