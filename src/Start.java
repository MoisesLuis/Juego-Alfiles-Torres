import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

public class Start extends JFrame implements ActionListener{
    /**
     * Atributos
     */
    protected static JButton boton[][];
    protected JButton boton1,boton2;
    public int x,y;
    private MovNE prueMover1;
    private MovNO prueMover2;
    private MovSE prueMover3 = new MovSE();
    private MovSO prueMover4 = new MovSO();
    private MovTorreN movTorreNorth = new MovTorreN();
    private MovTorreS movTorreSouth = new MovTorreS();
    private MovTorreE movTorreEast = new MovTorreE();
    private MovTorreO movTorreWest = new MovTorreO();

    /**
     * Método constructor
     * En el cuál inicializamos el array de botones
     * e inicializamos los botones
     */
    public Start(){
        x = 0;
        y = 0;
        setLayout(null);
        boton = new JButton[8][8];
        inicializarVector();

        boton1 = new JButton("Alfil");
        boton1.setBounds(80,0,100,40);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("Torre");
        boton2.setBounds(200,0,100,40);
        boton2.addActionListener(this);
        add(boton2);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * El siguiente método nos sirve para
     * poder inicializar nuestra ventana
     * que contiene el array de botones
     * para poder jugar
     */
    private void inicializarVector(){
        for (int i= 0; i<boton.length; i++){
            for (int j = 0; j<boton.length; j++){
                boton[i][j] = new JButton();
                boton[i][j].setBounds(50*i,40+50*j,50,50);
                boton[i][j].addActionListener(this);
                this.getContentPane().add(boton[i][j]);
                //  panel1.add(boton[i][j]);
            }
        }
    }

    /**
     *
     * @param x
     * El parámetro anterior nos sirve para
     * que en la posición "x" en la cuál se seleccionó
     * pueda aparezer la imagen del alfil
     * @param y
     *  El parámetro anterior nos sirve para
     *  que en la posición "y" en la cuál se seleccionó
     *  pueda aparezer la imagen del alfil
     */
    private void alfil(int x, int y){
        ImageIcon alfil = new ImageIcon("alfil.png");
        boton[x][y].setIcon(new ImageIcon(alfil.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        add(boton[x][y]);
        prueMover1 = new MovNE(x,y,boton);
        prueMover2 = new MovNO(x,y,boton);
       prueMover1.start();
       try{
           prueMover1.sleep(100);
       }catch (Exception e){
           System.out.println("Error en el hilo prueMover1.."+e);
       }
       prueMover2.start();
        try{
            prueMover2.sleep(1000);
        }catch (Exception e){
            System.out.println("Error en el hilo prueMover2.."+e);
        }
        //prueMover2.rangoIzqArriba(x,y,boton);
        prueMover3.pintarCaminoAlfil(x,y,boton);
        prueMover4.pintarCaminoAlfil(x,y,boton);

    }

    /**
     * @param x
     * El parámetro anterior nos sirve para
     * que en la posición "x" en la cuál se seleccionó
     * pueda aparezer la imagen de la torre
     * @param y
     *  El parámetro anterior nos sirve para
     *  que en la posición "y" en la cuál se seleccionó
     *  pueda aparezer la imagen de la torre
     */
    private void Torre(int x, int y){
        ImageIcon alfil = new ImageIcon("torre.png");
        boton[x][y].setIcon(new ImageIcon(alfil.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        add(boton[x][y]);
        movTorreNorth.pintarCaminoTorre(x,y,boton);
        movTorreSouth.pintarCaminoTorre(x,y,boton);
        movTorreEast.pintarCaminoTorre(x,y,boton);
        movTorreWest.pintarCaminoTorre(x,y,boton);
    }


    /**
     *
     * @param e
     * Parámetro que viene predefinido por el método
     * para poder utilizar los eventos
     */
    public void actionPerformed(ActionEvent e){
        for (int i= 0; i<boton.length; i++){
            for (int j = 0; j<boton.length; j++){
                if (e.getSource()==boton[i][j]){
                    x= i;
                    y= j;
                }
            }
        }
        if (e.getSource() == boton1){
            alfil(x,y);
        }
        if (e.getSource() == boton2){
            Torre(x,y);
        }


    }
}
