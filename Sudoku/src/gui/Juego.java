package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import listeners.ConfigListener;

/**
 *
 * @author Gerardo A A
 */

public class Juego extends JFrame{
    private TableroCeldas tablero;
    private PanelConfig configuracion;
    
    public Juego(){ 
        super.setTitle("Sudoku");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //super.setExtendedState(MAXIMIZED_BOTH);
        //super.setUndecorated(true);
        super.setLayout(new BorderLayout());
        super.setBounds(0,0,800,700);
        setTablero();
        configuracion = new PanelConfig();
        configuracion.addConfigListener(new ConfigListener() {
            @Override
            public void reiniciarJuego() {
                setTablero();
            }

            @Override
            public void verificarCasillas() {
                tablero.changeColor();
            }
        });
        super.add(tablero,BorderLayout.CENTER);
        super.add(configuracion,BorderLayout.EAST);
        super.setVisible(true);
    }
    
     public void setTablero(){
        TableroCeldas tablero = new TableroCeldas(); // Creo un tablero 
        if(this.tablero!=null) // ya que utilizo la función para inicializar tambien, entonces no remueve nada
            super.remove(this.tablero); // remueve tablero viejo
        super.add(tablero); // Agrego tablero
        super.revalidate(); //Cosa rara que se tiene que hacer
        super.repaint();    //Cosa rara 2 que se tiene que hacer
        this.tablero = tablero; //Asigno el nuevo tablero
    }
}
