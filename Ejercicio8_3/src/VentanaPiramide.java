import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPiramide() {
        inicio();
        setTitle("Pirámide");
        setSize(420, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 120, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 120, 23);

        apotema = new JLabel("Apotema (cms):");
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 110, 120, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 145, 220, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 175, 220, 23);

                try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/piramide.png"));
            Image imgEscalada = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(imgEscalada));
            imgLabel.setBounds(250, 20, 120, 120);
            contenedor.add(imgLabel);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen de la pirámide: " + e.getMessage());
        }
        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calcular) {

            if (campoBase.getText().trim().isEmpty() || 
                campoAltura.getText().trim().isEmpty() || 
                campoApotema.getText().trim().isEmpty()) {
                
                JOptionPane.showMessageDialog(
                    this, 
                    "Error: Todos los campos son obligatorios. Por favor ingrese base, altura y apotema.", 
                    "Campo incompleto", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                double baseVal = Double.parseDouble(campoBase.getText().trim());
                double alturaVal = Double.parseDouble(campoAltura.getText().trim());
                double apotemaVal = Double.parseDouble(campoApotema.getText().trim());

                Piramide piramide = new Piramide(baseVal, alturaVal, apotemaVal);

                volumen.setText("Volumen (cm3): " + String.format("%.2f", piramide.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", piramide.calcularSuperficie()));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    this, 
                    "Error: Ha ingresado caracteres no numéricos. Por favor ingrese solo números válidos.", 
                    "Entrada no numérica", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}

