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
    DefaultTableModel modelo;
    Object cabecera[]= {"Nombre","Perdio?","Pedido"};
    Object datos[][]={{"Jose","Peres","si"},{"Jose","Peres","si"},{"Jose","Peres","si"},{"Jose","Peres","si"}};

    public Reportes(){
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setContentPane(panel);
        panel.setLayout(null);

        modelo = new DefaultTableModel(datos,cabecera);
        table1.setModel(modelo);
        //table1.setBackground(new Color(200,200,200));
        //panel.add(table1);


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String args[]){
        Reportes rep=new Reportes();
        rep.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == agregarButton){
            String nombre = textField1.getText();
            int edad = Integer.parseInt(textField2.getText());
            datos = new Object[2][2];
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
