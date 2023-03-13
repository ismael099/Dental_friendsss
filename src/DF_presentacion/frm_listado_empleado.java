/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DF_presentacion;
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
 * @author jim3j
 */
public class frm_listado_empleado extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form frm_listado_empleado
     */
    public frm_listado_empleado() {
        initComponents();
           this.model = (DefaultTableModel) tabla_empleado.getModel();
        MostrarEmpleados(""); // esto es para que la tabla aparesca desde que ejecutemos la pantalla
      
    }
    
 public boolean RevisarEmpleado(String usuario){
        // Este metodo sirve para revisar al momento de insertar un nuevo empleado no se repita el id
          PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `empleado` WHERE `id` =?";
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
  public void RefrescarTabla(){ // este metodo es para refrecar la tabla
        try{
            model.setColumnCount(0); // con esto refrescamos todas las columnas 
            model.setRowCount(0); // este refresca todas las filas
            tabla_empleado.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex);
        }
    }
    
     public void MostrarEmpleados (String empleados){
          // este metodo funciona para mostrar todos los empleados almacenados en la base de datos con el defaulttablemodel
        String sql = "" +  empleados; // esta variable es para el sql aqui esta vacia para poder hacer el if, else
        Statement st;
        MyConnetion cc = new MyConnetion();
        Connection cn = MyConnetion.getConnection();
        RefrescarTabla();
      model.addColumn("ID");  // de esta manera se llena el defaulttablemodel
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Sexo");
        model.addColumn("Dirección");
        model.addColumn("Telefono");
        model.addColumn("Salario");
        model.addColumn("Cedula");
       
        
        tabla_empleado.setModel(model); //aqui le decimos a quien se le va a llenar
      
        String [] dato = new String[8]; // aqui creamos un array para decirle a java lo que va a ejecutar
          if(empleados.equals("")){ // este es el if que dije que iba a usar
            sql = "Select * from `empleado`"; // esta sql es el que aparece desde que entramos a la pantalla y es porque no estamos buscando nada
        }
          else {
          sql = "select * from `empleado` where `id_empleado` = '" + txt_id_empleado.getText()+ "'";// + " or nombre = '" + txt_empleado.getText()+ "'" + " or telefono = '" + txt_telefono.getText()+ "'" +  "or cedula = '" + txt_cedula.getText() + "'";
             // este sql es el que se ejecuta para buscar un empleado en este caso le estamos diciendo que por ejemplo nombre sea igual a un texfield en ese caso si llenamos ese textfield debe buscar a alguien con ese nombre 
          }
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql); // este codigo es el que va a ejecutar la variable sql
            while(rs.next()) // este while nos servira para crear un bucle para que rellene el array
            {  

            dato[0] =rs.getString(1);
            dato[1] =rs.getString(2);
            dato[2] =rs.getString(3);
            dato[3] =rs.getString(4);
            dato[4] =rs.getString(5);
            dato[5] =rs.getString(6);
            dato[6] =rs.getString(7);
            dato[7] =rs.getString(8);
                
                model.addRow(dato); // con esto le decimos a java que agregue todas esas filas que estan en el bucle se las agregue a la tabla
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error" + e);
        }
    }
     public void Limpiar(){  // con este metodo vaciamos todos el textfields que tengamos
         txt_id_empleado.setText("");
         txt_empleado.setText("");
         txt_telefono.setText("");
         txt_cedula.setText("");
     }
      public void EliminarEmpleado(String id) { // este metodo sirve para eliminar un empleado registrado en la base de datos
        String sql = "delete from empleado where id_empleado = " + id;
        Statement st;
         Connection cn = MyConnetion.getConnection();
        try {
            st = cn.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
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

        panel_listado_paciente = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_empleado = new javax.swing.JLabel();
        txt_id_empleado = new javax.swing.JTextField();
        lbl_nombre_empleado = new javax.swing.JLabel();
        txt_empleado = new javax.swing.JTextField();
        lbl_telefono = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        lbl_cedula = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        tabla_empleados = new javax.swing.JScrollPane();
        tabla_empleado = new javax.swing.JTable();
        btn_salir = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();
        btn_vaciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado de pacientes");

        panel_listado_paciente.setBackground(new java.awt.Color(255, 255, 255));
        panel_listado_paciente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(94, 141, 147));
        lbl_titulo.setText("Lista de empleados:");
        panel_listado_paciente.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 31, -1, -1));

        lbl_empleado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_empleado.setForeground(new java.awt.Color(81, 124, 164));
        lbl_empleado.setText("id del empleado:");
        panel_listado_paciente.add(lbl_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));
        panel_listado_paciente.add(txt_id_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 144, 117, -1));

        lbl_nombre_empleado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_nombre_empleado.setForeground(new java.awt.Color(81, 124, 164));
        lbl_nombre_empleado.setText("Nombre empleado:");
        panel_listado_paciente.add(lbl_nombre_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 115, -1, -1));
        panel_listado_paciente.add(txt_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 144, 102, -1));

        lbl_telefono.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_telefono.setForeground(new java.awt.Color(81, 124, 164));
        lbl_telefono.setText("Telefono:");
        panel_listado_paciente.add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 115, -1, -1));
        panel_listado_paciente.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 144, 107, -1));

        lbl_cedula.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_cedula.setForeground(new java.awt.Color(81, 124, 164));
        lbl_cedula.setText("Cedula:");
        panel_listado_paciente.add(lbl_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 115, -1, -1));
        panel_listado_paciente.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 144, 88, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-eliminar-32.png"))); // NOI18N
        btn_eliminar.setToolTipText("Vaciar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        panel_listado_paciente.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 50, 40));

        tabla_empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_empleadoMouseClicked(evt);
            }
        });
        tabla_empleados.setViewportView(tabla_empleado);

        panel_listado_paciente.add(tabla_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 701, 281));

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-salida-32.png"))); // NOI18N
        btn_salir.setToolTipText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        panel_listado_paciente.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 469, -1, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-búsqueda-32.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panel_listado_paciente.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 469, -1, -1));

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-imprimir-32.png"))); // NOI18N
        btn_imprimir.setToolTipText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        panel_listado_paciente.add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, -1, -1));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lo.png"))); // NOI18N
        lbl_logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoMouseClicked(evt);
            }
        });
        panel_listado_paciente.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        btn_vaciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-empty-48.png"))); // NOI18N
        btn_vaciar.setToolTipText("Vaciar");
        btn_vaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaciarActionPerformed(evt);
            }
        });
        panel_listado_paciente.add(btn_vaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 107, 52, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_listado_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_listado_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // Este es el boton que permite salir a menu de los listados
        frm_listas mf = new frm_listas(); // aqui estamos creando un mf nuevo
        mf.setVisible(true); // esto es para que la pantalla del main pueda ser visible y la otra desaparesca
        mf.pack();
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
//        Este es el boton que permite imprimir el listado de empleados 
//  Aqui definimos una variable que se llama outfile y esta es igual al lugar donde tenemos el archivo que queremos mostrar
          String outFile = "C:\\Users\\jim3j\\OneDrive\\Documentos\\NetBeansProjects\\Dental_Friends\\src\\Reportes\\empleado.pdf";
        
        Connection cn=MyConnetion.getConnection(); // definimos una nueva conexion y le ponemos el nombre de cn 
        try{
          
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_listado_empleado.class.getResource("/Reportes/empleado.jasper"));
            // creamos un nuevo jasper report y ejecutamos una libreria que nos perimite cargar un reporte de jasper ya guardado en una carpeta
          Map parametros = new HashMap<>(); 
          parametros.put("Titulo", "Reporte Empleados");
            
          JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn);
          JasperViewer jv = new JasperViewer(jp, false);
          jv.setVisible(true);          
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex); // usamos este catch para que muestre cualquier error que tenga la impresion del codigo
}

    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciarActionPerformed
        // Este boton sirve para vaciar todos los textfield
        Limpiar();
    }//GEN-LAST:event_btn_vaciarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
