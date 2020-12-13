
package baseDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andres Mendoza Contreras
 */
public class AdminBD {
    
    
    private String URL;
	private String usuario;
	private String contra;
	private String esquema;
	private String host;
	private String puerto;
	private String baseDatos;

	public AdminBD() {
		esquema="jdbc:postgresql:";
		host="127.0.0.1";
		puerto="5432";
		baseDatos="Repositorio";
		URL=esquema+"//"+host+":"+puerto+"/"+baseDatos;
		usuario="postgres";
		contra="170496";
        
    }
    public Connection DameConexion() {
		Connection con=null;
		try {
		    con=DriverManager.getConnection(URL,usuario, contra);
		}catch(SQLException esql) {
			esql.printStackTrace();
		}
		return con;
	}

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }
            
    
    
    
    
}
