package gui;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import listeners.CntTablero;

/**
 *
 * @author Gerardo A A
 */
//e  E 3
public class MaletasTablero extends JPanel{
    public static final int[] VALORES = {0,1,5,10,25,50,75,100,200,300,400,500,750,
    1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000};
    private Image image;
    
    private ArrayList<Maleta> maletas;
    private MaletaDialog maletadlg;
    private CntTablero listener;
    private int maletasCerradas;
    
    public MaletasTablero() {
        super.setLayout(new FlowLayout((int) RIGHT_ALIGNMENT,30,40));
        imagePanel();
        maletas = new ArrayList<>(26);
        maletasCerradas = 26;
        revolverValores();
        for(int i = 0;i<26;i++){
            int x = i;
            maletas.add(new Maleta(i+1,VALORES[i]));
            maletas.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(maletas.get(x).getEstado() == Maleta.CERRADA){
                        maletas.get(x).setEstado(Maleta.ABIERTA);
                        listener.abrirMaleta(maletas.get(x));
                        maletasCerradas--;
                    }
                }
            });
            super.add(maletas.get(i));
        }
    }

    public ArrayList<Maleta> getMaletas() {
        return maletas;
    }

    public int getMaletasCerradas() {
        return maletasCerradas;
    }

    public void AddCntListener(CntTablero listener) {
        this.listener = listener;
    } 
    
    //Algoritmo de Fisher-Yates
    private void revolverValores(){
        int cantidad = VALORES.length;
        Random az = new Random();
        for(int k=cantidad-1;k>=1;k--){
            int p = az.nextInt(k);
            int tmp = VALORES[p];
            VALORES[p]=VALORES[k];
            VALORES[k]=tmp;
        }
        
    }
    
    public int promedio(){
        int promedio = 0;
        int maletasCerradas=0;
        for(Maleta maleta: maletas){
            if(maleta.getEstado() == Maleta.CERRADA){
                maletasCerradas++;
                promedio+=maleta.getCantidad();
            }       
        }
        return promedio/maletasCerradas;
    }
    
    private void imagePanel(){
        try{
            image = ImageIO.read(getClass().getResource("../image/panel.jpg"));
        }catch(IOException e){System.out.println("Imagen no encontrada");};
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    } 
    
}
