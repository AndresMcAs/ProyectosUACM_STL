
package control;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import modelo.Repositorio;
import modelo.Estudiante;
import modelo.Cuenta;
import baseDatos.EstudianteDAOImp;


/**
 * Servlet implementation class Control
 */
@WebServlet("/altaEstudiante")
public class AltaEstudiante extends HttpServlet {
    private static final long serialVersionUID=1L;
    
    /**
     *
     */
    public AltaEstudiante() {
     super();
     
    }
  /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(request, response);
	}

	/**
     * @param request
     * @param response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      Repositorio rep=null;
		Estudiante estudiante=null;
		Cuenta cuenta= null;
		EstudianteDAOImp estudianteDAO=null;
		
		
		RequestDispatcher despachador;
		HttpSession sesion= request.getSession();
		rep=(Repositorio)sesion.getAttribute("rep");
		
        
		String mensajeAlta=null;
		
       
       
       String nombre = request.getParameter("nombre").trim();
       String apellido = request.getParameter("apellido").trim();
       String carrera = request.getParameter("carrera").trim();
       String matricula = request.getParameter("matricula").trim();
       String contrasena = request.getParameter("contrasena").trim();
       String confirmacion = request.getParameter("pass").trim();
       System.out.println("contraseña:"+contrasena);
       // si algun valor esta vacio
       if (nombre.isEmpty()||apellido.isEmpty()||carrera.isEmpty()
              ||matricula.isEmpty()||contrasena.isEmpty()||confirmacion.isEmpty() 
              ||!contrasena.equals(confirmacion)) {
           mensajeAlta="Datos vacios o las contraseñas no concuerdan, ingreselos otra vez";
           sesion.setAttribute("mensajeAlta", mensajeAlta);
           despachador=request.getRequestDispatcher("Formulario.jsp");
           despachador.forward(request, response);
           System.out.println("Regresa al Registro por error");
           
       }
       else{
       // se realiza el registro de la cuenta y el estudiante
       
       cuenta=new Cuenta();
       cuenta.setContrasena(contrasena);
       estudiante=new Estudiante(nombre,cuenta);
       estudiante.setApellido(apellido);
       estudiante.setCarrera(carrera);
       estudiante.setMatricula(matricula);
       estudianteDAO=new EstudianteDAOImp();
       estudianteDAO.InsertaTransaccion(estudiante, cuenta);
       
       System.out.println("regresa a formulario exitosamente" );
       mensajeAlta="REGISTRO EXITOSO: su cuenta es:"+cuenta.getId();
       sesion.setAttribute("mensajeAlta", mensajeAlta);
       sesion.setAttribute("estudiante",estudiante);
       sesion.setAttribute("cuenta", cuenta);
       despachador=request.getRequestDispatcher("Formulario.jsp"); // o regresar al index.jsp
       despachador.forward(request,response);
       
       }
    
    }

   

}
