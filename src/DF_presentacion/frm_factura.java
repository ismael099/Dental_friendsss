/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DF_presentacion;

import static DF_presentacion.MyConnetion.getConnection;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alian Peralta
 */
public class frm_factura extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form frm_factura
     */
    public frm_factura() {
        initComponents();
        this.model = (DefaultTableModel) tabla_factura.getModel();
        MostrarFactura("");
        
         
    }
     public void RefrescarTabla(){
        try{
            model.setColumnCount(0);
            model.setRowCount(0);
            tabla_factura.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex);
        }
    }
 public boolean RevisarFactura(String id){
     // Este metodo sirve para revisar al momento de insertar una nueva factura no se repita el id
    
          PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `factura` WHERE `id_factura` =?";
        try {
            ps = MyConnetion.getConnection().prepareStatement(query);
            ps.setString(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkUser = true;
            }
        }   catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        return checkUser;
    }
 public void MostrarFactura(String factura) {
      // este metodo funciona para mostrar todos las facturas almacenados en la base de datos con el defaulttablemodel
       String sql = "Select * from `factura`" +  factura;
        Statement st;
         MyConnetion cc = new MyConnetion();
        Connection cn = MyConnetion.getConnection();
        RefrescarTabla();
     model.addColumn("ID"); 
        model.addColumn("Numero Correlativa");
        model.addColumn("Fecha Correlativa");
        model.addColumn("Tipo de pago");
        model.addColumn("Subtotal");
        model.addColumn("Itbis");
        model.addColumn("Total");
        model.addColumn("ID empleado");
        model.addColumn("ID Doctor");
        model.addColumn("ID servicios");
       
        
        tabla_factura.setModel(model);
        String [] dato = new String[10];
      
        try{
            st = cn.createStatement();
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
                dato[7] =rs.getString(8);
                dato[8] =rs.getString(9);
                dato[9] =rs.getString(10);
                
                model.addRow(dato);
            }
        }catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null,"Error" + e);
        }
    }
   public void Limpiar(){
       // este metodo funciona para vaciar todos los texfields
    try{
       txt_num_correlativa.setText(""); // con esto se vacia un textfield en especifico
       txt_fecha_correletiva.setText("");
       txt_subtotal.setText("");
      txt_itbis.setText("");
        txt_total.setText("");
       cmb_tipo_pago.setSelectedIndex(-1);
     txt_id_serv.setText("");
     txt_id_empleado.setText("");
       txt_id_doctor.setText("");
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null,"error"+ ex);
    }
}
   public void ActualizarFactura(String id){
       // este metodo sirve para actualizar una factura registrada en la base de datos
       Connection con;

    try {
        PreparedStatement ps;
        con = getConnection();
        ps = con.prepareStatement("UPDATE `factura` SET numero_correlativa=?, fecha_correlativa=?, tipo_pago=?, subtotal=?, itbs=?, total=?, id_empleado=?, id_doctor=?, id_servicios=? WHERE id_factura=?");
        ps.setString(1, txt_num_correlativa.getText());
         ps.setString(2, txt_fecha_correletiva.getText());
         ps.setString(3, (String) cmb_tipo_pago.getSelectedItem());
         ps.setString(4, txt_subtotal.getText());
         ps.setString(5, txt_itbis.getText());
         ps.setString(6, txt_total.getText());
          ps.setString(7, txt_id_empleado.getText());
           ps.setString(8, txt_id_doctor.getText());
            ps.setString(9, txt_id_serv.getText());
        ps.setString(10, id);

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Factura Actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la factura");
        }
        con.close();

    } catch (SQLException e) {
       JOptionPane.showMessageDialog(null,"Error" + e);
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

        panel_factura = new javax.swing.JPanel();
        lbl_num_correlativa = new javax.swing.JLabel();
        txt_num_correlativa = new javax.swing.JTextField();
        lbl_fecha_correlativa = new javax.swing.JLabel();
        txt_fecha_correletiva = new javax.swing.JTextField();
        lbl_subtotal = new javax.swing.JLabel();
        lbl_itbis = new javax.swing.JLabel();
        cmb_tipo_pago = new javax.swing.JComboBox<>();
        txt_subtotal = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        lbl_tipo_pago = new javax.swing.JLabel();
        txt_itbis = new javax.swing.JTextField();
        lbl_servicio = new javax.swing.JLabel();
        txt_id_empleado = new javax.swing.JTextField();
        lbl_id_empleado = new javax.swing.JLabel();
        lbl_id_doctor = new javax.swing.JLabel();
        txt_id_doctor = new javax.swing.JTextField();
        btn_fact = new javax.swing.JButton();
        lbl_titulo = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        lbl_subtitulo = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        txt_id_serv = new javax.swing.JTextField();
        btn_listado = new javax.swing.JButton();
        btn_vaciar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        tabla_facturas = new javax.swing.JScrollPane();
        tabla_factura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturación");
        setPreferredSize(new java.awt.Dimension(1235, 559));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_factura.setBackground(new java.awt.Color(255, 255, 255));
        panel_factura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_num_correlativa.setBackground(java.awt.Color.white);
        lbl_num_correlativa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_num_correlativa.setForeground(new java.awt.Color(81, 124, 164));
        lbl_num_correlativa.setText("Num Correlativa:");
        panel_factura.add(lbl_num_correlativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 90, -1, -1));
        panel_factura.add(txt_num_correlativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 118, 150, -1));

        lbl_fecha_correlativa.setBackground(java.awt.Color.white);
        lbl_fecha_correlativa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_fecha_correlativa.setForeground(new java.awt.Color(81, 124, 164));
        lbl_fecha_correlativa.setText("Fecha correlativa:");
        panel_factura.add(lbl_fecha_correlativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 90, -1, -1));
        panel_factura.add(txt_fecha_correletiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 118, 150, -1));

        lbl_subtotal.setBackground(java.awt.Color.white);
        lbl_subtotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_subtotal.setForeground(new java.awt.Color(81, 124, 164));
        lbl_subtotal.setText("Subtotal:");
        panel_factura.add(lbl_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 156, -1, -1));

        lbl_itbis.setBackground(java.awt.Color.white);
        lbl_itbis.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_itbis.setForeground(new java.awt.Color(81, 124, 164));
        lbl_itbis.setText("Itbis:");
        panel_factura.add(lbl_itbis, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 156, -1, -1));

        cmb_tipo_pago.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmb_tipo_pago.setForeground(new java.awt.Color(81, 124, 164));
        cmb_tipo_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Credito" }));
        panel_factura.add(cmb_tipo_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 261, 150, -1));
        panel_factura.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 184, 150, -1));

        lbl_total.setBackground(java.awt.Color.white);
        lbl_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(81, 124, 164));
        lbl_total.setText("Total:");
        panel_factura.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 229, -1, -1));
        panel_factura.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 263, 150, -1));

        lbl_tipo_pago.setBackground(java.awt.Color.white);
        lbl_tipo_pago.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_tipo_pago.setForeground(new java.awt.Color(81, 124, 164));
        lbl_tipo_pago.setText("Tipo de pago:");
        panel_factura.add(lbl_tipo_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, 20));
        panel_factura.add(txt_itbis, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 184, 150, -1));

        lbl_servicio.setBackground(java.awt.Color.white);
        lbl_servicio.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_servicio.setForeground(new java.awt.Color(81, 124, 164));
        lbl_servicio.setText("Id Servicio:");
        panel_factura.add(lbl_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 301, -1, -1));
        panel_factura.add(txt_id_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 338, 160, -1));

        lbl_id_empleado.setBackground(java.awt.Color.white);
        lbl_id_empleado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_id_empleado.setForeground(new java.awt.Color(81, 124, 164));
        lbl_id_empleado.setText("Id del empleado:");
        panel_factura.add(lbl_id_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 301, -1, -1));

        lbl_id_doctor.setBackground(java.awt.Color.white);
        lbl_id_doctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_id_doctor.setForeground(new java.awt.Color(81, 124, 164));
        lbl_id_doctor.setText("Id del doctor:");
        panel_factura.add(lbl_id_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 375, -1, -1));
        panel_factura.add(txt_id_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 410, 160, -1));

        btn_fact.setBackground(new java.awt.Color(255, 255, 255));
        btn_fact.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_fact.setForeground(new java.awt.Color(94, 141, 147));
        btn_fact.setText("Facturar");
        btn_fact.setToolTipText("");
        btn_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_factActionPerformed(evt);
            }
        });
        panel_factura.add(btn_fact, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, 60));

        lbl_titulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(94, 141, 147));
        lbl_titulo.setText("Dental Friends ");
        panel_factura.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 23, -1, -1));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lo.png"))); // NOI18N
        panel_factura.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        lbl_subtitulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_subtitulo.setForeground(new java.awt.Color(94, 141, 147));
        lbl_subtitulo.setText("Facturación ");
        panel_factura.add(lbl_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 228, -1, -1));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salida-32.png"))); // NOI18N
        btn_salir.setToolTipText("Salir al menu principal");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        panel_factura.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 60));
        panel_factura.add(txt_id_serv, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 338, 160, -1));

        btn_listado.setBackground(new java.awt.Color(255, 255, 255));
        btn_listado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_listado.setForeground(new java.awt.Color(94, 141, 147));
        btn_listado.setText("Listado");
        btn_listado.setToolTipText("");
        btn_listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listadoActionPerformed(evt);
            }
        });
        panel_factura.add(btn_listado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 130, 60));

        btn_vaciar.setBackground(new java.awt.Color(255, 255, 255));
        btn_vaciar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_vaciar.setForeground(new java.awt.Color(94, 141, 147));
        btn_vaciar.setText("Vaciar");
        btn_vaciar.setToolTipText("");
        btn_vaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaciarActionPerformed(evt);
            }
        });
        panel_factura.add(btn_vaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 130, 60));

        btn_actualizar.setBackground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(94, 141, 147));
        btn_actualizar.setText("Actualizar");
        btn_actualizar.setToolTipText("");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        panel_factura.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 130, 60));

        getContentPane().add(panel_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 520));

        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_facturaMouseClicked(evt);
            }
        });
        tabla_facturas.setViewportView(tabla_factura);

        getContentPane().add(tabla_facturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 520, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_factActionPerformed
      //Boton para registrar facturas a la base de datos
        String num_corre = txt_num_correlativa.getText();
        String fecha_corre = txt_fecha_correletiva.getText();
        String subtotal = txt_subtotal.getText();
        String itbis = txt_itbis.getText();
        String total = txt_total.getText();
        String tipo_pago = String.valueOf(cmb_tipo_pago.getSelectedItem());
        String id_serv = txt_id_serv.getText();
        String id_emp = txt_id_empleado.getText();
        String id_doc = txt_id_doctor.getText();
                
        if(id_serv.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un servicio ofrecido");
        }
        
        else if(id_emp.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un id del empleado");
        }      
        else if(RevisarFactura(num_corre))
        {
            JOptionPane.showMessageDialog(null, "Este factura ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `factura`(`id_factura`, `numero_correlativa`,`fecha_correlativa`, `tipo_pago`, `subtotal`, `itbs`, `total`,`id_servicios`,`id_empleado`,`id_doctor`) VALUES (0,?,?,?,?,?,?,?,?,?)";
        try {
            ps = MyConnetion.getConnection().prepareStatement(query);
            
            ps.setString(1, num_corre);
            ps.setString(2, fecha_corre);
            ps.setString(3, tipo_pago);
            ps.setString(4, subtotal);
            ps.setString(5, itbis);
            ps.setString(6, total);
            ps.setString(7, id_serv);
            ps.setString(8, id_emp);
            ps.setString(9, id_doc); 
                
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nueva Factura Agregada");
                Limpiar();
                MostrarFactura("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
       }
    }//GEN-LAST:event_btn_factActionPerformed
    }
    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // Este es el boton que permite salir al menu principal o el main
        frm_main mf = new frm_main(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listadoActionPerformed
        // Este boton funciona para ir donde estan todos los registros de las facturas
          frm_listado_factura mf = new frm_listado_factura(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_listadoActionPerformed

    private void btn_vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciarActionPerformed
        // Este boton funciona para Vaciar todos el textfields
        Limpiar();
    }//GEN-LAST:event_btn_vaciarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // Este boton funciona para actualizar una factura ya registrada en la base de datos
        String id = tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 0).toString();
        ActualizarFactura(id);
        MostrarFactura("");
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void tabla_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_facturaMouseClicked
        // Este es un evento que al momento de darle click a una factura se rellenen todos los texfields con los datos de esta
    txt_num_correlativa.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 1).toString());
    txt_fecha_correletiva.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 2).toString());
    cmb_tipo_pago.setSelectedItem(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 3).toString());
    txt_subtotal.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 4).toString());
    txt_itbis.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 5).toString());
    txt_total.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 6).toString());
    txt_id_empleado.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 7).toString());
    txt_id_doctor.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 8).toString());
    txt_id_serv.setText(tabla_factura.getValueAt(tabla_factura.getSelectedRow(), 9).toString());
       
    }//GEN-LAST:event_tabla_facturaMouseClicked

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
            java.util.logging.Logger.getLogger(frm_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_fact;
    private javax.swing.JButton btn_listado;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_vaciar;
    private javax.swing.JComboBox<String> cmb_tipo_pago;
    private javax.swing.JLabel lbl_fecha_correlativa;
    private javax.swing.JLabel lbl_id_doctor;
    private javax.swing.JLabel lbl_id_empleado;
    private javax.swing.JLabel lbl_itbis;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_num_correlativa;
    private javax.swing.JLabel lbl_servicio;
    private javax.swing.JLabel lbl_subtitulo;
    private javax.swing.JLabel lbl_subtotal;
    private javax.swing.JLabel lbl_tipo_pago;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel panel_factura;
    private javax.swing.JTable tabla_factura;
    private javax.swing.JScrollPane tabla_facturas;
    private javax.swing.JTextField txt_fecha_correletiva;
    private javax.swing.JTextField txt_id_doctor;
    private javax.swing.JTextField txt_id_empleado;
    private javax.swing.JTextField txt_id_serv;
    private javax.swing.JTextField txt_itbis;
    private javax.swing.JTextField txt_num_correlativa;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
