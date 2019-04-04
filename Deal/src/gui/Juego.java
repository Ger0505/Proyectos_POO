package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import listeners.CntTablero;
import listeners.DialogoListener;
/**
 *
 * @author Gerardo A A
 */
public class Juego extends JFrame{
    private JPanel panel;
    private PremioDialog premio;
    private dlgFinal dialogoFinal;
    private MaletaDialog maletaDialog;
    private BankOffer oferta;
    private MaletasTablero maletines;
    private CantidadesTablero tablero1;
    private CantidadesTablero tablero2;
    
    private int turnosOferta;
    private Maleta maletaFinal;
    private JLabel miMaleta;
    private JLabel texto;
    private JFrame owner;

    public Juego(JFrame owner,Image image){
        
        super("Deal Or Not Deal");
        super.setExtendedState(MAXIMIZED_BOTH);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.setIconImage(image);
        this.owner = owner;
        turnosOferta = 0;
        iniciarPanel(owner);
        panel.setBackground(Color.BLACK);
        oferta = new BankOffer(this);
        maletaDialog = new MaletaDialog(this);
        maletines = new MaletasTablero();
        tablero1 = new CantidadesTablero(CantidadesTablero.CANT_MENORES);
        tablero2 = new CantidadesTablero(CantidadesTablero.CANT_MAYORES);
        maletines.AddCntListener(new CntTablero() {
            
            @Override
            public void abrirMaleta(Maleta maleta) {
                if(maletaFinal!=null){
                    maletaDialog.setMaleta(maleta);
                    maletaDialog.setVisible(true);
                    int cantidad = maleta.getCantidad();
                    if(cantidad<1000){
                        tablero1.enableCantidad(cantidad);
                    }else{
                        tablero2.enableCantidad(cantidad);
                    }
                    if(isOferta()){
                        oferta.setOferta(maletines.promedio());
                        oferta.setVisible(true);
                    }
                    verificarCerradas();
                }else{
                    maletaFinal = maleta;
                    maleta.setEstado(Maleta.ABIERTA);
                    miMaleta.setText(maleta.getText());
                    miMaleta.setHorizontalTextPosition(SwingConstants.CENTER);
                    miMaleta.setVerticalTextPosition(SwingConstants.CENTER);
                }
            }

            @Override
            public void decisionFinal(Maleta maleta) {
               Dialogofinal(maleta);
            }
        });
        oferta.addDialogoListener(new DialogoListener() {
            @Override
            public void darCantidad(int cantidad) {
                getFinal(cantidad+"");
                
            }
        });
        JPanel aux = new JPanel(new BorderLayout());
        aux.add(maletines);
        aux.add(panel,BorderLayout.SOUTH);
        super.add(tablero1,BorderLayout.WEST);
        super.add(tablero2,BorderLayout.EAST);
        super.add(aux,BorderLayout.CENTER);
        super.setVisible(true);
    }
    
    private void verificarCerradas(){
        if(maletines.getMaletasCerradas() == 2){
            for(Maleta m:maletines.getMaletas()){
                if(m.getEstado() == Maleta.CERRADA)
                    Dialogofinal(m);
            }
        }
    }
    
    private void iniciarPanel(JFrame owner){
        panel = new JPanel();
        ImageIcon imageIcon = new ImageIcon((getClass().getResource("../image/m.png")));
        ImageIcon imageIcon1 = new ImageIcon(imageIcon.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
        miMaleta = new JLabel(imageIcon1);
        miMaleta.setBounds(100,0,70,70);
        JButton salir = new JButton("SALIR");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.setVisible(true);
                dispose();
            }
        });
        salir.setBackground(Color.BLACK);
        salir.setForeground(Color.WHITE);
        salir.setBounds(0,0,50,35);
        panel.add(miMaleta);
        panel.add(salir);
        
    }
    
    public boolean isOferta(){
        turnosOferta++;
        if(turnosOferta==5){
            turnosOferta = 0;
            return true;
        }else
            return false;
    }
    
    private void Dialogofinal(Maleta maleta){
        dialogoFinal = new dlgFinal(this,maletaFinal,maleta);
        dialogoFinal.addDialogoListener(new DialogoListener() {
            @Override
            public void darCantidad(int cantidad) {
                getFinal(cantidad+"");
                dialogoFinal.setVisible(false);
            }
        });
        dialogoFinal.setVisible(true);
    }
    
     public void getFinal(String cantidad){
        premio = new PremioDialog(this,cantidad);
    }

    public JFrame getOwner() {
        return owner;
    }
     
    
}
