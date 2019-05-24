import javax.swing.*;
import java.awt.*;

public class MovSO extends Thread {
    /**
     *
     * @param x
     * El parámetro anterior nos sirve para
     * que en la posición "x" en la cuál se seleccionó
     * pueda inicializar el array que nos permitirá colorear
     * las demás casillas
     * @param y
     * * El parámetro anterior nos sirve para
     * que en la posición "x" en la cuál se seleccionó
     * pueda inicializar el array que nos permitirá colorear
     * las demás casillas
     * @param boton1
     * @return
     */
    public boolean rangoIzqAbajo(int x, int y, JButton boton1[][]){
        for(int i=1;y+i<8 && x-i>=0;i++) {
            if(boton1[x-i][y+i]!=null){
                return true;
                //boton[x-i][y+i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }

    /**
     *
     * @param x
     * El parámetro anterior nos sirve para
     * que en la posición "x" en la cuál se seleccionó
     * pueda inicializar el array que nos permitirá colorear
     * las demás casillas
     * @param y
     * * El parámetro anterior nos sirve para
     * que en la posición "x" en la cuál se seleccionó
     * pueda inicializar el array que nos permitirá colorear
     * las demás casillas
     * @param boton1
     * @return
     */
    public void pintarCaminoAlfil(int x,int y,JButton boton1[][]){
        if (rangoIzqAbajo(x,y,boton1)){
            for(int i=1;y+i<8 && x-i>=0;i++) {
                if(boton1[x-i][y+i]!=null){
                    boton1[x-i][y+i].setBackground(new Color(255,255,2));
                }else break;
            }
        }
    }
}
