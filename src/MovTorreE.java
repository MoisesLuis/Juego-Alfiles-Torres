import javax.swing.*;
import java.awt.*;

public class MovTorreE extends Thread {

    int posX,posY,dimensionX,dimensionY;
    JButton boton[][];
    int objeto[][];

    public MovTorreE(int posX, int posY, JButton boton[][],int dimensionX,int dimensionY,int objeto[][]){
        this.posX = posX;
        this.posY = posY;
        this.boton = boton;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.objeto=objeto;
    }
    public boolean rangoEast(int x, int y, JButton boton1[][]){
        for(int i=1;x+i<dimensionX;i++) {
            if(boton1[x+i][y]!=null){
                return true;
                //boton[x-i][y-i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }

    public void pintarCaminoTorre(int x,int y, JButton boton1[][]) {
        if (rangoEast(x, y, boton1)) {
            boton1[x][y].setBackground(new Color(110,150,200));
            for (int i = 1;x+i<dimensionX && Start.verificando == 0; i++) {
                if(objeto[x+i][y]==1 || objeto[x+i][y]==2){
                    Start.verificando = 1;
                    boton1[x+i][y].setBackground(new Color(200,20,20));
                    String mensaje = "Has perdido en la posición: "+" Y: "+(x+i+1)+", X: "+(y+1);
                    JOptionPane.showMessageDialog(null,mensaje);

                }

                if (objeto[x+i][y]==1 || objeto[x+i][y]==2)break;

                if (boton1[x+i][y] != null && objeto[x+i][y]==0 || objeto[x+i][y]==3 && Start.verificando == 0){
                    boton1[x+i][y].setBackground(new Color(110, 150, 200));
                    if (objeto[x+i][y]==3)
                        boton1[x+i][y].setBackground(new Color(5, 10, 50));
                    objeto[x+i][y] = 3;
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        System.out.println("Error en la clase MovTorreE: "+e);
                    }
                }
            }
        }
    }

    @Override
    public void run(){
        pintarCaminoTorre(posX,posY,boton);
    }
}
