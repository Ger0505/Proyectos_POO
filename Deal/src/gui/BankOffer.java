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
import javax.swing.JLabel;
import javax.swing.JPanel;
import listeners.DialogoListener;

/**
 *
 * @author Gerardo A A
 */
public class BankOffer extends JDialog{
    private JLabel pnlimage;
    private JPanel panel;
    private JButton deal;
    private JButton noDeal;
    private JLabel oferta;
    private DialogoListener listener;
    private int cantidad;
    public BankOffer(JFrame owner) {
        super(owner);
        super.setLayout(new BorderLayout());
        super.setUndecorated(true);
        super.setBounds(0,0,700,400);
        super.setLocationRelativeTo(owner);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pnlimage = new JLabel();
        ImageIcon banco = new ImageIcon(getClass().getResource("../image/BankGirl.png"));
        ImageIcon banco2 = new ImageIcon(banco.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT));
        pnlimage.setIcon(banco2);
        getContentPane().add(pnlimage);
        panel = new JPanel();
        oferta = new JLabel("$0");
        oferta.setForeground(Color.WHITE);
        oferta.setFont(new Font("Arial",Font.BOLD,25));
        deal = new JButton("DEAL");
        deal.setBackground(new Color(27,188,30));
        deal.setForeground(Color.WHITE);
        noDeal = new JButton("NO DEAL");
        noDeal.setBackground(Color.RED);
        noDeal.setForeground(Color.WHITE);
        deal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.darCantidad(cantidad);
                dispose();
            }
        });
        noDeal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.setBackground(Color.BLACK);
        panel.add(oferta);
        panel.add(deal);
        panel.add(noDeal);
        super.add(panel,BorderLayout.SOUTH);
        super.setVisible(false);
    }
    
    public void setOferta(int promedio){
        this.cantidad = promedio;
        this.oferta.setText("BANK OFFER $ "+promedio);
    }

    public void addDialogoListener(DialogoListener listener) {
        this.listener = listener;
    }
    
    
}
