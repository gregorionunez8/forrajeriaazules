package vista.proveedor;

import controlador.Ctrl_Proveedor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Proveedor;

public class DialogAgregar extends javax.swing.JDialog {

    //asdasd
    public DialogAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(new Dimension(506, 329));
        this.setTitle("Nuevo Proveedor");
        
        
        setIconImage(new ImageIcon(getClass().getResource("../../img/ventas.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_nombre = new javax.swing.JTextField();
        txt_nombre1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombreKeyPressed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 137, 340, 30));

        txt_nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombre1KeyPressed(evt);
            }
        });
        getContentPane().add(txt_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 80, 340, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-salir-50.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 220, 171, 51));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-guardar-50.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 171, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_nuevo_proveedor.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (!txt_nombre.getText().isEmpty() && !txt_nombre1.getText().isEmpty()) {

            Proveedor proveedor = new Proveedor();
            Ctrl_Proveedor ctrlProveedor = new Ctrl_Proveedor();

            if (ctrlProveedor.existeProveedor(txt_nombre1.getText().trim()) == true) {
                JOptionPane.showMessageDialog(null, "Ya existe un Proveedor con ese nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                proveedor.setIdProveedor(0);
                proveedor.setDescripcion(txt_nombre1.getText().trim());
                proveedor.setDireccion(txt_nombre.getText().trim());
                proveedor.setEstado(1);
                
                if(ctrlProveedor.guardarProveedor(proveedor) == true){
                    JOptionPane.showMessageDialog(null, "Proveedor agregado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el Proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                txt_nombre.setText("");
                txt_nombre1.setText("");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Complete los datos del Proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyPressed
          if (evt.getKeyCode() == evt.VK_ENTER) {
            jButton2.doClick();
        }
    }//GEN-LAST:event_txt_nombreKeyPressed

    private void txt_nombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombre1KeyPressed
          if (evt.getKeyCode() == evt.VK_ENTER) {
            txt_nombre.requestFocus();
        }
    }//GEN-LAST:event_txt_nombre1KeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAgregar dialog = new DialogAgregar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre1;
    // End of variables declaration//GEN-END:variables
}
