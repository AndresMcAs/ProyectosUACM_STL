<%-- 
    Document   : index
    Created on : 10/11/2020, 04:14:53 PM
    Author     : HP
--%>

<%@page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Proyectos Uacm</title>
    </head>
    <body>
        
        <% String mensajeIngreso="Proyectos UACM";
           String mensaje=(String)session.getAttribute("mensaje");
           if(mensaje!=null) mensajeIngreso=mensaje;
        
        %>
        
        
        <h1><%=mensajeIngreso%></h1>
        <form action="/Repositorio/control" method="post">
            <p> Bien venido a tu respositorio ProyectosUACM</p> 
            <img src="https://th.bing.com/th/id/OIP.8VyFNF49D5N87_md5EjEDAHaCx?w=336&h=131&c=7&o=5&pid=1.7" 
                 width="300" heigth="200"
                 align="center" alt="No se pudo mostrar la imagen">
          
             <br> <br><br> <br>
             <input name="usocuenta" value="Iniciar sesion" type="submit">
             <input name="alta" value="Registrame" type="submit" >  
           
             <br><br>
             <a href="Ayuda.jsp"> Ayuda <a/>
           
        </form>
    </body>
</html>