//         este boton permite eliminar un empleado registrado en la base de datos 
          String id = tabla_empleado.getValueAt(tabla_empleado.getSelectedRow(), 0).toString();
        Connection cn = MyConnetion.getConnection();
        EliminarEmpleado(id);
        MostrarEmpleados("");
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // Este boton permite buscar un empleado registrado en la base de datos
        MostrarEmpleados("empleado");
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tabla_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_empleadoMouseClicked
    txt_id_empleado.setText(tabla_empleado.getValueAt(tabla_empleado.getSelectedRow(), 0).toString());
    txt_empleado.setText(tabla_empleado.getValueAt(tabla_empleado.getSelectedRow(), 1).toString());
    txt_telefono.setText(tabla_empleado.getValueAt(tabla_empleado.getSelectedRow(), 5).toString());
      txt_cedula.setText(tabla_empleado.getValueAt(tabla_empleado.getSelectedRow(), 7).toString());

    }//GEN-LAST:event_tabla_empleadoMouseClicked

    private void lbl_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoMouseClicked
        // Este evento es para volver a poner todos los registros
        MostrarEmpleados("");
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
            java.util.logging.Logger.getLogger(frm_listado_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_listado_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_listado_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_listado_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_listado_empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_vaciar;
    private javax.swing.JLabel lbl_cedula;
    private javax.swing.JLabel lbl_empleado;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nombre_empleado;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel panel_listado_paciente;
    private javax.swing.JTable tabla_empleado;
    private javax.swing.JScrollPane tabla_empleados;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_empleado;
    private javax.swing.JTextField txt_id_empleado;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
