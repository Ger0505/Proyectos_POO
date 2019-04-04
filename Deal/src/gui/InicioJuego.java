package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gerardo A A
 */
public class InicioJuego extends JFrame implements ActionListener{
    private Juego juego;
    private JPanel panel;
    private JButton jugar;
    private JButton salir;
    private BufferedImage image;
    
    public InicioJuego() {
        super.setBounds(0,0,700,500);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setUndecorated(true);
       try{
            image = ImageIO.read(getClass().getResource("../image/Dal.png"));
            super.setIconImage(image);
       }catch(IOException e){System.out.println("ImagenIcono no encontrada");};
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                ImageIcon banco = new ImageIcon(getClass().getResource("../image/panelInicio.png"));
                g.drawImage(banco.getImage(), 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
                super.paint(g);
            }
            
        };
        panel.setLayout(null);
        ImageIcon image = new ImageIcon(getClass().getResource("../image/btnJugar.png"));
        ImageIcon image2 = new ImageIcon(image.getImage().getScaledInstance(80,35,Image.SCALE_DEFAULT));
        jugar = new JButton(image2);
        jugar.setBounds(240,300,80,35);
        image = new ImageIcon(getClass().getResource("../image/btnSalir.png"));
        image2 = new ImageIcon(image.getImage().getScaledInstance(80,35,Image.SCALE_DEFAULT));
        salir = new JButton(image2);
        salir.setBounds(350,300,80,35);
        panel.add(jugar);
        panel.add(salir);
        super.add(panel);
        super.setVisible(true);
        salir.addActionListener(this);
        jugar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jugar)){
            inicializarJuego();
            super.setVisible(false);
        }else if(e.getSource().equals(salir)){
            System.exit(0);
        }
    }
    
    private void inicializarJuego(){
        Juego juego1 = new Juego(this,image);
            if(this.juego!=null)
                super.remove(this.juego);
            super.revalidate();
            super.repaint();
            this.juego = juego1;
    }
    
}
