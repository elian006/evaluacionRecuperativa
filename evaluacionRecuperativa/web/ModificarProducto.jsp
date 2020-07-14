<%-- 
    Document   : ModificarProducto
    Created on : 14-07-2020, 0:30:19
    Author     : Elian
--%>

<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int"%>
<%@page import="Modelos.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("Admin")!=null){%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Producto</title>
    </head>
    <body> <center>
        <h1>Puede modificar los datos</h1>
        <form action="ControlProducto" method="post">
             <% Int Codigo = request.getParameter("codigo");
               producto p = new producto().obtenerProducto(Codigo);
            %>

                <table style="border: 1; ">
                    <tr>
                        <td>Codigo</td>
                        <td><input type="text" name="codigo" value="<%= p.getCodigo()%>"
                                   readonly="true" /></td>
                    </tr>
                    <tr>
                        <td>nombre</td>
                        <td><input type="text" name="nombre" value="<%=p.getNombre()%>" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Descripcion</td>
                        <td><input type="text" name="descripcion" value="<%=p.getDescripcion()%>" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>precio</td>
                        <td><input type="number" name="precio" value="<%=p.getPrecio()%>" readonly="true"/></td>
                    </tr>
                   
                    <tr>
                        <td><a href="intranetAdmin.jsp">Volver</a></td>
                        <td><input type="submit" value="Modificar"/></td>
                    </tr>
                    <input type="hidden" name="accion" value="2"/>
                </table> 
           <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
        
        
        </form></center>
    </body>
</html>
<% }else{
    response.sendRedirect("index.jsp?mensaje=acceso denegado");
}%>