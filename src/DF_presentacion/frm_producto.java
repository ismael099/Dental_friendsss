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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alian Peralta
 */
public class frm_producto extends javax.swing.JFrame {

    DefaultTableModel model;
    
    /**
     * Creates new form frm_producto
     */
    public frm_producto() {
        initComponents();
        
        this.model = (DefaultTableModel) Tabla_Producto.getModel();
        MostrarProductos("");
        
    }
    
    public boolean RevisarProducto(String producto){
        //Este metodo es como dice su nombre para revisar si el producto esta en la base de datos  o no 
          PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `producto` WHERE `id_product` =?";
        try {
            ps = MyConnetion.getConnection().prepareStatement(query);
            ps.setString(1, producto);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkUser = true;
            }
        }   catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        return checkUser;
    }
    
     public void RefrescarTabla(){ // este metodo es para refrecar la tabla
        try{
            model.setColumnCount(0); // con esto refrescamos todas las columnas 
            model.setRowCount(0); // este refresca todas las filas
            Tabla_Producto.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex);
        }
    }
     
       public void MostrarProductos (String producto){
          // este metodo funciona para mostrar todos los empleados almacenados en la base de datos con el defaulttablemodel
        String sql = "Select * from `producto`" +  producto;
        Statement st;
        MyConnetion cc = new MyConnetion();
        Connection cn = MyConnetion.getConnection();
        RefrescarTabla();
        model.addColumn("id");
        model.addColumn("nombre"); 
        model.addColumn("categoria");
        model.addColumn("marca");
        model.addColumn("descripcion");
        model.addColumn("precio");
        model.addColumn("fecha_vencimiento");
        model.addColumn("id_proveedor");
        model.addColumn("id_admin");
       
        
        Tabla_Producto.setModel(model);
        String [] dato = new String[9];
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
                
                model.addRow(dato);
            }
        }catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "error "+e);
        }
    }
    
    public void Limpiar(){
        // Este es el metodo que utilizamos para limpiar los campos de la pantalla 
    try{
    txt_nombre_product.setText("");
    txt_Categoria.setText("");
    txt_marca.setText("");
    txt_Descripcion.setText("");
    txt_Precio.setText("");
    txt_fecha_vencimiento.setText("");
    txt_Id_proveedor.setText("");
    txt_Id_Admin.setText("");
    
    
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null,"error"+ ex);
    }
}
         public void ActualizarProducto(String id){
        // Este metodo funciona para actualizar un empleado ya registrado en la base de datos
  Connection con;

    try {
        PreparedStatement ps;
        con = getConnection();
        ps = con.prepareStatement("UPDATE `producto` SET nombre=?, categoria=?, marca=?, descripcion=?, precio=?, fecha_vencimiento=?,id_proveedor=?, id_admin=? WHERE id_product=?");
     
        ps.setString(1, txt_nombre_product.getText());
        ps.setString(2, txt_Categoria.getText());
        ps.setString(3, txt_marca.getText());
        ps.setString(4, txt_Descripcion.getText());
        ps.setString(5, txt_Precio.getText());
        ps.setString(6, txt_fecha_vencimiento.getText());
        ps.setString(7, txt_Id_proveedor.getText());
        ps.setString(8, txt_Id_Admin.getText());
        ps.setString(9, id);
       

        int res = ps.executeUpdate();

        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Producto Modificado");
//            MostrarEmpleados("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al Modificar Prodcuto");
        }
        con.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "error "+e);
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

        panel_producto = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_nombre_product = new javax.swing.JLabel();
        txt_nombre_product = new javax.swing.JTextField();
        lbl_Categoria = new javax.swing.JLabel();
        txt_Categoria = new javax.swing.JTextField();
        txt_fecha_vencimiento = new javax.swing.JTextField();
        lbl_marca = new javax.swing.JLabel();
        lbl_fecha_vencimiento = new javax.swing.JLabel();
        lbl_representacion = new javax.swing.JLabel();
        txt_Id_proveedor = new javax.swing.JTextField();
        lbl_Id_Admin = new javax.swing.JLabel();
        btn_actualizar = new javax.swing.JButton();
        lbl_img = new javax.swing.JLabel();
        txt_Descripcion = new javax.swing.JTextField();
        btn_salir = new javax.swing.JButton();
        lbl_Precio = new javax.swing.JLabel();
        lbl_Id_proveedor = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        txt_Id_Admin = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Producto = new javax.swing.JTable();
        btn_registar = new javax.swing.JButton();
        btn_vaciar = new javax.swing.JButton();
        btn_listado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_producto.setBackground(new java.awt.Color(255, 255, 255));
        panel_producto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(94, 141, 147));
        lbl_titulo.setText("Registro de producto ");
        panel_producto.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        lbl_nombre_product.setBackground(java.awt.Color.white);
        lbl_nombre_product.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_nombre_product.setForeground(new java.awt.Color(81, 124, 164));
        lbl_nombre_product.setText("Nombre:");
        panel_producto.add(lbl_nombre_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));
        panel_producto.add(txt_nombre_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 150, -1));

        lbl_Categoria.setBackground(java.awt.Color.white);
        lbl_Categoria.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_Categoria.setForeground(new java.awt.Color(81, 124, 164));
        lbl_Categoria.setText("Categoria:");
        panel_producto.add(lbl_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));
        panel_producto.add(txt_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 150, -1));
        panel_producto.add(txt_fecha_vencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 150, -1));

        lbl_marca.setBackground(java.awt.Color.white);
        lbl_marca.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_marca.setForeground(new java.awt.Color(81, 124, 164));
        lbl_marca.setText("Marca:");
        panel_producto.add(lbl_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        lbl_fecha_vencimiento.setBackground(java.awt.Color.white);
        lbl_fecha_vencimiento.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_fecha_vencimiento.setForeground(new java.awt.Color(81, 124, 164));
        lbl_fecha_vencimiento.setText("Fecha vencimiento:");
        panel_producto.add(lbl_fecha_vencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

        lbl_representacion.setBackground(java.awt.Color.white);
        lbl_representacion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_representacion.setForeground(new java.awt.Color(81, 124, 164));
        lbl_representacion.setText("Descripción:");
        panel_producto.add(lbl_representacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, -1, -1));
        panel_producto.add(txt_Id_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 110, 20));

        lbl_Id_Admin.setBackground(java.awt.Color.white);
        lbl_Id_Admin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_Id_Admin.setForeground(new java.awt.Color(81, 124, 164));
        lbl_Id_Admin.setText("Id_Admin:");
        panel_producto.add(lbl_Id_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 180, -1, 20));

        btn_actualizar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(94, 141, 147));
        btn_actualizar.setText("Actualizar");
        btn_actualizar.setToolTipText("");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        panel_producto.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 660, 140, 60));

        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lo.png"))); // NOI18N
        panel_producto.add(lbl_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));
        panel_producto.add(txt_Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 150, -1));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salida-32.png"))); // NOI18N
        btn_salir.setToolTipText("Salir al menu principal");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        panel_producto.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 70, 60));

        lbl_Precio.setBackground(java.awt.Color.white);
        lbl_Precio.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_Precio.setForeground(new java.awt.Color(81, 124, 164));
        lbl_Precio.setText("Precio");
        panel_producto.add(lbl_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, -1, 20));

        lbl_Id_proveedor.setBackground(java.awt.Color.white);
        lbl_Id_proveedor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_Id_proveedor.setForeground(new java.awt.Color(81, 124, 164));
        lbl_Id_proveedor.setText("Id_proveedor:");
        panel_producto.add(lbl_Id_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 20));
        panel_producto.add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 150, -1));
        panel_producto.add(txt_Id_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 210, 80, -1));
        panel_producto.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 150, -1));

        Tabla_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_Producto(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Producto);

        panel_producto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 1210, 280));

        btn_registar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_registar.setForeground(new java.awt.Color(94, 141, 147));
        btn_registar.setText("Registrar");
        btn_registar.setToolTipText("");
        btn_registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registarActionPerformed(evt);
            }
        });
        panel_producto.add(btn_registar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 130, 60));

        btn_vaciar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_vaciar.setForeground(new java.awt.Color(94, 141, 147));
        btn_vaciar.setText("Vaciar");
        btn_vaciar.setToolTipText("");
        btn_vaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaciarActionPerformed(evt);
            }
        });
        panel_producto.add(btn_vaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 660, 130, 60));

        btn_listado.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_listado.setForeground(new java.awt.Color(94, 141, 147));
        btn_listado.setText("Listado");
        btn_listado.setToolTipText("");
        btn_listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listadoActionPerformed(evt);
            }
        });
        panel_producto.add(btn_listado, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 660, 130, 60));

        getContentPane().add(panel_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
      // Este es el boton que permite salir al menu principal o el main
        frm_main mf = new frm_main(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciarActionPerformed
     // Este es le boton que utilizamos para limpiar los campos de nuestra pantalla 
        Limpiar();
    }//GEN-LAST:event_btn_vaciarActionPerformed

    


    
    
    
    private void btn_registarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registarActionPerformed

        // Este es el boton para registrar el producto a nuestra base de datos 
              
        String nom = txt_nombre_product.getText();
        String cate = txt_Categoria.getText();
        String mar = txt_marca.getText();
        String desc = txt_Descripcion.getText();
        String pre= txt_Precio.getText();
        String fecha = txt_fecha_vencimiento.getText();
        String id_pro = txt_Id_proveedor.getText();
        String id_adm = txt_Id_Admin.getText();
    

        
        
           
        if(nom.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un nombre");
        }   
        else if(cate.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrege su tipo de categoia");
        }
        else if(mar.equals(""))
        {
            
           JOptionPane.showMessageDialog(null, "Agrege  la marca del producto");
        }
        else if(desc.equals(""))
        {
         JOptionPane.showMessageDialog(null, "Agrege  la fecha de vencimiento del producto");  
        }
        else if(pre.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Agrege  la descripcion del producto");    
        }
         else if(fecha.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Agrege el precio al producto");    
        }
          else if(id_pro.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Agrege  el id del proveedor para registrar el producto");    
        }
           else if(id_adm.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Agrege  el id del admin para registrar el producto ");    
        }
    
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `producto`(`nombre`, `categoria`, `marca`, `descripcion`, `precio`, `fecha_vencimiento`,`id_proveedor`,`id_admin`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = MyConnetion.getConnection().prepareStatement(query);
            
            ps.setString(1, nom);
            ps.setString(2, cate);
            ps.setString(3, mar);
            ps.setString(4, desc);
            ps.setString(5, pre);
            ps.setString(6, fecha);
            ps.setString(7, id_pro);
            ps.setString(8, id_adm);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo Producto Agregado");
                Limpiar();
                MostrarProductos("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
    }
    }//GEN-LAST:event_btn_registarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // Este boton se encarga de realizar el evento de actualizacion 
        
        String id = Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 0).toString();
        ActualizarProducto(id);
        
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listadoActionPerformed
        // este boton te envia al listado de los productos
        frm_listado_productos mf = new frm_listado_productos(); 
        mf.setVisible(true); 
        mf.pack();
        this.dispose();
        
    }//GEN-LAST:event_btn_listadoActionPerformed

    private void Tabla_Producto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_Producto
        // TODO add your handling code here:
        
        // Este es un evento que al momento de darle click a un empleado se reseñen todos los texfields con los datos de este
     txt_nombre_product.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 1).toString());
     txt_Categoria.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 2).toString());
     txt_marca.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 3).toString());
     txt_Descripcion.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 4).toString());
     txt_Precio.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 5).toString());
     txt_fecha_vencimiento.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 6).toString());
     txt_Id_proveedor.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 7).toString());
     txt_Id_Admin.setText(Tabla_Producto.getValueAt(Tabla_Producto.getSelectedRow(), 8).toString());
        
    }//GEN-LAST:event_Tabla_Producto

    
                                          

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
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Producto;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_listado;
    private javax.swing.JButton btn_registar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_vaciar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Categoria;
    private javax.swing.JLabel lbl_Id_Admin;
    private javax.swing.JLabel lbl_Id_proveedor;
    private javax.swing.JLabel lbl_Precio;
    private javax.swing.JLabel lbl_fecha_vencimiento;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_marca;
    private javax.swing.JLabel lbl_nombre_product;
    private javax.swing.JLabel lbl_representacion;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel panel_producto;
    private javax.swing.JTextField txt_Categoria;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Id_Admin;
    private javax.swing.JTextField txt_Id_proveedor;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_fecha_vencimiento;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_nombre_product;
    // End of variables declaration//GEN-END:variables
}
