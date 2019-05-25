import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private JPanel panelFondo;
    private JTextField textField1;
    private JButton aceptarButton;
    private JTextField textField2;

    public VentanaPrincipal() {
        this.setSize(600,250);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(panelFondo);

        aceptarButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == aceptarButton){
            try{
                int dimensionX = Integer.parseInt(textField1.getText());
                int dimensionY = Integer.parseInt(textField2.getText());
                Start siguienteVentana = new Start(dimensionX,dimensionY);
                this.setVisible(false);

            }catch (Exception ex){
                System.out.println("Error en el boton : Aceptar "+ex);
            }
        }
    }
}
