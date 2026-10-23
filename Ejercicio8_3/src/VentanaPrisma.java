import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrisma extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel base, altura, profundidad, volumen, superficie;
    private JTextField campoBase, campoAltura, campoProfundidad;
    private JButton calcular;

    public VentanaPrisma() {
        inicio();
        setTitle("Prisma Rectangular");
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

        profundidad = new JLabel("Profundidad (cms):");
        profundidad.setBounds(20, 80, 135, 23);
        campoProfundidad = new JTextField();
        campoProfundidad.setBounds(120, 80, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 110, 120, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 145, 220, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 175, 220, 23);
                try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/prisma.png"));
            Image imgEscalada = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(imgEscalada));
            imgLabel.setBounds(250, 20, 120, 120);
            contenedor.add(imgLabel);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen del prisma: " + e.getMessage());
        }

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(profundidad);
        contenedor.add(campoProfundidad);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            
            if (campoBase.getText().trim().isEmpty() || 
                campoAltura.getText().trim().isEmpty() || 
                campoProfundidad.getText().trim().isEmpty()) {
                
                JOptionPane.showMessageDialog(
                    this, 
                    "Error: Todos los campos son obligatorios. Por favor ingrese base, altura y profundidad.", 
                    "Campo incompleto", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                double baseVal = Double.parseDouble(campoBase.getText().trim());
                double alturaVal = Double.parseDouble(campoAltura.getText().trim());
                double profVal = Double.parseDouble(campoProfundidad.getText().trim());

                Prisma prisma = new Prisma(baseVal, alturaVal, profVal);

                volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.calcularSuperficie()));

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