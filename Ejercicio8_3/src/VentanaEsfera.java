import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaEsfera extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;
    
    public VentanaEsfera() {
        inicio();
        setTitle("Esfera");
        setSize(420, 210);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);

        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 90, 200, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 120, 200, 23);

                try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/esfera.png"));
            Image imgEscalada = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(imgEscalada));
            imgLabel.setBounds(250, 20, 120, 120);
            contenedor.add(imgLabel);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen de la esfera: " + e.getMessage());
        }

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            // 1. Validar que el campo no esté vacío
            if (campoRadio.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this, 
                    "Error: El campo de radio es obligatorio. Por favor ingrese un valor.", 
                    "Campo incompleto", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // 2. Parsear el valor e invocar los métodos del modelo
            try {
                double radioVal = Double.parseDouble(campoRadio.getText().trim());

                Esfera esfera = new Esfera(radioVal);

                volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));

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