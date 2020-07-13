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
import Modelos.producto;

/**
 *
 * @author Elian
 */
public class pedido {
    
    private int cod_pedido;
    private producto Productos;
    private String email;
    private int total;
    private Estado estado;
    private Conexion conexion;
    
    public pedido() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public pedido(int cod_pedido, producto Productos, String email,int total, Estado estado) throws ClassNotFoundException, SQLException {
        this.cod_pedido = cod_pedido;
        this.Productos = Productos;
        this.email = email;
        this.total = total;
        this.estado = estado;
        conexion = new Conexion();
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public producto getProductos() {
        return Productos;
    }

    public void setProductos(producto Productos) {
        this.Productos = Productos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int gettotal() {
        return total;
    }

    public void settotal(int total) {
        this.total = total;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
    public String registrarPedido() throws SQLException{
        if(validarPedido()){
            return "este pedido ya existe";
        }else{
        String sentencia = "insert into pedido values('"+cod_pedido+"',"+ "'"+Productos+"')"+ "'"+email+"')"+  "'"+total+"')"+"'"+estado+"')";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "pedido registrado";
        }else{
            return "No se pudo registrarel pedido";
        }
        }
    }
        public boolean validarPedido() throws SQLException{
        String sentencia = "select * from pedido where cod_pedido='"+cod_pedido+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        return rs.next();
    }
            public String eliminarPedido() throws SQLException{
        if(validarPedido()){
            String sentencia = "delete from pedido where cod_pedido = '"+cod_pedido+"'";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "pedido";
        }else{
            return "No se pudo eliminar el pedido";
        }
        }else{
            return "Este pedido no existe";
        }
    }
             public String modificarPedido() throws SQLException{
        if(validarPedido()){
            String sentencia = "update pedido set cod_pedido = '"+Productos+"','"+email+"','"+total+"','"+estado+"'," + "where cod_pedido = '"+cod_pedido+"'";
        if(conexion.ejecutarSQL(sentencia)==1){
            return "pedido modificado";
        }else{
            return "No se pudo modificar su pedido";
        }
        }else{
            return "Este pedido no existe";
        }
    }   
        public ArrayList<pedido> obtenerPedido() throws SQLException, ClassNotFoundException{
        String sentencia = "select * from pedido order by productos";
        ArrayList<pedido> pedidos = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            pedidos.add(new pedido(rs.getInt("cod_pedido"),
                    
                    (Productos.obtenerProductos(rs.getString("cod_producto"))),
                    
                    (rs.getString("email")),
                    
                    (rs.getInt("total")),
                    
                    (estado.obtenerEstado(rs.getString("Estado")))));
        }
        return pedidos;
    }
    public pedido obtenerPedido(int cod_pedido) throws SQLException, ClassNotFoundException{
        String sentencia = "select * from pedido where cod_ciudad='"+cod_pedido+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        
        pedido P = new pedido();
        
        if(rs.next()){
            P.setCod_pedido((rs.getInt("cod_pedido")));
            P.setProductos ((Productos.obtenerProductos(rs.getString("cod_producto"))));
            P.setEmail  (rs.getString("email"));
            P.settotal  (rs.getInt("total"));
            P.setEstado (estado.obtenerEstado(rs.getString("Estado")));
           
        }
        return P;
    }
    
}
