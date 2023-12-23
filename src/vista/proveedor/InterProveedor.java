package vista.proveedor;

import conexion.Conexion;
import controlador.Ctrl_Proveedor;
import java.awt.Dimension;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Proveedor;
import static vista.FrmMenu.jDesktopPane_menu;

public class InterProveedor extends javax.swing.JInternalFrame {

    //CREO UN OBJETO DEFAULTABLEMODEL PARA DARLE UN MODELO A LA TABLA
    private final DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) { //SOBREESCRIBO EL METODO PARA QUE NO SE PUEDA EDITAR
            return false;
        }
    };

    public InterProveedor() {
        initComponents();
        this.setSize(new Dimension(800, 700));
        this.setTitle("Proveedor");

        // Defino modelo de tabla y creo columnas
        InterProveedor.jTable_proveedor = new JTable(model);
        InterProveedor.jScrollPane.setViewportView(InterProveedor.jTable_proveedor);
        model.addColumn("ID");
        model.addColumn("Descripción");
        model.addColumn("Dirección/Telefono");
        model.addColumn("Estado");

        // Deshabilitar el seleccionado multiple
        ListSelectionModel selectionModel = jTable_proveedor.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Deshabilitar el reordenamiento de columnas
        jTable_proveedor.getTableHeader().setReorderingAllowed(false);

        // Crear y aplicar el renderizador personalizado para centrar el contenido de las celdas
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        // Aplicar el renderizador personalizado a las columnas específicas que deseas centrar
        jTable_proveedor.getColumnModel().getColumn(0).setCellRenderer(centrar); // ID
        jTable_proveedor.getColumnModel().getColumn(1).setCellRenderer(centrar); // Descripcion
        jTable_proveedor.getColumnModel().getColumn(2).setCellRenderer(centrar); // Direccion
        jTable_proveedor.getColumnModel().getColumn(3).setCellRenderer(centrar); // Estado
        centrar.setHorizontalAlignment(JLabel.CENTER);

        ((DefaultTableCellRenderer) jTable_proveedor.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //Centrar encabezado

        TableColumnModel columnModel = jTable_proveedor.getColumnModel();//Determino el ancho de cada columna
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(350);
        columnModel.getColumn(2).setPreferredWidth(250);
        columnModel.getColumn(3).setPreferredWidth(200);

        this.CargarTablaProveedor("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_Buscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable_proveedor = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        Wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_BuscarKeyReleased(evt);
            }
        });
        getContentPane().add(jTextField_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 110, 387, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-basura-501.png"))); // NOI18N
        jButton1.setText("Desactivar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 457, 195, 45));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-más-50.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 179, 195, 45));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-50.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 312, 195, 45));

        jTable_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(jTable_proveedor);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 170, 420, 460));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Ver Desactivados");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 640, -1, -1));

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_proveedor.jpg"))); // NOI18N
        getContentPane().add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 800, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_BuscarKeyReleased
        this.borrarFilas();
        this.CargarTablaProveedor(jTextField_Buscar.getText());
    }//GEN-LAST:event_jTextField_BuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int selectedRow = jTable_proveedor.getSelectedRow();

        if (selectedRow != -1) {
            if (!jTable_proveedor.getValueAt(selectedRow, 3).equals("Desactivado")) {

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que querés eliminar '" + jTable_proveedor.getValueAt(selectedRow, 1) + "' ?",
                        "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                if (respuesta == 0) {
                    Proveedor proveedor = new Proveedor();
                    Ctrl_Proveedor ctrlProveedor = new Ctrl_Proveedor();

                    proveedor.setIdProveedor((int) jTable_proveedor.getValueAt(selectedRow, 0));
                    proveedor.setDescripcion(jTable_proveedor.getValueAt(selectedRow, 1) + "");
                    proveedor.setDireccion(jTable_proveedor.getValueAt(selectedRow, 2) + "");
                    proveedor.setEstado(0);

                    if (ctrlProveedor.actualizarProveedor(proveedor) == true) {
                        JOptionPane.showMessageDialog(null, "Proveedor eliminado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar un Proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "El Proveedor ya se encuentra eliminado.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.borrarFilas();
        this.CargarTablaProveedor(jTextField_Buscar.getText());


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Frame f = JOptionPane.getFrameForComponent(this);
        DialogAgregar ventana = new DialogAgregar(f, true);
        //Centro el popup
        int x = (this.getWidth() - ventana.getWidth()) / 2 + this.getX();
        int y = (this.getHeight() - ventana.getHeight()) / 2 + this.getY();
        ventana.setLocation(x, y);
        ventana.setVisible(true);
        this.setVisible(true);

        this.borrarFilas();
        this.CargarTablaProveedor(jTextField_Buscar.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = jTable_proveedor.getSelectedRow();

        if (selectedRow != -1) {

            Proveedor proveedor = new Proveedor();

            proveedor.setIdProveedor((int) jTable_proveedor.getValueAt(selectedRow, 0));
            proveedor.setDescripcion(jTable_proveedor.getValueAt(selectedRow, 1) + "");
            proveedor.setDireccion(jTable_proveedor.getValueAt(selectedRow, 2) + "");
            proveedor.setEstado(jTable_proveedor.getValueAt(selectedRow, 3).equals("Activado") ? 1 : 0);

            Frame f = JOptionPane.getFrameForComponent(this);
            DialogModificar ventana = new DialogModificar(f, true, proveedor);

            //Centro el popup
            int x = (this.getWidth() - ventana.getWidth()) / 2 + this.getX();
            int y = (this.getHeight() - ventana.getHeight()) / 2 + this.getY();
            ventana.setLocation(x, y);

            ventana.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.borrarFilas();
        this.CargarTablaProveedor(jTextField_Buscar.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        this.borrarFilas();
        this.CargarTablaProveedor(jTextField_Buscar.getText());
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JRadioButton jRadioButton1;
    public static javax.swing.JScrollPane jScrollPane;
    public static javax.swing.JTable jTable_proveedor;
    private javax.swing.JTextField jTextField_Buscar;
    // End of variables declaration//GEN-END:variables

    private void CargarTablaProveedor(String busquedad) {

        Connection cn = Conexion.conectar();
        String sql = "";

        if ((busquedad.equals("") || busquedad.isEmpty()) && jRadioButton1.isSelected() == false) {
            sql = "SELECT * FROM tb_proveedor WHERE estado = 1";
        } else if ((busquedad.equals("") || busquedad.isEmpty()) && jRadioButton1.isSelected() == true) {
            sql = "SELECT * FROM tb_proveedor";
        } else {
            if (jRadioButton1.isSelected() == false) {
                sql = "SELECT * FROM tb_proveedor WHERE (idProveedor LIKE '%" + busquedad + "%' OR descripcion LIKE '%" + busquedad + "%' OR direccion LIKE '%" + busquedad + "%') AND estado = 1";
            } else if(jRadioButton1.isSelected() == true){
                sql = "SELECT * FROM tb_proveedor WHERE idProveedor LIKE '%" + busquedad + "%' OR descripcion LIKE '%" + busquedad + "%' OR direccion LIKE '%" + busquedad + "%'";
            }
        }

        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object fila[] = new Object[4];

                for (int i = 0; i < 4; i++) {

                    if (i == 3 && rs.getObject(i + 1).equals(0)) {
                        fila[i] = "Desactivado";
                    } else if (i == 3 && rs.getObject(i + 1).equals(1)) {
                        fila[i] = "Activado";
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }

                model.addRow(fila);
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla Proveedor: " + e);
        }
    }

    private void borrarFilas() {

        int filas = jTable_proveedor.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            model.removeRow(f);

        }
    }

}
