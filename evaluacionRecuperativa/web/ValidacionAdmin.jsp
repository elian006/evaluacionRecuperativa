<%-- 
    Document   : ValidacionAdmin
    Created on : 14-07-2020, 0:46:42
    Author     : Elian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><center>
        <h1>Inicio de sesion</h1>
        <form action="InicioSecionAdmin" method="post">
            
                <table style="border: 1; ">
                    <tr>
                        <td>Admin</td>
                        <td><input type="text" name="Admin" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td><a href="index.jsp">volver</a></td>
                        <td><input type="submit" value="Ingresar"/></td>
                        <input type="hidden" name="accion" value="4"/>
                    </tr>
                </table>
           <% if(request.getParameter("mensaje")!=null){%>
        <%=request.getParameter("mensaje") %>
        <%}%>
        </form>
         </center>
    </body>
</html>
