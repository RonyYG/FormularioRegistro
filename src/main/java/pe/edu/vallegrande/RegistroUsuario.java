package pe.edu.vallegrande;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroUsuario extends JFrame {

    public RegistroUsuario() {
        // Configuración del JFrame
        setTitle("Registro de Usuario");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Crear el panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));
        add(panel);

        // Crear los componentes
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();

        JLabel telefonoLabel = new JLabel("Teléfono:");
        JTextField telefonoField = new JTextField();

        JLabel tipoDocLabel = new JLabel("Tipo de Documento:");
        String[] tiposDocumento = {"DNI", "Pasaporte", "Carnet E.", "Otro"};
        JComboBox<String> tipoDocComboBox = new JComboBox<>(tiposDocumento);

        JLabel numeroDocLabel = new JLabel("Número de Documento:");
        JTextField numeroDocField = new JTextField();

        JLabel direccionLabel = new JLabel("Dirección (opcional):");
        JTextField direccionField = new JTextField();

        JLabel correoLabel = new JLabel("Correo:");

        JTextField correoField = new JTextField();

        JLabel contraseñaLabel = new JLabel("Contraseña:");
        JPasswordField contraseñaField = new JPasswordField();

        JLabel confirmarContraseñaLabel = new JLabel("Confirmar Contraseña:");
        JPasswordField confirmarContraseñaField = new JPasswordField();

        JCheckBox terminosCheckBox = new JCheckBox("Aceptar términos y condiciones");

        JButton registrarButton = new JButton("Registrar");

        // Agregar componentes al panel
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(telefonoLabel);
        panel.add(telefonoField);
        panel.add(tipoDocLabel);
        panel.add(tipoDocComboBox);
        panel.add(numeroDocLabel);
        panel.add(numeroDocField);
        panel.add(direccionLabel);
        panel.add(direccionField);
        panel.add(correoLabel);
        panel.add(correoField);
        panel.add(contraseñaLabel);
        panel.add(contraseñaField);
        panel.add(confirmarContraseñaLabel);
        panel.add(confirmarContraseñaField);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(terminosCheckBox);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(registrarButton);

        // Acción del botón
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String telefono = telefonoField.getText();
                String tipoDocumento = (String) tipoDocComboBox.getSelectedItem();
                String numeroDocumento = numeroDocField.getText();
                String direccion = direccionField.getText();
                String correo = correoField.getText();
                String contraseña = new String(contraseñaField.getPassword());
                String confirmarContraseña = new String(confirmarContraseñaField.getPassword());
                boolean acepto = terminosCheckBox.isSelected();

                // Validaciones
                if (nombre.isEmpty() || telefono.isEmpty() || numeroDocumento.isEmpty()
                        || correo.isEmpty() || contraseña.isEmpty() || confirmarContraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!contraseña.equals(confirmarContraseña)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!acepto) {
                    JOptionPane.showMessageDialog(null, "Debes aceptar los términos y condiciones.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Registro exitoso:\n" +
                                    "Nombre: " + nombre + "\n" +
                                    "Teléfono: " + telefono + "\n" +
                                    "Tipo de Documento: " + tipoDocumento + "\n" +
                                    "Número de Documento: " + numeroDocumento + "\n" +
                                    "Dirección: " + (direccion.isEmpty() ? "No proporcionada" : direccion) + "\n" +
                                    "Correo: " + correo,
                            "Registro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroUsuario().setVisible(true);
            }
        });
    }
}

