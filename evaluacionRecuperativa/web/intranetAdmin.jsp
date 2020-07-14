<%-- 
    Document   : intranetAdmin
    Created on : 12-07-2020, 19:52:44
    Author     : Elian
--%>

<%@page import="Modelos.Admin"%>
<%@page import="Modelos.producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet Admin</title>
        
    </head>
    <% if(session.getAttribute("Admin")!=null){ 
        Admin A =(Admin) session.getAttribute("Admin");%>
    <body style=" align-content: center;">
        <br>
        <br>
        <br>
        
        <center>
           
        <div>Inicio</div>
        <br>
        <menu style="border-bottom: 1; background-color:background; ">
            <a href="index.jsp">
                        <input type="button" value="Inicio"/>
                    </a>
        </menu> 
        <br>
        <br>

        <form action="ControlProducto" method="post"> 
                    <table style=" font-size: 20px; align-content: center;"  >
            <tr Style="font-size: 25px;"> Registrar Producto </tr>
            <tr>
                <td>
                    Codigo
                </td>
                <td>
                    Nombre
                </td>
                <td>
                    Descripcion
                </td>
                <td>
                    Precio
                </td>
                
            </tr>
            
            <tr>
                <td><input type="text" name="codigo" /></td>
                <td><input type="text" name="nombre" /></td>
                <td><input type="text" name="Descripcion" /></td>
               <td><input type="text" name="precio" /></td>
                <td>              
                    <input type="submit" value="Agregar producto a la tienda" />   
                </td>
                <td>              
                    <input type="submit" value="ir a Pedidos" />   
                </td>
                
            </tr>
            
        </table>
        <br>
        <br>  
        <br>
        <table style=" font-size: 20px; background-color: buttonface;border: 1;">
            
            <tr >
                <td>
                    codigo
                </td>
                <td>
                    nombre
                </td>
                <td>
                    descripcion
                </td>
                <td>
                    precio
                </td>

            </tr>
                <% ArrayList <producto> productos= new producto().obtenerProductos();
               
            for(producto p:productos){
            %>
            <tr>
               <td><%=p.getCodigo()%></td>
               <td><%=p.getNombre()%></td>
               <td><%=p.getDescripcion()%></td>
               <td><%=p.getPrecio()%></td>
               
               <td><a href="ModificarProducto.jsp?patente=<%=p.getCodigo()%>">
                        <input type="button" value="Modificar" />
                    </a>
               </td>
               <td>
                    <a href="EliminarProducto.jsp?patente=<%=p.getCodigo()%>">
                        <input type="button" value="Eliminar" />
                    </a>
               </td>
            </tr>
            <% } %>
         
        </table>
        
    <input type="hidden" name="accion" value="1"/>
    
     </form>
                        <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
            </center>
    </body>
        <% }else{
    response.sendRedirect("index.jsp?mensaje=acceso denegado");
    }%>
</html>
