/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import listeners.TecladoListener;

/**
 *
 * @author Gerardo A A
 */
public class Teclado extends JPanel{
    public static final String[] CARACTERES ={"C","CE",'\u00AB'+"","=","^","S","T","U","V","*","W","X","Y","Z","/","R","(",")","+","-"};
    private ArrayList<JButton> botones;
    
    private TecladoListener listener;
    
    public Teclado(){
        super.setLayout(new GridLayout(4,5));
        super.setBackground(new Color(0,102,163));
        botones = new ArrayList<>(20);
        for(int i =0 ;i<20 ; i++){
            int x = i;
            botones.add(new JButton(CARACTERES[i]));
            botones.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String dato = botones.get(x).getText();
                    switch(dato){
                        case "=":
                            listener.mostrarResultado();
                            break;
                        case "CE":
                            listener.borrarEntrada();
                            break;
                        case "C":
                            listener.borrarPantalla();
                            break;
                        case '\u00AB'+"":
                            listener.borrarUltimoDigito();
                            break;
                        default:
                            listener.enviarDato(dato);
                            break;
                    }
                }
            });
            botones.get(i).setBackground(new Color(39,217,247));
            if(CARACTERES[i].equals("="))
              botones.get(i).setBackground(Color.ORANGE);  
            botones.get(i).setFont(new Font(null,Font.BOLD,20));
            botones.get(i).setForeground(Color.WHITE);
            super.add(botones.get(i));
        }
    }

    public void addTecladoListener(TecladoListener listener) {
        this.listener = listener;
    }    
}
