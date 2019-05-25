import javax.swing.*;
import java.awt.*;

public class MovTorreN extends Thread{

    int posX,posY,dimensionX,dimensionY;
    JButton boton[][];
    int objeto[][];

    public MovTorreN(int posX,int posY, JButton boton[][],int dimensionX,int dimensionY,int objeto[][]){
        this.posX = posX;
        this.posY = posY;
        this.boton = boton;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.objeto=objeto;
    }

    public boolean rangoNorth(int x, int y, JButton boton1[][]){
        for(int i=1;y-i>=0 && x<dimensionX;i++) {
            if(boton1[x][y-i]!=null){
                return true;
                //boton[x-i][y-i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }

    public void pintarCaminoTorre(int x,int y, JButton boton1[][]) {
        if (rangoNorth(x, y, boton1)) {
            boton1[x][y].setBackground(new Color(100,100,100));
            for (int i = 1; y - i >= 0 && x < dimensionX&& Start.verificando == 0; i++) {
                if(objeto[x][y-i]!=0){
                    Start.verificando = 1;
                    String mensaje = "Has perdido en la posición"+(x)+", "+(y-i);
                    JOptionPane.showMessageDialog(null,mensaje);
                }
                if (objeto[x][y-i]!=0)break;
                if (boton1[x][y - i] != null && objeto[x][y-i]==0&& Start.verificando == 0) {
                    boton1[x][y - i].setBackground(new Color(80, 80, 88));
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println("Error en la clase MovTorreN: "+e);
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        pintarCaminoTorre(posX,posY,boton);
    }
}
