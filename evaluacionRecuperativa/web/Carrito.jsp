<%-- 
    Document   : Carrito
    Created on : 14-07-2020, 3:56:02
    Author     : Elian
--%>

<%@page import="Modelos.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
    </head>
 <body style=" align-content: center;">
        <br>
        <br>
        <br>
        
        <center>
           
            <div style="font-size: 30px;">Carrito</div>
        <br>
        <menu style="border-bottom: 1; background-color:background; ">
            <a href="index.jsp">
                        <input type="button" value="Inicio"/>
            </a>
        </menu> 
        <br>
        

        <form action="ControlCarrito" method="post"> 
            <menu Style="font-size: 25px;">
                 Productos en carrito 
            </menu>
            
             <table style=" font-size: 20px; align-content: center;"  >
            <tr>
                <td>
                    Codigo Carrito
                </td>
                <td>
                    productos
                </td>
                <td>
                    cantidad
                </td>
                <td>
                    Sub Costo
                </td>
                
            </tr>
            
            <tr>
                <td><input type="text" name="cod" /></td>
                <td><input type="text" name="nombre" /></td>
                <td><input type="text" name="Descripcion" /></td>
               <td><input type="text" name="precio" /></td>

                <td>
                    <a href="GuardarPedido.jsp">
                        <input type="button" value="Guardar Pedido" />
                    </a>
                </td>
                
            </tr>
            
        </table>
        <br>
        <br>  
        <br>
        <table style=" font-size: 20px; background-color: buttonface;border: 1;">
            
            <tr >
                <td>
                    Codigo Carrito
                </td>
                <td>    </td>
                <td>
                    productos
                </td>
                <td>    </td>
                <td>
                    cantidad
                </td>
                <td>     </td>
                <td>
                    Sub Costo
                </td>

            </tr>
                <% ArrayList <Carrito> carritos= new Carrito().obtenerProductosEnC();
               
            for(Carrito c:carritos){
            %>
            <tr>
               <td><%=c.getCod_carrito()%></td>
               <td><%=c.getProductos().getNombre()%> </td>
               <td><%=c.getCantidad()%></td>
               <td><%=c.getSubCosto()%></td>
               

               <td>
                    <a href="EliminarCarrito.jsp?Cod_carrito=<%=c.getCod_carrito()%>">
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
</html>
