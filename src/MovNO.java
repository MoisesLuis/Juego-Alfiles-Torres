import javax.swing.*;
import java.awt.*;


public class MovNO extends Thread{


    int posX,posY,dimensionX,dimensionY;
    JButton boton1[][];
    int objeto[][];
    public MovNO(int posX,int posY, JButton boton1[][],int dimensionX,int dimensionY,int objeto[][]){
        this.posX = posX;
        this.posY = posY;
        this.boton1 = boton1;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.objeto=objeto;
    }

    public boolean rangoIzqArriba(int x, int y, JButton boton1[][]){
        for(int i=1;y-i>=0 && x-i>=0;i++) {
            if(boton1[x-i][y-i]!=null){
                return true;
                //boton[x-i][y-i].setBackground(Color.cyan);
            }else break;
        }
        return false;
    }

    public void run(){
        if (rangoIzqArriba(posX, posY,boton1)) {
            for (int i = 1; posY - i >= 0 && posX - i >= 0&& Start.verificando == 0; i++) {
                if(objeto[posX-i][posY-i]!=0){
                    Start.verificando = 1;
                    String mensaje = "Has perdido en la posición"+(posX-i)+", "+(posY-i);
                    JOptionPane.showMessageDialog(null,mensaje);

                }
                if (objeto[posX-i][posY-i]!=0)break;
                if (boton1[posX - i][posY - i] != null && objeto[posX-i][posY-i]==0&& Start.verificando == 0) {
                    boton1[posX - i][posY - i].setBackground(new Color(255, 255, 2));
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println("Error en la clase MovNO: "+e);
                    }
                }
            }
        }
    }
}
