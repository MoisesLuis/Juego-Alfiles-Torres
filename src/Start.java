import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

public class Start extends JFrame implements ActionListener{
    /**
     * Atributos
     */
    protected static JButton boton[][];
    protected static int objeto[][];
    static int verificando=0;
    protected JButton boton1,boton2;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem nuevoJuegoRapido,nuevoJuego,salir,reportes;
    public int x,y;
    private int dimensionX,dimensionY;
    private MovNE prueMover1;
    private MovNO prueMover2;
    private MovSE prueMover3;
    private MovSO prueMover4;
    private MovTorreN movTorreNorth;
    private MovTorreS movTorreSouth;
    private MovTorreE movTorreEast;
    private MovTorreO movTorreWest;
    private JPanel panel;
    private JPanel panelCenter;
    private int botonSeleccionado;

    /**
     * Método constructor
     * En el cuál inicializamos el array de botones
     * e inicializamos los botones
     */

    public Start(int dimensionX,int dimensionY){
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        botonSeleccionado=0;
        x = 0;
        y = 0;

        this.setSize(600,620);
        this.setVisible(true);
        //this.setLayout(null);
        this.setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Opciones");
        menuBar.add(menu);

        nuevoJuegoRapido = new JMenuItem("Juego Rápido");
        nuevoJuegoRapido.addActionListener(this);
        menu.add(nuevoJuegoRapido);

        nuevoJuego = new JMenuItem("Nuevo Juego");
        nuevoJuego.addActionListener(this);
        menu.add(nuevoJuego);

        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        menu.add(salir);

        reportes = new JMenuItem("Reportes");
        reportes.addActionListener(this);
        menu.add(reportes);


        panel = new JPanel();
        panel.setBackground(new Color(10,10,50));
        panelCenter = new JPanel();
        panelCenter.setBackground(new Color(100,100,100));



        ImageIcon alfil = new ImageIcon("alfil.png");
        boton1 = new JButton("Alfil");
        boton1.setOpaque(true);
        boton1.setFocusPainted(false);
        boton1.setFont(new Font("News706 BT",Font.BOLD,20));
        boton1.setForeground(new Color(200,200,200));
        boton1.setBounds(80,5,150,60);
        boton1.setBackground(new Color(0,0,0));
        boton1.setIcon(new ImageIcon(alfil.getImage().getScaledInstance(boton1.getWidth(),boton1.getHeight(),Image.SCALE_SMOOTH)));
        boton1.addActionListener(this);
        panel.add(boton1);

        ImageIcon torre = new ImageIcon("torre.png");
        boton2 = new JButton("Torre");
        boton2.setOpaque(true);
        boton2.setFont(new Font("News706 BT",Font.BOLD,20));
        boton2.setForeground(new Color(200,200,200));
        boton2.setBounds(200,5,150,60);
        boton2.setBackground(new Color(0,0,0));
        boton2.setIcon(new ImageIcon(torre.getImage().getScaledInstance(boton2.getWidth(),boton2.getHeight(),Image.SCALE_SMOOTH)));
        boton2.addActionListener(this);
        panel.add(boton2);

        boton = new JButton[dimensionX][dimensionY];
        objeto = new int[dimensionX][dimensionY];
        inicializarVector();

        this.getContentPane().add(BorderLayout.NORTH, panel);
        this.getContentPane().add(BorderLayout.CENTER, panelCenter);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }


