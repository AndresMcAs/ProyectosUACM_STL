 package baseDatos; 
 
import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.List;
 import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 import modelo.Estudiante;
 import modelo.Cuenta;
 

public class EstudianteDAOImp implements EstudianteDAO {
    
    private AdminBD admin;
    private Connection conexion;
    private boolean conexionTransferida;

    
 
    public EstudianteDAOImp() {
        admin=new AdminBD();
        conexion=null;
    }
    public EstudianteDAOImp( Connection conexion)  {
        this.conexion=conexion;
        conexionTransferida=true;
    }
  
    @Override
    public List<Estudiante> Consultar(){
      PreparedStatement ps=null;
		ResultSet rs=null;
		Estudiante estudiante= null;
		List<Estudiante> lista= new ArrayList<>();
		
 		String sql="SELECT id_estudiante,nombre,apellido,carrera,matricula  FROM Estudiantes;";


		try {
			conexion=admin.DameConexion();
			ps=conexion.prepareStatement(sql);
			rs=ps.executeQuery();

			
			while(rs.next()) {
				estudiante= new Estudiante();
				estudiante.setId( rs.getInt("id_estudiante"));
				estudiante.setNombre(rs.getString("nombre"));
				estudiante.setApellido(rs.getString("apellido"));
				estudiante.setMatricula(rs.getString("matricula"));
				estudiante.setCarrera(rs.getString("carrera"));
				lista.add(estudiante);
                                
                              
			}
			rs.close();
			ps.close();
			conexion.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
    }
    
    @Override
    public int Insertar(Estudiante estudiante) {
     int cuenta =0;
     PreparedStatement ps= null;
     String sql="INSERT INTO Estudiantes(nombre,apellido,carrera,matricula)VALUES(?,?,?,?);";
     
    
      if(conexionTransferida==false)
			conexion=admin.DameConexion();
		
		try {
			ps=conexion.prepareStatement(sql);
			ps.setString(1, estudiante.getNombre());
			ps.setString(2, estudiante.getApellido());
			ps.setString(3, estudiante.getCarrera());
			ps.setString(4, estudiante.getMatricula());
			cuenta=ps.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}

        try {
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
		return cuenta;
     
       }
    public void InsertaTransaccion(Estudiante estudiante, Cuenta cuenta){
        
       int contador=0;
		int llaveReferencial=0;
		PreparedStatement ps=null;
		EstudianteDAOImp estudianteDAO; 
		CuentaDAOImp cuentaDAO; 
                
                
           try{ 
               conexion=admin.DameConexion();
               conexion.setAutoCommit(false);
               estudianteDAO=new EstudianteDAOImp(conexion);
               contador=estudianteDAO.Insertar(estudiante);
               System.out.println("contador:"+contador);
               
               String sql;
                sql = "SELECT currval ('Estudiantes_id_seq');";
               ps=conexion.prepareStatement(sql);
           try (ResultSet rs = ps.executeQuery(sql)) {
               if (rs.next()) llaveReferencial=rs.getInt(1);
               
               cuenta.setId(llaveReferencial);
               cuentaDAO=new CuentaDAOImp(conexion);
               contador+=cuentaDAO.Insertar(cuenta);
               if (contador==2)
                   conexion.commit();
               else
                   conexion.rollback();
               ps.close();
           }
                
	} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {			
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

    @Override
    public int Actualiza(Estudiante estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Borrar(Estudiante estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    public static void main(String args[]){
     Estudiante estudiante= new Estudiante ();
     estudiante.setNombre("Eduardo");
     estudiante.setApellido("Perez");
     estudiante.setMatricula("16-003-0636");
     estudiante.setCarrera("ingenieria");
     Cuenta cuenta= new Cuenta(3,"1235");
     EstudianteDAOImp estudianteDAO=new EstudianteDAOImp();
     estudianteDAO.InsertaTransaccion(estudiante, cuenta);
     
     List<Estudiante> lista=null;
     lista=estudianteDAO.Consultar();
     for(int i=0;i<lista.size();i++){
     System.out.println(""+lista.get(i));
     }
    
    }
    */
}
