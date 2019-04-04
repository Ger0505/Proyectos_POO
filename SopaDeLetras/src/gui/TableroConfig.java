package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import listeners.TableroConfigListener;

/**
 *
 * @author Gerardo A A
 */
public class TableroConfig extends JPanel implements ActionListener{
    private JButton solucion;
    private JButton cancelar;
    private TableroConfigListener listener;
    
    public TableroConfig() {
        solucion = new JButton("SOLUCION");
        cancelar = new JButton("SALIR");
        solucion.addActionListener(this);
        cancelar.addActionListener(this);
        super.add(solucion);
        super.add(cancelar);
    }

    public void addTableroConfigListener(TableroConfigListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(solucion)){
            listener.mostrarPalabras();
        }else{
           listener.salir();
        }
    }
    
    
    
}
