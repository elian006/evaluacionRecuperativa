/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Estado;
import Modelos.pedido;
import Modelos.producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elian
 */
@WebServlet(name = "ControladorPedidos", urlPatterns = {"/ControladorPedidos"})
public class ControladorPedidos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": ingresar(request,response);
            break;
            case "2"://modificar(request,response);
            break;
            case "3": Eliminar(request,response);
            break;
        }
        }
        catch(Exception e){
            response.sendRedirect("index.jsp?mensaje=Complete todos los campos");
        }
    }
    private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            Estado E = new Estado();
            producto p = new producto();
            pedido P = new pedido(getInt("cod_pedido",request),
                    p.obtenerProductos(getString("producto",request)),
                                       getString("email",request),
                                       getInt("total",request),
                    E.obtenerEstado(getString("estado",request)));

             response.sendRedirect("intranetAdmin.jsp?mensaje="+p.registrarProducto());
        
            } 
        catch (Exception e) {
                response.sendRedirect("intranetAdmin.jsp?mensaje="+e.getMessage());
            }
    }
    
       private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try { 
            Estado E = new Estado();
            producto p = new producto();
            pedido P = new pedido(getInt("cod_pedido",request),
                    p.obtenerProductos(getString("producto",request)),
                                       getString("email",request),
                                       getInt("total",request),
                    E.obtenerEstado(getString("estado",request)));

            response.sendRedirect("intranetAdmin.jsp?mensaje="+p.modificarP());
         } catch (Exception e) {
                response.sendRedirect("intranetAdmin.jsp?mensaje="+e.getMessage());
            }
    }
    
        private void Eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            producto p = new producto();
            
            p.setCodigo(getInt("codigo",request));
            response.sendRedirect("intranetAdmin.jsp?mensaje="+p.eliminarP());
         } catch (Exception e) {
                response.sendRedirect("intranetAdmin.jsp?mensaje="+e.getMessage());
            }   
        
    }
        private String getString(String nombre,HttpServletRequest request){
        return request.getParameter(nombre);
    }
    private int getInt(String nombre,HttpServletRequest request){
        return Integer.parseInt(request.getParameter(nombre));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
