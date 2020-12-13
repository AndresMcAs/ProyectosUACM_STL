<%-- 
    Document   : Formulario, para registrar a un nuevo estudiante
    Created on : 10/11/2020, 03:58:24 PM
    Author     : Andres Mendoza
--%>

<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
    <head>
        <meta  charset=UTF-8">
        <title>Alta Estudiante</title>
    </head>
    <body>
        <% String mensaje="Registro...";
           String m=(String)session.getAttribute("mensajeAlta");
           if(m!=null) mensaje=m;
            %>
        <h1> <%=mensaje%></h1>
        
        <form  method="post" action="/Repositorio/altaEstudiante">
           
            Nombre:    <input type="text" name="nombre"/><br><br>
            Apellido:  <input type="text" name="apellido"/><br><br>
            Carrera:   <input type="text" name="carrera"/><br><br>
            Matricula: <input type="text" name="matricula"/><br><br>
            Contraseña:<input type="password" name="contrasena"/><br><br>
            Confirma contraseña: <input type="password" name="pass"/><br>
            
            <br><br>
            <input type="submit" value="Registrar"/>    
        </form>
        <br>
        <a href="index.jsp"> Menu principal <a/>
        
    </body>
</html>
