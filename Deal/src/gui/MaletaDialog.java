package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Gerardo A A
 */
    public class MaletaDialog extends JDialog{
        private pnlMateleta panel;
        private JButton salir;
        

    public MaletaDialog(JFrame owner) {
        super(owner,true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setBounds(0,0,500,500);
        super.setLocationRelativeTo(owner);
        super.setUndecorated(true);
        super.setLayout(new BorderLayout());
        salir = new JButton("CANCELAR");
        panel = new pnlMateleta(salir);
        salir.setBackground(Color.BLACK);
        salir.setForeground(Color.WHITE);
        salir.setEnabled(false);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.SetimageMaleta("../image/maletinC.png");
                panel.getBoton().setFont(new Font("Arial",Font.BOLD,80));
                panel.getBoton().setForeground(Color.BLACK);
                salir.setEnabled(false);
                dispose();
            }
        });
        super.add(panel);
        super.add(salir,BorderLayout.SOUTH);
        super.setVisible(false);
    }
    
    public void setMaleta(Maleta maleta) {
        panel.setMaleta(maleta);
    }
    
}