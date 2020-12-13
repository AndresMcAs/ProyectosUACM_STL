<%-- 
    Document   : Ayuda
    Created on : 8/12/2020, 04:52:41 PM
    Author     : HP
--%>


<%@page  language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ayuda</title>
    </head>
    <body>
        
        <% String mensajeIngreso="Ayuda";
           String mensaje=(String)session.getAttribute("mensaje");
           if(mensaje!=null) mensajeIngreso=mensaje;
        
        %>
        
        
        <h1><%=mensajeIngreso%></h1>
        <form method="post" action="/Repositorio/control">    
            
            <p> .....Bien Venido A Tu Respositorio ProyectosUACM.....</p> 
           <img src="https://th.bing.com/th/id/OIP.54wsV_a3IYb7h8_0Ik4uiwHaE8?w=272&h=180&c=7&o=5&pid=1.7" 
                 width="500" heigth="400"
                 align="right" alt="No se pudo mostrar la imagen">
             <br> <br>
             
             <p> Para poder utilizar la plataforma debes registrarte opriminedo el boton (Registrame)</p> 
             <p> Una vez registrado podras iniciar sesion oprimiedno el boton (iniciar sesion)</p> 
             <p> Dentro de la plataforma podras realizar un serie de actividades como: </p> 
             <p> 1.- Registar tu proyecto </p> 
             <p> 2.- Ver los proyectos compartidos pos los demas compañeros de las distintas carreras  </p> 
             <p> 3.- Registar tu proyecto o idea que tengas en mente para poder realizarlo </p> 
             <p> 4.- Contactar al o los autores del proyecto </p> 
               <br><br>
             <a href="index.jsp"> Pagina Principal <a/>
           
        </form>
    </body>
</html>
