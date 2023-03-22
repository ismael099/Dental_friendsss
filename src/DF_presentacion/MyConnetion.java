/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DF_presentacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jim3j
 */
public class MyConnetion {
   // Este es un codigo para conectar la base de datos con net beans  
    public static Connection getConnection() {
    Connection con = null;
    // Establecemos una conexion y le damos el nombre de con y lo establecemos como null
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       // llamamos a la libreria que nos permite conectar la base de datos
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dental_friend", "root", "fake");

       // definimos a que va hacer igual la conexion
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println(ex.getMessage());
        // usamos este catch para saber si la conexion no tiene ningun error
    }
    return con;
}

}
