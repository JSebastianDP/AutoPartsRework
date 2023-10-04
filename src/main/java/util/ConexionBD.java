/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sebastian Diaz
 */
public class ConexionBD {
    
    private String driver,userDB,passwordDB,database,urlDB;
    private Connection conexion;

    public ConexionBD() {
        driver ="com.mysql.jdbc.Driver";
        userDB="root";
        passwordDB="";
        database="autopartsrework";
        urlDB="jdbc:mysql://localhost:3306/"+database;
        
        //3 - Conectarse
            System.out.println("Conectando a la base de datos " + database + "...");
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlDB, userDB, passwordDB);
            if(conexion != null){
                System.out.println("Conexion correcta ");
            }
        } 
        catch (Exception e) {
            System.out.println("Error, no se ha podido conectar a la base de datos" + e.toString());
            //Esta condicional solo aparecera en la consola si hay error al conectar a la base de datos
            if(conexion == null){
                System.out.println("Revise alguna de las siguientes opciones:\n1: Driver de mysql \n2: Servicios de xampp activos \n3: Nombre de la base de datos correcto y creada en localhost");
            }
        }
    }
    
    public Connection obtenerConexion(){
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    
    public static void main(String[] args) {
        new ConexionBD();
    }
        
}
