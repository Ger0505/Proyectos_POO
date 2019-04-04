package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Gerardo A A
 */
public class PremioDialog extends JDialog{
    private JLabel label;
    private JPanel panel;
    private JButton salir;

    public PremioDialog(JFrame owner,String cantidad){
        super(owner);
        super.setBounds(0,0,500,500);
        super.setUndecorated(true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(owner);
        super.setLayout(new BorderLayout());
        label = new JLabel("$   "+cantidad);
        panel = new JPanel();
        salir = new JButton("SALIR DEL JUEGO");
        salir.setBackground(Color.BLACK);
        salir.setForeground(Color.WHITE);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                owner.dispose();
                owner.getOwner().setVisible(true);
            }
        });
        ImageIcon banco = new ImageIcon(getClass().getResource("../image/MaletinA.png"));
        ImageIcon banco2 = new ImageIcon(banco.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT));
        label.setIcon(banco2);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial",Font.BOLD,50));
        panel.setBackground(Color.BLACK);
        JLabel etiqueta = new JLabel("<html><body>Congratulation!<br>Ganaste</body></html>");
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setFont(new Font("Arial",Font.BOLD,30));
        panel.add(etiqueta);
        super.add(panel,BorderLayout.NORTH);
        super.add(label);
        super.add(salir,BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
}
