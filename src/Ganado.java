import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ganado extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton nuevoJuegoButton;
    private JLabel ganaste;
    private JLabel felicidades;
    private JLabel s;

    public Ganado(){
        this.setSize(600,400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        nuevoJuegoButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == nuevoJuegoButton){
            VentanaPrincipal vent = new VentanaPrincipal();
            this.setVisible(false);
        }
    }
}
