import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovNE extends Thread {

    JButton boton1 [][];
    int posX,posY;
    public MovNE(int posX,int posY,JButton boton1[][]){
        this.boton1 = boton1;
        this.posX = posX;
        this.posY = posY;
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
    public boolean rangoDerechaArriba(int x, int y, JButton boton1[][]){
        for(int i=1;y-i>=0 && x+i<8;i++) {
            if(boton1[x+i][y-i]!=null){
                return true;
                //  boton[x+i][y-i].setBackground(Color.cyan);
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
     * @param
     * @return
     */

    @Override
    public void run(){
        if (rangoDerechaArriba(posX,posY,boton1)){
            for(int i=1;posY-i>=0 && posX+i<8;i++) {
                if(boton1[posX+i][posY-i]!=null){
                    boton1[posX+i][posY-i].setBackground(new Color(255,255,2));
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println("Error en la clase MovNE: "+e);
                    }
                }else break;
            }

        }
    }
}
