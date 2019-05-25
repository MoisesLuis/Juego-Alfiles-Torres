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
                boton1[x][y].setBackground(new Color(220,120,100));
                for(int i=1;y+i<dimensionY && x+i<dimensionX&& Start.verificando == 0;i++) {
                    if(objeto[posX+i][posY+i]!=0){
                        Start.verificando = 1;
                        String mensaje = "Has perdido en la posición"+(posX+i)+", "+(posY+i);
                        JOptionPane.showMessageDialog(null,mensaje);

                    }
                    if (objeto[posX+i][posY+i]!=0)break;
                    if(boton1[x+i][y+i]!=null&& objeto[posX+i][posY+i]==0&& Start.verificando == 0){
                        boton1[x+i][y+i].setBackground(new Color(255,255,2));
                        try {
                            Thread.sleep(1000);
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
