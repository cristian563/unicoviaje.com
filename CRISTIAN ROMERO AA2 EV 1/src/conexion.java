import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String usuario = "root";
    private static String password = "123456789";
    private static String url = "jdbc:mysql://localhost:3306/software";

    static {
        try {
            Class.forName(driver);
            JOptionPane.showMessageDialog(null, "Conexión con MySQL exitosa", "Driver", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el driver", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    Connection con = null;

    public Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, usuario, password);
            JOptionPane.showMessageDialog(null, "Conectado a MySQL", "Conexión", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

    public void close() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                JOptionPane.showMessageDialog(null, "Se cerró la conexión exitosamente", "Conexión", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        conexion db = new conexion();
        db.getConnection();
        // db.close();
    }
}
