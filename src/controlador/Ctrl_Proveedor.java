package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Proveedor;

public class Ctrl_Proveedor {

    public boolean guardarProveedor(Proveedor proveedor) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO tb_proveedor values(?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, proveedor.getDescripcion());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getEstado());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Proveedor: " + e);
        }

        return respuesta;
    }

    public boolean actualizarProveedor(Proveedor proveedor) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE tb_proveedor SET descripcion = ?, direccion = ?, estado = ? WHERE idProveedor = " + proveedor.getIdProveedor());
            ps.setString(1, proveedor.getDescripcion());
            ps.setString(2, proveedor.getDireccion());
            ps.setInt(3, proveedor.getEstado());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar Proveedor: " + e);
        }

        return respuesta;
    }

    public boolean existeProveedor(String proveedor) {

        boolean respuesta = false;
        String sql = "SELECT descripcion FROM tb_proveedor WHERE descripcion = '" + proveedor + "'";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar Proveedor: " + e);
        }

        return respuesta;
    }

}
