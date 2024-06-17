import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import javax.swing.SwingConstants;





public class App extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField_1;
    private JTextField textField_2;
    private conexion bdd = new conexion();
    private Connection con = bdd.getConnection();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public App() {
    	
        setTitle("UNICOVIAJE.COM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(617, 407); 
        JPanel panel = new JPanel();
        panel.setBackground(new Color(147, 193, 236));
        getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("CONEXION A BASE DE DATOS MYSQL");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 0, 255));
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        JLabel lblNewLabel_1 = new JLabel("id");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
        JLabel lblNewLabel_2 = new JLabel("nombre");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
        JButton btnNewButton = new JButton("insertar");
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
        btnNewButton.setBackground(new Color(0, 204, 0));
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Arial", Font.PLAIN, 20));
        btnEliminar.setBackground(new Color(255, 0, 102));
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 20));
        btnActualizar.setBackground(new Color(0, 102, 255));
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String id = textField_1.getText();
                String nombre = textField_2.getText();
                PreparedStatement ps;
                String insertar = "INSERT INTO software.curso (id, nombre) VALUES (?,?)";
                
                try {
                    ps = con.prepareStatement(insertar);
                    ps.setString(1, id);
                    ps.setString(2, nombre);
                    int registro = ps.executeUpdate();
                    if (registro > 0) {
                        JOptionPane.showMessageDialog(null, "Registro Guardado", "Bien", JOptionPane.INFORMATION_MESSAGE);
                        textField_1.setText("");
                        textField_2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar registro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField_1.getText();
                PreparedStatement ps;
                String eliminar = "DELETE FROM software.curso WHERE id = ?";
                try {
                    ps = con.prepareStatement(eliminar);
                    ps.setString(1, id);
                    int registro = ps.executeUpdate();
                    if (registro > 0) {
                        JOptionPane.showMessageDialog(null, "Registro Eliminado", "Bien", JOptionPane.INFORMATION_MESSAGE);
                        textField_1.setText("");
                        textField_2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el registro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al eliminar registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField_1.getText();
                String nombre = textField_2.getText();
                PreparedStatement ps;
                String actualizar = "UPDATE software.curso SET nombre = ? WHERE id = ?";
                try {
                    ps = con.prepareStatement(actualizar);
                    ps.setString(1, nombre);
                    ps.setString(2, id);
                    int registro = ps.executeUpdate();
                    if (registro > 0) {
                        JOptionPane.showMessageDialog(null, "Registro Actualizado", "Bien", JOptionPane.INFORMATION_MESSAGE);
                        textField_1.setText("");
                        textField_2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el registro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al actualizar registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        GroupLayout layout = new GroupLayout(panel);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(68, Short.MAX_VALUE)
        			.addComponent(lblNewLabel)
        			.addGap(120))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(23)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(btnEliminar)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnActualizar))
        				.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        				.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        			.addContainerGap(124, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblNewLabel)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_2)
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(9)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnNewButton)
        				.addComponent(btnActualizar)
        				.addComponent(btnEliminar))
        			.addContainerGap(11, Short.MAX_VALUE))
        );
        panel.setLayout(layout);

        pack();
    }
}
