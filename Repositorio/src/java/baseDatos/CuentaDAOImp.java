
package baseDatos;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.List;
 

 import modelo.Cuenta;

public class CuentaDAOImp implements CuentaDAO {
	private AdminBD admin;
	private Connection conexion;
	private boolean conexionTransferida;
	
	public CuentaDAOImp() {
		admin= new AdminBD();
	}
	public CuentaDAOImp(Connection conexion) {
		this.conexion=conexion;
		conexionTransferida=true;
	}

    @Override
    public List<Cuenta> Consultar() {
		// TODO Auto-generated method stub
		return null;
	}
	
    public Cuenta consultar(Cuenta cuenta) {
		Cuenta cuentaHallada=null;
		PreparedStatement ps=null;
		String sql=null;
		ResultSet tabla=null;
		int id=0;
	  
				
		conexion= admin.DameConexion();	
                /*consulta a la base de datos*/
		sql="SELECT id_estudiante  FROM cuentas"+
		       " WHERE  id_estudiante=? AND contrasena=?;";
                
		try {
			ps= conexion.prepareStatement(sql);
			ps.setInt(1, cuenta.getId());
			ps.setString(2, cuenta.getContrasena());
			tabla=ps.executeQuery();
			if(tabla.next()) {
				id=tabla.getInt("id_estudiante");
				cuentaHallada= new Cuenta(id,cuenta.getContrasena());			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuentaHallada;
    }
    
         /*inserccion */
    @Override
    public int Insertar(Cuenta cuenta) {
		int contador=0;
		PreparedStatement ps=null;
              
		String sql= "INSERT INTO cuentas( contrasena, id_estudiante) VALUES(?,?);";
             
                
		if(conexionTransferida==false)
				conexion=admin.DameConexion();
		
		try {
			ps=conexion.prepareStatement(sql);
			ps.setString(1,cuenta.getContrasena());
			ps.setInt(2,cuenta.getId());
			
			contador=ps.executeUpdate();	
                        
                      	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				if(conexionTransferida==false)				
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contador;
    }
    
    @Override
    public int Actualiza(Cuenta cuenta) {
		int contador=0;
		PreparedStatement ps=null;
		
		String sql= "UPDATE cuentas SET contrasena=? "+
		             " WHERE id_estudiante=? AND contrasena=?;";
		conexion= admin.DameConexion();		
                
                
		try {
			ps=conexion.prepareStatement(sql);
			
			ps.setInt(1,cuenta.getId());
			ps.setString(2, cuenta.getContrasena());
			contador=ps.executeUpdate();
			ps.close();
                        
                     
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contador;
	}

    @Override
    public int Borrar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return 0;
    }
	
}
