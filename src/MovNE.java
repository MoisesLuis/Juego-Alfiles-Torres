import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovNE extends Thread {

    JButton boton1 [][];
    int objeto[][];
    int posX,posY,dimensionX,dimensionY;
    public MovNE(int posX,int posY,JButton boton1[][],int dimensionX,int dimensionY,int objeto[][]){
        this.boton1 = boton1;
        this.posX = posX;
        this.posY = posY;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.objeto=objeto;
    }


    public boolean rangoDerechaArriba(int x, int y, JButton boton1[][]){
        for(int i=1;y-i>=0 && x+i<dimensionX;i++) {
            if(boton1[x+i][y-i]!=null){
                return true;
                //  boton[x+i][y-i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }


    @Override
    public void run(){
        if (rangoDerechaArriba(posX,posY,boton1)){
            boton1[posX][posY].setBackground(new Color(20,50,100));
            for(int i=1;posY-i>=0 && posX+i<dimensionX&& Start.verificando == 0;i++){
                if(objeto[posX+i][posY-i]==1 || objeto[posX+i][posY-i]==2){
                    Start.verificando = 1;
                    boton1[posX+i][posY-i].setBackground(new Color(200,20,20));
                    String mensaje = "Has perdido en la posición: "+" Y: "+(posX+i+1)+", X: "+(posY-i+1);
                    JOptionPane.showMessageDialog(null,mensaje);

                }
                if (objeto[posX+i][posY-i]==1 || objeto[posX+i][posY-i]==2)break;

                if(boton1[posX+i][posY-i]!=null && objeto[posX+i][posY-i]==0 || objeto[posX+i][posY-i]==3 && Start.verificando == 0){
                    boton1[posX+i][posY-i].setBackground(new Color(20,50,100));

                    if (objeto[posX+i][posY-i]==3)
                        boton1[posX+i][posY-i].setBackground(new Color(5, 10, 50));

                    objeto[posX+i][posY-i] = 3;
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        System.out.println("Error en la clase MovNE: "+e);
                    }
                }
            }

        }
    }


}
