
package control;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Repositorio;
/**
 * Servlet implementation class Control
 */
@WebServlet("/control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private  Repositorio rep;
	
    public Control() {
       super();
       rep= new Repositorio();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String transaccion=null;
        RequestDispatcher despachador=null; 
	HttpSession sesion=request.getSession();
	sesion.setAttribute("rep", rep);
                
		
		
		// se da de alta o se registra a un nuevo estudiante
        transaccion=request.getParameter("alta");
		 if (transaccion!= null ) {
			 despachador=request.getRequestDispatcher("Formulario.jsp");
			 despachador.forward(request, response);
		 }
		 // el usuario hace uso de la cuenta una vez creada
	transaccion=request.getParameter("usocuenta");		
		 if (transaccion!= null ) {
			 despachador=request.getRequestDispatcher("Ingreso.jsp");
			 despachador.forward(request, response);
		 }
                 
    }
}