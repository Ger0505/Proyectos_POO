package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gerardo A A
 */
public class Encabezado extends JPanel{
    private JLabel title;
    private JButton cerrar;
    public Encabezado() {
        super.setLayout(null);
        //super.setBackground(new Color(0,102,163));
        super.setBackground(new Color(0,102,163));
        title = new JLabel("CALCULADORA POLACA");
        title.setForeground(Color.WHITE);
        title.setBounds(0,5,200,40);
        cerrar = new JButton("X");
        cerrar.setForeground(Color.WHITE);
        cerrar.setOpaque(false);
        cerrar.setContentAreaFilled(false);
        cerrar.setBorderPainted(false);
        cerrar.setBounds(300,0,50,50);
        cerrar.setFont(new Font(null,Font.BOLD,20));
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        super.add(title);
        super.add(cerrar);
    }
    
}
