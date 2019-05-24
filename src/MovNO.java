import javax.swing.*;
import java.awt.*;


public class MovNO extends Thread{


    int posX,posY;
    JButton boton1[][];
    public MovNO(int posX,int posY, JButton boton1[][]){
        this.posX = posX;
        this.posY = posY;
        this.boton1 = boton1;
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
    public boolean rangoIzqArriba(int x, int y, JButton boton1[][]){
        for(int i=1;y-i>=0 && x-i>=0;i++) {
            if(boton1[x-i][y-i]!=null){
                return true;
                //boton[x-i][y-i].setBackground(Color.cyan);
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


    public void run(){
        if (rangoIzqArriba(posX, posY,boton1)) {
            for (int i = 1; posY - i >= 0 && posX - i >= 0; i++) {
                if (boton1[posX - i][posY - i] != null) {
                    boton1[posX - i][posY - i].setBackground(new Color(255, 255, 2));
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println("Error en la clase MovNO: "+e);
                    }
                } else break;
            }
        }
    }
}
