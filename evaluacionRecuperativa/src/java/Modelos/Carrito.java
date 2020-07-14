/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.Conexion;
import java.sql.SQLException;

/**
 *
 * @author Elian
 */
public class Carrito {
    
    private int cod_carrito;
    private producto productos;
    private Conexion conexion;

    public Carrito() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public Carrito(int cod_carrito, producto productos) throws ClassNotFoundException, SQLException {
        this.cod_carrito = cod_carrito;
        this.productos = productos;
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
    
    
    
}
