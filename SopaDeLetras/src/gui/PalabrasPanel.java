package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gerardo A A
 */
public class PalabrasPanel extends JPanel{
    private JLabel[] palabras;
    private String[] words;
    private int palabrasEncontrada;
    
    public PalabrasPanel(String[] words) {
        super.setLayout(new GridLayout(words.length,1));
        this.words = words;
        this.palabrasEncontrada = 0;
        palabras = new JLabel[words.length];
        for(int i = 0;i < words.length;i++){
            palabras[i] = new JLabel(words[i]);
            super.add(palabras[i]);
        }
    }
    
    public void tacharPalabra(String palabra){
        for(JLabel etiqueta:palabras){
            if(etiqueta.getText().equals(palabra) && etiqueta.getBackground()!=Color.GRAY){
                etiqueta.setForeground(Color.GRAY);
                palabrasEncontrada++;
            }
        }
    }

    public int getPalabrasEncontrada() {
        return palabrasEncontrada;
    }
    
    
}
