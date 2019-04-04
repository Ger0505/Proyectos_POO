package gui;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *
 * @author Gerardo A A
 */
public class TableroCeldas extends JPanel{
    private Celda[][] celdas;
    private boolean verificando;
    
    public TableroCeldas() {
        super.setLayout(new GridLayout(9,9));
        celdas = new Celda[9][9];
        this.verificando = false;
        leerMatriz();
        bloquearCeldas();
    }
    
    private void bloquearCeldas(){
        Random random = new Random();
        int x,y,cont = 0;
        while(cont!=17){
            x = random.nextInt(8);
            y = random.nextInt(8);
            if(!celdas[x][y].isBloqueado()){
                celdas[x][y].setBloqueado(true);
                celdas[x][y].setEditable(false);
                cont++;
            }
        }
    }
    
    public void changeColor(){
        if(verificando) this.verificando = false;
        else this.verificando = true;
        for(Celda[] fila:celdas){
            for(Celda celda:fila){
                if(!celda.getText().equals(celda.getDato()+""))
                    celda.setColorFondo(verificando);
            }
        }
    }
    
    private void verificar(){
        int cont = 81;
        for(Celda[] fila:celdas){
            for(Celda celda:fila){
                if(celda.getText().equals(celda.getDato()+""))
                    cont--;
            }
        }
        if(cont == 0){
            for(Celda[] fila:celdas){
            for(Celda celda:fila){
                if(celda.getText().equals(celda.getDato()+""))
                    celda.setEnabled(false);
            }
        }
        }
    }
    
    private void leerMatriz(){
        Scanner scanner = null;
        try{
         scanner = new Scanner(new File("C:\\Users\\Gerardo A A\\Documents\\tableroSudoku_No1.txt"));
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        };
        for(int i = 0;i<9;i++){
           String line = scanner.nextLine();
           for(int j = 0;j<9;j++){
               celdas[i][j] = new Celda(i,j);
               celdas[i][j].setDato(Integer.valueOf(line.substring(j,j+1)));
               celdas[i][j].addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        verificar();
                    }
                });
                super.add(celdas[i][j]);
           } 
        }
    }

}
