/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Admin {
    
    private String Admin;
    private String Nombre;
    private int Password;
    private Conexion conexion;

    public Admin() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public Admin(String Admin, String Nombre, int Password) throws ClassNotFoundException, SQLException {
        this.Admin = Admin;
        this.Nombre = Nombre;
        this.Password = Password;
        conexion = new Conexion();
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String Admin) {
        this.Admin = Admin;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }
    
    
     public String registrar() throws SQLException{
        if(validarUsuario()){
            return "El usuario ya existe";
        }else{
        String sentencia = "insert into usuario values('"+Admin+"','"+Nombre+"',"
                +Password+"')";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "Admin registrado";
        }else{
            return "No se pudo registrar el Admin";
        }
        }
    }
    public boolean validarUsuario() throws SQLException{
        String sentencia = "select * from administrador where Admin='"+Admin+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        return rs.next();
    }
    public boolean iniciarSesion() throws SQLException{
        String sentencia = "select * from administrador where Admin ='"+Admin+"' "
                + " and Password = '"+Password+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        boolean respuesta = false;
        if(rs.next()){
            respuesta = true;
            setNombre(rs.getString("Nombre"));
        }
        return respuesta;
    }
    
    public ArrayList<Admin> obtenerAdministrador() throws SQLException, ClassNotFoundException{
        String sentencia = "select * from administrador order by Nombre";
        ArrayList<Admin> Admins = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            Admins.add(new Admin(rs.getString("Admin"),rs.getString("Nombre"),
                   rs.getInt("Password")));
        }
        return Admins;
    }
    public Admin obtenerAdministradores(String Admin) throws SQLException, ClassNotFoundException{
        String sentencia = "select * from administradores where Admin='"+Admin+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        Admin u = new Admin();
        if(rs.next()){
            u.setAdmin(rs.getString("usuario"));
            u.setNombre(rs.getString("Nombre"));
            u.setPassword(rs.getInt("Password"));
        }
        return u;
    }

    
    
    
}
