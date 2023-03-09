/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DF_presentacion;

import static DF_presentacion.MyConnetion.getConnection;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jim3j
 */
public class frm_admin extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    // procedemos a crear una tabla mediante el defaulttablemodel
    /**
     * Creates new form frm_admin
     */
    public frm_admin() {
        initComponents();
        tabla(""); // esto llama al metodo tabla que es el que muestra la tabla

    }
    // creamos estemedo metodo llamado tabla para crear rellenar la tabla con el defaultablemodel

    public void tabla(String tabla) {
       String sql = " " +  tabla;
        Statement st;
        MyConnetion con = new MyConnetion();
        Connection conexion = con.getConnection();
        DefaultTableModel model = new DefaultTableModel();
     model.addColumn("ID"); 
        model.addColumn("Nombre");
        model.addColumn("Cedula");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        model.addColumn("Preparacion Academica");
        model.addColumn("Contraseña");
        
        tabla_admin.setModel(model);
        String [] dato = new String[7];
        if(tabla.equals("")){
            sql = "Select * from `admin`";
        }
        else {
            sql = "select * from `admin` where `nombre` = '"+ txt_nombre.getText()+"'" + " or cedula = '" + txt_cedula.getText()+ "'" + " or direccion = '" + txt_direccion.getText()+ "'" +  "or preparacion_academica = '" + txt_prepa.getText() + "'" + "or telefono = '" + txt_telefono.getText() +"'";
            
        }
        try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {  
                  
                dato[0] =rs.getString(1);
                dato[1] =rs.getString(2);
                dato[2] =rs.getString(3);
                dato[3] =rs.getString(4);
                dato[4] =rs.getString(5);
                dato[5] =rs.getString(6);
                dato[6] =rs.getString(7);
                model.addRow(dato);
                
                 txt_nombre.setText(rs.getString("nombre"));
            txt_cedula.setText(rs.getString("cedula"));
            txt_direccion.setText(rs.getString("direccion"));
            txt_telefono.setText(rs.getString("telefono"));
            txt_prepa.setText(rs.getString("preparacion_academica"));
           txt_contra.setText(rs.getString("contraseña"));
           
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public boolean RevisarAdmin(String admin) { // este metodo es para asegurar que el admin este en la base de datos
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `admin` WHERE `nombre` =?";
        try {
            ps = MyConnetion.getConnection().prepareStatement(query);
            ps.setString(1, admin);

            rs = ps.executeQuery();

            if (rs.next()) {
                checkUser = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        return checkUser;
    }

    public void Limpiar() { // este metodo es para limpiar todos los textfield
        try {
            txt_nombre.setText("");
            txt_direccion.setText("");
            txt_contra.setText("");
            txt_prepa.setText("");
            txt_telefono.setText("");
            txt_cedula.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

    public void ActualizarAdmin(String id) { // este metodo es para actualizar los administradores resgistrados mediante una tabla directacmente
Connection con;

    try {
        PreparedStatement ps;
        con = getConnection();
        ps = con.prepareStatement("UPDATE `admin` SET nombre=?, cedula=?, direccion=?, telefono=?, preparacion_academica=?, contraseña=? WHERE id_admin=?");
        ps.setString(1, txt_nombre.getText());
         ps.setString(2, txt_cedula.getText());
            ps.setString(3, txt_direccion.getText());
             ps.setString(4, txt_telefono.getText());
         ps.setString(5, txt_prepa.getText());
          ps.setString(6, String.valueOf(txt_contra.getPassword()));
        ps.setString(7, id);

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Persona Modificada");
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar persona");
        }
        tabla("");
        con.close();

    } catch (SQLException e) {
        System.err.println(e);
    }
    }
    public void EliminaRegistro(String id) {
        String sql = "delete from admin where id_admin = " + id;
        Statement st;
        Connection conexion = getConnection();
        try {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_admin = new javax.swing.JPanel();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_cedu = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        lbl_dire = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_tel = new javax.swing.JLabel();
        lbl_prepa = new javax.swing.JLabel();
        txt_prepa = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        lbl_title = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        btn_registrapaci = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        txt_contra = new javax.swing.JPasswordField();
        btn_eliminar = new javax.swing.JButton();
        btn_vaciar = new javax.swing.JButton();
        lbl_contra = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        scrpanel_tabla = new javax.swing.JScrollPane();
        tabla_admin = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Administrador");

        panel_admin.setBackground(new java.awt.Color(255, 255, 255));
        panel_admin.setToolTipText("");
        panel_admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(81, 124, 164));
        lbl_nombre.setText("Nombre:");
        panel_admin.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_admin.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 120, 20));

        lbl_cedu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_cedu.setForeground(new java.awt.Color(81, 124, 164));
        lbl_cedu.setText("Cedula:");
        panel_admin.add(lbl_cedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        txt_cedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_admin.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 150, 20));

        lbl_dire.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_dire.setForeground(new java.awt.Color(81, 124, 164));
        lbl_dire.setText("Direccion:");
        panel_admin.add(lbl_dire, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txt_direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_admin.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 20));

        lbl_tel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_tel.setForeground(new java.awt.Color(81, 124, 164));
        lbl_tel.setText("Telefono:");
        panel_admin.add(lbl_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        lbl_prepa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_prepa.setForeground(new java.awt.Color(81, 124, 164));
        lbl_prepa.setText("Preparacion Aca:");
        panel_admin.add(lbl_prepa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        txt_prepa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_admin.add(txt_prepa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 147, 20));

        txt_telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_admin.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 147, 20));

        lbl_title.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(94, 141, 147));
        lbl_title.setText("Registro de Admin");
        panel_admin.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lo.png"))); // NOI18N
        panel_admin.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salida-32.png"))); // NOI18N
        btn_salir.setToolTipText("Salir al menu principal");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        panel_admin.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));

        btn_registrapaci.setBackground(new java.awt.Color(255, 255, 255));
        btn_registrapaci.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_registrapaci.setForeground(new java.awt.Color(94, 141, 147));
        btn_registrapaci.setText("Registrar");
        btn_registrapaci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147), 2));
        btn_registrapaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrapaciActionPerformed(evt);
            }
        });
        panel_admin.add(btn_registrapaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 100, 40));

        btn_actualizar.setBackground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(94, 141, 147));
        btn_actualizar.setText("Actualizar");
        btn_actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147), 2));
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        panel_admin.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 100, 40));

        txt_contra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_admin.add(txt_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 159, 20));

        btn_eliminar.setBackground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(94, 141, 147));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147), 2));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        panel_admin.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 100, 40));

        btn_vaciar.setBackground(new java.awt.Color(255, 255, 255));
        btn_vaciar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_vaciar.setForeground(new java.awt.Color(94, 141, 147));
        btn_vaciar.setText("Vaciar");
        btn_vaciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147), 2));
        btn_vaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaciarActionPerformed(evt);
            }
        });
        panel_admin.add(btn_vaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, 40));

        lbl_contra.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_contra.setForeground(new java.awt.Color(81, 124, 164));
        lbl_contra.setText("Contraseña:");
        panel_admin.add(lbl_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(94, 141, 147));
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147), 2));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panel_admin.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 100, 40));

        tabla_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cedula", "Direccion", "Telefono", "Preparacion Academica", "Contraseña"
            }
        ));
        tabla_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_adminMouseClicked(evt);
            }
        });
        scrpanel_tabla.setViewportView(tabla_admin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(scrpanel_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(scrpanel_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // Este es el boton que permite salir al menu principal o el main
        frm_main mf = new frm_main(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_registrapaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrapaciActionPerformed

        // Este boton para permite registrar pacientes nuevos a la BD
        String nom = txt_nombre.getText();
        String prepa = txt_prepa.getText();
        String ced = txt_cedula.getText();
        String dir = txt_direccion.getText();
        String tel = txt_telefono.getText();
        String contra = String.valueOf(txt_contra.getPassword());
        if (ced.equals("")) {
            JOptionPane.showMessageDialog(null, "Agrega un cedula");
        } else if (contra.equals("")) {
            JOptionPane.showMessageDialog(null, "Agrega la contraseña");
        } else {
            PreparedStatement ps;
            String query = "INSERT INTO `admin`(`nombre`, `cedula`, `direccion`, `telefono`, `preparacion_academica`, `contraseña`) VALUES (?,?,?,?,?,?)";
            try {
                ps = MyConnetion.getConnection().prepareStatement(query);

                ps.setString(1, nom);
                ps.setString(2, ced);
                ps.setString(3, dir);
                ps.setString(4, tel);
                ps.setString(5, prepa);
                ps.setString(6, contra);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Nuevo Administrador Agregado");
                    Limpiar();
                    tabla("");
                }

            } catch (SQLException ex) {
                Logger.getLogger(frm_main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error " + ex);
            }
        }
    }//GEN-LAST:event_btn_registrapaciActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
      // este boton permite actualizar un administrador
         String id = tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 0).toString();
        ActualizarAdmin(id);
        tabla("");
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // este boton permite eliminar un administrador
        String id = tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 0).toString();
        Connection conexion = getConnection();
        EliminaRegistro(id);
        tabla("admin");
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tabla_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_adminMouseClicked
       // este evento es para que al momento de darle click a cualquier administrador aparesca en todos los textfield
        
        txt_nombre.setText(tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 1).toString());
        txt_cedula.setText(tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 2).toString());
        txt_direccion.setText(tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 3).toString());
        txt_telefono.setText(tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 4).toString());
        txt_prepa.setText(tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 4).toString());
        txt_contra.setText(tabla_admin.getValueAt(tabla_admin.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tabla_adminMouseClicked

    private void btn_vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciarActionPerformed
        // Este boton funciona para vaciar todos los textfield
        Limpiar();
    
    }//GEN-LAST:event_btn_vaciarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // Este boton sirve para buscar administradores
        tabla("admin");
        
    }//GEN-LAST:event_btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_registrapaci;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_vaciar;
    private javax.swing.JLabel lbl_cedu;
    private javax.swing.JLabel lbl_contra;
    private javax.swing.JLabel lbl_dire;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_prepa;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel panel_admin;
    private javax.swing.JScrollPane scrpanel_tabla;
    private javax.swing.JTable tabla_admin;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JPasswordField txt_contra;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_prepa;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
