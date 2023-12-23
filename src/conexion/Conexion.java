package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost/bd_sistema_ventas";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admin";

    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion local: " + e);
        }
        return null;
    }

}
