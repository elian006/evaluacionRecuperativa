/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    Connection conexion; //variable tipo Connection para la conexion a base de datos
    String url = "jdbc:mysql://localhost:3306/"; // inicio de la cadena de conexion
    String bd = "evaluacionrec"; //variable para el nombre de nuestra base de datos
    String driver = "com.mysql.jdbc.Driver"; //driver de jdbc para mysql
    String usuario = "root"; //usuario de la base de datos
    String password = ""; //password del usuario de la base de datos
    
    public Conexion() throws ClassNotFoundException, SQLException{
        Class.forName(driver) ;
        conexion = DriverManager.getConnection(url+bd,usuario,password);
    }
    
    private Statement obtenerStatement() throws SQLException{
       return  conexion.createStatement();
    }
    
    public int ejecutarSQL(String sentencia) throws SQLException{
       return obtenerStatement().executeUpdate(sentencia);
    }
    
    public ResultSet consultarSQL(String sentencia) throws SQLException{
        return obtenerStatement().executeQuery(sentencia);
    }
}