    /**
     * El siguiente método nos sirve para
     * poder inicializar nuestra ventana
     * que contiene el array de botones
     * para poder jugar
     */
    private void inicializarVector(){
        panelCenter.setLayout(new GridLayout(dimensionX,dimensionY));
        for (int i= 0; i<dimensionX; i++){
            for (int j = 0; j<dimensionY; j++){
                boton[i][j] = new JButton();
                boton[i][j].addActionListener(this);
                panelCenter.add(boton[i][j]);
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
        boton[x][y].setIcon(new ImageIcon(alfil.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        objeto[x][y] = 1;
        prueMover1 = new MovNE(x,y,boton,dimensionX,dimensionY,objeto);
        prueMover2 = new MovNO(x,y,boton,dimensionX,dimensionY,objeto);
        prueMover3 = new MovSE(x,y,boton,dimensionX,dimensionY,objeto);
        prueMover4 = new MovSO(x,y,boton,dimensionX,dimensionY,objeto);

        if (verificando == 1){
            prueMover1.stop();
            prueMover2.stop();
            prueMover3.stop();
            prueMover4.stop();
        }

       prueMover1.start();
       try{
           prueMover1.sleep(10);
       }catch (Exception e){
           System.out.println("Error en el hilo prueMover1.."+e);
       }
       prueMover2.start();
        try{
            prueMover2.sleep(10);
        }catch (Exception e){
            System.out.println("Error en el hilo prueMover2.."+e);
        }
        //prueMover2.rangoIzqArriba(x,y,boton);
        prueMover3.start();
        try{
            prueMover3.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en el hilo prueMover3: "+e);
        }
        prueMover4.start();
        try{
            prueMover4.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en el hilo prueMover4: "+e);
        }

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
        ImageIcon torre = new ImageIcon("torre.png");
        boton[x][y].setIcon(new ImageIcon(torre.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        objeto[x][y] = 2;
        movTorreNorth = new MovTorreN(x,y,boton,dimensionX,dimensionY,objeto);
        movTorreSouth = new MovTorreS(x,y,boton,dimensionX,dimensionY,objeto);
        movTorreEast = new MovTorreE(x,y,boton,dimensionX,dimensionY,objeto);
        movTorreWest = new MovTorreO(x,y,boton,dimensionX,dimensionY,objeto);

        if (verificando == 1){
            movTorreNorth.stop();
            movTorreWest.stop();
            movTorreEast.stop();
            movTorreSouth.stop();
        }
        movTorreNorth.start();
        try{
            movTorreNorth.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en el hilo movTorreNorth: "+e);
        }
        movTorreSouth.start();
        try{
            movTorreSouth.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en el hilo movTorreSouth: "+e);
        }
        movTorreEast.start();
        try{
            movTorreEast.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en el hilo movTorreEast: "+e);
        }
        movTorreWest.start();
        try{
            movTorreWest.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en el hilo movTorreWest: "+e);
        }
    }


    /**
     *
     * @param e
     * Parámetro que viene predefinido por el método
     * para poder utilizar los eventos
     */
    public void actionPerformed(ActionEvent e){
        for (int i= 0; i<dimensionX; i++){
            for (int j = 0; j<dimensionY; j++){
                if (e.getSource()==boton[i][j]){
                    x= i;
                    y= j;
                    if (botonSeleccionado == 1 && objeto[x][y]==0){
                        alfil(i,j);
                    }
                    if (botonSeleccionado == 2&& objeto[x][y]==0){
                        Torre(i,j);
                    }
                }
            }
        }
        if (e.getSource() == boton1){
            boton2.setBackground(new Color(0,0,0));
            boton1.setBackground(new Color(100,100,100));
            botonSeleccionado = 1;
            //alfil(x,y);
        }
        if (e.getSource() == boton2){
            boton1.setBackground(new Color(0,0,0));
            boton2.setBackground(new Color(100,100,100));
            botonSeleccionado = 2;
            //Torre(x,y);
        }
        if (e.getSource() == nuevoJuegoRapido){
            limpiarCuadro();
            inicializarVectorDeNuevo();
        }
        if (e.getSource() == nuevoJuego){
            this.setVisible(false);
            VentanaPrincipal ventPrincipal = new VentanaPrincipal();

        }
        if (e.getSource() == salir){
            System.exit(0);
        }
        if (e.getSource() == reportes){
            Reportes report = new Reportes();
            this.setVisible(false);
        }
    }

    public void limpiarCuadro(){
        for (int i= 0; i<dimensionX; i++){
            for (int j = 0; j<dimensionY; j++){
                boton[i][j] = null;
                objeto[i][j]=0;
            }
            panelCenter.removeAll();
        }
        panelCenter.repaint();
    }

    public void inicializarVectorDeNuevo(){
        panelCenter.setLayout(new GridLayout(dimensionX,dimensionY));
        boton = new JButton[dimensionX][dimensionY];
        for (int i= 0; i<dimensionX; i++){
            for (int j = 0; j<dimensionY; j++){
                boton[i][j] = new JButton();
                boton[i][j].addActionListener(this);
                panelCenter.add(boton[i][j]);
                Start.verificando =0;
            }
        }
        this.setVisible(true);
    }

}
