import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reportes extends JFrame implements ActionListener {
    private JPanel panel;
    private JTable table1;
    private JTextField textField1;
    private JButton agregarButton;
    private JTextField textField2;
    private JButton aceptarButton;
    private int contador;
    private Start ventSecond;

    DefaultTableModel modelo;


    public Reportes(int contador,Start ventSecond){
        this.ventSecond = ventSecond;
        this.contador = contador;
        System.out.println(contador);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);

        agregarButton.addActionListener(this);
        aceptarButton.addActionListener(this);
        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Perdido");
        modelo.addColumn("Punteo");
        //Object name[] = {"Nombre","Edad","Perdido","Punteo"};
        table1.setModel(modelo);
        //table1.setBackground(new Color(200,200,200));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == agregarButton){
            String nombre = textField1.getText();
            int edad = Integer.parseInt(textField2.getText());

            Object datos[]={nombre,edad,"si",contador};
            modelo.addRow(datos);
            table1.setModel(modelo);
            agregarButton.setEnabled(false);
        }
        if (e.getSource() == aceptarButton){
            this.setVisible(false);
            ventSecond.setVisible(true);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
