<%-- 
    Document   : Ingreso
    Created on : 10/11/2020, 10:05:47 PM
    Author     : HP
--%>

<%@page  language="java" contentType="text/html;charset=iso-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta  charset=iso-8859-1">
        <title>Ingresar A Cuenta</title>
    </head>
    <body>
        <% String mensajeIngreso="Ingresando a tu cuenta";
           String mensaje=(String)session.getAttribute("mensaje");
           if(mensaje!=null) mensajeIngreso=mensaje;
        
        %>
        
        
        <h1><%=mensajeIngreso%></h1>
        <form action="/Repositorio/verificador" method="post" >
             Usuario: <input type="texto" name="user">
             <br><br>
             Contraseña: <input type="password" name="contra">
             <br><br>
             <input type="submit" value ="Aceptar"> 
           
            <br><br>
             <a href="index.jsp"> Regresar <a/>
           
        </form>
    </body>
</html>
