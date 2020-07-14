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
public class Carrito {
    
    
    
    private int cod_carrito;
    private producto productos;
    private int cantidad;
    
    private int SubCosto;
    
    private Conexion conexion;

    public Carrito() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
        productos = new producto();
    }

    public Carrito(int cod_carrito, producto productos, int cantidad,int SubCosto) throws ClassNotFoundException, SQLException {
        this.cod_carrito = cod_carrito;
        this.productos = productos;
        this.cantidad=cantidad;
        this.SubCosto=SubCosto;
        conexion = new Conexion();
    }

    public int getCod_carrito() {
        return cod_carrito;
    }

    public void setCod_carrito(int cod_carrito) {
        this.cod_carrito = cod_carrito;
    }

    public producto getProductos() {
        return productos;
    }

    public void setProductos(producto productos) {
        this.productos = productos;
    }
        public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubCosto() {
        return SubCosto;
    }

    public void setSubCosto(int SubCosto) {
        this.SubCosto = SubCosto;
    }
    
     public String registrarProducto() throws SQLException{
        if(validarProductosEnC()){
            return "El producto ya esta en el carrito";
        }else{
        String sentencia = "insert into carrito values('"+cod_carrito+"',"+ "'"+productos+"','"+cantidad+"',"+ "'"+SubCosto+"')";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "Producto agregado al carrito";
        }else{
            return "No se pudo agregar al carrito";
        }
        }
    }
        public boolean validarProductosEnC() throws SQLException{
        String sentencia = "select * from carrito where cod_producto='"+cod_carrito+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        return rs.next();
    }
        
        
        public ArrayList<Carrito> obtenerProductosEnC() throws SQLException, ClassNotFoundException{
        String sentencia = "select * from carrito order by productos";
        ArrayList<Carrito> carritos = new ArrayList();
        
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            carritos.add(new Carrito(rs.getInt("cod_carrito"),
            (productos.obtenerProductos(rs.getString("Codigo"))), (rs.getInt("cantidad")),(rs.getInt("SubCosto"))));
        }
        return carritos;
    }
    public Carrito obtenerProductosEnC(int cod_carrito) throws SQLException, ClassNotFoundException{
        String sentencia = "select * from carrito where cod_carrito='"+cod_carrito+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        
        Carrito c = new Carrito();
        producto p = new producto();
        if(rs.next()){
            c.setCod_carrito((rs.getInt("cod_carrito")));
            c.setProductos(productos.obtenerProductos(rs.getString("Codigo")));
            c.setCantidad((rs.getInt("cantidad")));
            c.setSubCosto((rs.getInt("SubCosto")));
        }
        return c;
    }


}
