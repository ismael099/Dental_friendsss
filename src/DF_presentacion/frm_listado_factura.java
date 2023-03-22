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
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author deleo
 */
public class frm_listado_factura extends javax.swing.JFrame {
DefaultTableModel model;
        
    /**
     * Creates new form frm_factura
     */
    public frm_listado_factura() {
        initComponents();
        this.model = (DefaultTableModel) tabla_listado_factura.getModel();
        MostrarFactura("");  // esto es para que la tabla aparesca desde que ejecutemos la pantalla
      
    }
     public void RefrescarTabla(){ // este metodo es para refrecar la tabla
        try{
            model.setColumnCount(0); // con esto refrescamos todas las columnas 
            model.setRowCount(0); // este refresca todas las filas
            tabla_factura.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex);
        }
    }
 public void MostrarFactura(String tabla) {
   // este metodo funciona para mostrar todas las facturas almacenadas en la base de datos con el defaulttablemodel
        String sql = "" +  tabla;
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
        
        tabla_listado_factura.setModel(model);
        String [] dato = new String[10];
        if(tabla.equals("")){
            sql = "Select * from `factura`";
        }
        else {
            sql = "select * from `factura` where `numero_correlativa` = '"+ txt_num_corre.getText()+"'" + " or `id_empleado` = '" + txt_id_emp.getText()+ "'" + "or `id_factura` = '" + txt_id_factura.getText() +"'";
            
        }
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
                
                 txt_num_corre.setText(rs.getString("numero_correlativa"));
                 txt_id_factura.setText(rs.getString("id_factura"));
                 txt_id_emp.setText(rs.getString("id_empleado"));
           
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e);
        }
    }
  public boolean RevisarFactura(String id){
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
  public void Limpiar(){  // con este metodo vaciamos todos el textfields que tengamos
       txt_num_corre.setText("");
       txt_id_emp.setText("");
       txt_id_factura.setText("");
  }
  public void EliminarFactura(String id){ // este metodo sirve para eliminar una factura registrado en la base de datos
       String sql = "delete from `factura` where `id_factura` =  " + id;
       Statement st;
       Connection cn = MyConnetion.getConnection();
        try {
            st = cn.createStatement();
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

        panel_listado_factura = new javax.swing.JPanel();
        lbl_facturacion = new javax.swing.JLabel();
        txt_id_factura = new javax.swing.JTextField();
        txt_num_corre = new javax.swing.JTextField();
        lbl_id_factura = new javax.swing.JLabel();
        lbl_num_corre = new javax.swing.JLabel();
        txt_id_emp = new javax.swing.JTextField();
        lbl_id_emp = new javax.swing.JLabel();
        lbl_detalle = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        tabla_factura = new javax.swing.JScrollPane();
        tabla_listado_factura = new javax.swing.JTable();
        lbl_logo = new javax.swing.JLabel();
        btn_vaciar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado de facturas");
        setBackground(new java.awt.Color(204, 255, 255));

        panel_listado_factura.setBackground(new java.awt.Color(255, 255, 255));
        panel_listado_factura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_facturacion.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_facturacion.setForeground(new java.awt.Color(94, 141, 147));
        lbl_facturacion.setText("Factura");
        lbl_facturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_facturacionMouseClicked(evt);
            }
        });
        panel_listado_factura.add(lbl_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));
        panel_listado_factura.add(txt_id_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 100, -1));
        panel_listado_factura.add(txt_num_corre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 120, -1));

        lbl_id_factura.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_id_factura.setForeground(new java.awt.Color(81, 124, 164));
        lbl_id_factura.setText("Id factura");
        panel_listado_factura.add(lbl_id_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        lbl_num_corre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_num_corre.setForeground(new java.awt.Color(81, 124, 164));
        lbl_num_corre.setText("Num correlativa");
        panel_listado_factura.add(lbl_num_corre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));
        panel_listado_factura.add(txt_id_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 110, -1));

        lbl_id_emp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_id_emp.setForeground(new java.awt.Color(81, 124, 164));
        lbl_id_emp.setText("Id empleado");
        panel_listado_factura.add(lbl_id_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        lbl_detalle.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_detalle.setForeground(new java.awt.Color(81, 124, 164));
        lbl_detalle.setText("Detalle:");
        panel_listado_factura.add(lbl_detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-eliminar-32.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        panel_listado_factura.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 40, 40));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salida-32.png"))); // NOI18N
        btn_salir.setToolTipText("Salir ");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        panel_listado_factura.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 50, 40));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-búsqueda-32.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panel_listado_factura.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 40, 40));

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-imprimir-32.png"))); // NOI18N
        btn_imprimir.setToolTipText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        panel_listado_factura.add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, 40));

        tabla_listado_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_listado_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_listado_facturaMouseClicked(evt);
            }
        });
        tabla_factura.setViewportView(tabla_listado_factura);

        panel_listado_factura.add(tabla_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 690, 240));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lo.png"))); // NOI18N
        lbl_logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoMouseClicked(evt);
            }
        });
        panel_listado_factura.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btn_vaciar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-empty-48.png"))); // NOI18N
        btn_vaciar1.setToolTipText("Vaciar");
        btn_vaciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaciar1ActionPerformed(evt);
            }
        });
        panel_listado_factura.add(btn_vaciar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 80, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_listado_factura, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_listado_factura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // Este es el boton que permite eliminar una factura ya registrada en la base de datos.
        String id = tabla_listado_factura.getValueAt(tabla_listado_factura.getSelectedRow(), 0).toString();
//         Connection cn = MyConnetion.getConnection(); // con esto llamamos a nuestra conexion
        EliminarFactura(id); // llamamos nuestro metodo para eliminar
        MostrarFactura("");
        
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // Este es el boton que permite salir a menu de los listado
        frm_listas mf = new frm_listas();// aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
       //        Este es el boton que permite imprimir el listado de las facturas 
//  Aqui definimos una variable que se llama outfile y esta es igual al lugar donde tenemos el archivo que queremos mostrar
           String outFile = "C:\\Users\\jim3j\\OneDrive\\Documentos\\NetBeansProjects\\Dental_Friends\\src\\Reportes\\factura.pdf";
        
        Connection cn=MyConnetion.getConnection(); // definimos una nueva conexion y le ponemos el nombre de cn 
        try{
        JasperReport jr = (JasperReport) JRLoader.loadObject(frm_listado_factura.class.getResource("/Reportes/factura.jasper"));
           // creamos un nuevo jasper report y ejecutamos una libreria que nos perimite cargar un reporte de jasper ya guardado en una carpeta
        Map parametros = new HashMap<>();
        parametros.put("Titulo", "Reporte Factura");
            
        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setVisible(true);          
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            // usamos este catch para que muestre cualquier error que tenga la impresion del codigo
}

    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        //        Este es el boton que permite buscar cualquier empleado que este registrado en la base de datos
        MostrarFactura("factura"); // con esto se llama a tu metodo 
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tabla_listado_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_listado_facturaMouseClicked
        // Este evento sirve para rellenar todos los text field
    txt_num_corre.setText(tabla_listado_factura.getValueAt(tabla_listado_factura.getSelectedRow(), 1).toString()); // esto siver para decirle a java que cuando clikcles un campo en especifico de la tabla rellene un texfield en especifico
    txt_id_factura.setText(tabla_listado_factura.getValueAt(tabla_listado_factura.getSelectedRow(), 0).toString());
    txt_id_emp.setText(tabla_listado_factura.getValueAt(tabla_listado_factura.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tabla_listado_facturaMouseClicked

    private void btn_vaciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciar1ActionPerformed
        // Este boton vacia todos los textfield
        Limpiar();
    }//GEN-LAST:event_btn_vaciar1ActionPerformed

    private void lbl_facturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_facturacionMouseClicked
        // Esto te lleva a la pantalla de la factura
        frm_factura mf = new frm_factura();// aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_lbl_facturacionMouseClicked

    private void lbl_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoMouseClicked
        //Esto es para que la tabla se vuelva a mostrar
        MostrarFactura("");
    }//GEN-LAST:event_lbl_logoMouseClicked

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
            java.util.logging.Logger.getLogger(frm_listado_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_listado_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_listado_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_listado_factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_listado_factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_vaciar1;
    private javax.swing.JLabel lbl_detalle;
    private javax.swing.JLabel lbl_facturacion;
    private javax.swing.JLabel lbl_id_emp;
    private javax.swing.JLabel lbl_id_factura;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_num_corre;
    private javax.swing.JPanel panel_listado_factura;
    private javax.swing.JScrollPane tabla_factura;
    private javax.swing.JTable tabla_listado_factura;
    private javax.swing.JTextField txt_id_emp;
    private javax.swing.JTextField txt_id_factura;
    private javax.swing.JTextField txt_num_corre;
    // End of variables declaration//GEN-END:variables
}
