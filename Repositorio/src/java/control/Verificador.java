
package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseDatos.CuentaDAOImp;
import modelo.Repositorio;
import modelo.Cuenta;
import modelo.Estudiante;
/**
 *
 * @Servlet implementation class Verificador
 */
@WebServlet("/verificador")
public class Verificador extends HttpServlet {
    private static final long serialVersionUID=1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
   public Verificador(){
       super();
   }
   
   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException,IOException{
   
   Estudiante est=null;
   Cuenta cuenta=null;
   Cuenta  cuentaHallada=null;
   CuentaDAOImp cuentaDAO=null;
   int id=0;
   
   RequestDispatcher despacha;
   HttpSession sesion= request.getSession();
  
   String mensaje=null;
   
   id=Integer.parseInt(request.getParameter("id"));
   String contrasena=request.getParameter("contra");
   String ncuenta=request.getParameter("user");
   cuenta=new Cuenta(id,contrasena);
   
   cuentaDAO=new CuentaDAOImp();
   cuentaHallada=cuentaDAO.consultar(cuenta);
    
   if(cuentaHallada==null){
       mensaje="Datos invalidos, ingreselo de nuevo";
       sesion.setAttribute("mensaje", mensaje);
       despacha=request.getRequestDispatcher("Ingreso.jsp");
       despacha.forward(request, response);
   
   }else{
   
  
   sesion.setAttribute("cuenta", cuentaHallada);
   // falta definir las operaciones que puede realizar el usuario 
   despacha=request.getRequestDispatcher("Operaciones.jsp");
   despacha.forward(request, response);
  
   }
   
   }
   
}
