
package botonEfectosPack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.*;
import java.io.Serializable;
import javax.swing.Timer;
import javax.swing.JButton;


public class botonEfectos extends JButton implements Serializable,ActionListener {
    
    private Color colorFuente1;
    private Color colorFondo1;
    private Color colorFuente2;
    private Color colorFondo2;
    private String efecto;
    private int intervalo;
    private Timer t;

    //Constructor
    public botonEfectos() {
        this.colorFondo1 = this.getBackground();
        this.colorFondo2 = this.getBackground();
        this.colorFuente1 = this.getForeground();
        this.colorFuente2 = this.getForeground();
        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                if(efecto.compareToIgnoreCase("Hover")==0){
                    ponerColores1(false);
                }
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                if(efecto.compareToIgnoreCase("Hover")==0){
                    ponerColores1(true);
                }
            }
        });
    }
    
    
    //Gettres
    public Color getColorFondo1() {
        return colorFondo1;
    }
    public Color getColorFondo2() {
        return colorFondo2;
    }
    public Color getColorFuente1() {
        return colorFuente1;
    }
    public Color getColorFuente2() {
        return colorFuente2;
    }
    public String getEfecto() {
        return efecto;
    }
    public int getIntervalo() {
        return intervalo;
    }
 
    //Setters
    public void setColorFuente1(Color colorFuente1) {
        this.colorFuente1 = colorFuente1;
    }
    public void setColorFuente2(Color colorFuente2) {
        this.colorFuente2 = colorFuente2;
    }
    public void setColorFondo1(Color colorFondo1) {
        this.colorFondo1 = colorFondo1;
    }
    public void setColorFondo2(Color colorFondo2) {
        this.colorFondo2 = colorFondo2;
    }
    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
    
    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
        
        if(this.efecto.compareToIgnoreCase("Parpadeo")==0){
            if(this.t != null){
                this.t = new Timer(intervalo,this);
                this.t.start();
            }
            else{
                this.t.setDelay(intervalo);
            }
        }
        
    }

    //Metodos
    public void ponerColores1(boolean tf){
        if(tf){
            this.setForeground(this.colorFuente1);
            this.setBackground(this.colorFondo1);
        }
        else{
            this.setForeground(this.colorFuente2);
            this.setBackground(this.colorFondo2);
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(efecto.compareToIgnoreCase("Parpadeo")==0){
            if(this.getBackground() == colorFondo1){
                ponerColores1(false);
            }
            else{
                ponerColores1(true);
            }
        }
    }

  
    
    
}
