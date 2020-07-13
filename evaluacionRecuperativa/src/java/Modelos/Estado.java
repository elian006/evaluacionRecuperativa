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
public class Estado {
    
    private int cod_Estado;
    private String descripcion_E;
    private Conexion conexion;

    public Estado() throws ClassNotFoundException, SQLException {
        conexion = new Conexion();
    }

    public Estado(int cod_Estado, String descripcion_E) throws ClassNotFoundException, SQLException {
        this.cod_Estado = cod_Estado;
        this.descripcion_E = descripcion_E;
        conexion = new Conexion();
    }

    public int getCod_Estado() {
        return cod_Estado;
    }

    public void setCod_Estado(int cod_Estado) {
        this.cod_Estado = cod_Estado;
    }

    public String getDescripcion_E() {
        return descripcion_E;
    }

    public void setDescripcion_E(String descripcion_E) {
        this.descripcion_E = descripcion_E;
    }

    public ArrayList<Estado> obtenerEstado() throws SQLException, ClassNotFoundException{
        String sentencia = "select * from Estado order by cod_Estado";
        ArrayList<Estado> Estados = new ArrayList();
        ResultSet rs = conexion.consultarSQL(sentencia);
        while(rs.next()){
            Estados.add(new Estado(rs.getInt("cod_Estado"),
            (rs.getString("descripcion_E"))));
        }
        return Estados;
    }
    public Estado obtenerEstado(String cod_Estado) throws SQLException, ClassNotFoundException{
        String sentencia = "select * from Estado where cod_Estado='"+cod_Estado+"'";
        ResultSet rs = conexion.consultarSQL(sentencia);
        
        Estado E = new Estado();
        
        if(rs.next()){
            E.setCod_Estado((rs.getInt("cod_Estado")));
            E.setDescripcion_E ((rs.getString("descripcion_E")));
           
        }
        return E;
    } 
    
}
