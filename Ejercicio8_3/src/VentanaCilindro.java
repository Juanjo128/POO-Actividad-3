import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCilindro extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel radio,altura,volumen,superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro");
        setSize(420,210);
        setLocationRelativeTo(null);
        setResizable(false);
}

private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel();
        radio.setText("Radio (cms):");
        radio.setBounds(20,20,135,23);
        contenedor.add(radio);

        campoRadio = new JTextField();
        campoRadio.setBounds(100,20,135,23);
        contenedor.add(campoRadio);

        altura = new JLabel();
        altura.setText("Altura:");
        altura.setBounds(20,50,135,23);
        contenedor.add(altura);

        campoAltura = new JTextField();
        campoAltura.setBounds(100,50,135,23);
        contenedor.add(campoAltura);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100,80,135,23);
        calcular.addActionListener(this);
        contenedor.add(calcular);

        volumen = new JLabel();
        volumen.setText("Volumen:");
        volumen.setBounds(20,110,135,23);
        contenedor.add(volumen);

        superficie = new JLabel();
        superficie.setText("Superficie:");
        superficie.setBounds(20,140,135,23);

        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/cilindro.png"));
            Image imgEscalada = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(imgEscalada));
            imgLabel.setBounds(250, 20, 120, 120);
            contenedor.add(imgLabel);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen del cilindro: " + e.getMessage());
        }

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double radio = 0, altura = 0;
        try {
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie())) ;

    } catch (Exception e) {
            error = true;
        }
        finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
}
}

