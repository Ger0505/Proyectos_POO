package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import listeners.DialogoListener;

/**
 *
 * @author Gerardo A A
 */
public class dlgFinal extends JDialog{
    private pnlMateleta opcion1;
    private pnlMateleta opcion2;
    private JPanel panel;
    
    private DialogoListener listener;

    public dlgFinal(JFrame owner,Maleta maleta1,Maleta maleta2){
        super(owner, true);
        super.setLayout(new BorderLayout());
        super.setBounds(0,0,1040,500);
        super.setUndecorated(true);
        super.setLocationRelativeTo(owner);
       opcion1 = new pnlMateleta(null){
           @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(getBoton())){
                    listener.darCantidad(opcion1.getMaleta().getCantidad());
                }
            }
       };
       opcion2 = new pnlMateleta(null){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(getBoton())){
                    listener.darCantidad(opcion2.getMaleta().getCantidad());
                    ocultar();
                }
            }
           
       };
       opcion1.setMaleta(maleta1);
       opcion2.setMaleta(maleta2);
       opcion1.setBackground(Color.BLACK);
       opcion2.setBackground(Color.BLACK);
       inicializarPanel();
       JPanel aux = new JPanel(new GridLayout(1,2));
       aux.setBackground(Color.BLACK);
       aux.add(opcion1);
       aux.add(opcion2);
       super.add(aux);
       super.add(panel,BorderLayout.SOUTH);
        super.setVisible(false);
    }

    public void addDialogoListener(DialogoListener listener) {
        this.listener = listener;
    }
    
    private void inicializarPanel(){
        panel = new JPanel(new GridLayout(1,2));
        panel.setBackground(Color.BLACK);
        JLabel lb1= new JLabel("TU MALETA",SwingConstants.CENTER);
        lb1.setForeground(Color.WHITE);
        JLabel lb2= new JLabel("ULTIMA MALETA",SwingConstants.CENTER);
        lb2.setForeground(Color.WHITE);
        panel.add(lb1);
        panel.add(lb2);
    }
    
    private void ocultar(){
        super.setVisible(false);
    }
}
