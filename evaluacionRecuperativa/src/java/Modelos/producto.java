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

/**
 *
 * @author Elian
 */
public class producto {
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precio;
    private Conexion conexion;
    
    public producto() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public producto(int codigo, String nombre, String descripcion, int precio) throws ClassNotFoundException, SQLException {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        conexion = new Conexion();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    public String registrarProducto() throws SQLException{
        if(validarProducto()){
            return "El producto ya existe";
        }else{
        String sentencia = "insert into producto values('"+codigo+"',"+ "'"+nombre+"','"+descripcion+"',"+ "'"+precio+"')";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "Producto registrado corectamente";
        }else{
            return "No se pudo registrar el producto";
        }
        }
    }
        public boolean validarProducto() throws SQLException{
        String sentencia = "select * from producto where cod_producto='"+codigo+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        return rs.next();
    }
            public String eliminarP() throws SQLException{
        if(validarProducto()){
            String sentencia = "delete from producto where cod_producto = '"+codigo+"'";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "producto eliminado";
        }else{
            return "No se pudo eliminar el producto";
        }
        }else{
            return "el producto no existe";
        }
    }
             public String modificarP() throws SQLException{
        if(validarProducto()){
            String sentencia = "update producto set cod_producto = '"+nombre+"','"+descripcion+"','"+precio+"',"
                    + "" + "where cod_producto = '"+codigo+"'";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "cproducto modificado";
        }else{
            return "No se pudo modificar el producto";
        }
        }else{
            return "el producto no existe";
        }
    }   
        public ArrayList<producto> obtenerProductos() throws SQLException, ClassNotFoundException{
        String sentencia = "select * from producto order by nombre";
        ArrayList<producto> productos = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            productos.add(new producto(rs.getInt("cod_producto"),
            (rs.getString("nombre")),(rs.getString("Descripcion")),(rs.getInt("precio"))));
        }
        return productos;
    }
    public producto obtenerProductos(String cod_producto) throws SQLException, ClassNotFoundException{
        String sentencia = "select * from producto where cod_producto='"+cod_producto+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        
        producto p = new producto();
        
        if(rs.next()){
            p.setCodigo((rs.getInt("cod_producto")));
            p.setNombre ((rs.getString("nombre")));
            p.setDescripcion(rs.getString("descripcion"));
            p.setPrecio(rs.getInt("precio"));
           
        }
        return p;
    }
    
    
}
