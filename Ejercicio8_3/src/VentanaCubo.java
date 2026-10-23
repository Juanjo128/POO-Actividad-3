import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaCubo extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel lado, volumen, superficie;
    private JTextField campoLado;
    private JButton calcular;

    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(420, 210);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel("Lado (cms):");
        lado.setBounds(20, 20, 135, 23);

        campoLado = new JTextField();
        campoLado.setBounds(100, 20, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 90, 200, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 120, 200, 23);

                try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
            Image imgEscalada = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(imgEscalada));
            imgLabel.setBounds(250, 20, 120, 120);
            contenedor.add(imgLabel);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen del cubo: " + e.getMessage());
        }

        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {

            if (campoLado.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this, 
                    "Error: El campo del lado es obligatorio. Por favor ingrese un valor.", 
                    "Campo incompleto", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            try {
                double ladoVal = Double.parseDouble(campoLado.getText().trim());

                Cubo cubo = new Cubo(ladoVal);

                volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    this, 
                    "Error: Ha ingresado caracteres no numéricos. Por favor ingrese un número válido.", 
                    "Entrada no numérica", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
