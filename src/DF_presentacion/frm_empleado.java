/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DF_presentacion;

import javax.swing.JOptionPane;

/**
 *
 * @author Alian Peralta
 */
public class frm_empleado extends javax.swing.JFrame {

    /**
     * Creates new form frm_empleado
     */
    public frm_empleado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_empleado = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        lbl_ape = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        lbl_tel = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        lbl_cedu = new javax.swing.JLabel();
        lbl_dire1 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_correo = new javax.swing.JLabel();
        txt_core = new javax.swing.JTextField();
        cmb_sex = new javax.swing.JComboBox<>();
        Sexo = new javax.swing.JLabel();
        txt_salario = new javax.swing.JTextField();
        lbl_salario = new javax.swing.JLabel();
        btn_regiemp = new javax.swing.JButton();
        lbl_titu = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de empleado");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_empleado.setBackground(new java.awt.Color(255, 255, 255));
        panel_empleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_empleado.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 123, -1));

        lbl_nombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(81, 124, 164));
        lbl_nombre.setText("Nombre:");
        panel_empleado.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lbl_ape.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_ape.setForeground(new java.awt.Color(81, 124, 164));
        lbl_ape.setText("Apellido:");
        panel_empleado.add(lbl_ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));
        panel_empleado.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 130, -1));
        panel_empleado.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 114, -1));

        lbl_tel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_tel.setForeground(new java.awt.Color(81, 124, 164));
        lbl_tel.setText("Telefono:");
        panel_empleado.add(lbl_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));
        panel_empleado.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 130, -1));

        lbl_cedu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_cedu.setForeground(new java.awt.Color(81, 124, 164));
        lbl_cedu.setText("Cedula:");
        panel_empleado.add(lbl_cedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        lbl_dire1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_dire1.setForeground(new java.awt.Color(81, 124, 164));
        lbl_dire1.setText("Direccion:");
        panel_empleado.add(lbl_dire1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));
        panel_empleado.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 123, -1));

        lbl_correo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_correo.setForeground(new java.awt.Color(81, 124, 164));
        lbl_correo.setText("Correo:");
        panel_empleado.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));
        panel_empleado.add(txt_core, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 140, -1));

        cmb_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));
        panel_empleado.add(cmb_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 160, -1));

        Sexo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Sexo.setForeground(new java.awt.Color(81, 124, 164));
        Sexo.setText("Sexo:");
        panel_empleado.add(Sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));
        panel_empleado.add(txt_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 123, -1));

        lbl_salario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_salario.setForeground(new java.awt.Color(81, 124, 164));
        lbl_salario.setText("Salario:");
        panel_empleado.add(lbl_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        btn_regiemp.setBackground(new java.awt.Color(255, 255, 255));
        btn_regiemp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_regiemp.setForeground(new java.awt.Color(94, 141, 147));
        btn_regiemp.setText("Registrar");
        btn_regiemp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        btn_regiemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regiempActionPerformed(evt);
            }
        });
        panel_empleado.add(btn_regiemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 122, 44));

        lbl_titu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_titu.setForeground(new java.awt.Color(94, 141, 147));
        lbl_titu.setText("Registro de empleado:");
        panel_empleado.add(lbl_titu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DF_presentacion/lo.png"))); // NOI18N
        panel_empleado.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DF_presentacion/icons8-salida-32.png"))); // NOI18N
        btn_salir.setToolTipText("Salir al menu principal");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        panel_empleado.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 70, 60));

        getContentPane().add(panel_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regiempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regiempActionPerformed
        // Este es el boton que permite registrar un empleado 

        JOptionPane.showMessageDialog(null,"Registraste un empleado correctamente"); // por el momento aparece este mensaje al momento de hacer click en el boton
    }//GEN-LAST:event_btn_regiempActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // Este es el boton que permite salir al menu principal o el main
        frm_main mf = new frm_main(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Sexo;
    private javax.swing.JButton btn_regiemp;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cmb_sex;
    private javax.swing.JLabel lbl_ape;
    private javax.swing.JLabel lbl_cedu;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_dire1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_salario;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JLabel lbl_titu;
    private javax.swing.JPanel panel_empleado;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_core;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_salario;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
