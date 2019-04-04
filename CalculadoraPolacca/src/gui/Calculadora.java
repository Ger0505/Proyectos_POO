package gui;

import java.awt.Color;
import javax.swing.JFrame;
import listeners.TecladoListener;
/**
 *
 * @author Gerardo A A
 */
public class Calculadora extends JFrame{
    private Pantalla pantalla;
    private Teclado teclado;
    private Encabezado encabezado;
    
    public Calculadora(){
        super.setTitle("Calculadora Polaca");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(null);
        super.setResizable(false);
        super.setUndecorated(true);
        super.setBounds(900,130,350,500);
        this.getContentPane().setBackground(new Color(0,102,163));
        this.encabezado = new Encabezado();
        encabezado.setBounds(0,0,350,51);
        this.pantalla = new Pantalla();
        pantalla.setBounds(0,51,360,120);
        this.teclado = new Teclado();
        teclado.setBounds(1,171,348,327);
        //this.encabezado = new Encabezado();
        teclado.addTecladoListener(new TecladoListener() {
            @Override
            public void enviarDato(String dato) {
                pantalla.getDato(dato);
            }

            @Override
            public void mostrarResultado(){
                pantalla.mostrarResultado();
            }

            @Override
            public void borrarPantalla() {
                pantalla.resetear();
            }

            @Override
            public void borrarEntrada() {
                pantalla.borrarEntrada();
            }

            @Override
            public void borrarUltimoDigito() {
                pantalla.borrarDigito();
            }
        });
        super.add(encabezado);
        super.add(pantalla);
        super.add(teclado);
        super.setVisible(true);
    }
    
}
