package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import listeners.ConfigListener;

/**
 *
 * @author Gerardo A A
 */
public class PanelConfig extends JPanel{
    private JButton reiniciar;
    private JButton verificar;
    //private JButton cerrar;
    private boolean presionado;
    
    
    private ConfigListener listener;

    public PanelConfig(){
        //super.setBackground(Color.WHITE);
        this.presionado = false;
        reiniciar = new JButton("Reiniciar");
        reiniciar.setBorder(BorderFactory.createLineBorder(new Color(64, 205, 81  ),3));
        reiniciar.setBackground(new Color(3, 234, 31));
        reiniciar.setFont(new Font(null,Font.PLAIN,20));
        verificar = new JButton("Verificar");
        changeVerificado();
        //cerrar = new JButton("X");
        //cerrar.setBorder(BorderFactory.createLineBorder(Color.RED,3));
        //cerrar.setBackground(new Color(234, 14,3));
        //cerrar.setFont(new Font(null,Font.PLAIN,20));
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.reiniciarJuego();
            }
        });
        verificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.verificarCasillas();
                changeVerificado();
            }
        });
        /*cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });*/
        super.add(reiniciar);
        super.add(verificar);
        //super.add(cerrar);
    }

    public void addConfigListener(ConfigListener listener) {
        this.listener = listener;
    }
    
    private void changeVerificado(){
        if(presionado){
            verificar.setBorder(BorderFactory.createLineBorder(Color.RED,3));
            verificar.setBackground(new Color(234, 14,3));
            verificar.setFont(new Font(null,Font.PLAIN,20));
            presionado = false;
        }else{
            verificar.setBorder(BorderFactory.createLineBorder(new Color(64, 205, 81  ),3));
            verificar.setBackground(new Color(3, 234, 31));
            verificar.setFont(new Font(null,Font.PLAIN,20));
            presionado = true;
        }
    }
    
}
