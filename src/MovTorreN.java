import javax.swing.*;
import java.awt.*;

public class MovTorreN extends Thread{

    public boolean rangoNorth(int x, int y, JButton boton1[][]){
        for(int i=1;y-i>=0 && x<8;i++) {
            if(boton1[x][y-i]!=null){
                return true;
                //boton[x-i][y-i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }

    public void pintarCaminoTorre(int x,int y, JButton boton1[][]) {
        if (rangoNorth(x, y, boton1)) {
            for (int i = 1; y - i >= 0 && x < 8; i++) {
                if (boton1[x][y - i] != null) {
                    boton1[x][y - i].setBackground(new Color(80, 80, 88));
                } else break;
            }
            boton1[x][y].setBackground(new Color(150,150,150));
        }
    }
}
