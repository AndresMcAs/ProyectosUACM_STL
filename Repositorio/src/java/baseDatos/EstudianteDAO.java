
package baseDatos;
import java.util.List;
import modelo.Estudiante;

/**
 *
 * @Andres Mendoza Contreras 
 */
public interface EstudianteDAO {
    public List<Estudiante>Consultar();
    public int Insertar(Estudiante estudiante);
    public int Actualiza(Estudiante estudiante);
    public int Borrar(Estudiante estudiante);
    
    
}
