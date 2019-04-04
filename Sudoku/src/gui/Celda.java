package gui;

import enums.Grupo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author Gerardo A A
 */
public class Celda extends JTextField{
    private int fila;
    private int columna;
    private Grupo grupo;
    private int dato;
    private boolean bloqueado;

    public Celda(int fila,int columna) {
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(new Font("Arial",Font.BOLD,30));
        this.fila = fila;
        this.columna = columna;
        this.bloqueado = false;
        this.dato = 0;
        super.setText("");
        asignarGrupo();
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
        //super.setText(dato+"");
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
        super.setText(dato+"");
        super.setForeground(Color.WHITE);
    }
    
    
    
    private void asignarGrupo(){
        if(fila<=2){
            switch(columna){
                case 0: 
                case 1:
                case 2:
                    this.grupo = Grupo.UNO;
                    break;
                case 3: 
                case 4:
                case 5: 
                    this.grupo = Grupo.DOS;
                    break;
                case 6: 
                case 7:
                case 8:
                    this.grupo = Grupo.TRES;
                    break;
            }
        }else if(fila<=5){
            switch(columna){
                case 0: 
                case 1:
                case 2:
                    this.grupo = Grupo.CUATRO;
                    break;
                case 3: 
                case 4:
                case 5: 
                    this.grupo = Grupo.CINCO;
                    break;
                case 6: 
                case 7:
                case 8:
                    this.grupo = Grupo.SEIS;
                    break;
            }
        }else{
            switch(columna){
                case 0: 
                case 1:
                case 2:
                    this.grupo = Grupo.SIETE;
                    break;
                case 3: 
                case 4:
                case 5: 
                    this.grupo = Grupo.OCHO;
                    break;
                case 6: 
                case 7:
                case 8:
                    this.grupo = Grupo.NUEVE;
                    break;
            }
        }
        setColorFondo(false);
    }
    
    public void setColorFondo(boolean verificando){
        Color color1 = null,color2 = null;
        if(!verificando){
            color1 = new Color(60,245,38);
            color2 = new Color(143,255,129);
        }else{
            color1 = color2 = Color.RED;
        }
        switch(grupo){
            case UNO:
            case TRES:
            case CINCO:
            case SIETE:
            case NUEVE:
                setBackground(color1);
                break;
            case DOS:
            case CUATRO:
            case SEIS:
            case OCHO:
                setBackground(color2);
                break;
        }
    }
}
