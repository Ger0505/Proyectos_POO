package gui;

import calculadora.ShuntingYard;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Gerardo A A
 */
public class Pantalla extends JPanel{
    private JLabel entrada;
    private JLabel resultado;
    private JPanel encabezado;

    public Pantalla(){
        //super.setLayout(new GridLayout(2,1,5,5));
        super.setLayout(null);
        super.setBackground(new Color(0,102,163));
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        resultado = new JLabel("",SwingConstants.RIGHT);
        resultado.setBounds(5,20,339,30);
        resultado.setBackground(new Color(242,249,255));
        resultado.setOpaque(true);
        resultado.setFont(new Font(null,Font.BOLD,20));
        resultado.setBorder(loweredbevel);
        entrada = new JLabel("",SwingConstants.RIGHT);
        entrada.setBounds(5,70,339,40);
        entrada.setBackground(new Color(242,249,255));
        entrada.setOpaque(true);
        entrada.setFont(new Font(null,Font.BOLD,30));
        entrada.setBorder(loweredbevel);
        super.add(resultado);
        super.add(entrada);
    }
    
    public void getDato(String dato){
        this.entrada.setText(entrada.getText()+dato);
    }
    
    public void resetear(){
        this.resultado.setText("");
        this.entrada.setText("");
    }
    
    public void borrarEntrada(){
        this.entrada.setText("");
    }
    
    public void mostrarResultado(){
        String resultado = ShuntingYard.shuntingYard(entrada.getText());
        this.resultado.setText(resultado);
        //borrarEntrada();
    }
    
    public void borrarDigito(){
        if(!entrada.getText().isEmpty())
            this.entrada.setText(entrada.getText().substring(0,entrada.getText().length()-1));
    }
}
//PostGresql
//Oracle Sql
//JDBSC instalar
//configurar la conexión