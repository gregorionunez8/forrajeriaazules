package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class Ctrl_Usuario {

    //Metodo para Iniciar Sesión
    public boolean loginUser(Usuario usuario) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "SELECT usuario,password FROM tb_usuario WHERE usuario = '" + usuario.getUsuario() + "' and password = '" + usuario.getPassword() + "'";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }
            
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }

}
