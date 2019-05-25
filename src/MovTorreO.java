import javax.swing.*;
import java.awt.*;

public class MovTorreO extends Thread {

    int posX,posY,dimensionX,dimensionY;
    JButton boton[][];
    int objeto[][];

    public MovTorreO(int posX, int posY, JButton boton[][],int dimensionX,int dimensionY,int []objeto[]){
        this.posX = posX;
        this.posY = posY;
        this.boton = boton;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.objeto=objeto;
    }

    public boolean rangoWest(int x, int y, JButton boton1[][]){
        for(int i=1;x-i>=0;i++) {
            if(boton1[x-i][y]!=null){
                return true;
                //boton[x-i][y-i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }

    public void pintarCaminoTorre(int x,int y, JButton boton1[][]) {
        if (rangoWest(x, y, boton1)) {
            for (int i = 1; x-i>=0&& Start.verificando == 0; i++) {
                if(objeto[x-i][y]!=0){
                    Start.verificando=1;
                    String mensaje = "Has perdido en la posición"+(x-i)+", "+(y);
                    JOptionPane.showMessageDialog(null,mensaje);
                }
                if(objeto[x-i][y]!=0) break;
                if (boton1[x-i][y] != null && objeto[x-i][y]==0 && Start.verificando == 0) {
                    boton1[x-i][y].setBackground(new Color(80, 80, 88));
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println("Error en la clase MovTorreO: "+e);
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
