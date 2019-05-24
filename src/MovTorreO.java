import javax.swing.*;
import java.awt.*;

public class MovTorreO extends Thread {
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
    public boolean rangoWest(int x, int y, JButton boton1[][]){
        for(int i=1;x-i>=0;i++) {
            if(boton1[x-i][y]!=null){
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
    public void pintarCaminoTorre(int x,int y, JButton boton1[][]) {
        if (rangoWest(x, y, boton1)) {
            for (int i = 1; x-i>=0; i++) {
                if (boton1[x-i][y] != null) {
                    boton1[x-i][y].setBackground(new Color(80, 80, 88));
                } else break;
            }
        }
    }
}
