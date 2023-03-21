/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DF_presentacion;

import static DF_presentacion.MyConnetion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Alian Peralta
 */
public class frm_paciente extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form frm_cliente
     */
    public frm_paciente() {
        initComponents();
         this.model = (DefaultTableModel) tabla_paciente.getModel();
        MostrarPacientes("");
    }
    
      public void RefrescarTabla(){
        try{
            model.setColumnCount(0);
            model.setRowCount(0);
            tabla_paciente.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex);
        }
    }
    public boolean RevisarPaciente(String usuario){
          PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `paciente` WHERE `id_paciente` =?";
        try {
            ps = MyConnetion.getConnection().prepareStatement(query);
            ps.setString(1, usuario);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkUser = true;
            }
        }   catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        return checkUser;
    }
    public void Limpiar(){
    try{
    txt_nombre.setText("");
    txt_direccion.setText("");
    txt_apellido.setText("");
    txt_core.setText("");
    txt_telefono.setText("");
    txt_cedula.setText("");
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null,"error"+ ex);
    }

}
      public void MostrarPacientes(String paciente){
           // este metodo funciona para mostrar todos las facturas almacenados en la base de datos con el defaulttablemodel
       String sql = "Select * from `paciente` " +  paciente; // aqui tenemos que definir un string que este tendra la consulta sql para despues usarla
        Statement st; // aqui creamos nuestro stament
         MyConnetion cc = new MyConnetion(); // llamamos nuestra conexion de mysql
        Connection cn = MyConnetion.getConnection();
        RefrescarTabla(); // aqui se utiliza el refrecartabla para cada que se llame a este metodo la tabla se refresque
     model.addColumn("ID");  // rellenamos nuestro jtables o defaulttablemodel con estas columnas 
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Dirección");
        model.addColumn("Telefono");
        model.addColumn("Cedula");
        model.addColumn("Correo Electronico");

        tabla_paciente.setModel(model); // aqui le decimos a java que estas columnas iran a nuestro jtablel
        String [] dato = new String[7]; // creamos un array para ordenar la informacion que se saca de la base de datos
      
        try{ // se crea este try para ejecutar nuestro codigo sql y para rellenar mi array
            st = cn.createStatement(); // aqui utilizamos nuestro stament y aqui conectamos la conexion con el stament
            ResultSet rs = st.executeQuery(sql); // con creamos un resultset y lo definimos con nuestro stament y ademas le decirmos que ejecute nuestro codigo de sql 
            while(rs.next()) // creamos este while para que rellene el array
            {  
                  
                dato[0] =rs.getString(1); // con esto se llena el array y este es para ordenar la informacion que se esta resiviendo desde la base de datos
                dato[1] =rs.getString(2);
                dato[2] =rs.getString(3);
                dato[3] =rs.getString(4);
                dato[4] =rs.getString(5);
                dato[5] =rs.getString(6);
                 dato[6] =rs.getString(7);
                
                model.addRow(dato); // con esto le decimos a java que ese array que acabamos de llenar es para nuestro defaulttablemodel
            }
        }catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null,"Error" + e);
        }
    }
   public void ActualizarPaciente(String id){
       // este metodo sirve para actualizar una factura registrada en la base de datos
       Connection con;
// String nom = txt_nombre.getText();
// String ced = txt_cedula.getText();
// String core = txt_core.getText();
//         if(nom.equals("")){
//           JOptionPane.showMessageDialog(null, "Error al actualizar un paciente no puedes dejar el nombre vacio"); 
//        }
//         
//         else if(ced.equals("")){
//              JOptionPane.showMessageDialog(null, "Error al actualizar un paciente no puedes dejar la cedula vacia"); 
//         }
//         
//         else if(core.equals("")){
//              JOptionPane.showMessageDialog(null, "Error al actualizar un paciente no puedes dejar el correo vacio"); 
//         }
//        else {
//            JOptionPane.showMessageDialog(null, "Error al actualizar un paciente");
    try {
        PreparedStatement ps;
        con = getConnection();
        ps = con.prepareStatement("UPDATE `paciente` SET `nombre`=?, `apellido`=?, `direccion`=?, `telefono`=?,`cedula`=?,`correo`=?  WHERE `id_paciente`=?");
        ps.setString(1, txt_nombre.getText());
         ps.setString(2, txt_apellido.getText());
         ps.setString(3, txt_direccion.getText());
         ps.setString(4, txt_telefono.getText());
         ps.setString(5, txt_cedula.getText());
         ps.setString(6, txt_core.getText());
        ps.setString(7, id);

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Paciente Actualizado");
        }
        else {
            JOptionPane.showMessageDialog(null, "Error al actualizar un paciente");
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

        panel_paciente = new javax.swing.JPanel();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_cedu = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        lbl_dire = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_correo = new javax.swing.JLabel();
        btn_listado = new javax.swing.JButton();
        lbl_tel = new javax.swing.JLabel();
        lbl_ape = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_core = new javax.swing.JTextField();
        lbl_title = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        btn_regitro = new javax.swing.JButton();
        btn_vaciar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        scrpanel_tabla = new javax.swing.JScrollPane();
        tabla_paciente = new javax.swing.JTable();
        sp_separador = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de pacientes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_paciente.setBackground(new java.awt.Color(255, 255, 255));
        panel_paciente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(81, 124, 164));
        lbl_nombre.setText("Nombre:");
        panel_paciente.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_paciente.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 137, 20));

        lbl_cedu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_cedu.setForeground(new java.awt.Color(81, 124, 164));
        lbl_cedu.setText("Cedula:");
        panel_paciente.add(lbl_cedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        txt_cedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_paciente.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 150, 20));

        lbl_dire.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_dire.setForeground(new java.awt.Color(81, 124, 164));
        lbl_dire.setText("Direccion:");
        panel_paciente.add(lbl_dire, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txt_direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_paciente.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 20));

        lbl_correo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_correo.setForeground(new java.awt.Color(81, 124, 164));
        lbl_correo.setText("Correo:");
        panel_paciente.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        btn_listado.setBackground(new java.awt.Color(255, 255, 255));
        btn_listado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_listado.setForeground(new java.awt.Color(94, 141, 147));
        btn_listado.setText("Listado");
        btn_listado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147), 2));
        btn_listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listadoActionPerformed(evt);
            }
        });
        panel_paciente.add(btn_listado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 100, 40));

        lbl_tel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_tel.setForeground(new java.awt.Color(81, 124, 164));
        lbl_tel.setText("Telefono:");
        panel_paciente.add(lbl_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        lbl_ape.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_ape.setForeground(new java.awt.Color(81, 124, 164));
        lbl_ape.setText("Apellido:");
        panel_paciente.add(lbl_ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        txt_apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_paciente.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 147, 20));

        txt_telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_paciente.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 147, 20));

        txt_core.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147)));
        panel_paciente.add(txt_core, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 147, 20));

        lbl_title.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(94, 141, 147));
        lbl_title.setText("Registro de paciente");
        panel_paciente.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lo.png"))); // NOI18N
        panel_paciente.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salida-32.png"))); // NOI18N
        btn_salir.setToolTipText("Salir al menu principal");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        panel_paciente.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));

        btn_regitro.setBackground(new java.awt.Color(255, 255, 255));
        btn_regitro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_regitro.setForeground(new java.awt.Color(94, 141, 147));
        btn_regitro.setText("Registrar");
        btn_regitro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(94, 141, 147), 2));
        btn_regitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regitroActionPerformed(evt);
            }
        });
        panel_paciente.add(btn_regitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 100, 40));

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
        panel_paciente.add(btn_vaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 100, 40));

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
        panel_paciente.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 100, 40));

        getContentPane().add(panel_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 430));

        tabla_paciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "nombre", "apellido", "direccion", "telefono", "cedula"
            }
        ));
        tabla_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_pacienteMouseClicked(evt);
            }
        });
        scrpanel_tabla.setViewportView(tabla_paciente);

        getContentPane().add(scrpanel_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 400));
        getContentPane().add(sp_separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 2, -1, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listadoActionPerformed
 // Este boton funciona para ir donde estan todos los registros de los pacientes
          frm_paciente_listado mf = new frm_paciente_listado(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_listadoActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
         // Este es el boton que permite salir al menu principal o el main
        frm_main mf = new frm_main(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_regitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regitroActionPerformed

        // Este boton para permite registrar pacientes nuevos a la BD
  
        String nom = txt_nombre.getText();
        String ape = txt_apellido.getText();
              String ced = txt_cedula.getText();
        String dir = txt_direccion.getText();
         String tel = txt_telefono.getText();
         String corre = txt_core.getText();

                
        if(ced.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un cedula");
        }
        
        else if(nom.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el nombre");
        }      
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `paciente`(`nombre`, `apellido`, `direccion`, `telefono`, `cedula`, `correo`) VALUES (?,?,?,?,?,?)";
        try {
            ps = MyConnetion.getConnection().prepareStatement(query);
            
            ps.setString(1, nom);
            ps.setString(2, ape);
             ps.setString(3, dir);
             ps.setString(4, tel);          
             ps.setString(5, ced);
             ps.setString(6,corre);
        
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo paciente Agregado");
                Limpiar();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
       }
        
    }//GEN-LAST:event_btn_regitroActionPerformed
    }
    private void btn_vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciarActionPerformed
  // Este boton funciona para Vaciar todos el textfields
  Limpiar();
    }//GEN-LAST:event_btn_vaciarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // Este boton funciona para actualizar una factura ya registrada en la base de datos
        String id = tabla_paciente.getValueAt(tabla_paciente.getSelectedRow(), 0).toString();
        ActualizarPaciente(id);
        MostrarPacientes("");
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void tabla_pacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_pacienteMouseClicked
       // Este es un evento que al momento de darle click a una factura se rellenen todos los texfields con los datos de esta
    txt_nombre.setText(tabla_paciente.getValueAt(tabla_paciente.getSelectedRow(), 1).toString());
    txt_apellido.setText(tabla_paciente.getValueAt(tabla_paciente.getSelectedRow(), 2).toString());
    txt_cedula.setText(tabla_paciente.getValueAt(tabla_paciente.getSelectedRow(), 5).toString());
    txt_direccion.setText(tabla_paciente.getValueAt(tabla_paciente.getSelectedRow(), 3).toString());
    txt_core.setText(tabla_paciente.getValueAt(tabla_paciente.getSelectedRow(), 6).toString());
    txt_telefono.setText(tabla_paciente.getValueAt(tabla_paciente.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tabla_pacienteMouseClicked
    
 
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
            java.util.logging.Logger.getLogger(frm_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_listado;
    private javax.swing.JButton btn_regitro;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_vaciar;
    private javax.swing.JLabel lbl_ape;
    private javax.swing.JLabel lbl_cedu;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_dire;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel panel_paciente;
    private javax.swing.JScrollPane scrpanel_tabla;
    private javax.swing.JSeparator sp_separador;
    private javax.swing.JTable tabla_paciente;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_core;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
