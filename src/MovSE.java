import javax.swing.*;
import java.awt.*;

public class MovSE extends Thread {

    int posX, posY,dimensionX,dimensionY;
    JButton boton[][];
    int objeto[][];
    public MovSE(int poxX,int posY, JButton boton[][],int dimensionX,int dimensionY,int objeto[][]){
        this.posX = poxX;
        this.posY = posY;
        this.boton = boton;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.objeto=objeto;

    }

    public boolean rangoDerechaAbajo(int x, int y, JButton boton1[][]){
        for(int i=1;y+i<dimensionY && x+i<dimensionX;i++) {
            if(boton1[x+i][y+i]!=null){
                return true;
                //boton[x+i][y+i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }

    public void pintarCaminoAlfil(int x, int y, JButton boton1[][]) {
        try{
            if (rangoDerechaAbajo(x,y,boton1) == true){
                boton1[x][y].setBackground(new Color(20,50,100));
                for(int i=1;y+i<dimensionY && x+i<dimensionX&& Start.verificando == 0;i++) {
                    if(objeto[posX+i][posY+i]==1 || objeto[posX+i][posY+i]==2){
                        Start.verificando = 1;
                        boton1[posX+i][posY+i].setBackground(new Color(200,20,20));
                        String mensaje = "Has perdido en la posición: "+" Y: "+(posX+i+1)+", X: "+(posY+i+1);
                        JOptionPane.showMessageDialog(null,mensaje);
                    }
                    if (objeto[posX+i][posY+i]==1 || objeto[posX+i][posY+i]==2 )break;
                    if(boton1[x+i][y+i]!=null&& objeto[posX+i][posY+i]==0 || objeto[posX+i][posY+i]==3&& Start.verificando == 0){
                        boton1[x+i][y+i].setBackground(new Color(20,50,100));
                        if (objeto[posX+i][posY+i]==3)
                            boton1[posX+i][posY+i].setBackground(new Color(5, 10, 50));

                        objeto[posX+i][posY+i] = 3;

                        try {
                            Thread.sleep(500);
                        }catch (InterruptedException e){
                            System.out.println("Error en la clase MovSE: "+e);
                        }
                    }
                }

            }
        }
        catch (Exception e){
            System.out.println("Error: "+e);
        }

    }

    @Override
    public void run() {
        pintarCaminoAlfil(posX,posY,boton);
    }
}
