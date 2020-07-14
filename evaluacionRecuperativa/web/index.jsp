<%@page import="Modelos.producto"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style=" align-content: center;">
        <br>
        <br>
        <br>
        
        <center>
            
        <div>Inicio</div>
        <br>
        <menu style="border-bottom: 1; background-color:background; ">
            <a href="intranetAdmin.jsp" >Admin Web</a>
        </menu> 
        <br>
        <br>

        
        <table style=" font-size: 20px;" >
            
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
                    Cantidad
                </td>
                <td>
                    Precio
                </td>
                
            </tr>
            
            <tr>
                <td><input type="text" name="codigo" /></td>
                <td><input type="text" name="nombre" /></td>
                <td><input type="text" name="Descripcion" /></td>
                <td><input type="text" name="cantidad" /></td>
               <td><input type="text" name="precio" /></td>
                <td>              
                    <input type="submit" value="Agregar al carrito" />   
                </td>
                <td>              
                    <input type="submit" value="ir alcarrito" />   
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
            </tr>
            <% } %>
         
        </table>
        </center>
    
    </body>
</html>
