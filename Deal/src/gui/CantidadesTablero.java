package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Gerardo A A
 */
//e  E 3
public class CantidadesTablero extends JPanel{
    public static final int[] CANT_MENORES = {0,1,5,10,25,50,75,100,200,300,400,500,750};
    public static final int[] CANT_MAYORES ={1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000};
    
    private JTextField[] tabla = new JTextField[13];

    public CantidadesTablero(int[] cantidades) {
        super.setLayout(new GridLayout(13,1));
        
       for(int i = 0;i<13;i++){
           
           tabla[i] = new JTextField(""+cantidades[i],15);
           tabla[i].setEditable(false);
           tabla[i].setBackground(Color.BLACK);
           tabla[i].setForeground(Color.WHITE);
           tabla[i].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
           tabla[i].setFont(new Font("Arial",Font.BOLD,20));
           tabla[i].setHorizontalAlignment(JTextField.CENTER);
           super.add(tabla[i]);
       }
    }
    
    public void enableCantidad(int cantidad){
        for(JTextField label:tabla){
            if(label.getText().equals(""+cantidad)){
                label.setEditable(true);
                label.setText("");
                label.setEditable(false);
            }
        }
    }
 
}
