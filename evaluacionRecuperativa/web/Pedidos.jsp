<%-- 
    Document   : Pedidos
    Created on : 14-07-2020, 0:30:33
    Author     : Elian
--%>

<%@page import="Modelos.pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pedidos</title>
        </head>
         <% if(session.getAttribute("Admin")!=null){ 
        Admin A =(Admin) session.getAttribute("Admin");%>
        

    <body style=" align-content: center;">
        <br>
        <br>
        <br>
        
        <center>
           
            <div style="font-size: 30px;">Lista Pedidos</div>
        <br>
        <menu style="border-bottom: 1; background-color:background; ">
            <a href="index.jsp">
                        <input type="button" value="Inicio"/>
                    </a>
        </menu> 
        <br>
        

        <form action="ControlPedidos" method="post"> 
            <menu Style="font-size: 25px;">
                 Pedidos 
            </menu>
            
             <table style=" font-size: 20px; align-content: center;"  >
            <tr>
                <td>
                    codigo
                </td>
                <td>
                    productos
                </td>
                <td>
                    email
                </td>
                <td>
                    total
                </td>
                
            </tr>
            
            <tr>
                <td><input type="text" name="codigo" /></td>
                <td><input type="text" name="productos" /></td>
                <td><input type="text" name="email" /></td>
               <td><input type="text" name="total" /></td>
                <td>              
                    <input type="submit" value="cambiar estado" />   
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
                    productos
                </td>
                <td>
                    email
                </td>
                <td>
                    total
                </td>

            </tr>
                <% ArrayList <pedido> pedidos= new pedido().obtenerPedido();
               
            for(pedido P:pedidos){
            %>
            <tr>
                <td><%=P.getCod_pedido()%></td>
                <td><%=P.getProductos().getCodigo()%></td>
                <td><%=P.getEmail()%></td>
                <td><%=P.getEstado().getCod_Estado()%></td>
               
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
    <%}else{
    response.sendRedirect("index.jsp?mensaje=acceso denegado");
    }%>
</html>
